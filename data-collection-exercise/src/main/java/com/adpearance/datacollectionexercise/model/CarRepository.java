package com.adpearance.datacollectionexercise.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {

	List<Car> findByMake(String make);

}
