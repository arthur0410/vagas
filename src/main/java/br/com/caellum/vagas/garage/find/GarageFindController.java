package br.com.caellum.vagas.garage.find;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.caellum.vagas.shared.Garage;
import br.com.caellum.vagas.shared.Location;

@RestController
@RequestMapping("/garages")
class GarageFindController {
	
	private final GarageFindService service;

	GarageFindController(GarageFindService service) {
		this.service = service;
	}
	
	@GetMapping("/{id}")
	ResponseEntity<?> findGarageByGarageId(@PathVariable String id){
		Garage garage = service.findGarageByGarageId(id);
		return ResponseEntity.ok(garage);
	}
	
	@GetMapping("/user/{id}")
	ResponseEntity<?> findGaragesByUserId(@PathVariable String id){
		List<Garage> garages = service.findGaragesByUserId(id);
		return ResponseEntity.ok(garages);
	}

	@GetMapping
	@ResponseBody
	ResponseEntity<?> findGaragesByLocation(@RequestParam("lng") Double longitude,
								            @RequestParam("lat") Double latitude,
								            @RequestParam("dist") Double distance) {
		Location location = new Location(longitude, latitude);
		List<Garage> garage = service.findGaragesBy(location, distance);
		return ResponseEntity.ok(garage);
	}
}
