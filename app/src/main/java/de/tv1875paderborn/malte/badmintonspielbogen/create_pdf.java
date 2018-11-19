package de.tv1875paderborn.malte.badmintonspielbogen;

import android.content.Context;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
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
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.kommentar;

// Spielernamen
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.heim_team;
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.gast_team;


// Ergebnisse
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.heim_erg;
import static de.tv1875paderborn.malte.badmintonspielbogen.MainActivity.gast_erg;
public class create_pdf {

    private static String sets[][] = new String[8][3];
    private static Integer heim_points[] = new Integer[8];
    private static Integer heim_sets[] = new Integer[8];
    private static Integer heim_games[] = new Integer[8];
    private static Integer gast_points[] = new Integer[8];
    private static Integer gast_sets[] = new Integer[8];
    private static Integer gast_games[] = new Integer[8];
    private static Integer sums[] = new Integer[6];

    private static String winner;

    public static void main(Context context, boolean vorschau) {
        get_scores();

        Date datum = Calendar.getInstance().getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.GERMANY);
        String date = simpleDateFormat.format(datum);

        // the directory where the signature will be saved
        File file = new File(context.getExternalFilesDir(null), date + "_" + heimverein + "-" + gastverein + ".pdf");

        Document document = new Document(PageSize.A4.rotate());

