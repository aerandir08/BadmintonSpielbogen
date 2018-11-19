package de.tv1875paderborn.malte.badmintonspielbogen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.gast_team;
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.heimverein;
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.heim_team;
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.mail_heim;

public class menu_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_2);
        setTitle(heimverein);
    }

    @Override
    protected void onPause() {
        super.onPause();

        int resID;
        String name;
        EditText editText;

        editText = findViewById(R.id.edit_mail);
        mail_heim = editText.getText().toString();

        // Spielernamen
        for (int ii=0; ii<12; ii++){
            name = "edit_" + Integer.toString(ii);
            resID = getResources().getIdentifier(name, "id", getPackageName());
            editText = findViewById(resID);
            heim_team[ii] = editText.getText().toString();
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        int resID;
        String name;
        EditText editText;
        TextView textView;

        editText = findViewById(R.id.edit_mail);
        editText.setText(mail_heim);

        // Spielernamen
        for (int ii=0; ii<12; ii++){
            name = "text_" + Integer.toString(ii);
            resID = getResources().getIdentifier(name, "id", getPackageName());
            textView = findViewById(resID);
            textView.setText(gast_team[ii]);

            name = "edit_" + Integer.toString(ii);
            resID = getResources().getIdentifier(name, "id", getPackageName());
            editText = findViewById(resID);
            editText.setText(heim_team[ii]);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

    }
}
