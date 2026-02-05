package com.example.producing_web_service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;

@Configuration(proxyBeanMethods = false)
public class WebServiceConfig {

    @Bean
    public DefaultWsdl11Definition countries(SimpleXsdSchema schema) {
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setPortTypeName("CountriesPort");
        definition.setLocationUri("/services");
        definition.setTargetNamespace("https://spring.io/guides/gs-producing-web-service");
        definition.setSchema(schema);

        return definition;
    }

}
