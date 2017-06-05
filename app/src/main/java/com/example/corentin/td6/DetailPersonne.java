package com.example.corentin.td6;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by Corentin on 03/06/2017.
 */

public class DetailPersonne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_personne);
        
        Personne personne = this.getIntent().getExtras().getParcelable("Personne");
        ImageView poster = (ImageView) findViewById(R.id.imageViewDetailImagePersonne);
        Picasso.with(this.getApplicationContext()).load("https://image.tmdb.org/t/p/w500"+personne.getPoster()).into(poster);

        TextView titre = (TextView) findViewById(R.id.textViewDetailNom);
        titre.setText(personne.getNom());

        ArrayAdapter<Media> adapterResultFilm = new AdapterPersonneFilmSerie(this, personne.getConnuePour());
        GridView listView = (GridView) findViewById(R.id.gridView);
        listView.setAdapter(adapterResultFilm);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Media media = (Media) parent.getAdapter().getItem(position);
                if (media.getType().contentEquals("Film")){
                    Film film = (Film) media;
                    Intent versSecondeActivity = new Intent(DetailPersonne.this, DetailFilm.class);
                    versSecondeActivity.putExtra("Film", film);
                    startActivity(versSecondeActivity);
                } else if (media.getType().contentEquals("Serie")){
                    Serie serie = (Serie) media;
                    Intent versSecondeActivity = new Intent(DetailPersonne.this, DetailSerie.class);
                    versSecondeActivity.putExtra("Serie", serie);
                    startActivity(versSecondeActivity);
                }

            }
        });

    }
}

