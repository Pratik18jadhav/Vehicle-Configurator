package com.example.services;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.SolidBorder;

@Service
public class InvoicePdfManagerImpl implements InvoicePdfManager {

    @Override
    public void invoicePdf(String pdfname) throws IOException {
    	String pdfName = pdfname;  // You can set this dynamically
        String path = pdfName + ".pdf";

        PdfWriter pdfWriter = new PdfWriter(new File(path));
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.setDefaultPageSize(PageSize.A4);
        Document document = new Document(pdfDocument);

        // Load Fonts
        PdfFont boldFont = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
        PdfFont regularFont = PdfFontFactory.createFont(StandardFonts.HELVETICA);

        // **Header**
        Paragraph header = new Paragraph("INVOICE")
                .setFontSize(28)
                .setFont(boldFont)
                .setFontColor(ColorConstants.BLUE)
                .setTextAlignment(TextAlignment.CENTER)
                .setMarginBottom(20);
        document.add(header);

        // **Company & Client Details**
        Table detailsTable = new Table(new float[]{1, 1});
        detailsTable.setWidth(UnitValue.createPercentValue(100));

        detailsTable.addCell(new Cell().add(new Paragraph("VConfig Solutions\n123 Business Street\nMumbai, India\n📞 +91-9876543210"))
                .setFont(regularFont)
                .setBorder(Border.NO_BORDER));

        detailsTable.addCell(new Cell().add(new Paragraph("Billed To:\n[Customer Name]\n[Customer Address]\n📧 customer@email.com"))
                .setFont(regularFont)
                .setBorder(Border.NO_BORDER)
                .setTextAlignment(TextAlignment.RIGHT));

        document.add(detailsTable);
        document.add(new Paragraph("\n")); // Spacer

        // **Itemized Table**
        Table table = new Table(new float[]{2, 1, 1, 1});
        table.setWidth(UnitValue.createPercentValue(100));

        // Table Header
        String[] headers = {"Item Description", "Quantity", "Unit Price (₹)", "Total (₹)"};
        for (String headerText : headers) {
            table.addHeaderCell(new Cell().add(new Paragraph(headerText))
                    .setBackgroundColor(ColorConstants.LIGHT_GRAY)
                    .setFont(boldFont)
                    .setTextAlignment(TextAlignment.CENTER));
        }

        // Sample Items (Replace with dynamic values)
        double subtotal = 0;
        for (int i = 1; i <= 3; i++) {
            double price = 100 * i;
            double total = price * 1;
            subtotal += total;

            table.addCell(new Cell().add(new Paragraph("Product " + i)).setFont(regularFont).setTextAlignment(TextAlignment.LEFT));
            table.addCell(new Cell().add(new Paragraph("1")).setFont(regularFont).setTextAlignment(TextAlignment.CENTER));
            table.addCell(new Cell().add(new Paragraph("₹" + price)).setFont(regularFont).setTextAlignment(TextAlignment.RIGHT));
            table.addCell(new Cell().add(new Paragraph("₹" + total)).setFont(regularFont).setTextAlignment(TextAlignment.RIGHT));
        }

        document.add(table);
        document.add(new Paragraph("\n")); // Spacer

        // **Total Summary**
        Table totalTable = new Table(new float[]{3, 1});
        totalTable.setWidth(UnitValue.createPercentValue(100));

        double tax = subtotal * 0.10; // 10% Tax
        double grandTotal = subtotal + tax;

        totalTable.addCell(new Cell().add(new Paragraph("Subtotal:")).setFont(regularFont).setBorder(Border.NO_BORDER));
        totalTable.addCell(new Cell().add(new Paragraph("₹" + String.format("%.2f", subtotal)))
                .setFont(regularFont)
                .setTextAlignment(TextAlignment.RIGHT)
                .setBorder(Border.NO_BORDER));

        totalTable.addCell(new Cell().add(new Paragraph("Tax (10%):")).setFont(regularFont).setBorder(Border.NO_BORDER));
        totalTable.addCell(new Cell().add(new Paragraph("₹" + String.format("%.2f", tax)))
                .setFont(regularFont)
                .setTextAlignment(TextAlignment.RIGHT)
                .setBorder(Border.NO_BORDER));

        totalTable.addCell(new Cell().add(new Paragraph("Total Amount:")).setFont(boldFont).setBorder(Border.NO_BORDER));
        totalTable.addCell(new Cell().add(new Paragraph("₹" + String.format("%.2f", grandTotal)))
                .setFont(boldFont)
                .setTextAlignment(TextAlignment.RIGHT)
                .setBorder(Border.NO_BORDER)
                .setFontColor(ColorConstants.RED));

        document.add(totalTable);

        // **Footer**
        document.add(new Paragraph("\nThank you for your business! 😊\nVConfig Solutions")
                .setTextAlignment(TextAlignment.CENTER)
                .setFontSize(12)
                .setFont(regularFont)
                .setFontColor(ColorConstants.GRAY)
                .setMarginTop(20));

        // Close Document
        document.close();
        System.out.println("✅ Invoice PDF Created: " + path);
        System.out.println("Invoice PDF created successfully!");
    }
}
