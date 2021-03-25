package com.consumer.tempconvert.configuration;

import com.consumer.tempconvert.client.CelsiusToFahrenheitClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SubtractConfiguration {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in pom.xml
        marshaller.setContextPath("com.example.test.wsdl");
        return marshaller;
    }

    @Bean
    public CelsiusToFahrenheitClient celsiusToFahrenheitClient(Jaxb2Marshaller marshaller) {
        CelsiusToFahrenheitClient client = new CelsiusToFahrenheitClient();
        client.setDefaultUri("https://www.w3schools.com/xml/tempconvert.asmx?WSDL");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }


}
