# capitals-soap
Combination of the two Spring guides representing how to produce and consume a SOAP service.

## Prerequisites
- Java 21
- Gradle (or use the included Gradle wrapper)

## How to Run

### 1. Build the Project
```
./gradlew build
```

### 2. Start the Producing Web Service
Start the producing service, which runs on `http://localhost:8080`:
```
./gradlew :producing:bootRun
```

### 3. Test the Producing Service
Before running the consuming application, verify that the producing service is working correctly.

Create a file named `request.xml` in the root directory with the following content:
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
xmlns:gs="https://spring.io/guides/gs-producing-web-service">
<soapenv:Header/>
<soapenv:Body>
<gs:getCountryRequest>
<gs:name>Spain</gs:name>
</gs:getCountryRequest>
</soapenv:Body>
</soapenv:Envelope>
```

Send a SOAP request to the producing service:
```
curl --header "Content-Type: text/xml" -d @request.xml http://localhost:8080/services > response.xml
```

Format and view the response:
```
xmllint --pretty 2 response.xml
```

You should see a successful SOAP response containing country information for Spain as below:

```xml
<?xml version="1.0"?>
<SOAP-ENV:Envelope
    xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/"
  ><SOAP-ENV:Header
  /><SOAP-ENV:Body
    ><ns2:getCountryResponse
        xmlns:ns2="https://spring.io/guides/gs-producing-web-service"
      ><ns2:country
        ><ns2:name
          >Spain</ns2:name
        ><ns2:population
          >46704314</ns2:population
        ><ns2:capital
          >Madrid</ns2:capital
        ><ns2:currency
          >EUR</ns2:currency
        ></ns2:country
      ></ns2:getCountryResponse
    ></SOAP-ENV:Body
  ></SOAP-ENV:Envelope
>
```

### 4. Start the Consuming Web Service
In a separate terminal, start the consuming web service:
```
./gradlew :consuming:bootRun
```

The consuming service will connect to the producing service to demonstrate SOAP communication.
