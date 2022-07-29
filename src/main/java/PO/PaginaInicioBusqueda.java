package PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.io.IOException;

public class PaginaInicioBusqueda extends BasePage{
    /**se llama el driver para ocuopar la clase Base*/
    public PaginaInicioBusqueda (WebDriver driver){super(driver);}

    /**Elementos en la pagina inicio*/

    @FindBy ( xpath = "//input[contains(@class,'nav-search-input')]" )
    WebElement busqueda;
    @FindBy ( xpath = "//div[contains(@class,'nav-icon-search')]")
    WebElement btnLupa;
    @FindBy ( xpath = "//span[contains(text(),'Siguiente')]")
    WebElement btnSiguiente;
    @FindBy ( xpath = "//ol[contains(@class,'ui-search-layout ui-search-layout--grid')]")
    WebElement listProd;
    /** objeto con logica*/
    public void IngresoPagina( String url,String busq) throws IOException {
        driver.get(url);
        if(isVisible(busqueda))
        {
         Log("Se visualiza buscador");
         busqueda.sendKeys(busq);
         Log("se busca " + busq);
         btnLupa.click();

         for ( int num = 1; num <= 18; num = num+ 1 ){
             WebElement merPagina = driver.findElement (By.xpath("(//ol[contains(@class,'ui-search-layout ui-search-layout--grid')])["+num+"]"));
             isVisible(merPagina);
             String busqued = merPagina.getText();
             Log("prueba   :::: " + busqued);
         }
         scroll();
        }btnSiguiente.click();
        if(isVisible(listProd))
        {
            Log("Se visualizan los productos");
            for ( int num = 1; num <= 18; num = num+ 1 ){
                WebElement merPagina = driver.findElement (By.xpath("(//ol[contains(@class,'ui-search-layout ui-search-layout--grid')])["+num+"]"));
                isVisible(merPagina);
                String busqued = merPagina.getText();
                Log("prueba   :::: " + busqued);
            }
            scroll();
        }btnSiguiente.click();
        if(isVisible(listProd))
        {
            Log("Se visualizan los productos");
            for ( int num = 1; num <= 18; num = num+ 1 ){
                WebElement merPagina = driver.findElement (By.xpath("(//ol[contains(@class,'ui-search-layout ui-search-layout--grid')])["+num+"]"));
                isVisible(merPagina);
                String busqued = merPagina.getText();
                Log("prueba   :::: " + busqued);
            }
        }

    }
}
