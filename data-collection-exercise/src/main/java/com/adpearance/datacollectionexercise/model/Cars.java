package com.adpearance.datacollectionexercise.model;

import java.util.LinkedList;
import java.util.List;

public class Cars {

	private List<Car> cars;

	public Cars() {this.cars = new LinkedList<Car>();}
	
	public void addCar(Car car) {this.cars.add(car);}
	
	public List<Car> getCars() {return cars;}

	public void setCars(List<Car> cars) {this.cars = cars;}
	
}
