package com.rental.rental_price_backend.service;

import com.rental.rental_price_backend.model.property;
import org.springframework.stereotype.Service;

@Service
public class PredictionService {

	public double predictRent(property property, String algorithm) {
		switch (algorithm.toLowerCase()) {
			case "linear":
				return property.getSize() * 1.5 + property.getBhk() * 1000;
			case "tree":
				return property.getSize() * 1.8 + property.getBathroom() * 800;
			case "forest":
				return property.getSize() * 2.0 + property.getBathroom() * 1000;
			default:
				return 0;
		}
	}
}
