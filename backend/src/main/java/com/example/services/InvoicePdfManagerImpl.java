package com.example.services;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import com.itextpdf.layout.borders.SolidBorder;

@Service
public class InvoicePdfManagerImpl implements InvoicePdfManager {

    @Override
    public void invoicePdf(String pdfname) throws IOException {
        String path = pdfname + ".pdf";
        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.setDefaultPageSize(PageSize.A4);
        Document document = new Document(pdfDocument);

        // Header
        Paragraph header = new Paragraph("INVOICE")
                .setFontSize(20)
                .setFont(com.itextpdf.kernel.font.PdfFontFactory.createFont(com.itextpdf.io.font.constants.StandardFonts.HELVETICA_BOLD))
                .setTextAlignment(TextAlignment.CENTER);
        document.add(header);

        // Company and Client Details
        Table detailsTable = new Table(new float[]{1, 1});
        detailsTable.setWidth(UnitValue.createPercentValue(100));

        detailsTable.addCell(new Cell().add(new Paragraph("Company Name\nAddress Line 1\nCity, Country\nPhone: 123-456-7890"))
                .setBorder(null));
        detailsTable.addCell(new Cell().add(new Paragraph("Bill To:\nCustomer Name\nCustomer Address\nEmail: customer@email.com"))
                .setBorder(null));
        document.add(detailsTable);

        // Space
        document.add(new Paragraph(" "));

        // Item Table
        Table table = new Table(new float[]{2, 1, 1, 1});
        table.setWidth(UnitValue.createPercentValue(100));
        table.addHeaderCell(new Cell().add(new Paragraph("Item Description").setBackgroundColor(ColorConstants.LIGHT_GRAY)));
        table.addHeaderCell(new Cell().add(new Paragraph("Quantity").setBackgroundColor(ColorConstants.LIGHT_GRAY)));
        table.addHeaderCell(new Cell().add(new Paragraph("Unit Price").setBackgroundColor(ColorConstants.LIGHT_GRAY)));
        table.addHeaderCell(new Cell().add(new Paragraph("Total").setBackgroundColor(ColorConstants.LIGHT_GRAY)));

        // Sample Items
        for (int i = 0; i < 3; i++) {
            table.addCell("Product " + (i + 1));
            table.addCell("1");
            table.addCell("$100");
            table.addCell("$100");
        }
        document.add(table);

        // Total Section
        Table totalTable = new Table(new float[]{3, 1});
        totalTable.setWidth(UnitValue.createPercentValue(100));
        totalTable.addCell(new Cell().add(new Paragraph(" ")).setBorder(null));
        totalTable.addCell(new Cell().add(new Paragraph("Subtotal: $300")).setBorder(null));
        totalTable.addCell(new Cell().add(new Paragraph(" ")).setBorder(null));
        totalTable.addCell(new Cell().add(new Paragraph("Tax (10%): $30")).setBorder(null));
        totalTable.addCell(new Cell().add(new Paragraph(" ")).setBorder(null));
        totalTable.addCell(new Cell().add(new Paragraph("Total: $330")));
        document.add(totalTable);

        // Footer
        document.add(new Paragraph("Thank you for your business!\nCompany Name").setTextAlignment(TextAlignment.CENTER));

        document.close();
        System.out.println("Invoice PDF created successfully!");
    }
}
