package com.mastercard.pts.integrated.issuing.utils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.mastercard.testing.utils.encryption.EncryptUtils;

public class DatabaseUtils {

	public static String PRVSN_RQST_PR = "PR.PRVSN_RQST_ID, PR.PRVSN_TYPE_CD, PR.PRVSN_STAT_CD,Pr.WLT_PRVDR_ID, PR.WLT_PRVDR_RQST_ID, PR.AUTHTCN_TOKEN_ID, PR.PKG_DLVR_ID, PR.IDV_DECSN_TXT, PR.IDV_DECSN_MADE_BY_CD, PR.FPAN_SRC_CD, PR.WLT_PRVDR_RCMND_DECSN_TXT, PR.API_RQST_ID, PR.SRC_APPL_NAM, PR.EVENT_RQSTR_CD ";
	public static String PAN_DVC_MAP_PM = " pm.map_id, PM.MAP_STAT_CD, PM.MAP_STAT_DT, PM.SEC_ELMT_ID, PM.WLT_PRVDR_ID, PM.DVC_PAN_UNQ_ID, PM.CLNT_APPL_ID ";
	public static String PAN_DVC_MAP_ACTVTY_PR = " PR.MAP_ID, PR.ACTVTY_TYPE_NAM, PR.ACTVTY_NAM, PR.CRTE_TS, PR.RSLT_TXT, PR.MSG_TXT ";
	public static String ACCT_RNG_MDES_PARM_AC = " AC.RNG_STRT_NUM, AC.ACPT_BRND_ID, AC.CARD_LEN_NUM, "
			+ " AC.PRVSN_PATH_CD, AC.ACTV_CD_MTHD_CD, AC.GRP_SIGNIN_NUM, "
			+ " AC.EXPIRY_DT_PRSNT_ON_CARD_SW, AC.CVC2_PRSNT_ON_CARD_SW ";
	@Autowired
	protected Environment env;
	private JDBCTemplateImpl dbInstance = null;

	@SuppressWarnings("unused")
	private DatabaseUtils() {
	}

	public DatabaseUtils(JDBCTemplateImpl db) {
		dbInstance = db;
		try {
			dbInstance.getDataSource().getConnection().setAutoCommit(true);
		} catch (SQLException e) {

		}

	}

	public List<Map<String, Object>> runQuery(String query, boolean islog) {
		Utils.logged(Utils.addLine() + "Query : " + query, true);
		List<Map<String, Object>> results = dbInstance.queryATable(query);

		Utils.displayMap(results, islog);

		return results;
	}

	public int runUpdateQuery(String query, boolean isDisplay) {
		Utils.logged("Executing Update Query : " + query, true);
		int results = dbInstance.jdbcTemplate.update(query);

		Utils.logged("Updated " + results + " Record", isDisplay);
		int results1 = dbInstance.jdbcTemplate.update("commit");
		Utils.logged("Commit " + results1, false);
		return results;
	}

	/**
	 * For PRVNS_RQST, PAN_DVC_MAP and PAN_DVC_ACTIVITY table if we have map_id
	 * we can fetch complete row for particular token.
	 * 
	 * We created this function so that if you have any field from which u can
	 * fetch MAP_ID which belong to any table mentioned earlier.
	 * 
	 * @param tableName
	 *            pass table in which you know MAP_ID is there
	 * @param tableField
	 *            pass COL_NAME like (DVC_PANUNQ_ID,SEC_ELMT_ID)
	 * @param FieldValue
	 *            value of that coloumn
	 * @return will return MAP_ID
	 */
	public String fetchMapId(String tableName, String tableField,
			String FieldValue) {
		return runQuery(
				"select MAP_ID from MDES_OWNER." + tableName + " p where p."
						+ tableField + "='" + FieldValue + "'", true).get(0)
				.get("MAP_ID").toString();

	}

