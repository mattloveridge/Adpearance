package com.adpearance.datacollectionexercise.service;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adpearance.datacollectionexercise.model.Car;
import com.adpearance.datacollectionexercise.model.CarRepository;
import com.adpearance.datacollectionexercise.model.Cars;

@Service
public class ImportService {

	@Autowired
	private CarRepository repository;
	
	public void execute(String clientWebsiteUrl) throws Exception {

		// TODO have this be an input that the caller can specify

		repository.deleteAll();
		System.out.println("Deleted all the records in the car table");
		
		Cars cars = new Cars();

		getCars(cars, clientWebsiteUrl);
		
		saveCars(cars);
	}
	
	private void saveCars(Cars cars) {

		for(Car car : cars.getCars()) {
			repository.save(car);
		}

      // fetch all Cars
      System.out.println("Cars found with findAll():");
      System.out.println("-------------------------------");
      for (Car Car : repository.findAll()) {
    	  System.out.println(Car.getVin());
    	  System.out.println(Car.getMake());
    	  System.out.println(Car.getModel());
    	  System.out.println(Car.getYear());
    	  System.out.println(Car.getVdpUrl());
    	  System.out.println(Car.getImageUrl());
    	  System.out.println(Car.getPrice());
    	  System.out.println(Car.getMsrp());
    	  System.out.println();
      }  
    }
	
	private void getCars(Cars cars, String clientWebSiteUrlPrefix) throws Exception {

		int webSitePageNumber = 2;

		final String DOT_HTML = ".html",
				DASH = "-",
				HTTP_ERROR_FETCHING_URL = "HTTP error fetching URL",
				BASE_URL = "http://exercise.fourbot.io/",
				UNKNOWN_EXCEPTION_EQUAL = "Unknown Exception = ";
		
		String url = null;
		
		Connection.Response response = Jsoup.connect(clientWebSiteUrlPrefix + DOT_HTML).execute();

		Document document = response.parse();
		
		Elements elementsCol12InventoryListing = document.getElementsByClass("col-12 inventory_listing");

		while( true ) {
			for (Element elementInventoryListing : elementsCol12InventoryListing) {
				Car car = new Car();
				car.setVin(elementInventoryListing.attr("data-vin"));
				car.setMake(elementInventoryListing.attr("data-make"));
				car.setModel(elementInventoryListing.attr("data-model"));
				car.setYear(Integer.valueOf(elementInventoryListing.attr("data-year")));
				setVpdUrl(car, cars, elementInventoryListing, BASE_URL);
				setImageUrl(car, cars, elementInventoryListing, BASE_URL);				
				setPrice(car, cars, elementInventoryListing);				
				setMsrp(car, cars, elementInventoryListing);				
	
				cars.addCar(car);
			}		

			url = clientWebSiteUrlPrefix + DASH + webSitePageNumber++ + DOT_HTML;

			try {
				response = Jsoup.connect(url)
						.execute();
			} catch(Exception e) {
				if (e.getMessage() == HTTP_ERROR_FETCHING_URL) { 
					return; 
				} else {
					throw new Exception(UNKNOWN_EXCEPTION_EQUAL + e.getMessage());
				}
			}			
			document = response.parse();
			elementsCol12InventoryListing = document.getElementsByClass("col-12 inventory_listing");
		}
	}

	private void setVpdUrl(Car car, Cars cars, Element elementInventoryListing, String baseUrl) {
		Elements workElements = elementInventoryListing.getElementsByClass("b-goods_list");

		Element workElement = workElements.get(0);
		
		workElement = workElement.getElementsByClass("b-goods__img").get(0);

		String workString = workElement.attr("href");

		car.setVdpUrl(baseUrl + workString);
	}
	
	private void setImageUrl(Car car, Cars cars, Element elementInventoryListing, String baseUrl) {
		Elements workElements = elementInventoryListing.getElementsByClass("b-goods_list");

		Element workElement = workElements.get(0);
		
		workElement = workElement.getElementsByClass("b-goods__img").get(0);

		String workString = workElement.attr("href");

		car.setImageUrl(baseUrl + workString);
	}
	
	private void setPrice(Car car, Cars cars, Element elementInventoryListing) {
		Elements workElements = elementInventoryListing.getElementsByClass("b-goods__price-number");

		Element workElement = workElements.get(0);
		
		String workString = workElement.childNode(0).outerHtml();

		workString = workString.replace("$",  "");
		
		workString = workString.replaceAll(",",  "");

		car.setPrice(Float.valueOf(workString));
	}
	
	private void setMsrp(Car car, Cars cars, Element elementInventoryListing) {
		Elements workElements = elementInventoryListing.getElementsByClass("b-goods__price-msrp");

		String workString = workElements.get(0).childNode(0).outerHtml();

		if (workString.length() > 6) {
			workString = workString.substring(6);
			workString = workString.replaceAll(",",  "");
			car.setMsrp(Float.valueOf(workString));
		}
		else {
			car.setMsrp(Float.valueOf(-1F));
		}
	}	
}