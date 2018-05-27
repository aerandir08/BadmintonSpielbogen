package de.tv1875paderborn.malte.badmintonspielbogen;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;

import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_hd1_h1;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_hd1_h2;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_hd1_h3;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_hd2_h1;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_hd2_h2;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_hd2_h3;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_dd_h1;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_dd_h2;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_dd_h3;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_he1_h1;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_he1_h2;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_he1_h3;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_he2_h1;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_he2_h2;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_he2_h3;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_he3_h1;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_he3_h2;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_he3_h3;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_de_h1;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_de_h2;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_de_h3;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_mx_h1;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_mx_h2;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_mx_h3;

import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_hd1_g1;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_hd1_g2;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_hd1_g3;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_hd2_g1;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_hd2_g2;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_hd2_g3;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_dd_g1;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_dd_g2;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_dd_g3;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_he1_g1;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_he1_g2;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_he1_g3;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_he2_g1;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_he2_g2;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_he2_g3;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_he3_g1;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_he3_g2;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_he3_g3;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_de_g1;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_de_g2;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_de_g3;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_mx_g1;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_mx_g2;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_mx_g3;

public class MainActivity extends AppCompatActivity {
    // Allgemeine Daten speichern
    public static String heimverein;
    public static String gastverein;
    public static String staffel;
    public static String ort;
    public static String zeit;

    // Namen des Heimvereins speichern
    public static String h_hd11;
    public static String h_hd12;
    public static String h_hd21;
    public static String h_hd22;
    public static String h_dd1;
    public static String h_dd2;
    public static String h_he1;
    public static String h_he2;
    public static String h_he3;
    public static String h_de;
    public static String h_mx1;
    public static String h_mx2;

    // Namen des Gastvereins speichern
    public static String g_hd11;
    public static String g_hd12;
    public static String g_hd21;
    public static String g_hd22;
    public static String g_dd1;
    public static String g_dd2;
    public static String g_he1;
    public static String g_he2;
    public static String g_he3;
    public static String g_de;
    public static String g_mx1;
    public static String g_mx2;

    public static boolean erg_opend = false;
    public static boolean pdf_created = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = findViewById(R.id.editText_heimverein);
        editText.setText(heimverein);
        editText = findViewById(R.id.editText_gastverein);
        editText.setText(gastverein);
        editText = findViewById(R.id.editText_staffel);
        editText.setText(staffel);
        editText = findViewById(R.id.editText_ort);
        editText.setText(ort);
        editText = findViewById(R.id.editText_zeit);
        editText.setText(zeit);

