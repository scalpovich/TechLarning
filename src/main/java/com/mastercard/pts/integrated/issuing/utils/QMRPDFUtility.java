package com.mastercard.pts.integrated.issuing.utils;

import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.itextpdf.text.pdf.PdfReader;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.BatchProcessingPage;

@SuppressWarnings({ "rawtypes", "unchecked" })
@Component
public class QMRPDFUtility {

	@Autowired
	BatchProcessingPage batchProcesingPage;

	@Autowired
	public Environment env;

	@Autowired
	public BatchProcessingPage batchpage;
	@Autowired
	ZipUnzipUtils zipunziputil;

	@Autowired
	FileUtils fileutils;

	public static Set<String> set = new LinkedHashSet<>();

	static String reportIdVal = null;

	public PdfReader getPDFReaderObject() throws IOException {

		String password = zipunziputil.getReportPassword();
		String pdfFilePath = fileutils.readFile().toString();

		PdfReader reader = new PdfReader(pdfFilePath, password.getBytes());

		return reader;

	}

	public ArrayList<String> pdfUtility(String[] split) {

		Pattern pattern1 = Pattern
				.compile("([a-zA-Z0-9]+[\\s\\t]*[:]{1}[\\s\\t]*[a-zA-Z0-9]+)");
		Pattern pattern2 = Pattern
				.compile("([A-Za-z0-9]+[\\s]*[:]{1}[\\s]*[A-Za-z0-9]+)");
		Pattern pattern3 = Pattern.compile("([A-H J-Z][.])(.)*");
		Pattern pattern4 = Pattern.compile("([0-9]+[a-zA-Z]*[.][\\sA-Za-z]+)");
		Pattern pattern5 = Pattern.compile("([I]+[.])");

		Pattern pattern7 = Pattern
				.compile("((\\W*(Breakdown)\\W*)([\\s]*[a-zA-Z]+)+)");
		Pattern pattern8 = Pattern
				.compile("(^([a-z]+[.][\\s]*)([A-Za-z][\\s]*)+)");
		Pattern pattern9 = Pattern.compile("([I]+[.][A-Za-z\\s-]*[^0-9:]*)");

		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> list_second = new ArrayList<String>();

		LinkedHashMap<String, ArrayList<String>> innerMap = new LinkedHashMap<String, ArrayList<String>>();
		LinkedHashMap<String, ArrayList<String>> innerMapForHeaders = new LinkedHashMap<String, ArrayList<String>>();
		LinkedHashMap<String, ArrayList<Map.Entry<String, ArrayList<String>>>> innerMapForMapping = new LinkedHashMap<String, ArrayList<Map.Entry<String, ArrayList<String>>>>();

		for (int i = 0; i < split.length; i++) {

			Matcher m1 = pattern1.matcher(split[i]);
			Matcher m2 = pattern2.matcher(split[i]);

			while (m1.find()) {
				try {

					set.add(m1.group().trim());

				} catch (Exception r) {
					continue;
				}
			}

			while (m2.find()) {

				try {

					set.add(m2.group().trim());

				} catch (Exception r) {

					continue;
				}
			}
		}

		System.out.println(set);

		for (int i = 0; i < split.length; i++) {
			Matcher m9 = pattern9.matcher(split[i]);
			if (m9.find()) {
				list.add(m9.group().trim());
			}
		}
		System.out.println(list);

		for (int i = 0; i < split.length; i++) {

			Matcher m9 = pattern9.matcher(split[i]);
			if (m9.find()) {
				for (int k = i + 1; k < split.length; k++) {
					Matcher m3 = pattern3.matcher(split[k]);

					if (m3.find() && !pattern4.equals(split[k])
							&& !pattern5.equals(split[k])
							&& !list_second.contains(split[k])) {
						list_second.add(split[k].trim());

					}
				}

			}
		}
		System.out.println(list_second);
		ArrayList<String> list_third = new ArrayList<String>();

		int q = 0;
		for (int i = 0; i < split.length; i++) {

			if (list_second.get(q).equals(split[i]) && q < list_second.size()) {

				for (int j = i + 1; j < split.length
						&& q + 1 < list_second.size(); j++) {

					Matcher m4 = pattern4.matcher(split[j]);

					if (m4.find()) {
						list_third.add(split[j].trim());
					}
					if (list_second.get(q + 1).equals(split[j])
							&& q < list.size() - 1) {
						q++;
						break;
					}
				}

			}
		}

		System.out.println(list_third);
		int t = 0;
		int count = 0;

		for (int i = 0; i < list_second.size(); i++) {
			ArrayList<String> list_fourth = new ArrayList<String>();
			try {
				if (list_third.get(t).substring(0, 2).equals("1.")
						&& count == 0) {

					list_fourth.add(list_third.get(t));
					t++;
					count++;
				}

				do {

					list_fourth.add(list_third.get(t));
					t++;

				} while (list_third.get(t).substring(0, 2).equals("1.") != true);
				count = 0;
			} catch (Exception e) {
				continue;
			}
			innerMap.put(list_second.get(i), list_fourth);
		}

		System.out.println(innerMap);

		int r = 0;
		int counter = 0;

		for (int i = 0; i < list.size(); i++) {
			ArrayList<String> list_fourth = new ArrayList<String>();
			try {

				if (list_second.get(r).substring(0, 2).equals("A.")
						&& counter == 0) {

					list_fourth.add(list_second.get(r));
					r++;
					counter++;
				}

				do {

					list_fourth.add(list_second.get(r));
					r++;

				} while (list_second.get(r).substring(0, 2).equals("A.") != true);
				counter = 0;
				innerMapForHeaders.put(list.get(i), list_fourth);
			}

			catch (Exception e) {
				innerMapForHeaders.put(list.get(i), list_fourth);
				continue;
			}

		}

		System.out.println(innerMapForHeaders);

		Set entrys = innerMap.entrySet();

		Iterator iter = entrys.iterator();
		counter = 0;
		int p = 0;
		Map.Entry me = null;
		count = 0;
		while (iter.hasNext()) {
			ArrayList<Map.Entry<String, ArrayList<String>>> list_fourth = new ArrayList<Map.Entry<String, ArrayList<String>>>();
			try {
				if (count == 0) {
					me = (Map.Entry) iter.next();
					count++;
				}
				if (((String) me.getKey()).substring(0, 2).equals("A.")
						&& counter == 0) {

					list_fourth.add(me);

					counter++;
				}

				do {

					me = (Map.Entry) iter.next();
					if (!((String) me.getKey()).substring(0, 2).equals("A.")) {
						list_fourth.add(me);

					} else {
						break;
					}

				} while (!((String) me.getKey()).substring(0, 2).equals("A."));

				counter = 0;
				innerMapForMapping.put(list.get(p), list_fourth);

				p++;
			} catch (Exception e) {

				innerMapForMapping.put(list.get(p), list_fourth);
				p++;

			}

		}

		System.out.println(innerMapForMapping);

		// For data having no column header part 1.

		ArrayList<String> differentallyFormatted = new ArrayList<String>();

		for (int i = 0; i + 1 < split.length; i++) {

			if (pattern5.matcher(split[i]).find()
					&& !pattern3.matcher(split[i + 1]).find()
					&& pattern4.matcher(split[i + 1]).find()) {

				for (int j = i + 1; j < split.length
						&& !pattern5.matcher(split[j]).find()
						&& !pattern3.matcher(split[j]).find(); j++) {
					if (pattern4.matcher(split[j]).find())
						differentallyFormatted.add(split[j].trim());
				}
			}
		}

		System.out.println(differentallyFormatted);

		// For data having no column header part 2.

		LinkedHashMap<String, ArrayList<String>> differentlyFormattedMap = new LinkedHashMap<String, ArrayList<String>>();

		ArrayList<String> list_fourth = new ArrayList<String>();

		int m = 0;

		for (int i = 0; i + 1 < split.length; i++) {

			if (pattern5.matcher(split[i]).find()) {

				ArrayList<String> differentallyFormatted_2 = new ArrayList<String>();

				try {
					for (int j = i + 1; j < split.length; j++) {
						if (!pattern3.matcher(split[j]).find()
								&& pattern7.matcher(split[j]).find()) {

							if (m == 0) {

								m = j;
							}

							for (int k = j + 1; k < split.length
									&& !pattern3.matcher(split[k]).find()
									&& !pattern5.matcher(split[j]).find(); k++) {
								Matcher m8 = pattern8.matcher(split[k]);

								if (m8.find()) {
									differentallyFormatted_2.add(m8.group()
											.trim());
								}
							}

							list_fourth.add(split[m].trim());

							list_fourth.addAll(differentallyFormatted_2);

							differentlyFormattedMap.put(split[m].trim(),
									differentallyFormatted_2);
						}

					}

				} catch (Exception e) {
					continue;
				}
			}
			m = 0;
		}

		System.out.println(differentlyFormattedMap);

		ArrayList<String> consolidated = new ArrayList<String>();

		consolidated.addAll(list);

		consolidated.addAll(list_second);

		consolidated.addAll(list_third);

		consolidated.addAll(list_fourth);

		return consolidated;

	}

