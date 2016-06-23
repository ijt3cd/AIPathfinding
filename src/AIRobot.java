import java.awt.Point;
import java.util.ArrayList;
import java.util.PriorityQueue;

import world.Robot;
import world.World;

public class AIRobot extends Robot{

	public void aStar(World w){
		//ping everything touching current point
		//calculate value of each pinged point
		//put each point onto an arrayList with value, in order
		//pop the lowest value point onto the closed list and ping its neighbors
		PriorityQueue<Node> openList = new PriorityQueue<Node>(w.numRows()*w.numCols());
		ArrayList<Point> closedList = new ArrayList<Point>();
		int distFromStart = 0;

		Point current = super.getPosition();
		Point t  = new Point(current.x,  current.y+1);
		Point tr = new Point(current.x+1,current.y+1);
		Point tl = new Point(current.x-1,current.y+1);
		Point r  = new Point(current.x+1,current.y  );
		Point l  = new Point(current.x-1,current.y  );
		Point b  = new Point(current.x,  current.y-1);
		Point br = new Point(current.x+1,current.y-1);
		Point bl = new Point(current.x-1,current.y-1);
		
		++distFromStart;
		
		openList.add(new Node(t,  distFromStart, hVal(t, w)));
		openList.add(new Node(tr, distFromStart, hVal(tr,w)));
		openList.add(new Node(tl, distFromStart, hVal(tl,w)));
		openList.add(new Node(r,  distFromStart, hVal(r, w)));
		openList.add(new Node(l,  distFromStart, hVal(l, w)));
		openList.add(new Node(b,  distFromStart, hVal(b, w)));
		openList.add(new Node(br, distFromStart, hVal(br,w)));
		openList.add(new Node(bl, distFromStart, hVal(bl,w)));
		

		
		
	}
	
	public int hVal(Point p, World w){
		int xDist = Math.abs(p.x-w.getEndPos().x);
		int yDist = Math.abs(p.y-w.getEndPos().y);
		return Math.max(xDist, yDist);
	}
	
	
	
	
	@Override
	public void travelToDestination() {
		System.out.println(super.pingMap(new Point(-1,-1)));
		System.out.println(super.pingMap(new Point(3,3)));
		super.move(new Point(3,3));
		
		

	}
	
	
	
	public static void main(String[] args) {
	
		try {
		World wo;
		wo = new World("TestCases/myInputFile3.txt", false);
		wo.createGUI(600, 600, 100);
		AIRobot aiRobot = new AIRobot();
		aiRobot.addToWorld(wo);
		System.out.println(wo.getEndPos());
		aiRobot.travelToDestination();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
