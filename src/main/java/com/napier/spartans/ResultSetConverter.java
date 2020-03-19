package com.napier.spartans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class ResultSetConverter <T>{

    public abstract String getFields();

    public abstract String getTables();

    public abstract ArrayList<T> convert(ResultSet rset) throws SQLException;
}