	public String getBin() {

		Iterator itr_bin = set.iterator();

		Pattern binChecker = Pattern.compile("([0-9]+)");

		while (itr_bin.hasNext()) {

			String checkerVal = (String) itr_bin.next();

			if (checkerVal.contains("Bin")) {

				Matcher bin = binChecker.matcher(checkerVal);

				if (bin.find()) {

					System.out.println("Total Bin validated"
							+ bin.group().trim());
					return bin.group().trim();

				}
			}
		}
		return null;
	}

	public String getQuarterId() {

		Iterator quarterId = set.iterator();

		Pattern quarterIdChecker = Pattern.compile("([0-9]+)");

		while (quarterId.hasNext()) {

			String checkerVal = (String) quarterId.next();

			if (checkerVal.contains("QUARTER")) {

				Matcher qid = quarterIdChecker.matcher(checkerVal);

				if (qid.find()) {

					return qid.group().trim();

				}
			}
		}
		return null;
	}

	public String getCurrency() {

		Iterator itr_currency = set.iterator();

		Pattern curChecker = Pattern.compile("([\\s][A-Za-z\\s]+)");

		while (itr_currency.hasNext()) {

			String checkerVal = (String) itr_currency.next();

			if (checkerVal.contains("CURRENCY")) {

				Matcher cur = curChecker.matcher(checkerVal);

				if (cur.find()) {

					return cur.group().trim();
				}
			}
		}

		return null;

	}

	public String getYear() {

		Iterator itr_year = set.iterator();

		Pattern yearChecker = Pattern.compile("([0-9]+)");

		while (itr_year.hasNext()) {

			String checkerVal = (String) itr_year.next();

			if (checkerVal.contains("YEAR")) {

				Matcher year = yearChecker.matcher(checkerVal);

				if (year.find()) {

					return year.group().trim();

				}
			}
		}

		return null;

	}

	public String getInstitutionId() {

		Iterator itr_inst = set.iterator();

		Pattern instChecker = Pattern.compile("([0-9]+)");

		while (itr_inst.hasNext()) {

			String checkerVal = (String) itr_inst.next();

			if (checkerVal.contains("Institution")) {

				Matcher inst = instChecker.matcher(checkerVal);

				if (inst.find()) {

					return inst.group().trim();

				}
			}
		}
		return null;
	}

	public String getInstitutionName(String[] split) {

		Pattern instNameChecker = Pattern.compile("([\\s][A-Za-z\\s]+)");

		for (int i = 0; i < split.length; i++) {

			if (split[i].contains("Institution")) {

				Matcher instName = instNameChecker.matcher(split[i]);

				if (instName.find()) {

					return instName.group().trim();
				}
			}
		}

		return null;
	}

	public String getReportGeneratedBy(String[] split) {

		Pattern reportGeneratedByChecker = Pattern
				.compile("([^:]([a-zA-Z\\s]+[-][a-zA-Z\\s]+))");

		for (int i = 0; i < split.length; i++) {

			if (split[i].contains("Report Generated By")) {

				Matcher repGenName = reportGeneratedByChecker.matcher(split[i]);

				if (repGenName.find()) {

					if (repGenName.group().trim().contains("Page")) {

						System.out.println(repGenName.group().trim()
								.replaceAll("Page", "").trim());
						return repGenName.group().trim().replaceAll("Page", "")
								.trim();

					} else {
						System.out.println(repGenName.group().trim()
								.replaceAll("Page", "").trim());
						return repGenName.group().trim().replaceAll("Page", "")
								.trim();

					}
				}
			}
		}
		return null;

	}

	public String getReportId() {

		Iterator reportId = set.iterator();

		Pattern reportIdChecker = Pattern.compile("([\\s]+[0-9A-Za-z]+)");

		while (reportId.hasNext()) {

			String checkerVal = (String) reportId.next();

			if (checkerVal.contains("Report")) {

				Matcher report = reportIdChecker.matcher(checkerVal);

				if (report.find()) {

					reportIdVal = report.group().trim();

					return report.group().trim();

				}
			}
		}

		return null;
	}

	public String getReportName(String[] split) {

		Pattern repNameChecker = Pattern.compile("[\\s](.)*");

		for (int i = 0; i < split.length; i++) {

			if (split[i].contains(reportIdVal)) {

				Matcher repName = repNameChecker.matcher(split[i]);

				if (repName.find()) {

					return repName.group().trim();

				}
			}
		}

		return null;
	}

	public String getReportGenerationDate(String[] split) {

		Pattern date = Pattern
				.compile("([0-9/]+[\\s][0-9]+[:]+[0-9]+[:]+[0-9]+)");

		for (int i = 0; i < split.length; i++) {

			Matcher match = date.matcher(split[i]);

			if (match.find()) {

				return match.group();

			}
		}
		return null;
	}

	public String getPageNumber(String[] split) {

		Pattern pageChecker = Pattern
				.compile("([\\s]([1-9]+[\\s]*[a-zA-Z]+[\\s]*[1-9]+)+)");

		for (int i = 0; i < split.length; i++) {

			if (split[i].contains("Page")) {

				Matcher page = pageChecker.matcher(split[i]);

				if (page.find()) {

					return page.group().trim();

				}
			}
		}

		return null;
	}

