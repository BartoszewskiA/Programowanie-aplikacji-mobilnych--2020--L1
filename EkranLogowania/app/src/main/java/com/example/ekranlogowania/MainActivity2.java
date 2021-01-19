package com.example.ekranlogowania;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView kto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        kto = findViewById(R.id.zalogowany);
        Bundle paczka = getIntent().getExtras();
        kto.setText(paczka.getString("kto"));
    }
}