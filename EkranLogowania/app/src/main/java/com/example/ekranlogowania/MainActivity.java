package com.example.ekranlogowania;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText polePassword, poleUsername;
    Button przyciskLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        polePassword = findViewById(R.id.password);
        poleUsername = findViewById(R.id.username);
        przyciskLogin = findViewById(R.id.login);
        przyciskLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sprawdzHaslo();
            }
        });
    }

    private void sprawdzHaslo() {

        // dopiero po sprawdzeniu
        otworz();
    }

    private void otworz() {
        Intent intencja = new Intent(this, MainActivity2.class);
        intencja.putExtra("kto", poleUsername.getText().toString());
        startActivity(intencja);

    }
}