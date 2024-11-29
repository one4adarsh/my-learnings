package org.example.part_7_misc._1_hackerrank_rest_api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import javax.script.*;

/*
 * REST API: Number of Drawn Matches
 */
public class Hackerrank2 {
    private static int getTotalNumDraws(String request) throws IOException {
        URL url = new URL(request);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setConnectTimeout(5000);
        httpURLConnection.setReadTimeout(5000);
        httpURLConnection.addRequestProperty("Content-Type", "application/json");

        int status = httpURLConnection.getResponseCode();
        InputStream in = (status != 200) ?
                httpURLConnection.getErrorStream() : httpURLConnection.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        String responseline;
        StringBuffer responseContent = new StringBuffer();
        while ((responseline = br.readLine()) != null) {
            responseContent.append(responseline);
        }
        br.close();
        httpURLConnection.disconnect();

        String script = "var obj = " + responseContent + ";";
        script += "var total = obj.total;";

        // For Java 17
        // implementation("org.openjdk.nashorn:nashorn-core:15.4")
        ScriptEngine ee = new ScriptEngineManager().getEngineByName("Nashorn");

        /*
         ** this works for Java 8 but not Java 17 **
         *
         * String script = "var obj = JSON.parse('" + responseContent.toString() + "');";
         * script += "var total = obj.total;";
         *
         * ScriptEngineManager manager = new ScriptEngineManager();
         * ScriptEngine engine = manager.getEngineByName("JavaScript");
         *
         */

        try {
            ee.eval(script);
        } catch (ScriptException ex) {
            ex.printStackTrace();
        }

        if (ee.get("total") == null) {
            throw new RuntimeException("Cannot retrieve data from the server.");
        }

        return (int) ee.get("total");
    }

    public static int getNumDraws(int year) throws IOException {
        final String EndPoint = "https://jsonmock.hackerrank.com/api/football_matches?year=" + year;
        final int MaxScore = 10;

        int totalNumDraws = 0;
        for (int score = 0; score <= MaxScore; score++) {
            totalNumDraws += getTotalNumDraws(String.format(EndPoint + "&team1goals=%d&team2goals=%d", score, score));
        }

        return totalNumDraws;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(getNumDraws(2011));
    }
}
