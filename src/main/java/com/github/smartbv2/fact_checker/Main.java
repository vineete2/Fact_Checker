package com.github.smartbv2.fact_checker;

/**
 * @author Varma G.S.
 */
public class Main {

    public static int[] main(String statement) throws Exception {

        // FOX
        // String statement = "Britney Spears is Kevin Federline's better half.";
        System.out.println(statement);
        ConnectFOX connectFOX = new ConnectFOX();
        connectFOX.getPerson(statement);

        // Retrieve name from FOX Json
        JSOName jsoName = new JSOName();
        String trigger = jsoName.getName();

        // DBpedia
        // String trigger = "Britney_Spears"; // Query for DBpedia
        ConnectDBpedia connectDBpedia = new ConnectDBpedia();
        connectDBpedia.getJSON(trigger);


        Checker.convertToUnigram(statement, trigger);
        int[] words = new int[2];

        words = Checker.verifyText();

        return words;
    }
}
