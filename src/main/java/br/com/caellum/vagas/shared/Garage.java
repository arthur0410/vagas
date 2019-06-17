package br.com.caellum.vagas.shared;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Garage {
	
	@Id
	private String garageId;
	
	private String userId;
	
	private Location location;
	
	public Garage(String userId, Location location) {
		this.userId = userId;
		this.location = location;
	}

	public String getGarageId() {
		return garageId;
	}

	public void setGarageId(String garageId) {
		this.garageId = garageId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
}
