package com.example.kalkulator2020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button  p1, p2, p3, p4, p5, p6, p7, p8, p9, p0,
            kasuj, wstecz, rowne, przecinek, zmianaZnaku,
            procent, pierwiastek, kwadrat, odwrotnosc,
            razy, podzielic, minus, plus;
    TextView wyswietlacz;

    double x1=0, x2=0;
    int kodDzialania =0;

    boolean trybPisania = true,
            pierwszeDzilanie = true;

    View.OnClickListener sluchaczZdarzen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        znajdzKontrolki();
        stworzSluchaczaZdarzen();
        dodajSluchaczaZdarzen();
    }



    private void znajdzKontrolki() {

        p1 = findViewById(R.id.p1);
        p2 = findViewById(R.id.p2);
        p3 = findViewById(R.id.p3);
        p4 = findViewById(R.id.p4);
        p5 = findViewById(R.id.p5);
        p6 = findViewById(R.id.p6);
        p7 = findViewById(R.id.p7);
        p8 = findViewById(R.id.p8);
        p9 = findViewById(R.id.p9);
        p0 = findViewById(R.id.p0);

        kasuj = findViewById(R.id.kasuj);
        wstecz = findViewById(R.id.wstecz);
        rowne = findViewById(R.id.rowne);
        przecinek = findViewById(R.id.przecinek);
        zmianaZnaku = findViewById(R.id.zmianaZnaku);

        procent = findViewById(R.id.procent);
        pierwiastek = findViewById(R.id.pierwiastek);
        kwadrat = findViewById(R.id.kwadrat);
        odwrotnosc= findViewById(R.id.odwrotnosc);

        razy = findViewById(R.id.razy);
        podzielic = findViewById(R.id.podzielic);
        minus = findViewById(R.id.minus);
        plus = findViewById(R.id.plus);

        wyswietlacz = findViewById(R.id.wyswietlacz);
    }

    private void stworzSluchaczaZdarzen()
    {
        sluchaczZdarzen =  new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int ID = view.getId();
                switch (ID)
                {
                    case R.id.p1 : dodajCyfre("1"); break;
                    case R.id.p2 : dodajCyfre("2"); break;
                    case R.id.p3 : dodajCyfre("3"); break;
                    case R.id.p4 : dodajCyfre("4"); break;
                    case R.id.p5 : dodajCyfre("5"); break;
                    case R.id.p6 : dodajCyfre("6"); break;
                    case R.id.p7 : dodajCyfre("7"); break;
                    case R.id.p8 : dodajCyfre("8"); break;
                    case R.id.p9 : dodajCyfre("9"); break;
                    case R.id.p0 : dodajCyfre("0"); break;
                    case R.id.wstecz: cofnij(); break;

                    case R.id.plus : dzialanie(1); break;
                    case R.id.minus : dzialanie(2); break;
                    case R.id.razy : dzialanie(3); break;
                    case R.id.podzielic : dzialanie(4); break;
                    case R.id.rowne : dzialanie(0); break;
                }
            }
        };
    }


    private void dodajSluchaczaZdarzen()
    {
        p1.setOnClickListener(sluchaczZdarzen);
        p2.setOnClickListener(sluchaczZdarzen);
        p3.setOnClickListener(sluchaczZdarzen);
        p4.setOnClickListener(sluchaczZdarzen);
        p5.setOnClickListener(sluchaczZdarzen);
        p6.setOnClickListener(sluchaczZdarzen);
        p7.setOnClickListener(sluchaczZdarzen);
        p8.setOnClickListener(sluchaczZdarzen);
        p9.setOnClickListener(sluchaczZdarzen);
        p0.setOnClickListener(sluchaczZdarzen);
        kasuj.setOnClickListener(sluchaczZdarzen);
        plus.setOnClickListener(sluchaczZdarzen);
        minus.setOnClickListener(sluchaczZdarzen);
        razy.setOnClickListener(sluchaczZdarzen);
        podzielic.setOnClickListener(sluchaczZdarzen);
        rowne.setOnClickListener(sluchaczZdarzen);
        wstecz.setOnClickListener(sluchaczZdarzen);
        zmianaZnaku.setOnClickListener(sluchaczZdarzen);
        przecinek.setOnClickListener(sluchaczZdarzen);
        procent.setOnClickListener(sluchaczZdarzen);
        kwadrat.setOnClickListener(sluchaczZdarzen);
        pierwiastek.setOnClickListener(sluchaczZdarzen);
       //odwrotnosc.setOnClickListener(sluchaczZdarzen);
    }

    private void dodajCyfre(String cyfra) {
        if (trybPisania)
        {
            String temp = wyswietlacz.getText().toString();
            if(temp.equals("0")) temp="";
            wyswietlacz.setText(temp + cyfra);
        }
        else
        {
            wyswietlacz.setText(cyfra);
            trybPisania=true;
        }
    }

    private void cofnij() {
        String s = wyswietlacz.getText().toString();
        if (s.length()>1) {
            s = s.substring(0,s.length()-1);
        }
        else s="0";
        wyswietlacz.setText(s);
    }

    private void dzialanie(int kodPrzycisku) {
        double wynik=0;
        if (pierwszeDzilanie)
        {
            x1= Double.parseDouble(wyswietlacz.getText().toString());
            pierwszeDzilanie=false;
        }
        else
        {
            x2 = Double.parseDouble(wyswietlacz.getText().toString());
            switch (kodDzialania)
            {
                case 1: wynik = x1+x2; break;
                case 2: wynik = x1-x2; break;
                case 3: wynik = x1*x2; break;
                case 4: wynik = x1/x2; break;
            }
            x1=wynik;
            //wyswietl(wynik);
            wyswietlacz.setText(String.valueOf(wynik));
        }
        kodDzialania= kodPrzycisku;
        if (kodPrzycisku==0) {
            pierwszeDzilanie=true;
        }
        trybPisania=false;
    }
}