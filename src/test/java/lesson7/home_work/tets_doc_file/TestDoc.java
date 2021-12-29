package lesson7.home_work.tets_doc_file;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestDoc {
    @Test
    void testDocFile() throws IOException {
        FileOutputStream outputStream = new FileOutputStream("src/test/resources/Arcane3.docx");
        XWPFDocument testDoc = new XWPFDocument();
        XWPFParagraph bodyDoc = testDoc.createParagraph();
        XWPFRun config = bodyDoc.createRun();
        config.setText("Hello Jinx");
        assertTrue(config.text().contains("Hello Jinx"), String.format("Файл не содержит текст: %s", "Hello Jinx"));
        testDoc.write(outputStream);
        outputStream.close();

    }

}


