package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class formPaineldoCliente {
	
	private WebDriver navegador;

	  public formPaineldoCliente(WebDriver navegador){
		this.navegador = navegador;

}
	
	  public formPaineldoCliente listarUsuarios() {
		  
		  navegador.findElement(By.xpath("//*[@id=\"menu_itens\"]/div[2]/ul[1]/li[1]/a")).click();
		  
		  return this;
	  }
	  
	  
	  public formCadastrarUsuario incluirNovoUsuario() {
		  navegador.findElement(By.xpath("//*[@id=\"menu_content\"]/div[4]/div/div[2]/input[1]")).click();
		  
		  return new formCadastrarUsuario(navegador);
	  }

}
