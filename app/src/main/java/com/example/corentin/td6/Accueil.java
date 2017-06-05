package com.example.corentin.td6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Accueil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        List<Integer> list = new ArrayList<Integer>();
        for (int i=5 ; i<=20;i+=5){
            list.add(i);
        }

        final Spinner nbresult = (Spinner) findViewById(R.id.nbresultat);
        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_dropdown_item, list);
        nbresult.setAdapter(arrayAdapter);
        nbresult.setSelection(1);

        final EditText editTextRecherche = (EditText) findViewById(R.id.editTextTitreFilm);
        final RadioButton film = (RadioButton) findViewById(R.id.radioButtonFilm);
        final RadioButton serie = (RadioButton) findViewById(R.id.radioButtonSerie);
        final RadioButton personne = (RadioButton) findViewById(R.id.radioButtonPersonne);

        Button recherche = (Button) findViewById(R.id.buttonRecherche);
        recherche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent versSecondeActivity = new Intent(Accueil.this, Resultat.class);
                versSecondeActivity.putExtra("Nbresult", Integer.parseInt(nbresult.getSelectedItem().toString()));

                //Choix type resultat
                if (film.isChecked()){
                    versSecondeActivity.putExtra("TypeDemander", "Film");
                } else if(serie.isChecked()){
                    versSecondeActivity.putExtra("TypeDemander", "Serie");
                } else if (personne.isChecked()){
                    versSecondeActivity.putExtra("TypeDemander", "Personne");
                } else {
                    versSecondeActivity.putExtra("TypeDemander", "Tous");
                }

                versSecondeActivity.putExtra("Film", editTextRecherche.getText().toString());
                versSecondeActivity.putExtra("page", 1);
                startActivity(versSecondeActivity);
            }
        });

        editTextRecherche.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                Intent versSecondeActivity = new Intent(Accueil.this, Resultat.class);
                versSecondeActivity.putExtra("Nbresult", Integer.parseInt(nbresult.getSelectedItem().toString()));

                //Choix type resultat
                if (film.isChecked()){
                    versSecondeActivity.putExtra("TypeDemander", "Film");
                } else if(serie.isChecked()){
                    versSecondeActivity.putExtra("TypeDemander", "Serie");
                } else if (personne.isChecked()){
                    versSecondeActivity.putExtra("TypeDemander", "Personne");
                } else {
                    versSecondeActivity.putExtra("TypeDemander", "Tous");
                }

                versSecondeActivity.putExtra("Film", editTextRecherche.getText().toString());
                versSecondeActivity.putExtra("page", 1);
                startActivity(versSecondeActivity);
                return true;
            }
        });
    }

}
