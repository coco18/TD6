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

public class AdapterResultat extends ArrayAdapter<Media> {

    public AdapterResultat(Context context, List<Media> objects) {
        super(context, R.layout.adpater_film_result, objects);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        // instantiation d’un View correspondant a notre fichier de layout
        LayoutInflater inflater = LayoutInflater.from(getContext());
        row=inflater.inflate(R.layout.adpater_film_result, null);
        // personalisation de la vue
        Media media = getItem(position);
        TextView titre = (TextView)row.findViewById(R.id.textViewFilmResult);
        titre.setText(media.getNom());
        ImageView affiche = (ImageView) row.findViewById(R.id.imageViewFilmResult);
        Picasso.with(row.getContext()).load("https://image.tmdb.org/t/p/w300"+media.getPoster()).into(affiche);

        return(row);
    }
}
