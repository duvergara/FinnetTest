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

import junit.framework.Assert;

public class CadastroTestes {
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
				navegador.get("http://www.stilespeciale.com.br/");
	}
	
	@Test	
	public void testAdicionarCliente() throws InterruptedException{
				
		//Clicar no link que possui o texto Faça seu Login ou Cadastre-se
		//1 opção de clicar direto no link
		
		navegador.findElement(By.linkText("Faça seu Login ou Cadastre-se")).click();
		navegador.findElement(By.linkText("REALIZAR CADASTRO")).click();
		
//		WebElement linkLogin = navegador.findElement(By.linkText("Faça seu Login ou Cadastre-se"));	
//		WebElement linkRealizaCadastro = navegador.findElement(By.linkText("REALIZAR CADASTRO"));	
//		linkLogin.click();
//		linkRealizaCadastro.click();
		
		
	
	// Preenche dados
		navegador.findElement(By.id("NomeCompleto")).sendKeys("mauricio oliveira junior");
		navegador.findElement(By.id("Email")).sendKeys("mauricio@gmail.com");
		navegador.findElement(By.id("UserName")).sendKeys("ProfessorXavier");
		navegador.findElement(By.id("Senha")).sendKeys("123456");
		navegador.findElement(By.id("Documento_Valor")).sendKeys("38995063831");
		navegador.findElement(By.id("Documento_DtNasc")).sendKeys("30121989");
		navegador.findElement(By.id("Telefone_CodigoArea")).sendKeys("11");
		navegador.findElement(By.id("Telefone_Numero")).sendKeys("999999999");
		navegador.findElement(By.id("Endereco_Pais")).sendKeys("Brasil");
		navegador.findElement(By.id("Endereco_CEP")).sendKeys("04521000");
		Thread.sleep(2000);
		navegador.findElement(By.id("Endereco_Bairro")).click();
		Thread.sleep(2000);
		navegador.findElement(By.id("Endereco_Numero")).sendKeys("100");
		navegador.findElement(By.xpath("//input[@value=\"Cadastrar\"]")).click();
		Thread.sleep(2000);
	
	// Realiza login
	
		navegador.findElement(By.id("Username")).sendKeys("ProfessorXavier");
		navegador.findElement(By.id("Password")).sendKeys("123456");
		navegador.findElement(By.xpath("//button[text()=\"Logar\"]")).click();
				
		// Validação
		
//		WebElement UsuarioRepetido = navegador.findElement(By.xpath("//li[text()='Name Mauriciao is already taken.']"));
//		String ValidaRepetido = UsuarioRepetido.getText();
//		Assert.assertEquals("Name Mauriciao is already taken.", ValidaRepetido);
		
//		
		WebElement LinkLogin = navegador.findElement(By.xpath("//ul[@class=\"nav navbar-nav\"]"));
		String ValidaLogin = LinkLogin.getText();
		Assert.assertEquals("Bem Vindo ProfessorXavier!\r\n" + 
				"Sair\r\n" + 
				"Meus Pedidos\r\n", ValidaLogin);
		
		//Fechar Navegador
		//navegador.close fecha apenas a aba que vc está
//		navegador.close();		
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
