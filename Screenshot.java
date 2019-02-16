package suporte;

import java.io.File;
import org.apache.commons.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class Screenshot {
public static void tirar(WebDriver navegador, String arquivo) {
	File sreenshot = ((TakesScreenshot)navegador).getScreenshotAs(OutputType.FILE);
	try {	
		
		Files.copy(sreenshot, new File(arquivo));
		
	} catch (Exception e) {
		System.out.println("Falha no arquivo" + e.getMessage());	
	}

}
}
