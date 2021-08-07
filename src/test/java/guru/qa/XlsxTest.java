package guru.qa;

import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static testUtils.FileUtils.readXlsxFile;

public class XlsxTest {
    @Test
    public void XlsxFile() throws Exception {
        String exelData = readXlsxFile("file_example_XLSX_10.xlsx", 0, 5, 5);
        assertThat(exelData, containsString("58"));
    }
}
