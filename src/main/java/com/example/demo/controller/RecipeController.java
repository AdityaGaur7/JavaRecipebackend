package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RecipeController {

    private final String API_URL = "https://dummyjson.com/recipes";

    @GetMapping("/api/recipes")
    public ResponseEntity<Map<String, Object>> getRecipes() {
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(API_URL, String.class);

        Map<String, Object> jsonResponse = new HashMap<>();
        jsonResponse.put("recipes", response);

        return ResponseEntity.ok(jsonResponse);
    }
}
