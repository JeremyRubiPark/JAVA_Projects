package configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import classses.English;
import interfaces.Language;

@Configuration
@ComponentScan({"repositories","components","services"})
public class GreetingConfiguration {
	
	@Bean(name = "language")
	public Language getLanguage() {
		return new English();
	}
}
