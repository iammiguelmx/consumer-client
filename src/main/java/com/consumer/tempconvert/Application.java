package com.consumer.tempconvert;

import com.consumer.tempconvert.client.CelsiusToFahrenheitClient;
import com.example.test.wsdl.CelsiusToFahrenheitResponse;
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
	CommandLineRunner setupInitial(CelsiusToFahrenheitClient celsiusToFahrenheitClient) {
		return args -> {
			String sCelsius = "18";
			CelsiusToFahrenheitResponse response = celsiusToFahrenheitClient.celsiusToFahrenheitResponse(sCelsius);
			System.out.println("Response => " + response.getCelsiusToFahrenheitResult());
		};
	}

}
