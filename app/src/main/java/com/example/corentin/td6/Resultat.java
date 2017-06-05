package com.example.corentin.td6;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
        final int page = intent.getIntExtra("page",1);
        final String filmdemande = intent.getStringExtra("Film");
        String film = filmdemande.replaceAll("\\s", "\\+");

        String url ="";
        final String typeDemander = intent.getStringExtra("TypeDemander");
        if (typeDemander.contentEquals("Film")){
            url = "https://api.themoviedb.org/3/search/movie?api_key=67e311a7c21dbb5f13026fae8fc5dd0f&query="+film+"&language=fr&page="+page;
        } else if(typeDemander.contentEquals("Serie")){
            url = "https://api.themoviedb.org/3/search/tv?api_key=67e311a7c21dbb5f13026fae8fc5dd0f&query="+film+"&language=fr&page="+page;
        } else if (typeDemander.contentEquals("Personne")){
            url = "https://api.themoviedb.org/3/search/person?api_key=67e311a7c21dbb5f13026fae8fc5dd0f&query="+film+"&language=fr&page="+page;
        } else {
            url = "https://api.themoviedb.org/3/search/multi?api_key=67e311a7c21dbb5f13026fae8fc5dd0f&query="+film+"&language=fr&page="+page;
        }


        RequestQueue queue = Volley.newRequestQueue(this);


        final JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                       try {
                            int nbResultatResponse = new Integer(response.get("total_results").toString());
                            int nbResultatAfficher = nbresultdemander;
                           JSONArray jsonArray = response.getJSONArray("results");
                           //Si le nombre de résultat de la réponse < que résultat souhaité.
                            if (jsonArray.length()<nbResultatAfficher){
                                nbResultatAfficher=jsonArray.length();
                            }
                           //Si le nombre résultat disponnible sur le site < nbresultat afficher
                           if (jsonArray.length()*page>=nbResultatResponse){
                               Button pageSuivante = (Button) findViewById(R.id.buttonPageSuivante);
                               pageSuivante.setClickable(false);
                               pageSuivante.setAlpha(.5f);
                           }
                           for (int i=0; i<nbResultatAfficher; i++){
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                if (jsonObject.has("media_type") || typeDemander.contentEquals("Film") || typeDemander.contentEquals("Serie")){
                                    if (typeDemander.contentEquals("Film")){
                                        listResultat.add(new Film(
                                                jsonObject.getInt("id"),
                                                jsonObject.getString("original_title"),
                                                jsonObject.getString("overview"),
                                                jsonObject.getString("poster_path"),
                                                jsonObject.getString("backdrop_path")
                                        ));
                                    } else if (typeDemander.contentEquals("Serie")){
                                        listResultat.add(new Serie(
                                                jsonObject.getInt("id"),
                                                jsonObject.getString("name"),
                                                jsonObject.getString("overview"),
                                                jsonObject.getString("poster_path"),
                                                jsonObject.getString("backdrop_path")
                                        ));
                                    } else if (jsonObject.getString("media_type").contentEquals("movie")){
                                        listResultat.add(new Film(
                                                jsonObject.getInt("id"),
                                                jsonObject.getString("original_title"),
                                                jsonObject.getString("overview"),
                                                jsonObject.getString("poster_path"),
                                                jsonObject.getString("backdrop_path")
                                        ));
                                    } else if (jsonObject.getString("media_type").contentEquals("tv")){
                                        listResultat.add(new Serie(
                                                jsonObject.getInt("id"),
                                                jsonObject.getString("name"),
                                                jsonObject.getString("overview"),
                                                jsonObject.getString("poster_path"),
                                                jsonObject.getString("backdrop_path")
                                        ));
                                    } else if (jsonObject.getString("media_type").contentEquals("person")){
                                        Personne p = new Personne(
                                                jsonObject.getInt("id"),
                                                jsonObject.getString("name"),
                                                jsonObject.getString("profile_path")
                                        );
                                        Log.e("test", p.toString());
                                        JSONArray connuePour = jsonObject.getJSONArray("known_for");
                                        for (int j=0; j<connuePour.length();j++){
                                            JSONObject media = connuePour.getJSONObject(j);
                                            if (media.getString("media_type").contentEquals("movie")){
                                                p.ajoutConnuePour(new Film(
                                                        media.getInt("id"),
                                                        media.getString("original_title"),
                                                        media.getString("overview"),
                                                        media.getString("poster_path"),
                                                        media.getString("backdrop_path")
                                                ));
                                            } else if (media.getString("media_type").contentEquals("tv")){
                                                p.ajoutConnuePour(new Serie(
                                                        media.getInt("id"),
                                                        media.getString("name"),
                                                        media.getString("overview"),
                                                        media.getString("poster_path"),
                                                        media.getString("backdrop_path")
                                                ));
                                            }
                                        }
                                        listResultat.add(p);
                                    }
                                } else {
                                    Personne p = new Personne(
                                            jsonObject.getInt("id"),
                                            jsonObject.getString("name"),
                                            jsonObject.getString("profile_path")
                                    );
                                    Log.e("test", p.toString());
                                    JSONArray connuePour = jsonObject.getJSONArray("known_for");
                                    for (int j=0; j<connuePour.length();j++){
                                        JSONObject media = connuePour.getJSONObject(j);
                                        if (media.getString("media_type").contentEquals("movie")){
                                            p.ajoutConnuePour(new Film(
                                                    media.getInt("id"),
                                                    media.getString("original_title"),
                                                    media.getString("overview"),
                                                    media.getString("poster_path"),
                                                    media.getString("backdrop_path")
                                            ));
                                        } else if (media.getString("media_type").contentEquals("tv")){
                                            p.ajoutConnuePour(new Serie(
                                                    media.getInt("id"),
                                                    media.getString("name"),
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
                           if (listResultat.size()==0){
                               Button pageSuivante = (Button) findViewById(R.id.buttonPageSuivante);
                               pageSuivante.setClickable(false);
                               pageSuivante.setAlpha(.5f);
                               textView.setText("Aucun résultat disponnible");
                           }
                       } catch (JSONException e) {

                       }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub
                        textView.setText("Aucun résultat disponnible");
                    }
                });

        // Access the RequestQueue through your singleton class.
        queue.add(jsObjRequest);
        Log.e("aa", jsObjRequest.toString());

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
                    Log.e("film", film.toString());
                    Intent versSecondeActivity = new Intent(Resultat.this, DetailFilm.class);
                    versSecondeActivity.putExtra("Film", film);
                    startActivity(versSecondeActivity);
                } else if (media.getType().contentEquals("Serie")){
                    Serie serie = (Serie) media;
                    Log.e("test", serie.toString());
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

        Button pagesuivante = (Button) findViewById(R.id.buttonPageSuivante);
        pagesuivante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent versSecondeActivity = new Intent(Resultat.this, Resultat.class);
                versSecondeActivity.putExtra("Nbresult", nbresultdemander+30);


                versSecondeActivity.putExtra("TypeDemander", typeDemander);

                versSecondeActivity.putExtra("page", page+1);

                versSecondeActivity.putExtra("Film", filmdemande);
                startActivity(versSecondeActivity);
            }
        });
    }
}