        try {
            PdfWriter.getInstance(document, new FileOutputStream(file));
            simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.GERMANY);
            date = simpleDateFormat.format(datum);

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
            cell2 = new PdfPCell(new Paragraph(heim_team[0] + "\n" + heim_team[1]));
            cell3 = new PdfPCell(new Paragraph(gast_team[0] + "\n" + gast_team[1]));
            cell4 = new PdfPCell(new Paragraph(sets[0][0]));
            cell5 = new PdfPCell(new Paragraph(sets[0][1]));
            cell6 = new PdfPCell(new Paragraph(sets[0][2]));
            cell7 = new PdfPCell(new Paragraph(Integer.toString(heim_points[0])));
            cell8 = new PdfPCell(new Paragraph(Integer.toString(gast_points[0])));
            cell9 = new PdfPCell(new Paragraph(Integer.toString(heim_sets[0])));
            cell10 = new PdfPCell(new Paragraph(Integer.toString(gast_sets[0])));
            cell11 = new PdfPCell(new Paragraph(Integer.toString(heim_games[0])));
            cell12 = new PdfPCell(new Paragraph(Integer.toString(gast_games[0])));

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
            cell2 = new PdfPCell(new Paragraph(heim_team[2] + "\n" + heim_team[3]));
            cell3 = new PdfPCell(new Paragraph(gast_team[2] + "\n" + gast_team[3]));
            cell4 = new PdfPCell(new Paragraph(sets[1][0]));
            cell5 = new PdfPCell(new Paragraph(sets[1][1]));
            cell6 = new PdfPCell(new Paragraph(sets[1][2]));
            cell7 = new PdfPCell(new Paragraph(Integer.toString(heim_points[1])));
            cell8 = new PdfPCell(new Paragraph(Integer.toString(gast_points[1])));
            cell9 = new PdfPCell(new Paragraph(Integer.toString(heim_sets[1])));
            cell10 = new PdfPCell(new Paragraph(Integer.toString(gast_sets[1])));
            cell11 = new PdfPCell(new Paragraph(Integer.toString(heim_games[1])));
            cell12 = new PdfPCell(new Paragraph(Integer.toString(gast_games[1])));

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
            cell2 = new PdfPCell(new Paragraph(heim_team[4] + "\n" + heim_team[5]));
            cell3 = new PdfPCell(new Paragraph(gast_team[4] + "\n" + gast_team[5]));
            cell4 = new PdfPCell(new Paragraph(sets[2][0]));
            cell5 = new PdfPCell(new Paragraph(sets[2][1]));
            cell6 = new PdfPCell(new Paragraph(sets[2][2]));
            cell7 = new PdfPCell(new Paragraph(Integer.toString(heim_points[2])));
            cell8 = new PdfPCell(new Paragraph(Integer.toString(gast_points[2])));
            cell9 = new PdfPCell(new Paragraph(Integer.toString(heim_sets[2])));
            cell10 = new PdfPCell(new Paragraph(Integer.toString(gast_sets[2])));
            cell11 = new PdfPCell(new Paragraph(Integer.toString(heim_games[2])));
            cell12 = new PdfPCell(new Paragraph(Integer.toString(gast_games[2])));

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
            cell2 = new PdfPCell(new Paragraph(heim_team[6]));
            cell3 = new PdfPCell(new Paragraph(gast_team[6]));
            cell4 = new PdfPCell(new Paragraph(sets[3][0]));
            cell5 = new PdfPCell(new Paragraph(sets[3][1]));
            cell6 = new PdfPCell(new Paragraph(sets[3][2]));
            cell7 = new PdfPCell(new Paragraph(Integer.toString(heim_points[3])));
            cell8 = new PdfPCell(new Paragraph(Integer.toString(gast_points[3])));
            cell9 = new PdfPCell(new Paragraph(Integer.toString(heim_sets[3])));
            cell10 = new PdfPCell(new Paragraph(Integer.toString(gast_sets[3])));
            cell11 = new PdfPCell(new Paragraph(Integer.toString(heim_games[3])));
            cell12 = new PdfPCell(new Paragraph(Integer.toString(gast_games[3])));

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
            cell2 = new PdfPCell(new Paragraph(heim_team[7]));
            cell3 = new PdfPCell(new Paragraph(gast_team[7]));
            cell4 = new PdfPCell(new Paragraph(sets[4][0]));
            cell5 = new PdfPCell(new Paragraph(sets[4][1]));
            cell6 = new PdfPCell(new Paragraph(sets[4][2]));
            cell7 = new PdfPCell(new Paragraph(Integer.toString(heim_points[4])));
            cell8 = new PdfPCell(new Paragraph(Integer.toString(gast_points[4])));
            cell9 = new PdfPCell(new Paragraph(Integer.toString(heim_sets[4])));
            cell10 = new PdfPCell(new Paragraph(Integer.toString(gast_sets[4])));
            cell11 = new PdfPCell(new Paragraph(Integer.toString(heim_games[4])));
            cell12 = new PdfPCell(new Paragraph(Integer.toString(gast_games[4])));

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
            cell2 = new PdfPCell(new Paragraph(heim_team[8]));
            cell3 = new PdfPCell(new Paragraph(gast_team[8]));
            cell4 = new PdfPCell(new Paragraph(sets[5][0]));
            cell5 = new PdfPCell(new Paragraph(sets[5][1]));
            cell6 = new PdfPCell(new Paragraph(sets[5][2]));
            cell7 = new PdfPCell(new Paragraph(Integer.toString(heim_points[5])));
            cell8 = new PdfPCell(new Paragraph(Integer.toString(gast_points[5])));
            cell9 = new PdfPCell(new Paragraph(Integer.toString(heim_sets[5])));
            cell10 = new PdfPCell(new Paragraph(Integer.toString(gast_sets[5])));
            cell11 = new PdfPCell(new Paragraph(Integer.toString(heim_games[5])));
            cell12 = new PdfPCell(new Paragraph(Integer.toString(gast_games[5])));

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
            cell2 = new PdfPCell(new Paragraph(heim_team[9]));
            cell3 = new PdfPCell(new Paragraph(gast_team[9]));
            cell4 = new PdfPCell(new Paragraph(sets[6][0]));
            cell5 = new PdfPCell(new Paragraph(sets[6][1]));
            cell6 = new PdfPCell(new Paragraph(sets[6][2]));
            cell7 = new PdfPCell(new Paragraph(Integer.toString(heim_points[6])));
            cell8 = new PdfPCell(new Paragraph(Integer.toString(gast_points[6])));
            cell9 = new PdfPCell(new Paragraph(Integer.toString(heim_sets[6])));
            cell10 = new PdfPCell(new Paragraph(Integer.toString(gast_sets[6])));
            cell11 = new PdfPCell(new Paragraph(Integer.toString(heim_games[6])));
            cell12 = new PdfPCell(new Paragraph(Integer.toString(gast_games[6])));

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
            cell2 = new PdfPCell(new Paragraph(heim_team[10] + "\n" + heim_team[11]));
            cell3 = new PdfPCell(new Paragraph(gast_team[10] + "\n" + gast_team[11]));
            cell4 = new PdfPCell(new Paragraph(sets[7][0]));
            cell5 = new PdfPCell(new Paragraph(sets[7][1]));
            cell6 = new PdfPCell(new Paragraph(sets[7][2]));
            cell7 = new PdfPCell(new Paragraph(Integer.toString(heim_points[7])));
            cell8 = new PdfPCell(new Paragraph(Integer.toString(gast_points[7])));
            cell9 = new PdfPCell(new Paragraph(Integer.toString(heim_sets[7])));
            cell10 = new PdfPCell(new Paragraph(Integer.toString(gast_sets[7])));
            cell11 = new PdfPCell(new Paragraph(Integer.toString(heim_games[7])));
            cell12 = new PdfPCell(new Paragraph(Integer.toString(gast_games[7])));

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
            cell7 = new PdfPCell(new Paragraph(Integer.toString(sums[0])));
            cell8 = new PdfPCell(new Paragraph(Integer.toString(sums[1])));
            cell9 = new PdfPCell(new Paragraph(Integer.toString(sums[2])));
            cell10 = new PdfPCell(new Paragraph(Integer.toString(sums[3])));
            cell11 = new PdfPCell(new Paragraph(Integer.toString(sums[4])));
            cell12 = new PdfPCell(new Paragraph(Integer.toString(sums[5])));

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

