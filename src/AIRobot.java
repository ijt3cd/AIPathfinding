import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

import world.Robot;
import world.World;

public class AIRobot extends Robot{

	private World world;
	private ArrayList bClosedList = new ArrayList<>();
	private ArrayList bOpenList = new ArrayList<>();
	
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
		Node check = null;
		
	while(true){
	
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
		openNodeList.add(new Node(t,  distFromStart, hVal(t),check));
		openPointList.add(t);
		}
		if(!closedList.contains(tr)&&!openPointList.contains(tr)){
		openNodeList.add(new Node(tr, distFromStart, hVal(tr),check));
		openPointList.add(tr);
		}
		if(!closedList.contains(tl)&&!openPointList.contains(tl)){
		openNodeList.add(new Node(tl, distFromStart, hVal(tl),check));
		openPointList.add(tl);
		}
		if(!closedList.contains(r)&&!openPointList.contains(r)){
		openNodeList.add(new Node(r,  distFromStart, hVal(r),check));
		openPointList.add(r);
		}
		if(!closedList.contains(l)&&!openPointList.contains(l)){
		openNodeList.add(new Node(l,  distFromStart, hVal(l),check));
		openPointList.add(l);
		}
		if(!closedList.contains(b)&&!openPointList.contains(b)){
		openNodeList.add(new Node(b,  distFromStart, hVal(b),check));
		openPointList.add(b);
		}
		if(!closedList.contains(br)&&!openPointList.contains(br)){
		openNodeList.add(new Node(br, distFromStart, hVal(br),check));
		openPointList.add(br);
		}
		if(!closedList.contains(bl)&&!openPointList.contains(bl)){
		openNodeList.add(new Node(bl, distFromStart, hVal(bl),check));
		openPointList.add(bl);
		}
		
		
		check = openNodeList.poll();
		String ping = super.pingMap(check.getPt());
		while((check.getPt()==null||ping==null)||ping.equals("X")){
			check = openNodeList.poll();
			ping = super.pingMap(check.getPt());
		}
		current=check.getPt();	
		closedList.add(check.getPt());
		distFromStart=check.getDistFromStart();

//		System.out.println(check.getPt());	
//		System.out.println(check.getValue());
		super.makeGuess(check.getPt(), true);
		if(ping.equals("F")){
			ArrayList<Point> path = new ArrayList<Point>();
			while(check.getPrev()!=null){
				path.add(check.getPrev().getPt());
				check=check.getPrev();
			}
			Collections.reverse(path);
//			System.out.println(path);
			for(Point p:path){
				super.move(p);
				super.move(world.getEndPos());
			}
			break;
		}
//		System.out.println(openNodeList.size());
	}
		
		
	}
	
	public int hVal(Point p){
		int xDist = Math.abs(p.x-world.getEndPos().x);
		int yDist = Math.abs(p.y-world.getEndPos().y);
		return Math.max(xDist, yDist);
	}
	
	public void bStar(){
//		System.out.println("uncertain case not yet handled");
		PriorityQueue<Node> openNodeList = new PriorityQueue<Node>(world.numRows()*world.numCols());
		ArrayList<Point> openPointList = new ArrayList<Point>();
		ArrayList<Point> closedList = new ArrayList<Point>();
		int distFromStart = 0;

		
		Point current = super.getPosition();
		Node check = null;
		
	while(true){
	
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
		openNodeList.add(new Node(t,  distFromStart, hVal(t),check));
		openPointList.add(t);
		}
		if(!closedList.contains(tr)&&!openPointList.contains(tr)){
		openNodeList.add(new Node(tr, distFromStart, hVal(tr),check));
		openPointList.add(tr);
		}
		if(!closedList.contains(tl)&&!openPointList.contains(tl)){
		openNodeList.add(new Node(tl, distFromStart, hVal(tl),check));
		openPointList.add(tl);
		}
		if(!closedList.contains(r)&&!openPointList.contains(r)){
		openNodeList.add(new Node(r,  distFromStart, hVal(r),check));
		openPointList.add(r);
		}
		if(!closedList.contains(l)&&!openPointList.contains(l)){
		openNodeList.add(new Node(l,  distFromStart, hVal(l),check));
		openPointList.add(l);
		}
		if(!closedList.contains(b)&&!openPointList.contains(b)){
		openNodeList.add(new Node(b,  distFromStart, hVal(b),check));
		openPointList.add(b);
		}
		if(!closedList.contains(br)&&!openPointList.contains(br)){
		openNodeList.add(new Node(br, distFromStart, hVal(br),check));
		openPointList.add(br);
		}
		if(!closedList.contains(bl)&&!openPointList.contains(bl)){
		openNodeList.add(new Node(bl, distFromStart, hVal(bl),check));
		openPointList.add(bl);
		}
		
		
		check = openNodeList.poll();
		String ping;
		if(bOpenList.contains(check.getPt())){
			ping = "O";
		}
		else{
			ping = super.pingMap(check.getPt());
		}
		while((check.getPt()==null||ping==null)||ping.equals("X")||bClosedList.contains(check.getPt())){
			check = openNodeList.poll();
			try
			{
				ping = super.pingMap(check.getPt());
			}
			catch (NullPointerException e)
			{
			     bStar();
			}
			
		}
		current=check.getPt();	
		closedList.add(check.getPt());
		distFromStart=check.getDistFromStart();

//		System.out.println(check.getPt());	
//		System.out.println(check.getValue());
//		super.makeGuess(check.getPt(), true);
		if(ping.equals("F")){
			ArrayList<Point> path = new ArrayList<Point>();
			while(check.getPrev()!=null){
				path.add(check.getPrev().getPt());
				check=check.getPrev();
			}
			Collections.reverse(path);
//			System.out.println(path);
			for(Point p:path){
				if(super.getPosition().equals(super.move(p))){
					bClosedList.add(p);
//					System.out.println("?");
					bStar();
					
				}
				bOpenList.add(p);
				
			}
			super.move(world.getEndPos());
			return;
		}
//		System.out.println(openNodeList.size());
	}
		
		
	}
	
	public void cStar(){
//		System.out.println("uncertain case not yet handled");
		PriorityQueue<Node> openNodeList = new PriorityQueue<Node>(world.numRows()*world.numCols());
		ArrayList<Point> openPointList = new ArrayList<Point>();
		ArrayList<Point> closedList = new ArrayList<Point>();
		int distFromStart = 0;

		
		Point current = super.getPosition();
		Node check = null;
		
	while(true){
	
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
		openNodeList.add(new Node(t,  distFromStart, hVal(t),check));
		openPointList.add(t);
		}
		if(!closedList.contains(tr)&&!openPointList.contains(tr)){
		openNodeList.add(new Node(tr, distFromStart, hVal(tr),check));
		openPointList.add(tr);
		}
		if(!closedList.contains(tl)&&!openPointList.contains(tl)){
		openNodeList.add(new Node(tl, distFromStart, hVal(tl),check));
		openPointList.add(tl);
		}
		if(!closedList.contains(r)&&!openPointList.contains(r)){
		openNodeList.add(new Node(r,  distFromStart, hVal(r),check));
		openPointList.add(r);
		}
		if(!closedList.contains(l)&&!openPointList.contains(l)){
		openNodeList.add(new Node(l,  distFromStart, hVal(l),check));
		openPointList.add(l);
		}
		if(!closedList.contains(b)&&!openPointList.contains(b)){
		openNodeList.add(new Node(b,  distFromStart, hVal(b),check));
		openPointList.add(b);
		}
		if(!closedList.contains(br)&&!openPointList.contains(br)){
		openNodeList.add(new Node(br, distFromStart, hVal(br),check));
		openPointList.add(br);
		}
		if(!closedList.contains(bl)&&!openPointList.contains(bl)){
		openNodeList.add(new Node(bl, distFromStart, hVal(bl),check));
		openPointList.add(bl);
		}
		
		
		check = openNodeList.poll();
		String ping="O";

//		else{
//			ping = super.pingMap(check.getPt());
//		}
		while((check.getPt()==null||ping==null)||ping.equals("X")||bClosedList.contains(check.getPt())){
			check = openNodeList.poll();
			try
			{
				ping = "O";
			}
			catch (NullPointerException e)
			{
			     cStar();
			}
			
		}
		current=check.getPt();	
		closedList.add(check.getPt());
		distFromStart=check.getDistFromStart();

//		System.out.println(check.getPt());	
//		System.out.println(check.getValue());
//		super.makeGuess(check.getPt(), true);
		if(ping.equals("F")){
			ArrayList<Point> path = new ArrayList<Point>();
			while(check.getPrev()!=null){
				path.add(check.getPrev().getPt());
				check=check.getPrev();
			}
			Collections.reverse(path);
//			System.out.println(path);
			for(Point p:path){
				if(super.getPosition().equals(super.move(p))){
					bClosedList.add(p);
//					System.out.println("?");
					cStar();
					
				}
				bOpenList.add(p);
				
			}
			super.move(world.getEndPos());
			return;
		}
//		System.out.println(openNodeList.size());
	}
		
		
	}
	
	
	@Override
	public void travelToDestination() {
		
		if(!world.getUncertain()){
			aStar();
		}
		else{
			bStar();
		}
		
		

	}
	
	
	
	public static void main(String[] args) {
	
		try {
		World wo;
		wo = new World("TestCases/myInputFile1.txt", true);
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
