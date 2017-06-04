package com.example.corentin.td6;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
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

        ArrayAdapter<Media> adapterResultFilm = new AdapterResultat(this, personne.getConnuePour());
        ListView listView = (ListView) findViewById(R.id.listview_detail_personne_list_film);
        listView.setAdapter(adapterResultFilm);



    }
}

