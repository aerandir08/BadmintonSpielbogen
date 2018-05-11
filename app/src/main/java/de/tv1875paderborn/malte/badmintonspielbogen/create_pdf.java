package de.tv1875paderborn.malte.badmintonspielbogen;

import android.os.Environment;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
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
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_hd11;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_hd12;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_hd13;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_hd21;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_hd22;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_hd23;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_dd1;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_dd2;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_dd3;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_he11;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_he12;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_he13;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_he21;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_he22;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_he23;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_he31;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_he32;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_he33;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_de1;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_de2;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_de3;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_mx1;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_mx2;
import static de.tv1875paderborn.malte.badmintonspielbogen.ergebnis.er_mx3;

public class create_pdf {
    public static void main() {
        String root = Environment.getExternalStorageDirectory().toString();

        // the directory where the signature will be saved
        File file = new File(root + "/badmintonspielbogen/Spielberichtsbogen.pdf");

        Document document = new Document(PageSize.A4.rotate());

        try {
            PdfWriter.getInstance(document, new FileOutputStream(file));

            document.open();

            // überschrift und zentrales
            document.add(new Paragraph("Spielberichtsbogen: " + heimverein + " : " + gastverein));
            document.add(new Paragraph("Staffel: " + staffel + "     Austragungsort: " + ort + "     Spielbeginn:" + zeit));

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
            cell4 = new PdfPCell(new Paragraph(er_hd11));
            cell5 = new PdfPCell(new Paragraph(er_hd12));
            cell6 = new PdfPCell(new Paragraph(er_hd13));
            cell7 = new PdfPCell(new Paragraph("1. HD"));
            cell8 = new PdfPCell(new Paragraph("1. HD"));
            cell9 = new PdfPCell(new Paragraph("1. HD"));
            cell10 = new PdfPCell(new Paragraph("1. HD"));
            cell11 = new PdfPCell(new Paragraph("1. HD"));
            cell12 = new PdfPCell(new Paragraph("1. HD"));

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
            cell4 = new PdfPCell(new Paragraph(er_hd21));
            cell5 = new PdfPCell(new Paragraph(er_hd22));
            cell6 = new PdfPCell(new Paragraph(er_hd23));
            cell7 = new PdfPCell(new Paragraph("1. HD"));
            cell8 = new PdfPCell(new Paragraph("1. HD"));
            cell9 = new PdfPCell(new Paragraph("1. HD"));
            cell10 = new PdfPCell(new Paragraph("1. HD"));
            cell11 = new PdfPCell(new Paragraph("1. HD"));
            cell12 = new PdfPCell(new Paragraph("1. HD"));

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
            cell4 = new PdfPCell(new Paragraph(er_dd1));
            cell5 = new PdfPCell(new Paragraph(er_dd2));
            cell6 = new PdfPCell(new Paragraph(er_dd3));
            cell7 = new PdfPCell(new Paragraph("1. HD"));
            cell8 = new PdfPCell(new Paragraph("1. HD"));
            cell9 = new PdfPCell(new Paragraph("1. HD"));
            cell10 = new PdfPCell(new Paragraph("1. HD"));
            cell11 = new PdfPCell(new Paragraph("1. HD"));
            cell12 = new PdfPCell(new Paragraph("1. HD"));

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
            cell4 = new PdfPCell(new Paragraph(er_he11));
            cell5 = new PdfPCell(new Paragraph(er_he12));
            cell6 = new PdfPCell(new Paragraph(er_he13));
            cell7 = new PdfPCell(new Paragraph("1. HD"));
            cell8 = new PdfPCell(new Paragraph("1. HD"));
            cell9 = new PdfPCell(new Paragraph("1. HD"));
            cell10 = new PdfPCell(new Paragraph("1. HD"));
            cell11 = new PdfPCell(new Paragraph("1. HD"));
            cell12 = new PdfPCell(new Paragraph("1. HD"));

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
            cell4 = new PdfPCell(new Paragraph(er_he21));
            cell5 = new PdfPCell(new Paragraph(er_he22));
            cell6 = new PdfPCell(new Paragraph(er_he23));
            cell7 = new PdfPCell(new Paragraph("1. HD"));
            cell8 = new PdfPCell(new Paragraph("1. HD"));
            cell9 = new PdfPCell(new Paragraph("1. HD"));
            cell10 = new PdfPCell(new Paragraph("1. HD"));
            cell11 = new PdfPCell(new Paragraph("1. HD"));
            cell12 = new PdfPCell(new Paragraph("1. HD"));

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
            cell4 = new PdfPCell(new Paragraph(er_he31));
            cell5 = new PdfPCell(new Paragraph(er_he32));
            cell6 = new PdfPCell(new Paragraph(er_he33));
            cell7 = new PdfPCell(new Paragraph("1. HD"));
            cell8 = new PdfPCell(new Paragraph("1. HD"));
            cell9 = new PdfPCell(new Paragraph("1. HD"));
            cell10 = new PdfPCell(new Paragraph("1. HD"));
            cell11 = new PdfPCell(new Paragraph("1. HD"));
            cell12 = new PdfPCell(new Paragraph("1. HD"));

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
            cell4 = new PdfPCell(new Paragraph(er_de1));
            cell5 = new PdfPCell(new Paragraph(er_de2));
            cell6 = new PdfPCell(new Paragraph(er_de3));
            cell7 = new PdfPCell(new Paragraph("1. HD"));
            cell8 = new PdfPCell(new Paragraph("1. HD"));
            cell9 = new PdfPCell(new Paragraph("1. HD"));
            cell10 = new PdfPCell(new Paragraph("1. HD"));
            cell11 = new PdfPCell(new Paragraph("1. HD"));
            cell12 = new PdfPCell(new Paragraph("1. HD"));

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
            cell4 = new PdfPCell(new Paragraph(er_mx1));
            cell5 = new PdfPCell(new Paragraph(er_mx2));
            cell6 = new PdfPCell(new Paragraph(er_mx3));
            cell7 = new PdfPCell(new Paragraph("1. HD"));
            cell8 = new PdfPCell(new Paragraph("1. HD"));
            cell9 = new PdfPCell(new Paragraph("1. HD"));
            cell10 = new PdfPCell(new Paragraph("1. HD"));
            cell11 = new PdfPCell(new Paragraph("1. HD"));
            cell12 = new PdfPCell(new Paragraph("1. HD"));

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
            cell7 = new PdfPCell(new Paragraph("1. HD"));
            cell8 = new PdfPCell(new Paragraph("1. HD"));
            cell9 = new PdfPCell(new Paragraph("1. HD"));
            cell10 = new PdfPCell(new Paragraph("1. HD"));
            cell11 = new PdfPCell(new Paragraph("1. HD"));
            cell12 = new PdfPCell(new Paragraph("1. HD"));

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

            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);
            float[] columnWidths = {1f, 5f, 5f, 3f, 3f, 3f, 2f, 2f, 2f, 2f, 2f, 2f};
            table.setWidths(columnWidths);

            document.add(table);
            
            document.close(); // no need to close PDFwriter?

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    public static int get_scores(){
        int pkt = 0;
        return pkt;
    }

}
