package com.example.corentin.td6;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Corentin on 31/05/2017.
 */

public class Resultat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        final TextView textView = (TextView) findViewById(R.id.textView);

        Intent intent = this.getIntent();
        String film = intent.getStringExtra("Film");
        film = film.replaceAll("\\s", "\\+");

        String url = "https://api.themoviedb.org/3/search/movie?api_key=67e311a7c21dbb5f13026fae8fc5dd0f&query="+film;

        RequestQueue queue = Volley.newRequestQueue(this);

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                       try {
                            int nbResultatResponse = new Integer(response.get("total_results").toString());
                            List<Film> listFilm = new ArrayList<Film>();
                            for (int i=0; i<nbResultatResponse; i++){
                                JSONObject jsonObject = response.getJSONArray("results").getJSONObject(i);
                                listFilm.add(new Film(
                                        jsonObject.getString("original_title"),
                                        jsonObject.getString("overview"),
                                        jsonObject.getString("poster_path"),
                                        jsonObject.getString("backdrop_path")
                                ));
                            }

                            textView.setText("Nombre de resultat : "+listFilm.toString());
                       } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub

                    }
                });

        // Access the RequestQueue through your singleton class.
        queue.add(jsObjRequest);
    }
}