	public LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, String>>> getTransactionDetails(
			String[] split) {

		Pattern pattern3 = Pattern.compile("([A-H J-Z][.])(.)*");

		Pattern pattern4 = Pattern.compile("([0-9]+[A-Za-z]*[.][\\sA-Za-z]+)");

		Pattern pattern7 = Pattern
				.compile("((\\W*(Breakdown)\\W*)([\\s]*[a-zA-Z]+)+)");

		Pattern pattern8 = Pattern.compile("([0-9]*[a-z]*[.][\\s]*[A-Za-z]+)");

		Pattern checkInteger = Pattern
				.compile("([^\\s]*[0-9]+[.\\s]*[0-9]+[\\s]+[0-9]+)");

		Pattern pattern5 = Pattern.compile("([I]+[.])");

		Pattern pattern9 = Pattern.compile("([I]+[.][A-Za-z\\s-]*[^0-9:]*)");

		ArrayList<String> keyList = new ArrayList<String>();

		ArrayList<String> valueList = new ArrayList<String>();

		for (int i = 0; i < split.length; i++) {

			if (pattern3.matcher(split[i]).find()) {

				for (int j = i + 1; !pattern3.matcher(split[j]).find()
						&& j + 1 < split.length
						&& !pattern5.matcher(split[j]).find(); j++) {

					if (checkInteger.matcher(split[j]).find()) {

						if (pattern4.matcher(split[j + 1]).find()) {

							keyList.add(split[j + 1].trim());

							valueList.add(split[j].trim());
						}
					} else {

						if (pattern4.matcher(split[j]).find()
								&& !checkInteger.matcher(split[j - 1]).find()) {

							keyList.add(split[j].trim());

							valueList.add(null);

						}

					}
				}
			}
		}

		System.out.println("key's are:" + keyList);

		System.out.println("value's are:" + valueList);

		for (int i = 0; i < split.length; i++) {

			if (pattern7.matcher(split[i]).find()) {

				for (int j = i + 1; j + 1 < split.length
						&& !pattern7.matcher(split[j]).find()
						&& !pattern3.matcher(split[j]).find()
						&& !pattern5.matcher(split[j]).find(); j++) {

					if (checkInteger.matcher(split[j]).find()) {

						if (pattern8.matcher(split[j + 1]).find()) {

							keyList.add(split[j + 1].trim());

							valueList.add(split[j].trim());
						}
					} else {

						if (pattern8.matcher(split[j]).find()
								&& !checkInteger.matcher(split[j - 1]).find()) {

							keyList.add(split[j].trim());

							valueList.add(null);

						}

					}
				}
			}

		}

		System.out.println("key's are:" + keyList);

		System.out.println("value's are:" + valueList);

		for (int i = 0; i < split.length; i++) {

			if (pattern5.matcher(split[i]).find()) {

				for (int j = i + 1; j + 1 < split.length
						&& !pattern7.matcher(split[j]).find()
						&& !pattern3.matcher(split[j]).find()
						&& !pattern5.matcher(split[j]).find(); j++) {

					if (checkInteger.matcher(split[j]).find()) {

						if (pattern4.matcher(split[j + 1]).find()) {

							keyList.add(split[j + 1].trim());

							valueList.add(split[j].trim());
						}
					} else {

						if (pattern4.matcher(split[j]).find()
								&& !checkInteger.matcher(split[j - 1]).find()) {

							keyList.add(split[j].trim());

							valueList.add(null);

						}

					}
				}
			}

		}

		System.out.println("key's are:" + keyList);

		System.out.println("value's are:" + valueList);

		ArrayList<String> list_second = new ArrayList<String>();

		ArrayList<String> list_first = new ArrayList<String>();

		for (int i = 0; i < split.length; i++) {
			Matcher m9 = pattern9.matcher(split[i]);
			if (m9.find()) {
				list_first.add(m9.group().trim());
			}
		}
		System.out.println(list_first);

		for (int i = 0; i < split.length; i++) {

			Matcher m9 = pattern9.matcher(split[i]);
			if (m9.find()) {
				for (int k = i + 1; k < split.length; k++) {
					Matcher m3 = pattern3.matcher(split[k]);

					if (m3.find() && !pattern4.equals(split[k])
							&& !pattern5.equals(split[k])
							&& !list_second.contains(split[k])) {
						list_second.add(split[k].trim());

					}
				}

			}
		}
		System.out.println(list_second);
		ArrayList<String> list_third = new ArrayList<String>();

		LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, String>>> finalMap = new LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, String>>>();

		int q = 0;
		for (int i = 0; i < split.length; i++) {

			if (list_second.get(q).equals(split[i]) && q < list_second.size()) {

				for (int j = i + 1; j < split.length
						&& q + 1 < list_second.size(); j++) {

					Matcher m4 = pattern4.matcher(split[j]);

					if (m4.find()) {
						list_third.add(split[j].trim());
					}
					if (list_second.get(q + 1).equals(split[j])
							&& q < list_first.size() - 1) {
						q++;
						break;
					}
				}

			}
		}

		System.out.println(list_third);

		int t = 0, k = 0, p = 0;

		for (int i = 0; i < keyList
				.indexOf(Constants.ACCOUNT_AT_QUARTER_BEGINING)
				&& p < list_second.size(); i = t) {

			if (keyList.get(i).substring(0, 2).equals("1.")) {

				LinkedHashMap<String, LinkedHashMap<String, String>> nestedMap = new LinkedHashMap<String, LinkedHashMap<String, String>>();

				LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();

				if (valueList.get(i) != null) {

					String[] string = valueList.get(k).split(" ");

					map.put(Constants.TRANSACTION_AMOUNT, string[0]);

					map.put(Constants.TRANSACTION_COUNT, string[1]);

				} else {

					map.put(Constants.TRANSACTION_AMOUNT, null);

					map.put(Constants.TRANSACTION_COUNT, null);

				}

				nestedMap.put(keyList.get(i), map);

				for (k = i + 1; !keyList.get(k).trim().substring(0, 2).trim()
						.equals("1."); k++)

				{
					LinkedHashMap<String, String> map_1 = new LinkedHashMap<String, String>();

					if (valueList.get(k) != null) {

						String[] string = valueList.get(k).split(" ");

						map_1.put(Constants.TRANSACTION_AMOUNT, string[0]);

						map_1.put(Constants.TRANSACTION_COUNT, string[1]);

					} else {

						map_1.put(Constants.TRANSACTION_AMOUNT, null);

						map_1.put(Constants.TRANSACTION_COUNT, null);

					}

					nestedMap.put(keyList.get(k), map_1);

				}

				if (keyList.get(k).trim().substring(0, 2).trim().equals("1.")) {
					finalMap.put(list_second.get(p), nestedMap);
					p++;
					t = k;

				} else {

					t++;
				}

			}
		}

		for (int i = keyList.indexOf(Constants.ACCOUNT_AT_QUARTER_BEGINING); i < keyList
				.indexOf(Constants.GROSS_CREDIT_LOSSES)
				&& p < list_second.size(); i = t) {

			if (keyList.get(i).substring(0, 2).equals("1.")) {

				LinkedHashMap<String, LinkedHashMap<String, String>> nestedMap = new LinkedHashMap<String, LinkedHashMap<String, String>>();

				LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();

				if (valueList.get(i) != null) {

					String[] string = valueList.get(i).split(" ");

					map.put(Constants.OPEN, string[0]);

					map.put(Constants.TEMPORARILY_BLOCKED, string[1]);

					map.put(Constants.TOTAL, string[2].trim());

				} else {

					map.put(Constants.OPEN, null);

					map.put(Constants.TEMPORARILY_BLOCKED, null);

					map.put(Constants.TOTAL, null);
				}

				nestedMap.put(keyList.get(i), map);

				for (k = i + 1; !keyList.get(k).trim().substring(0, 2).trim()
						.equals("1."); k++)

				{
					LinkedHashMap<String, String> map_1 = new LinkedHashMap<String, String>();

					if (valueList.get(k) != null) {

						String[] string = valueList.get(k).split(" ");

						map_1.put(Constants.OPEN, string[0]);

						map_1.put(Constants.TEMPORARILY_BLOCKED, string[1]);

						map_1.put(Constants.TOTAL, string[2]);

					} else {

						map_1.put(Constants.OPEN, null);

						map_1.put(Constants.TEMPORARILY_BLOCKED, null);

						map_1.put(Constants.TOTAL, null);
					}

					nestedMap.put(keyList.get(k), map_1);

				}

				if (keyList.get(k).trim().substring(0, 2).trim().equals("1.")) {
					finalMap.put(list_second.get(p), nestedMap);
					p++;
					t = k;

				}

				else {

					t++;
				}

			}

		}

		for (int i = keyList.indexOf(Constants.GROSS_CREDIT_LOSSES); i < keyList
				.indexOf(Constants.ATM_CASH_DISBURSEMENTS)
				&& p < list_second.size(); i = t) {

			if (keyList.get(i).substring(0, 2).equals("1.")) {

				LinkedHashMap<String, LinkedHashMap<String, String>> nestedMap = new LinkedHashMap<String, LinkedHashMap<String, String>>();

				LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();

				if (valueList.get(i) != null) {

					String[] string = valueList.get(k).split(" ");

					map.put(Constants.ACCOUNTS, string[0]);

					map.put(Constants.BALANCES, string[1]);

				} else {

					map.put(Constants.ACCOUNTS, null);

					map.put(Constants.BALANCES, null);
				}

				nestedMap.put(keyList.get(i), map);

				for (k = i + 1; !keyList.get(k).trim().substring(0, 2).trim()
						.equals("1."); k++)

				{
					LinkedHashMap<String, String> map_1 = new LinkedHashMap<String, String>();

					if (valueList.get(k) != null) {

						String[] string = valueList.get(k).split(" ");

						map_1.put(Constants.ACCOUNTS, string[0]);

						map_1.put(Constants.BALANCES, string[1]);

					} else {

						map_1.put(Constants.ACCOUNTS, null);

						map_1.put(Constants.BALANCES, null);
					}

					nestedMap.put(keyList.get(k), map_1);

				}

				if (keyList.get(k).trim().substring(0, 2).trim().equals("1.")) {
					finalMap.put(list_second.get(p), nestedMap);
					p++;
					t = k;

				} else {

					t++;
				}

			}
		}

		for (int i = keyList.indexOf(Constants.ATM_CASH_DISBURSEMENTS); i < keyList
				.indexOf(Constants.BREAKOUT_OF_EMV_COMPLIANT_CHIPS)
				&& p < list_second.size(); i = t) {

			if (keyList.get(i).substring(0, 2).equals("1.")) {

				LinkedHashMap<String, LinkedHashMap<String, String>> nestedMap = new LinkedHashMap<String, LinkedHashMap<String, String>>();

				LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();

				if (valueList.get(i) != null) {

					String[] string = valueList.get(k).split(" ");

					map.put(Constants.TRANSACTION_AMOUNT, string[0]);

					map.put(Constants.TRANSACTION_COUNT, string[1]);

				} else {

					map.put(Constants.TRANSACTION_AMOUNT, null);

					map.put(Constants.TRANSACTION_COUNT, null);

				}

				nestedMap.put(keyList.get(i), map);

				for (k = i + 1; !keyList.get(k).trim().substring(0, 2).trim()
						.equals("1."); k++)

				{
					LinkedHashMap<String, String> map_1 = new LinkedHashMap<String, String>();

					if (valueList.get(k) != null) {

						String[] string = valueList.get(k).split(" ");

						map_1.put(Constants.TRANSACTION_AMOUNT, string[0]);

						map_1.put(Constants.TRANSACTION_COUNT, string[1]);

					} else {

						map_1.put(Constants.TRANSACTION_AMOUNT, null);

						map_1.put(Constants.TRANSACTION_COUNT, null);

					}

					nestedMap.put(keyList.get(k), map_1);

				}

				if (keyList.get(k).trim().substring(0, 2).trim().equals("1.")) {
					finalMap.put(list_second.get(p), nestedMap);
					p++;
					t = k;

				} else {

					t++;
				}

			}

		}

		for (int i = keyList.indexOf(Constants.BREAKOUT_OF_EMV_COMPLIANT_CHIPS); i < keyList
				.indexOf(Constants.TOTAL_MASTERCARD_CONTACTLESS_CARDS); i = t) {

			if (keyList.get(i).trim().substring(0, 2).trim().equals("1.")) {

				LinkedHashMap<String, LinkedHashMap<String, String>> nestedMap = new LinkedHashMap<String, LinkedHashMap<String, String>>();

				LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();

				if (valueList.get(i) != null) {

					String[] string = valueList.get(i).split(" ");

					map.put(Constants.CARDS, string[0]);

					map.put(Constants.TRANSACTION_AMOUNT, string[1]);

					map.put(Constants.TRANSACTION_COUNT, string[2]);

				} else {

					map.put(Constants.CARDS, null);

					map.put(Constants.TRANSACTION_AMOUNT, null);

					map.put(Constants.TRANSACTION_COUNT, null);

				}

				nestedMap.put(keyList.get(i), map);

				for (k = i + 1; k < keyList.size(); k++)

				{
					LinkedHashMap<String, String> map_1 = new LinkedHashMap<String, String>();

					if (valueList.get(k) != null) {

						String[] string = valueList.get(k).split(" ");

						map_1.put(Constants.CARDS, string[0]);

						map_1.put(Constants.TRANSACTION_AMOUNT, string[1]);

						map_1.put(Constants.TRANSACTION_COUNT, string[2]);

					} else {

						map_1.put(Constants.CARDS, null);

						map_1.put(Constants.TRANSACTION_AMOUNT, null);

						map_1.put(Constants.TRANSACTION_COUNT, null);

					}

					nestedMap.put(keyList.get(k), map_1);

				}

				finalMap.put(keyList.get(i), nestedMap);

				t = k;

			}

		}

		System.out.println("Final Map Values Are:" + finalMap);

		return finalMap;
	}