            // Kommentare hinzufügen, falls vorhanden
            if (kommentar.length() != 0) {
                document.newPage();

                document.add(new Paragraph("Kommentar"));
                document.add(new Paragraph(kommentar));
            }

            try {
                if (!vorschau) {
                    String root = context.getExternalFilesDir(null).toString();
                    Image sign_heim = Image.getInstance(root + "/unterschriften/sign_heim.png");
                    Image sign_gast = Image.getInstance(root + "/unterschriften/sign_gast.png");

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
                }
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

        for (int su=0; su<6; su++){
            sums[su] = 0;
        }

        for (int game=0; game<8; game++){
            heim_points[game] = 0;
            heim_sets[game] = 0;
            heim_games[game] = 0;

            gast_points[game] = 0;
            gast_sets[game] = 0;
            gast_games[game] = 0;

            for (int set=0; set<3; set++) {
                // Darstellung Satzergebnis
                if (heim_erg[game][set] == null || gast_erg[game][set] == null){
                    sets[game][set] = "-";
                }else {
                    sets[game][set] = heim_erg[game][set] + "-" + gast_erg[game][set];

                    // Berechnung Punkte
                    if (heim_erg[game][set] > gast_erg[game][set]){
                        heim_sets[game] += 1;
                    }else {
                        gast_sets[game] += 1;
                    }
                    heim_points[game] += heim_erg[game][set];
                    gast_points[game] += gast_erg[game][set];
                }
            }
            // Berechnung Sätze und Spiele
            if (heim_sets[game] > gast_sets[game]){
                heim_games[game] += 1;
            }else if (heim_sets[game] < gast_sets[game]){
                gast_games[game] += 1;
            }

            // Summen berechnen
            sums[0] += heim_points[game];
            sums[1] += gast_points[game];
            sums[2] += heim_sets[game];
            sums[3] += gast_sets[game];
            sums[4] += heim_games[game];
            sums[5] += gast_games[game];
        }

        if (sums[4] > sums[5]) {
            winner = heimverein;
        } else {
            if (sums[4] < sums[5]) {
                winner = gastverein;
            } else{
                winner = "unentschieden";
            }
        }
    }

}
