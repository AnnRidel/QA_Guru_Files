package testUtils;

import net.lingala.zip4j.core.ZipFile;
import org.apache.commons.io.IOUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class FileUtils {

    public static String readDocxFile (String docxFilePath) throws Exception {
            FileInputStream fis = new FileInputStream(docxFilePath);
            XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(fis));
            XWPFWordExtractor extractor = new XWPFWordExtractor(xdoc);
            fis.close();
        return extractor.getText();
    }

    public static String readPDFFile (String pdfFilePath) throws Exception {
        PDDocument document = PDDocument.load(new File(pdfFilePath));
        PDFTextStripper stripper = new PDFTextStripper();
        String text = stripper.getText(document);
        document.close();
        return text;
    }

    public static InputStream getInputStreamForFileName(String fileName) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        return classLoader.getResourceAsStream(fileName);
    }

    public static String readXlsxFile (String xlsxFilePath, int index, int rowindex, int cellnum) throws Exception {
        InputStream stream = getInputStreamForFileName(xlsxFilePath);
        XSSFWorkbook workbook = new XSSFWorkbook(stream);
        XSSFSheet sheet = workbook.getSheetAt(index);
        XSSFRow row = sheet.getRow(rowindex);
        XSSFCell cell = row.getCell(cellnum);
        return String.valueOf(cell.getNumericCellValue());
    }

    public static void readZipFile (String zipFilePath, String password, String unzipFolderPath) throws Exception {
        ZipFile zipFile = new ZipFile(zipFilePath);
        if (zipFile.isEncrypted()) {
            zipFile.setPassword (password);
        }
        zipFile.extractAll(unzipFolderPath);
    }

    public static String readTextFile (String textFilePath) throws Exception {
        FileInputStream fis = new FileInputStream(textFilePath);
        String data = IOUtils.toString(fis, StandardCharsets.UTF_8);
        fis.close();
        return data.trim();
    }
}
