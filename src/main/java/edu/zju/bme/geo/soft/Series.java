/**
 * 
 */
package edu.zju.bme.geo.soft;

import java.util.HashMap;

/**
 * @author syc
 *
 */
public class Series {

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
	public String geo_accession;
	public String last_update_date;
	public String overall_design;
	public String platform_id;
	public String platform_organism;
	public String platform_taxid;
	public String pubmed_id;
	public String relation;
	public String repeats;
	public String repeats_sample_list;
	public String sample_id;
	public String sample_organism;
	public String sample_taxid;
	public String status;
	public String submission_date;
	public String summary;
	public String supplementary_file;
	public String title;
	public String type;
	public String variable;
	public String variable_description;
	public String variable_sample_list;
	
	private HashMap<String, String> gse=new HashMap<String, String>();
	
	public HashMap<String, String> getGse(){
		gse.put("contact_address", contact_address);
		gse.put("contact_city", contact_city);
		gse.put("contact_country", contact_country);
		gse.put("contact_department", contact_department);
		gse.put("contact_email", contact_email);
		gse.put("contact_fax", contact_fax);
		gse.put("contact_institute", contact_institute);
		gse.put("contact_laboratory", contact_laboratory);
		gse.put("contact_name", contact_name);
		gse.put("contact_phone", contact_phone);
		gse.put("contact_state", contact_state);
		gse.put("contact_zip_or_postal_code", contact_zip_or_postal_code);
		gse.put("contributor", contributor);
		gse.put("geo_accession", geo_accession);
		gse.put("last_update_date", last_update_date);
		gse.put("overall_design", overall_design);
		gse.put("platform_id", platform_id);
		gse.put("platform_organism", platform_organism);
		gse.put("platform_taxid", platform_taxid);
		gse.put("pubmed_id", pubmed_id);
		gse.put("relation", relation);
		gse.put("repeats", repeats);
		gse.put("repeats_sample_list", repeats_sample_list);
		gse.put("sample_id", sample_id);
		gse.put("sample_organism", sample_organism);
		gse.put("sample_taxid", sample_taxid);
		gse.put("status", status);
		gse.put("submission_date", submission_date);
		gse.put("summary", summary);
		gse.put("supplementary_file", supplementary_file);
		gse.put("title", title);
		gse.put("type", type);
		gse.put("variable", variable);
		gse.put("variable_description", variable_description);
		gse.put("variable_sample_list", variable_sample_list);
		return gse;
	}
	
	public void getData(HashMap<String, String> hm){
		for(String s:hm.keySet()){

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
			if(s.endsWith("geo_accession")){
				geo_accession=hm.get(s);
			}
			if(s.endsWith("last_update_date")){
				last_update_date=hm.get(s);
			}
			if(s.endsWith("overall_design")){
				overall_design=hm.get(s);
			}
			if(s.endsWith("platform_id")){
				platform_id=hm.get(s);
			}
			if(s.endsWith("platform_organism")){
				platform_organism=hm.get(s);
			}
			if(s.endsWith("platform_taxid")){
				platform_taxid=hm.get(s);
			}
			if(s.endsWith("pubmed_id")){
				pubmed_id=hm.get(s);
			}
			if(s.endsWith("relation")){
				relation=hm.get(s);
			}
			if(s.endsWith("repeats")){
				repeats=hm.get(s);
			}
			if(s.endsWith("repeats_sample_list")){
				repeats_sample_list=hm.get(s);
			}
			if(s.endsWith("sample_id")){
				sample_id=hm.get(s);
			}
			if(s.endsWith("sample_organism")){
				sample_organism=hm.get(s);
			}
			if(s.endsWith("sample_taxid")){
				sample_taxid=hm.get(s);
			}
			if(s.endsWith("status")){
				status=hm.get(s);
			}
			if(s.endsWith("submission_date")){
				submission_date=hm.get(s);
			}
			if(s.endsWith("summary")){
				summary=hm.get(s);
			}
			if(s.endsWith("supplementary_file")){
				supplementary_file=hm.get(s);
			}
			if(s.endsWith("title")){
				title=hm.get(s);
			}
			if(s.endsWith("type")){
				type=hm.get(s);
			}
			if(s.endsWith("variable")){
				variable=hm.get(s);
			}
			if(s.endsWith("variable_description")){
				variable_description=hm.get(s);
			}
			if(s.endsWith("variable_sample_list")){
				variable_sample_list=hm.get(s);
			}
		}
	}
}
