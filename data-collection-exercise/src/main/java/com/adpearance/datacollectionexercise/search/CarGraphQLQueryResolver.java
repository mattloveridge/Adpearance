package com.adpearance.datacollectionexercise.search;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adpearance.datacollectionexercise.model.Car;
import com.adpearance.datacollectionexercise.model.CarRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

@Component
public class CarGraphQLQueryResolver implements GraphQLQueryResolver {

	@Autowired
	private CarRepository repository;
	
	public List<Car> searchCars() throws Exception {
	
			List<Car> listOfCar;
			
			listOfCar = repository.findAll();
			
			return listOfCar;
	}
	
	public List<Car> searchCars(String make) throws Exception {
	
		List<Car> listOfCar;
		
		listOfCar = repository.findByMake( make );
		
		return listOfCar;
	}
}
