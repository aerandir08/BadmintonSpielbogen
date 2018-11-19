package de.tv1875paderborn.malte.badmintonspielbogen;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    // Allgemeine Daten speichern
    public static String heimverein;
    public static String gastverein;
    public static String staffel;
    public static String ort;
    public static String zeit;
    public static String kommentar;

    // Spielernamen
    public static String[] heim_team = new String[12];
    public static String[] gast_team = new String[12];


    // Alle Ergebnisse als Integer
    public static Integer[][] heim_erg = new Integer[8][3];
    public static Integer[][] gast_erg = new Integer[8][3];

    public static boolean erg_opend = false;
    public static boolean sign_h = false;
    public static boolean sign_g = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button;
        button = findViewById(R.id.button_pdf_vorschau);
        button.setEnabled(false);
        button = findViewById(R.id.button_sign_heim);
        button.setEnabled(false);
        button = findViewById(R.id.button_sign_gast);
        button.setEnabled(false);
        button = findViewById(R.id.button_share_pdf);
        button.setEnabled(false);
    }

    @Override
    protected void onPause() {
        super.onPause();

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
        editText = findViewById(R.id.editText_kommentar);
        kommentar = editText.getText().toString();
    }

    @Override
    protected void onResume() {
        super.onResume();

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
        editText = findViewById(R.id.editText_kommentar);
        editText.setText(kommentar);

        Button button;
        if (erg_opend) {
            button = findViewById(R.id.button_pdf_vorschau);
            button.setEnabled(true);
            button = findViewById(R.id.button_sign_heim);
            button.setEnabled(true);
            button = findViewById(R.id.button_sign_gast);
            button.setEnabled(true);
        }

        if (sign_h && sign_g) {
            button = findViewById(R.id.button_share_pdf);
            button.setEnabled(true);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

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
                save_json();
                return true;
            case R.id.menu_load:
                choose_file_load();
                return true;
            case R.id.menu_delete:
                choose_file_delete();
                return true;
            case R.id.menu_reset:
                reset();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public void save_json(){
        onStop();
        Date datum = Calendar.getInstance().getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.GERMANY);
        String date = simpleDateFormat.format(datum);

        try {
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("heimverein", heimverein);
            jsonObj.put("gastverein", gastverein);
            jsonObj.put("staffel", staffel);
            jsonObj.put("ort", ort);
            jsonObj.put("zeit", zeit);
            jsonObj.put("kommentar", kommentar);

            for (int ii=0; ii<12; ii++) {
                jsonObj.put("heim_team_"+Integer.toString(ii), heim_team[ii]);
                jsonObj.put("gast_team_"+Integer.toString(ii), gast_team[ii]);

            }

            for (int ii=0; ii<8; ii++) {
                for (int jj=0; jj<3; jj++){
                    jsonObj.put("heim_erg_" + Integer.toString(ii) + "_" + Integer.toString(jj), heim_erg[ii][jj]);
                    jsonObj.put("gast_erg_" + Integer.toString(ii) + "_" + Integer.toString(jj), gast_erg[ii][jj]);
                }
            }

            try {
                File file = new File(this.getBaseContext().getExternalFilesDir(null), date + "_" + heimverein + "-" + gastverein + ".json");

                Writer output = new BufferedWriter(new FileWriter(file));
                output.write(jsonObj.toString());
                output.close();

                Toast.makeText(this.getBaseContext(), "gespeichert", Toast.LENGTH_LONG).show();
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }
        catch(JSONException ex) {
            ex.printStackTrace();
        }
    }

    private static String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }

    private void choose_file_load(){

        final ArrayList<String> l_jason = new ArrayList<>();
        File file= new File(this.getBaseContext().getExternalFilesDir(null), "");
        for (File f : file.listFiles()) {
            if (f.isFile())
                if (getFileExtension(f).equals("json"))
                    l_jason.add(f.getName());
        }

        final CharSequence[] cs = l_jason.toArray(new CharSequence[l_jason.size()]);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Wähle ein Spiel");
        if (l_jason.size() == 0) {
            builder.setMessage("Keine Spiele vorhanden");
        }
        builder.setItems(cs, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String filename = cs[which].toString();
                load_json(filename);
            }
        });
        builder.show();
    }

    public void load_json(String filename){
        File file = new File(this.getBaseContext().getExternalFilesDir(null), filename);

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null){
                stringBuilder.append(line).append("\n");
            }
            reader.close();
            String json = stringBuilder.toString();
            try {
                JSONObject jsonObj = new JSONObject(json);
                heimverein = get_string_from_json(jsonObj,"heimverein");
                gastverein = get_string_from_json(jsonObj,"gastverein");
                staffel = get_string_from_json(jsonObj,"staffel");
                ort = get_string_from_json(jsonObj,"ort");
                zeit = get_string_from_json(jsonObj,"zeit");
                kommentar = get_string_from_json(jsonObj, "kommentar");

                for (int ii=0; ii<12; ii++) {
                    heim_team[ii] = get_string_from_json(jsonObj, "heim_team_"+Integer.toString(ii));
                    gast_team[ii] = get_string_from_json(jsonObj, "gast_team_"+Integer.toString(ii));
                }


                for (int ii=0; ii<8; ii++) {
                    for (int jj=0; jj<3; jj++){
                        String value = get_string_from_json(jsonObj, "heim_erg_" + Integer.toString(ii) + "_" + Integer.toString(jj));
                        if (!value.isEmpty()) {
                            heim_erg[ii][jj] = Integer.parseInt(value);
                        }else{
                            heim_erg[ii][jj] = null;
                        }
                        value = get_string_from_json(jsonObj, "gast_erg_" + Integer.toString(ii) + "_" + Integer.toString(jj));
                        if (!value.isEmpty()) {
                            gast_erg[ii][jj] = Integer.parseInt(value);
                        }else{
                            gast_erg[ii][jj] = null;
                        }
                    }
                }


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
                editText = findViewById(R.id.editText_kommentar);
                editText.setText(kommentar);

            } catch (Exception ex){
                ex.printStackTrace();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }

    public void choose_file_delete(){
        final ArrayList<String> l_jason = new ArrayList<>();
        File file= new File(this.getBaseContext().getExternalFilesDir(null), "");
        for (File f : file.listFiles()) {
            if (f.isFile())
                if (getFileExtension(f).equals("json"))
                    l_jason.add(f.getName());
        }

        final String[] cs = l_jason.toArray(new String[0]);
        final boolean[] checked = new boolean[l_jason.size()];
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Wähle ein Spiel");
        if (l_jason.size() == 0) {
            builder.setMessage("Keine Spiele vorhanden");
        }
        else {
            builder.setMultiChoiceItems(cs, checked, new DialogInterface.OnMultiChoiceClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                    // Update the current focused item's checked status
                    checked[which] = isChecked;
                }
            });
            // Specify the dialog is not cancelable
            builder.setCancelable(false);

            // Set a title for alert dialog
            builder.setTitle("Welche Datein sollen gelöscht werden?");

            // Set the positive/yes button click listener
            builder.setPositiveButton("Löschen", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // Do something when click positive button
                    for (int i = 0; i < checked.length; i++) {
                        if (checked[i]) {
                            String filename = cs[i];
                            delete_json(filename);
                        }
                    }
                }
            });

            // Set the neutral/cancel button click listener
            builder.setNeutralButton("Abbrechen", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // Do something when click the neutral button
                }
            });
        }
        AlertDialog dialog = builder.create();
        // Display the alert dialog on interface
        dialog.show();
    }

    public void delete_json(String filename){
        File file = new File(this.getBaseContext().getExternalFilesDir(null), filename);
        boolean bla = file.delete();
    }

    public String get_string_from_json(JSONObject jsonObj, String value){
        if (jsonObj.has(value)){
            try {
                return jsonObj.getString(value);
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }else {
            return "";
        }
        return null;
    }

    public void reset(){
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
        editText = findViewById(R.id.editText_kommentar);
        editText.setText("");

        for (int ii=0; ii<12; ii++) {
            heim_team[ii] = "";
            gast_team[ii] = "";
        }

        for (int ii=0; ii<8; ii++) {
            for (int jj=0; jj<3; jj++){
                heim_erg[ii][jj] = null;
                gast_erg[ii][jj] = null;
            }
        }
        erg_opend = false;
        sign_h = false;
        sign_g = false;
        


        File myFile;
        myFile = new File(this.getBaseContext().getExternalFilesDir(null), "/unterschriften/sign_heim.png");
        if (myFile.exists()) {
            boolean bla = myFile.delete();
        }
        myFile = new File(this.getBaseContext().getExternalFilesDir(null), "/unterschriften/sign_gast.png");
        if (myFile.exists()) {
            boolean bla = myFile.delete();
        }

        Button button = findViewById(R.id.button_share_pdf);
        button.setEnabled(false);
        button = findViewById(R.id.button_pdf_vorschau);
        button.setEnabled(false);
        button = findViewById(R.id.button_sign_heim);
        button.setEnabled(false);
        button = findViewById(R.id.button_sign_gast);
        button.setEnabled(false);

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

    public void button_sign_heim(View view) {
        Intent intent = new Intent(this, sign_heim.class);
        startActivity(intent);
    }

    public void button_sign_gast(View view) {
        Intent intent = new Intent(this, sign_gast.class);
        startActivity(intent);
    }

    public void button_pdf(View view){
        Context context = getBaseContext();
        save_json();
        create_pdf.main(context, true);

        Date datum = Calendar.getInstance().getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.GERMANY);
        String date = simpleDateFormat.format(datum);

        File file = new File(context.getExternalFilesDir(null), date + "_" + heimverein + "-" + gastverein + ".pdf");
        Uri path = Uri.fromFile(file);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(path, "application/pdf");
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void button_share_pdf(View view){
        Context context = getBaseContext();
        create_pdf.main(context, false);

        Date datum = Calendar.getInstance().getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.GERMANY);
        String date = simpleDateFormat.format(datum);

        // the directory where the signature will be saved
        String pdfname = date + "_" + heimverein + "-" + gastverein + ".pdf";
        String mimeType = "application/pdf";
        File file = new File(getBaseContext().getExternalFilesDir(null), pdfname);

        Uri uri = FileProvider.getUriForFile(this, "de.tv1875paderborn.malte.badmintonspielbogen.fileprovider", file);
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType(mimeType);
        intent.putExtra(Intent.EXTRA_STREAM, uri);
        startActivity(Intent.createChooser(intent, "PDF senden..."));
    }
}
