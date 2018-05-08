package de.tv1875paderborn.malte.badmintonspielbogen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.g_dd1;
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.g_de;
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.g_hd11;
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.g_hd12;
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.g_hd21;
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.g_hd22;
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.g_he1;
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.g_he2;
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.g_he3;
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.g_mx1;
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.g_mx2;
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.h_dd1;
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.h_dd2;
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.h_de;
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.h_hd11;
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.h_hd12;
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.h_hd21;
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.h_hd22;
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.h_he1;
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.h_he2;
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.h_he3;
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.h_mx1;
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.h_mx2;

public class ergebnis extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ergebnis);

        TextView textView = findViewById(R.id.er_h_hd1);
        textView.setText(h_hd11 + "\n" + h_hd12);
        textView = findViewById(R.id.er_g_hd1);
        textView.setText(g_hd11 + "\n" + g_hd12);

        textView = findViewById(R.id.er_h_hd2);
        textView.setText(h_hd21 + "\n" + h_hd22);
        textView = findViewById(R.id.er_g_hd1);
        textView.setText(g_hd21 + "\n" + g_hd22);

        textView = findViewById(R.id.er_h_dd);
        textView.setText(h_dd1 + "\n" + h_dd2);
        textView = findViewById(R.id.er_g_hd1);
        textView.setText(g_dd1 + "\n" + g_dd1);

        textView = findViewById(R.id.er_h_he1);
        textView.setText(h_he1);
        textView = findViewById(R.id.er_g_he1);
        textView.setText(g_he1);

        textView = findViewById(R.id.er_h_he2);
        textView.setText(h_he2);
        textView = findViewById(R.id.er_g_he2);
        textView.setText(g_he2);

        textView = findViewById(R.id.er_h_he3);
        textView.setText(h_he3);
        textView = findViewById(R.id.er_g_he3);
        textView.setText(g_he3);

        textView = findViewById(R.id.er_h_de);
        textView.setText(h_de);
        textView = findViewById(R.id.er_g_de);
        textView.setText(g_de);

        textView = findViewById(R.id.er_h_mx);
        textView.setText(h_mx1 + "\n" + h_mx2);
        textView = findViewById(R.id.er_g_mx);
        textView.setText(g_mx1 + "\n" + g_mx2);

    }
}
