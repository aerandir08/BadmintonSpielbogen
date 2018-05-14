package de.tv1875paderborn.malte.badmintonspielbogen;

import android.content.Context;
import android.content.Intent;
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
    public  static String er_hd1_h1;
    public  static String er_hd1_h2;
    public  static String er_hd1_h3;
    public  static String er_hd1_g1;
    public  static String er_hd1_g2;
    public  static String er_hd1_g3;
    public  static String er_hd2_h1;
    public  static String er_hd2_h2;
    public  static String er_hd2_h3;
    public  static String er_hd2_g1;
    public  static String er_hd2_g2;
    public  static String er_hd2_g3;
    public  static String er_dd_h1;
    public  static String er_dd_h2;
    public  static String er_dd_h3;
    public  static String er_dd_g1;
    public  static String er_dd_g2;
    public  static String er_dd_g3;
    public  static String er_he1_h1;
    public  static String er_he1_h2;
    public  static String er_he1_h3;
    public  static String er_he1_g1;
    public  static String er_he1_g2;
    public  static String er_he1_g3;
    public  static String er_he2_h1;
    public  static String er_he2_h2;
    public  static String er_he2_h3;
    public  static String er_he2_g1;
    public  static String er_he2_g2;
    public  static String er_he2_g3;
    public  static String er_he3_h1;
    public  static String er_he3_h2;
    public  static String er_he3_h3;
    public  static String er_he3_g1;
    public  static String er_he3_g2;
    public  static String er_he3_g3;
    public  static String er_de_h1;
    public  static String er_de_h2;
    public  static String er_de_h3;
    public  static String er_de_g1;
    public  static String er_de_g2;
    public  static String er_de_g3;
    public  static String er_mx_h1;
    public  static String er_mx_h2;
    public  static String er_mx_h3;
    public  static String er_mx_g1;
    public  static String er_mx_g2;
    public  static String er_mx_g3;
    


    public static boolean sign;

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
        EditText editText = findViewById(R.id.er_hd1_h1);
        editText.setText(er_hd1_h1);
        editText = findViewById(R.id.er_hd1_h2);
        editText.setText(er_hd1_h2);
        editText = findViewById(R.id.er_hd1_h3);
        editText.setText(er_hd1_h3);
        editText = findViewById(R.id.er_hd1_g1);
        editText.setText(er_hd1_g1);
        editText = findViewById(R.id.er_hd1_g2);
        editText.setText(er_hd1_g2);
        editText = findViewById(R.id.er_hd1_g3);
        editText.setText(er_hd1_g3);

        textView = findViewById(R.id.er_h_hd2);
        textView.setText(h_hd2);
        textView = findViewById(R.id.er_g_hd2);
        textView.setText(g_hd2);
        editText = findViewById(R.id.er_hd2_h1);
        editText.setText(er_hd2_h1);
        editText = findViewById(R.id.er_hd2_h2);
        editText.setText(er_hd2_h2);
        editText = findViewById(R.id.er_hd2_h3);
        editText.setText(er_hd2_h3);
        editText = findViewById(R.id.er_hd2_g1);
        editText.setText(er_hd2_g1);
        editText = findViewById(R.id.er_hd2_g2);
        editText.setText(er_hd2_g2);
        editText = findViewById(R.id.er_hd2_g3);
        editText.setText(er_hd2_g3);

        textView = findViewById(R.id.er_h_dd);
        textView.setText(h_dd);
        textView = findViewById(R.id.er_g_dd);
        textView.setText(g_dd);
        editText = findViewById(R.id.er_dd_h1);
        editText.setText(er_dd_h1);
        editText = findViewById(R.id.er_dd_h2);
        editText.setText(er_dd_h2);
        editText = findViewById(R.id.er_dd_h3);
        editText.setText(er_dd_h3);
        editText = findViewById(R.id.er_dd_g1);
        editText.setText(er_dd_g1);
        editText = findViewById(R.id.er_dd_g2);
        editText.setText(er_dd_g2);
        editText = findViewById(R.id.er_dd_g3);
        editText.setText(er_dd_g3);

        textView = findViewById(R.id.er_h_he1);
        textView.setText(h_he1);
        textView = findViewById(R.id.er_g_he1);
        textView.setText(g_he1);
        editText = findViewById(R.id.er_he1_h1);
        editText.setText(er_he1_h1);
        editText = findViewById(R.id.er_he1_h2);
        editText.setText(er_he1_h2);
        editText = findViewById(R.id.er_he1_h3);
        editText.setText(er_he1_h3);
        editText = findViewById(R.id.er_he1_g1);
        editText.setText(er_he1_g1);
        editText = findViewById(R.id.er_he1_g2);
        editText.setText(er_he1_g2);
        editText = findViewById(R.id.er_he1_g3);
        editText.setText(er_he1_g3);

        textView = findViewById(R.id.er_h_he2);
        textView.setText(h_he2);
        textView = findViewById(R.id.er_g_he2);
        textView.setText(g_he2);
        editText = findViewById(R.id.er_he2_h1);
        editText.setText(er_he2_h1);
        editText = findViewById(R.id.er_he2_h2);
        editText.setText(er_he2_h2);
        editText = findViewById(R.id.er_he2_h3);
        editText.setText(er_he2_h3);
        editText = findViewById(R.id.er_he2_g1);
        editText.setText(er_he2_g1);
        editText = findViewById(R.id.er_he2_g2);
        editText.setText(er_he2_g2);
        editText = findViewById(R.id.er_he2_g3);
        editText.setText(er_he2_g3);

        textView = findViewById(R.id.er_h_he3);
        textView.setText(h_he3);
        textView = findViewById(R.id.er_g_he3);
        textView.setText(g_he3);
        editText = findViewById(R.id.er_he3_h1);
        editText.setText(er_he3_h1);
        editText = findViewById(R.id.er_he3_h2);
        editText.setText(er_he3_h2);
        editText = findViewById(R.id.er_he3_h3);
        editText.setText(er_he3_h3);
        editText = findViewById(R.id.er_he3_g1);
        editText.setText(er_he3_g1);
        editText = findViewById(R.id.er_he3_g2);
        editText.setText(er_he3_g2);
        editText = findViewById(R.id.er_he3_g3);
        editText.setText(er_he3_g3);

        textView = findViewById(R.id.er_h_de);
        textView.setText(h_de);
        textView = findViewById(R.id.er_g_de);
        textView.setText(g_de);
        editText = findViewById(R.id.er_de_h1);
        editText.setText(er_de_h1);
        editText = findViewById(R.id.er_de_h2);
        editText.setText(er_de_h2);
        editText = findViewById(R.id.er_de_h3);
        editText.setText(er_de_h3);
        editText = findViewById(R.id.er_de_g1);
        editText.setText(er_de_g1);
        editText = findViewById(R.id.er_de_g2);
        editText.setText(er_de_g2);
        editText = findViewById(R.id.er_de_g3);
        editText.setText(er_de_g3);

        textView = findViewById(R.id.er_h_mx);
        textView.setText(h_mx);
        textView = findViewById(R.id.er_g_mx);
        textView.setText(g_mx);
        editText = findViewById(R.id.er_mx_h1);
        editText.setText(er_mx_h1);
        editText = findViewById(R.id.er_mx_h2);
        editText.setText(er_mx_h2);
        editText = findViewById(R.id.er_mx_h3);
        editText.setText(er_mx_h3);
        editText = findViewById(R.id.er_mx_g1);
        editText.setText(er_mx_g1);
        editText = findViewById(R.id.er_mx_g2);
        editText.setText(er_mx_g2);
        editText = findViewById(R.id.er_mx_g3);
        editText.setText(er_mx_g3);
    }


    @Override
    protected void onStop() {
        super.onStop();
        EditText editText = findViewById(R.id.er_hd1_h1);
        er_hd1_h1 = editText.getText().toString();
        if (er_hd1_h1.isEmpty())
            er_hd1_h1 = "0";
        editText = findViewById(R.id.er_hd1_h2);
        er_hd1_h2 = editText.getText().toString();
        if (er_hd1_h2.isEmpty())
            er_hd1_h2 = "0";
        editText = findViewById(R.id.er_hd1_h3);
        er_hd1_h3 = editText.getText().toString();
        if (er_hd1_h3.isEmpty())
            er_hd1_h3 = "0";
        editText = findViewById(R.id.er_hd1_g1);
        er_hd1_g1 = editText.getText().toString();
        if (er_hd1_g1.isEmpty())
            er_hd1_g1 = "0";
        editText = findViewById(R.id.er_hd1_g2);
        er_hd1_g2 = editText.getText().toString();
        if (er_hd1_g2.isEmpty())
            er_hd1_g2 = "0";
        editText = findViewById(R.id.er_hd1_g3);
        er_hd1_g3 = editText.getText().toString();
        if (er_hd1_g3.isEmpty())
            er_hd1_g3 = "0";

        editText = findViewById(R.id.er_hd2_h1);
        er_hd2_h1 = editText.getText().toString();
        if (er_hd2_h1.isEmpty())
            er_hd2_h1 = "0";
        editText = findViewById(R.id.er_hd2_h2);
        er_hd2_h2 = editText.getText().toString();
        if (er_hd2_h2.isEmpty())
            er_hd2_h2 = "0";
        editText = findViewById(R.id.er_hd2_h3);
        er_hd2_h3 = editText.getText().toString();
        if (er_hd2_h3.isEmpty())
            er_hd2_h3 = "0";
        editText = findViewById(R.id.er_hd2_g1);
        er_hd2_g1 = editText.getText().toString();
        if (er_hd2_g1.isEmpty())
            er_hd2_g1 = "0";
        editText = findViewById(R.id.er_hd2_g2);
        er_hd2_g2 = editText.getText().toString();
        if (er_hd2_g2.isEmpty())
            er_hd2_g2 = "0";
        editText = findViewById(R.id.er_hd2_g3);
        er_hd2_g3 = editText.getText().toString();
        if (er_hd2_g3.isEmpty())
            er_hd2_g3 = "0";

        editText = findViewById(R.id.er_dd_h1);
        er_dd_h1 = editText.getText().toString();
        if (er_dd_h1.isEmpty())
            er_dd_h1 = "0";
        editText = findViewById(R.id.er_dd_h2);
        er_dd_h2 = editText.getText().toString();
        if (er_dd_h2.isEmpty())
            er_dd_h2 = "0";
        editText = findViewById(R.id.er_dd_h3);
        er_dd_h3 = editText.getText().toString();
        if (er_dd_h3.isEmpty())
            er_dd_h3 = "0";
        editText = findViewById(R.id.er_dd_g1);
        er_dd_g1 = editText.getText().toString();
        if (er_dd_g1.isEmpty())
            er_dd_g1 = "0";
        editText = findViewById(R.id.er_dd_g2);
        er_dd_g2 = editText.getText().toString();
        if (er_dd_g2.isEmpty())
            er_dd_g2 = "0";
        editText = findViewById(R.id.er_dd_g3);
        er_dd_g3 = editText.getText().toString();
        if (er_dd_g3.isEmpty())
            er_dd_g3 = "0";

        editText = findViewById(R.id.er_he1_h1);
        er_he1_h1 = editText.getText().toString();
        if (er_he1_h1.isEmpty())
            er_he1_h1 = "0";
        editText = findViewById(R.id.er_he1_h2);
        er_he1_h2 = editText.getText().toString();
        if (er_he1_h2.isEmpty())
            er_he1_h2 = "0";
        editText = findViewById(R.id.er_he1_h3);
        er_he1_h3 = editText.getText().toString();
        if (er_he1_h3.isEmpty())
            er_he1_h3 = "0";
        editText = findViewById(R.id.er_he1_g1);
        er_he1_g1 = editText.getText().toString();
        if (er_he1_g1.isEmpty())
            er_he1_g1 = "0";
        editText = findViewById(R.id.er_he1_g2);
        er_he1_g2 = editText.getText().toString();
        if (er_he1_g2.isEmpty())
            er_he1_g2 = "0";
        editText = findViewById(R.id.er_he1_g3);
        er_he1_g3 = editText.getText().toString();
        if (er_he1_g3.isEmpty())
            er_he1_g3 = "0";

        editText = findViewById(R.id.er_he2_h1);
        er_he2_h1 = editText.getText().toString();
        if (er_he2_h1.isEmpty())
            er_he2_h1 = "0";
        editText = findViewById(R.id.er_he2_h2);
        er_he2_h2 = editText.getText().toString();
        if (er_he2_h2.isEmpty())
            er_he2_h2 = "0";
        editText = findViewById(R.id.er_he2_h3);
        er_he2_h3 = editText.getText().toString();
        if (er_he2_h3.isEmpty())
            er_he2_h3 = "0";
        editText = findViewById(R.id.er_he2_g1);
        er_he2_g1 = editText.getText().toString();
        if (er_he2_g1.isEmpty())
            er_he2_g1 = "0";
        editText = findViewById(R.id.er_he2_g2);
        er_he2_g2 = editText.getText().toString();
        if (er_he2_g2.isEmpty())
            er_he2_g2 = "0";
        editText = findViewById(R.id.er_he2_g3);
        er_he2_g3 = editText.getText().toString();
        if (er_he2_g3.isEmpty())
            er_he2_g3 = "0";

        editText = findViewById(R.id.er_he3_h1);
        er_he3_h1 = editText.getText().toString();
        if (er_he3_h1.isEmpty())
            er_he3_h1 = "0";
        editText = findViewById(R.id.er_he3_h2);
        er_he3_h2 = editText.getText().toString();
        if (er_he3_h2.isEmpty())
            er_he3_h2 = "0";
        editText = findViewById(R.id.er_he3_h3);
        er_he3_h3 = editText.getText().toString();
        if (er_he3_h3.isEmpty())
            er_he3_h3 = "0";
        editText = findViewById(R.id.er_he3_g1);
        er_he3_g1 = editText.getText().toString();
        if (er_he3_g1.isEmpty())
            er_he3_g1 = "0";
        editText = findViewById(R.id.er_he3_g2);
        er_he3_g2 = editText.getText().toString();
        if (er_he3_g2.isEmpty())
            er_he3_g2 = "0";
        editText = findViewById(R.id.er_he3_g3);
        er_he3_g3 = editText.getText().toString();
        if (er_he3_g3.isEmpty())
            er_he3_g3 = "0";

        editText = findViewById(R.id.er_de_h1);
        er_de_h1 = editText.getText().toString();
        if (er_de_h1.isEmpty())
            er_de_h1 = "0";
        editText = findViewById(R.id.er_de_h2);
        er_de_h2 = editText.getText().toString();
        if (er_de_h2.isEmpty())
            er_de_h2 = "0";
        editText = findViewById(R.id.er_de_h3);
        er_de_h3 = editText.getText().toString();
        if (er_de_h3.isEmpty())
            er_de_h3 = "0";
        editText = findViewById(R.id.er_de_g1);
        er_de_g1 = editText.getText().toString();
        if (er_de_g1.isEmpty())
            er_de_g1 = "0";
        editText = findViewById(R.id.er_de_g2);
        er_de_g2 = editText.getText().toString();
        if (er_de_g2.isEmpty())
            er_de_g2 = "0";
        editText = findViewById(R.id.er_de_g3);
        er_de_g3 = editText.getText().toString();
        if (er_de_g3.isEmpty())
            er_de_g3 = "0";

        editText = findViewById(R.id.er_mx_h1);
        er_mx_h1 = editText.getText().toString();
        if (er_mx_h1.isEmpty())
            er_mx_h1 = "0";
        editText = findViewById(R.id.er_mx_h2);
        er_mx_h2 = editText.getText().toString();
        if (er_mx_h2.isEmpty())
            er_mx_h2 = "0";
        editText = findViewById(R.id.er_mx_h3);
        er_mx_h3 = editText.getText().toString();
        if (er_mx_h3.isEmpty())
            er_mx_h3 = "0";
        editText = findViewById(R.id.er_mx_g1);
        er_mx_g1 = editText.getText().toString();
        if (er_mx_g1.isEmpty())
            er_mx_g1 = "0";
        editText = findViewById(R.id.er_mx_g2);
        er_mx_g2 = editText.getText().toString();
        if (er_mx_g2.isEmpty())
            er_mx_g2 = "0";
        editText = findViewById(R.id.er_mx_g3);
        er_mx_g3 = editText.getText().toString();
        if (er_mx_g3.isEmpty())
            er_mx_g3 = "0";
    }

    public void button_sign_heim(View view) {
        Intent intent = new Intent(this, sign_heim.class);
        startActivity(intent);
    }

    public void button_sign_gast(View view) {
        Intent intent = new Intent(this, sign_gast.class);
        startActivity(intent);
    }
}
