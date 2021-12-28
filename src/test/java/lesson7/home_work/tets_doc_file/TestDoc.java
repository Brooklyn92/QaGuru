package lesson7.home_work.tets_doc_file;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;
import java.io.FileOutputStream;
import java.io.IOException;


public class TestDoc {
    @Test
    void testDocFile() {
           try {
               FileOutputStream outputStream = new FileOutputStream("src/test/resources/Arcane22.docx");
               XWPFDocument testDoc = new XWPFDocument();
               XWPFParagraph bodyDoc = testDoc.createParagraph();
               XWPFRun config = bodyDoc.createRun();
               config.setText("Hello Arcane");
               testDoc.write(outputStream);
               outputStream.close();
            }  catch (IOException e) {
               e.printStackTrace();
            }
        }



    }


