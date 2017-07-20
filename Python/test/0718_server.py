'''
Created on Jul 18, 2017

@author: student
'''
import socket
import sys

def main():
    # import RPi.GPIO as GPIO

    """socket"""
    serverSocket = socket.socket()
    # host = socket.gethostname()
    host = "192.168.0.100"
    port = 10000
    hp = (host, port)
    serverSocket.bind(hp)

    serverSocket.listen(5)
    """socket"""

# GPIO
    """
    pin = 18
    GPIO.setmode(GPIO.BCM)
    GPIO.setup(pin, GPIO.OUT)
    motor = GPIO.PWM(pin, 50)
    """
# GPIO
    ascii_letters = 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ'
    while True:
        try:
            c, addr = serverSocket.accept()
            print 'Got connection from ', addr

        # time.sleep(1)
        # motor.start(7.5)
        # time.sleep(1)



            c.send('Thank you for connecting')

            #initial_speed
            speed = 0
            while True:
                result_str = c.recv(1024)

                if len(result_str) != 0:
                    angle = int(result_str)
                    print angle
                    speed = 1.8 * abs(angle)
                    if 0<angle<=180:
                        #left rotation
                        #car turns left
                        #default speed
                        speed = 50
                        pass
                    elif -180<=angle<0:
                        #right rotation
                        #car turns right
                        #default speed
                        speed = 50
                        pass
                    else:
                        #stop
                        speed = 0
                        pass
                         
            # direction = c.recv(1024)
            # direction = int(direction)
            # time.sleep(1)
            # if direction != None :
                # print direction
                if result_str == "exit":
                    c.close()
        except KeyboardInterrupt:
            print 'Server terminates'
            sys.exit(0)
        except socket.error, IOError:
            print 'Client requires disconnection'


if __name__ == '__main__':
    main()
