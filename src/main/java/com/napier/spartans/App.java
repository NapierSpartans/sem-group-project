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
    }

    /**
     * Get All Cities within a country ordered from largest population to smallest
     */
    public ArrayList<City> getAllCitiesInCountryOrderPopulation(String countryName) throws SQLException {
            Statement stmt = con.createStatement();

            String queryCountry = "SELECT con.name, con.continent, con.region, con.surfacearea, con.indepyear," +
                    "con.population, con.lifeexpectancy, con.gnp, con.gnpold, con.localname," +
                    "con.governmentform, con.headofstate, con.code2, cit.id, cit.name, cit.district, cit.population " +
                    "FROM country as con LEFT JOIN city as cit on con.capital = cit.id " +
                    "WHERE con.name = '" +countryName+"'" ;

            ResultSet countryRset = stmt.executeQuery(queryCountry);

            Country country = new Country();
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

            City countryCapital = new City();
            countryCapital.id = countryRset.getInt("cap.ID");
            countryCapital.name = countryRset.getString("cap.name");
            countryCapital.district = countryRset.getString("cap.district");
            countryCapital.population = countryRset.getInt("cap.population");
            countryCapital.country = country;
            country.capital = countryCapital;


            String strSelect =
                    "SELECT cit.ID, cit.name, cit.district, cit.population FROM city as cit" +
                            "WHERE cit.countrycode = '" + country.code +"' ORDER BY cit.population DESC";

            stmt = con.createStatement();

            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<City> cities = new ArrayList<>();

            while (rset.next())
            {
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
