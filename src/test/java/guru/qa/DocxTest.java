package guru.qa;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static testUtils.FileUtils.*;

public class DocxTest {
    @Test
    public void DocxFile() throws Exception {
        String text = readDocxFile("src/test/resources/Как начать и поддержать разговор на английском языке.docx");
        assertThat(text, containsString("Как жизнь?"));
    }
}
