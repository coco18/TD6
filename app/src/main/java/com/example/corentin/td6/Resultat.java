package com.example.corentin.td6;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
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
        final List<Media> listResultat = new ArrayList<Media>();

        Intent intent = this.getIntent();
        final int nbresultdemander = intent.getIntExtra("Nbresult",10);
        String film = intent.getStringExtra("Film");
        film = film.replaceAll("\\s", "\\+");

        String url ="";
        String typeDemander = intent.getStringExtra("TypeDemander");
        if (typeDemander.contentEquals("Film")){
             url = "https://api.themoviedb.org/3/search/movie?api_key=67e311a7c21dbb5f13026fae8fc5dd0f&query="+film+"&language=fr";
        } else if(typeDemander.contentEquals("Serie")){
            url = "https://api.themoviedb.org/3/search/tv?api_key=67e311a7c21dbb5f13026fae8fc5dd0f&query="+film+"&language=fr";
        } else if (typeDemander.contentEquals("Personne")){
            url = "https://api.themoviedb.org/3/search/person?api_key=67e311a7c21dbb5f13026fae8fc5dd0f&query="+film+"&language=fr";
        } else {
            url = "https://api.themoviedb.org/3/search/multi?api_key=67e311a7c21dbb5f13026fae8fc5dd0f&query="+film+"&language=fr";
        }

        RequestQueue queue = Volley.newRequestQueue(this);


        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                       try {
                            int nbResultatResponse = new Integer(response.get("total_results").toString());
                            int nbResultatAfficher = nbresultdemander;
                            if (nbResultatResponse<nbResultatAfficher){
                                nbResultatAfficher=nbResultatResponse;
                            }
                            for (int i=0; i<nbResultatAfficher; i++){
                                JSONObject jsonObject = response.getJSONArray("results").getJSONObject(i);
                                if (jsonObject.has("media_type")){
                                    if (jsonObject.getString("media_type").contentEquals("movie")){
                                        listResultat.add(new Film(
                                                jsonObject.getString("original_title"),
                                                jsonObject.getString("overview"),
                                                jsonObject.getString("poster_path"),
                                                jsonObject.getString("backdrop_path")
                                        ));
                                    } else if (jsonObject.getString("media_type").contentEquals("tv")){
                                        listResultat.add(new Serie(
                                                jsonObject.getString("original_title"),
                                                jsonObject.getString("overview"),
                                                jsonObject.getString("poster_path"),
                                                jsonObject.getString("backdrop_path")
                                        ));
                                    }
                                } else {
                                    Personne p = new Personne(
                                            jsonObject.getString("name"),
                                            jsonObject.getString("profile_path")
                                    );
                                    JSONArray connuePour = jsonObject.getJSONArray("known_for");
                                    for (int j=0; j<connuePour.length();j++){
                                        JSONObject media = connuePour.getJSONObject(j);
                                        if (media.getString("media_type").contentEquals("movie")){
                                            p.ajoutConnuePour(new Film(
                                                    media.getString("original_title"),
                                                    media.getString("overview"),
                                                    media.getString("poster_path"),
                                                    media.getString("backdrop_path")
                                            ));
                                        } else if (media.getString("media_type").contentEquals("tv")){
                                            p.ajoutConnuePour(new Serie(
                                                    media.getString("original_title"),
                                                    media.getString("overview"),
                                                    media.getString("poster_path"),
                                                    media.getString("backdrop_path")
                                            ));
                                        }
                                    }
                                    listResultat.add(p);
                                }


                            }

                            textView.setText("Nombre de resultat : "+nbResultatResponse);
                       } catch (JSONException e) {
                           textView.setText("Aucun résultat disponnible");
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

        ArrayAdapter<Media> adapterResultFilm = new AdapterResultat(this, listResultat);
        final ListView listView = (ListView) findViewById(R.id.listview_result);
        listView.setAdapter(adapterResultFilm);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Media media = (Media) parent.getAdapter().getItem(position);
                Log.e("te", media.toString());
                if (media.getType().contentEquals("Film")){
                    Film film = (Film) media;
                    Intent versSecondeActivity = new Intent(Resultat.this, DetailFilm.class);
                    versSecondeActivity.putExtra("Film", film);
                    startActivity(versSecondeActivity);
                } else if (media.getType().contentEquals("Serie")){
                    Serie serie = (Serie) media;
                    Intent versSecondeActivity = new Intent(Resultat.this, DetailSerie.class);
                    versSecondeActivity.putExtra("Serie", serie);
                    startActivity(versSecondeActivity);
                } else if (media.getType().contentEquals("Personne")){
                    Personne p = (Personne) media;
                    Intent versSecondeActivity = new Intent(Resultat.this, DetailPersonne.class);

                    versSecondeActivity.putExtra("Personne", p);
                    startActivity(versSecondeActivity);
                }

            }
        });
    }
}
