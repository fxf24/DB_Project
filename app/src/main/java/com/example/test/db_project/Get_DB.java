package com.example.test.db_project;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Get_DB {

    String myJSON;

    private static final String TAG_RESULTS = "result";
    private static final String TAG_ID = "id";
    private static final String TAG_NAME = "name";
    private static final String TAG_ADD = "address";

    JSONArray peoples = null;


    protected void showList() {
        try {
            JSONObject jsonObj = new JSONObject(myJSON);
            peoples = jsonObj.getJSONArray(TAG_RESULTS);
//
//            for (int i = 0; i < peoples.length(); i++) {
//                JSONObject c = peoples.getJSONObject(i);
//                String id = c.getString(TAG_ID);
//                String name = c.getString(TAG_NAME);
//                String address = c.getString(TAG_ADD);
//
//                personList.add(new Data(id, name, address));
//                adapter.notifyDataSetChanged();
//            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void getData(String url) {
        class GetDataJSON extends AsyncTask<String, Void, String> {

            @Override
            protected String doInBackground(String... params) {

                String uri = params[0];

                BufferedReader bufferedReader = null;
                try {
                    URL url = new URL(uri);
                    Log.d("nomal", url.toString());
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    StringBuilder sb = new StringBuilder();

                    Log.d("nomal", "test2");
                    InputStream inputStream;
                    int responseStatusCode = con.getResponseCode();
                    Log.d("nomal", "response code - " + responseStatusCode);
                    if(responseStatusCode == HttpURLConnection.HTTP_OK) {
                        inputStream = con.getInputStream();
                    }
                    else{
                        inputStream = con.getErrorStream();
                    }
                    Log.d("nomal", "test3");
                    bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));

                    Log.d("nomal", "test4");
                    String json;
                    while ((json = bufferedReader.readLine()) != null) {
                        sb.append(json + "\n");
                    }

                    return sb.toString().trim();

                } catch (Exception e) {
                    Log.d("nomal", e.toString());
                    return "error";
                }
            }

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);
                myJSON = result;
                Log.d("nomal", myJSON);
                showList();
            }
        }
        GetDataJSON g = new GetDataJSON();
        g.execute(url);
    }
}
