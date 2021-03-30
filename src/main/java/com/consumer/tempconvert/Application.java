package com.consumer.tempconvert;

import com.consumer.tempconvert.client.CelsiusToFahrenheitClient;
import com.consumer.tempconvert.client.FahrenheitToCelsiusClient;
import com.example.test.wsdl.CelsiusToFahrenheitResponse;
import com.example.test.wsdl.FahrenheitToCelsiusResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author Miguel Camacho
 */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	//Here testing remplace sCelsius for any value String number.
	@Bean
	CommandLineRunner setupConvertCelsiusToFahrenheit(CelsiusToFahrenheitClient celsiusToFahrenheitClient) {
		return args -> {
			String sCelsius = "18";
			CelsiusToFahrenheitResponse response = celsiusToFahrenheitClient.celsiusToFahrenheitResponse(sCelsius);
			System.out.println("Response => " + response.getCelsiusToFahrenheitResult());
		};
	}

	//Converter
	@Bean
	CommandLineRunner setupConverterFahrenheitToCelsius(FahrenheitToCelsiusClient fahrenheitToCelsiusClient) {
		return args -> {
			String sFahrenheit = "7";
			FahrenheitToCelsiusResponse response = fahrenheitToCelsiusClient.fahrenheitToCelsiusResponse(sFahrenheit);
			System.out.println("Response => " + response.getFahrenheitToCelsiusResult());
		};
	}


}
