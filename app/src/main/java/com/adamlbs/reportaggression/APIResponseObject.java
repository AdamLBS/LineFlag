package com.adamlbs.reportaggression;
import java.net.HttpURLConnection;

import android.content.Context;
import android.os.AsyncTask;
import java.io.OutputStream;
import java.net.*;
import java.io.*;
import java.util.*;
import android.util.Pair;
import android.util.*;


public class APIResponseObject {

    int responseCode;
    String response;

    APIResponseObject(int responseCode, String response) {
        this.responseCode = responseCode;
        this.response = response;
    }


   public static class APIAccessTask extends AsyncTask<String, Void, APIResponseObject> {
        URL requestUrl;
        Context context;
        HttpURLConnection urlConnection;
        List<Pair<String, String>> postData, headerData;
        String method;
        int responseCode = HttpURLConnection.HTTP_OK;

        interface OnCompleteListener {
            void onComplete(APIResponseObject result);
        }

        public OnCompleteListener delegate = null;

        APIAccessTask(Context context, String requestUrl, String method, OnCompleteListener delegate) {
            this.context = context;
            this.delegate = delegate;
            this.method = method;
            try {
                this.requestUrl = new URL(requestUrl);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        APIAccessTask(Context context, String requestUrl, String method, List<Pair<String, String>> postData, OnCompleteListener delegate) {
            this(context, requestUrl, method, delegate);
            this.postData = postData;
        }

        APIAccessTask(Context context, String requestUrl, String method, List<Pair<String, String>> postData,
                      List<Pair<String, String>> headerData, OnCompleteListener delegate) {
            this(context, requestUrl, method, postData, delegate);
            this.headerData = headerData;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected APIResponseObject doInBackground(String... params) {
            Log.d("debug", "url = " + requestUrl);
            try {
                urlConnection = (HttpURLConnection) requestUrl.openConnection();

                if (headerData != null) {
                    for (Pair pair : headerData) {
                        urlConnection.setRequestProperty(pair.first.toString(), pair.second.toString());
                    }
                }

                urlConnection.setDoInput(true);
                urlConnection.setChunkedStreamingMode(0);
                urlConnection.setRequestMethod(method);
                urlConnection.connect();

                StringBuilder sb = new StringBuilder();

                if (!(method.equals("GET"))) {
                    OutputStream out = new BufferedOutputStream(urlConnection.getOutputStream());
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));
                    writer.write(getPostDataString(postData));
                    writer.flush();
                    writer.close();
                    out.close();
                }

                urlConnection.connect();
                responseCode = urlConnection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
                    String line;

                    while ((line = reader.readLine()) != null) {
                        sb.append(line);
                    }
                }

                return new APIResponseObject(responseCode, sb.toString());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(APIResponseObject result) {
            delegate.onComplete(result);
            super.onPostExecute(result);
        }

        private String getPostDataString(List<Pair<String, String>> params) throws UnsupportedEncodingException {
            StringBuilder result = new StringBuilder();
            boolean first = true;
            for (Pair<String, String> pair : params) {
                if (first)
                    first = false;
                else
                    result.append("&");

                result.append(URLEncoder.encode(pair.first, "UTF-8"));
                result.append("=");
                result.append(URLEncoder.encode(pair.second, "UTF-8"));
            }
            return result.toString();
        }
    }
}