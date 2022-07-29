package PO;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

public class BasePage {

    private static Logger LOGGER = Logger.getLogger("abstrac");
    private static final int TIMEOUT = 10;
    private static final int POLLING = 100;

    final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(id = "processing_content")
    WebElement loadPage;
    @FindBy (id = "CerrarSesion")
    WebElement CerrarPage;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, TIMEOUT, POLLING);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
    }
    protected void waitForElementToAppear(WebElement element) {

        wait.until(ExpectedConditions.visibilityOf(element));
    }
    protected void waitForElementToDisappear(WebElement locator) {
        wait.until(ExpectedConditions.invisibilityOf(locator));
    }
    protected void waitForTextToDisappear(WebElement locator, String text) {
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(locator, text)));
    }
    protected boolean waitForClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return true;
    }
    protected boolean isVisible(WebElement webElement) {
        boolean isVisible;
        try {
            isVisible = webElement.isDisplayed();
        } catch (NoSuchElementException e) {
            isVisible = false;
        }
        return isVisible;
    }
    public void waitFor(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
    public void Log(String ms) {
        LOGGER.info(ms);
    }
    public  void position (WebDriver driver,WebElement element){
        Actions act = new Actions(driver);
        act.moveToElement(element).perform();
        act.moveToElement(element).click().perform();
    }
    public void cerrarSesion (){
        waitForElementToAppear(CerrarPage);
        CerrarPage.click();
    }
    public void scroll() throws IOException {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
}
