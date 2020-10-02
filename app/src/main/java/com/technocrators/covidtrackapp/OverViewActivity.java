package com.technocrators.covidtrackapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class OverViewActivity extends AppCompatActivity {

    private TextView text1, text2, text3, text4;
    private Map<String, String> map = new HashMap<>();
    private String  url = "https://api.apify.com/v2/key-value-stores/toDWvRj1JpTXiM8FF/records/LATEST";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_over_view);

        text1 = findViewById(R.id.total_cases);
        text2 = findViewById(R.id.active_cases);
        text3 = findViewById(R.id.recovered);
        text4 = findViewById(R.id.deceased);

        RequestQueue requestQueue = Volley.newRequestQueue(OverViewActivity.this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    map.put("activeCases", response.get("activeCases").toString());
                    map.put("activeCasesNew", response.get("activeCasesNew").toString());
                    map.put("recovered", response.get("recovered").toString());
                    map.put("recoveredNew", response.get("recoveredNew").toString());
                    map.put("deaths", response.get("deaths").toString());
                    map.put("deathsNew", response.get("deathsNew").toString());
                    map.put("totalCases", response.get("totalCases").toString());

                    text1.setText(map.get("totalCases"));
                    text2.setText(map.get("activeCases"));
                    text3.setText(map.get("recovered"));
                    text4.setText(map.get("deaths"));

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        requestQueue.add(jsonObjectRequest);


    }
}