	public boolean readHeaders(ArrayList<String> headerList) {

		try {
			if (!headerList
					.contains(Constants.CARD_HOLDER_ACTIVITY_AND_ISSUER_BIN
							.trim())) {

				return false;
			} else if (!headerList
					.contains(Constants.CHARGED_OFF_LOSSES.trim())) {

				return false;
			} else if (!headerList.contains(Constants.CARD_FEATURE_DETAILS
					.trim())) {

				return false;
			} else if (!headerList
					.contains(Constants.PURCHASE_TRANSACTIONS_VOLUME.trim())) {

				return false;
			} else if (!headerList
					.contains(Constants.CASH_DISBERSEMENTS.trim())) {

				return false;
			} else if (!headerList.contains(Constants.REFUND_RETURN_CREDITS
					.trim())) {

				return false;
			} else if (!headerList
					.contains(Constants.ACCOUNT_CARDS_OPEN_BLOCKED_TOTAL.trim())) {

				return false;
			} else if (!headerList.contains(Constants.CREDIT_LOSSES.trim())) {

				return false;
			} else if (!headerList.contains(Constants.BANKRUPTCY_LOSSES.trim())) {

				return false;
			} else if (!headerList.contains(Constants.FRAUD_LOSSES.trim())) {

				return false;
			} else if (!headerList.contains(Constants.OTHER_LOSSES.trim())) {

				return false;
			} else if (!headerList.contains(Constants.TOTAL_CHARGED_OFF_LOSSES
					.trim())) {

				return false;
			} else if (!headerList
					.contains(Constants.CASH_DISBURSEMENT_BREAKDOWN.trim())) {

				return false;
			} else if (!headerList.contains(Constants.DOMESTIC_ONUS_1.trim())) {

				return false;
			} else if (!headerList.contains(Constants.DOMESTIC_OTHER_BRAND_1
					.trim())) {
				return false;
			} else if (!headerList.contains(Constants.DOMESTIC_INTERCHANGE_1
					.trim())) {
				return false;
			} else if (!headerList.contains(Constants.INTERNATIONAL_1.trim())) {
				return false;
			} else if (!headerList.contains(Constants.TOTAL_1.trim())) {
				return false;
			} else if (!headerList.contains(Constants.DOMESTIC_ONUS_2.trim())) {
				return false;
			} else if (!headerList.contains(Constants.DOMESTIC_OTHER_BRAND_2
					.trim())) {
				return false;
			} else if (!headerList.contains(Constants.DOMESTIC_INTERCHANGE_2
					.trim())) {
				return false;
			} else if (!headerList.contains(Constants.INTERNATIONAL_2.trim())) {
				return false;
			} else if (!headerList.contains(Constants.TOTAL_2.trim())) {
				return false;
			} else if (!headerList.contains(Constants.DOMESTIC_ONUS_3.trim())) {
				return false;
			} else if (!headerList.contains(Constants.DOMESTIC_OTHER_BRAND_3
					.trim())) {
				return false;
			} else if (!headerList.contains(Constants.DOMESTIC_INTERCHANGE_3
					.trim())) {
				return false;
			} else if (!headerList.contains(Constants.INTERNATIONAL_3.trim())) {
				return false;
			} else if (!headerList.contains(Constants.TOTAL_3.trim())) {
				return false;
			} else if (!headerList
					.contains(Constants.ACCOUNT_AT_QUARTER_BEGINING.trim())) {
				return false;
			} else if (!headerList
					.contains(Constants.NEW_ACCOUNTS_DURING_QUARTER.trim())) {
				return false;
			} else if (!headerList
					.contains(Constants.ACCOUNTS_TERMINATED_DURING_QUARTER
							.trim())) {
				return false;
			} else if (!headerList
					.contains(Constants.ACCOUNTS_AT_END_OF_QUARTER.trim())) {
				return false;
			} else if (!headerList
					.contains(Constants.ACCOUNTS_WITH_ATLEAST_ONE_TRN_DURING_QUARTER
							.trim())) {
				return false;
			} else if (!headerList
					.contains(Constants.CARDS_AT_QUARTER_BEGINNING.trim())) {
				return false;
			} else if (!headerList.contains(Constants.NEW_CARDS.trim())) {
				return false;
			} else if (!headerList.contains(Constants.CARDS_AT_QUARTER_END
					.trim())) {
				return false;
			} else if (!headerList
					.contains(Constants.CARDS_WITH_CURRUS_LOGO_AT_QUARTER_END
							.trim())) {
				return false;
			} else if (!headerList.contains(Constants.CARDS_WITH_MAESTRO_LOGO
					.trim())) {
				return false;
			} else if (!headerList
					.contains(Constants.CARDS_WITH_ATLEAST_ONE_TRANS_PER_QUARTER
							.trim())) {
				return false;
			} else if (!headerList.contains(Constants.CARDS_IN_REWARDS_PROGRAM
					.trim())) {
				return false;
			} else if (!headerList
					.contains(Constants.GROSS_FRAUD_LOSSES.trim())) {
				return false;
			} else if (!headerList.contains(Constants.RECOVERY_OF_FRAUD_LOSSES
					.trim())) {
				return false;
			} else if (!headerList.contains(Constants.NET_FRAUD_LOSSES.trim())) {
				return false;
			} else if (!headerList
					.contains(Constants.GROSS_OTHER_LOSSES.trim())) {
				return false;
			} else if (!headerList.contains(Constants.RECOVERY_OF_OTHER_LOSES
					.trim())) {
				return false;
			} else if (!headerList.contains(Constants.NET_OTHER_LOSSES.trim())) {
				return false;
			} else if (!headerList
					.contains(Constants.TOTAL_GROSS_CHARGED_OFF_LOSSES.trim())) {
				return false;
			} else if (!headerList
					.contains(Constants.TOTAL_RECOVERY_OF_CHARGED_OFF_LOSSES
							.trim())) {
				return false;
			} else if (!headerList
					.contains(Constants.TOTAL_NET_CHARGED_OFF_LOSSES.trim())) {
				return false;
			} else if (!headerList
					.contains(Constants.BREAKOUT_OF_EMV_COMPLIANT_CHIPS.trim())) {
				return false;
			} else if (!headerList.contains(Constants.OFFLINE_PIN_CAPABILITY
					.trim())) {
				return false;
			} else if (!headerList.contains(Constants.PAYPASS_ENABLED.trim())) {
				return false;
			} else if (!headerList.contains(Constants.DIPPED_TRANSACTIONS
					.trim())) {
				return false;
			} else if (!headerList
					.contains(Constants.TOTAL_MASTERCARD_CONTACTLESS_CARDS
							.trim())) {
				return false;
			} else if (!headerList.contains(Constants.ATM_CASH_DISBURSEMENTS
					.trim())) {
				return false;
			} else if (!headerList.contains(Constants.TELLER_CASH_DISBURSEMENTS
					.trim())) {
				return false;
			} else if (!headerList
					.contains(Constants.CONVENIENCE_CHECKS.trim())) {
				return false;
			} else if (!headerList.contains(Constants.BALANCE_TRANSFERS.trim())) {
				return false;
			} else if (!headerList.contains(Constants.GROSS_CREDIT_LOSSES
					.trim())) {
				return false;
			} else if (!headerList.contains(Constants.RECOVERY_OF_CREDIT_LOSSES
					.trim())) {
				return false;
			} else if (!headerList.contains(Constants.NET_CREDIT_LOSSES.trim())) {
				return false;
			} else if (!headerList.contains(Constants.GROSS_BANKRUPTCY_LOSSES
					.trim())) {
				return false;
			} else if (!headerList
					.contains(Constants.RECOVERY_OF_BANKRUPTCY_CHARGES.trim())) {
				return false;
			} else if (!headerList.contains(Constants.NET_BANKRUPTCY_CHARGES
					.trim())) {
				return false;
			}

		} catch (Exception e) {

			System.out.println("Encountered Exception in Header Validations:"
					+ e.getMessage());
		}

		return true;
	}

