package br.com.caellum.vagas.garage.find;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import br.com.caellum.vagas.shared.Garage;
import br.com.caellum.vagas.shared.Location;

@Repository
public class GarageFindRepositoryImpl implements GarageFindRepository {

	private final MongoTemplate mongoDb;
	private final ConverterLocationToPoint converter;
	
	public GarageFindRepositoryImpl(MongoTemplate mongoDb, ConverterLocationToPoint converter) {
		this.mongoDb = mongoDb;
		this.converter = converter;
	}

	@Override
	public List<Garage> findByLocationNear(Location location, Double maxDistance) {
		Point point = converter.convert(location);
		return mongoDb.find(query(where("location").near(point).maxDistance(maxDistance)), Garage.class);
	}

	@Override
	public List<Garage> findByUserId(String userId) {
		return mongoDb.find(query(where("userId").is(userId)), Garage.class);
	}

	@Override
	public Garage findById(String id) {
		return mongoDb.findById(id, Garage.class);
	}

}
