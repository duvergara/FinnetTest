package Pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import Pages.Loginpage;

public class formCadastrarUsuario {
	private WebDriver navegador;
	private By comboTipoinc;
	public formCadastrarUsuario(WebDriver navegador) {
		this.navegador = navegador;
		}
	
public formCadastrarUsuario clicarNovoUsuario() throws Exception {
	 Thread.sleep(6000);
	navegador.findElement(By.xpath("//*[@id=\"menu_itens\"]/div[2]/ul[1]/li[1]/a")).click();
	
	return this;
	
	
}

public formCadastrarUsuario incluirNovoUsuarioe() throws Exception {
Thread.sleep(8000);  
JavascriptExecutor js = (JavascriptExecutor)navegador;
js.executeScript("window.scrollBy(0,1000)","");
	navegador.findElement(By.className("format_buttons")).click();
	return   this;
	
}

public formCadastrarUsuario preencherCamposNovoUsuarioPf(String CPF) {
	
	WebElement campoTipoIncricao = comboTipoinc.findElement((SearchContext) By.name("usuario[usu_tipo_inscricao]"));
	new Select(campoTipoIncricao).selectByVisibleText("CPF");
	return this;
	
	
}
public formCadastrarUsuario txtIncricao1 (String incricao) throws Exception {
	Thread.sleep(6000);
	navegador.findElement(By.name("usuario[usu_inscricao]")).click();
	navegador.findElement(By.name("usuario[usu_inscricao]")).sendKeys(incricao);
	return this;
	
	
}

public formCadastrarUsuario txtNome (String nome) {
	navegador.findElement(By.name("usuario[usu_nome]")).sendKeys(nome);;
	return this;
	
	
}

public formCadastrarUsuario txtEmail (String email) {
	navegador.findElement(By.name("usuario[usu_email]")).sendKeys(email);;
	return this;
	
	
}

public formCadastrarUsuario txtCep (String cep) {
	navegador.findElement(By.name("usuario[usu_cep]")).sendKeys(cep);;
	return this;
	
	
}
public formCadastrarUsuario txtTelefone (String telefoe) {
	navegador.findElement(By.name("usuario[usu_telefone]")).sendKeys(telefoe);;
	return this;
}
public formCadastrarUsuario lupaBuscar () {
	
	navegador.findElement(By.xpath("//*[@id=\"frm_dados_usuario\"]/div[6]/p/a")).click();
	return this;
}
public formCadastrarUsuario txtNumero1 (String numero) {
	navegador.findElement(By.name("usuario[usu_numero]")).sendKeys(numero);;
	return this;

}


public formCadastrarUsuario txtComplemento (String complemento) {
	navegador.findElement(By.name("usuario[usu_telefone]")).sendKeys(complemento);
	return this;

			
}

public formCadastrarUsuario comboEstado(String estado) {
	
	WebElement comboestado = navegador.findElement(By.name("usuario[uf_id]"));
	new Select(comboestado).selectByValue(estado);
return this;
	
}

		public formCadastrarUsuario txtcidade (String cidade ) {
	navegador.findElement(By.name("usuario[usu_cidade]")).sendKeys(cidade);
	return this;
}

	
	public formCadastrarUsuario comboPerfil(String perfil) {
		
		WebElement comboestado = navegador.findElement(By.name("usuario[per_id]"));
		new Select(comboestado).selectByValue(perfil);
	return this;
	
}
	
	public 	formCadastrarUsuario salvarNovoUsuario() throws Exception {
		Thread.sleep(6000);
		navegador.findElement(By.id("avancar")).click();
		return this;
	}
	
	public formCadastrarUsuario addEmpresaria() throws Exception {
		Thread.sleep(6000);
		navegador.findElement(By.xpath("//*[@id=\"frm_vincular_empresa\"]/table/thead/tr/th[1]/a")).click();
		return this;
		
	}
	
	
	public formCadastrarUsuario avancarArea() throws Exception {
		Thread.sleep(6000);
		navegador.findElement(By.id("btn_empresa_vincular_avancar")).click();
		return this;
		
	}
		
		public formCadastrarUsuario addArea() throws Exception {
			Thread.sleep(8000);
			navegador.findElement(By.name("areas[]")).click();
			return this;
		}
		
		
			public formCadastrarUsuario salvarusuario() throws Exception {
				Thread.sleep(8000);
				navegador.findElement(By.xpath("//*[@id=\"tab_vincular_area\"]/div/input[3]")).click();
			
				return this;
	  
			}	
	
	
	
	
}