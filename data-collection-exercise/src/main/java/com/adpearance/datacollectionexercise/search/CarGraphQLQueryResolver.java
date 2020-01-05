package com.adpearance.datacollectionexercise.search;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.adpearance.datacollectionexercise.model.Car;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

@Component
public class CarGraphQLQueryResolver implements GraphQLQueryResolver {
	public List<Car> searchCars() throws Exception {
		
		// TODO Use JPA to query cars
		
		// Replace with actual list of cars
		return new ArrayList<Car>();
	}
}
