package com.github.smartbv2.fact_checker;


import org.aksw.fox.binding.java.FoxApi;
import org.aksw.fox.binding.java.FoxParameter;
import org.aksw.fox.binding.java.IFoxApi;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Varma G.S.
 */
public class ConnectFOX {

    //public final static Logger LOG = LogManager.getLogger(ConnectFOX.class);

    public void getPerson(String statement) throws MalformedURLException, FileNotFoundException {

        PrintStream out = new PrintStream(new FileOutputStream("output_fox.json"));
        System.setOut(out);

        final IFoxApi fox = new FoxApi();
        fox.setApiURL(new URL("http://fox-demo.aksw.org/fox"));

        fox.setTask(FoxParameter.TASK.NER);
        fox.setLang(FoxParameter.LANG.EN);

        //fox.setOutputFormat(FoxParameter.OUTPUT.TURTLE);
        fox.setOutputFormat(FoxParameter.OUTPUT.JSONLD);

        fox.setInput(statement);

        // LOG.info(fox.send());
        String response = fox.send();
        System.out.println(response);


    }

}
