package com.example.corentin.td6;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by Corentin on 03/06/2017.
 */

public class DetailSerie extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_film_serie);

        final Serie serie = this.getIntent().getExtras().getParcelable("Serie");
        ImageView poster = (ImageView) findViewById(R.id.imageViewDetailPoster);
        Picasso.with(this.getApplicationContext()).load("https://image.tmdb.org/t/p/w500"+serie.getPoster()).into(poster);

        TextView titre = (TextView) findViewById(R.id.textViewDetailTitre);
        titre.setText(serie.getNom());

        TextView description = (TextView) findViewById(R.id.textViewDetailDescription);
        description.setText(serie.getDescription());

        ImageView toileDeFond = (ImageView) findViewById(R.id.imageViewDetailFond);
        Picasso.with(this.getApplicationContext()).load("https://image.tmdb.org/t/p/w1000"+serie.getToileDeFond()).into(toileDeFond);

        Button button = (Button)findViewById(R.id.buttonplusdinfo);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent versSecondeActivity = new Intent(DetailSerie.this, PlusInfoFilmSerie.class);
                versSecondeActivity.putExtra("TypeDemander", serie.getType());

                versSecondeActivity.putExtra("id", serie.getId());
                startActivity(versSecondeActivity);

            }
        });

    }
}