        Button button = findViewById(R.id.button_create_pdf);
        if (erg_opend){
            button.setEnabled(true);
        }else{
            button.setEnabled(false);
        }
        button = findViewById(R.id.button_share_pdf);
        if (pdf_created) {
            button.setEnabled(true);
        }else{
            button.setEnabled(false);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        EditText editText = findViewById(R.id.editText_heimverein);
        heimverein = editText.getText().toString();
        editText = findViewById(R.id.editText_gastverein);
        gastverein = editText.getText().toString();
        editText = findViewById(R.id.editText_staffel);
        staffel = editText.getText().toString();
        editText = findViewById(R.id.editText_ort);
        ort = editText.getText().toString();
        editText = findViewById(R.id.editText_zeit);
        zeit = editText.getText().toString();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menu_save:
                save();
                return true;
            case R.id.menu_reset:
                reset();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void save(){

    }
    
    final void reset(){
        EditText editText = findViewById(R.id.editText_heimverein);
        editText.setText("");
        editText = findViewById(R.id.editText_gastverein);
        editText.setText("");
        editText = findViewById(R.id.editText_staffel);
        editText.setText("");
        editText = findViewById(R.id.editText_ort);
        editText.setText("");
        editText = findViewById(R.id.editText_zeit);
        editText.setText("");

        h_hd11 = "";
        h_hd12 = "";
        h_hd21 = "";
        h_hd22 = "";
        h_dd1 = "";
        h_dd2 = "";
        h_he1 = "";
        h_he2 = "";
        h_he3 = "";
        h_de = "";
        h_mx1 = "";
        h_mx2 = "";
        
        g_hd11 = "";
        g_hd12 = "";
        g_hd21 = "";
        g_hd22 = "";
        g_dd1 = "";
        g_dd2 = "";
        g_he1 = "";
        g_he2 = "";
        g_he3 = "";
        g_de = "";
        g_mx1 = "";
        g_mx2 = "";

        erg_opend = false;
        pdf_created = false;
        
        er_hd1_h1 = "";
        er_hd1_h2 = "";
        er_hd1_h3 = "";
        er_hd2_h1 = "";
        er_hd2_h2 = "";
        er_hd2_h3 = "";
        er_dd_h1 = "";
        er_dd_h2 = "";
        er_dd_h3 = "";
        er_he1_h1 = "";
        er_he1_h2 = "";
        er_he1_h3 = "";
        er_he2_h1 = "";
        er_he2_h2 = "";
        er_he2_h3 = "";
        er_he3_h1 = "";
        er_he3_h2 = "";
        er_he3_h3 = "";
        er_de_h1 = "";
        er_de_h2 = "";
        er_de_h3 = "";
        er_mx_h1 = "";
        er_mx_h2 = "";
        er_mx_h3 = "";

        er_hd1_g1 = "";
        er_hd1_g2 = "";
        er_hd1_g3 = "";
        er_hd2_g1 = "";
        er_hd2_g2 = "";
        er_hd2_g3 = "";
        er_dd_g1 = "";
        er_dd_g2 = "";
        er_dd_g3 = "";
        er_he1_g1 = "";
        er_he1_g2 = "";
        er_he1_g3 = "";
        er_he2_g1 = "";
        er_he2_g2 = "";
        er_he2_g3 = "";
        er_he3_g1 = "";
        er_he3_g2 = "";
        er_he3_g3 = "";
        er_de_g1 = "";
        er_de_g2 = "";
        er_de_g3 = "";
        er_mx_g1 = "";
        er_mx_g2 = "";
        er_mx_g3 = "";

        File myFile;
        myFile = new File(this.getBaseContext().getExternalFilesDir(null), "/unterschriften/sign_heim.png");
        if (myFile.exists()) {
            myFile.delete();
        }
        myFile = new File(this.getBaseContext().getExternalFilesDir(null), "/unterschriften/sign_gast.png");
        if (myFile.exists()) {
            myFile.delete();
        }

        Toast.makeText(this.getBaseContext(), "Alle Eingaben gelöscht", Toast.LENGTH_LONG).show();
    }

    public void button_heimverein(View view) {
        Intent intent = new Intent(this, menu_2.class);
        startActivity(intent);
    }

    public void button_gastverein(View view) {
        Intent intent = new Intent(this, menu_3.class);
        startActivity(intent);
    }

    public void button_ergebnis(View view) {
        Intent intent = new Intent(this, ergebnis.class);
        startActivity(intent);
        erg_opend = true;
    }

    public void button_pdf(View view){
        Context context = getBaseContext();
        create_pdf.main(context);
        Button button = findViewById(R.id.button_share_pdf);
        if (pdf_created) {
            button.setEnabled(true);
        }else{
            button.setEnabled(false);
        }
    }

    public void button_share_pdf(View view){
        String pdfname = heimverein + "-" + gastverein + ".pdf";
        String mimeType = "application/pdf";
        File file = new File(getBaseContext().getExternalFilesDir(null), pdfname);

        Uri uri = FileProvider.getUriForFile(this, "de.tv1875paderborn.malte.badmintonspielbogen.fileprovider", file);
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType(mimeType);
        intent.putExtra(Intent.EXTRA_STREAM, uri);
        startActivity(Intent.createChooser(intent, "PDF senden..."));
    }
}
