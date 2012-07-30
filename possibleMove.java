package project;

public class possibleMove {

	String typeofSpot=null;
	int priority=-1;
	int xf=0,yf=0,xt=0,yt=0,rx=0,ry=0;
	
	public possibleMove(String type,int a,int b,int c,int d, int x) {
		// TODO Auto-generated constructor stub
		
		typeofSpot=type;
		xf=a;yf=b;xt=c;yt=d;
		priority=x;
	}
	
	public possibleMove(String type,int a,int b,int c,int d,int e,int f, int x) {
		// TODO Auto-generated constructor stub
		
		typeofSpot=type;
		xf=a;yf=b;xt=c;yt=d;rx=e;ry=f;
		priority=x;
	}
}
