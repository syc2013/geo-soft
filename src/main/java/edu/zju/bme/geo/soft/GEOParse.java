/**
 * 
 */
package edu.zju.bme.geo.soft;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @author syc
 * 
 */
public class GEOParse {

	private String geoFlag = "";

	private boolean tableFlag = false;

	private HashMap<Platform, String> mapPlatform = new HashMap<Platform, String>();

	private HashMap<Sample, String> mapSample = new HashMap<Sample, String>();

	private HashMap<Series, String> mapSeries = new HashMap<Series, String>();

	private HashMap<String, String> m = new HashMap<String, String>();

	private StringBuffer table = new StringBuffer();

	util u = new util();

	public HashMap<Platform, String> getMapPlatForm() {
		return mapPlatform;
	}

	public HashMap<Sample, String> getMapSample() {
		return mapSample;
	}

	public HashMap<Series, String> getMapSeries() {
		return mapSeries;
	}

	public void parseFile(File file) throws IOException {
		FileInputStream fis = new FileInputStream(file);
		BufferedReader br = null;
		br = new BufferedReader(new InputStreamReader(fis, "UTF-8"));
		if (br != null) {
			String data = br.readLine();
			while (data != null) {
				parseSingleLine(data);
				data = br.readLine();
			}
			br.close();
		}
		if (m.size() != 0) {
			switch (geoFlag) {
			case "GPL":
				Platform pf = new Platform();
				pf.getData(m);
				mapPlatform.put(pf, geoFlag);
				break;
			case "GSM":
				Sample sm = new Sample();
				sm.getData(m);
				mapSample.put(sm, geoFlag);
				break;
			case "GSE":
				Series se = new Series();
				se.getData(m);
				mapSeries.put(se, geoFlag);
				break;
			}
		}
		System.out.println(mapPlatform.keySet());
	}

	public void parseSingleLine(String str) {
		String attribute = "", value = "", temp = "";
		StringTokenizer st = new StringTokenizer(str);
		temp = st.nextToken();
		temp = checkTitle(temp);
		temp = u.checkNumber(temp);
		if (u.isTitle(temp)) {
			attribute = simpleTitle(temp);
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

			if (u.getCount() == 0) {
				if (m.containsKey(attribute)) {
					value = m.get(attribute) + " " + value;
					m.put(attribute, value);
				} else if (attribute != "") {
					m.put(attribute, value);
				}
			} else {
				if (m.containsKey(attribute)) {
					value = m.get(attribute) + " " + u.getCount() + "\t"
							+ value;
					m.put(attribute, value);
				} else if (attribute != "") {
					m.put(attribute, u.getCount() + "\t" + value);
				}
			}
			u.setCount(0);
		}

		if (temp.equals("platform_table_end")) {
			tableFlag = false;
			m.put("Platform_table", table.toString());
		}
		if (temp.equals("sample_table_end")) {
			tableFlag = false;
			m.put("Sample_table", table.toString());
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

		if (temp.equals("sample_table_begin")) {
			tableFlag = true;
		}
	}

	public String checkTitle(String s) {
		String s1, s2;
		if (s.length() > 2) {
			s1 = s.substring(1, s.length());
			s2 = s.substring(2, s.length());
		} else {
			return s;
		}

		if (s1.equals("PLATFORM") || s2.equals("PLATFORM")) {
			if (m.size() != 0) {
				saveData(m, geoFlag);
				m.clear();
			}
			return geoFlag = "GPL";
		}
		if (s1.equals("SERIES") || s2.equals("SERIES")) {
			if (m.size() != 0) {
				saveData(m, geoFlag);
				m.clear();
			}
			return geoFlag = "GSE";
		}
		if (s1.equals("SAMPLE") || s2.equals("SAMPLE")) {
			if (m.size() != 0) {
				saveData(m, geoFlag);
				m.clear();
			}
			return geoFlag = "GSM";
		}
		switch (s1) {
		case "platform_table_begin":
		case "platform_table_end":
		case "sample_table_begin":
		case "sample_table_end":
			return s1;
		default:
			return s;
		}
	}

	public String simpleTitle(String str) {
		if (str.startsWith("!")) {
			str = str.substring(1, str.length());
		}
		return str;
	}
	
	public void saveData(HashMap<String, String> hm,String flag){
		switch(flag){
		case "GPL":
			Platform plat = new Platform();
			plat.getData(m);
			mapPlatform.put(plat, geoFlag);
			break;
		case "GSE":
			Series ser = new Series();
			ser.getData(m);
			mapSeries.put(ser, geoFlag);
			break;
		case "GSM":
			Sample sam = new Sample();
			sam.getData(m);
			mapSample.put(sam, geoFlag);
			break;
		}
	}
}