	public boolean VerifyNetworkMessageSetup(String RNG_STRT_NUM,
			List<String> NTWRK_MSG_IDList) {

		boolean isACCT_RNG_NTWRK_MSG = true;
		for (String NTWRK_MSG_ID : NTWRK_MSG_IDList) {
			isACCT_RNG_NTWRK_MSG = runQuery(
					"select * from MDES_OWNER.ACCT_RNG_NTWRK_MSG NM where NM.RNG_STRT_NUM = '"
							+ RNG_STRT_NUM
							+ "' and NM.TOKEN_SERV_CD = '098' and NTWRK_MSG_ID="
							+ NTWRK_MSG_ID, true).size() == 1;

		}

		return isACCT_RNG_NTWRK_MSG;
	}

	/**
	 * This function will verify for NTWRK_MSG_ID against 100200 or 0620
	 * 
	 * NOTE : this funciton hard coded with RNG_STRT_NUM,TOKEN_SERV_CD value if
	 * we want to pass these also Generic funciton has written named
	 * 
	 * @param RNG_STRT_NUM
	 *            pass range
	 * @param NTWRK_MSG_IDList
	 *            pass list of ID 11,21,31,41, in case of 100200 or 11,21,32,42
	 *            in case of 0620
	 * @return true if passed, false if fail
	 */
	public boolean checkNetworkMessageSetup(String RNG_STRT_NUM,
			List<String> NTWRK_MSG_IDList) {

		if (!VerifyNetworkMessageSetup(RNG_STRT_NUM, NTWRK_MSG_IDList)) {

			int update = runUpdateQuery(
					"delete FROM MDES_OWNER.ACCT_RNG_NTWRK_MSG where RNG_STRT_NUM='"
							+ RNG_STRT_NUM + "' AND TOKEN_SERV_CD = '098'",
					true);
			System.out.println("Update " + update);

			for (String NTWRK_MSG_ID : NTWRK_MSG_IDList) {
				runUpdateQuery(
						"INSERT INTO MDES_OWNER.ACCT_RNG_NTWRK_MSG (NTWRK_MSG_ID,PARTN_NUM,RNG_STRT_NUM,TOKEN_SERV_CD) VALUES ('"
								+ NTWRK_MSG_ID
								+ "',0,'"
								+ RNG_STRT_NUM
								+ "','098')", true);
			}

		}
		return true;

	}

	/**
	 * will verify ACCT_RNG_MDES_PARM table against for following Green path,
	 * with expiry,with CVC and rule set id is not null
	 * 
	 * NOTE : if we want to pass the value of
	 * PRVSN_PATH_CD,EXPIRY_DT_PRSNT_ON_CARD_SW,CVC2_PRSNT_ON_CARD_SW,
	 * IDV_RULE_SET_ID generic function has written
	 * 
	 * @param RNG_STRT_NUM
	 * @return
	 */
	public boolean checkACCT_RNG_MDES_PARM(String RNG_STRT_NUM) {
		// TODO

		String query = "select AP.PARTN_NUM, AP.RNG_STRT_NUM, AP.PRVSN_PATH_CD,AP.EXPIRY_DT_PRSNT_ON_CARD_SW, AP.CVC2_PRSNT_ON_CARD_SW, AP.IDV_RULE_SET_ID, AP.CARD_LEN_NUM "
				+ "from MDES_OWNER.ACCT_RNG_MDES_PARM ap where "
				+ "AP.RNG_STRT_NUM = '"
				+ RNG_STRT_NUM
				+ "' and "
				+ "AP.PRVSN_PATH_CD ='G' and "
				+ "AP.EXPIRY_DT_PRSNT_ON_CARD_SW ='Y' "
				+ "and AP.CVC2_PRSNT_ON_CARD_SW ='Y'"
				+ " and AP.IDV_RULE_SET_ID is null ";

		Utils.logged("Verification for " + query);
		List<Map<String, Object>> s = runQuery(query, false);

		if (s.size() == 0) {
			runUpdateQuery(
					"update MDES_OWNER.ACCT_RNG_MDES_PARM AP SET AP.PRVSN_PATH_CD ='G' , AP.IDV_RULE_SET_ID =null, AP.EXPIRY_DT_PRSNT_ON_CARD_SW ='Y' , AP.CVC2_PRSNT_ON_CARD_SW ='Y' where AP.RNG_STRT_NUM = '"
							+ RNG_STRT_NUM + "'", true);
			return true;
		} else

			return true;
	}

