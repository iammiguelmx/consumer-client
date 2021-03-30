package com.consumer.tempconvert.client;

import com.example.test.wsdl.FahrenheitToCelsius;
import com.example.test.wsdl.FahrenheitToCelsiusResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Slf4j
public class FahrenheitToCelsiusClient extends WebServiceGatewaySupport {

    public FahrenheitToCelsiusResponse fahrenheitToCelsiusResponse(String sFahrenheit){
        FahrenheitToCelsius request = new FahrenheitToCelsius();
        request.setFahrenheit(sFahrenheit);
        log.info("Execute soap service with params -> " + sFahrenheit);
        FahrenheitToCelsiusResponse fahrenheitToCelsiusResponse = (FahrenheitToCelsiusResponse)
                getWebServiceTemplate().marshalSendAndReceive(
                request,
                new SoapActionCallback("https://www.w3schools.com/xml/FahrenheitToCelsius"));
        return fahrenheitToCelsiusResponse;
    }


}
