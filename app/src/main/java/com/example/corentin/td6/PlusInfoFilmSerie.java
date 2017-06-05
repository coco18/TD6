package com.example.corentin.td6;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Corentin on 05/06/2017.
 */

public class PlusInfoFilmSerie  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plus_detail_film_serie);

        final TextView textView = (TextView) findViewById(R.id.textView2);

        Intent intent = this.getIntent();
        int id = intent.getIntExtra("id",0);

        String url ="";
        final String typeDemander = intent.getStringExtra("TypeDemander");
        if (typeDemander.contentEquals("Film")){
            url = "https://api.themoviedb.org/3/movie/"+id+"?api_key=67e311a7c21dbb5f13026fae8fc5dd0f&language=fr";
        } else if(typeDemander.contentEquals("Serie")){
            url = "https://api.themoviedb.org/3/search/tv?api_key=67e311a7c21dbb5f13026fae8fc5dd0f&language=fr";
        } else if (typeDemander.contentEquals("Personne")){
            url = "https://api.themoviedb.org/3/search/person?api_key=67e311a7c21dbb5f13026fae8fc5dd0f&language=fr";
        } else {
            url = "https://api.themoviedb.org/3/search/multi?api_key=67e311a7c21dbb5f13026fae8fc5dd0f&language=fr";
        }


        RequestQueue queue = Volley.newRequestQueue(this);


        final JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Gson gson = new Gson();
                        final FilmGson filmGson = gson.fromJson(response.toString(), FilmGson.class);
                        textView.setText(filmGson.toString());
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
