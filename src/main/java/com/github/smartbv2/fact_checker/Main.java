package com.github.smartbv2.fact_checker;

/**
 * @author Varma G.S.
 */
public class Main {

    public static void main(String[] args) throws Exception {

        // FOX
        String statement = "Britney Spears is Kevin Federline's better half.";
        ConnectFOX connectFOX = new ConnectFOX();
        connectFOX.getPerson(statement);

        // Retrieve name from FOX Json
        JSOName jsoName = new JSOName();
        String trigger = jsoName.getName();

        // DBpedia
        // String trigger = "Britney_Spears"; // Query for DBpedia
        ConnectDBpedia connectDBpedia = new ConnectDBpedia();
        connectDBpedia.getJSON(trigger);


    }
}
