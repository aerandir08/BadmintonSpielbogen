package de.tv1875paderborn.malte.badmintonspielbogen;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Environment;
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
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    // Allgemeine Daten speichern
    public static String heimverein;
    public static String gastverein;
    public static String staffel;
    public static String ort;
    public static String zeit;
    public static String kommentar;

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

    // Alle Ergebnisse als String
    public  static String er_hd1_h1;
    public  static String er_hd1_h2;
    public  static String er_hd1_h3;
    public  static String er_hd1_g1;
    public  static String er_hd1_g2;
    public  static String er_hd1_g3;
    public  static String er_hd2_h1;
    public  static String er_hd2_h2;
    public  static String er_hd2_h3;
    public  static String er_hd2_g1;
    public  static String er_hd2_g2;
    public  static String er_hd2_g3;
    public  static String er_dd_h1;
    public  static String er_dd_h2;
    public  static String er_dd_h3;
    public  static String er_dd_g1;
    public  static String er_dd_g2;
    public  static String er_dd_g3;
    public  static String er_he1_h1;
    public  static String er_he1_h2;
    public  static String er_he1_h3;
    public  static String er_he1_g1;
    public  static String er_he1_g2;
    public  static String er_he1_g3;
    public  static String er_he2_h1;
    public  static String er_he2_h2;
    public  static String er_he2_h3;
    public  static String er_he2_g1;
    public  static String er_he2_g2;
    public  static String er_he2_g3;
    public  static String er_he3_h1;
    public  static String er_he3_h2;
    public  static String er_he3_h3;
    public  static String er_he3_g1;
    public  static String er_he3_g2;
    public  static String er_he3_g3;
    public  static String er_de_h1;
    public  static String er_de_h2;
    public  static String er_de_h3;
    public  static String er_de_g1;
    public  static String er_de_g2;
    public  static String er_de_g3;
    public  static String er_mx_h1;
    public  static String er_mx_h2;
    public  static String er_mx_h3;
    public  static String er_mx_g1;
    public  static String er_mx_g2;
    public  static String er_mx_g3;

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
        editText = findViewById(R.id.editText_kommentar);
        editText.setText(kommentar);

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
        editText = findViewById(R.id.editText_kommentar);
        kommentar = editText.getText().toString();
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

            jsonObj.put("h_hd11", h_hd11);
            jsonObj.put("h_hd12", h_hd12);
            jsonObj.put("h_hd21", h_hd21);
            jsonObj.put("h_hd22", h_hd22);
            jsonObj.put("h_dd1", h_dd1);
            jsonObj.put("h_dd2", h_dd2);
            jsonObj.put("h_he1", h_he1);
            jsonObj.put("h_he2", h_he2);
            jsonObj.put("h_he3", h_he3);
            jsonObj.put("h_de", h_de);
            jsonObj.put("h_mx1", h_mx1);
            jsonObj.put("h_mx2", h_mx2);

            jsonObj.put("g_hd11", g_hd11);
            jsonObj.put("g_hd12", g_hd12);
            jsonObj.put("g_hd21", g_hd21);
            jsonObj.put("g_hd22", g_hd22);
            jsonObj.put("g_dd1", g_dd1);
            jsonObj.put("g_dd2", g_dd2);
            jsonObj.put("g_he1", g_he1);
            jsonObj.put("g_he2", g_he2);
            jsonObj.put("g_he3", g_he3);
            jsonObj.put("g_de", g_de);
            jsonObj.put("g_mx1", g_mx1);
            jsonObj.put("g_mx2", g_mx2);

            jsonObj.put("er_hd1_h1", er_hd1_h1);
            jsonObj.put("er_hd1_h2", er_hd1_h2);
            jsonObj.put("er_hd1_h3", er_hd1_h3);
            jsonObj.put("er_hd2_h1", er_hd2_h1);
            jsonObj.put("er_hd2_h2", er_hd2_h2);
            jsonObj.put("er_hd2_h3", er_hd2_h3);
            jsonObj.put("er_dd_h1", er_dd_h1);
            jsonObj.put("er_dd_h2", er_dd_h2);
            jsonObj.put("er_dd_h3", er_dd_h3);
            jsonObj.put("er_he1_h1", er_he1_h1);
            jsonObj.put("er_he1_h2", er_he1_h2);
            jsonObj.put("er_he1_h3", er_he1_h3);
            jsonObj.put("er_he2_h1", er_he2_h1);
            jsonObj.put("er_he2_h2", er_he2_h2);
            jsonObj.put("er_he2_h3", er_he2_h3);
            jsonObj.put("er_he3_h1", er_he3_h1);
            jsonObj.put("er_he3_h2", er_he3_h2);
            jsonObj.put("er_he3_h3", er_he3_h3);
            jsonObj.put("er_de_h1", er_de_h1);
            jsonObj.put("er_de_h2", er_de_h2);
            jsonObj.put("er_de_h3", er_de_h3);
            jsonObj.put("er_mx_h1", er_mx_h1);
            jsonObj.put("er_mx_h2", er_mx_h2);
            jsonObj.put("er_mx_h3", er_mx_h3);

            jsonObj.put("er_hd1_g1", er_hd1_g1);
            jsonObj.put("er_hd1_g2", er_hd1_g2);
            jsonObj.put("er_hd1_g3", er_hd1_g3);
            jsonObj.put("er_hd2_g1", er_hd2_g1);
            jsonObj.put("er_hd2_g2", er_hd2_g2);
            jsonObj.put("er_hd2_g3", er_hd2_g3);
            jsonObj.put("er_dd_g1", er_dd_g1);
            jsonObj.put("er_dd_g2", er_dd_g2);
            jsonObj.put("er_dd_g3", er_dd_g3);
            jsonObj.put("er_he1_g1", er_he1_g1);
            jsonObj.put("er_he1_g2", er_he1_g2);
            jsonObj.put("er_he1_g3", er_he1_g3);
            jsonObj.put("er_he2_g1", er_he2_g1);
            jsonObj.put("er_he2_g2", er_he2_g2);
            jsonObj.put("er_he2_g3", er_he2_g3);
            jsonObj.put("er_he3_g1", er_he3_g1);
            jsonObj.put("er_he3_g2", er_he3_g2);
            jsonObj.put("er_he3_g3", er_he3_g3);
            jsonObj.put("er_de_g1", er_de_g1);
            jsonObj.put("er_de_g2", er_de_g2);
            jsonObj.put("er_de_g3", er_de_g3);
            jsonObj.put("er_mx_g1", er_mx_g1);
            jsonObj.put("er_mx_g2", er_mx_g2);
            jsonObj.put("er_mx_g3", er_mx_g3);

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

                h_hd11 = get_string_from_json(jsonObj,"h_hd11");
                h_hd12 = get_string_from_json(jsonObj,"h_hd12");
                h_hd21 = get_string_from_json(jsonObj,"h_hd21");
                h_hd22 = get_string_from_json(jsonObj,"h_hd22");
                h_dd1 = get_string_from_json(jsonObj,"h_dd1");
                h_dd2 = get_string_from_json(jsonObj,"h_dd2");
                h_he1 = get_string_from_json(jsonObj,"h_he1");
                h_he2 = get_string_from_json(jsonObj,"h_he2");
                h_he3 = get_string_from_json(jsonObj,"h_he3");
                h_de = get_string_from_json(jsonObj,"h_de");
                h_mx1 = get_string_from_json(jsonObj,"h_mx1");
                h_mx2 = get_string_from_json(jsonObj,"h_mx2");

                g_hd11 = get_string_from_json(jsonObj,"g_hd11");
                g_hd12 = get_string_from_json(jsonObj,"g_hd12");
                g_hd21 = get_string_from_json(jsonObj,"g_hd21");
                g_hd22 = get_string_from_json(jsonObj,"g_hd22");
                g_dd1 = get_string_from_json(jsonObj,"g_dd1");
                g_dd2 = get_string_from_json(jsonObj,"g_dd2");
                g_he1 = get_string_from_json(jsonObj,"g_he1");
                g_he2 = get_string_from_json(jsonObj,"g_he2");
                g_he3 = get_string_from_json(jsonObj,"g_he3");
                g_de = get_string_from_json(jsonObj,"g_de");
                g_mx1 = get_string_from_json(jsonObj,"g_mx1");
                g_mx2 = get_string_from_json(jsonObj,"g_mx2");

                er_hd1_h1 = get_string_from_json(jsonObj,"er_hd1_h1");
                er_hd1_h2 = get_string_from_json(jsonObj,"er_hd1_h2");
                er_hd1_h3 = get_string_from_json(jsonObj,"er_hd1_h3");
                er_hd2_h1 = get_string_from_json(jsonObj,"er_hd2_h1");
                er_hd2_h2 = get_string_from_json(jsonObj,"er_hd2_h2");
                er_hd2_h3 = get_string_from_json(jsonObj,"er_hd2_h3");
                er_dd_h1 = get_string_from_json(jsonObj,"er_dd_h1");
                er_dd_h2 = get_string_from_json(jsonObj,"er_dd_h2");
                er_dd_h3 = get_string_from_json(jsonObj,"er_dd_h3");
                er_he1_h1 = get_string_from_json(jsonObj,"er_he1_h1");
                er_he1_h2 = get_string_from_json(jsonObj,"er_he1_h2");
                er_he1_h3 = get_string_from_json(jsonObj,"er_he1_h3");
                er_he2_h1 = get_string_from_json(jsonObj,"er_he2_h1");
                er_he2_h2 = get_string_from_json(jsonObj,"er_he2_h2");
                er_he2_h3 = get_string_from_json(jsonObj,"er_he2_h3");
                er_he3_h1 = get_string_from_json(jsonObj,"er_he3_h1");
                er_he3_h2 = get_string_from_json(jsonObj,"er_he3_h2");
                er_he3_h3 = get_string_from_json(jsonObj,"er_he3_h3");
                er_de_h1 = get_string_from_json(jsonObj,"er_de_h1");
                er_de_h2 = get_string_from_json(jsonObj,"er_de_h2");
                er_de_h3 = get_string_from_json(jsonObj,"er_de_h3");
                er_mx_h1 = get_string_from_json(jsonObj,"er_mx_h1");
                er_mx_h2 = get_string_from_json(jsonObj,"er_mx_h2");
                er_mx_h3 = get_string_from_json(jsonObj,"er_mx_h3");

                er_hd1_g1 = get_string_from_json(jsonObj,"er_hd1_g1");
                er_hd1_g2 = get_string_from_json(jsonObj,"er_hd1_g2");
                er_hd1_g3 = get_string_from_json(jsonObj,"er_hd1_g3");
                er_hd2_g1 = get_string_from_json(jsonObj,"er_hd2_g1");
                er_hd2_g2 = get_string_from_json(jsonObj,"er_hd2_g2");
                er_hd2_g3 = get_string_from_json(jsonObj,"er_hd2_g3");
                er_dd_g1 = get_string_from_json(jsonObj,"er_dd_g1");
                er_dd_g2 = get_string_from_json(jsonObj,"er_dd_g2");
                er_dd_g3 = get_string_from_json(jsonObj,"er_dd_g3");
                er_he1_g1 = get_string_from_json(jsonObj,"er_he1_g1");
                er_he1_g2 = get_string_from_json(jsonObj,"er_he1_g2");
                er_he1_g3 = get_string_from_json(jsonObj,"er_he1_g3");
                er_he2_g1 = get_string_from_json(jsonObj,"er_he2_g1");
                er_he2_g2 = get_string_from_json(jsonObj,"er_he2_g2");
                er_he2_g3 = get_string_from_json(jsonObj,"er_he2_g3");
                er_he3_g1 = get_string_from_json(jsonObj,"er_he3_g1");
                er_he3_g2 = get_string_from_json(jsonObj,"er_he3_g2");
                er_he3_g3 = get_string_from_json(jsonObj,"er_he3_g3");
                er_de_g1 = get_string_from_json(jsonObj,"er_de_g1");
                er_de_g2 = get_string_from_json(jsonObj,"er_de_g2");
                er_de_g3 = get_string_from_json(jsonObj,"er_de_g3");
                er_mx_g1 = get_string_from_json(jsonObj,"er_mx_g1");
                er_mx_g2 = get_string_from_json(jsonObj,"er_mx_g2");
                er_mx_g3 = get_string_from_json(jsonObj,"er_mx_g3");

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
        final List<String> listitem = Arrays.asList(cs);
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
