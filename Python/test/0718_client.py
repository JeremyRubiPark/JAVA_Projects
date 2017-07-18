'''
Created on Jul 18, 2017

@author: student
'''

import socket
import sys
sys.path.insert(0, "lib")
import Leap
from Leap import CircleGesture, KeyTapGesture, ScreenTapGesture, SwipeGesture

class LeapMotionRcCar(Leap.Listener):
    ##############################


    ##############################

    """socket"""
    clientSocket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

    host = "192.168.0.100"
    port = 10000
    hp = (host, port)

    clientSocket.connect(hp)
    print clientSocket.recv(1024)

    """socket"""

    #user defined method
    def send_finger_data_to_server(self, frame, clientSocket):
        for hand in frame.hands:
            handType = "Left hand" if hand.is_left else "Right hand"

            result_str = ""+handType+""+str(hand.id)+""+str(hand.palm_position)
            if result_str != "" or result_str != None:
                clientSocket.send(result_str)

    def on_init(self, controller):
        print "Initialized"

    def on_connect(self, controller):
        print "Connected"

    def on_disconnect(self, controller):
        print "Exited"

    def on_frame(self, controller):
        frame = controller.frame()

        self.send_finger_data_to_server(frame, self.clientSocket)

def main():
    listener = LeapMotionRcCar()
    controller = Leap.Controller()

    controller.add_listener(listener)
    print "Press Enter to quit...."
    try:
        sys.stdin.readline()
    except KeyboardInterrupt:
        pass
    finally:
        listener.clientSocket.send("exit")
        print "Exited"
        controller.remove_listener(listener)


if __name__ == "__main__":
    main()