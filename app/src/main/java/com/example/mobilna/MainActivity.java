package com.example.mobilna;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ImageView obrazPytania;
    private TextView trescPytania;
    private RadioGroup grupaOdpowiedzi;
    private RadioButton odpowiedzA;
    private RadioButton odpowiedzB;
    private RadioButton odpowiedzC;
    private Button przyciskDalej;

    private ArrayList<PytanieZamkniete> pytania = new ArrayList<>();
    private int numerPytania = 0;
    private int punkty = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        obrazPytania = findViewById(R.id.obrazPytania);
        trescPytania = findViewById(R.id.trescPytania);
        grupaOdpowiedzi = findViewById(R.id.grupaOdpowiedzi);
        odpowiedzA = findViewById(R.id.odpowiedzA);
        odpowiedzB = findViewById(R.id.odpowiedzB);
        odpowiedzC = findViewById(R.id.odpowiedzC);
        przyciskDalej = findViewById(R.id.przyciskDalej);

        dodajPytania();
        pokazPytanie();

        przyciskDalej.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View widok) {
                sprawdzOdpowiedzIPrzejdzDalej();
            }
        });
    }

    private void dodajPytania() {
        pytania.add(new PytanieZamkniete("Które to schronisko?", 1, "Na Rysiance", "Na Wielkiej Raczy", "Na Wielkiej Rycerzowej", 'C'));
        pytania.add(new PytanieZamkniete("Zwierzę na zdjęciu to", 2, "owczarek", "wilk", "kozica", 'A'));
        pytania.add(new PytanieZamkniete("W oddali są widoczne", 3, "Himalaje", "Alpy", "Tatry", 'C'));

    }

    private void pokazPytanie() {
        PytanieZamkniete pytanie = pytania.get(numerPytania);
        obrazPytania.setImageResource(pytanie.getObraz());
        trescPytania.setText(pytanie.getTresc());
        odpowiedzA.setText(pytanie.getOdpowiedzA());
        odpowiedzB.setText(pytanie.getOdpowiedzB());
        odpowiedzC.setText(pytanie.getOdpowiedzC());
        grupaOdpowiedzi.clearCheck();
    }

    private void sprawdzOdpowiedzIPrzejdzDalej() {
        char wybranaOdpowiedz = ' ';
        int wybraneId = grupaOdpowiedzi.getCheckedRadioButtonId();
        if (wybraneId == R.id.odpowiedzA) {
            wybranaOdpowiedz = 'A';
        } else if (wybraneId == R.id.odpowiedzB) {
            wybranaOdpowiedz = 'B';
        } else if (wybraneId == R.id.odpowiedzC) {
            wybranaOdpowiedz = 'C';
        }

        if (pytania.get(numerPytania).sprawdz(wybranaOdpowiedz)) {
            punkty++;
        }

        numerPytania++;
        if (numerPytania >= pytania.size()) {
            numerPytania = 0;
        }
        pokazPytanie();
    }
}