	/**
	 * This is generic function we can pass RNG_STRT_NUM and NTWRK_MSG_IDList
	 * and it will be useful in both 100200 setup 0620
	 * 
	 * @param RNG_STRT_NUM
	 * @param NTWRK_MSG_IDList
	 * @return
	 */
	public boolean checkSetupForACCT_RNG_NTWRK_MSG(String RNG_STRT_NUM,
			List<String> NTWRK_MSG_IDList, String PARTN_NUM,
			String TOKEN_SERV_CD) {

		/**
		 * First we will check againes all message id that record is present or
		 * not
		 */
		boolean isACCT_RNG_NTWRK_MSG = true;
		for (String NTWRK_MSG_ID : NTWRK_MSG_IDList) {
			isACCT_RNG_NTWRK_MSG = runQuery(
					"select * from MDES_OWNER.ACCT_RNG_NTWRK_MSG NM where NM.RNG_STRT_NUM = '"
							+ RNG_STRT_NUM + "' and NM.TOKEN_SERV_CD = '"
							+ TOKEN_SERV_CD + "' and NTWRK_MSG_ID="
							+ NTWRK_MSG_ID, true).size() == 1;
			if (isACCT_RNG_NTWRK_MSG == false)
				break;
		}

		/**
		 * if no record found we will delete all records for range and insert it
		 * again.
		 */
		if (!isACCT_RNG_NTWRK_MSG) {
			Utils.logged("did not find any record in ACCT_RNG_NTWRK_MSG");

			int update = runUpdateQuery(
					"delete FROM MDES_OWNER.ACCT_RNG_NTWRK_MSG where RNG_STRT_NUM='"
							+ RNG_STRT_NUM + "' AND TOKEN_SERV_CD = '"
							+ TOKEN_SERV_CD + "'", true);
			System.out.println("Deleting record for  range =" + RNG_STRT_NUM
					+ " and after query " + update + " row get updated");
			int updateCount = 0;
			for (String NTWRK_MSG_ID : NTWRK_MSG_IDList) {
				updateCount += runUpdateQuery(
						"INSERT INTO MDES_OWNER.ACCT_RNG_NTWRK_MSG (NTWRK_MSG_ID,PARTN_NUM,RNG_STRT_NUM,TOKEN_SERV_CD) VALUES ('"
								+ NTWRK_MSG_ID
								+ "',"
								+ PARTN_NUM
								+ ",'"
								+ RNG_STRT_NUM + "','" + TOKEN_SERV_CD + "')",
						true);
			}
			/**
			 * after update count should be four
			 */
			if (updateCount != 4) {
				AssertTypes.assertTrue(
						"did no insert all query for ACCT_RNG_NTWRK_MSG table",
						false);
			}

		}
		return true;
	}

