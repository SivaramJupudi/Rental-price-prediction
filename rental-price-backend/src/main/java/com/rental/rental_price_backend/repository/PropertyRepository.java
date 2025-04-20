package com.rental.rental_price_backend.repository;


import com.rental.rental_price_backend.model.property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<property, Long> {
}
