import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Pages.Loginpage;
import Pages.formCadastrarUsuario;
import suporte.Generator;
import suporte.Screenshot;
import suporte.Web;


public class InformacoesPainelTest {
	
	private WebDriver navegador; 
		
		@Before
		public void setUp() {
			navegador = Web.creatChrome();
		}

		@Test
		public void  efetuarLogin() throws Exception{
			new Loginpage(navegador)
			.clicAcessoCliente()
			.typeLogin("candidato2.master")
			.typeSenha("candidato2@")
			.acessarPainel();
			 Thread.sleep(8000);
			    Screenshot.tirar(navegador, "/Users/emoisess/Desktop/stiletestes/test-reports/" + Generator.dataHoraparaArq()+ "efetuarlogin.png");
			   
		}
		

		@Test
			public void cadastrarUsuario() throws Exception {
				
			new Loginpage(navegador)
			 .clicAcessoCliente()
			 .typeLogin("candidato2.master")
			 .typeSenha("candidato2@")
			 .acessarPainel();
		    new formCadastrarUsuario(navegador)
		     .clicarNovoUsuario()
		     .incluirNovoUsuarioe()	
			.txtIncricao1("19932231944")
			.txtNome("eduardo moises")
			.txtEmail("teste@teste.com.br")
			.txtTelefone("1117531251")
			.txtCep("08390130")
			.lupaBuscar()
			.txtNumero1("13")
			.txtComplemento("complemento")
			.comboPerfil("5")
			.salvarNovoUsuario()
			.addEmpresaria()
			.avancarArea()
			.addArea()
			.salvarusuario();
		   navegador.manage().timeouts().implicitlyWait(6,TimeUnit.SECONDS);  
		   WebElement popup_text_alert = navegador.findElement(By.className("popup_text_alert"));
		   String validaMsg = popup_text_alert.getText();
		   assertEquals(validaMsg, "Operação Concluída com Sucesso.",validaMsg);
		    Screenshot.tirar(navegador, "/Users/emoisess/Desktop/stiletestes/test-reports/"+ Generator.dataHoraparaArq()+ "cadastrarusuario.png");
             Thread.sleep(8000);
			
			
		}
	
			
		@After
		        public void encerrarApp(){
				navegador.quit();;
			
		{
			
			
		
	}

}}
