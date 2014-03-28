/**
 * 
 */
package edu.zju.bme.geo.soft;

import java.util.HashMap;

/**
 * @author syc
 *
 */
public class Platform {

	public String catalog_number;
	public String coating;
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
	public String contact_zip_or_postal_code;
	public String contributor;
	public String data_row_count;
	public String description;
	public String distribution;
	public String geo_accession;
	public String last_update_protocol;
	public String manufacturer_protocol;
	public String manufacturer;
	public String organism;
	public String pubmed_id;
	public String sample_id;
	public String series_id;
	public String status;
	public String submission_date;
	public String supplementary_file;
	public String support;
	public String table;
	public String taxid;
	public String technology;
	public String title;
	public String web_link;
	private HashMap<String, String> gpl=new HashMap<>();
	
	public HashMap<String, String> getGpl(){
		gpl.put("catalog_number", catalog_number);
		gpl.put("coating", coating);
		gpl.put("contact_address", contact_address);
		gpl.put("contact_city", contact_city);
		gpl.put("contact_country", contact_country);
		gpl.put("contact_department", contact_department);
		gpl.put("contact_email", contact_email);
		gpl.put("contact_fax", contact_fax);
		gpl.put("contact_institute", contact_institute);
		gpl.put("contact_laboratory", contact_laboratory);
		gpl.put("contact_name", contact_name);
		gpl.put("contact_phone", contact_phone);
		gpl.put("contact_state", contact_state);
		gpl.put("contact_zip_or_postal_code", contact_zip_or_postal_code);
		gpl.put("contributor", contributor);
		gpl.put("data_row_count", data_row_count);
		gpl.put("description", description);
		gpl.put("distribution", distribution);
		gpl.put("geo_accession", geo_accession);
		gpl.put("ast_update_protocol", last_update_protocol);
		gpl.put("manufacturer_protocol", manufacturer_protocol);
		gpl.put("manufacturer", manufacturer);
		gpl.put("organism", organism);
		gpl.put("pubmed_id", pubmed_id);
		gpl.put("sample_id", sample_id);
		gpl.put("series_id", series_id);
		gpl.put("status", status);
		gpl.put("submission_date", submission_date);
		gpl.put("supplementary_file", supplementary_file);
		gpl.put("support", support);
		gpl.put("table", table);
		gpl.put("taxid", taxid);
		gpl.put("technology", technology);
		gpl.put("title", title);
		gpl.put("web_link", web_link);
		return gpl;
	}
	
	public void getData(HashMap<String, String> hm){
		for(String s:hm.keySet()){
			if(s.endsWith("catalog_number")){
				catalog_number=hm.get(s);
			}
			if(s.endsWith("coating")){
				coating=hm.get(s);
			}
			if(s.endsWith("contact_address")){
				contact_address=hm.get(s);
			}
			if(s.endsWith("contact_city")){
				contact_city=hm.get(s);
			}
			if(s.endsWith("contact_country")){
				contact_country=hm.get(s);
			}
			if(s.endsWith("contact_department")){
				contact_department=hm.get(s);
			}
			if(s.endsWith("contact_email")){
				contact_email=hm.get(s);
			}
			if(s.endsWith("contact_fax")){
				contact_fax=hm.get(s);
			}
			if(s.endsWith("contact_institute")){
				contact_institute=hm.get(s);
			}
			if(s.endsWith("contact_laboratory")){
				contact_laboratory=hm.get(s);
			}
			if(s.endsWith("contact_name")){
				contact_name=hm.get(s);
			}
			if(s.endsWith("contact_phone")){
				contact_phone=hm.get(s);
			}
			if(s.endsWith("contact_state")){
				contact_state=hm.get(s);
			}
			if(s.endsWith("postal_code")){
				contact_zip_or_postal_code=hm.get(s);
			}
			if(s.endsWith("contributor")){
				contributor=hm.get(s);
			}
			if(s.endsWith("data_row_count")){
				data_row_count=hm.get(s);
			}if(s.endsWith("description")){
				description=hm.get(s);
			}
			if(s.endsWith("distribution")){
				distribution=hm.get(s);
			}
			if(s.endsWith("geo_accession")){
				geo_accession=hm.get(s);
			}
			if(s.endsWith("last_update_protocol")){
				last_update_protocol=hm.get(s);
			}
			if(s.endsWith("manufacturer_protocol")){
				manufacturer_protocol=hm.get(s);
			}
			if(s.endsWith("manufacturer")){
				manufacturer=hm.get(s);
			}
			if(s.endsWith("organism")){
				organism=hm.get(s);
			}
			if(s.endsWith("pubmed_id")){
				pubmed_id=hm.get(s);
			}if(s.endsWith("sample_id")){
				sample_id=hm.get(s);
			}
			if(s.endsWith("series_id")){
				series_id=hm.get(s);
			}
			if(s.endsWith("status")){
				status=hm.get(s);
			}
			if(s.endsWith("submission_date")){
				submission_date=hm.get(s);
			}
			if(s.endsWith("supplementary_file")){
				supplementary_file=hm.get(s);
			}
			if(s.endsWith("support")){
				support=hm.get(s);
			}
			if(s.endsWith("table")){
				table=hm.get(s);
			}
			if(s.endsWith("taxid")){
				taxid=hm.get(s);
			}
			if(s.endsWith("technology")){
				technology=hm.get(s);
			}
			if(s.endsWith("title")){
				title=hm.get(s);
			}
			if(s.endsWith("web_link")){
				web_link=hm.get(s);
			}
		}
	}
}
