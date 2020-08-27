package com.example.calcfront.Classes;

import android.os.AsyncTask;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RequestSender extends AsyncTask<String, String, String> {

    private static final String baseURL = "http://192.168.10.16/api/calc/count";
    private static final int timeout = 2000;

    private String url;
    private IActionManager actionManager;
    private StringBuilder builder = new StringBuilder();

    public RequestSender(String param1, String param2, String act, ActionManager actionManager) {
        this.url = String.format("%s/%s/%s/%s", baseURL, param1, param2, act);
        this.actionManager = actionManager;
    }

    @Override
    protected String doInBackground(String... strings) {
        HttpURLConnection connection = null;
        try {
            URL link = new URL(url);
            connection = (HttpURLConnection) link.openConnection();
            connection.setConnectTimeout(timeout);

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
            cancel(false);
        } finally {
            if (connection != null)
                connection.disconnect();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        actionManager.showResult(builder.toString());
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
        actionManager.actionCancel();
    }
}
