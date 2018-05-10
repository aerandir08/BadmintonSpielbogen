package de.tv1875paderborn.malte.badmintonspielbogen;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
    // Alle Ergebnisse als String
    public  static String er_hd11;
    public  static String er_hd12;
    public  static String er_hd13;
    public  static String er_hd21;
    public  static String er_hd22;
    public  static String er_hd23;
    public  static String er_dd1;
    public  static String er_dd2;
    public  static String er_dd3;
    public  static String er_he11;
    public  static String er_he12;
    public  static String er_he13;
    public  static String er_he21;
    public  static String er_he22;
    public  static String er_he23;
    public  static String er_he31;
    public  static String er_he32;
    public  static String er_he33;
    public  static String er_de1;
    public  static String er_de2;
    public  static String er_de3;
    public  static String er_mx1;
    public  static String er_mx2;
    public  static String er_mx3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ergebnis);
        String h_hd1 = h_hd11 + "\n" + h_hd12;
        String g_hd1 = g_hd11 + "\n" + g_hd12;
        String h_hd2 = h_hd21 + "\n" + h_hd22;
        String g_hd2 = g_hd21 + "\n" + g_hd22;
        String h_dd = h_dd1 + "\n" + h_dd2;
        String g_dd = g_dd1 + "\n" + g_dd1;
        String h_mx = h_mx1 + "\n" + h_mx2;
        String g_mx = g_mx1 + "\n" + g_mx2;

        TextView textView = findViewById(R.id.er_h_hd1);
        textView.setText(h_hd1);
        textView = findViewById(R.id.er_g_hd1);
        textView.setText(g_hd1);
        EditText editText = findViewById(R.id.er_hd11);
        editText.setText(er_hd11);
        editText = findViewById(R.id.er_hd12);
        editText.setText(er_hd12);
        editText = findViewById(R.id.er_hd13);
        editText.setText(er_hd13);

        textView = findViewById(R.id.er_h_hd2);
        textView.setText(h_hd2);
        textView = findViewById(R.id.er_g_hd2);
        textView.setText(g_hd2);
        editText = findViewById(R.id.er_hd21);
        editText.setText(er_hd21);
        editText = findViewById(R.id.er_hd22);
        editText.setText(er_hd22);
        editText = findViewById(R.id.er_hd23);
        editText.setText(er_hd23);

        textView = findViewById(R.id.er_h_dd);
        textView.setText(h_dd);
        textView = findViewById(R.id.er_g_dd);
        textView.setText(g_dd);
        editText = findViewById(R.id.er_dd1);
        editText.setText(er_dd1);
        editText = findViewById(R.id.er_dd2);
        editText.setText(er_dd2);
        editText = findViewById(R.id.er_dd3);
        editText.setText(er_dd3);

        textView = findViewById(R.id.er_h_he1);
        textView.setText(h_he1);
        textView = findViewById(R.id.er_g_he1);
        textView.setText(g_he1);
        editText = findViewById(R.id.er_he11);
        editText.setText(er_he11);
        editText = findViewById(R.id.er_he12);
        editText.setText(er_he12);
        editText = findViewById(R.id.er_he13);
        editText.setText(er_he13);

        textView = findViewById(R.id.er_h_he2);
        textView.setText(h_he2);
        textView = findViewById(R.id.er_g_he2);
        textView.setText(g_he2);
        editText = findViewById(R.id.er_he21);
        editText.setText(er_he21);
        editText = findViewById(R.id.er_he22);
        editText.setText(er_he22);
        editText = findViewById(R.id.er_he23);
        editText.setText(er_he23);

        textView = findViewById(R.id.er_h_he3);
        textView.setText(h_he3);
        textView = findViewById(R.id.er_g_he3);
        textView.setText(g_he3);
        editText = findViewById(R.id.er_he31);
        editText.setText(er_he31);
        editText = findViewById(R.id.er_he32);
        editText.setText(er_he32);
        editText = findViewById(R.id.er_he33);
        editText.setText(er_he33);

        textView = findViewById(R.id.er_h_de);
        textView.setText(h_de);
        textView = findViewById(R.id.er_g_de);
        textView.setText(g_de);
        editText = findViewById(R.id.er_de1);
        editText.setText(er_de1);
        editText = findViewById(R.id.er_de2);
        editText.setText(er_de2);
        editText = findViewById(R.id.er_de3);
        editText.setText(er_de3);

        textView = findViewById(R.id.er_h_mx);
        textView.setText(h_mx);
        textView = findViewById(R.id.er_g_mx);
        textView.setText(g_mx);
        editText = findViewById(R.id.er_mx1);
        editText.setText(er_mx1);
        editText = findViewById(R.id.er_mx2);
        editText.setText(er_mx2);
        editText = findViewById(R.id.er_mx3);
        editText.setText(er_mx3);
    }

    public void button_save(View view) {
        EditText editText = findViewById(R.id.er_hd11);
        er_hd11 = editText.getText().toString();

        editText = findViewById(R.id.er_hd12);
        er_hd12 = editText.getText().toString();

        editText = findViewById(R.id.er_hd13);
        er_hd13 = editText.getText().toString();

        editText = findViewById(R.id.er_hd21);
        er_hd21 = editText.getText().toString();

        editText = findViewById(R.id.er_hd22);
        er_hd22 = editText.getText().toString();

        editText = findViewById(R.id.er_hd23);
        er_hd23 = editText.getText().toString();

        editText = findViewById(R.id.er_dd1);
        er_dd1 = editText.getText().toString();

        editText = findViewById(R.id.er_dd2);
        er_dd2 = editText.getText().toString();

        editText = findViewById(R.id.er_dd3);
        er_dd3 = editText.getText().toString();

        editText = findViewById(R.id.er_he11);
        er_he11 = editText.getText().toString();

        editText = findViewById(R.id.er_he12);
        er_he12 = editText.getText().toString();

        editText = findViewById(R.id.er_he13);
        er_he13 = editText.getText().toString();

        editText = findViewById(R.id.er_he21);
        er_he21 = editText.getText().toString();

        editText = findViewById(R.id.er_he22);
        er_he22 = editText.getText().toString();

        editText = findViewById(R.id.er_he23);
        er_he23 = editText.getText().toString();

        editText = findViewById(R.id.er_he31);
        er_he31 = editText.getText().toString();

        editText = findViewById(R.id.er_he32);
        er_he32 = editText.getText().toString();

        editText = findViewById(R.id.er_he33);
        er_he33 = editText.getText().toString();

        editText = findViewById(R.id.er_de1);
        er_de1 = editText.getText().toString();

        editText = findViewById(R.id.er_de2);
        er_de2 = editText.getText().toString();

        editText = findViewById(R.id.er_de3);
        er_de3 = editText.getText().toString();

        editText = findViewById(R.id.er_mx1);
        er_mx1 = editText.getText().toString();

        editText = findViewById(R.id.er_mx2);
        er_mx2 = editText.getText().toString();

        editText = findViewById(R.id.er_mx3);
        er_mx3 = editText.getText().toString();

        Context context = getApplicationContext();
        Toast.makeText(context, "Daten gespeichert", Toast.LENGTH_SHORT).show();
    }
}
