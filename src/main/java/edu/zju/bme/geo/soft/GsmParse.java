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
public class GsmParse {

	private static int count = 0;

	private static Map<String, String> m = new HashMap<String, String>();

	private static StringBuffer table = new StringBuffer("\n");

	private static boolean tableFlag = false;

	static String checkNumber(String ss) {
		String temp = ss.substring(ss.length() - 1);
		String temp1 = ss.substring(0, ss.length() - 1);
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

	static String checkTitle(String t) {
		String t1 = t.substring(1, t.length());
		String t2 = t.substring(2, t.length());

		if (t2.equals("SAMPLE")) {
			return t2;
		}
		switch (t1) {
		case "sample_table_begin":
		case "sample_table_end":
			return t = t1;
		default:
			return t;
		}
	}

	static String classify(File filename) throws IOException {
		byte[] cs = new byte[3];
		InputStream is = new FileInputStream(filename);
		is.read(cs);
		is.close();
		switch (cs[0]) {
		case (byte) 0xFF:
			switch (cs[1]) {
			case (byte) 0xFE:
				return "Unicode";// utf-16
			default:
				return "ANSI";
			}
		case (byte) 0xFE:
			switch (cs[1]) {
			case (byte) 0xFF:
				return "Unicode big endian";// unicode
			default:
				return "ANSI";
			}
		case (byte) 0xEF:
			switch (cs[1]) {
			case (byte) 0xBB:
				switch (cs[2]) {
				case (byte) 0xBF:
					return "UTF-8";// utf-8
				default:
					return "ANSI";
				}
			}
		default:
			return "ANSI";// gb2312
		}
	}

	public static Map<String, String> getM() {
		return m;
	}
	static boolean isTitle(String is) {
		switch (is) {
		case "SAMPLE":
		case "!Sample_anchor":
		case "!Sample_biomaterial_provider_ch":
		case "!Sample_channel_count":
		case "!Sample_characteristics_ch":
		case "!Sample_contact_address":
		case "!Sample_contact_city":
		case "!Sample_contact_country":
		case "!Sample_contact_department":
		case "!Sample_contact_email":
		case "!Sample_contact_fax":
		case "!Sample_contact_institute":
		case "!Sample_contact_laboratory":
		case "!Sample_contact_name":
		case "!Sample_contact_phone":
		case "!Sample_contact_state":
		case "!Sample_contact_web_link":
		case "!Sample_contact_zip/postal_code":
		case "!Sample_data_processing":
		case "!Sample_data_row_count":
		case "!Sample_description":
		case "!Sample_extract_protocol_ch":
		case "!Sample_geo_accession":
		case "!Sample_growth_protocol_ch":
		case "!Sample_hyb_protocol":
		case "!Sample_label_ch":
		case "!Sample_label_protocol_ch":
		case "!Sample_last_update_date":
		case "!Sample_molecule_ch":
		case "!Sample_organism_ch":
		case "!Sample_platform_id":
		case "!Sample_scan_protocol":
		case "!Sample_series_id":
		case "!Sample_source_name_ch":
		case "!Sample_status":
		case "!Sample_submission_date":
		case "!Sample_supplementary_file":
		case "!Sample_table":
		case "!Sample_tag_count":
		case "!Sample_tag_length":
		case "!Sample_taxid_ch":
		case "!Sample_title":
		case "!Sample_treatment_protocol_ch":
		case "!Sample_type":
			return true;
		default:
			return false;
		}
	}
	public static void parseFile(File f) throws IOException {

		String attr = classify(f);
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
		String s = "", t = "", r = "";
		StringTokenizer st = new StringTokenizer(str);
		r = st.nextToken();
		r = checkTitle(r);// check item
		r = checkNumber(r);// check number suffix
		if (isTitle(r)) {
			s = title(r);
			while (st.hasMoreTokens()) {
				r = st.nextToken();
				if (!r.equals("=")) {
					if (t != "") {
						t = t + " " + r;
					} else {
						t = r;
					}
				}
			}
			if (count == 0) {
				if (m.containsKey(s)) {
					t = m.get(s) + " " + t;
					m.put(s, t);
				} else {
					m.put(s, t);
				}
			} else {
				s = s + count;
				if (m.containsKey(s)) {
					t = m.get(s) + "	" + t;
					m.put(s, t);
				} else {
					m.put(s, t);
				}
			}
		}

		if (r.equals("sample_table_end")) {
			tableFlag = false;
			m.put("Sample_table", table.toString());
		}
		if (tableFlag) {
			table.append(r);
			while (st.hasMoreTokens()) {
				r = st.nextToken();
				table.append("\t");
				table.append(r);
			}
			table.append("\n");
		}
		if (r.equals("sample_table_begin")) {
			tableFlag = true;
		}
		count = 0;
	}
	static String title(String s) {
		String temp = s.substring(1, s.length());
		switch (temp) {
		case "Sample_anchor":
		case "Sample_biomaterial_provider_ch":
		case "Sample_channel_count":
		case "Sample_characteristics_ch":
		case "Sample_contact_address":
		case "Sample_contact_city":
		case "Sample_contact_country":
		case "Sample_contact_department":
		case "Sample_contact_email":
		case "Sample_contact_fax":
		case "Sample_contact_institute":
		case "Sample_contact_laboratory":
		case "Sample_contact_name":
		case "Sample_contact_phone":
		case "Sample_contact_state":
		case "Sample_contact_web_link":
		case "Sample_contact_zip/postal_code":
		case "Sample_data_processing":
		case "Sample_data_row_count":
		case "Sample_description":
		case "Sample_extract_protocol_ch":
		case "Sample_geo_accession":
		case "Sample_growth_protocol_ch":
		case "Sample_hyb_protocol":
		case "Sample_label_ch":
		case "Sample_label_protocol_ch":
		case "Sample_last_update_date":
		case "Sample_molecule_ch":
		case "Sample_organism_ch":
		case "Sample_platform_id":
		case "Sample_scan_protocol":
		case "Sample_series_id":
		case "Sample_source_name_ch":
		case "Sample_status":
		case "Sample_submission_date":
		case "Sample_supplementary_file":
		case "Sample_table":
		case "Sample_tag_count":
		case "Sample_tag_length":
		case "Sample_taxid_ch":
		case "Sample_title":
		case "Sample_treatment_protocol_ch":
		case "Sample_type":
			return temp;
		default:
			return s;
		}
	}
}
