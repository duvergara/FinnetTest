package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Loginpage {	
		private WebDriver navegador;
		public Loginpage (WebDriver navegador) {
			this.navegador = navegador;
			
		}
 
  public Loginpage clicAcessoCliente() throws Exception {
		 Thread.sleep(3000);
	  navegador.findElement(By.xpath("/html/body/nav/div[1]/ul/li[5]/button/span")).click();
	  
	  return this;
	  
	  
  }
  
  public Loginpage typeLogin(String login ) throws Exception {
	 Thread.sleep(3000);
		navegador.findElement(By.id("LoginAcesso")).sendKeys(login);
		
		return this;
	}
	
	public Loginpage typeSenha(String senha ) throws Exception {
		navegador.findElement(By.id("SenhaAcesso")).sendKeys(senha);
		Thread.sleep(10000);
		return this;
}
	
	public formPaineldoCliente acessarPainel() throws Exception   {
		 Thread.sleep(3000);
		navegador.findElement(By.id("BtnAcessar")).click();
		
		return new formPaineldoCliente(navegador);
		
	}
}