package com.github.smartbv2.fact_checker.CorpusMaker;

import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;

/**
 * @author Varma G.S.
 */
public class HeadlinesCorpus {

    public static StringBuilder create() throws IOException, ParseException {

        StringBuilder header = new StringBuilder();

        for (int i = 1; i < 3863; i++) {

            String filePath = "data/NYT2013/articles/json (" + i + ")";
            File inJsonFile = new File(filePath);

            String headline = ReadJSON.getHeadline(inJsonFile);

            header.append(headline + ". ");
        }
        return header;
    }
}