	// /**
	// * This is generic function we can pass RNG_STRT_NUM, CARD_LEN_NUM,
	// * PRVSN_PATH_CD, ACTV_CD_MTHD_CD, GRP_SIGNIN_NUM,
	// * EXPIRY_DT_PRSNT_ON_CARD_SW, CVC2_PRSNT_ON_CARD_SW and it will be useful
	// * in both 100200 setup 0620
	// *
	// * @param RNG_STRT_NUM
	// * @param CARD_LEN_NUM
	// * @param PRVSN_PATH_CD
	// * @param ACTV_CD_MTHD_CD
	// * @param GRP_SIGNIN_NUM
	// * @param EXPIRY_DT_PRSNT_ON_CARD_SW
	// * @param CVC2_PRSNT_ON_CARD_SW
	// * @return
	// */
	// public boolean checkACCT_RNG_MDES_PARM1(String RNG_STRT_NUM, String
	// CARD_LEN_NUM, String PRVSN_PATH_CD,
	// String ACTV_CD_MTHD_CD, String GRP_SIGNIN_NUM, String
	// EXPIRY_DT_PRSNT_ON_CARD_SW,
	// String CVC2_PRSNT_ON_CARD_SW) {
	// // 16//ACPT_BRND//RANGE
	// String query = " select AC.RNG_STRT_NUM, AC.ACPT_BRND_ID,
	// AC.CARD_LEN_NUM, "
	// + " AC.PRVSN_PATH_CD, AC.ACTV_CD_MTHD_CD, AC.GRP_SIGNIN_NUM, "
	// + " AC.EXPIRY_DT_PRSNT_ON_CARD_SW, AC.CVC2_PRSNT_ON_CARD_SW "
	// + " from MDES_OWNER.ACCT_RNG_MDES_PARM ac where " + " AC.RNG_STRT_NUM='"
	// + RNG_STRT_NUM + "' and "
	// + " AC.CARD_LEN_NUM='" + CARD_LEN_NUM + "' and " + " AC.PRVSN_PATH_CD='"
	// + PRVSN_PATH_CD + "' and "
	// + " AC.ACTV_CD_MTHD_CD='" + ACTV_CD_MTHD_CD + "' and " + "
	// AC.GRP_SIGNIN_NUM=" + GRP_SIGNIN_NUM
	// + " and " + " AC.EXPIRY_DT_PRSNT_ON_CARD_SW='" +
	// EXPIRY_DT_PRSNT_ON_CARD_SW + "' and "
	// + " AC.CVC2_PRSNT_ON_CARD_SW='" + CVC2_PRSNT_ON_CARD_SW + "' and
	// AC.IDV_RULE_SET_ID is null";
	// // Utils.logged("Verification for " + query);
	// List<Map<String, Object>> s = runQuery(query, false);
	// // Utils.logged(log);
	// if (s.size() == 0) {
	// String updateQuery = "update MDES_OWNER.ACCT_RNG_MDES_PARM AC SET" + "
	// AC.PRVSN_PATH_CD='" + PRVSN_PATH_CD
	// + "' , " + " AC.ACTV_CD_MTHD_CD='" + ACTV_CD_MTHD_CD + "' ,
	// AC.EXPIRY_DT_PRSNT_ON_CARD_SW='"
	// + EXPIRY_DT_PRSNT_ON_CARD_SW + "' , " + " AC.CVC2_PRSNT_ON_CARD_SW='" +
	// CVC2_PRSNT_ON_CARD_SW
	// + "' , IDV_RULE_SET_ID=null " + " where AC.RNG_STRT_NUM='" + RNG_STRT_NUM
	// + "'";
	// // Utils.logged("Updating Query :" + updateQuery);
	// int updated_row = runUpdateQuery(updateQuery, true);
	// if (updated_row != 1) {
	// MDESAssert.assertTrue("Not Able to update " + updateQuery, false);
	//
	// }
	// return true;
	// } else
	//
	// return true;
	// }

