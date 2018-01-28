package com.github.smartbv2.fact_checker.CorpusMaker;

import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Varma G.S.
 */
public class CorpusMaker {

    public static void main(String[] args) throws IOException, ParseException {

        StringBuilder headlinesCorpus = HeadlinesCorpus.create();

        File file = new File("data/NYT2013/headlinesCorpus.txt");
        PrintWriter out = new PrintWriter(file);
        out.println(headlinesCorpus);


    }
}
