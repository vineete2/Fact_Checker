package com.github.smartbv2.fact_checker;

import edu.stanford.nlp.ie.AbstractSequenceClassifier;
import edu.stanford.nlp.ie.crf.CRFClassifier;
import edu.stanford.nlp.ling.CoreLabel;
import org.apache.log4j.varia.NullAppender;

import java.io.IOException;
import java.util.List;

/**
 * Sample Named Entity Extraction Program
 */
public class Starter {

    private static final org.apache.log4j.Logger logger = org.apache.log4j.LogManager.getLogger(Starter.class);

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // Default log configuration
        org.apache.log4j.BasicConfigurator.configure(new NullAppender());

        // Model - 7 class:	Location, Person, Organization, Money, Percent, Date, Time
        String model = "src/models/ner/english.muc.7class.distsim.crf.ser.gz";

        AbstractSequenceClassifier<CoreLabel> classifier = CRFClassifier.getClassifier(model);

        String text = "The New York Times is an American newspaper based in New York City with worldwide influence " +
                "and readership. Founded in 1851, the paper has won 122 Pulitzer Prizes, " +
                "more than any other newspaper. ";

        System.out.println(classifier.classifyToString(text, "tsv", true));

        // Indexing words
        int i = 0;
        for (List<CoreLabel> listCL : classifier.classify(text)) {
            for (CoreLabel coreLabel : listCL) {
                System.out.print(i++ + ":");
                System.out.println(coreLabel);

            }
        }
    }
}