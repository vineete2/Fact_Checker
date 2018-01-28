package com.github.smartbv2.fact_checker;


import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

/**
 * @author Varma G.S.
 */
public class ReadJSON {

    public static void main(String myHelpers[]) throws JSONException, IOException, ParseException {

        JSONParser parser = new JSONParser();

        Object obj = null;

        obj = parser.parse(new FileReader("data/NYT2013/articles/json (1)"));


        JSONObject jsonObject = (JSONObject) obj;

        String headline = (String) jsonObject.get("headline");
        System.out.println(headline);

        String body = (String) jsonObject.get("body");
        System.out.println(body);

        String url = (String) jsonObject.get("url");
        System.out.println(url);

        String date = (String) jsonObject.get("date");
        System.out.println(date);

        String description = (String) jsonObject.get("description");
        System.out.println(description);


//        String jsonString = "{\"headline\:" 11,\"field2\": 12,\"field3\": 13};
//        JSONObject output;
//        try {
//            output = new JSONObject(jsonString);
//
//
//            JSONArray docs = output.getJSONArray("infile");
//
//            File file=new File("/tmp2/fromJSON.csv");
//            String csv = CDL.toString(docs);
//            FileUtils.writeStringToFile(file, csv, "utf8");
//        } catch (JSONException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
    }
}