package com.eplapp.model;

import org.json.simple.JSONObject;

public class ClubBuilder {
	private String id;
	private String clubName;
	private String key;
	
	public ClubBuilder(String id, String clubName, String key) {
		
		this.id= id;
		this.clubName = clubName;
		this.key = key;
				
	}
	
	
	public String createClubBody() {
		JSONObject json = new JSONObject();
		json.put("id",id);
		json.put("name",clubName);
		json.put("key",key);
		return json.toString();
		
	}
	
	

}
