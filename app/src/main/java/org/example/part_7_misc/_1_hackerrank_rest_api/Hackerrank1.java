package org.example.part_7_misc._1_hackerrank_rest_api;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/*
 * REST API: Total Goals by a Team
 */
public class Hackerrank1 {

    private static int getPageTotalGoals(String request, int totalGoals, String team, int page) throws IOException {
        URL url = new URL(request + "&page=" + page);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setConnectTimeout(5000);
        httpURLConnection.setReadTimeout(5000);
        httpURLConnection.addRequestProperty("Content-Type", "application/json");

        int status = httpURLConnection.getResponseCode();
        InputStream in = (status < 200 || status > 299) ?
                httpURLConnection.getErrorStream() : httpURLConnection.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        String responseLine;
        StringBuffer responseContent = new StringBuffer();
        while ((responseLine = br.readLine()) != null) {
            responseContent.append(responseLine);
        }
        br.close();
        httpURLConnection.disconnect();

        String script = "var obj = " + responseContent + ";";

        script += "var total_pages = obj.total_pages;";
        script += "var total_goals = obj.data.reduce( function(acc, current) { return acc + parseInt(current." + team + "goals); }, 0);";

        ScriptEngine ee = new ScriptEngineManager().getEngineByName("Nashorn");

        try {
            ee.eval(script);
        } catch (ScriptException ex) {
            ex.printStackTrace();
        }

        if (ee.get("total_pages") == null) {
            throw new RuntimeException("Cannot retrieve data from the server.");
        }

        int totalPages = (int) ee.get("total_pages");
        totalGoals += (int) Double.parseDouble(ee.get("total_goals").toString());


        return (page < totalPages) ? getPageTotalGoals(request, totalGoals, team, page + 1) : totalGoals;
    }

    public static int getTotalGoals(String team, int year) throws IOException {
        final String EndPoint = "https://jsonmock.hackerrank.com/api/football_matches";

        int totalGoalsAtHome = getPageTotalGoals(String.format(EndPoint + "?team1=%s&year=%d", URLEncoder.encode(team, "UTF-8"), year), 0, "team1", 1);
        int totalGoalsAtVisiting = getPageTotalGoals(String.format(EndPoint + "?team1=%s&year=%d", URLEncoder.encode(team, "UTF-8"), year), 0, "team2", 1);

        return totalGoalsAtHome + totalGoalsAtVisiting;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(getTotalGoals("Chelsea", 2014));
    }
}
