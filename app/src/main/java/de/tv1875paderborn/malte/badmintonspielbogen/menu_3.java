package de.tv1875paderborn.malte.badmintonspielbogen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.gast_team;
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.gastverein;
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.heim_team;

public class menu_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_3);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText(gastverein);

        int resID;
        String name;
        EditText editText;

        //Spielernamen
        for (int ii=0; ii<12; ii++){
            name = "text_" + Integer.toString(ii);
            resID = getResources().getIdentifier(name, "id", getPackageName());
            textView = findViewById(resID);
            textView.setText(heim_team[ii]);

            name = "edit_" + Integer.toString(ii);
            resID = getResources().getIdentifier(name, "id", getPackageName());
            editText = findViewById(resID);
            editText.setText(gast_team[ii]);
        }

    }

    @Override
    protected void onStop() {
        super.onStop();

        int resID;
        String name;
        EditText editText;

        //Spielernamen
        for (int ii=0; ii<12; ii++){
            name = "edit_" + Integer.toString(ii);
            resID = getResources().getIdentifier(name, "id", getPackageName());
            editText = findViewById(resID);
            gast_team[ii] = editText.getText().toString();
        }
    }
}
