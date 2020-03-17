package com.napier.spartans;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class AppTest {

    static App app;

    @BeforeAll
    static void init(){
        app = new App();
    }

    @Test
    void printCitiesNullValue(){
        app.printCities(null);
    }

    @Test
    void printCitiesEmptyList(){
        app.printCities(new ArrayList<>());
    }

    @Test
    void printCitiesContainsNull() {
        ArrayList<City> cities = new ArrayList<>();
        cities.add(null);
        app.printCities(cities);
    }

    @Test
    void printCities(){
        ArrayList<City> cities = new ArrayList<>();
        City city = new City();
        city.id = 1;
        city.name = "New York";
        Country country = new Country();
        country.name = "United States of America";
        city.country = country;
        city.district = "North America";
        city.population = 144000000;
        cities.add(city);
        app.printCities(cities);
    }

}
