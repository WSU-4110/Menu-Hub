package com.example.menuhub;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataParser {

    private HashMap<String, String> getPlace(JSONObject googlePlacesJason) {
        HashMap<String, String> googlePlacesMap = new HashMap<>();
        String placeName = "-NA-";
        String vicinity = "-NA-";
        String latitude = "";
        String longitude = "";
        String reference = "";

        Log.d("DataParser","jsonobject = " + googlePlacesJason.toString());

        try {
            if (!googlePlacesJason.isNull("name")) {
                placeName = googlePlacesJason.getString("name");
            }
            if (!googlePlacesJason.isNull("vicinity")) {
                vicinity = googlePlacesJason.getString("vicinity");
            }
            latitude = googlePlacesJason.getJSONObject("geometry").getJSONObject("location").getString("lat");
            longitude = googlePlacesJason.getJSONObject("geometry").getJSONObject("location").getString("lng");
            reference = googlePlacesJason.getString("reference");

            googlePlacesMap.put("place_name", placeName);
            googlePlacesMap.put("vicinity", vicinity);
            googlePlacesMap.put("lat", latitude);
            googlePlacesMap.put("lng", longitude);
            googlePlacesMap.put("reference", reference);

        } catch (JSONException e) {
                e.printStackTrace();
        }
        return googlePlacesMap;
    }

    private List<HashMap<String,String>> getPlaces(JSONArray jsonArray) {
        int count = jsonArray.length();
        List<HashMap<String,String>> placesList = new ArrayList<>();
        HashMap<String,String> placeMap = null;

        for(int i = 0; i < count; i++) {
            try {
                placeMap = getPlace((JSONObject) jsonArray.get(i));
                placesList.add(placeMap);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return  placesList;
    }

    public List<HashMap<String,String>> parse(String jsonData) {
        JSONArray jsonArray = null;
        JSONObject jsonObject;

        Log.d("json data",jsonData);

        try {
            jsonObject = new JSONObject(jsonData);
            jsonArray = jsonObject.getJSONArray("results");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return getPlaces(jsonArray);
    }
}
