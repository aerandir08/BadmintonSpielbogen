package de.tv1875paderborn.malte.badmintonspielbogen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.heimverein;
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.heim_team;

public class menu_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_2);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText(heimverein);

        EditText editText = findViewById(R.id.edit_hd11);
        editText.setText(heim_team[0]);
        editText = findViewById(R.id.edit_hd12);
        editText.setText(heim_team[1]);
        editText = findViewById(R.id.edit_hd21);
        editText.setText(heim_team[2]);
        editText = findViewById(R.id.edit_hd22);
        editText.setText(heim_team[3]);
        editText = findViewById(R.id.edit_dd1);
        editText.setText(heim_team[4]);
        editText = findViewById(R.id.edit_dd2);
        editText.setText(heim_team[5]);
        editText = findViewById(R.id.edit_he1);
        editText.setText(heim_team[6]);
        editText = findViewById(R.id.edit_he2);
        editText.setText(heim_team[7]);
        editText = findViewById(R.id.edit_he3);
        editText.setText(heim_team[8]);
        editText = findViewById(R.id.edit_de);
        editText.setText(heim_team[9]);
        editText = findViewById(R.id.edit_mx1);
        editText.setText(heim_team[10]);
        editText = findViewById(R.id.edit_mx2);
        editText.setText(heim_team[11]);
    }

    @Override
    protected void onStop() {
        super.onStop();

        EditText editText = findViewById(R.id.edit_hd11);
        heim_team[0] = editText.getText().toString();
        editText = findViewById(R.id.edit_hd12);
        heim_team[1] = editText.getText().toString();
        editText = findViewById(R.id.edit_hd21);
        heim_team[2] = editText.getText().toString();
        editText = findViewById(R.id.edit_hd22);
        heim_team[3] = editText.getText().toString();
        editText = findViewById(R.id.edit_dd1);
        heim_team[4] = editText.getText().toString();
        editText = findViewById(R.id.edit_dd2);
        heim_team[5] = editText.getText().toString();
        editText = findViewById(R.id.edit_he1);
        heim_team[6] = editText.getText().toString();
        editText = findViewById(R.id.edit_he2);
        heim_team[7] = editText.getText().toString();
        editText = findViewById(R.id.edit_he3);
        heim_team[8] = editText.getText().toString();
        editText = findViewById(R.id.edit_de);
        heim_team[9] = editText.getText().toString();
        editText = findViewById(R.id.edit_mx1);
        heim_team[10] = editText.getText().toString();
        editText = findViewById(R.id.edit_mx2);
        heim_team[11] = editText.getText().toString();
    }
}
