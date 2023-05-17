package com.example.Api_junitDemo;

import org.json.JSONObject;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class CountryTest {

    @Test
    public void testFetchCountryData() {


       //  Creates a mock of the RestTemplate
        RestTemplate restTemplate = Mockito.mock(RestTemplate.class);

        // Set up the mock behavior
        String mockResponse = "{\"status\":\"OK\",\"status-code\":200,\"version\":\"1.0\",\"access\":\"public\",\"data\":{\"DZ\":{\"country\":\"Algeria\",\"region\":\"Central America\"}}}";
        when(restTemplate.getForObject(Mockito.anyString(), Mockito.eq(String.class))).thenReturn(mockResponse);

        Country country = new Country();


        List<String> jsonDataList = country.fetchCountryData();


        Assert.assertNotNull(jsonDataList);
        Assert.assertFalse(jsonDataList.isEmpty());

        String actualCountryData = jsonDataList.get(0);

        // Parse the JSON response
        JSONObject responseJson = new JSONObject(actualCountryData); // converts the string representation of data into obeject
        JSONObject dataJson = responseJson.getJSONObject("data"); //retrieves the object "DATA" from the response
        JSONObject algeriaJson = dataJson.getJSONObject("BZ"); // retrieves the jsonobject associated with the key BZ from the datajson

        // Extracting the relevant data
        String expectedCountry = "Belize";
        String expectedRegion = "Central America";
        String actualCountry = algeriaJson.getString("country");// retrieves the value associated with key country from algeriajson
        String actualRegion = algeriaJson.getString("region");

        // checking if the expected output is equal to the actual output
        assertEquals(expectedCountry, actualCountry);
        assertEquals(expectedRegion, actualRegion);
    }
    }
