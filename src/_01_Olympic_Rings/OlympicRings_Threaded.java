package _01_Olympic_Rings;

import java.awt.Color;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded {
	// Make A Program that uses Threads and robots to draw the Olympic rings. One robot should draw one ring simultaneously with the other 4 robots.
	public static void main(String[] args) {
		Robot rob1 = new Robot(400,500);
		Robot rob2 = new Robot (600,600);
		Robot rob3 = new Robot(800,500);
		Robot rob4 = new Robot(1000,600);
		Robot rob5 = new Robot(1200,500);
		rob1.setPenColor(Color.blue);
		rob2.setPenColor(Color.yellow);
		rob3.setPenColor(Color.black);
		rob4.setPenColor(Color.green);
		rob5.setPenColor(Color.red);
		Thread r1 = new Thread(() -> robCircle(rob1));
		Thread r2 = new Thread(() -> robCircle(rob2));
		Thread r3 = new Thread(() -> robCircle(rob3));
		Thread r4 = new Thread(() -> robCircle(rob4));
		Thread r5 = new Thread(() -> robCircle(rob5));
		
		r1.start();
		r2.start();
		r3.start();
		r4.start();
		r5.start();
		
	}
	private static void robCircle(Robot rob) {
		rob.turn(-45);
		rob.setSpeed(15);
		rob.setPenWidth(5);
		rob.penDown();
		for(int i = 0; i <360; i++) {
			rob.move(3);
			rob.turn(1);
		}
		rob.hide();
	}
}