	public boolean compareReportDBValues(
			LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, String>>> map,
			String header, LinkedHashMap<String, String> databaseObj) {
		// TODO Auto-generated method stub

		// return
		// databaseObj.equals(map.get(Constants.BREAKOUT_OF_EMV_COMPLIANT_CHIPS).get(Constants.TOTAL_MASTERCARD_CONTACTLESS_CARDS));

		try {

			if (header.equals(Constants.PURCHASE_TRANSACTIONS_VOLUME)) {

				if (map.get(Constants.PURCHASE_TRANSACTIONS_VOLUME).get(
						Constants.DOMESTIC_ONUS_1) != null) {

					return databaseObj.equals(map.get(
							Constants.PURCHASE_TRANSACTIONS_VOLUME).get(
							Constants.DOMESTIC_ONUS_1));
				} else if (map.get(Constants.PURCHASE_TRANSACTIONS_VOLUME).get(
						Constants.DOMESTIC_OTHER_BRAND_1) != null) {

					return databaseObj.equals(map.get(
							Constants.PURCHASE_TRANSACTIONS_VOLUME).get(
							Constants.DOMESTIC_OTHER_BRAND_1));
				} else if (map.get(Constants.PURCHASE_TRANSACTIONS_VOLUME).get(
						Constants.DOMESTIC_INTERCHANGE_1) != null) {

					return databaseObj.equals(map.get(
							Constants.PURCHASE_TRANSACTIONS_VOLUME).get(
							Constants.DOMESTIC_INTERCHANGE_1));
				} else if (map.get(Constants.PURCHASE_TRANSACTIONS_VOLUME).get(
						Constants.INTERNATIONAL_1) != null) {

					return databaseObj.equals(map.get(
							Constants.PURCHASE_TRANSACTIONS_VOLUME).get(
							Constants.INTERNATIONAL_1));
				} else if (map.get(Constants.PURCHASE_TRANSACTIONS_VOLUME).get(
						Constants.TOTAL_1) != null) {

					return databaseObj.equals(map.get(
							Constants.PURCHASE_TRANSACTIONS_VOLUME).get(
							Constants.TOTAL_1));
				}

			} else if (header.equals(Constants.CASH_DISBERSEMENTS)) {
				if (map.get(Constants.CASH_DISBERSEMENTS).get(
						Constants.DOMESTIC_ONUS_2) != null) {

					return databaseObj.equals(map.get(
							Constants.CASH_DISBERSEMENTS).get(
							Constants.DOMESTIC_ONUS_2));
				} else if (map.get(Constants.CASH_DISBERSEMENTS).get(
						Constants.DOMESTIC_OTHER_BRAND_2) != null) {

					return databaseObj.equals(map.get(
							Constants.CASH_DISBERSEMENTS).get(
							Constants.DOMESTIC_OTHER_BRAND_2));
				} else if (map.get(Constants.CASH_DISBERSEMENTS).get(
						Constants.DOMESTIC_INTERCHANGE_2) != null) {

					return databaseObj.equals(map.get(
							Constants.CASH_DISBERSEMENTS).get(
							Constants.DOMESTIC_INTERCHANGE_2));
				} else if (map.get(Constants.CASH_DISBERSEMENTS).get(
						Constants.INTERNATIONAL_2) != null) {

					return databaseObj.equals(map.get(
							Constants.CASH_DISBERSEMENTS).get(
							Constants.INTERNATIONAL_2));
				} else if (map.get(Constants.CASH_DISBERSEMENTS).get(
						Constants.TOTAL_2) != null) {

					return databaseObj.equals(map.get(
							Constants.CASH_DISBERSEMENTS)
							.get(Constants.TOTAL_2));
				}
			}

			else if (header.equals(Constants.REFUND_RETURN_CREDITS)) {
				if (map.get(Constants.REFUND_RETURN_CREDITS).get(
						Constants.DOMESTIC_ONUS_3) != null) {

					return databaseObj.equals(map.get(
							Constants.REFUND_RETURN_CREDITS).get(
							Constants.DOMESTIC_ONUS_3));
				} else if (map.get(Constants.REFUND_RETURN_CREDITS).get(
						Constants.DOMESTIC_OTHER_BRAND_3) != null) {

					return databaseObj.equals(map.get(
							Constants.REFUND_RETURN_CREDITS).get(
							Constants.DOMESTIC_OTHER_BRAND_3));
				} else if (map.get(Constants.REFUND_RETURN_CREDITS).get(
						Constants.DOMESTIC_INTERCHANGE_3) != null) {

					return databaseObj.equals(map.get(
							Constants.REFUND_RETURN_CREDITS).get(
							Constants.DOMESTIC_INTERCHANGE_3));
				} else if (map.get(Constants.REFUND_RETURN_CREDITS).get(
						Constants.INTERNATIONAL_3) != null) {

					return databaseObj.equals(map.get(
							Constants.REFUND_RETURN_CREDITS).get(
							Constants.INTERNATIONAL_3));
				} else if (map.get(Constants.REFUND_RETURN_CREDITS).get(
						Constants.TOTAL_3) != null) {

					return databaseObj.equals(map.get(
							Constants.REFUND_RETURN_CREDITS).get(
							Constants.TOTAL_3));
				}
			}

			else if (header.equals(Constants.ACCOUNT_CARDS_OPEN_BLOCKED_TOTAL)) {
				if (map.get(Constants.ACCOUNT_CARDS_OPEN_BLOCKED_TOTAL).get(
						Constants.ACCOUNT_AT_QUARTER_BEGINING) != null) {

					return databaseObj.equals(map.get(
							Constants.ACCOUNT_CARDS_OPEN_BLOCKED_TOTAL).get(
							Constants.ACCOUNT_AT_QUARTER_BEGINING));
				} else if (map.get(Constants.ACCOUNT_CARDS_OPEN_BLOCKED_TOTAL)
						.get(Constants.NEW_ACCOUNTS_DURING_QUARTER) != null) {

					return databaseObj.equals(map.get(
							Constants.ACCOUNT_CARDS_OPEN_BLOCKED_TOTAL).get(
							Constants.NEW_ACCOUNTS_DURING_QUARTER));
				} else if (map.get(Constants.ACCOUNT_CARDS_OPEN_BLOCKED_TOTAL)
						.get(Constants.ACCOUNTS_TERMINATED_DURING_QUARTER) != null) {

					return databaseObj.equals(map.get(
							Constants.ACCOUNT_CARDS_OPEN_BLOCKED_TOTAL).get(
							Constants.ACCOUNTS_TERMINATED_DURING_QUARTER));
				} else if (map.get(Constants.ACCOUNT_CARDS_OPEN_BLOCKED_TOTAL)
						.get(Constants.ACCOUNTS_AT_END_OF_QUARTER) != null) {

					return databaseObj.equals(map.get(
							Constants.ACCOUNT_CARDS_OPEN_BLOCKED_TOTAL).get(
							Constants.ACCOUNTS_AT_END_OF_QUARTER));
				} else if (map
						.get(Constants.ACCOUNT_CARDS_OPEN_BLOCKED_TOTAL)
						.get(Constants.ACCOUNTS_WITH_ATLEAST_ONE_TRN_DURING_QUARTER) != null) {

					return databaseObj
							.equals(map
									.get(Constants.ACCOUNT_CARDS_OPEN_BLOCKED_TOTAL)
									.get(Constants.ACCOUNTS_WITH_ATLEAST_ONE_TRN_DURING_QUARTER));
				}

				else if (map.get(Constants.ACCOUNT_CARDS_OPEN_BLOCKED_TOTAL)
						.get(Constants.CARDS_AT_QUARTER_BEGINNING) != null) {

					return databaseObj.equals(map.get(
							Constants.ACCOUNT_CARDS_OPEN_BLOCKED_TOTAL).get(
							Constants.CARDS_AT_QUARTER_BEGINNING));
				} else if (map.get(Constants.ACCOUNT_CARDS_OPEN_BLOCKED_TOTAL)
						.get(Constants.NEW_CARDS) != null) {

					return databaseObj.equals(map.get(
							Constants.ACCOUNT_CARDS_OPEN_BLOCKED_TOTAL).get(
							Constants.NEW_CARDS));
				} else if (map.get(Constants.ACCOUNT_CARDS_OPEN_BLOCKED_TOTAL)
						.get(Constants.CARDS_AT_QUARTER_END) != null) {

					return databaseObj.equals(map.get(
							Constants.ACCOUNT_CARDS_OPEN_BLOCKED_TOTAL).get(
							Constants.CARDS_AT_QUARTER_END));
				} else if (map.get(Constants.ACCOUNT_CARDS_OPEN_BLOCKED_TOTAL)
						.get(Constants.CARDS_WITH_CURRUS_LOGO_AT_QUARTER_END) != null) {

					return databaseObj.equals(map.get(
							Constants.ACCOUNT_CARDS_OPEN_BLOCKED_TOTAL).get(
							Constants.CARDS_WITH_CURRUS_LOGO_AT_QUARTER_END));
				} else if (map.get(Constants.ACCOUNT_CARDS_OPEN_BLOCKED_TOTAL)
						.get(Constants.CARDS_WITH_MAESTRO_LOGO) != null) {

					return databaseObj.equals(map.get(
							Constants.ACCOUNT_CARDS_OPEN_BLOCKED_TOTAL).get(
							Constants.CARDS_WITH_MAESTRO_LOGO));
				} else if (map
						.get(Constants.ACCOUNT_CARDS_OPEN_BLOCKED_TOTAL)
						.get(Constants.CARDS_WITH_ATLEAST_ONE_TRANS_PER_QUARTER) != null) {

					return databaseObj
							.equals(map
									.get(Constants.ACCOUNT_CARDS_OPEN_BLOCKED_TOTAL)
									.get(Constants.CARDS_WITH_ATLEAST_ONE_TRANS_PER_QUARTER));
				} else if (map.get(Constants.ACCOUNT_CARDS_OPEN_BLOCKED_TOTAL)
						.get(Constants.CARDS_IN_REWARDS_PROGRAM) != null) {

					return databaseObj.equals(map.get(
							Constants.ACCOUNT_CARDS_OPEN_BLOCKED_TOTAL).get(
							Constants.CARDS_IN_REWARDS_PROGRAM));
				}

			}

			else if (header.equals(Constants.CREDIT_LOSSES)) {

				if (map.get(Constants.CREDIT_LOSSES).get(
						Constants.GROSS_CREDIT_LOSSES) != null) {

					return databaseObj.equals(map.get(Constants.CREDIT_LOSSES)
							.get(Constants.GROSS_CREDIT_LOSSES));
				} else if (map.get(Constants.CREDIT_LOSSES).get(
						Constants.RECOVERY_OF_CREDIT_LOSSES) != null) {

					return databaseObj.equals(map.get(Constants.CREDIT_LOSSES)
							.get(Constants.RECOVERY_OF_CREDIT_LOSSES));
				} else if (map.get(Constants.CREDIT_LOSSES).get(
						Constants.NET_CREDIT_LOSSES) != null) {

					return databaseObj.equals(map.get(Constants.CREDIT_LOSSES)
							.get(Constants.NET_CREDIT_LOSSES));
				}
			} else if (header.equals(Constants.BANKRUPTCY_LOSSES)) {

				if (map.get(Constants.BANKRUPTCY_LOSSES).get(
						Constants.GROSS_BANKRUPTCY_LOSSES) != null) {

					return databaseObj.equals(map.get(
							Constants.BANKRUPTCY_LOSSES).get(
							Constants.GROSS_BANKRUPTCY_LOSSES));
				} else if (map.get(Constants.BANKRUPTCY_LOSSES).get(
						Constants.RECOVERY_OF_BANKRUPTCY_CHARGES) != null) {

					return databaseObj.equals(map.get(
							Constants.BANKRUPTCY_LOSSES).get(
							Constants.RECOVERY_OF_BANKRUPTCY_CHARGES));
				}

				else if (map.get(Constants.BANKRUPTCY_LOSSES).get(
						Constants.NET_BANKRUPTCY_CHARGES) != null) {

					return databaseObj.equals(map.get(
							Constants.BANKRUPTCY_LOSSES).get(
							Constants.NET_BANKRUPTCY_CHARGES));

				}
			} else if (header.equals(Constants.FRAUD_LOSSES)) {

				if (map.get(Constants.FRAUD_LOSSES).get(
						Constants.GROSS_FRAUD_LOSSES) != null) {

					return databaseObj.equals(map.get(Constants.FRAUD_LOSSES)
							.get(Constants.GROSS_FRAUD_LOSSES));
				} else if (map.get(Constants.FRAUD_LOSSES).get(
						Constants.NET_FRAUD_LOSSES) != null) {

					return databaseObj.equals(map.get(Constants.FRAUD_LOSSES)
							.get(Constants.NET_FRAUD_LOSSES));
				} else if (map.get(Constants.FRAUD_LOSSES).get(
						Constants.RECOVERY_OF_OTHER_LOSES) != null) {

					return databaseObj.equals(map.get(
							Constants.ACCOUNT_CARDS_OPEN_BLOCKED_TOTAL).get(
							Constants.RECOVERY_OF_OTHER_LOSES));
				}

			}

			else if (header.equals(Constants.TOTAL_CHARGED_OFF_LOSSES)) {

				if (map.get(Constants.TOTAL_CHARGED_OFF_LOSSES).get(
						Constants.TOTAL_GROSS_CHARGED_OFF_LOSSES) != null) {

					return databaseObj.equals(map.get(
							Constants.TOTAL_CHARGED_OFF_LOSSES).get(
							Constants.TOTAL_GROSS_CHARGED_OFF_LOSSES));
				}

				else if (map.get(Constants.TOTAL_CHARGED_OFF_LOSSES).get(
						Constants.TOTAL_RECOVERY_OF_CHARGED_OFF_LOSSES) != null) {

					return databaseObj.equals(map.get(
							Constants.TOTAL_CHARGED_OFF_LOSSES).get(
							Constants.TOTAL_RECOVERY_OF_CHARGED_OFF_LOSSES));
				} else if (map.get(Constants.TOTAL_CHARGED_OFF_LOSSES).get(
						Constants.TOTAL_NET_CHARGED_OFF_LOSSES) != null) {

					return databaseObj.equals(map.get(
							Constants.TOTAL_CHARGED_OFF_LOSSES).get(
							Constants.TOTAL_NET_CHARGED_OFF_LOSSES));
				}

				else if (map.get(Constants.TOTAL_CHARGED_OFF_LOSSES).get(
						Constants.ATM_CASH_DISBURSEMENTS) != null) {

					return databaseObj.equals(map.get(
							Constants.TOTAL_CHARGED_OFF_LOSSES).get(
							Constants.ATM_CASH_DISBURSEMENTS));
				} else if (map.get(Constants.TOTAL_CHARGED_OFF_LOSSES).get(
						Constants.TELLER_CASH_DISBURSEMENTS) != null) {

					return databaseObj.equals(map.get(
							Constants.TOTAL_CHARGED_OFF_LOSSES).get(
							Constants.TELLER_CASH_DISBURSEMENTS));
				} else if (map.get(Constants.TOTAL_CHARGED_OFF_LOSSES).get(
						Constants.CONVENIENCE_CHECKS) != null) {

					return databaseObj.equals(map.get(
							Constants.TOTAL_CHARGED_OFF_LOSSES).get(
							Constants.CONVENIENCE_CHECKS));
				} else if (map.get(Constants.TOTAL_CHARGED_OFF_LOSSES).get(
						Constants.BALANCE_TRANSFERS) != null) {

					return databaseObj.equals(map.get(
							Constants.TOTAL_CHARGED_OFF_LOSSES).get(
							Constants.BALANCE_TRANSFERS));
				}

			}

			else if (header.equals(Constants.BREAKOUT_OF_EMV_COMPLIANT_CHIPS)) {

				if (map.get(Constants.BREAKOUT_OF_EMV_COMPLIANT_CHIPS).get(
						Constants.CARDS_AT_QUARTER_END) != null) {

					return databaseObj.equals(map.get(
							Constants.BREAKOUT_OF_EMV_COMPLIANT_CHIPS).get(
							Constants.BREAKOUT_OF_EMV_COMPLIANT_CHIPS));
				} else if (map.get(Constants.BREAKOUT_OF_EMV_COMPLIANT_CHIPS)
						.get(Constants.OFFLINE_PIN_CAPABILITY) != null) {

					return databaseObj.equals(map.get(
							Constants.OFFLINE_PIN_CAPABILITY).get(
							Constants.OFFLINE_PIN_CAPABILITY));
				} else if (map.get(Constants.BREAKOUT_OF_EMV_COMPLIANT_CHIPS)
						.get(Constants.PAYPASS_ENABLED) != null) {

					return databaseObj.equals(map
							.get(Constants.PAYPASS_ENABLED).get(
									Constants.PAYPASS_ENABLED));
				} else if (map.get(Constants.BREAKOUT_OF_EMV_COMPLIANT_CHIPS)
						.get(Constants.DIPPED_TRANSACTIONS) != null) {

					return databaseObj.equals(map.get(
							Constants.DIPPED_TRANSACTIONS).get(
							Constants.DIPPED_TRANSACTIONS));
				} else if (map.get(Constants.BREAKOUT_OF_EMV_COMPLIANT_CHIPS)
						.get(Constants.TOTAL_MASTERCARD_CONTACTLESS_CARDS) != null) {

					return databaseObj.equals(map.get(
							Constants.TOTAL_MASTERCARD_CONTACTLESS_CARDS).get(
							Constants.TOTAL_MASTERCARD_CONTACTLESS_CARDS));
				}

			}

		} catch (Exception e) {

		}
		return false;
	}

