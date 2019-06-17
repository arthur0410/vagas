package br.com.caellum.vagas.garage.creation;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.caellum.vagas.shared.Location;

@Component
public class ConverterLocationGarageCreationFormToLocation implements Converter<LocationGarageCreationForm, Location> {

	@Override
	public Location convert(LocationGarageCreationForm form) {
		return new Location(form.getLongitude(), form.getLatitude());
	}

}
