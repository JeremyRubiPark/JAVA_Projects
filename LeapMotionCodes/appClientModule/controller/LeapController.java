package controller;

import java.io.IOException;

import com.leapmotion.leap.Controller;

import listener.LeapListener;

public class LeapController {
	public static void main(String[] args) {
		LeapListener listener = new LeapListener();
		Controller controller = new Controller();
		
		controller.addListener(listener);
		
		System.out.println("Press Enter to quit...");
		try {
			System.in.read();
			System.out.println("Trying to read from InputStream");
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
			controller.removeListener(listener);
		}
}
