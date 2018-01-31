package com.github.smartbv2.fact_checker;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;


/**
 * @author Varma G.S.
 */
public class JSOName {
    public String getName() throws IOException, ParseException {

        String generalName = "default";

        JSONParser parser = new JSONParser();
        JSONArray graph;
        JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("data/outputs/output_fox.json"));
        // typecasting obj to JSONObject
        graph = (JSONArray) jsonObject.get("@graph");

        // When there is no graph i.e., identified entity .. considering it's fact to be zero for now.
        if (graph == null) {
            return null; }

        for (Object aGraph : graph) {
            JSONObject jsonObject1 = (JSONObject) aGraph;
            String check = null;
            check = jsonObject1.get("@type").toString();
            if (Objects.equals(check, "nif:Phrase")) {
                //     generalName = String.valueOf(jsonObject1.get("@taldentRef"));
                generalName = jsonObject1.get("anchorOf").toString();
                break;
            }
        }
        String name = generalName.replaceAll(" ", "_");
        return name;
    }

}