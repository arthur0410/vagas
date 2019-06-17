package br.com.caellum.vagas.garage.creation;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.caellum.vagas.shared.Garage;
import br.com.caellum.vagas.shared.Location;

@Component
public class ConverterGarageCreationFormToGarage implements Converter<GarageCreationForm, Garage> {

	private final Converter<LocationGarageCreationForm, Location> converter;
	
	public ConverterGarageCreationFormToGarage(ConverterLocationGarageCreationFormToLocation converter) {
		this.converter = converter;
	}

	@Override
	public Garage convert(GarageCreationForm form) {
		Location location = converter.convert(form.getLocation());
		return new Garage(form.getUserId(), location);
	}

}
