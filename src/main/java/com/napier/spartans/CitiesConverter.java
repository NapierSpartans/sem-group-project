package com.napier.spartans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CitiesConverter extends ResultSetConverter<City> {

    @Override
    public String getFields() {
        return " cit.ID, cit.name, cit.district, cit.population, " +
            "con.code, con.name, con.continent, con.region, con.surfacearea, con.indepyear, " +
            "con.population, con.lifeexpectancy, con.gnp, con.gnpold, con.localname, " +
            "con.governmentform, con.headofstate, con.code2, cap.id, cap.name, cap.district, cap.population ";
    }

    @Override
    public String getTables() {
        return " city as cit LEFT JOIN country as con on cit.countrycode = con.code " +
                "LEFT JOIN city as cap on con.capital = cap.id ";
    }

    @Override
    public ArrayList<City> convert(ResultSet rset) throws SQLException {

        ArrayList<City> cities = new ArrayList<>();

        if(rset == null) return null;

        while (rset.next()){
            City capitalCity = new City();
            capitalCity.id = rset.getInt("cap.id");
            capitalCity.name = rset.getString("cap.name");
            capitalCity.district = rset.getString("cap.district");
            capitalCity.population = rset.getInt("cap.population");

            Country country = new Country();
            country.code = rset.getString("con.code");
            country.name = rset.getString("con.name");
            country.continent = Continent.valueOfLabel(rset.getString("con.continent"));
            country.region = rset.getString("con.region");
            country.surfaceArea = rset.getDouble("con.surfacearea");
            country.independenceYear = rset.getShort("con.indepyear");
            country.population = rset.getInt("con.population");
            country.lifeExpectancy = rset.getDouble("con.lifeexpectancy");
            country.gnp = rset.getDouble("con.gnp");
            country.gnpOld = rset.getDouble("con.gnpold");
            country.localName = rset.getString("con.localname");
            country.governmentForm = rset.getString("con.governmentform");
            country.headOfState = rset.getString("con.headofstate");
            country.code2 = rset.getString("con.code2");
            capitalCity.country = country;
            country.capital = capitalCity;

            City city = new City();
            city.id = rset.getInt("cit.ID");
            city.name = rset.getString("cit.name");
            city.country = country;
            city.district = rset.getString("cit.district");
            city.population = rset.getInt("cit.population");
            cities.add(city);
        }
        return cities;
    }
}
