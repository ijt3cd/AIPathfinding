import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

import world.Robot;
import world.World;

public class AIRobot extends Robot{

	private World world;
	private ArrayList<Point> bClosedList = new ArrayList<Point>();
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


//		super.makeGuess(check.getPt(), true);
		if(ping.equals("F")){
			ArrayList<Point> path = new ArrayList<Point>();
			while(check.getPrev()!=null){
				path.add(check.getPrev().getPt());
				check=check.getPrev();
			}
			Collections.reverse(path);
			for(Point p:path){
				super.move(p);
				super.move(world.getEndPos());
			}
			break;
		}
	}
		
		
	}
	
	public int hVal(Point p){
		int xDist = Math.abs(p.x-world.getEndPos().x);
		int yDist = Math.abs(p.y-world.getEndPos().y);
		return Math.max(xDist, yDist);
	}
	
	public void bStar(){
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
		String ping=null;
		
		if(check!=null){
		if(check.getPt()!=null){
		if(bOpenList.contains(check.getPt())){
			ping = "O";
			
		}
		else{
			ping = super.pingMap(check.getPt());
		}
		}
		}
		
		while(check==null||(check.getPt()==null||ping==null)||ping.equals("X")||bClosedList.contains(check.getPt())){
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

//		super.makeGuess(check.getPt(), true);
		if(ping.equals("F")){
			ArrayList<Point> path = new ArrayList<Point>();
			while(check.getPrev()!=null){
				path.add(check.getPrev().getPt());
				check=check.getPrev();
			}
			Collections.reverse(path);
			for(Point p:path){
				if(super.getPosition().equals(super.move(p))){
					bClosedList.add(p);
					bStar();
					
				}
				bOpenList.add(p);
				
			}
			super.move(world.getEndPos());
			return;
		}
	}
		
		
	}
	
	public void cStar(){
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
		int w = 0;
		int x = 0;
	while(true){
		++w;
		Point t  = new Point(current.x,  current.y+1);
		Point tr = new Point(current.x+1,current.y+1);
		Point tl = new Point(current.x-1,current.y+1);
		Point r  = new Point(current.x+1,current.y  );
		Point l  = new Point(current.x-1,current.y  );
		Point b  = new Point(current.x,  current.y-1);
		Point br = new Point(current.x+1,current.y-1);
		Point bl = new Point(current.x-1,current.y-1);
		

		
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
		
	
		
		while(check==null||check.getPt()==null||bClosedList.contains(check.getPt())){
			check = openNodeList.poll();
		}
		
		closedList.add(check.getPt());
		if(hVal(check.getPt())>=hVal(super.getPosition())){
//			super.makeGuess(super.getPosition(), false);
			closedList.add(super.getPosition());
			if(w-x==1){
				bClosedList.add(super.getPosition());
			}
		}
		
		
		if(super.getPosition().equals(super.move(check.getPt()))){
			++x;
//			bClosedList.add(check.getPt());
			if(openNodeList.isEmpty()){
//				bClosedList.add(super.getPosition());
//				super.makeGuess(super.getPosition(), false);
				
				cStar();
				break;
			}
		}


		current = super.getPosition();
//		super.makeGuess(check.getPt(), false);
		
		if(check.getPt().equals(world.getEndPos())){
			
			break;
		}
	
		
		//Look at all adjacent positions
		//Ignore the positions in closedList or wallList
		//pop the best move off of priority Q
		//Add current point to closed list and make the best move
		//repeat until wall is hit or end is found
		//if wall is hit, add wall and current position to 
	}
	
	}
	@Override
	public void travelToDestination() {
		
		if(!world.getUncertain()){
			aStar();
		}
		else{
			cStar();
		}
		
		

	}
		
	
	
	
	
	public static void main(String[] args) {
	
		try {
		World wo;
		wo = new World("TestCases/myInputFile4.txt", true);
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
