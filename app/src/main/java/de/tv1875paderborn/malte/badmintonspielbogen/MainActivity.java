package de.tv1875paderborn.malte.badmintonspielbogen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {
    // Allgemeine Daten speichern
    public static String heimverein = "heimverein";
    public static String gastverein = "gastverein";
    public static String staffel = "staffel";
    public static String ort = "ort";
    public static String zeit = "zeit";

    // Namen des Heimvereins speichern
    public static String h_hd11;
    public static String h_hd12;
    public static String h_hd21;
    public static String h_hd22;
    public static String h_dd1;
    public static String h_dd2;
    public static String h_he1;
    public static String h_he2;
    public static String h_he3;
    public static String h_de;
    public static String h_mx1;
    public static String h_mx2;

    // Namen des Gastvereins speichern
    public static String g_hd11;
    public static String g_hd12;
    public static String g_hd21;
    public static String g_hd22;
    public static String g_dd1;
    public static String g_dd2;
    public static String g_he1;
    public static String g_he2;
    public static String g_he3;
    public static String g_de;
    public static String g_mx1;
    public static String g_mx2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void button_save(View view) {
        EditText editText = findViewById(R.id.editText_heimverein);
        heimverein = editText.getText().toString();
        editText = findViewById(R.id.editText_gastverein);
        gastverein = editText.getText().toString();
        editText = findViewById(R.id.editText_staffel);
        staffel = editText.getText().toString();
        editText = findViewById(R.id.editText_ort);
        ort = editText.getText().toString();
        editText = findViewById(R.id.editText_zeit);
        zeit = editText.getText().toString();
    }

    public void button_heimverein(View view) {
        Intent intent = new Intent(this, menu_2.class);
        startActivity(intent);
    }

    public void button_gastverein(View view) {
        Intent intent = new Intent(this, menu_3.class);
        startActivity(intent);
    }

    public void button_ergebnis(View view) {
        Intent intent = new Intent(this, ergebnis.class);
        startActivity(intent);
    }
}
