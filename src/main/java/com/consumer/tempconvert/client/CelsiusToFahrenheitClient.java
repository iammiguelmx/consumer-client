package com.consumer.tempconvert.client;

import com.example.test.wsdl.CelsiusToFahrenheit;
import com.example.test.wsdl.CelsiusToFahrenheitResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Slf4j
public class CelsiusToFahrenheitClient  extends WebServiceGatewaySupport {

    public CelsiusToFahrenheitResponse celsiusToFahrenheitResponse(String sCelsius){
        CelsiusToFahrenheit request = new CelsiusToFahrenheit();
        request.setCelsius(sCelsius);
        log.info("Execute soap service with params -> " + sCelsius);
        CelsiusToFahrenheitResponse celsiusToFahrenheitResponse = (CelsiusToFahrenheitResponse)
                getWebServiceTemplate().marshalSendAndReceive(
                        request,
                        new SoapActionCallback("https://www.w3schools.com/xml/CelsiusToFahrenheit"));
        return celsiusToFahrenheitResponse;
    }



}
