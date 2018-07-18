package classExercise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class facebook {
	
	static WebDriver driver;
	
	public static void main(String[] args) { 
     //configurar el navegador
		setUp("chrome","https://www.facebook.com");
		//iniciar sesion
		iniciarSesion("spawnd19@gmail.com","123456a!");
		//buscar a la persona
		buscarPersona("Marcela Alegria");
		//validar que exiate la persona que se busca
		validarPersona("Marcela Alegría");
		//enviar solicitud de amistad
		agragarAmigo("Marcela Alegría");
	}

	private static void setUp(String navegador, String url) {
		switch(navegador) {
			case"chrome":
				System.setProperty("webdriver.chrome.driver", "C:\\test_automation\\drivers\\chromedriver.exe");
				driver = new ChromeDriver();
			
				break;
			default:
				System.out.println("Ese navegador no existe");
				System.exit(-1);
				
		}
		driver.manage().timeouts().implicitlyWait(30,  TimeUnit.SECONDS);
		driver.get(url);
	}
		
	

	private static void iniciarSesion(String usuario, String password) {
		WebElement campoUsuario; //id=email
		WebElement campoPassword; //id="pass"
		WebElement botonLogin; //data-testid="royal_login_button"
		
		campoUsuario = driver.findElement(By.id("email"));
		campoPassword = driver.findElement(By.id("pass"));
		botonLogin = driver.findElement(By.xpath("//input[@data-testid='royal_login_button']"));
		
		campoUsuario.clear();
		campoUsuario.sendKeys(usuario);
		campoPassword.clear();
		campoPassword.sendKeys(password);
		botonLogin.click();
	}

	private static void buscarPersona(String persona) {
		
		WebElement buscarpersona;
		WebElement botonbuscar;
		
		buscarpersona = driver.findElement(By.xpath("//div[@class='innerWrap']//input[@class='_1frb']"));
		botonbuscar = driver.findElement(By.xpath("//button[@data-testid='facebar_search_button']"));
		
		buscarpersona.clear();
		buscarpersona.sendKeys(persona);
		botonbuscar.click();
		
	}

	private static void validarPersona(String valperson) {
		WebElement persona;
		
		persona = driver.findElement(By.linkText(valperson));
		
	}

	private static void agragarAmigo(String amigo) {
		
		WebElement agregaramigo;
		WebElement confirmar;
		
		driver.manage().timeouts().implicitlyWait(10,  TimeUnit.SECONDS);
		agregaramigo = driver.findElement(By.xpath("//button[@class='_42ft _4jy0 FriendRequestAdd addButton _4jy3 _517h _51sy']"));
		agregaramigo.click();
		driver.manage().timeouts().implicitlyWait(5,  TimeUnit.SECONDS);
		confirmar = driver.findElement(By.xpath("//button[@class='_42ft _4jy0 layerConfirm uiOverlayButton _4jy3 _4jy1 selected _51sy']"));
		confirmar.click();	
	}
	

}