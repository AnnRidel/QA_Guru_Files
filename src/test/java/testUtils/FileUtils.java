package testUtils;

import net.lingala.zip4j.core.ZipFile;
import org.apache.commons.io.IOUtils;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;


public class FileUtils {

    public static String readDocxFile (String docxFilePath) throws Exception {
            FileInputStream fis = new FileInputStream(docxFilePath);
            XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(fis));
            XWPFWordExtractor extractor = new XWPFWordExtractor(xdoc);
            fis.close();
        return extractor.getText();
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
