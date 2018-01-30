package com.github.smartbv2.fact_checker;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author Varma G.S.
 */
public class ConnectDBpedia {

    public static void main(String[] args) throws Exception {
        URL db = new URL("http://dbpedia.org/data/Britney_Spears.json");
        URLConnection yc = db.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        yc.getInputStream()));
        String inputLine;

        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();
    }

}
