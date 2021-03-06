package lesson7;
import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FilesTest {

    @Test
    @DisplayName("Загрузка файла по абсолютному пути(не рекомендуется)")
    void fileNameShouldDisplayedAfterUploadActionAbsolutePathTest() {
        open("https://the-internet.herokuapp.com/upload");
       File exampleFile1 =  new File("C:\\Users\\Aleksandr\\Desktop\\Study\\QaGuru\\src\\test\\resources\\example");
        $("input[type='file']").uploadFile(exampleFile1);
        $("#file-submit").click();
        $("#uploaded-files").shouldHave(text("example"));
    }

    @Test
    @DisplayName("Загрузка файла по относительному пути(рекомендуется)")
    void fileNameShouldDisplayedAfterUploadActionFromClassPathTest() {
        open("https://the-internet.herokuapp.com/upload");
        $("input[type='file']").uploadFromClasspath("example");
        $("#file-submit").click();
        $("#uploaded-files").shouldHave(text("example"));
    }
    @Test
    @DisplayName("Сачивание файла перед проверкой его содеражимого")
    void downloadSimpleTextFileTest() throws IOException {
        open("https://github.com/junit-team/junit5/blob/main/README.md");
        File download = $("#raw-url").download(); // метод для скачивания файла.Можно скачивать файлы только со ссылкой с атрибутом “href”.
        String fileContent = IOUtils.toString(new FileReader(download));// подключаем библиотеку IOUtils для проверки содержимого файла
        assertTrue(fileContent.contains("This repository is the home of the next generation of JUnit, _JUnit 5_."));// проверка условия на то, что искомый текст будет в скачеваемом файле
        //System.out.println(download.getAbsoluteFile()); - качает файл по абсолютному пути, в throws нужно прописать исклечение FileNotFoundException.

    }

    @Test
    @DisplayName("Скачивание PDF файла")
    void pdfFileDownloadTest() throws IOException {
        open("https://junit.org/junit5/docs/current/user-guide/");
        File pdf = $(byText("PDF download")).download();
        PDF parsePDF = new PDF(pdf);
        Assertions.assertEquals(166, parsePDF.numberOfPages);
    }

    @Test
    @DisplayName("Скачивание XLS файла")
    void xlsFileDownloadTest() throws IOException {
        open("http://romashka2008.ru/price");
        $(".remodal-close-btn").click();
        File file = $$("a[href*='prajs']")
                .find(text("Скачать Прайс-лист Excel"))
                .download();
        XLS parsedXLS = new XLS(file);
        boolean checkPassed = parsedXLS.excel.getSheetAt(0)
                .getRow(11)
                .getCell(1)
                .getStringCellValue()
                .contains("693010, Сахалинская обл, Южно-Сахалинск г, им Анкудинова Федора Степановича б-р, дом № 15, корпус А");
        assertTrue(checkPassed);
    }

    @Test
    @DisplayName("Парсинг CSV файлов")
    void parseCsvFileTest() throws IOException, CsvException {
        ClassLoader classLoader = this.getClass().getClassLoader();
       try (InputStream is = classLoader.getResourceAsStream("csv.csv");
            Reader reader = new InputStreamReader(is)) {
            CSVReader csvReader = new CSVReader(reader);
            List<String[]> strings = csvReader.readAll();
            assertEquals(3,strings.size());
       }
    }

    @Test
    @DisplayName("Парсинг ZIP файлов")
    void parseZipFileTest() throws IOException {
        ClassLoader classLoader = this.getClass().getClassLoader();
        try (InputStream is = classLoader.getResourceAsStream("zip_2MB.zip");
             ZipInputStream zis = new ZipInputStream(is)) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null){
                System.out.println(entry.getName());
            }
        }
    }

}
