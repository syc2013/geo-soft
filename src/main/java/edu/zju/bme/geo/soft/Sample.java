/**
 * 
 */
package edu.zju.bme.geo.soft;

import java.util.HashMap;

/**
 * @author syc
 * 
 */
public class Sample {

	public String anchor;
	public String biomaterial_provider_ch;
	public String channel_count;
	public String characteristics_ch;
	public String contact_address;
	public String contact_city;
	public String contact_country;
	public String contact_department;
	public String contact_email;
	public String contact_fax;
	public String contact_institute;
	public String contact_laboratory;
	public String contact_name;
	public String contact_phone;
	public String contact_state;
	public String contact_web_link;
	public String contact_zip_or_postal_code;
	public String data_processing;
	public String data_row_count;
	public String description;
	public String extract_protocol;
	public String geo_accession;
	public String growth_protocol;
	public String hyb_protocol;
	public String label_ch;
	public String label_protocol_ch;
	public String last_update_date;
	public String molecule_ch;
	public String organism_ch;
	public String platform_id;
	public String scan_protocol;
	public String series_id;
	public String source_name_ch;
	public String status;
	public String submission_date;
	public String supplementary_file;
	public String table;
	public String tag_count;
	public String tag_length;
	public String taxid_ch;
	public String title;
	public String treatment_protocol_ch;
	public String type;

	private HashMap<String, String> gsm = new HashMap<String, String>();
	
	public HashMap<String, String> getGsm(){
		gsm.put("anchor", anchor);
		gsm.put("biomaterial_provider_ch", biomaterial_provider_ch);
		gsm.put("channel_count", channel_count);
		gsm.put("characteristics_ch", characteristics_ch);
		gsm.put("contact_address", contact_address);
		gsm.put("contact_city", contact_city);
		gsm.put("contact_country", contact_country);
		gsm.put("contact_department", contact_department);
		gsm.put("contact_email", contact_email);
		gsm.put("contact_fax", contact_fax);
		gsm.put("contact_institute", contact_institute);
		gsm.put("contact_laboratory", contact_laboratory);
		gsm.put("contact_name", contact_name);
		gsm.put("contact_phone", contact_phone);
		gsm.put("contact_state", contact_state);
		gsm.put("contact_web_link", contact_web_link);
		gsm.put("contact_zip_or_postal_code", contact_zip_or_postal_code);
		gsm.put("data_processing", data_processing);
		gsm.put("data_row_count", data_row_count);
		gsm.put("description", description);
		gsm.put("extract_protocol", extract_protocol);
		gsm.put("geo_accession", geo_accession);
		gsm.put("growth_protocol", growth_protocol);
		gsm.put("hyb_protocol", hyb_protocol);
		gsm.put("label_ch", label_ch);
		gsm.put("label_protocol_ch", label_protocol_ch);
		gsm.put("last_update_date", last_update_date);
		gsm.put("molecule_ch", molecule_ch);
		gsm.put("organism_ch", organism_ch);
		gsm.put("platform_id", platform_id);
		gsm.put("scan_protocol", scan_protocol);
		gsm.put("series_id", series_id);
		gsm.put("source_name_ch", source_name_ch);
		gsm.put("status", status);
		gsm.put("submission_date", submission_date);
		gsm.put("supplementary_file", supplementary_file);
		gsm.put("table", table);
		gsm.put("tag_count", tag_count);
		gsm.put("tag_length", tag_length);
		gsm.put("taxid_ch", taxid_ch);
		gsm.put("title", title);
		gsm.put("treatment_protocol_ch", treatment_protocol_ch);
		gsm.put("type", type);
		return gsm;
	}

	public void getData(HashMap<String, String> hm) {
		for (String s : hm.keySet()) {
			if (s.endsWith("anchor")) {
				anchor = hm.get(s);
			}
			if (s.endsWith("biomaterial_provider_ch")) {
				biomaterial_provider_ch = hm.get(s);
			}
			if (s.endsWith("channel_count")) {
				channel_count = hm.get(s);
			}
			if (s.endsWith("characteristics_ch")) {
				characteristics_ch = hm.get(s);
			}
			if (s.endsWith("contact_address")) {
				contact_address = hm.get(s);
			}
			if (s.endsWith("contact_city")) {
				contact_city = hm.get(s);
			}
			if (s.endsWith("contact_country")) {
				contact_country = hm.get(s);
			}
			if (s.endsWith("contact_department")) {
				contact_department = hm.get(s);
			}
			if (s.endsWith("contact_email")) {
				contact_email = hm.get(s);
			}
			if (s.endsWith("contact_fax")) {
				contact_fax = hm.get(s);
			}
			if (s.endsWith("contact_institute")) {
				contact_institute = hm.get(s);
			}
			if (s.endsWith("contact_laboratory")) {
				contact_laboratory = hm.get(s);
			}
			if (s.endsWith("contact_name")) {
				contact_name = hm.get(s);
			}
			if (s.endsWith("contact_phone")) {
				contact_phone = hm.get(s);
			}
			if (s.endsWith("contact_state")) {
				contact_state = hm.get(s);
			}
			if (s.endsWith("postal_code")) {
				contact_zip_or_postal_code = hm.get(s);
			}
			if (s.endsWith("data_processing")) {
				data_processing = hm.get(s);
			}
			if (s.endsWith("data_row_count")) {
				data_row_count = hm.get(s);
			}
			if (s.endsWith("description")) {
				description = hm.get(s);
			}
			if (s.endsWith("extract_protocol")) {
				extract_protocol = hm.get(s);
			}
			if (s.endsWith("geo_accession")) {
				geo_accession = hm.get(s);
			}
			if (s.endsWith("growth_protocol")) {
				growth_protocol = hm.get(s);
			}
			if (s.endsWith("hyb_protocol")) {
				hyb_protocol = hm.get(s);
			}
			if (s.endsWith("label_ch")) {
				label_ch = hm.get(s);
			}
			if (s.endsWith("label_protocol_ch")) {
				label_protocol_ch = hm.get(s);
			}
			if (s.endsWith("last_update_date")) {
				last_update_date = hm.get(s);
			}
			if (s.endsWith("molecule_ch")) {
				molecule_ch = hm.get(s);
			}
			if (s.endsWith("organism_ch")) {
				organism_ch = hm.get(s);
			}
			if (s.endsWith("platform_id")) {
				platform_id = hm.get(s);
			}
			if (s.endsWith("scan_protocol")) {
				scan_protocol = hm.get(s);
			}
			if (s.endsWith("series_id")) {
				series_id = hm.get(s);
			}
			if (s.endsWith("source_name_ch")) {
				source_name_ch = hm.get(s);
			}
			if (s.endsWith("status")) {
				status = hm.get(s);
			}
			if (s.endsWith("submission_date")) {
				submission_date = hm.get(s);
			}
			if (s.endsWith("supplementary_file")) {
				supplementary_file = hm.get(s);
			}
			if (s.endsWith("table")) {
				table = hm.get(s);
			}
			if (s.endsWith("tag_count")) {
				tag_count = hm.get(s);
			}
			if (s.endsWith("tag_length")) {
				tag_length = hm.get(s);
			}
			if (s.endsWith("taxid_ch")) {
				taxid_ch = hm.get(s);
			}
			if (s.endsWith("title")) {
				title = hm.get(s);
			}
			if (s.endsWith("treatment_protocol_ch")) {
				treatment_protocol_ch = hm.get(s);
			}
			if (s.endsWith("type")) {
				type = hm.get(s);
			}
		}
	}
}
