package br.com.caellum.vagas.garage.find;

import java.util.List;

import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.caellum.vagas.shared.Garage;

interface GarageFindRepository extends MongoRepository<Garage, String> {
	
	List<Garage> findByLocationNear(Point center, Distance distance);
	
	List<Garage> findByUserId(String userId);
}
