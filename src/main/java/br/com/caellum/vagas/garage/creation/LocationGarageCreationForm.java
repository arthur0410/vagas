package br.com.caellum.vagas.garage.creation;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class LocationGarageCreationForm {

	@NotNull
	@Pattern(regexp = "^(\\\\+|-)?(?:180(?:(?:\\\\.0{1,6})?)|(?:[0-9]|[1-9][0-9]|1[0-7][0-9])(?:(?:\\\\.[0-9]{1,6})?))$")
	private Double longitude;
	
	@NotNull
	@Pattern(regexp = "^(\\\\+|-)?(?:90(?:(?:\\\\.0{1,6})?)|(?:[0-9]|[1-8][0-9])(?:(?:\\\\.[0-9]{1,6})?))$")
	private Double latitude;

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
}
