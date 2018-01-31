package com.github.smartbv2.fact_checker;

import java.io.*;


public class ReadInput {

    public static void main(String[] args) throws Exception {
        int[] words;
        String dataRow;


        BufferedReader TSVFile =
                new BufferedReader(new FileReader("data/test.tsv"));


        String dataRow0 = TSVFile.readLine(); // Read first line which has Heading --not required to send.

        while ((dataRow = TSVFile.readLine()) != null) {
            // dataRow = TSVFile.readLine();  // Set the first line of TSV input file

            String[] dataArray = dataRow.split("\t");
            words = Main.main(dataArray[1]);
            double confidence = calculateconfidence(words);
            // System.out.println(confidence);


            printFile(dataArray[0], dataArray[1], confidence);

        }

        TSVFile.close();
    }

    private static double calculateconfidence(int[] words) {

        double fl = (double) words[0] / words[1];
        // Threshold Value: 0.5
//        if (fl >= 0.5)
//            return (float)1.0;
//        else
//            return (float)0.0;
        return fl;
    }

    private static void printFile(String FactID, String stmt, double confidence) {
        try {

//            String finalcsv = "data/outputs/final.tsv";
//            FileWriter fos = new FileWriter(finalcsv, true);
//            PrintWriter dos = new PrintWriter(fos);
//
//            File file = new File(finalcsv);
//            if (file.length() == 0) {
//                dos.print("FactID\tFact_Statement\tTrue/False\t");
//                dos.println();
//            }
//            dos.print(FactID + "\t");
//            dos.print(stmt + "\t");
//            dos.print(confidence + "\t");

            // Result file in ttl format for SWC GERBIL
            String finalcsv = "data/evaluations/result.ttl";
            FileWriter fos = new FileWriter(finalcsv, true);
            PrintWriter dos = new PrintWriter(fos);

            dos.print("<http://swc2017.aksw.org/task2/dataset/" + FactID + "> ");
            dos.print("<http://swc2017.aksw.org/hasTruthValue> \"");
            dos.print(confidence + "\"^^<http://www.w3.org/2001/XMLSchema#double> .");
            dos.println();

            dos.close();
            fos.close();
        } catch (IOException e) {
            System.out.println("Error Printing Tab Delimited File");
        }
    }
}
