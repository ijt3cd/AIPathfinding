import java.awt.Point;

import world.Robot;
import world.World;

public class AIRobot extends Robot{

	public void travelToDestination() {
		super.pingMap(new Point(5,3));
		super.move(new Point(3,7));
		super.move(new Point(3,8));
	}
	
	
	
	public static void main(String[] args) {
	
		try {
		World wo;
		wo = new World("TestCases/myInputFile3.txt", false);
		wo.createGUI(600, 600, 100);
		AIRobot aiRobot = new AIRobot();
		aiRobot.travelToDestination();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
