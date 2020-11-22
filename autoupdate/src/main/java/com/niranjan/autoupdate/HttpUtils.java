package com.niranjan.autoupdate;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtils {

    public static String get(String urlStr) {
        String result = null;
        HttpURLConnection urlConnection = null;
        InputStream stream = null;
        BufferedReader bufferedReader = null;
        try {
            URL url = new URL(urlStr);
            urlConnection = (HttpURLConnection) url.openConnection();

            stream = new BufferedInputStream(urlConnection.getInputStream());
            bufferedReader = new BufferedReader(new InputStreamReader(stream));
            StringBuilder builder = new StringBuilder();

            String inputString;
            while ((inputString = bufferedReader.readLine()) != null) {
                builder.append(inputString);
            }

            result=builder.toString();
            urlConnection.disconnect();
        } catch (IOException e) {
            Log.e(Constants.TAG, "http  error");
        }
        return result;

    }
}
