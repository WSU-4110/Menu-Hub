package com.example.menuhub;

import android.os.AsyncTask;

import com.google.android.gms.maps.GoogleMap;

import java.io.IOException;

public class GetNearbyData extends AsyncTask<Object, String, String> {

    String googlePlaceData;
    GoogleMap mMap;
    String url;

    @Override
    protected String doInBackground(Object... objects) {
        mMap = (GoogleMap)objects[0];
        url = (String)objects[1];

        DownloadUrl downloadUrl = new DownloadUrl();
        try {
            googlePlaceData = downloadUrl.readUrl(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return googlePlaceData;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}
