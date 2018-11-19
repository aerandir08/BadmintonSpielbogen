package de.tv1875paderborn.malte.badmintonspielbogen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.gast_team;
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.heim_team;

import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.heim_erg;
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.gast_erg;

public class ergebnis extends AppCompatActivity {
    public static boolean sign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ergebnis);
        setTitle("Ergebnisse eintragen");

        // Strings zur Darstellung
        String erg_namen[] = new String[16];
        erg_namen[0] = heim_team[0] + "\n" + heim_team[1];
        erg_namen[1] = heim_team[2] + "\n" + heim_team[3];
        erg_namen[2] = heim_team[4] + "\n" + heim_team[5];
        erg_namen[3] = heim_team[6];
        erg_namen[4] = heim_team[7];
        erg_namen[5] = heim_team[8];
        erg_namen[6] = heim_team[9];
        erg_namen[7] = heim_team[10] + "\n" + heim_team[11];
        erg_namen[8] = gast_team[0] + "\n" + gast_team[1];
        erg_namen[9] = gast_team[2] + "\n" + gast_team[3];
        erg_namen[10] = gast_team[4] + "\n" + gast_team[5];
        erg_namen[11] = gast_team[6];
        erg_namen[12] = gast_team[7];
        erg_namen[13] = gast_team[8];
        erg_namen[14] = gast_team[9];
        erg_namen[15] = gast_team[10] + "\n" + gast_team[11];


        String name;
        int resID;
        TextView textView;

        //Spielernamen
        for (int ii=0; ii<16; ii++){
            name = "erg_name_"+Integer.toString(ii);
            resID = getResources().getIdentifier(name, "id", getPackageName());
            textView = findViewById(resID);
            textView.setText(erg_namen[ii]);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        String name;
        int resID;
        EditText editText;
        String temp;

        // Ergebnisse Heim Team
        for (int game=0; game<8; game++){
            for (int set=0; set<3; set++){
                name = "heim_"+Integer.toString(game)+"_"+Integer.toString(set);
                resID = getResources().getIdentifier(name, "id", getPackageName());
                editText = findViewById(resID);
                temp = editText.getText().toString();
                if (!temp.isEmpty()) {
                    heim_erg[game][set] = Integer.parseInt(temp);
                }else{
                    heim_erg[game][set] = null;
                }
            }
        }

        // Ergebnisse Gast Team
        for (int game=0; game<8; game++){
            for (int set=0; set<3; set++){
                name = "gast_"+Integer.toString(game)+"_"+Integer.toString(set);
                resID = getResources().getIdentifier(name, "id", getPackageName());
                editText = findViewById(resID);
                temp = editText.getText().toString();
                if (!temp.isEmpty()) {
                    gast_erg[game][set] = Integer.parseInt(temp);
                }else{
                    gast_erg[game][set] = null;
                }
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        String name;
        int resID;
        EditText editText;

        // Ergebnisse Heim Team
        for (int game=0; game<8; game++){
            for (int set=0; set<3; set++){
                name = "heim_"+Integer.toString(game)+"_"+Integer.toString(set);
                resID = getResources().getIdentifier(name, "id", getPackageName());
                editText = findViewById(resID);
                if (heim_erg[game][set] != null) {
                    editText.setText(String.valueOf(heim_erg[game][set]));
                }else{
                    editText.setText("");
                }
            }
        }

        // Ergebnisse Gast Team
        for (int game=0; game<8; game++){
            for (int set=0; set<3; set++){
                name = "gast_"+Integer.toString(game)+"_"+Integer.toString(set);
                resID = getResources().getIdentifier(name, "id", getPackageName());
                editText = findViewById(resID);
                if (gast_erg[game][set] != null) {
                    editText.setText(String.valueOf(gast_erg[game][set]));
                }else{
                    editText.setText("");
                }
            }
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

}
