package components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repositories.GreetingRepository;



@Component
public class GreetingComponent {
	@Autowired
	private GreetingRepository repository;
	
	public void showAppInfo() {
		System.out.println(repository.getAppName());
		System.out.println(repository.getSystemDateTime());
	}
}
