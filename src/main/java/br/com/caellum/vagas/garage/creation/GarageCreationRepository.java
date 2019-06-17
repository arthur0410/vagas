package br.com.caellum.vagas.garage.creation;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.caellum.vagas.shared.Garage;

@Repository
public interface GarageCreationRepository extends MongoRepository<Garage, Long> {

}
