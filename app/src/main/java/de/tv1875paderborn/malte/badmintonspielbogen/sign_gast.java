package de.tv1875paderborn.malte.badmintonspielbogen;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.sign;

public class sign_gast extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sign = false;
        setContentView(new SignatureMainLayout(this));
    }
}