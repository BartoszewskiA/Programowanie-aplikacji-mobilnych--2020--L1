package com.example.cyklzycia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView opis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        opis = findViewById(R.id.opis);
        opis.setText(opis.getText().toString()+"\n"+"onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        opis.setText(opis.getText().toString()+"\n"+"onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        opis.setText(opis.getText().toString()+"\n"+"onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        opis.setText(opis.getText().toString()+"\n"+"onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        opis.setText(opis.getText().toString()+"\n"+"onStop");
    }


}