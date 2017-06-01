package com.example.corentin.td6;

import com.squareup.picasso.Picasso;
import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Corentin on 01/06/2017.
 */

public class AdapterResultFilm extends ArrayAdapter<Film> {

    public AdapterResultFilm(Context context, List<Film> objects) {
        super(context, R.layout.adpater_film_result, objects);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        // instantiation d’un View correspondant a notre fichier de layout
        LayoutInflater inflater = LayoutInflater.from(getContext());
        row=inflater.inflate(R.layout.adpater_film_result, null);
        // personalisation de la vue
        Film film = getItem(position);
        TextView titre = (TextView)row.findViewById(R.id.textViewFilmResult);
        titre.setText(film.getTitre());
        ImageView affiche = (ImageView) row.findViewById(R.id.imageViewFilmResult);
        Picasso.with(row.getContext()).load("https://image.tmdb.org/t/p/w300"+film.getPoster()).into(affiche);

        return(row);
    }
}
