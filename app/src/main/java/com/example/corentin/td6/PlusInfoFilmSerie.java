package com.example.corentin.td6;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

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

        final TextView titre = (TextView) findViewById(R.id.textViewPlusDetailTitre);
        final TextView dateDeSortie = (TextView) findViewById(R.id.textViewPlusDetailDateSortie);
        final TextView description = (TextView) findViewById(R.id.textViewPlusDetailDescription);
        final ImageView poster = (ImageView) findViewById(R.id.imageViewPlusDetailPoster);
        final ImageView fond = (ImageView) findViewById(R.id.imageViewPlusDetailFond);
        final TextView production = (TextView) findViewById(R.id.textViewPlusDetailProduction);
        final TextView genres = (TextView) findViewById(R.id.textViewPlusDetailGenres);
        final RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);

        Intent intent = this.getIntent();
        int id = intent.getIntExtra("id", 0);

        String url = "";
        final String typeDemander = intent.getStringExtra("TypeDemander");
        if (typeDemander.contentEquals("Film")) {
            url = "https://api.themoviedb.org/3/movie/" + id + "?api_key=67e311a7c21dbb5f13026fae8fc5dd0f&language=fr";

            RequestQueue queue = Volley.newRequestQueue(this);
            final Context context = this.getApplicationContext();

            final JsonObjectRequest jsObjRequest = new JsonObjectRequest
                    (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                        @Override
                        public void onResponse(JSONObject response) {
                            Gson gson = new Gson();
                            final FilmGson filmGson = gson.fromJson(response.toString(), FilmGson.class);
                            Picasso.with(context).load("https://image.tmdb.org/t/p/w500" + filmGson.getPoster_path()).into(poster);
                            Picasso.with(context).load("https://image.tmdb.org/t/p/w1000" + filmGson.getBackdrop_path()).into(fond);
                            titre.setText(filmGson.getTitle());
                            dateDeSortie.setText("Date de sortie : " + filmGson.getRelease_date());
                            production.setText("Production : " + filmGson.getProduction());
                            description.setText(filmGson.getOverview());
                            genres.setText("Genres : " + filmGson.getGenre());
                            float result = filmGson.getPopularity()/2;
                            ratingBar.setRating(result);
                        }

                    }, new Response.ErrorListener() {

                        @Override
                        public void onErrorResponse(VolleyError error) {
                            // TODO Auto-generated method stub
                        }
                    });

            // Access the RequestQueue through your singleton class.
            queue.add(jsObjRequest);

        } else if (typeDemander.contentEquals("Serie")) {
            url = "https://api.themoviedb.org/3/tv/+"+id+"?api_key=67e311a7c21dbb5f13026fae8fc5dd0f&language=fr";

            RequestQueue queue = Volley.newRequestQueue(this);
            final Context context = this.getApplicationContext();

            final JsonObjectRequest jsObjRequest = new JsonObjectRequest
                    (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                        @Override
                        public void onResponse(JSONObject response) {
                            Gson gson = new Gson();
                            final SerieGson serieGson = gson.fromJson(response.toString(), SerieGson.class);
                            Picasso.with(context).load("https://image.tmdb.org/t/p/w500" + serieGson.getPoster_path()).into(poster);
                            Picasso.with(context).load("https://image.tmdb.org/t/p/w1000" + serieGson.getBackdrop_path()).into(fond);
                            titre.setText(serieGson.getOriginal_name());
                            dateDeSortie.setText("Crée par : " + serieGson.getCreate_by());
                            production.setText("Production : " + serieGson.getProduction());
                            description.setText(serieGson.getOverview());
                            genres.setText("Genres : " + serieGson.getGenre());
                            float result = serieGson.getPopularity()/2;
                            ratingBar.setRating(result);
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

        ratingBar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(PlusInfoFilmSerie.this,
                        "Vallue"+ratingBar.getRating(),
                        Toast.LENGTH_SHORT).show();

            }

        });
    }


}
