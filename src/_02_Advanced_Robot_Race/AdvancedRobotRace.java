package _02_Advanced_Robot_Race;

import java.util.Random;

import org.jointheleague.graphical.robot.Robot;

public class AdvancedRobotRace {
	// Re-do the robot race recipe from level 3 module 0. 
	// This time, use threads to make all of the robots go at the same time.
	public static void main(String[] args) {
		Robot[] robots = new Robot[5];
		for (int z = 0; z < robots.length; z++) {
			robots[z] = new Robot(500,600);
			robots[z].setSpeed(1000);
		}
		Thread[] robThread = new Thread[5];
		Random rand = new Random();
		
		for (int i = 0; i < robThread.length; i++) {
			int k = i;
			robThread[i] = new Thread(()-> robots[k].move(rand.nextInt(45)+5));
		}
		while(isNotZero(robots)) {
		for(Thread th : robThread) {
			
		}
		}
	}
	private static boolean isNotZero(Robot[] robots) {
		for(Robot r : robots) {
			if(r.getY()<=0) {
				return false;
			}
		}
		return true;
	}
}
