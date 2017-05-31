package com.example.corentin.td6;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Corentin on 31/05/2017.
 */

public class Resultat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = this.getIntent();
        intent.getStringExtra("Film");

        https://api.themoviedb.org/3/search/movie?api_key=67e311a7c21dbb5f13026fae8fc5dd0f&query=Jack+Reacher
    }
}
