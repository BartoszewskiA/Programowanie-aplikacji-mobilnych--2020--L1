package com.example.systemmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity2 extends AppCompatActivity {

    ImageView ramka;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ramka = findViewById(R.id.ramka);

        Bundle paczka = getIntent().getExtras();
        int id = paczka.getInt("obrazek");
        ramka.setImageResource(id);


        ramka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}