package de.tv1875paderborn.malte.badmintonspielbogen;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.gastverein;
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.g_dd1;
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.g_dd2;
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

public class menu_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_3);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText(gastverein);

        EditText editText = findViewById(R.id.edit_hd11);
        editText.setText(g_hd11);
        editText = findViewById(R.id.edit_hd12);
        editText.setText(g_hd12);
        editText = findViewById(R.id.edit_hd21);
        editText.setText(g_hd21);
        editText = findViewById(R.id.edit_hd22);
        editText.setText(g_hd22);
        editText = findViewById(R.id.edit_dd1);
        editText.setText(g_dd1);
        editText = findViewById(R.id.edit_dd2);
        editText.setText(g_dd2);
        editText = findViewById(R.id.edit_he1);
        editText.setText(g_he1);
        editText = findViewById(R.id.edit_he2);
        editText.setText(g_he2);
        editText = findViewById(R.id.edit_he3);
        editText.setText(g_he3);
        editText = findViewById(R.id.edit_de);
        editText.setText(g_de);
        editText = findViewById(R.id.edit_mx1);
        editText.setText(g_mx1);
        editText = findViewById(R.id.edit_mx2);
        editText.setText(g_mx2);
    }

    public void button_save(View view) {
        EditText editText = findViewById(R.id.edit_hd11);
        g_hd11 = editText.getText().toString();
        editText = findViewById(R.id.edit_hd12);
        g_hd12 = editText.getText().toString();
        editText = findViewById(R.id.edit_hd21);
        g_hd21 = editText.getText().toString();
        editText = findViewById(R.id.edit_hd22);
        g_hd22 = editText.getText().toString();
        editText = findViewById(R.id.edit_dd1);
        g_dd1 = editText.getText().toString();
        editText = findViewById(R.id.edit_dd2);
        g_dd2 = editText.getText().toString();
        editText = findViewById(R.id.edit_he1);
        g_he1 = editText.getText().toString();
        editText = findViewById(R.id.edit_he2);
        g_he2 = editText.getText().toString();
        editText = findViewById(R.id.edit_he3);
        g_he3 = editText.getText().toString();
        editText = findViewById(R.id.edit_de);
        g_de = editText.getText().toString();
        editText = findViewById(R.id.edit_mx1);
        g_mx1 = editText.getText().toString();
        editText = findViewById(R.id.edit_mx2);
        g_mx2 = editText.getText().toString();

        Context context = getApplicationContext();
        Toast.makeText(context, "Daten gespeichert", Toast.LENGTH_SHORT).show();
    }
}
