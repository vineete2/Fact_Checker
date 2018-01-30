package com.github.smartbv2.fact_checker;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author Varma G.S.
 */
public class ConnectDBpedia {

    public static void getJSON(String trigger) throws Exception {

        URL url = new URL("http://dbpedia.org/data/"+trigger+".json");
        URLConnection urlConnection = url.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        urlConnection.getInputStream()));
        String inputLine;

        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();
    }

}
