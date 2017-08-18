package com.mastercard.pts.integrated.issuing.utils;

public class SQLQueriesConstants {

	public static final String  FETCH_ARN_QUERY = "SELECT * FROM TRANSACTION_HIST t WHERE issuer_bank_code = 121212 AND Function_code = 205 AND NVL(t.reversal_flag,'O') = 'O' AND (NVL(authorization_status,0) != 0 OR card_status =2) AND ORIGINE_CODE IN ('1', '2') AND NOT EXISTS (SELECT microfilm_ref_number FROM retrieval_request r WHERE r.microfilm_ref_number = t.microfilm_ref_number AND r.sequence_number = t.sequence_number AND request_indicator = 2) AND NOT EXISTS (SELECT microfilm_ref_number FROM chargeback_history r WHERE r.microfilm_ref_number = t.microfilm_ref_number AND r.sequence_number = t.sequence_number AND r.bank_code = t.issuer_bank_code AND status = 'C' UNION SELECT microfilm_ref_number FROM chargeback_movement r WHERE r.microfilm_ref_number = t.microfilm_ref_number AND r.sequence_number = t.sequence_number AND r.bank_code = t.issuer_bank_code AND status = 'C' ) ORDER BY Microfilm_Ref_Number, sequence_number";
	private SQLQueriesConstants() {}
}
