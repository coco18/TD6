package com.example.corentin.td6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class Accueil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        List<Integer> list = new ArrayList<Integer>();
        for (int i=0 ; i<30;i++){
            list.add(i);
        }

        final Spinner nbresult = (Spinner) findViewById(R.id.nbresultat);
        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_dropdown_item, list);
        nbresult.setAdapter(arrayAdapter);

        final EditText film = (EditText) findViewById(R.id.editTextTitreFilm);

        Button recherche = (Button) findViewById(R.id.buttonRecherche);
        recherche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent versSecondeActivity = new Intent(Accueil.this, Resultat.class);
                versSecondeActivity.putExtra("Nbresult", nbresult.getSelectedItem().toString());

                versSecondeActivity.putExtra("Film", film.getText().toString());
                startActivity(versSecondeActivity);
            }
        });
    }
}
