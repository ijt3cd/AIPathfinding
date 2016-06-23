import java.awt.Point;
import java.util.ArrayList;
import java.util.PriorityQueue;

import world.Robot;
import world.World;

public class AIRobot extends Robot{

	private World world;
	
	@Override
	public void addToWorld(World world){
		super.addToWorld(world);
		this.world = world;
	}
	
	public void aStar(){
		//ping everything touching current point
		//calculate value of each pinged point
		//put each point onto an arrayList with value, in order
		//pop the lowest value point onto the closed list and ping its neighbors
		PriorityQueue<Node> openNodeList = new PriorityQueue<Node>(world.numRows()*world.numCols());
		ArrayList<Point> openPointList = new ArrayList<Point>();
		ArrayList<Point> closedList = new ArrayList<Point>();
		int distFromStart = 0;

		
		Point current = super.getPosition();
		
	for(int i = 0; i < 30; i++){
	
		Point t  = new Point(current.x,  current.y+1);
		Point tr = new Point(current.x+1,current.y+1);
		Point tl = new Point(current.x-1,current.y+1);
		Point r  = new Point(current.x+1,current.y  );
		Point l  = new Point(current.x-1,current.y  );
		Point b  = new Point(current.x,  current.y-1);
		Point br = new Point(current.x+1,current.y-1);
		Point bl = new Point(current.x-1,current.y-1);
		
		++distFromStart;
		
		if(!closedList.contains(t)&&!openPointList.contains(t)){
		openNodeList.add(new Node(t,  distFromStart, hVal(t)));
		openPointList.add(t);
		}
		if(!closedList.contains(tr)&&!openPointList.contains(tr)){
		openNodeList.add(new Node(tr, distFromStart, hVal(tr)));
		openPointList.add(tr);
		}
		if(!closedList.contains(tl)&&!openPointList.contains(tl)){
		openNodeList.add(new Node(tl, distFromStart, hVal(tl)));
		openPointList.add(tl);
		}
		if(!closedList.contains(r)&&!openPointList.contains(r)){
		openNodeList.add(new Node(r,  distFromStart, hVal(r)));
		openPointList.add(r);
		}
		if(!closedList.contains(l)&&!openPointList.contains(l)){
		openNodeList.add(new Node(l,  distFromStart, hVal(l)));
		openPointList.add(l);
		}
		if(!closedList.contains(b)&&!openPointList.contains(b)){
		openNodeList.add(new Node(b,  distFromStart, hVal(b)));
		openPointList.add(b);
		}
		if(!closedList.contains(br)&&!openPointList.contains(br)){
		openNodeList.add(new Node(br, distFromStart, hVal(br)));
		openPointList.add(br);
		}
		if(!closedList.contains(bl)&&!openPointList.contains(bl)){
		openNodeList.add(new Node(bl, distFromStart, hVal(bl)));
		openPointList.add(bl);
		}
		
		Node check = openNodeList.poll();
	
		current=check.getPt();
		
		closedList.add(check.getPt());
		distFromStart=check.getDistFromStart();
		System.out.println(check.getPt());
//		System.out.println(check.getValue());
//		System.out.println(super.pingMap(check.getPt()));
//		System.out.println(openNodeList.size());
	}
		
		
	}
	
	public int hVal(Point p){
		int xDist = Math.abs(p.x-world.getEndPos().x);
		int yDist = Math.abs(p.y-world.getEndPos().y);
		return Math.max(xDist, yDist);
	}
	
	
	
	
	@Override
	public void travelToDestination() {
//		super.pingMap(new Point(-1,-1));
//		super.pingMap(new Point(3,3));
//		super.move(new Point(3,3));
//		
		aStar();
		
		

	}
	
	
	
	public static void main(String[] args) {
	
		try {
		World wo;
		wo = new World("TestCases/myInputFile3.txt", false);
		wo.createGUI(600, 600, 100);
		AIRobot aiRobot = new AIRobot();
		aiRobot.addToWorld(wo);
		aiRobot.travelToDestination();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
