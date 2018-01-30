package com.github.smartbv2.fact_checker;


import org.aksw.fox.binding.java.FoxApi;
import org.aksw.fox.binding.java.FoxParameter;
import org.aksw.fox.binding.java.IFoxApi;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Varma G.S.
 */
public class FoxExample {

    //public final static Logger LOG = LogManager.getLogger(FoxExample.class);

    public static void main(String[] a) throws Exception {
        example();
    }

    public static void example() throws MalformedURLException {

        final IFoxApi fox = new FoxApi();
        fox.setApiURL(new URL("http://fox-demo.aksw.org/fox"));

        fox.setTask(FoxParameter.TASK.NER);
        fox.setLang(FoxParameter.LANG.EN);

        fox.setOutputFormat(FoxParameter.OUTPUT.TURTLE);
        // fox.setOutputFormat(FoxParameter.OUTPUT.JSONLD);

        fox.setInput("Golden State Warriors is Jamal Crawford's squad");
        // fox.setInput(new URL("https://en.wikipedia.org/wiki/India"));

        // LOG.info(fox.send());
        String response = fox.send();
        System.out.println(response);
    }

}
