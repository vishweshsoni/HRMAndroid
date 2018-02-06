package com.hrms.vsoni.hrms;

import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by vishwesh on 1/1/18.
 */

public class BackgroundWorker extends AsyncTask<Httpcall,String,String> {

    Fragment parent;
    BackgroundWorker(Fragment parent){
        this.parent = parent;

    }
    public interface goBackToParentFragment {
        void setResponse(Employee s);
       void showError(String message);
    }
    @Override
    protected String doInBackground(Httpcall... params) {
        HttpURLConnection urlConnection=null;
        Httpcall httpcall =params[0];
        StringBuilder response = new StringBuilder();
        try {
            String dataParams=getPostDataString(httpcall.getParams());
            URL url=new URL("http://192.168.43.127:3000/login");
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setDoOutput(true);
            urlConnection.setDoInput(true);

            urlConnection.setReadTimeout(10000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);
            if(httpcall.getParams()!=null){

                OutputStream os = urlConnection.getOutputStream();
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(os, "UTF-8"));
                writer.append(dataParams);
                writer.flush();
                writer.close();
                os.close();//node code
            }

            int responseCode = urlConnection.getResponseCode();

            if(responseCode == HttpURLConnection.HTTP_OK){
                String line ;
                BufferedReader br = new BufferedReader( new InputStreamReader(urlConnection.getInputStream()));
                while ((line = br.readLine()) != null){
                    response.append(line);
                }
            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            urlConnection.disconnect();
        }
        String res=response.toString();

        return res;
    }

    @Override
    protected void onPostExecute(String s){ //see
      try {

           JSONObject jObject = new JSONObject(s);
            boolean isLogin = jObject.getBoolean("flag");
            if (isLogin){
                //Fragment setResponse
                JSONArray employees = jObject.getJSONArray("result");
                Employee emp = new Employee();
                for (int i = 0; i < employees.length() ; i++){
                    JSONObject emplJSON = employees.getJSONObject(i);
                    emp.setId(emplJSON.getInt("id"));
                    emp.setUsername(emplJSON.getString("username"));
                    emp.setPassword(emplJSON.getString("password"));
                    emp.setGender(emplJSON.getString("gender"));
                    emp.setEmail(emplJSON.getString("email"));

                }
                if (parent instanceof LoginFragment){
                    ((LoginFragment)parent).setResponse(emp);
                }
                return;
            }
            else {

                String errorMessage = jObject.getString("message");
                Log.d("error",s);
                if (parent instanceof LoginFragment){
                    ((LoginFragment)parent).showError(errorMessage);
                }
                return;

                //setError
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

       super.onPostExecute(s);
        if ( s != null)
            Log.i("Json",s);
        else {
            Log.d("BACKGROUNDWORKER----->","Failed, something went wrong!");
        }
    }


    private String getPostDataString(HashMap<String, String> params) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        boolean first = true;
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (first)
                first = false;
            else
                result.append("&");
            result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
        }

        return result.toString();
    }


}
