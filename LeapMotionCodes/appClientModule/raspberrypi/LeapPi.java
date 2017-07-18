package raspberrypi;
import java.net.*;
import java.io.*;
import javax.swing.JOptionPane;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class LeapPi {
	
	public static final int SERVER_PORT = 6347;
	public Robot robot;
	
	private ServerSocket goOnline(){
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(SERVER_PORT);
		} catch (IOException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Server: Error creating network connection", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		try {
			System.out.println("SERVER Online\nWaiting for gestures on: " + "192.168.0.100" + " : " + SERVER_PORT + "\n");
		} catch (Exception e) {
			// TODO: handle exception
		} 
		return serverSocket;
	}
	
	private void readInput(ServerSocket serverSocket){
		while(true){
			Socket socket = null;
			BufferedReader in = null;
			try {
				socket = serverSocket.accept();
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			} catch (IOException e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "Server: Error connecting network connection", "Error", JOptionPane.ERROR_MESSAGE);
				System.exit(-1);
			}
			try {
				String request = in.readLine();
				if (request.startsWith("(")){
					String subStr = request.substring(1, request.length() - 1);
					String[] coordinates = subStr.split(",");
					Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
					Float xPos = Float.parseFloat(coordinates[0]);
					Float yPos = Float.parseFloat(coordinates[1]);
					robot.mouseMove((int)(screen.width * xPos), (int)(screen.height - yPos * screen.height));
				}
				else if(request.equals("Click")){
					robot.mousePress(InputEvent.BUTTON1_MASK);
					robot.mouseRelease(InputEvent.BUTTON1_MASK);
				}
				else if(request.equals("Up")){
					robot.mouseWheel(-1);
				}
				else if(request.equals("Down")){
					robot.mouseWheel(1);
				}
				else if(request.equals("Swipe")){
					robot.keyPress(KeyEvent.VK_WINDOWS);
					robot.keyRelease(KeyEvent.VK_WINDOWS);
				}
			} catch (IOException e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "Server: Error communicating network connection", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public LeapPi(){
		try {
			robot = new Robot();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeapPi pi = new LeapPi();
		ServerSocket socket = pi.goOnline();
		if (pi != null){
			pi.readInput(socket);
		}
	}

}
