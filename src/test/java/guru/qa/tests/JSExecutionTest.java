package guru.qa.tests;

import com.codeborne.selenide.Selenide;

import guru.qa.TestBase;
import guru.qa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;


public class JSExecutionTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void checkJSExecution() throws IOException {

        registrationPage
                .openPage();

        String jsScript = Files.readString(Path.of("src/test/resources/js/alert.js"));

        Selenide.executeJavaScript(jsScript);

        Alert alert = Selenide.switchTo().alert();

        assertEquals("Test alert message", alert.getText());

        Selenide.confirm();

    }
}
