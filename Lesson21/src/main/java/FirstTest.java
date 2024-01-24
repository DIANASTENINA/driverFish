import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstTest {
    static Logger logger = (Logger) LogManager.getLogger(FirstTest.class);
    WebDriver driver;

    @BeforeAll
    public static void driverInstall(){
        WebDriverManager.firefoxdriver().setup();
        logger.info("Установка драйвера ");
    }

    @BeforeEach
    public void driverStart(){
        driver = new FirefoxDriver();
        logger.info("Запуск браузера");

    }

    @AfterEach
    public void driverStop(){
        if (driver!= null) {
            logger.info("Закрываем браузер");
            driver.close();
            driver.quit();
             }
        }

    @Test
    public void firstTest(WebDriver driver) {
        driver.get("https://otus.ru");
        String fr = driver.getTitle();
        Assertions.assertEquals("", fr, "шев все пропало");

    }
}

