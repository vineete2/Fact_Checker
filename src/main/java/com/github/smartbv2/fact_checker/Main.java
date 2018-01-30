package com.github.smartbv2.fact_checker;

/**
 * @author Varma G.S.
 */
public class Main {

    public static void main(String[] args) throws Exception {


        String trigger = "Britney_Spears"; // Query for DBpedia
        ConnectDBpedia connectDBpedia = new ConnectDBpedia();
        connectDBpedia.getJSON(trigger);
    }
}
