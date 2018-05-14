package de.tv1875paderborn.malte.badmintonspielbogen;

import android.os.Environment;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPage;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

// Alle Variablen importieren
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.heimverein;
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.gastverein;
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.staffel;
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.ort;
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.zeit;

// Spielernamen
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.h_hd11;
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.h_hd12;
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.h_hd21;
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.h_hd22;
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.h_dd1;
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.h_dd2;
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.h_he1;
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.h_he2;
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.h_he3;
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.h_de;
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.h_mx1;
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.h_mx2;

import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.g_hd11;
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.g_hd12;
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.g_hd21;
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.g_hd22;
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.g_dd1;
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.g_dd2;
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.g_he1;
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.g_he2;
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.g_he3;
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.g_de;
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.g_mx1;
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.g_mx2;

// Ergebnisse
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_hd1_h1;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_hd1_h2;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_hd1_h3;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_hd1_g1;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_hd1_g2;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_hd1_g3;

import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_hd2_h1;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_hd2_h2;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_hd2_h3;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_hd2_g1;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_hd2_g2;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_hd2_g3;

import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_dd_h1;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_dd_h2;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_dd_h3;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_dd_g1;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_dd_g2;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_dd_g3;

import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_he1_h1;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_he1_h2;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_he1_h3;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_he1_g1;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_he1_g2;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_he1_g3;

import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_he2_h1;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_he2_h2;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_he2_h3;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_he2_g1;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_he2_g2;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_he2_g3;

import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_he3_h1;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_he3_h2;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_he3_h3;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_he3_g1;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_he3_g2;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_he3_g3;

import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_de_h1;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_de_h2;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_de_h3;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_de_g1;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_de_g2;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_de_g3;

import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_mx_h1;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_mx_h2;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_mx_h3;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_mx_g1;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_mx_g2;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_mx_g3;

public class create_pdf {

    private static String hd1_1, hd1_2, hd1_3;
    private static int pkt_hd1_h, pkt_hd1_g;
    private static int set_hd1_h, set_hd1_g;
    private static int game_hd1_h, game_hd1_g;
    private static String hd2_1, hd2_2, hd2_3;
    private static int pkt_hd2_h, pkt_hd2_g;
    private static int set_hd2_h, set_hd2_g;
    private static int game_hd2_h, game_hd2_g;
    private static String dd_1, dd_2, dd_3;
    private static int pkt_dd_h, pkt_dd_g;
    private static int set_dd_h, set_dd_g;
    private static int game_dd_h, game_dd_g;
    private static String he1_1, he1_2, he1_3;
    private static int pkt_he1_h, pkt_he1_g;
    private static int set_he1_h, set_he1_g;
    private static int game_he1_h, game_he1_g;
    private static String he2_1, he2_2, he2_3;
    private static int pkt_he2_h, pkt_he2_g;
    private static int set_he2_h, set_he2_g;
    private static int game_he2_h, game_he2_g;
    private static String he3_1, he3_2, he3_3;
    private static int pkt_he3_h, pkt_he3_g;
    private static int set_he3_h, set_he3_g;
    private static int game_he3_h, game_he3_g;
    private static String de_1, de_2, de_3;
    private static int pkt_de_h, pkt_de_g;
    private static int set_de_h, set_de_g;
    private static int game_de_h, game_de_g;
    private static String mx_1, mx_2, mx_3;
    private static int pkt_mx_h, pkt_mx_g;
    private static int set_mx_h, set_mx_g;
    private static int game_mx_h, game_mx_g;

    private static int pkt_sum_h, pkt_sum_g;
    private static int set_sum_h, set_sum_g;
    private static int game_sum_h, game_sum_g;

    private static String winner;

