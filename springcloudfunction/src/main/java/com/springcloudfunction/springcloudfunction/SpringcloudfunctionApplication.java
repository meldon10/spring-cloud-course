package com.springcloudfunction.springcloudfunction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@SpringBootApplication
public class SpringcloudfunctionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudfunctionApplication.class, args);
	}

	List<TollStation> tollStationList;

	//Constructor of this class
	public SpringcloudfunctionApplication() {

		tollStationList = new ArrayList<>();
		tollStationList.add(new TollStation("100A",112.5f,2));
		tollStationList.add(new TollStation("120A",120.5f,2));
		tollStationList.add(new TollStation("130A",130.5f,5));
		tollStationList.add(new TollStation("140A",140.5f,10));
		tollStationList.add(new TollStation("150A",150.5f,3));
	}

	/**
	 * There are a total of 3 Functional interface to choose from
	 * 1) Supplier(Output) - Just provide us with output and does not take any input
	 * 3) Consumer(Input) - It take Input but do not expect any output like providing data to async endpoint
	 * 2) Function(Input,Output) - Both input and output
	 */


	// If we annotate a spring cloud function with a Bean it will tell spring to recognize it
	// and later can be used for further development
	//You can make a post request to this function once you run the app
	// localhost:8080/retrieveTollStations and in body pass value to be searched

	//Function
	@Bean
	public Function<String,TollStation> retrieveTollStations(){
			return value -> {
				System.out.println("Received Request for station "+ value);
				return tollStationList.stream()
						.filter(toll-> value.equals(toll.getTollStationId()))
						.findAny()
						.orElse(null);
			};
	}

	//Consumer
	@Bean
	public Consumer<TollRecord> getToll(){
		return value -> {
			System.out.println("Received Request for Toll Record "+value.getLicensePlate());
		};
	}

	//Consumer Flux of records
	//Subscribe requests the data from the publisher
	//A Flux object represents a reactive sequence of 0.. N items
	@Bean
	public Consumer<Flux<TollRecord>> getTollFlux(){
		return value -> {
			value.subscribe( toll -> System.out.println("Received Request for Toll Record "+toll.getLicensePlate()));
		};
	}


	//Supplier
	@Bean
	public Supplier<Flux<TollStation>> getTollSupplier(){
		return() -> Flux.fromIterable(tollStationList);
	}







}
