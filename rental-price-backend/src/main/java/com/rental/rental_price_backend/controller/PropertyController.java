package com.rental.rental_price_backend.controller;



import com.rental.rental_price_backend.model.property;
import com.rental.rental_price_backend.repository.PropertyRepository;
import com.rental.rental_price_backend.service.PredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/properties")
@CrossOrigin("*")
public class PropertyController {

	@Autowired
	private PropertyRepository repo;

	@Autowired
	private PredictionService predictor;

	@PostMapping("/predict")
	public Map<String, Double> predict(@RequestBody property property, @RequestParam String algorithm) {
		double predictedRent = predictor.predictRent(property, algorithm);
		return Map.of("predictedRent", predictedRent);
	}

	@PostMapping("/save")
	public property save(@RequestBody property property) {
		return repo.save(property);
	}

	@GetMapping("/all")
	public List<property> all() {
		return repo.findAll();
	}

	@GetMapping("/")
	public String hello() {
		return "Backend is up!";
	}

}
