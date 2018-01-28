package com.github.smartbv2.fact_checker.CorpusMaker;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Varma G.S.
 */
public class ReadJSON {

    public static String getHeadline(File inJFile) throws IOException, ParseException {

        JSONParser parser = new JSONParser();

        Object obj = null;

        obj = parser.parse(new FileReader(inJFile.getAbsolutePath()));


        JSONObject jsonObject = (JSONObject) obj;

        String headline = (String) jsonObject.get("headline");
//        System.out.println(headline);

//        String body = (String) jsonObject.get("body");
//        System.out.println(body);
//
//        String url = (String) jsonObject.get("url");
//        System.out.println(url);
//
//        String date = (String) jsonObject.get("date");
//        System.out.println(date);
//
//        String description = (String) jsonObject.get("description");
//        System.out.println(description);

        return headline;
    }
}