package com.example.menuhub;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class DataParser {

    private HashMap<String, String> getPlace(JSONObject googlePlacesJason) {
        HashMap<String, String> googlePlacesMap = new HashMap<>();
        String placeName = "-NA-";
        String vicinity = "-NA-";
        String latitude = "";
        String longitude = "";
        String reference = "";

        try {
            if (!googlePlacesJason.isNull("name")) {
                placeName = googlePlacesJason.getString("name");
            }
            if (!googlePlacesJason.isNull("vicinity")) {
                vicinity = googlePlacesJason.getString("vicinity");
            }
            latitude = googlePlacesJason.getJSONObject("geometry").getJSONObject("location").getString("lat");
            longitude = googlePlacesJason.getJSONObject("geometry").getJSONObject("location").getString("lng");

            reference = googlePlacesJason.getString("refeence");

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
}
