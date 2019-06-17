package br.com.caellum.vagas.garage.creation;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import static org.springframework.http.ResponseEntity.created;

import java.net.URI;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("garage")
class GarageCreationController {

	private final GarageCreationService service;

	GarageCreationController(GarageCreationService service) {
		this.service = service;
	}
	@PostMapping
	ResponseEntity<?> createGarage(@RequestHeader("Authorization") String authorization, 
								   @Valid @RequestBody GarageCreationForm form, 
								   UriComponentsBuilder uriBuilder) {
		form.setUserId(authorization);
		String garageId = service.createGarageBy(form);
		URI uri = uriBuilder.path("/garages/{id}").build(garageId);;
		return created(uri).build();
	}
	
}
