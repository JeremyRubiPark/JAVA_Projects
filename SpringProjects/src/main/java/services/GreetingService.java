package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import interfaces.Language;

@Service
public class GreetingService {
	@Autowired
	private Language language;

	public GreetingService() {
	}
	
	public void Greeting() {
		String greeting = language.getGreeting();
		System.out.println(greeting);
	}
}
