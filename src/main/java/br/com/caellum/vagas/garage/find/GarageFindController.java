package br.com.caellum.vagas.garage.find;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.created;

import br.com.caellum.vagas.shared.Garage;
import br.com.caellum.vagas.shared.Location;

@RestController
class GarageFindController {
	
	private final GarageFindService service;

	GarageFindController(GarageFindService service) {
		this.service = service;
	}

	@GetMapping("/garages/{longitude}/{latitude}/{maxDistance}")
	@ResponseBody
	ResponseEntity<?> findGarages(@PathVariable Double longitude,
								  @PathVariable Double latitude,
								  @PathVariable Double maxDistance) {
		Location location = new Location(longitude, latitude);
		List<Garage> garage = service.findGaragesBy(location, maxDistance);
		return ResponseEntity.ok(garage);
	}
}
