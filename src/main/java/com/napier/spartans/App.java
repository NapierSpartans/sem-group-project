package com.napier.spartans;


import java.sql.*;
import java.util.ArrayList;


public class App {

    private Connection con;


    public static void main(String[] args) {
        // Create new Application
        App a = new App();

        // Connect to database
        if (args.length < 1)
        {
            a.connect("localhost:3306");
        }
        else
        {
            a.connect(args[0]);
        }


        try {
            a.printCities(a.getAllCitiesInCountryOrderPopulation("United Kingdom"));
            a.printCities(a.getAllCitiesInRegionOrderByPopulation("Caribbean"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get All Cities within a country ordered from largest population to smallest
     */
    public ArrayList<City> getAllCitiesInCountryOrderPopulation(String countryName) throws SQLException {

        ArrayList<City> cities = new ArrayList<>();

        System.out.println("All Cities in a Country by Population");

        Statement stmt = con.createStatement();

        String queryCountry = "SELECT con.code, con.name, con.continent, con.region, con.surfacearea, con.indepyear," +
                "con.population, con.lifeexpectancy, con.gnp, con.gnpold, con.localname," +
                "con.governmentform, con.headofstate, con.code2, cap.id, cap.name, cap.district, cap.population " +
                "FROM country as con LEFT JOIN city as cap on con.capital = cap.id " +
                "WHERE con.name = '" +countryName+"'" ;

        ResultSet countryRset = stmt.executeQuery(queryCountry);

        if(countryRset == null) return null;

        Country country = new Country();
        City countryCapital = new City();

        if(countryRset.next()){
            country.code = countryRset.getString("con.code");
            country.name = countryRset.getString("con.name");
            country.continent = Continent.valueOfLabel(countryRset.getString("con.continent"));
            country.region = countryRset.getString("con.region");
            country.surfaceArea = countryRset.getDouble("con.surfacearea");
            country.independenceYear = countryRset.getShort("con.indepyear");
            country.population = countryRset.getInt("con.population");
            country.lifeExpectancy = countryRset.getDouble("con.lifeexpectancy");
            country.gnp = countryRset.getDouble("con.gnp");
            country.gnpOld = countryRset.getDouble("con.gnpold");
            country.localName = countryRset.getString("con.localname");
            country.governmentForm = countryRset.getString("con.governmentform");
            country.headOfState = countryRset.getString("con.headofstate");


            countryCapital.id = countryRset.getInt("cap.id");
            countryCapital.name = countryRset.getString("cap.name");
            countryCapital.district = countryRset.getString("cap.district");
            countryCapital.population = countryRset.getInt("cap.population");
            countryCapital.country = country;
            country.capital = countryCapital;

            String strSelect =
                    "SELECT id, name, district, population FROM city " +
                            "WHERE CountryCode = '" + country.code +"' ORDER BY population DESC";

            stmt = con.createStatement();

            ResultSet rset = stmt.executeQuery(strSelect);

            if(rset == null){
                System.out.println("City result set is null");
                return null;
            }



            while (rset.next())
            {
                City city = new City();
                city.id = rset.getInt("id");
                city.name = rset.getString("name");
                city.country = country;
                city.district = rset.getString("district");
                city.population = rset.getInt("population");
                cities.add(city);
            }
        }



        return cities;
    }

    public ArrayList<City> getAllCitiesInRegionOrderByPopulation(String region) throws SQLException{

        System.out.println("All Cities in a Region by Population");

        ArrayList<City> cities = new ArrayList<>();


        Statement stmt = con.createStatement();

        String queryAllCitiesInRegion = "SELECT cit.ID, cit.name, cit.district, cit.population, " +
                "con.code, con.name, con.continent, con.surfacearea, con.indepyear, " +
                "con.population, con.lifeexpectancy, con.gnp, con.gnpold, con.localname, " +
                "con.governmentform, con.headofstate, con.code2, cap.id, cap.name, cap.district, cap.population " +
                "FROM city as cit LEFT JOIN country as con on cit.countrycode = con.code LEFT JOIN city as cap on con.capital = cap.id " +
                "WHERE con.region = '" + region + "' ORDER BY cit.population DESC";

        ResultSet rset = stmt.executeQuery(queryAllCitiesInRegion);

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
            country.region = region;
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

    /**
     * Connect to the MySQL database.
     */
    public void connect(String location)
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://" + location + "/world?allowPublicKeyRetrieval=true&useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + i);
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect()
    {
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }

    public void printCities(ArrayList<City> cities){
        if(cities != null){
            System.out.println(String.format("%-10s %-15s %-25s %-15s %-10s", "id", "name", "country name" , "district","population"));
            for (City c : cities) {
                if (c == null) continue;
                System.out.println(
                        String.format("%-10d %-15s %-25s %-15s %-10d", c.id, c.name, c.country.name, c.district, c.population)
                );
            }
        } else {
            System.out.println("No Cities");
        }

    }
}
