package Test;

import PO.BasePage;
//import PO.PaginaInicio;
import PO.PaginaInicioBusqueda;
import PO.leectorProperties;
import io.github.bonigarcia.wdm.UrlFilter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.PropertyConfigurator;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Test_01 {

    String log4jConfPath = "./src/test/resources/log4j.properties";
    leectorProperties lec;
    WebDriver driver;
    PaginaInicioBusqueda pb;
    BasePage base;

    /**Datos por propiedades*/
    private final String url = lec.getDatoProperties("url");
    private final String busqueda = lec.getDatoProperties("camiseta");

    @BeforeAll
    public void SetUp() {
        System.setProperty("java.net.useSystemProxies", "true");

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();


        options.addArguments("--start-maximized");
        options.addArguments("--start-maximized","--ignore-certificate-errors","--incognito","--headless");
        options.addArguments("--lang=es");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        this.pb = new PaginaInicioBusqueda(driver);
        this.base = new BasePage(driver);


        }
    @AfterAll
    public void tear(){
        driver.close();
    }

    @AfterEach
    public void afterEach(TestInfo testinfo) throws Exception {
       // takeSnapShot(this.driver, this.getClass().getName()+"-"+testinfo.getDisplayName());
    }

    @Test
    @Order(1)
    public void Paso1() throws IOException {
        base.Log("Se inicia prueba");
        pb.IngresoPagina(url,busqueda);

    }


}
