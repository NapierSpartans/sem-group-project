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
    public ArrayList<City> getAllCitiesInCountryOrderPopulation(String country) throws SQLException {
            Statement stmt = con.createStatement();

            String strSelect =
                    "SELECT cit.ID, cit.Name, cit.CountryCode, cit.district, cit.population " +
                            "FROM city as cit LEFT JOIN country as con on " +
                            "cit.CountryCode = con.code WHERE con.Name = '" + country +
                            "'ORDER BY cit.population DESC";

            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<City> cities = new ArrayList<>();

            while (rset.next())
            {
                City city = new City();
                city.id = rset.getInt("cit.ID");
                city.name = rset.getString("cit.Name");
                city.countryCode = rset.getString("cit.CountryCode");
                city.District = rset.getString("cit.district");
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
            System.out.println(String.format("%-10s %-20s %-5s %-15s %-10s", "id", "name", "code" , "district","population"));
            for (City c : cities) {
                if (c == null) continue;
                System.out.println(
                        String.format("%-10d %-20s %-5s %-15s %-10d", c.id, c.name, c.countryCode, c.District , c.population)
                );
            }
        } else {
            System.out.println("No Cities");
        }

    }
}
