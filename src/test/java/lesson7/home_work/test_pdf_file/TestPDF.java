package lesson7.home_work.test_pdf_file;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;

public class TestPDF {
    @DisplayName("Чтение PDF-файла")
    @Test
    void testPDFRead() {
        try {
            File file = new File("src/test/resources/163902.pdf");
            PDDocument document = PDDocument.load(file);
            PDFTextStripper pdfStripper = new PDFTextStripper();
            String text = pdfStripper.getText(document);
            Assertions.assertEquals(true, text.contains("600000, Владимирская обл, г Владимир"));
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
