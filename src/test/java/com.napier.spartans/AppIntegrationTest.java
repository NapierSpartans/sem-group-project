package com.napier.spartans;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class AppIntegrationTest {

    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060");
    }

    @Test
    void testGetCitiesInCountryOrderPopulation(){
        assertDoesNotThrow(() -> {
            app.getAllCitiesInCountryOrderPopulation("United Kingdom");
        });
    }

    @Test
    void testGetCitiesInCountryOrderPopulationNullInput(){
        assertDoesNotThrow(() -> {
            app.getAllCitiesInCountryOrderPopulation(null);
        });
    }

    @Test
    void testGetCitiesInCountryOrderPopulationEmptyString(){
        assertDoesNotThrow(() -> {
            app.getAllCitiesInCountryOrderPopulation("");
        });
    }

    @Test
    void testGetCitiesInCountryOrderPopulationInvalidCountry(){
        assertDoesNotThrow(() -> {
            app.getAllCitiesInCountryOrderPopulation("bogus value");
        });
    }
}
