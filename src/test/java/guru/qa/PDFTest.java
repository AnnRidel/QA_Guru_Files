package guru.qa;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static testUtils.FileUtils.readPDFFile;

public class PDFTest {
    @Test
    public void PDFFile() throws Exception {
        String text = readPDFFile("src/test/resources/sample.pdf");
        assertThat(text, containsString("And more text"));
    }
}
