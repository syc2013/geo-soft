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
public class GplParse {

	private static String attr = "";

	public static Map<String, String> m = new HashMap<>();

	private static StringBuffer table = new StringBuffer();

	private static boolean tableFlag = false;

	static String checkTitle(String s) {
		String s1 = s.substring(1, s.length());
		String s2 = s.substring(2, s.length());

		if (attr.equals("ANSI")) {
			if (s1.equals("PLATFORM")) {
				return s1;
			} else {
				return s;
			}
		} else if (attr.equals("UTF-8")) {
			if (s2.equals("PLATFORM")) {
				return s2;
			}
		} else {
			return s;
		}

		switch (s1) {
		case "platform_table_begin":
		case "platform_table_end":
			return s1;
		default:
			return s;
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

	static Boolean isTitle(String it) {
		switch (it) {
		case "PLATFORM":
		case "!Platform_catalog_number":
		case "!Platform_coating":
		case "!Platform_contact_address":
		case "!Platform_contact_city":
		case "!Platform_contact_country":
		case "!Platform_contact_department":
		case "!Platform_contact_email":
		case "!Platform_contact_fax":
		case "!Platform_contact_institute":
		case "!Platform_contact_laboratory":
		case "!Platform_contact_name":
		case "!Platform_contact_phone":
		case "!Platform_contact_state":
		case "!Platform_contact_zip/postal_code":
		case "!Platform_contributor":
		case "!Platform_data_row_count":
		case "!Platform_description":
		case "!Platform_distribution":
		case "!Platform_geo_accession":
		case "!Platform_last_update_date":
		case "!Platform_manufacture_protocol":
		case "!Platform_manufacturer":
		case "!Platform_organism":
		case "!Platform_pubmed_id":
		case "!Platform_sample_id":
		case "!Platform_series_id":
		case "!Platform_status":
		case "!Platform_submission_date":
		case "!Platform_supplementary_file":
		case "!Platform_support":
		case "!Platform_taxid":
		case "!Platform_technology":
		case "!Platform_title":
		case "!Platform_web_link":
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
		String attribute = "", value = "", temp = "";
		StringTokenizer st = new StringTokenizer(str);
		temp = st.nextToken();
		temp = checkTitle(temp);
		if (isTitle(temp)) {
			attribute = title(temp);
			while (st.hasMoreTokens()) {
				temp = st.nextToken();
				switch (temp) {
				case "=":
					break;
				default:
					if (value == "") {
						value = temp;
					} else {
						value = value + " " + temp;
					}
					break;
				}
			}
			if (m.containsKey(attribute)) {
				value = m.get(attribute) + " " + value;
				m.put(attribute, value);
			} else if (attribute != "") {
				m.put(attribute, value);
			}
		}

		if (temp.equals("platform_table_end")) {
			tableFlag = false;
			m.put("Platform_table", table.toString());
		}
		if (tableFlag) {
			table.append("\n");
			table.append(temp);
			while (st.hasMoreTokens()) {
				temp = st.nextToken();
				table.append("\t");
				table.append(temp);
			}
			table.append("\n");
		}
		if (temp.equals("platform_table_begin")) {
			tableFlag = true;
		}

	}

	static String title(String st) {
		String temp = st.substring(1, st.length());
		switch (temp) {
		case "Platform_catalog_number":
		case "Platform_coating":
		case "Platform_contact_address":
		case "Platform_contact_city":
		case "Platform_contact_country":
		case "Platform_contact_department":
		case "Platform_contact_email":
		case "Platform_contact_fax":
		case "Platform_contact_institute":
		case "Platform_contact_laboratory":
		case "Platform_contact_name":
		case "Platform_contact_phone":
		case "Platform_contact_state":
		case "Platform_contact_zip/postal_code":
		case "Platform_contributor":
		case "Platform_data_row_count":
		case "Platform_description":
		case "Platform_distribution":
		case "Platform_geo_accession":
		case "Platform_last_update_date":
		case "Platform_manufacture_protocol":
		case "Platform_manufacturer":
		case "Platform_organism":
		case "Platform_pubmed_id":
		case "Platform_sample_id":
		case "Platform_series_id":
		case "Platform_status":
		case "Platform_submission_date":
		case "Platform_supplementary_file":
		case "Platform_support":
		case "Platform_taxid":
		case "Platform_technology":
		case "Platform_title":
		case "Platform_web_link":
			return temp;
		default:
			return st;
		}
	}

}
