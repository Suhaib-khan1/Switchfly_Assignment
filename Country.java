package com.example.Api_junitDemo;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Country {

    public List<String> fetchCountryData() {
        final String uri = "https://api.first.org/data/v1/countries";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        System.out.println(result);

        // Create a List to store the JSON data
        List<String> jsonDataList = new ArrayList<>();
        jsonDataList.add(result);
        System.out.println(jsonDataList.get(0));

        return jsonDataList;
    }





//    public static void main(String[] args) {
//        Country country = new Country();
//        country.fetchCountryData();
//
//  }
}