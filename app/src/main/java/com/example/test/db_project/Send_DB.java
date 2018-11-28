package com.example.test.db_project;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Send_DB extends AsyncTask<String, Void, String> {
    String text;
    Context context;

    public Send_DB(Context context){
        this.context = context;
    }

    @Override
    protected String doInBackground(String... params) {
        String uri = params[0];
        /* 인풋 파라메터값 생성 */
        String param = "u_id=" + params[1] + "&u_pw" + params[2];
        Log.e("test1",param);
        try {
            /* 서버연결 */
            URL url = new URL(uri);
            Log.e("test1", url.toString());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(5000);
            conn.setConnectTimeout(5000);
            conn.setRequestMethod("POST");
            conn.connect();


            Log.e("test1", "connect");
            /* 안드로이드 -> 서버 파라메터값 전달 */
            OutputStream outs = conn.getOutputStream();
            outs.write(param.getBytes("UTF-8"));
            outs.flush();
            outs.close();

            Log.e("test1", "connect2");
            /* 서버 -> 안드로이드 파라메터값 전달 */
            InputStream is = null;
            BufferedReader in = null;
            String data = "";

            Log.e("test1", "connect3");
            is = conn.getInputStream();
            in = new BufferedReader(new InputStreamReader(is), 8 * 1024);
            String line = null;
            StringBuffer buff = new StringBuffer();
            while ( ( line = in.readLine() ) != null )
            {
                buff.append(line + "\n");
            }
            data = buff.toString().trim();

            /* 서버에서 응답 */
            Log.e("RECV DATA",data);

            if(data.equals("0"))
            {
                Log.e("RESULT","성공적으로 처리되었습니다!");
                return  data;
            }
            else
            {
                Log.e("RESULT","에러 발생! ERRCODE = " + data);
                return null;
            }

        } catch (Exception e)
        {
            return null;
        }
    }

    @Override
    protected void onPostExecute(String data) {
        super.onPostExecute(data);
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context);

        if(data.equals("1"))
        {
            Log.e("RESULT","성공적으로 처리되었습니다!");
            alertBuilder
                    .setTitle("알림")
                    .setMessage("성공적으로 등록되었습니다!")
                    .setCancelable(true)
                    .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(context, Staff_Start.class);
                            context.startActivity(intent);
                        }
                    });
            AlertDialog dialog = alertBuilder.create();
            dialog.show();
        }
        else if(data.equals("0"))
        {
            Log.e("RESULT","비밀번호가 일치하지 않습니다.");
            alertBuilder
                    .setTitle("알림")
                    .setMessage("비밀번호가 일치하지 않습니다.")
                    .setCancelable(true)
                    .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //finish();
                        }
                    });
            AlertDialog dialog = alertBuilder.create();
            dialog.show();
        }
        else
        {
            Log.e("RESULT","에러 발생! ERRCODE = " + data);
            alertBuilder
                    .setTitle("알림")
                    .setMessage("등록중 에러가 발생했습니다! errcode : "+ data)
                    .setCancelable(true)
                    .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //finish();
                        }
                    });
            AlertDialog dialog = alertBuilder.create();
            dialog.show();
        }
    }
}
