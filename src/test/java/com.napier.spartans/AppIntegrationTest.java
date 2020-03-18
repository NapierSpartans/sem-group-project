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

    // CITIES IN COUNTRY BY POPULATION TESTS

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

    // CITIES IN REGION BY POPULATION TESTS

    @Test
    void testGetCitiesInRegionOrderPopulation(){
        assertDoesNotThrow(() -> {
            app.getAllCitiesInRegionOrderByPopulation("Caribbean");
        });
    }

    @Test
    void testGetCitiesInRegionOrderPopulationNullInput(){
        assertDoesNotThrow(() -> {
            app.getAllCitiesInRegionOrderByPopulation(null);
        });
    }

    @Test
    void testGetCitiesInRegionOrderPopulationEmptyString(){
        assertDoesNotThrow(() -> {
            app.getAllCitiesInRegionOrderByPopulation("");
        });
    }

    @Test
    void testGetCitiesInRegionOrderPopulationInvalidCountry(){
        assertDoesNotThrow(() -> {
            app.getAllCitiesInRegionOrderByPopulation("bogus value");
        });
    }

    // CITIES IN DISTRICT BY POPULATION TESTS

    @Test
    void testGetCitiesInDistrictOrderPopulation(){
        assertDoesNotThrow(() -> {
            app.getAllCitiesInRegionOrderByPopulation("Buenos Aires");
        });
    }

    @Test
    void testGetCitiesInDistrictOrderPopulationNullInput(){
        assertDoesNotThrow(() -> {
            app.getAllCitiesInRegionOrderByPopulation(null);
        });
    }

    @Test
    void testGetCitiesInDistrictOrderPopulationEmptyString(){
        assertDoesNotThrow(() -> {
            app.getAllCitiesInRegionOrderByPopulation("");
        });
    }

    @Test
    void testGetCitiesInDistrictOrderPopulationInvalidDistrict(){
        assertDoesNotThrow(() -> {
            app.getAllCitiesInRegionOrderByPopulation("bogus value");
        });
    }

    // POPULATION OF A CITY

    @Test
    void testGetPopulationOfCity(){
        assertDoesNotThrow(() -> {
            app.getPopulationOfCity("Glasgow");
        });
    }

    @Test
    void testGetPopulationOfCityNullInput(){
        assertDoesNotThrow(() -> {
            app.getPopulationOfCity(null);
        });
    }

    @Test
    void testGetPopulationOfCityEmptyString(){
        assertDoesNotThrow(() -> {
            app.getPopulationOfCity("");
        });
    }

    @Test
    void testGetPopulationOfCityInvalidCity(){
        assertDoesNotThrow(() -> {
            app.getPopulationOfCity("bogus value");
        });
    }


    // POPULATION OF THE WORLD

    @Test
    void testGetPopulationOfTheWorld(){
        assertDoesNotThrow(() -> {
            app.getPopulationOfWorld();
        });
    }

    // N MOST POPULOUS CITIES IN CONTINENT

    @Test
    void testGetMostPopulousCitiesInContinentLimit_N_(){
        assertDoesNotThrow(() -> {
            app.get_N_MostPopulousCitiesInContinent(Continent.ASIA, 10);
        });
    }

    @Test
    void testGetMostPopulousCitiesInContinentLimit_N_NullInput(){
        assertDoesNotThrow(() -> {
            app.get_N_MostPopulousCitiesInContinent(null,10);
        });
    }

    @Test
    void testGetMostPopulousCitiesInContinentLimit_N_InvalidLimit(){
        assertDoesNotThrow(() -> {
            app.get_N_MostPopulousCitiesInContinent(Continent.AFRICA, 0);
        });
    }

    // WORLD PERCENTAGE OF LANGUAGE SPEAKERS

    @Test
    void testGetPercentageOfLanguageSpeakers(){
        assertDoesNotThrow(() -> {
            app.getWorldPercentageOfLanguageSpeakers("Spanish");
        });
    }

    @Test
    void testGetPercentageOfLanguageSpeakersNullInput(){
        assertDoesNotThrow(() -> {
            app.getWorldPercentageOfLanguageSpeakers(null);
        });
    }

    @Test
    void testGetPercentageOfLanguageSpeakersEmptyString(){
        assertDoesNotThrow(() -> {
            app.getWorldPercentageOfLanguageSpeakers("");
        });
    }

    @Test
    void testGetPercentageOfLanguageSpeakersInvalidCity(){
        assertDoesNotThrow(() -> {
            app.getWorldPercentageOfLanguageSpeakers("bogus value");
        });
    }
}
