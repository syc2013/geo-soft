package edu.zju.bme.geo.soft;

public class util {
	private int count;
	
	public void setCount(int i){
		count=i;
	}
	
	public int getCount(){
		return count;
	}
	
	private String[] mapString = new String[] {
			"!Sample_biomaterial_provider_ch", "!Sample_characteristics_ch",
			"!Sample_extract_protocol_ch", "!Sample_growth_protocol_ch",
			"!Sample_label_ch", "!Sample_label_protocol_ch",
			"!Sample_molecule_ch", "!Sample_organism_ch",
			"!Sample_source_name_ch", "!Sample_taxid_ch",
			"!Sample_treatment_protocol_ch", "!Series_repeats",
			"!Series_repeats_sample_list", "!Series_variable",
			"!Series_variable_description", "!Series_variable_sample_list" };
	
	public String checkNumber(String ss) {
		for (String sample : mapString) {
			if (ss.startsWith(sample)) {
				count = Integer.valueOf(ss.substring(sample.length()));
				return sample;
			}
		}
		return ss;
	}
	public Boolean isTitle(String it) {
		switch (it) {
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
		case "!Series_supplementary_file":
		case "!Series_title":
		case "!Series_type":
		case "!Series_variable":// _[n]
		case "!Series_variable_description":// _[n]
		case "!Series_variable_sample_list":// _[n]
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
}
