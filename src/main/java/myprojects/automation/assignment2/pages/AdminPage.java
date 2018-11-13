package myprojects.automation.assignment2.pages;

import myprojects.automation.assignment2.BaseScript;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

/**
 * Created by lucky on 11/9/18.
 */
public class AdminPage {

    WebDriver driver = BaseScript.getDriver();

    public LoginPage logout() {
//    3. После входа в систему нажать на пиктограмме пользователя в верхнем правом углу и выбрать опцию «Выход.»

        driver.findElement(By.id("header_employee_box")).click();
        driver.findElement(By.id("header_logout")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(driver.findElement(By.cssSelector("img[src='/img/preston-login@2x.png']")).isDisplayed(), "TBD");
        return new LoginPage();
    }

    /**
     * 2. Кликнуть на каждом видимом пункте главного меню (Dashboard, Заказы,
     Каталог, Клиенты...) для открытия соответствующего раздела и выполнить следующее:
     */
    public AdminPage openEachItemOfMenuAndPrintItsTitle(){

        List<WebElement> menuItems = driver.findElements(By.cssSelector("li.maintab > a"));
        WebElement pageTitleBefore;
        WebElement pageTitleAfter;
        String pageTitleStrBefore;
        String pageTitleStrAfter;

        for(int i = 0; i < menuItems.size(); i++){
            List<WebElement> menuTabs = driver.findElements(By.cssSelector("li.maintab > a")).isEmpty() ?
                     driver.findElements(By.cssSelector(".main-menu > li.link-levelone")) : driver.findElements(By.cssSelector("li.maintab > a"));

            menuTabs.get(i).click();
            ExpectedConditions.presenceOfElementLocated(By.id("content"));
            //  a. Вывести в консоль заголовок открытого раздела.
            pageTitleBefore = driver.findElement(By.tagName("h2"));
            pageTitleStrBefore = pageTitleBefore.getText();
            // b. Выполнить обновление (рефреш) страницы
            driver.navigate().refresh();
            // to avoid StaleElementReferenceException, let's find page title one more time
            pageTitleAfter = driver.findElement(By.tagName("h2"));
            pageTitleStrAfter = pageTitleAfter.getText();
            System.out.printf("Page title BEFORE refresh is '%s', and AFTER - '%s' \n", pageTitleStrBefore, pageTitleStrAfter);
            // и проверить, что пользователь остается в том же разделе после перезагрузки страницы.
            Assert.assertEquals(pageTitleStrAfter, pageTitleStrBefore, "Page Title before and after refresh seem to be different");
        }

        return this;
    }
}
