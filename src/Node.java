import java.awt.Point;

class Node implements Comparable<Node>{

	private Point pt;
	private int value;
	private int distFromStart;
	private int hVal;
	private Node prev;
	
	
	public Node(Point pt, int distFromStart, int hVal, Node prev) {
		this.pt = pt;
		this.value = distFromStart+hVal;
		this.distFromStart = distFromStart;
		this.hVal = hVal;
		this.prev = prev;
	}

	public Node getPrev() {
		return prev;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}

	public Point getPt() {
		return pt;
	}

	public void setPt(Point pt) {
		this.pt = pt;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getDistFromStart() {
		return distFromStart;
	}

	public void setDistFromStart(int distFromStart) {
		this.distFromStart = distFromStart;
	}

	public int gethVal() {
		return hVal;
	}

	public void sethVal(int hVal) {
		this.hVal = hVal;
	}

	@Override
	public int compareTo(Node other) {
		
		if(this.value<other.value){
			return -1;
		}
		if(this.value>other.value){
			return 1;
		}
		
		else{
			return 0;
		}
	}
	
	
	
	
	
}