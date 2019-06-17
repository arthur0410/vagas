package br.com.caellum.vagas.garage.creation;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

public class GarageCreationForm {
	

	@Null
	private String userId;
	
	@NotNull
	private LocationGarageCreationForm location;
	
	public LocationGarageCreationForm getLocation() {
		return location;
	}
	public void setLocation(LocationGarageCreationForm location) {
		this.location = location;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