	public String getReportGeneratedByName(String[] split) {

		Pattern p = Pattern.compile("^([^-][a-zA-Z\\s]+)(.)*");

		Matcher m = p.matcher(getReportGeneratedBy(split));

		String str = null;

		while (m.find()) {
			str = m.group(1);
		}

		return str;
	}

	public Process openPDFFile(String fileName) throws IOException,
			InterruptedException {

		ProcessBuilder pb = new ProcessBuilder("explorer.exe", fileName);
		Process p = pb.start();
		p.waitFor();
		Console console = System.console();
		console.writer().write("Swap1606");
		return p;
	}

	public boolean checkTransAmountCountLabels(String[] split) {

		int count = 0, counter = 0;

		for (int i = 0; i + 1 < split.length; i++) {

			if (split[i].trim().contains(Constants.TRANSACTION_AMOUNT)
					&& split[i].contains(Constants.TRANSACTION_COUNT)) {
				count = count + 2;

			}

			if (count == 2) {

				if (split[i + 1].trim().equals(
						Constants.PURCHASE_TRANSACTIONS_VOLUME)
						|| split[i + 1].trim().equals(
								Constants.CASH_DISBERSEMENTS)
						|| split[i + 1].trim().equals(
								Constants.REFUND_RETURN_CREDITS)) {

					counter = counter + count;

				}

			}
			count = 0;
		}

		if (counter == 6) {

			return true;
		}

		return false;
	}