    public static void main() {
        String root = Environment.getExternalStorageDirectory().toString();

        get_scores();

        // the directory where the signature will be saved
        File file = new File(root + "/badmintonspielbogen/Spielberichtsbogen.pdf");

        Document document = new Document(PageSize.A4.rotate());

        try {
            PdfWriter.getInstance(document, new FileOutputStream(file));
            Date datum = Calendar.getInstance().getTime();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.GERMANY);
            String date = simpleDateFormat.format(datum);

            document.open();

            // überschrift und zentrales
            document.add(new Paragraph(heimverein + " : " + gastverein));
            document.add(new Paragraph("Staffel: " + staffel + "     Austragungsort: " + ort + "     Spielbeginn:" + zeit + "     Datum: " + date));

            // Tabelle
            // 1. Zeile
            PdfPTable table = new PdfPTable(12);

            PdfPCell cell1 = new PdfPCell(new Paragraph(""));
            PdfPCell cell2 = new PdfPCell(new Paragraph(heimverein));
            PdfPCell cell3 = new PdfPCell(new Paragraph(gastverein));
            PdfPCell cell4 = new PdfPCell(new Paragraph("1. Satz"));
            PdfPCell cell5 = new PdfPCell(new Paragraph("2. Satz"));
            PdfPCell cell6 = new PdfPCell(new Paragraph("3. Satz"));
            PdfPCell cell7 = new PdfPCell(new Paragraph("Punkte\nHeim"));
            PdfPCell cell8 = new PdfPCell(new Paragraph("Punkte\nGast"));
            PdfPCell cell9 = new PdfPCell(new Paragraph("Sätze\nHeim"));
            PdfPCell cell10 = new PdfPCell(new Paragraph("Sätze\nGast"));
            PdfPCell cell11 = new PdfPCell(new Paragraph("Spiele\nHeim"));
            PdfPCell cell12 = new PdfPCell(new Paragraph("Spiele\nGast"));

            cell1.setFixedHeight(30);
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell6.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell7.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell8.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell8.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell9.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell9.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell10.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell10.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell11.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell12.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            table.addCell(cell1);
            table.addCell(cell2);
            table.addCell(cell3);
            table.addCell(cell4);
            table.addCell(cell5);
            table.addCell(cell6);
            table.addCell(cell7);
            table.addCell(cell8);
            table.addCell(cell9);
            table.addCell(cell10);
            table.addCell(cell11);
            table.addCell(cell12);

            // 2. Zeile
            cell1 = new PdfPCell(new Paragraph("1. HD"));
            cell2 = new PdfPCell(new Paragraph(h_hd11 + "\n" + h_hd12));
            cell3 = new PdfPCell(new Paragraph(g_hd11 + "\n" + g_hd12));
            cell4 = new PdfPCell(new Paragraph(hd1_1));
            cell5 = new PdfPCell(new Paragraph(hd1_2));
            cell6 = new PdfPCell(new Paragraph(hd1_3));
            cell7 = new PdfPCell(new Paragraph(Integer.toString(pkt_hd1_h)));
            cell8 = new PdfPCell(new Paragraph(Integer.toString(pkt_hd1_g)));
            cell9 = new PdfPCell(new Paragraph(Integer.toString(set_hd1_h)));
            cell10 = new PdfPCell(new Paragraph(Integer.toString(set_hd1_g)));
            cell11 = new PdfPCell(new Paragraph(Integer.toString(game_hd1_h)));
            cell12 = new PdfPCell(new Paragraph(Integer.toString(game_hd1_g)));

            cell1.setFixedHeight(30);
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell6.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell7.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell8.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell8.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell9.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell9.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell10.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell10.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell11.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell12.setVerticalAlignment(Element.ALIGN_MIDDLE);

            table.addCell(cell1);
            table.addCell(cell2);
            table.addCell(cell3);
            table.addCell(cell4);
            table.addCell(cell5);
            table.addCell(cell6);
            table.addCell(cell7);
            table.addCell(cell8);
            table.addCell(cell9);
            table.addCell(cell10);
            table.addCell(cell11);
            table.addCell(cell12);

            // 3. Zeile
            cell1 = new PdfPCell(new Paragraph("2. HD"));
            cell2 = new PdfPCell(new Paragraph(h_hd21 + "\n" + h_hd22));
            cell3 = new PdfPCell(new Paragraph(g_hd21 + "\n" + g_hd22));
            cell4 = new PdfPCell(new Paragraph(hd2_1));
            cell5 = new PdfPCell(new Paragraph(hd2_2));
            cell6 = new PdfPCell(new Paragraph(hd2_3));
            cell7 = new PdfPCell(new Paragraph(Integer.toString(pkt_hd2_h)));
            cell8 = new PdfPCell(new Paragraph(Integer.toString(pkt_hd2_g)));
            cell9 = new PdfPCell(new Paragraph(Integer.toString(set_hd2_h)));
            cell10 = new PdfPCell(new Paragraph(Integer.toString(set_hd2_g)));
            cell11 = new PdfPCell(new Paragraph(Integer.toString(game_hd2_h)));
            cell12 = new PdfPCell(new Paragraph(Integer.toString(game_hd2_g)));

            cell1.setFixedHeight(30);
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell6.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell7.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell8.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell8.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell9.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell9.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell10.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell10.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell11.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell12.setVerticalAlignment(Element.ALIGN_MIDDLE);

            table.addCell(cell1);
            table.addCell(cell2);
            table.addCell(cell3);
            table.addCell(cell4);
            table.addCell(cell5);
            table.addCell(cell6);
            table.addCell(cell7);
            table.addCell(cell8);
            table.addCell(cell9);
            table.addCell(cell10);
            table.addCell(cell11);
            table.addCell(cell12);

            // 4. Zeile
            cell1 = new PdfPCell(new Paragraph("DD"));
            cell2 = new PdfPCell(new Paragraph(h_dd1 + "\n" + h_dd2));
            cell3 = new PdfPCell(new Paragraph(g_dd1 + "\n" + g_dd2));
            cell4 = new PdfPCell(new Paragraph(dd_1));
            cell5 = new PdfPCell(new Paragraph(dd_2));
            cell6 = new PdfPCell(new Paragraph(dd_3));
            cell7 = new PdfPCell(new Paragraph(Integer.toString(pkt_dd_h)));
            cell8 = new PdfPCell(new Paragraph(Integer.toString(pkt_dd_g)));
            cell9 = new PdfPCell(new Paragraph(Integer.toString(set_dd_h)));
            cell10 = new PdfPCell(new Paragraph(Integer.toString(set_dd_g)));
            cell11 = new PdfPCell(new Paragraph(Integer.toString(game_dd_h)));
            cell12 = new PdfPCell(new Paragraph(Integer.toString(game_dd_g)));

            cell1.setFixedHeight(30);
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell6.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell7.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell8.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell8.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell9.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell9.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell10.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell10.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell11.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell12.setVerticalAlignment(Element.ALIGN_MIDDLE);

            table.addCell(cell1);
            table.addCell(cell2);
            table.addCell(cell3);
            table.addCell(cell4);
            table.addCell(cell5);
            table.addCell(cell6);
            table.addCell(cell7);
            table.addCell(cell8);
            table.addCell(cell9);
            table.addCell(cell10);
            table.addCell(cell11);
            table.addCell(cell12);

            // 5. Zeile
            cell1 = new PdfPCell(new Paragraph("1. HE"));
            cell2 = new PdfPCell(new Paragraph(h_he1));
            cell3 = new PdfPCell(new Paragraph(g_he1));
            cell4 = new PdfPCell(new Paragraph(he1_1));
            cell5 = new PdfPCell(new Paragraph(he1_2));
            cell6 = new PdfPCell(new Paragraph(he1_3));
            cell7 = new PdfPCell(new Paragraph(Integer.toString(pkt_he1_h)));
            cell8 = new PdfPCell(new Paragraph(Integer.toString(pkt_he1_g)));
            cell9 = new PdfPCell(new Paragraph(Integer.toString(set_he1_h)));
            cell10 = new PdfPCell(new Paragraph(Integer.toString(set_he1_g)));
            cell11 = new PdfPCell(new Paragraph(Integer.toString(game_he1_h)));
            cell12 = new PdfPCell(new Paragraph(Integer.toString(game_he1_g)));

            cell1.setFixedHeight(30);
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell6.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell7.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell8.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell8.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell9.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell9.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell10.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell10.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell11.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell12.setVerticalAlignment(Element.ALIGN_MIDDLE);

            table.addCell(cell1);
            table.addCell(cell2);
            table.addCell(cell3);
            table.addCell(cell4);
            table.addCell(cell5);
            table.addCell(cell6);
            table.addCell(cell7);
            table.addCell(cell8);
            table.addCell(cell9);
            table.addCell(cell10);
            table.addCell(cell11);
            table.addCell(cell12);

            // 6. Zeile
            cell1 = new PdfPCell(new Paragraph("2. HE"));
            cell2 = new PdfPCell(new Paragraph(h_he2));
            cell3 = new PdfPCell(new Paragraph(g_he2));
            cell4 = new PdfPCell(new Paragraph(he2_1));
            cell5 = new PdfPCell(new Paragraph(he2_2));
            cell6 = new PdfPCell(new Paragraph(he2_3));
            cell7 = new PdfPCell(new Paragraph(Integer.toString(pkt_he2_h)));
            cell8 = new PdfPCell(new Paragraph(Integer.toString(pkt_he2_g)));
            cell9 = new PdfPCell(new Paragraph(Integer.toString(set_he2_h)));
            cell10 = new PdfPCell(new Paragraph(Integer.toString(set_he2_g)));
            cell11 = new PdfPCell(new Paragraph(Integer.toString(game_he2_h)));
            cell12 = new PdfPCell(new Paragraph(Integer.toString(game_he2_g)));

            cell1.setFixedHeight(30);
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell6.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell7.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell8.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell8.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell9.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell9.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell10.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell10.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell11.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell12.setVerticalAlignment(Element.ALIGN_MIDDLE);

            table.addCell(cell1);
            table.addCell(cell2);
            table.addCell(cell3);
            table.addCell(cell4);
            table.addCell(cell5);
            table.addCell(cell6);
            table.addCell(cell7);
            table.addCell(cell8);
            table.addCell(cell9);
            table.addCell(cell10);
            table.addCell(cell11);
            table.addCell(cell12);

            // 7. Zeile
            cell1 = new PdfPCell(new Paragraph("3. HE"));
            cell2 = new PdfPCell(new Paragraph(h_he3));
            cell3 = new PdfPCell(new Paragraph(g_he3));
            cell4 = new PdfPCell(new Paragraph(he3_1));
            cell5 = new PdfPCell(new Paragraph(he3_2));
            cell6 = new PdfPCell(new Paragraph(he3_3));
            cell7 = new PdfPCell(new Paragraph(Integer.toString(pkt_he3_h)));
            cell8 = new PdfPCell(new Paragraph(Integer.toString(pkt_he3_g)));
            cell9 = new PdfPCell(new Paragraph(Integer.toString(set_he3_h)));
            cell10 = new PdfPCell(new Paragraph(Integer.toString(set_he3_g)));
            cell11 = new PdfPCell(new Paragraph(Integer.toString(game_he3_h)));
            cell12 = new PdfPCell(new Paragraph(Integer.toString(game_he3_g)));

            cell1.setFixedHeight(30);
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell6.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell7.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell8.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell8.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell9.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell9.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell10.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell10.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell11.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell12.setVerticalAlignment(Element.ALIGN_MIDDLE);

            table.addCell(cell1);
            table.addCell(cell2);
            table.addCell(cell3);
            table.addCell(cell4);
            table.addCell(cell5);
            table.addCell(cell6);
            table.addCell(cell7);
            table.addCell(cell8);
            table.addCell(cell9);
            table.addCell(cell10);
            table.addCell(cell11);
            table.addCell(cell12);

            // 8. Zeile
            cell1 = new PdfPCell(new Paragraph("DE"));
            cell2 = new PdfPCell(new Paragraph(h_de));
            cell3 = new PdfPCell(new Paragraph(g_de));
            cell4 = new PdfPCell(new Paragraph(de_1));
            cell5 = new PdfPCell(new Paragraph(de_2));
            cell6 = new PdfPCell(new Paragraph(de_3));
            cell7 = new PdfPCell(new Paragraph(Integer.toString(pkt_de_h)));
            cell8 = new PdfPCell(new Paragraph(Integer.toString(pkt_de_g)));
            cell9 = new PdfPCell(new Paragraph(Integer.toString(set_de_h)));
            cell10 = new PdfPCell(new Paragraph(Integer.toString(set_de_g)));
            cell11 = new PdfPCell(new Paragraph(Integer.toString(game_de_h)));
            cell12 = new PdfPCell(new Paragraph(Integer.toString(game_de_g)));

            cell1.setFixedHeight(30);
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell6.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell7.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell8.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell8.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell9.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell9.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell10.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell10.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell11.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell12.setVerticalAlignment(Element.ALIGN_MIDDLE);

            table.addCell(cell1);
            table.addCell(cell2);
            table.addCell(cell3);
            table.addCell(cell4);
            table.addCell(cell5);
            table.addCell(cell6);
            table.addCell(cell7);
            table.addCell(cell8);
            table.addCell(cell9);
            table.addCell(cell10);
            table.addCell(cell11);
            table.addCell(cell12);

            // 9. Zeile
            cell1 = new PdfPCell(new Paragraph("MX"));
            cell2 = new PdfPCell(new Paragraph(h_mx1 + "\n" + h_mx2));
            cell3 = new PdfPCell(new Paragraph(g_mx1 + "\n" + g_mx2));
            cell4 = new PdfPCell(new Paragraph(mx_1));
            cell5 = new PdfPCell(new Paragraph(mx_2));
            cell6 = new PdfPCell(new Paragraph(mx_3));
            cell7 = new PdfPCell(new Paragraph(Integer.toString(pkt_mx_h)));
            cell8 = new PdfPCell(new Paragraph(Integer.toString(pkt_mx_g)));
            cell9 = new PdfPCell(new Paragraph(Integer.toString(set_mx_h)));
            cell10 = new PdfPCell(new Paragraph(Integer.toString(set_mx_g)));
            cell11 = new PdfPCell(new Paragraph(Integer.toString(game_mx_h)));
            cell12 = new PdfPCell(new Paragraph(Integer.toString(game_mx_g)));

            cell1.setFixedHeight(30);
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell6.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell7.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell8.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell8.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell9.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell9.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell10.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell10.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell11.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell12.setVerticalAlignment(Element.ALIGN_MIDDLE);

            table.addCell(cell1);
            table.addCell(cell2);
            table.addCell(cell3);
            table.addCell(cell4);
            table.addCell(cell5);
            table.addCell(cell6);
            table.addCell(cell7);
            table.addCell(cell8);
            table.addCell(cell9);
            table.addCell(cell10);
            table.addCell(cell11);
            table.addCell(cell12);

            // 10. Zeile
            cell1 = new PdfPCell(new Paragraph(""));
            cell2 = new PdfPCell(new Paragraph(""));
            cell3 = new PdfPCell(new Paragraph(""));
            cell4 = new PdfPCell(new Paragraph(""));
            cell5 = new PdfPCell(new Paragraph(""));
            cell6 = new PdfPCell(new Paragraph("Summe:"));
            cell7 = new PdfPCell(new Paragraph(Integer.toString(pkt_sum_h)));
            cell8 = new PdfPCell(new Paragraph(Integer.toString(pkt_sum_g)));
            cell9 = new PdfPCell(new Paragraph(Integer.toString(set_sum_h)));
            cell10 = new PdfPCell(new Paragraph(Integer.toString(set_sum_g)));
            cell11 = new PdfPCell(new Paragraph(Integer.toString(game_sum_h)));
            cell12 = new PdfPCell(new Paragraph(Integer.toString(game_sum_g)));

            cell1.setFixedHeight(30);
            cell1.setBorderWidthLeft(0);
            cell1.setBorderWidthBottom(0);
            cell1.setBorderWidthRight(0);
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell2.setBorderWidthLeft(0);
            cell2.setBorderWidthBottom(0);
            cell2.setBorderWidthRight(0);
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell3.setBorderWidthLeft(0);
            cell3.setBorderWidthBottom(0);
            cell3.setBorderWidthRight(0);
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell4.setBorderWidthLeft(0);
            cell4.setBorderWidthBottom(0);
            cell4.setBorderWidthRight(0);
            cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell5.setBorderWidthLeft(0);
            cell5.setBorderWidthBottom(0);
            cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell6.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell7.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell8.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell8.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell9.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell9.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell10.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell10.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell11.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell12.setVerticalAlignment(Element.ALIGN_MIDDLE);

            table.addCell(cell1);
            table.addCell(cell2);
            table.addCell(cell3);
            table.addCell(cell4);
            table.addCell(cell5);
            table.addCell(cell6);
            table.addCell(cell7);
            table.addCell(cell8);
            table.addCell(cell9);
            table.addCell(cell10);
            table.addCell(cell11);
            table.addCell(cell12);

            table.setWidthPercentage(100);
            table.setSpacingBefore(20f);
            float[] columnWidths = {1f, 5f, 5f, 3f, 3f, 3f, 2f, 2f, 2f, 2f, 2f, 2f};
            table.setWidths(columnWidths);

            document.add(table);

            document.add(new Paragraph("Gewinner: " + winner));
            document.add( Chunk.NEWLINE );

            try {
                Image sign_heim = Image.getInstance(root + "/badmintonspielbogen/unterschriften/sign_heim.png");
                Image sign_gast = Image.getInstance(root + "/badmintonspielbogen/unterschriften/sign_gast.png");

                sign_heim.scaleToFit(180f, 360f);
                sign_gast.scaleToFit(180f, 360f);

                table = new PdfPTable(2);
                cell1 = new PdfPCell(new Paragraph("Mannschaftsführer Heimverein:"));
                cell1.setBorderWidth(0);
                cell2 = new PdfPCell(new Paragraph("Mannschaftsführer Gastverein:"));
                cell2.setBorderWidth(0);

                table.addCell(cell1);
                table.addCell(cell2);

                cell1 = new PdfPCell(sign_heim, false);
                cell1.setBorderWidth(0);
                cell2 = new PdfPCell(sign_gast, false);
                cell2.setBorderWidth(0);

                table.addCell(cell1);
                table.addCell(cell2);

                document.add(table);

                document.close(); // no need to close PDFwriter?
            }catch (MalformedURLException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    private static void get_scores() {
        boolean set1, set2, set3;

        int hd1_h1 = Integer.parseInt(er_hd1_h1);
        int hd1_h2 = Integer.parseInt(er_hd1_h2);
        int hd1_h3 = Integer.parseInt(er_hd1_h3);
        int hd1_g1 = Integer.parseInt(er_hd1_g1);
        int hd1_g2 = Integer.parseInt(er_hd1_g2);
        int hd1_g3 = Integer.parseInt(er_hd1_g3);

        hd1_1 = er_hd1_h1 + " - " + er_hd1_g1;
        hd1_2 = er_hd1_h2 + " - " + er_hd1_g2;

        if (hd1_h3 == hd1_g3){
            hd1_3 = "-";
        }else {
            hd1_3 = er_hd1_h3 + " - " + er_hd1_g3;
        }
        pkt_hd1_h = hd1_h1 + hd1_h2 + hd1_h3;
        pkt_hd1_g = hd1_g1 + hd1_g2 + hd1_g3;

        // true = Heim gewinnt
        set1 = hd1_h1 > hd1_g1;
        set2 = hd1_h2 > hd1_g2;
        set3 = hd1_h3 > hd1_g3;
        if (hd1_h3 == hd1_g3) {
            if (set1) {
                set_hd1_h = 2;
                set_hd1_g = 0;
                game_hd1_h = 1;
                game_hd1_g = 0;
            } else {
                set_hd1_h = 0;
                set_hd1_g = 2;
                game_hd1_h = 0;
                game_hd1_g = 1;
            }
        } else {
            if (set3) {
                set_hd1_h = 2;
                set_hd1_g = 1;
                game_hd1_h = 1;
                game_hd1_g = 0;
            } else {
                set_hd1_h = 1;
                set_hd1_g = 2;
                game_hd1_h = 0;
                game_hd1_g = 1;
            }
        }

        int hd2_h1 = Integer.parseInt(er_hd2_h1);
        int hd2_h2 = Integer.parseInt(er_hd2_h2);
        int hd2_h3 = Integer.parseInt(er_hd2_h3);
        int hd2_g1 = Integer.parseInt(er_hd2_g1);
        int hd2_g2 = Integer.parseInt(er_hd2_g2);
        int hd2_g3 = Integer.parseInt(er_hd2_g3);

        hd2_1 = er_hd2_h1 + " - " + er_hd2_g1;
        hd2_2 = er_hd2_h2 + " - " + er_hd2_g2;
        if (hd2_h3 == hd2_g3){
            hd2_3 = "-";
        }else {
            hd2_3 = er_hd2_h3 + " - " + er_hd2_g3;
        }

        pkt_hd2_h = hd2_h1 + hd2_h2 + hd2_h3;
        pkt_hd2_g = hd2_g1 + hd2_g2 + hd2_g3;

        // true = Heim gewinnt
        set1 = hd2_h1 > hd2_g1;
        set2 = hd2_h2 > hd2_g2;
        set3 = hd2_h3 > hd2_g3;
        if (hd2_h3 == hd2_g3) {
            if (set1) {
                set_hd2_h = 2;
                set_hd2_g = 0;
                game_hd2_h = 1;
                game_hd2_g = 0;
            } else {
                set_hd2_h = 0;
                set_hd2_g = 2;
                game_hd2_h = 0;
                game_hd2_g = 1;
            }
        } else {
            if (set3) {
                set_hd2_h = 2;
                set_hd2_g = 1;
                game_hd2_h = 1;
                game_hd2_g = 0;
            } else {
                set_hd2_h = 1;
                set_hd2_g = 2;
                game_hd2_h = 0;
                game_hd2_g = 1;
            }
        }

        int dd_h1 = Integer.parseInt(er_dd_h1);
        int dd_h2 = Integer.parseInt(er_dd_h2);
        int dd_h3 = Integer.parseInt(er_dd_h3);
        int dd_g1 = Integer.parseInt(er_dd_g1);
        int dd_g2 = Integer.parseInt(er_dd_g2);
        int dd_g3 = Integer.parseInt(er_dd_g3);

        dd_1 = er_dd_h1 + " - " + er_dd_g1;
        dd_2 = er_dd_h2 + " - " + er_dd_g2;
        if (dd_h3 == dd_g3){
            dd_3 = "-";
        }else {
            dd_3 = er_dd_h3 + " - " + er_dd_g3;
        }

        pkt_dd_h = dd_h1 + dd_h2 + dd_h3;
        pkt_dd_g = dd_g1 + dd_g2 + dd_g3;

        // true = Heim gewinnt
        set1 = dd_h1 > dd_g1;
        set2 = dd_h2 > dd_g2;
        set3 = dd_h3 > dd_g3;
        if (dd_h3 == dd_g3) {
            if (set1) {
                set_dd_h = 2;
                set_dd_g = 0;
                game_dd_h = 1;
                game_dd_g = 0;
            } else {
                set_dd_h = 0;
                set_dd_g = 2;
                game_dd_h = 0;
                game_dd_g = 1;
            }
        } else {
            if (set3) {
                set_dd_h = 2;
                set_dd_g = 1;
                game_dd_h = 1;
                game_dd_g = 0;
            } else {
                set_dd_h = 1;
                set_dd_g = 2;
                game_dd_h = 0;
                game_dd_g = 1;
            }
        }

        int he1_h1 = Integer.parseInt(er_he1_h1);
        int he1_h2 = Integer.parseInt(er_he1_h2);
        int he1_h3 = Integer.parseInt(er_he1_h3);
        int he1_g1 = Integer.parseInt(er_he1_g1);
        int he1_g2 = Integer.parseInt(er_he1_g2);
        int he1_g3 = Integer.parseInt(er_he1_g3);

        he1_1 = er_he1_h1 + " - " + er_he1_g1;
        he1_2 = er_he1_h2 + " - " + er_he1_g2;
        if (he1_h3 == he1_g3){
            he1_3 = "-";
        }else {
            he1_3 = er_he1_h3 + " - " + er_he1_g3;
        }

        pkt_he1_h = he1_h1 + he1_h2 + he1_h3;
        pkt_he1_g = he1_g1 + he1_g2 + he1_g3;

        // true = Heim gewinnt
        set1 = he1_h1 > he1_g1;
        set2 = he1_h2 > he1_g2;
        set3 = he1_h3 > he1_g3;
        if (he1_h3 == he1_g3) {
            if (set1) {
                set_he1_h = 2;
                set_he1_g = 0;
                game_he1_h = 1;
                game_he1_g = 0;
            } else {
                set_he1_h = 0;
                set_he1_g = 2;
                game_he1_h = 0;
                game_he1_g = 1;
            }
        } else {
            if (set3) {
                set_he1_h = 2;
                set_he1_g = 1;
                game_he1_h = 1;
                game_he1_g = 0;
            } else {
                set_he1_h = 1;
                set_he1_g = 2;
                game_he1_h = 0;
                game_he1_g = 1;
            }
        }

        int he2_h1 = Integer.parseInt(er_he2_h1);
        int he2_h2 = Integer.parseInt(er_he2_h2);
        int he2_h3 = Integer.parseInt(er_he2_h3);
        int he2_g1 = Integer.parseInt(er_he2_g1);
        int he2_g2 = Integer.parseInt(er_he2_g2);
        int he2_g3 = Integer.parseInt(er_he2_g3);

        he2_1 = er_he2_h1 + " - " + er_he2_g1;
        he2_2 = er_he2_h2 + " - " + er_he2_g2;
        if (he2_h3 == he2_g3){
            he2_3 = "-";
        }else {
            he2_3 = er_he2_h3 + " - " + er_he2_g3;
        }

        pkt_he2_h = he2_h1 + he2_h2 + he2_h3;
        pkt_he2_g = he2_g1 + he2_g2 + he2_g3;

        // true = Heim gewinnt
        set1 = he2_h1 > he2_g1;
        set2 = he2_h2 > he2_g2;
        set3 = he2_h3 > he2_g3;
        if (he2_h3 == he2_g3) {
            if (set1) {
                set_he2_h = 2;
                set_he2_g = 0;
                game_he2_h = 1;
                game_he2_g = 0;
            } else {
                set_he2_h = 0;
                set_he2_g = 2;
                game_he2_h = 0;
                game_he2_g = 1;
            }
        } else {
            if (set3) {
                set_he2_h = 2;
                set_he2_g = 1;
                game_he2_h = 1;
                game_he2_g = 0;
            } else {
                set_he2_h = 1;
                set_he2_g = 2;
                game_he2_h = 0;
                game_he2_g = 1;
            }
        }

        int he3_h1 = Integer.parseInt(er_he3_h1);
        int he3_h2 = Integer.parseInt(er_he3_h2);
        int he3_h3 = Integer.parseInt(er_he3_h3);
        int he3_g1 = Integer.parseInt(er_he3_g1);
        int he3_g2 = Integer.parseInt(er_he3_g2);
        int he3_g3 = Integer.parseInt(er_he3_g3);

        he3_1 = er_he3_h1 + " - " + er_he3_g1;
        he3_2 = er_he3_h2 + " - " + er_he3_g2;
        if (he3_h3 == he3_g3){
            he3_3 = "-";
        }else {
            he3_3 = er_he3_h3 + " - " + er_he3_g3;
        }

        pkt_he3_h = he3_h1 + he3_h2 + he3_h3;
        pkt_he3_g = he3_g1 + he3_g2 + he3_g3;

        // true = Heim gewinnt
        set1 = he3_h1 > he3_g1;
        set2 = he3_h2 > he3_g2;
        set3 = he3_h3 > he3_g3;
        if (he3_h3 == he3_g3) {
            if (set1) {
                set_he3_h = 2;
                set_he3_g = 0;
                game_he3_h = 1;
                game_he3_g = 0;
            } else {
                set_he3_h = 0;
                set_he3_g = 2;
                game_he3_h = 0;
                game_he3_g = 1;
            }
        } else {
            if (set3) {
                set_he3_h = 2;
                set_he3_g = 1;
                game_he3_h = 1;
                game_he3_g = 0;
            } else {
                set_he3_h = 1;
                set_he3_g = 2;
                game_he3_h = 0;
                game_he3_g = 1;
            }
        }

        int de_h1 = Integer.parseInt(er_de_h1);
        int de_h2 = Integer.parseInt(er_de_h2);
        int de_h3 = Integer.parseInt(er_de_h3);
        int de_g1 = Integer.parseInt(er_de_g1);
        int de_g2 = Integer.parseInt(er_de_g2);
        int de_g3 = Integer.parseInt(er_de_g3);

        de_1 = er_de_h1 + " - " + er_de_g1;
        de_2 = er_de_h2 + " - " + er_de_g2;
        if (de_h3 == de_g3){
            de_3 = "-";
        }else {
            de_3 = er_de_h3 + " - " + er_de_g3;
        }

        pkt_de_h = de_h1 + de_h2 + de_h3;
        pkt_de_g = de_g1 + de_g2 + de_g3;

        // true = Heim gewinnt
        set1 = de_h1 > de_g1;
        set2 = de_h2 > de_g2;
        set3 = de_h3 > de_g3;
        if (de_h3 == de_g3) {
            if (set1) {
                set_de_h = 2;
                set_de_g = 0;
                game_de_h = 1;
                game_de_g = 0;
            } else {
                set_de_h = 0;
                set_de_g = 2;
                game_de_h = 0;
                game_de_g = 1;
            }
        } else {
            if (set3) {
                set_de_h = 2;
                set_de_g = 1;
                game_de_h = 1;
                game_de_g = 0;
            } else {
                set_de_h = 1;
                set_de_g = 2;
                game_de_h = 0;
                game_de_g = 1;
            }
        }

        int mx_h1 = Integer.parseInt(er_mx_h1);
        int mx_h2 = Integer.parseInt(er_mx_h2);
        int mx_h3 = Integer.parseInt(er_mx_h3);
        int mx_g1 = Integer.parseInt(er_mx_g1);
        int mx_g2 = Integer.parseInt(er_mx_g2);
        int mx_g3 = Integer.parseInt(er_mx_g3);

        mx_1 = er_mx_h1 + " - " + er_mx_g1;
        mx_2 = er_mx_h2 + " - " + er_mx_g2;
        if (mx_h3 == mx_g3){
            mx_3 = "-";
        }else {
            mx_3 = er_mx_h3 + " - " + er_mx_g3;
        }

        pkt_mx_h = mx_h1 + mx_h2 + mx_h3;
        pkt_mx_g = mx_g1 + mx_g2 + mx_g3;

        // true = Heim gewinnt
        set1 = mx_h1 > mx_g1;
        set2 = mx_h2 > mx_g2;
        set3 = mx_h3 > mx_g3;
        if (mx_h3 == mx_g3) {
            if (set1) {
                set_mx_h = 2;
                set_mx_g = 0;
                game_mx_h = 1;
                game_mx_g = 0;
            } else {
                set_mx_h = 0;
                set_mx_g = 2;
                game_mx_h = 0;
                game_mx_g = 1;
            }
        } else {
            if (set3) {
                set_mx_h = 2;
                set_mx_g = 1;
                game_mx_h = 1;
                game_mx_g = 0;
            } else {
                set_mx_h = 1;
                set_mx_g = 2;
                game_mx_h = 0;
                game_mx_g = 1;
            }
        }

        pkt_sum_h = pkt_hd1_h + pkt_hd2_h + pkt_dd_h + pkt_he1_h + pkt_he2_h + pkt_he3_h + pkt_de_h + pkt_mx_h;
        pkt_sum_g = pkt_hd1_g + pkt_hd2_g + pkt_dd_g + pkt_he1_g + pkt_he2_g + pkt_he3_g + pkt_de_g + pkt_mx_g;
        
        set_sum_h = set_hd1_h + set_hd2_h + set_dd_h + set_he1_h + set_he2_h + set_he3_h + set_de_h + set_mx_h;
        set_sum_g = set_hd1_g + set_hd2_g + set_dd_g + set_he1_g + set_he2_g + set_he3_g + set_de_g + set_mx_g;

        game_sum_h = game_hd1_h + game_hd2_h + game_dd_h + game_he1_h + game_he2_h + game_he3_h + game_de_h + game_mx_h;
        game_sum_g = game_hd1_g + game_hd2_g + game_dd_g + game_he1_g + game_he2_g + game_he3_g + game_de_g + game_mx_g;

        if (game_sum_h > game_sum_g) {
            winner = heimverein;
        } else {
            if (game_sum_h < game_sum_g) {
                winner = gastverein;
            } else{
                winner = "unentschieden";
            }
        }
    }
}
