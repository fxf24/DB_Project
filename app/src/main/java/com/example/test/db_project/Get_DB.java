package com.example.test.db_project;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.BaseAdapter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Get_DB<T, S extends BaseAdapter> extends AsyncTask<String, Void, String> {
    private String myJSON;
    private int category;
    private JSONArray data = null;
    private ArrayList<T> dataset;
    private S adapter;

    public Get_DB(int category, ArrayList<T> dataset, S adapter) {
        this.category = category;
        this.dataset = dataset;
        this.adapter = adapter;
    }

    private void showOrganization() {
        try {
            JSONObject jsonObj = new JSONObject(myJSON);
            data = jsonObj.getJSONArray("result");

            for (int i = 0; i < data.length(); i++) {
                JSONObject c = data.getJSONObject(i);
                String name = c.getString("name");
                String position = c.getString("position");
                String phone = c.getString("phone");

                dataset.add((T) new staff_info(name, position, phone));
                adapter.notifyDataSetChanged();
            }
        } catch (Exception e) {
            Log.e("test2", e.toString());
        }
    }

    private void showBill() {
        try {
            JSONObject jsonObj = new JSONObject(myJSON);
            data = jsonObj.getJSONArray("result");

            for (int i = 0; i < data.length(); i++) {
                JSONObject c = data.getJSONObject(i);
                String name = c.getString("name");
                String date = c.getString("date");
                String type = c.getString("type");
                String item = c.getString("item");
                String amount = c.getString("amount");
                String price = c.getString("price");

                dataset.add((T) new Bill_data(name, date, type, item, amount,price));
                adapter.notifyDataSetChanged();
            }
        } catch (Exception e) {
            Log.e("test2", e.toString());
        }
    }

    private void showParking() {
        try {
            JSONObject jsonObj = new JSONObject(myJSON);
            data = jsonObj.getJSONArray("result");

            for (int i = 0; i < data.length(); i++) {
                JSONObject c = data.getJSONObject(i);
                String location = c.getString("location");
                String availability = c.getString("availability");
                int src;
                if(availability.equals("yes"))
                    src = R.drawable.parking_p;
                else
                    src = R.drawable.parking_n;


                dataset.add((T) new Grid_data(src, location));
                adapter.notifyDataSetChanged();
            }
        } catch (Exception e) {
            Log.e("test2", e.toString());
        }
    }
    protected String doInBackground(String... params) {

        String uri = "http://192.168.0.18/"+params[0];
        String param = params[1];

        Log.e("test2", uri);
        BufferedReader bufferedReader = null;
        try {
            URL url = new URL(uri);
            Log.d("nomal", url.toString());
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            StringBuilder sb = new StringBuilder();

            con.setRequestMethod("POST");
            con.setDoInput(true);
            con.setDoOutput(true);
            con.setRequestProperty("content-type", "application/x-www-form-urlencoded");

            Log.e("test2", param);
            /* 안드로이드 -> 서버 파라메터값 전달 */
            OutputStream outputStream = con.getOutputStream();
            Log.e("test2", "connect1");
            outputStream.write(param.getBytes("UTF-8"));
            outputStream.flush();
            outputStream.close();

            Log.d("nomal", "test2");
            InputStream inputStream;
            int responseStatusCode = con.getResponseCode();
            Log.d("nomal", "response code - " + responseStatusCode);
            if (responseStatusCode == HttpURLConnection.HTTP_OK) {
                inputStream = con.getInputStream();
            } else {
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
            Log.e("test2", e.toString());
            return "error";
        }
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        myJSON = result;
        Log.e("test2", myJSON);

        switch (category) {
            case 1:
                showOrganization();
                break;
            case 2:
                showBill();
                break;
            case 3:
                showParking();
                break;
            default:

                break;
        }
    }
}

