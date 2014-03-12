/**
 * 
 */
package edu.zju.bme.geo.soft;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @author syc
 * 
 */
public class GseParse {

	private static String attr = "";

	private static int count = 0;

	private static Map<String, String> m = new HashMap<String, String>();

	static String checkNumber(String ss) {
		String temp = "", temp1 = "";
		temp = ss.substring(ss.length() - 1);
		temp1 = ss.substring(0, ss.length() - 1);
		switch (temp) {
		case "1":
			count = 1;
			return temp1;
		case "2":
			count = 2;
			return temp1;
		case "3":
			count = 3;
			return temp1;
		case "4":
			count = 4;
			return temp1;
		case "5":
			count = 5;
			return temp1;
		case "6":
			count = 6;
			return temp1;
		case "7":
			count = 7;
			return temp1;
		case "8":
			count = 8;
			return temp1;
		case "9":
			count = 9;
			return temp1;
		default:
			return ss;
		}
	}

	/**
	 * ^ in ANSI is 1,but in UTF-8 is 3
	 */
	static String checktitle(String t) {
		String t1, t2 = "";
		t1 = t.substring(1, t.length());
		t2 = t.substring(2, t.length());
		if (attr.equals("ANSI")) {
			if (t1.equals("SERIES")) {
				return t1;
			} else {
				return t;
			}
		} else if (attr.equals("UTF-8")) {
			if (t2.equals("SERIES")) {
				return t2;
			} else {
				return t;
			}
		} else {
			return t;
		}
	}

	static String classify(File f) throws IOException {
		InputStream is = new FileInputStream(f);
		byte[] cs = new byte[3];
		is.read(cs);
		is.close();
		if (cs[0] == (byte) 0xFF && cs[1] == (byte) 0xFE) {
			return "Unicode";
		} else if (cs[0] == (byte) 0xFE && cs[1] == (byte) 0xFF) {
			return "Unicode big endian";
		} else if (cs[0] == (byte) 0xEF && cs[1] == (byte) 0xBB
				&& cs[2] == (byte) 0xBF) {
			return "UTF-8";
		} else {
			return "ANSI";
		}
	}

	public static Map<String, String> getM() {
		return m;
	}

	static boolean isTitle(String it) {
		switch (it) {
		case "SERIES":
		case "!Series_contact_address":
		case "!Series_contact_city":
		case "!Series_contact_country":
		case "!Series_contact_department":
		case "!Series_contact_email":
		case "!Series_contact_fax":
		case "!Series_contact_institute":
		case "!Series_contact_laboratory":
		case "!Series_contact_name":
		case "!Series_contact_phone":
		case "!Series_contact_state":
		case "!Series_contact_zip/postal_code":
		case "!Series_contributor":
		case "!Series_geo_accession":
		case "!Series_last_update_date":
		case "!Series_overall_design":
		case "!Series_platform_id":
		case "!Series_platform_organism":
		case "!Series_platform_taxid":
		case "!Series_pubmed_id":
		case "!Series_relation":
		case "!Series_repeats":// _[n]
		case "!Series_repeats_sample_list":// _[n]
		case "!Series_sample_id":
		case "!Series_sample_organism":
		case "!Series_sample_taxid":
		case "!Series_status":
		case "!Series_submission_date":
		case "!Series_summary":
		case "!Series_title":
		case "!Series_type":
		case "!Series_variable":// _[n]
		case "!Series_variable_description":// _[n]
		case "!Series_variable_sample_list":// _[n]
			return true;
		default:
			return false;
		}
	}

	public static void parseFile(File f) throws IOException {
		attr = classify(f);
		FileInputStream fis = new FileInputStream(f);
		BufferedReader br = null;

		if (attr.equals("ANSI")) {
			br = new BufferedReader(new InputStreamReader(fis));
		} else {
			br = new BufferedReader(new InputStreamReader(fis, attr));
		}

		if (br != null) {
			String data = br.readLine();
			while (data != null) {
				parseSingleLine(data);
				data = br.readLine();
			}
			br.close();
		}
	}

	static void parseSingleLine(String str) {
		String s = "", r = "";
		StringBuffer sb = new StringBuffer();
		StringBuffer bs = new StringBuffer();
		StringTokenizer st = new StringTokenizer(str);
		r = st.nextToken();
		r = checktitle(r);
		r = checkNumber(r);
		if (isTitle(r)) {
			s = title(r);
			while (st.hasMoreTokens()) {
				r = st.nextToken();
				if (!r.equals("=")) {
					if (sb.toString().equals("")) {
						sb.append(" ");
						sb.append(r);
					} else {
						sb.append(" ");
						sb.append(r);
					}
				}
			}
			if (count == 0) {
				if (m.containsKey(s)) {
					bs.append(m.get(s));
					bs.append(" ");
					bs.append(sb.toString());
					m.put(s, bs.toString());
				} else {
					sb.append("\n");
					m.put(s, sb.toString());
				}
			} else {
				s = s + count;
				if (m.containsKey(s)) {
					bs.append(m.get(s));
					bs.append(" ");
					bs.append(sb.toString());
					m.put(s, bs.toString());
				} else {
					sb.append("\n");
					m.put(s, sb.toString());
				}
			}
		}
		sb.setLength(0);
		bs.setLength(0);
		count = 0;
	}

	static String title(String st) {
		String temp = st.substring(1, st.length());
		switch (temp) {
		case "Series_contact_address":
		case "Series_contact_city":
		case "Series_contact_country":
		case "Series_contact_department":
		case "Series_contact_email":
		case "Series_contact_fax":
		case "Series_contact_institute":
		case "Series_contact_laboratory":
		case "Series_contact_name":
		case "Series_contact_phone":
		case "Series_contact_state":
		case "Series_contact_zip/postal_code":
		case "Series_contributor":
		case "Series_geo_accession":
		case "Series_last_update_date":
		case "Series_overall_design":
		case "Series_platform_id":
		case "Series_platform_organism":
		case "Series_platform_taxid":
		case "Series_pubmed_id":
		case "Series_relation":
		case "Series_repeats":
		case "Series_repeats_sample_list":
		case "Series_sample_id":
		case "Series_sample_organism":
		case "Series_sample_taxid":
		case "Series_status":
		case "Series_submission_date":
		case "Series_summary":
		case "Series_title":
		case "Series_type":
		case "Series_variable":
		case "Series_variable_description":
		case "Series_variable_sample_list":
			return temp;
		default:
			return st;
		}
	}

}
