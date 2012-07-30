package project;

public class Boardspot {

	String type=null;
	int x=0,y=0;
	int maxX=7,maxY=7;
	Boardspot right=null,left=null;
	
	public Boardspot(int xa,int ya,String type) {
		// TODO Auto-generated constructor stub
		x=xa;
		y=ya;
		this.type=type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Boardspot getRight() {
		return right;
	}

	public void setRight(Boardspot[][] b) {
		if(x+1<=maxX && y+1<=maxY )
			this.right=b[x+1][y+1];
	}

	public Boardspot getLeft() {
		return left;
	}

	public void setLeft(Boardspot[][] b) {
		
		if(x+1<=maxX && y-1>=0 )
			this.left=b[x+1][y-1];
	}
	
	
	
	
	
	
}
