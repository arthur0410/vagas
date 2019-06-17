package br.com.caellum.vagas.garage.find;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import com.mongodb.client.model.geojson.Position;

import br.com.caellum.vagas.shared.Garage;
import br.com.caellum.vagas.shared.Location;

@Service
class GarageFindService {

	private final GarageFindRepository repository;
	private final Converter<Location, Point> converter;
	
	GarageFindService(GarageFindRepository repository, Converter<Location, Point> converter) {
		this.repository = repository;
		this.converter = converter;
	}

	List<Garage> findGaragesBy(Location location, Double maxDistance) {
		Point center = converter.convert(location);
		return repository.findByLocationNear(center, new Distance(maxDistance));
	}
	
}