	public boolean checkACCT_RNG_MDES_PARM(String RNG_STRT_NUM,
			String CARD_LEN_NUM, String PRVSN_PATH_CD, String ACTV_CD_MTHD_CD,
			String GRP_SIGNIN_NUM, String EXPIRY_DT_PRSNT_ON_CARD_SW,
			String CVC2_PRSNT_ON_CARD_SW) {

		String query = " select " + ACCT_RNG_MDES_PARM_AC
				+ "  from MDES_OWNER.ACCT_RNG_MDES_PARM ac where "
				+ " AC.RNG_STRT_NUM='" + RNG_STRT_NUM + "' and "
				+ " AC.CARD_LEN_NUM='" + CARD_LEN_NUM + "' and "
				+ " AC.PRVSN_PATH_CD='" + PRVSN_PATH_CD + "' and "
				+ " AC.ACTV_CD_MTHD_CD='" + ACTV_CD_MTHD_CD + "' and "
				+ " AC.GRP_SIGNIN_NUM=" + GRP_SIGNIN_NUM + " and "
				+ " AC.EXPIRY_DT_PRSNT_ON_CARD_SW='"
				+ EXPIRY_DT_PRSNT_ON_CARD_SW + "' and "
				+ " AC.CVC2_PRSNT_ON_CARD_SW='" + CVC2_PRSNT_ON_CARD_SW
				+ "'  and AC.IDV_RULE_SET_ID is null";

		Utils.logged("Verification for " + query);
		List<Map<String, Object>> s = runQuery(query, false);
		if (s.size() == 0) {
			String updateQuery = "update MDES_OWNER.ACCT_RNG_MDES_PARM AC SET"
					+ "	AC.PRVSN_PATH_CD='" + PRVSN_PATH_CD + "' , "
					+ "	AC.ACTV_CD_MTHD_CD='" + ACTV_CD_MTHD_CD
					+ "' , AC.EXPIRY_DT_PRSNT_ON_CARD_SW='"
					+ EXPIRY_DT_PRSNT_ON_CARD_SW + "' , "
					+ " AC.CVC2_PRSNT_ON_CARD_SW='" + CVC2_PRSNT_ON_CARD_SW
					+ "'  , IDV_RULE_SET_ID=null where AC.RNG_STRT_NUM='"
					+ RNG_STRT_NUM + "'";

			int updated_row = runUpdateQuery(updateQuery, true);
			if (updated_row != 1) {
				AssertTypes.assertTrue("Not Able to update " + updateQuery,
						false);

			}
			return true;
		} else

			return true;
	}

	/**
	 * once we have map Id we can fetch complete data from three table one is
	 * PAN_DVC_MAP, PAN_DVC_MAP_ACTVTY and PRVSN_RWQST table
	 * 
	 * @param map_id
	 *            pass map id
	 * @return it will return you HashMAP of two first get(0) is for PAN_DVC_MAP
	 *         table second get(1) is for PRVSN_RQST get(2) is for
	 *         PAN_DVC_MAP_ACTVTY table use it accordingly
	 */
	public List<Map<String, Object>> getLatestTableDataFromMapId(String map_id) {

		return getTableDataFromMapId(map_id, 1, 1);

	}

	/**
	 * 
	 * @param map_id
	 * @param PRVSN_RQST_COUNT
	 *            pass -1 f don't want any record
	 * @param PAN_DVC_MAP_ACTVTY_COUNT
	 *            pass -1 f don't want any record
	 * @return
	 */
	public List<Map<String, Object>> getTableDataFromMapId(String map_id,
			int PRVSN_RQST_COUNT, int PAN_DVC_MAP_ACTVTY_COUNT) {

		Map<String, Object> PAN_DVC_MAP = runQuery(
				"select " + PAN_DVC_MAP_PM
						+ " from mdes_owner.PAN_DVC_MAP pm where pm.MAP_ID="
						+ map_id, true).get(0);

		List<Map<String, Object>> PRVSN_RQST = runQuery("select "
				+ PRVSN_RQST_PR
				+ " from MDES_OWNER.PRVSN_RQST pr where pr.MAP_ID=" + map_id
				+ " order by pr.CRTE_DT DESC", true);

		List<Map<String, Object>> PAN_DVC_MAP_ACTVTY = runQuery("select "
				+ PAN_DVC_MAP_ACTVTY_PR
				+ " from MDES_OWNER.PAN_DVC_MAP_ACTVTY PR where PR.MAP_ID="
				+ map_id + " order by PR.CRTE_TS desc", true);

		List<Map<String, Object>> tdata = new ArrayList<>();

		tdata.add(PAN_DVC_MAP);

		if (PRVSN_RQST_COUNT != -1)
			for (int i = 0; i < PRVSN_RQST_COUNT; i++)
				tdata.add(PRVSN_RQST.get(i));

		if (PAN_DVC_MAP_ACTVTY_COUNT != -1)
			for (int i = 0; i < PAN_DVC_MAP_ACTVTY_COUNT; i++)
				tdata.add(PAN_DVC_MAP_ACTVTY.get(i));

		return tdata;

	}

