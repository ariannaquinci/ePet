package reversoseleniumtest.reversotestselenium;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class seleniumReverso{
    public static void main(String args[]){
        String txt;
        String expectedString;
        System.setProperty("webdriver.chrome.driver", "src/chromedriver_win32/chromedriver.exe");

        WebDriver driver= new ChromeDriver();
        driver.get("https://context.reverso.net/translation/");
        driver.findElement(By.xpath("//*[@id=\"didomi-notice-agree-button\"]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"entry\"]")).sendKeys("Buongiorno");
        driver.findElement(By.xpath("//*[@id=\"src-selector\"]/span[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"src-selector\"]/div/span[7]")).click();
        driver.findElement(By.xpath("//*[@id=\"trg-selector\"]/span[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"trg-selector\"]/div/span[6]")).click();
        driver.findElement(By.xpath("//*[@id=\"search-button\"]")).click();
        txt=driver.findElement(By.xpath("//*[@id=\"translations-content\"]/a[1]")).getText();
        driver.close();
        JUnitReverso.checkTranslation("bonjour",txt);
        }

}
