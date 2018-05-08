package de.tv1875paderborn.malte.badmintonspielbogen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.gastverein;
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
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.heimverein;

public class menu_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_2);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText(heimverein);

        EditText editText = findViewById(R.id.edit_hd11);
        editText.setText(h_hd11);
        editText = findViewById(R.id.edit_hd12);
        editText.setText(h_hd12);
        editText = findViewById(R.id.edit_hd21);
        editText.setText(h_hd21);
        editText = findViewById(R.id.edit_hd22);
        editText.setText(h_hd22);
        editText = findViewById(R.id.edit_dd1);
        editText.setText(h_dd1);
        editText = findViewById(R.id.edit_dd2);
        editText.setText(h_dd2);
        editText = findViewById(R.id.edit_he1);
        editText.setText(h_he1);
        editText = findViewById(R.id.edit_he2);
        editText.setText(h_he2);
        editText = findViewById(R.id.edit_he3);
        editText.setText(h_he3);
        editText = findViewById(R.id.edit_de);
        editText.setText(h_de);
        editText = findViewById(R.id.edit_mx1);
        editText.setText(h_mx1);
        editText = findViewById(R.id.edit_mx2);
        editText.setText(h_mx2);
    }

    public void button_save(View view) {
        EditText editText = findViewById(R.id.edit_hd11);
        h_hd11 = editText.getText().toString();
        editText = findViewById(R.id.edit_hd12);
        h_hd12 = editText.getText().toString();
        editText = findViewById(R.id.edit_hd21);
        h_hd21 = editText.getText().toString();
        editText = findViewById(R.id.edit_hd22);
        h_hd22 = editText.getText().toString();
        editText = findViewById(R.id.edit_dd1);
        h_dd1 = editText.getText().toString();
        editText = findViewById(R.id.edit_dd2);
        h_dd2 = editText.getText().toString();
        editText = findViewById(R.id.edit_he1);
        h_he1 = editText.getText().toString();
        editText = findViewById(R.id.edit_he2);
        h_he2 = editText.getText().toString();
        editText = findViewById(R.id.edit_he3);
        h_he3 = editText.getText().toString();
        editText = findViewById(R.id.edit_de);
        h_de = editText.getText().toString();
        editText = findViewById(R.id.edit_mx1);
        h_mx1 = editText.getText().toString();
        editText = findViewById(R.id.edit_mx2);
        h_mx2 = editText.getText().toString();
    }
}