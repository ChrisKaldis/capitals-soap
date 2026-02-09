package com.example.consuming_web_service;

import com.example.consumingwebservice.wsdl.GetCountryRequest;
import com.example.consumingwebservice.wsdl.GetCountryResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class CountryClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(CountryClient.class);

    public GetCountryResponse getCountry(String countryCode) {
        GetCountryRequest request = new GetCountryRequest();
        request.setName(countryCode);

        log.info("Requesting location [{}]", countryCode);

        GetCountryResponse getCountryResponse = (GetCountryResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/services/countries", request,
                        new SoapActionCallback(
                                "https://spring.io/guides/gs-producing-web-service/GetCountryRequest"
                        ));

        return getCountryResponse;
    }

}
