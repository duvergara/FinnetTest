package gear.host.stilespeciale;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class VendaTestes {
	private WebDriver navegador; 
	
	@Before
	public void setup() {
		//Abrindo o navegador 
				System.setProperty("webdriver.chrome.driver", "c:\\temp\\driver\\chromedriver.exe");
				navegador = new ChromeDriver();
				navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				
				
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--start-maximized");
				navegador = new ChromeDriver(chromeOptions);
				
				//Navegando para a página 
				navegador.get("http://www.stilespeciale.com.br");
	}
	
	@Test	
	public void testVendaComFrete() throws InterruptedException{
		
		navegador.findElement(By.linkText("Calças")).click();
		Thread.sleep(2000);
		navegador.findElement(By.xpath("//img[@src='/Stile/Calça em Ribana Cinza.jpg']")).click();
		Thread.sleep(2000);
		navegador.findElement(By.xpath("//button[@class='btn btn-success btn-lg']")).click();
		Thread.sleep(2000);
//		navegador.findElement(By.xpath("//a[@id='cartMenu']")).click();
//		Thread.sleep(2000);
//		navegador.findElement(By.xpath("//a[text()='Fechar o pedido']")).click();
//		Thread.sleep(2000);
		
		//Login
		navegador.findElement(By.id("Username")).sendKeys("Mauricio301289");
		navegador.findElement(By.id("Password")).sendKeys("cavalo02");
		navegador.findElement(By.xpath("//button[text()=\"Logar\"]")).click();
		Thread.sleep(2000);
		
		//Fechar Pedido
		navegador.findElement(By.xpath("//input[@value='Fechar o pedido']")).click();
		Thread.sleep(2000);
		
		//PagSeguro
		
		//Valida se Frete é exibido
		navegador.findElement(By.id("user")).sendKeys("mauricio.oliveira301289@gmail.com");
		navegador.findElement(By.id("hasNotAccount")).click();
		navegador.findElement(By.xpath("//button[text()='Pagar com segurança']")).click();
		Thread.sleep(4000);
		
		
		
		WebElement Frete = navegador.findElement(By.xpath("//h1[text()='Escolha o frete']"));
		Assert.assertTrue(Frete.isDisplayed());
		navegador.findElement(By.id("paymentMethod_booklet")).click();
		navegador.findElement(By.xpath("//button[text()='Gerar boleto']")).click();
		Thread.sleep(20000);
		navegador.findElement(By.xpath("//a[@id='backToShop']")).click();
		Thread.sleep(2000);
		
		//Valida Compra concluida com sucesso
		
		WebElement UsuarioRepetido = navegador.findElement(By.xpath("//h2[text()='Obrigado!']"));
		String CompraSucesso = UsuarioRepetido.getText();
		Assert.assertEquals("Obrigado!", CompraSucesso);
		
		navegador.quit();
						
	}
	
	@Test	
	public void testVendaSemFrete() throws InterruptedException{
		
		navegador.findElement(By.linkText("Calças")).click();
		Thread.sleep(2000);
		navegador.findElement(By.xpath("//img[@src='/Stile/Calça em Ribana Cinza.jpg']")).click();
		Thread.sleep(2000);
		navegador.findElement(By.xpath("//button[@class='btn btn-success btn-lg']")).click();
		Thread.sleep(2000);
		navegador.findElement(By.xpath("//a[@id='cartMenu']")).click();
		Thread.sleep(2000);
		navegador.findElement(By.xpath("//a[text()='Fechar o pedido']")).click();
		Thread.sleep(2000);
		
		//Login
		navegador.findElement(By.id("Username")).sendKeys("Mauricio301289");
		navegador.findElement(By.id("Password")).sendKeys("cavalo02");
		navegador.findElement(By.xpath("//button[text()=\"Logar\"]")).click();
		Thread.sleep(2000);
		
		//Fechar Pedido
		navegador.findElement(By.id("EntregaMetro")).click();
		Thread.sleep(2000);
		navegador.findElement(By.xpath("//input[@value='Fechar o pedido']")).click();
		Thread.sleep(2000);
		
		//PagSeguro
		
		//Valida se Frete é exibido
		navegador.findElement(By.id("user")).sendKeys("mauricio.oliveira301289@gmail.com");
		navegador.findElement(By.id("hasNotAccount")).click();
		navegador.findElement(By.xpath("//button[text()='Pagar com segurança']")).click();
		Thread.sleep(4000);
		
		WebElement Frete = navegador.findElement(By.xpath("//h1[text()='Escolha o frete']"));	
		Assert.assertFalse(Frete.isDisplayed());
		
	
		navegador.findElement(By.id("paymentMethod_booklet")).click();
		navegador.findElement(By.xpath("//button[text()='Gerar boleto']")).click();
		Thread.sleep(20000);
		navegador.findElement(By.xpath("//a[@id='backToShop']")).click();
		Thread.sleep(2000);
		
		//Valida Compra concluida com sucesso
		
		WebElement MsgObrigado = navegador.findElement(By.xpath("//h2[text()='Obrigado!']"));
		String CompraSucesso = MsgObrigado.getText();
		Assert.assertEquals("Obrigado!", CompraSucesso);
		
		navegador.quit();
						
	}
	
	@After
	public void tearDown() {
		//Fechar Navegador
				//navegador.close fecha apenas a aba que vc está
//				navegador.close();		
				navegador.quit();
		
	}
}