	/**
	 * we use mostly fetch map_Id from PAN_DVC_MAP table so overloaded with hard
	 * code table value name
	 * 
	 * @param tableField
	 *            field/column can be anything which is unique or primary from
	 *            table where we should get single record
	 * @param FieldValue
	 *            value for that particular column
	 * @return
	 */
	public String fetchMapIdFromPAN_DVC_MAPTable(String tableField,
			String FieldValue) {
		return fetchMapId("PAN_DVC_MAP", tableField, FieldValue);

	}

	/**
	 * It will return PKG_DLVR_ID
	 * 
	 * @param MAP_ID
	 * @return
	 */
	public String fetchPKG_DLVR_ID(String MAP_ID) {

		Map<String, Object> s = runQuery(
				"select PKG_DLVR_ID from MDES_OWNER.PRVSN_RQST p where p.MAP_ID="
						+ MAP_ID, true).get(0);

		if (s.get("PKG_DLVR_ID") != null) {
			return s.get("PKG_DLVR_ID").toString();
		}
		return null;
	}

	/**
	 * IT will verify PAN_DVC_MAP_ACTVTY for 100200 and 0630 message
	 * 
	 * @param MAP_ID
	 *            mapid for token
	 * @param colsValue
	 *            pass TA,TE,TC,TV in case of 100200 or pass TA,TE,TC0620,
	 *            TV0620 in case of 0620
	 * @param res_txt
	 *            it is 00 as of now for all four row so taking as single string
	 * @return
	 */
	public boolean checkAfterUnlink(String MAP_ID, List<String> colsValue,
			String res_txt) {

		List<String> failed = new ArrayList<>();
		boolean result = true;
		for (String actv_name : colsValue) {
			Utils.logged("Verification for " + actv_name
					+ " in PAN_DVC_MAP_ACTVTY ");

			String query = "select p.MAP_ID, p.ACTVTY_NAM, p.RSLT_TXT  from mdes_owner.PAN_DVC_MAP_ACTVTY p where p.MAP_ID="
					+ MAP_ID
					+ " and "
					+ " p.RSLT_TXT="
					+ res_txt
					+ " and p.ACTVTY_NAM='" + actv_name + "'";
			List<Map<String, Object>> d = runQuery(query, true);
			if (d.size() == 0) {
				failed.add("Verification for " + actv_name
						+ " in PAN_DVC_MAP_ACTVTY Failed");
				result = false;
			}

		}
		if (!result) {
			for (String string : failed) {
				Utils.logged(string, true);
			}
			AssertTypes.assertTrue(
					"Verification in table PAN_DVC_MAP_ACTVTY after unlink ",
					false);
		}
		return result;

	}

	/**
	 * once we have map Id we can fetch complete data from three table one is
	 * PAN_DVC_MAP, PAN_DVC_MAP_ACTVTY and PRVSN_RWQST table
	 * 
	 * @param map_id
	 *            pass map id
	 * @return it will return you HashMAP of two first get(0) is for PAN_DVC_MAP
	 *         table second get(1) is for PRVSN_RQST get(2) is for
	 *         PAN_DVC_MAP_ACTVTY table use it accordingly
	 */
	public List<Map<String, Object>> getTableDataFromMapId(String map_id,
			List<String> tableNames) {

		List<Map<String, Object>> tdata = new ArrayList<>();
		for (String tableName : tableNames) {

			// RAHUL
			String query = "select * from mdes_owner." + tableName
					+ " PM where PM.MAP_ID=" + map_id;

			if (tableName.equalsIgnoreCase("PRVSN_RQST"))
				query = "select " + PRVSN_RQST_PR + " from mdes_owner."
						+ tableName + " PR where PR.MAP_ID=" + map_id;
			else if (tableName.equalsIgnoreCase("PAN_DVC_MAP"))
				query = "select " + PAN_DVC_MAP_PM + " from mdes_owner."
						+ tableName + " PM where PM.MAP_ID=" + map_id;

			Map<String, Object> PAN_DVC_MAP = runQuery(query, true).get(0);
			tdata.add(PAN_DVC_MAP);

		}

		return tdata;

	}