	public boolean checkTransAmountCountForConvenienceChecks(String[] split) {

		boolean flag_1 = false, flag_2 = false;

		LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, String>>> finalMap = getTransactionDetails(split);

		if (finalMap.containsKey(Constants.TOTAL_CHARGED_OFF_LOSSES)) {

			if (finalMap.get(Constants.TOTAL_CHARGED_OFF_LOSSES).containsKey(
					Constants.BALANCE_TRANSFERS)) {

				flag_1 = true;

			}

			if (finalMap.get(Constants.TOTAL_CHARGED_OFF_LOSSES).containsKey(
					Constants.CONVENIENCE_CHECKS)) {

				Assert.assertTrue(finalMap
						.get(Constants.TOTAL_CHARGED_OFF_LOSSES)
						.get(Constants.CONVENIENCE_CHECKS)
						.get(Constants.ACCOUNTS) == null

						|| finalMap.get(Constants.TOTAL_CHARGED_OFF_LOSSES)
								.get(Constants.CONVENIENCE_CHECKS)
								.get(Constants.BALANCES) == null);

				flag_2 = true;

			}

		}

		return flag_1 && flag_2;
	}

	public void checkPDFPageCountAndBinPresence(String[] split) {

		Set<String> set = new LinkedHashSet<String>();

		Pattern pattern1 = Pattern
				.compile("([a-zA-Z0-9]+[\\s\\t]*[:]{1}[\\s\\t]*[a-zA-Z0-9]+)");
		Pattern pattern2 = Pattern
				.compile("([A-Za-z0-9]+[\\s]*[:]{1}[\\s]*[A-Za-z0-9]+)");

		for (int i = 0; i < split.length; i++) {

			Matcher m1 = pattern1.matcher(split[i]);
			Matcher m2 = pattern2.matcher(split[i]);

			while (m1.find()) {
				try {

					set.add(m1.group().trim());

				} catch (Exception r) {
					continue;
				}
			}

			while (m2.find()) {

				try {

					set.add(m2.group().trim());

				} catch (Exception r) {

					continue;
				}
			}
		}

		Iterator itr = set.iterator();

		boolean flag = false;

		while (itr.hasNext()) {
			String str = (String) itr.next();

			if (str.contains("Bin")) {

				flag = true;
			}

		}

		Assert.assertTrue(flag == true);
	}

