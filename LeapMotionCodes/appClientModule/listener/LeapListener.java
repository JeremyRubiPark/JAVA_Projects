package listener;

import com.leapmotion.leap.Arm;
import com.leapmotion.leap.Bone;
import com.leapmotion.leap.CircleGesture;
import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Finger;
import com.leapmotion.leap.Finger.Type;
import com.leapmotion.leap.Frame;
import com.leapmotion.leap.Gesture;
import com.leapmotion.leap.GestureList;
import com.leapmotion.leap.Listener;
import com.leapmotion.leap.ScreenTapGesture;
import com.leapmotion.leap.SwipeGesture;
import com.leapmotion.leap.Tool;
import com.leapmotion.leap.Vector;
import com.leapmotion.leap.Gesture.State;
import com.leapmotion.leap.Hand;
import com.leapmotion.leap.InteractionBox;
import com.leapmotion.leap.KeyTapGesture;

import java.net.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.*;
import javax.swing.JOptionPane;


public class LeapListener extends Listener{
	
	private Socket socket;
	private PrintWriter out;
	private static final int SERVER_PORT = 6347;
	
	private void connectToServer(){
		try {
			socket = new Socket("192.168.0.100", SERVER_PORT);
			out = new PrintWriter(socket.getOutputStream());
			System.out.println("Trying to connect to server");
		} catch (IOException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "CLIENT: Cannot connect to server", "Error", JOptionPane.ERROR_MESSAGE);
			System.exit(-1);
		}
		
	}
	private void disconnectFromServer(){
		try {
			socket.close();
		} catch (IOException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "CLIENT: Cannot disconnect to server", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	private void updatePosition(String position){
		connectToServer();
		out.println(position);
		out.flush();
		disconnectFromServer();
	}
	private void click(){
		connectToServer();
		out.println("Click");
		out.flush();
		disconnectFromServer();
	}
	private void scrollUp(){
		connectToServer();
		out.println("Up");
		out.flush();
		disconnectFromServer();
	}
	private void scrollDown(){
		connectToServer();
		out.println("Down");
		out.flush();
		disconnectFromServer();
	}
	private void swipe(){
		connectToServer();
		out.println("Swipe");
		out.flush();
		disconnectFromServer();
	}
	public void onInit(Controller controller){
		System.out.println("Initialize");
	}
	public void onConnect(Controller controller){
		System.out.println("Connected");
		controller.enableGesture(Gesture.Type.TYPE_SWIPE);
		controller.enableGesture(Gesture.Type.TYPE_CIRCLE);
		controller.enableGesture(Gesture.Type.TYPE_KEY_TAP);
		controller.enableGesture(Gesture.Type.TYPE_SCREEN_TAP);
	}
	public void onDisconnect(Controller controller){
		System.out.println("Disconnected");
	}
	public void onExit(Controller controller){
		System.out.println("Exited");
	}
	public void onFrame(Controller controller){
		Frame frame = controller.frame();
//		System.out.println("Frame id: " + frame.id()
//		+ ", timestamp: " + frame.timestamp()
//		+ ", hands: " + frame.hands().count()
//		+ ", fingers: " + frame.fingers().count()
//		+ ", tools: " + frame.tools().count()
//		+ ", gestures " + frame.gestures().count());
//		
//		for (Hand hand : frame.hands()){
//			String handType = null;
//			if (hand.isLeft() == true){
//				handType = "Left hand";
//			}
//			else{
//				handType = "Right hand";
//			}
//			System.out.println(" " + handType + ", id: " + hand.id() + ", palm position: " + hand.palmPosition());
//			Vector normal = hand.palmNormal();
//			Vector direction = hand.direction();
//			
//			System.out.println(" pitch: " + Math.toDegrees(direction.pitch()) + " degrees, " + "roll: " + Math.toDegrees(normal.roll()) + " degrees, " + "yaw: " + Math.toDegrees(direction.yaw()) + " degrees");
//			
//			Arm arm = hand.arm();
//			System.out.println(" Arm direction: " + arm.direction() + ", wrist position: " + arm.wristPosition() + ", elbow position: " + arm.elbowPosition());
//			
//			for (Finger finger : hand.fingers()){
//				System.out.println("   " + finger.type() + ", id: " + finger.id() + ", length: " + finger.length() + "mm, width: " + finger.width() + "mm");
//				for(Bone.Type boneType : Bone.Type.values()){
//					Bone bone = finger.bone(boneType);
//					System.out.println("       " + bone.type() + " bone, start: " + bone.prevJoint() + ", end: " + bone.nextJoint() + ", direction: " + bone.direction());
//				}
//			}
//		}
//		for (Tool tool : frame.tools()){
//			System.out.println("  Tool id: " + tool.id() + ", position: " + tool.tipPosition() + ", direction: " + tool.direction());
//		}
//		
//		GestureList gestures = frame.gestures();
//		for (int i = 0; i < gestures.count() ; i ++){
//			Gesture gesture = gestures.get(i);
//			
//			switch (gesture.type()) {
//			case TYPE_CIRCLE:
//				CircleGesture circle = new CircleGesture(gesture);
//				String clockwiseness;
//				if (circle.pointable().direction().angleTo(circle.normal()) <= Math.PI/2){
//					clockwiseness = "Clockwise";
//				}
//				else{
//					clockwiseness = "CounterClockwise";
//				}
//				double sweptAngle = 0;
//				if (circle.state() != State.STATE_START){
//					CircleGesture previousUpdate = new CircleGesture(controller.frame(1).gesture(circle.id()));
//					sweptAngle = (circle.progress() - previousUpdate.progress()) * 2 * Math.PI;
//				}
//				System.out.println("  Circle id: " + circle.id() + ", " + circle.state() + ", progress: " + circle.progress() + ", radius: " + circle.radius() + ", angle: " + Math.toDegrees(sweptAngle) + ", " + clockwiseness);
//				break;
//
//			case TYPE_SWIPE:
//				SwipeGesture swipe = new SwipeGesture(gesture);
//				System.out.println("  Swipe id: " + swipe.id() + ", " + swipe.state() + ", position: " + swipe.position() + ", direction: " + swipe.direction() + ", speed: " + swipe.speed());
//				break;
//				
//			case TYPE_SCREEN_TAP:
//				ScreenTapGesture screenTap = new ScreenTapGesture(gesture);
//				System.out.println("  Screen Tap id: " + screenTap.id() + ", " + screenTap.state() + ", position: " + screenTap.position() + ", direction: " + screenTap.direction());
//				break;
//				
//			case TYPE_KEY_TAP:
//				KeyTapGesture keyTap = new KeyTapGesture(gesture);
//				System.out.println("  Key Tap id: " + keyTap.id() + ", " + keyTap.state() + ", position: " + keyTap.position() + ", direction: " + keyTap.direction());
//				break;
//				
//			default:
//				System.out.println("Unknown gesture type.");
//				break;
//			}
//		}
//		
//		if (!frame.hands().isEmpty() || !gestures.isEmpty()){
//			System.out.println();
//		}
		for (Finger finger : frame.fingers()) {
			if(finger.type() == Type.TYPE_INDEX && !finger.isExtended()) {
				Vector fingerPos = finger.stabilizedTipPosition();
				InteractionBox box = frame.interactionBox();
				fingerPos = box.normalizePoint(fingerPos);
				System.out.println(fingerPos.toString());
				updatePosition(fingerPos.toString());
			}
			else if(finger.type() == Type.TYPE_THUMB && !finger.isExtended()) {
				click();
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
		for(Gesture gesture : frame.gestures()) {
			if(gesture.type() == Gesture.Type.TYPE_CIRCLE) {
				CircleGesture circleGesture = new CircleGesture(gesture);
				if (circleGesture.pointable().direction().angleTo(circleGesture.normal()) <= Math.PI/4) {
					scrollDown();
					try {
						Thread.sleep(50);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				else {
					scrollUp();
				}
			}
			else if(gesture.type() == Gesture.Type.TYPE_SWIPE) {
				if(gesture.state() == State.STATE_STOP) {
					swipe();
					try {
						Thread.sleep(500);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				
			}
		}
 	}
}