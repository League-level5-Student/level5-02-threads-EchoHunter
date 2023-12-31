package _02_Advanced_Robot_Race;

import java.util.Random;

import org.jointheleague.graphical.robot.Robot;

public class AdvancedRobotRace {
	// Re-do the robot race recipe from level 3 module 0. 
	// This time, use threads to make all of the robots go at the same time.
	public static void main(String[] args) {
		Robot[] robots = new Robot[5];
		int adder = 0;
		for (int z = 0; z < robots.length; z++) {
			robots[z] = new Robot(250+adder,600);
			robots[z].setSpeed(1000);
			adder = adder + 300;
		}
		Thread[] robThread = new Thread[5];
		Random rand = new Random();
		
		for (int i = 0; i < robThread.length; i++) {
			int k = i;
			robThread[i] = new Thread(()-> {
			while(isNotZero(robots[k])){
				robots[k].move(rand.nextInt(45)+5);
				}
			});
		}
		for (Thread r : robThread) {
			r.start();
		}
		}
	
	private static boolean isNotZero(Robot robots) {
				if(robots.getY()<=0) {
				return false;
		}
		return true;
	}
}