	public void CheckTotalTransactionAmountReturnAndRefunds(String[] split) {

		try {

			float sum;

			LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, String>>> finalMap = getTransactionDetails(split);

			if (finalMap.containsKey(Constants.REFUND_RETURN_CREDITS)) {

				sum = Float.parseFloat(finalMap
						.get(Constants.REFUND_RETURN_CREDITS)
						.get(Constants.DOMESTIC_ONUS_3)
						.get(Constants.TRANSACTION_AMOUNT))
						+ Float.parseFloat(finalMap
								.get(Constants.REFUND_RETURN_CREDITS)
								.get(Constants.DOMESTIC_OTHER_BRAND_3)
								.get(Constants.TRANSACTION_AMOUNT))
						+ Float.parseFloat(finalMap
								.get(Constants.REFUND_RETURN_CREDITS)
								.get(Constants.DOMESTIC_INTERCHANGE_3)
								.get(Constants.TRANSACTION_AMOUNT))
						+ Float.parseFloat(finalMap
								.get(Constants.REFUND_RETURN_CREDITS)
								.get(Constants.INTERNATIONAL_3)
								.get(Constants.TRANSACTION_AMOUNT));

				Assert.assertTrue(finalMap.get(Constants.REFUND_RETURN_CREDITS)
						.get(Constants.TOTAL_3)
						.get(Constants.TRANSACTION_AMOUNT)
						.equals(String.valueOf(sum)));
			}
		} catch (Exception e) {

			System.out
					.println("Exception occured in CheckTotalTransactionAmountReturnAndRefunds function:"
							+ e.getMessage());

		}
	}

	public void CheckTotalTransactionCountReturnAndRefunds(String[] split) {

		try {

			int sum;

			LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, String>>> finalMap = getTransactionDetails(split);

			if (finalMap.containsKey(Constants.REFUND_RETURN_CREDITS)) {

				sum = Integer.parseInt(finalMap
						.get(Constants.REFUND_RETURN_CREDITS)
						.get(Constants.DOMESTIC_ONUS_3)
						.get(Constants.TRANSACTION_COUNT))
						+ Integer.parseInt(finalMap
								.get(Constants.REFUND_RETURN_CREDITS)
								.get(Constants.DOMESTIC_OTHER_BRAND_3)
								.get(Constants.TRANSACTION_COUNT))
						+ Integer.parseInt(finalMap
								.get(Constants.REFUND_RETURN_CREDITS)
								.get(Constants.DOMESTIC_INTERCHANGE_3)
								.get(Constants.TRANSACTION_COUNT))
						+ Integer.parseInt(finalMap
								.get(Constants.REFUND_RETURN_CREDITS)
								.get(Constants.INTERNATIONAL_3)
								.get(Constants.TRANSACTION_COUNT));

				System.out.println(sum);

				Assert.assertTrue(finalMap.get(Constants.REFUND_RETURN_CREDITS)
						.get(Constants.TOTAL_3)
						.get(Constants.TRANSACTION_COUNT)
						.equals(String.valueOf(sum)));
			}
		} catch (Exception e) {

			System.out
					.println("Exception occured in CheckTotalTransactionCountReturnAndRefunds function:"
							+ e.getMessage());

		}
	}

	public void CheckTotalTransactionAmountDisbursements(String[] split) {

		try {

			float sum;

			LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, String>>> finalMap = getTransactionDetails(split);

			if (finalMap.containsKey(Constants.CASH_DISBERSEMENTS)) {

				sum = Float.parseFloat(finalMap
						.get(Constants.CASH_DISBERSEMENTS)
						.get(Constants.DOMESTIC_ONUS_2)
						.get(Constants.TRANSACTION_AMOUNT))
						+ Float.parseFloat(finalMap
								.get(Constants.CASH_DISBERSEMENTS)
								.get(Constants.DOMESTIC_OTHER_BRAND_2)
								.get(Constants.TRANSACTION_AMOUNT))
						+ Float.parseFloat(finalMap
								.get(Constants.CASH_DISBERSEMENTS)
								.get(Constants.DOMESTIC_INTERCHANGE_2)
								.get(Constants.TRANSACTION_AMOUNT))
						+ Float.parseFloat(finalMap
								.get(Constants.CASH_DISBERSEMENTS)
								.get(Constants.INTERNATIONAL_2)
								.get(Constants.TRANSACTION_AMOUNT));

				Assert.assertTrue(finalMap.get(Constants.CASH_DISBERSEMENTS)
						.get(Constants.TOTAL_2)
						.get(Constants.TRANSACTION_AMOUNT)
						.equals(String.valueOf(sum)));
			}
		} catch (Exception e) {

			System.out
					.println("Exception occured in CheckTotalTransactionAmountDisbursements function:"
							+ e.getMessage());

		}
	}

	public void CheckTotalTransactionCountDisbursements(String[] split) {

		try {

			int sum;

			LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, String>>> finalMap = getTransactionDetails(split);

			if (finalMap.containsKey(Constants.CASH_DISBERSEMENTS)) {

				sum = Integer.parseInt(finalMap
						.get(Constants.CASH_DISBERSEMENTS)
						.get(Constants.DOMESTIC_ONUS_2)
						.get(Constants.TRANSACTION_COUNT))
						+ Integer.parseInt(finalMap
								.get(Constants.CASH_DISBERSEMENTS)
								.get(Constants.DOMESTIC_OTHER_BRAND_2)
								.get(Constants.TRANSACTION_COUNT))
						+ Integer.parseInt(finalMap
								.get(Constants.CASH_DISBERSEMENTS)
								.get(Constants.DOMESTIC_INTERCHANGE_2)
								.get(Constants.TRANSACTION_COUNT))
						+ Integer.parseInt(finalMap
								.get(Constants.CASH_DISBERSEMENTS)
								.get(Constants.INTERNATIONAL_2)
								.get(Constants.TRANSACTION_COUNT));

				Assert.assertTrue(finalMap.get(Constants.CASH_DISBERSEMENTS)
						.get(Constants.TOTAL_2)
						.get(Constants.TRANSACTION_COUNT)
						.equals(String.valueOf(sum)));
			}

		} catch (Exception e) {

			System.out
					.println("Exception occured in CheckTotalTransactionCountDisbursements function:"
							+ e.getMessage());

		}

	}

	public void checkAccountTerminatedDuringQuarterHeaderLabel(String[] split) {

		LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, String>>> finalMap = getTransactionDetails(split);

		try {

			if (finalMap
					.containsKey(Constants.ACCOUNT_CARDS_OPEN_BLOCKED_TOTAL)) {

				Assert.assertTrue(finalMap.get(
						Constants.ACCOUNT_CARDS_OPEN_BLOCKED_TOTAL)
						.containsKey(
								Constants.ACCOUNTS_TERMINATED_DURING_QUARTER));

			}

		} catch (Exception e) {

			System.out
					.println("Exception occured in checkAccountTerminatedDuringQuarterHeaderLabel function:"
							+ e.getMessage());

		}

	}

	public void checkNewCardsOpenCount(String[] split, String databaseVal) {

		LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, String>>> finalMap = getTransactionDetails(split);

		try {

			if (finalMap
					.containsKey(Constants.ACCOUNT_CARDS_OPEN_BLOCKED_TOTAL)) {

				Assert.assertTrue(finalMap
						.get(Constants.ACCOUNT_CARDS_OPEN_BLOCKED_TOTAL)
						.get(Constants.NEW_CARDS).get(Constants.OPEN)
						.equals(databaseVal));

			}

		} catch (Exception e) {

			System.out
					.println("Exception occured in checkNewCardsOpenCount function:"
							+ e.getMessage());

		}

	}

}