package com.example.calcfront.Classes;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.Console;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class RequestSender extends AsyncTask<String, String, String> {

    private static final String baseURL = "http://192.168.10.16/api/calc/count";

    private String param1;
    private String param2;
    private String act;
    private String url;
    private IActionManager actionManager;
    private StringBuilder builder =  new StringBuilder();

    public RequestSender(String param1, String param2, String act, ActionManager actionManager) {
        this.param1 = param1;
        this.param2 = param2;
        this.act = act;
        this.url = String.format("%s/%s/%s/%s", baseURL, param1, param2, act);
        this.actionManager = actionManager;
    }

    @Override
    protected String doInBackground(String... strings) {
        try {
            URL link = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) link.openConnection();
            InputStream inputStream = new BufferedInputStream(connection.getInputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            connection.connect();
            String t;
            builder.setLength(0);
            while ((t = reader.readLine()) != null)
                builder.append(t);
            reader.close();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        actionManager.showResult(builder.toString());
    }
}
