package br.com.caellum.vagas.garage.find;

import java.util.List;

//import org.springframework.data.geo.Distance;
//import org.springframework.data.geo.Point;
//import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.caellum.vagas.shared.Garage;
import br.com.caellum.vagas.shared.Location;

//interface GarageFindRepository extends MongoRepository<Garage, String> {
interface GarageFindRepository {

	Garage findById(String id);
	
	List<Garage> findByLocationNear(Location location, Double maxDistance);
	
	List<Garage> findByUserId(String userId);
}
