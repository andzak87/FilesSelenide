
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class TestClass {

    @Disabled
    @Test
    public void SelenideDownloadTest() throws IOException {
        open("https://github.com/andzak87/javaZak/blob/main/README.md");
        File downFile = $("#raw-url").download();
        InputStream is = new FileInputStream(downFile);
        byte[] bytes = is.readAllBytes();
        String textContent = new String(bytes, StandardCharsets.UTF_8);
        assertThat(textContent).contains("javaZak");
        is.close();

    }


}
