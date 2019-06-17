package br.com.caellum.vagas.garage.find;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Component;


import br.com.caellum.vagas.shared.Location;

@Component
public class ConverterLocationToPoint implements Converter<Location, Point> {

	@Override
	public Point convert(Location location) {
		return new Point(location.getLongitude(), location.getLatitude());
	}

}
