package com.napier.spartans;

public enum Continent {
    ASIA("Asia"),
    EUROPE("Europe"),
    NORTHAMERICA("North America"),
    AFRICA("Africa"),
    OCEANIA("Oceania"),
    ANTARCTICA("Antarctica"),
    SOUTHAMERICA("South America");

    public final String label;

    private Continent(String label){
        this.label = label;
    }

    public static Continent valueOfLabel(String label){
        for(Continent c : values()){
            if (c.label.equals(label)){
                return c;
            }
        }
        return null;
    }
}
