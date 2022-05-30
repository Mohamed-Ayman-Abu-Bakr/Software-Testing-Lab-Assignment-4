import com.google.common.annotations.VisibleForTesting;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;


public class testClass {

    static WebDriver driver;
    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://formy-project.herokuapp.com/form");
        driver.manage().window().maximize();
    }
    @AfterEach
    public void clean(){
        driver.quit();
    }

    @Test
    public void test_First_Name(){
        WebElement first_name = driver.findElement(By.id("first-name"));
        first_name.sendKeys("Mohamed");
        String text = first_name.getAttribute("value");
        assertEquals("Mohamed",text);
    }
    @Test
    public void test_Last_Name(){
        WebElement last_name = driver.findElement(By.id("last-name"));
        last_name.sendKeys("Ayman");
        String text = last_name.getAttribute("value");
        assertEquals("Ayman",text);
    }
    @Test
    public void test_Job_Title(){
        WebElement first_name = driver.findElement(By.id("job-title"));
        first_name.sendKeys("Engineer");
        String text = first_name.getAttribute("value");
        assertEquals("Engineer",text);
    }

    @Test
    public void test_radio_1(){
        WebElement radio1 = driver.findElement(By.id("radio-button-1"));
        boolean selected  = radio1.isSelected();
        assertFalse(selected);
        radio1.click();
        selected  = radio1.isSelected();
        assertTrue(selected);
    }
    @Test
    public void test_radio_2(){
        WebElement radio2 = driver.findElement(By.id("radio-button-2"));
        boolean selected  = radio2.isSelected();
        assertFalse(selected);
        radio2.click();
        selected  = radio2.isSelected();
        assertTrue(selected);
    }
    @Test
    public void test_radio_3(){
        WebElement radio3 = driver.findElement(By.id("radio-button-3"));
        boolean selected  = radio3.isSelected();
        assertFalse(selected);
        radio3.click();
        selected  = radio3.isSelected();
        assertTrue(selected);
    }

    @Test
    public void test_click_multiple_radio(){
        // This test checks if multiple radio buttons can be selected at once
        WebElement radio1 = driver.findElement(By.id("radio-button-1"));
        WebElement radio2 = driver.findElement(By.id("radio-button-2"));
        radio1.click();
        radio2.click();
        //here radio1 should be deselected
        assertTrue(radio2.isSelected());
        assertFalse(radio1.isSelected());
    }

    @Test
    public void test_checkbox_1(){
        WebElement checkbox = driver.findElement(By.id("checkbox-1"));
        boolean selected  = checkbox.isSelected();
        assertFalse(selected);
        checkbox.click();
        /*selected  = checkbox.isSelected();
        assertTrue(selected);*/
    }

    @Test
    public void test_checkbox_2(){
        WebElement checkbox = driver.findElement(By.id("checkbox-2"));
        boolean selected  = checkbox.isSelected();
        assertFalse(selected);
        checkbox.click();
        selected  = checkbox.isSelected();
        assertTrue(selected);
    }

    @Test
    public void test_checkbox_3(){
        WebElement checkbox = driver.findElement(By.id("checkbox-3"));
        boolean selected  = checkbox.isSelected();
        assertFalse(selected);
        checkbox.click();
        selected  = checkbox.isSelected();
        assertTrue(selected);
    }

    @Test
    public void test_multiple_checkboxes(){
        WebElement checkbox1 = driver.findElement(By.id("checkbox-1"));
        WebElement checkbox2 = driver.findElement(By.id("checkbox-2"));
        WebElement checkbox3 = driver.findElement(By.id("checkbox-3"));
        assertFalse(checkbox1.isSelected());
        assertFalse(checkbox2.isSelected());
        assertFalse(checkbox3.isSelected());
        checkbox1.click();
        checkbox2.click();
        checkbox3.click();
        assertTrue(checkbox1.isSelected());
        assertTrue(checkbox2.isSelected());
        assertTrue(checkbox3.isSelected());
    }

    @Test
    public void test_combobox(){
        Select years_of_experience = new Select(driver.findElement(By.id("select-menu")));
        years_of_experience.selectByIndex(2);
       String selected = years_of_experience.getFirstSelectedOption().getText();
       assertEquals("2-4",selected);
    }

    @Test
    public void test_date(){
        WebElement date = driver.findElement(By.id("datepicker"));
        date.sendKeys("28/02/2001");
        assertEquals("28/02/2001",date.getAttribute("value"));
    }

    @Test
    public void test_submit(){
        WebElement btn =  driver.findElement(By.className("btn"));
        btn.click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        WebElement submit = driver.findElement(By.className("alert"));
        assertEquals("The form was successfully submitted!",submit.getText());
    }

    @Test
    public void test_submit_empty_form(){
        //the button should be disabled if the form is not full
        WebElement btn =  driver.findElement(By.className("btn"));
        assertFalse(btn.isEnabled());
    }



}
