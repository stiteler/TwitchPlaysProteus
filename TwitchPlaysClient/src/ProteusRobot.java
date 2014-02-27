import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;


public class ProteusRobot {
	Robot robot;
	private static int turnSleepTime = 4000;
	private static int moveSleepTime = 1500;
	
	public ProteusRobot() {
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
	
	public void turnLeft() throws InterruptedException {
		System.out.println("turning left");
		robot.keyPress(KeyEvent.VK_J);
		Thread.sleep(turnSleepTime);
		robot.keyRelease(KeyEvent.VK_J);
	}
	
	public void turnRight() throws InterruptedException {
		System.out.println("turning right");
		robot.keyPress(KeyEvent.VK_L);
		Thread.sleep(turnSleepTime);
		robot.keyRelease(KeyEvent.VK_L);
	}
	
	public void moveForward() throws InterruptedException {
		System.out.println("moving forward");
		robot.keyPress(KeyEvent.VK_W);
		Thread.sleep(moveSleepTime);
		robot.keyRelease(KeyEvent.VK_W);
	}
	
	public void moveBackwards() throws InterruptedException {
		System.out.println("moving Backwards");
		robot.keyPress(KeyEvent.VK_S);
		Thread.sleep(moveSleepTime);
		robot.keyRelease(KeyEvent.VK_S);
	}
	
	public void idle() throws InterruptedException {
		double prob = Math.random();
		if(prob < 0.5) {
			System.out.println("idling left");
			robot.keyPress(KeyEvent.VK_W);
			robot.keyPress(KeyEvent.VK_J);
			Thread.sleep(turnSleepTime);
			robot.keyRelease(KeyEvent.VK_W);
			robot.keyRelease(KeyEvent.VK_J);
		} else {
			System.out.println("idling right");
			robot.keyPress(KeyEvent.VK_W);
			robot.keyPress(KeyEvent.VK_L);
			Thread.sleep(turnSleepTime);
			robot.keyRelease(KeyEvent.VK_W);
			robot.keyRelease(KeyEvent.VK_L);
		}
		
		
	}
	
	public void stop() throws InterruptedException {
		System.out.println("stopping");
		robot.keyPress(KeyEvent.VK_W);
		robot.keyPress(KeyEvent.VK_S);
		Thread.sleep(moveSleepTime);
		robot.keyRelease(KeyEvent.VK_W);
		robot.keyRelease(KeyEvent.VK_S);
	}
}
