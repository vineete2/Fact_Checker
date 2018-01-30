package com.github.smartbv2.fact_checker;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class Checker {

    static int wordsFound;
    static int wordsInput;
    static String[] unig;


    // public static void main(String[] args) throws Exception { // main
    //String[] static unig;
    public static void convertToUnigram(String inputstmt, String trigger) throws IOException {   //class call


        //  String trigger = "Britney_Spears";
        // String inputstmt = "Britney_Spears is Kevin Federline's better half. ";
        String in = cleanText(inputstmt);
        String key = cleanText(trigger);
        System.out.println(in);
        System.out.println(key);

        String matchstr = removeKey(in, key);

        System.out.println(matchstr);
        unig = generateUnigram(matchstr);


//        for (int i = 0; i < unig.length; i++) {
//            System.out.println(i + "  " + unig[i]);
//
//        }


//
    }


    //} //Main end


    public static int[] verifyText() throws IOException {


        // BufferedReader dbcompare = new BufferedReader(new FileReader("output_dbpedia.txt"));

        File file = new File("data/outputs/output_dbpedia.txt");
        FileInputStream fis = new FileInputStream(file);
        byte[] data = new byte[(int) file.length()];
        fis.read(data);
        fis.close();

        String outdb = new String(data, "UTF-8");

        wordsFound = 0;

        for (int i = 0; i < unig.length; i++) {

            System.out.println(i + "  " + unig[i]);
            wordsFound = wordsFound + countwords(unig[i], outdb);
        }
        System.out.println("total words found: " + wordsFound);
        wordsInput = unig.length;
        System.out.println("total words queried: " + wordsInput);

        int[] output = new int[2];
        output[0] = wordsFound;
        output[1] = wordsInput;


        return output;
    }

    public static int countwords(String str, String outdb) {
        int count = 1;

        if (outdb.contains(str)) {

            //   System.out.println(count);
            return count;
        } else
            return 0;


    }

    public static String cleanText(String str) throws IOException {

        // Tokenize str ( statement )
        String[] words = str.split(" ");

        ArrayList wordList =new ArrayList(Arrays.asList(words));
       // List<String> wordList = Arrays.asList(words);
        String[] stopWords = findStopWords();
        for (String word : words) {
            for (String stopWord : stopWords) {

                if (word.equals(stopWord)) {
                    wordList.remove(word);
                }
            }
        }



        String after = String.join(" ", wordList);


        after = str.replaceAll("'s", "");
        after = after.replaceAll("_", " ");
        after = after.replaceAll(" is", "");

        after = after.replaceAll("[^a-zA-Z\\d\\s]+", "");
       after = after.trim().replaceAll("[ ]{2,}", " ");
        return after;
    }

    public static String removeKey(String in, String key) {

        String matchstr = "";

        matchstr = in.replaceAll(key, "");
        matchstr = matchstr.trim();

        return matchstr;
    }

    public static String[] generateUnigram(String matchstr) throws IOException {
        matchstr = matchstr.trim().replaceAll("[ ]{2,}", " ");

        String[] words = matchstr.split(" ");

        return words;

    }

    public static String[] findStopWords() throws IOException {
        Path filePath = new File("data/stopwords.txt").toPath();
        Charset charset = Charset.defaultCharset();
        List<String> stringList = Files.readAllLines(filePath, charset);
        String[] stopWords = stringList.toArray(new String[]{});

        return stopWords;

    }


}
