package suporte;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Web {
	public static WebDriver creatChrome() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\emoisess\\Desktop\\stiletestes\\driver\\chromedriver.exe");
		WebDriver navegador = new ChromeDriver();
		navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		navegador = new ChromeDriver(chromeOptions);
		
				
		//Navegando para a página 
		navegador.get("http://showroom-painelfornecedor.finnet.com.br/");	
		
		return navegador;
		
	}

}
