package testUtils;

import net.lingala.zip4j.core.ZipFile;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;



public class FileUtils {

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
