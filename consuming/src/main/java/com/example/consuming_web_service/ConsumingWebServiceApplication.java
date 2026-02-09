package com.example.consuming_web_service;

import com.example.consumingwebservice.wsdl.GetCountryResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ConsumingWebServiceApplication {

    Logger logger = LoggerFactory.getLogger(ConsumingWebServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ConsumingWebServiceApplication.class, args);
    }

    @Bean
    ApplicationRunner lookup(CountryClient countryClient) {
        return args -> {
            List<String> countryOption = args.getOptionValues("country");
            String country = (countryOption == null || countryOption.isEmpty()) ? "Spain" : countryOption.get(0);
            GetCountryResponse countryResponse = countryClient.getCountry(country);
            logger.info("Country -> {} has currency [{}]",
                    country,  countryResponse.getCountry().getCurrency());
        };
    }

}