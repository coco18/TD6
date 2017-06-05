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
 * Created by Corentin on 01/06/2017.
 */

public class DetailFilm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_film_serie);

        final Film film =  this.getIntent().getExtras().getParcelable("Film");
        ImageView poster = (ImageView) findViewById(R.id.imageViewDetailPoster);
        Picasso.with(this.getApplicationContext()).load("https://image.tmdb.org/t/p/w500"+film.getPoster()).into(poster);

        TextView titre = (TextView) findViewById(R.id.textViewDetailTitre);
        titre.setText(film.getNom());

        TextView description = (TextView) findViewById(R.id.textViewDetailDescription);
        description.setText(film.getDescription());

        ImageView toileDeFond = (ImageView) findViewById(R.id.imageViewDetailFond);
        Picasso.with(this.getApplicationContext()).load("https://image.tmdb.org/t/p/w1000"+film.getToileDeFond()).into(toileDeFond);

        Button button = (Button)findViewById(R.id.buttonplusdinfo);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent versSecondeActivity = new Intent(DetailFilm.this, PlusInfoFilmSerie.class);
                versSecondeActivity.putExtra("TypeDemander", film.getType());

                versSecondeActivity.putExtra("id", film.getId());
                startActivity(versSecondeActivity);

            }
        });
    }
}
