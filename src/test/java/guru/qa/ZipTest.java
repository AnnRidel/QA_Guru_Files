package guru.qa;

import org.apache.commons.io.FileUtils;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import org.junit.jupiter.api.Test;
import java.io.File;
import static testUtils.FileUtils.readTextFile;
import static testUtils.FileUtils.readZipFile;

public class ZipTest {
    @Test
    public void ZipFile() throws Exception {
        readZipFile ("src/test/resources/тест.zip", "123456", "src/test/resources/unpackedzip");
        String text = readTextFile("src/test/resources/unpackedzip/test.txt");
        assertThat(text, containsString("тест2"));
        FileUtils.cleanDirectory(new File("src/test/resources/unpackedzip"));
    }
}
