package com.napier.spartans;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest {

    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060");
    }

    @AfterAll
    static void destroy(){
        app.disconnect();
    }

    // CITIES IN COUNTRY BY POPULATION TESTS

    @Test
    void testGetCitiesInCountryOrderPopulationDoesNotThrow(){
        assertDoesNotThrow(() -> {
            app.getAllCitiesInCountryOrderPopulation("United Kingdom");
        });
    }

    @Test
    void testGetCitiesInCountryOrderPopulationNullInputDoesNotThrow(){
        assertDoesNotThrow(() -> {
            app.getAllCitiesInCountryOrderPopulation(null);
        });
    }

    @Test
    void testGetCitiesInCountryOrderPopulationEmptyStringDoesNotThrow(){
        assertDoesNotThrow(() -> {
            app.getAllCitiesInCountryOrderPopulation("");
        });
    }

    @Test
    void testGetCitiesInCountryOrderPopulationInvalidCountryDoesNotThrow(){
        assertDoesNotThrow(() -> {
            app.getAllCitiesInCountryOrderPopulation("bogus value");
        });
    }

    @Test
    void testGetCitiesInCountryOrderPopulation(){
        try {
            assertEquals(81, app.getAllCitiesInCountryOrderPopulation("United Kingdom").size());
        }catch (SQLException e){ e.printStackTrace(); }
    }

    @Test
    void testGetCitiesInCountryOrderPopulationNullCountryName(){
        try {
            assertEquals(null, app.getAllCitiesInCountryOrderPopulation(null));
        }catch (SQLException e){ e.printStackTrace(); }
    }

    @Test
    void testGetCitiesInCountryOrderPopulationEmptyCountryName(){
        try {
            assertEquals(0, app.getAllCitiesInCountryOrderPopulation("").size());
        }catch (SQLException e) { e.printStackTrace(); }
    }

    @Test
    void testGetCitiesInCountryOrderPopulationInvalidCountryName(){
        try {
            assertEquals(0, app.getAllCitiesInCountryOrderPopulation("Bogus Value").size());
        }catch (SQLException e){ e.printStackTrace(); }
    }

    // CITIES IN REGION BY POPULATION TESTS

    @Test
    void testGetCitiesInRegionOrderPopulationDoesNotThrow(){
        assertDoesNotThrow(() -> {
            app.getAllCitiesInRegionOrderByPopulation("Caribbean");
        });
    }

    @Test
    void testGetCitiesInRegionOrderPopulationNullInputDoesNotThrow(){
        assertDoesNotThrow(() -> {
            app.getAllCitiesInRegionOrderByPopulation(null);
        });
    }

    @Test
    void testGetCitiesInRegionOrderPopulationEmptyStringDoesNotThrow(){
        assertDoesNotThrow(() -> {
            app.getAllCitiesInRegionOrderByPopulation("");
        });
    }

    @Test
    void testGetCitiesInRegionOrderPopulationInvalidCountryDoesNotThrow(){
        assertDoesNotThrow(() -> {
            app.getAllCitiesInRegionOrderByPopulation("bogus value");
        });
    }

    @Test
    void testGetCitiesInRegionOrderPopulation(){
        try {
            assertEquals(327 , app.getAllCitiesInRegionOrderByPopulation("North America").size());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testGetCitiesInRegionOrderPopulationNullRegion(){
        try {
            assertEquals(null , app.getAllCitiesInRegionOrderByPopulation(null));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testGetCitiesInRegionOrderPopulationEmptyRegion(){
        try {
            assertEquals(0 , app.getAllCitiesInRegionOrderByPopulation("").size());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testGetCitiesInRegionOrderPopulationInvalidRegion(){
        try {
            assertEquals(0 , app.getAllCitiesInRegionOrderByPopulation("Bogus Value").size());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // CITIES IN DISTRICT BY POPULATION TESTS

    @Test
    void testGetCitiesInDistrictOrderPopulationDoesNotThrow(){
        assertDoesNotThrow(() -> {
            app.getAllCitiesInRegionOrderByPopulation("Buenos Aires");
        });
    }

    @Test
    void testGetCitiesInDistrictOrderPopulationNullInputDoesNotThrow(){
        assertDoesNotThrow(() -> {
            app.getAllCitiesInRegionOrderByPopulation(null);
        });
    }

    @Test
    void testGetCitiesInDistrictOrderPopulationEmptyStringDoesNotThrow(){
        assertDoesNotThrow(() -> {
            app.getAllCitiesInRegionOrderByPopulation("");
        });
    }

    @Test
    void testGetCitiesInDistrictOrderPopulationInvalidDistrictDoesNotThrow(){
        assertDoesNotThrow(() -> {
            app.getAllCitiesInRegionOrderByPopulation("bogus value");
        });
    }

    @Test
    void testGetCitiesInDistrictOrderPopulation(){

    }

    // POPULATION OF A CITY

    @Test
    void testGetPopulationOfCityDoesNotThrow(){
        assertDoesNotThrow(() -> {
            app.getPopulationOfCity("Glasgow");
        });
    }

    @Test
    void testGetPopulationOfCityNullInputDoesNotThrow(){
        assertDoesNotThrow(() -> {
            app.getPopulationOfCity(null);
        });
    }

    @Test
    void testGetPopulationOfCityEmptyStringDoesNotThrow(){
        assertDoesNotThrow(() -> {
            app.getPopulationOfCity("");
        });
    }

    @Test
    void testGetPopulationOfCityInvalidCityDoesNotThrow(){
        assertDoesNotThrow(() -> {
            app.getPopulationOfCity("bogus value");
        });
    }


    // POPULATION OF THE WORLD

    @Test
    void testGetPopulationOfTheWorldDoesNotThrow(){
        assertDoesNotThrow(() -> {
            app.getPopulationOfWorld();
        });
    }

    // N MOST POPULOUS CITIES IN CONTINENT

    @Test
    void testGetMostPopulousCitiesInContinentLimit_N_DoesNotThrow(){
        assertDoesNotThrow(() -> {
            app.get_N_MostPopulousCitiesInContinent(Continent.ASIA, 10);
        });
    }

    @Test
    void testGetMostPopulousCitiesInContinentLimit_N_NullInputDoesNotThrow(){
        assertDoesNotThrow(() -> {
            app.get_N_MostPopulousCitiesInContinent(null,10);
        });
    }

    @Test
    void testGetMostPopulousCitiesInContinentLimit_N_InvalidLimitDoesNotThrow(){
        assertDoesNotThrow(() -> {
            app.get_N_MostPopulousCitiesInContinent(Continent.AFRICA, 0);
        });
    }

    // WORLD PERCENTAGE OF LANGUAGE SPEAKERS

    @Test
    void testGetPercentageOfLanguageSpeakersDoesNotThrow(){
        assertDoesNotThrow(() -> {
            app.getWorldPercentageOfLanguageSpeakers("Spanish");
        });
    }

    @Test
    void testGetPercentageOfLanguageSpeakersNullInputDoesNotThrow(){
        assertDoesNotThrow(() -> {
            app.getWorldPercentageOfLanguageSpeakers(null);
        });
    }

    @Test
    void testGetPercentageOfLanguageSpeakersEmptyStringDoesNotThrow(){
        assertDoesNotThrow(() -> {
            app.getWorldPercentageOfLanguageSpeakers("");
        });
    }

    @Test
    void testGetPercentageOfLanguageSpeakersInvalidCityDoesNotThrow(){
        assertDoesNotThrow(() -> {
            app.getWorldPercentageOfLanguageSpeakers("bogus value");
        });
    }

    //GET TOP N POPULATED CITIES
    @Test
    void testGetTop_N_PopulatedCitiesDoesNotThrow(){
        assertDoesNotThrow(() -> {
            app.getTop_N_PopulatedCities(5);
        });
    }

    @Test
    void testGetTop_N_PopulatedCitiesNegativeValueDoesNotThrow(){
        assertDoesNotThrow(() -> {
            app.getTop_N_PopulatedCities(-1);
        });
    }
    //GET TOP N POPULATED CITIES OF A COUNTRY
    @Test
    void testGetTop_N_PopulatedCitiesOfCountryDoesNotThrow(){
        assertDoesNotThrow(() -> {
            app.getTop_N_PopulatedCitiesOfCountry("United Kingdom", 5);
        });
    }

    @Test
    void testGetTop_N_PopulatedCitiesOfCountryNegativeLimitDoesNotThrow(){
        assertDoesNotThrow(() -> {
            app.getTop_N_PopulatedCitiesOfCountry("United Kingdom", -1);
        });
    }

    @Test
    void testGetTop_N_PopulatedCitiesOfCountryNullStringDoesNotThrow(){
        assertDoesNotThrow(() -> {
            app.getTop_N_PopulatedCitiesOfCountry(null, -1);
        });
    }

    @Test
    void testGetTop_N_PopulatedCitiesOfCountryEmptyStringDoesNotThrow(){
        assertDoesNotThrow(() -> {
            app.getTop_N_PopulatedCitiesOfCountry("", 5);
        });
    }

    @Test
    void testGetTop_N_PopulatedCitiesOfCountryInvalidStringDoesNotThrow(){
        assertDoesNotThrow(() -> {
            app.getTop_N_PopulatedCitiesOfCountry("Invalid String", 5);
        });
    }
    //GET TOP N POPULATED CAPITAL CITIES OF A REGION
    @Test
    void testGetTop_N_PopulatedCapitalCitiesOfRegionDoesNotThrow(){
        assertDoesNotThrow(() -> {
            app.getTop_N_PopulatedCapitalCitiesOfRegion("North America", 5);
        });
    }

    @Test
    void testGetTop_N_PopulatedCapitalCitiesOfRegionNegativeLimitDoesNotThrow(){
        assertDoesNotThrow(() -> {
            app.getTop_N_PopulatedCapitalCitiesOfRegion("North America", -1);
        });
    }

    @Test
    void testGetTop_N_PopulatedCapitalCitiesOfRegionNullStringDoesNotThrow(){
        assertDoesNotThrow(() -> {
            app.getTop_N_PopulatedCapitalCitiesOfRegion(null, -1);
        });
    }

    @Test
    void testGetTop_N_PopulatedCapitalCitiesOfRegionEmptyStringDoesNotThrow(){
        assertDoesNotThrow(() -> {
            app.getTop_N_PopulatedCapitalCitiesOfRegion("", 5);
        });
    }

    @Test
    void testGetTop_N_PopulatedCapitalCitiesOfRegionInvalidStringDoesNotThrow(){
        assertDoesNotThrow(() -> {
            app.getTop_N_PopulatedCapitalCitiesOfRegion("Invalid String", 5);
        });
    }

    //GET TOP N POPULATED CAPITAL CITIES OF A CONTINENT
    @Test
    void testGetTop_N_PopulatedCapitalCitiesOfContinentDoesNotThrow(){
        assertDoesNotThrow(() -> {
            app.getTop_N_PopulatedCapitalCitiesOfContinent(Continent.AFRICA, 5);
        });
    }

    @Test
    void testGetTop_N_PopulatedCapitalCitiesOfContinentNegativeLimitDoesNotThrow(){
        assertDoesNotThrow(() -> {
            app.getTop_N_PopulatedCapitalCitiesOfContinent(Continent.ASIA, -1);
        });
    }

    @Test
    void testGetTop_N_PopulatedCapitalCitiesOfContinentNullContinentDoesNotThrow(){
        assertDoesNotThrow(() -> {
            app.getTop_N_PopulatedCapitalCitiesOfContinent(null, -1);
        });
    }


    //GET TOP N POPULATED CAPITAL CITIES
    @Test
    void testGetTop_N_PopulatedCapitalCitiesDoesNotThrow(){
        assertDoesNotThrow(() -> {
            app.getTop_N_PopulatedCities(5);
        });
    }

    @Test
    void testGetTop_N_PopulatedCapitalCitiesNegativeLimitDoesNotThrow(){
        assertDoesNotThrow(() -> {
            app.getTop_N_PopulatedCities(-1);
        });
    }


    // MOST POPULATED CAPITAL CITIES IN THE WORLD

    @Test
    void testGetMostPopulatedCapitalCitiesInTheWorldDoesNotThrow(){
        assertDoesNotThrow(() -> {
            app.getMostPopulatedCapitalCitiesOfWorld();
        });
    }

    // MOST POPULATED CAPITAL CITIES IN A CONTINENT

    @Test
    void testGetMostPopulatedCapitalCitiesOfContinentDoesNotThrow(){
        assertDoesNotThrow(() -> {
            app.getMostPopulatedCapitalCitiesOfContinent(Continent.AFRICA);
        });
    }

    @Test
    void testGetMostPopulatedCapitalCitiesOfContinentNullValueDoesNotThrow(){
        assertDoesNotThrow(() -> {
            app.getMostPopulatedCapitalCitiesOfContinent(null);
        });
    }

    // MOST POPULATED CAPITAL CITIES IN A REGION

    @Test
    void testGetMostPopulatedCapitalCitiesOfRegionDoesNotThrow(){
        assertDoesNotThrow(() -> {
            app.getMostPopulatedCapitalCitiesOfRegion("North America");
        });
    }

    @Test
    void testGetMostPopulatedCapitalCitiesOfRegionNullValueDoesNotThrow(){
        assertDoesNotThrow(() -> {
            app.getMostPopulatedCapitalCitiesOfRegion(null);
        });
    }

    @Test
    void testGetMostPopulatedCapitalCitiesOfRegionEmptyStringDoesNotThrow(){
        assertDoesNotThrow(() -> {
            app.getMostPopulatedCapitalCitiesOfRegion("");
        });
    }

    @Test
    void testGetMostPopulatedCapitalCitiesOfRegionInvalidStringDoesNotThrow(){
        assertDoesNotThrow(() -> {
            app.getMostPopulatedCapitalCitiesOfRegion("Invalid String");
        });
    }
}