	public boolean checkAR_CRDHLDR_ACTV_CD_MTHD(String RNG_STRT_NUM,
			String ACTV_CD_MTHD_CD, String ACTV_CD_MTHD_VAL) {

		String query = "select AR.RNG_STRT_NUM, AR.ACTV_CD_MTHD_CD, AR.ACTV_CD_MTHD_VAL  from MDES_OWNER.AR_CRDHLDR_ACTV_CD_MTHD ar "
				+ "where AR.RNG_STRT_NUM =   '"
				+ RNG_STRT_NUM
				+ "' and AR.ACTV_CD_MTHD_CD='"
				+ ACTV_CD_MTHD_CD
				+ "' and AR.ACTV_CD_MTHD_VAL='" + ACTV_CD_MTHD_VAL + "' ";
		Utils.logged("Verification for " + query);
		List<Map<String, Object>> s = runQuery(query, true);
		// Utils.logged(log);
		if (s.size() == 0) {
			String updateQuery = "update MDES_OWNER.AR_CRDHLDR_ACTV_CD_MTHD AC SET"
					+ "	AC.ACTV_CD_MTHD_CD='"
					+ ACTV_CD_MTHD_CD
					+ "' , "
					+ " AC.ACTV_CD_MTHD_VAL='"
					+ ACTV_CD_MTHD_VAL
					+ "' where AC.RNG_STRT_NUM='" + RNG_STRT_NUM + "'";
			// Utils.logged("Updating Query :" + updateQuery);
			int updated_row = runUpdateQuery(updateQuery, true);
			if (updated_row != 1) {
				AssertTypes.assertTrue("Not Able to update " + updateQuery,
						false);

			}
			return true;
		} else

			return true;

	}

	public String getACTV_CD(String map_id) {

		return runQuery(
				"select ACTV_CD from mdes_owner.PAN_DVC_MAP pm where pm.MAP_ID="
						+ map_id, true).get(0).get("ACTV_CD").toString().trim();

	}

	public Map<String, Object> getNOTIFData(String WLT_PRVDR_DVC_ID) {

		return runQuery(
				"select ntf.CLOUD_NOTIF_TYPE_CD, ntf.WLT_PRVDR_DVC_ID, ntf.TRAN_REG_TOKEN_ID, ntf.PAYMT_APPL_INSTNCE_ID,ntf.TRAN_REG_TOKEN_EXPIR_DT,ntf.CLOUD_NOTIF_TOKEN_ID,ntf.HASH_WLT_PRVDR_ACCT_ID "
						+ "from MDES_OWNER.DVC_NOTIF ntf where ntf.WLT_PRVDR_DVC_ID='"
						+ WLT_PRVDR_DVC_ID + "'", true).get(0);

	}

	public static void main(String a[]) throws Exception {
		System.out.println(EncryptUtils.encrypt("MPTSE_ISS_USER"));
		System.out.println(EncryptUtils.encrypt("KmslWW3d"));

	}
	
	public boolean updateSystemCodes(String RNG_STRT_NUM,
			String ACTV_CD_MTHD_CD, String ACTV_CD_MTHD_VAL) {
		
			String updateQuery = "update system_codes set short_name=short_name-11  WHERE TYPE_ID = 'SYS_PARAM' AND code = 'BACK_DAY' AND bank_code = '554466'";
			Utils.logged("Updating Query :" + updateQuery);
			int updatedRow = runUpdateQuery(updateQuery, true);
			if (updatedRow != 1) {
				AssertTypes.assertTrue("Not Able to update " + updateQuery,
						false);
				return false;
			}
			
			return true;		
	}

}
