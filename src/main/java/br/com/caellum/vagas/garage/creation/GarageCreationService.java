package br.com.caellum.vagas.garage.creation;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import br.com.caellum.vagas.shared.Garage;

@Service
class GarageCreationService {
	
	private final Converter<GarageCreationForm, Garage> converter;
	private final GarageCreationRepository repository;
	
	public GarageCreationService(Converter<GarageCreationForm, Garage> converter, GarageCreationRepository repository) {
		this.converter = converter;
		this.repository = repository;
	}

	String createGarageBy(GarageCreationForm form) {
		Garage garage = converter.convert(form);
		repository.save(garage);
		return garage.getGarageId();
	}

}
