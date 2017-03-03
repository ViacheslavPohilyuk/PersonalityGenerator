package org.person.generator.app.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by mac on 28.01.17.
 */
public class URLConnectionReader {
    private URL randus;
    private URLConnection yc;
    private String result;

    public String randPersonData() {
        connectURL();
        jsonPersonData();
        return result;
    }

    private void connectURL() {
        try {
            randus = new URL("http://randus.ru/api.php");
        }
        catch (MalformedURLException e) {
            System.err.println("Wrong URL-string!");
            e.printStackTrace();
        }

        try {
            yc = randus.openConnection();
        }
        catch (IOException e) {
            System.err.println("");
            e.printStackTrace();
        }
    }

    private void jsonPersonData() {
        StringBuilder jsonResult = new StringBuilder();

        try(BufferedReader in =
                    new BufferedReader(
                            new InputStreamReader(yc.getInputStream()))) {

            String inputLine;
            while ((inputLine = in.readLine()) != null)
                jsonResult.append(inputLine);
        }
        catch (IOException e) {
            System.err.println("Can't write person data in the json-string!");
            e.printStackTrace();
        }

        result = jsonResult.toString();
    }

}