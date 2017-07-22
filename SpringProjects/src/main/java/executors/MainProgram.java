package executors;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import components.GreetingComponent;
import configurations.GreetingConfiguration;
import interfaces.Language;
import services.GreetingService;

public class MainProgram {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new AnnotationConfigApplicationContext(GreetingConfiguration.class);
		Language language = (Language) context.getBean("language");
		
		System.out.println(language);
		System.out.println(language.getBye());
		
		System.out.println();
		System.out.println();
		
		GreetingService service = (GreetingService) context.getBean("greetingService");
		service.Greeting();
		
		System.out.println();
		System.out.println();
		
		GreetingComponent component = (GreetingComponent) context.getBean("greetingComponent");
		component.showAppInfo();
		
	}

}
