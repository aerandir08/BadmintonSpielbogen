package de.tv1875paderborn.malte.badmintonspielbogen;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.gast_team;
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.gastverein;
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.heim_team;
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.mail_gast;

public class menu_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_3);
        setTitle(gastverein);
    }

    @Override
    protected void onPause() {
        super.onPause();

        int resID;
        String name;
        EditText editText;

        editText = findViewById(R.id.edit_mail);
        mail_gast = editText.getText().toString();

        // Spielernamen
        for (int ii=0; ii<12; ii++){
            name = "edit_" + Integer.toString(ii);
            resID = getResources().getIdentifier(name, "id", getPackageName());
            editText = findViewById(resID);
            gast_team[ii] = editText.getText().toString();
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
        editText.setText(mail_gast);

        // Spielernamen
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
    }
}
