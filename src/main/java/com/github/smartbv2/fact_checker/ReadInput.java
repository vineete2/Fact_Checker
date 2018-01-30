package com.github.smartbv2.fact_checker;

import java.io.*;


public class ReadInput {

    public static void main(String[] args) throws Exception {
        int[] words = new int[2];
        String dataRow = null;


        BufferedReader TSVFile =
                new BufferedReader(new FileReader("data/train.tsv"));


        String dataRow0 = TSVFile.readLine(); // Read first line which has Heading --not required to send.

        while ((dataRow = TSVFile.readLine()) != null) {
            // dataRow = TSVFile.readLine();  // Set the first line of TSV input file

            String[] dataArray = dataRow.split("\t");
            words = Main.main(dataArray[1]);
            float confidence = calculateconfidence(words);
            // System.out.println(confidence);


            printFile(dataArray[0], dataArray[1], confidence);

        }

//        while (dataRow != null) {
//
//            System.out.println(dataArray[1]);
//            Main.main(dataArray[1]);
//
//
////            for (String item : dataArray) {
////                System.out.print(item + "  ");
////            }
////            System.out.println(); // Print the data line.
//            dataRow = TSVFile.readLine(); // Read next line of data.
//        }
// Close the file once all data has been read.


        TSVFile.close();


// End the printout with a blank line.


    }

    public static float calculateconfidence(int[] words) {

        float fl = (float) words[0] / words[1];
        if (fl >= 0.5)
            return (float)1.0;
        else
            return (float)0.0;
    }

    public static void printFile(String FactID, String stmt, float confidence) throws IOException {
        try {
            String finalcsv = "data/outputs/final.tsv";
            FileWriter fos = new FileWriter(finalcsv, true);
            PrintWriter dos = new PrintWriter(fos);

            File file = new File(finalcsv);
            if (file.length() == 0) {
                dos.print("FactID\tFact_Statement\tTrue/False\t");
                dos.println();
            }

            dos.print(FactID + "\t");
            dos.print(stmt + "\t");
            dos.print(confidence + "\t");
            dos.println();

            dos.close();
            fos.close();
        } catch (IOException e) {
            System.out.println("Error Printing Tab Delimited File");
        }
    }

}
