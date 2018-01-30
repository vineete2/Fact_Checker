package com.github.smartbv2.fact_checker;

import edu.stanford.nlp.ie.AbstractSequenceClassifier;
import edu.stanford.nlp.ie.crf.CRFClassifier;
import edu.stanford.nlp.ling.CoreLabel;
import org.apache.log4j.varia.NullAppender;

import java.io.IOException;
import java.util.List;

/**
 * @author Varma G.S.
 * Sample Named Entity Extraction Program
 */
public class Stanford {

    private static final org.apache.log4j.Logger logger = org.apache.log4j.LogManager.getLogger(Stanford.class);

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // Default log configuration
        org.apache.log4j.BasicConfigurator.configure(new NullAppender());

        // Model - 7 class:	Location, Person, Organization, Money, Percent, Date, Time
        String model = "src/models/ner/english.muc.7class.distsim.crf.ser.gz";

        AbstractSequenceClassifier<CoreLabel> classifier = CRFClassifier.getClassifier(model);

        String text = "Nobel Prize in Literature is Winston Churchill's honour";

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