package com.monks.pokemon.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.monks.pokemon.model.api.PokemonCardResponse;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
public class JsonReader {

    private final ObjectMapper objectMapper;

    public JsonReader() {
        objectMapper = new ObjectMapper();
    }

    public PokemonCardResponse readJsonFile() {
        try {
            InputStream inputStream = new ClassPathResource("pokemon-data.json").getInputStream();
            return objectMapper.readValue(inputStream, PokemonCardResponse.class);
        } catch (IOException e) {
            System.out.println("Error reading JSON file: " + e.getMessage());
            return null;
        }
    }
}
