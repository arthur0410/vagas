package br.com.caellum.vagas.garage.find;

import java.util.List;
import org.springframework.stereotype.Service;

import br.com.caellum.vagas.shared.Garage;
import br.com.caellum.vagas.shared.Location;

@Service
class GarageFindService {

	private final GarageFindRepository repository;
	
	public GarageFindService(GarageFindRepository repository) {
		this.repository = repository;
	}

	Garage findGarageByGarageId(String id) {
		return repository.findById(id);
	}
	
	List<Garage> findGaragesByUserId(String userId) {
		return repository.findByUserId(userId);
	}
	
	List<Garage> findGaragesBy(Location location, Double maxDistance) {
		return repository.findByLocationNear(location, maxDistance);
	}
	
}
