package de.tv1875paderborn.malte.badmintonspielbogen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.gastverein;
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.gast_team;

public class menu_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_2);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText(gastverein);

        EditText editText = findViewById(R.id.edit_hd11);
        editText.setText(gast_team[0]);
        editText = findViewById(R.id.edit_hd12);
        editText.setText(gast_team[1]);
        editText = findViewById(R.id.edit_hd21);
        editText.setText(gast_team[2]);
        editText = findViewById(R.id.edit_hd22);
        editText.setText(gast_team[3]);
        editText = findViewById(R.id.edit_dd1);
        editText.setText(gast_team[4]);
        editText = findViewById(R.id.edit_dd2);
        editText.setText(gast_team[5]);
        editText = findViewById(R.id.edit_he1);
        editText.setText(gast_team[6]);
        editText = findViewById(R.id.edit_he2);
        editText.setText(gast_team[7]);
        editText = findViewById(R.id.edit_he3);
        editText.setText(gast_team[8]);
        editText = findViewById(R.id.edit_de);
        editText.setText(gast_team[9]);
        editText = findViewById(R.id.edit_mx1);
        editText.setText(gast_team[10]);
        editText = findViewById(R.id.edit_mx2);
        editText.setText(gast_team[11]);
    }

    @Override
    protected void onStop() {
        super.onStop();

        EditText editText = findViewById(R.id.edit_hd11);
        gast_team[0] = editText.getText().toString();
        editText = findViewById(R.id.edit_hd12);
        gast_team[1] = editText.getText().toString();
        editText = findViewById(R.id.edit_hd21);
        gast_team[2] = editText.getText().toString();
        editText = findViewById(R.id.edit_hd22);
        gast_team[3] = editText.getText().toString();
        editText = findViewById(R.id.edit_dd1);
        gast_team[4] = editText.getText().toString();
        editText = findViewById(R.id.edit_dd2);
        gast_team[5] = editText.getText().toString();
        editText = findViewById(R.id.edit_he1);
        gast_team[6] = editText.getText().toString();
        editText = findViewById(R.id.edit_he2);
        gast_team[7] = editText.getText().toString();
        editText = findViewById(R.id.edit_he3);
        gast_team[8] = editText.getText().toString();
        editText = findViewById(R.id.edit_de);
        gast_team[9] = editText.getText().toString();
        editText = findViewById(R.id.edit_mx1);
        gast_team[10] = editText.getText().toString();
        editText = findViewById(R.id.edit_mx2);
        gast_team[11] = editText.getText().toString();
    }
}
