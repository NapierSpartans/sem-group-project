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

    //GET TOP N POPULATED CITIES
    @Test
    void testGetTop_N_PopulatedCities(){
        assertDoesNotThrow(() -> {
            app.getTop_N_PopulatedCities(5);
        });
    }

    @Test
    void testGetTop_N_PopulatedCitiesNegativeValue(){
        assertDoesNotThrow(() -> {
            app.getTop_N_PopulatedCities(-1);
        });
    }
    //GET TOP N POPULATED CITIES OF A COUNTRY
    @Test
    void testGetTop_N_PopulatedCitiesoOfCountry(){
        assertDoesNotThrow(() -> {
            app.getTop_N_PopulatedCitiesOfCountry("United Kingdom", 5);
        });
    }

    @Test
    void testGetTop_N_PopulatedCitiesoOfCountryNegativeLimit(){
        assertDoesNotThrow(() -> {
            app.getTop_N_PopulatedCitiesOfCountry("United Kingdom", -1);
        });
    }

    @Test
    void testGetTop_N_PopulatedCitiesoOfCountryNullString(){
        assertDoesNotThrow(() -> {
            app.getTop_N_PopulatedCitiesOfCountry(null, -1);
        });
    }

    @Test
    void testGetTop_N_PopulatedCitiesoOfCountryEmptyString(){
        assertDoesNotThrow(() -> {
            app.getTop_N_PopulatedCitiesOfCountry("", 5);
        });
    }

    @Test
    void testGetTop_N_PopulatedCitiesoOfCountryInvalidString(){
        assertDoesNotThrow(() -> {
            app.getTop_N_PopulatedCitiesOfCountry("Invalid String", 5);
        });
    }
    //GET TOP N POPULATED CAPITAL CITIES OF A REGION
    @Test
    void testGetTop_N_PopulatedCapitalCitiesoOfRegion(){
        assertDoesNotThrow(() -> {
            app.getTop_N_PopulatedCapitalCitiesOfRegion("North America", 5);
        });
    }

    @Test
    void testGetTop_N_PopulatedCapitalCitiesoOfRegionNegativeLimit(){
        assertDoesNotThrow(() -> {
            app.getTop_N_PopulatedCapitalCitiesOfRegion("North America", -1);
        });
    }

    @Test
    void testGetTop_N_PopulatedCapitalCitiesoOfRegionNullString(){
        assertDoesNotThrow(() -> {
            app.getTop_N_PopulatedCapitalCitiesOfRegion(null, -1);
        });
    }

    @Test
    void testGetTop_N_PopulatedCapitalCitiesoOfRegionEmptyString(){
        assertDoesNotThrow(() -> {
            app.getTop_N_PopulatedCapitalCitiesOfRegion("", 5);
        });
    }

    @Test
    void testGetTop_N_PopulatedCapitalCitiesoOfRegionInvalidString(){
        assertDoesNotThrow(() -> {
            app.getTop_N_PopulatedCapitalCitiesOfRegion("Invalid String", 5);
        });
    }

    //GET TOP N POPULATED CAPITAL CITIES OF A CONTINENT
    @Test
    void testGetTop_N_PopulatedCapitalCitiesoOfContinent(){
        assertDoesNotThrow(() -> {
            app.getTop_N_PopulatedCapitalCitiesOfContinent(Continent.AFRICA, 5);
        });
    }

    @Test
    void testGetTop_N_PopulatedCapitalCitiesoOfContinentNegativeLimit(){
        assertDoesNotThrow(() -> {
            app.getTop_N_PopulatedCapitalCitiesOfContinent(Continent.ASIA, -1);
        });
    }

    @Test
    void testGetTop_N_PopulatedCapitalCitiesoOfContinentNullContinent(){
        assertDoesNotThrow(() -> {
            app.getTop_N_PopulatedCapitalCitiesOfContinent(null, -1);
        });
    }


    //GET TOP N POPULATED CAPITAL CITIES
    @Test
    void testGetTop_N_PopulatedCapitalCities(){
        assertDoesNotThrow(() -> {
            app.getTop_N_PopulatedCities(5);
        });
    }

    @Test
    void testGetTop_N_PopulatedCapitalCitiesNegativeLimit(){
        assertDoesNotThrow(() -> {
            app.getTop_N_PopulatedCities(-1);
        });
    }


    // MOST POPULATED CAPITAL CITIES IN THE WORLD

    @Test
    void testGetMostPopulatedCapitalCitiesInTheWorld(){
        assertDoesNotThrow(() -> {
            app.getMostPopulatedCapitalCitiesOfWorld();
        });
    }
}
