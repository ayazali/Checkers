package project;


import java.util.Iterator;
import java.util.ArrayList;
import java.util.Random;

public class d_logic {

	/**
	 * @author Ayaz Ali Qureshi
	 * 
	 */
	
	Boardspot[][] board=new Boardspot[8][8];
	ArrayList<Boardspot> existingList=new ArrayList<Boardspot>();
	ArrayList<possibleMove> moves=new ArrayList<possibleMove>();
	int maxX=7,maxY=7;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		d_logic obj=new d_logic();
		obj.fillboard();
		obj.printer();
		obj.establishLinks();
		obj.makeMove();
		obj.tryWin();
		System.out.println(obj.isWin());

	}

	public void fillboard() {

		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {

				if (row % 2 != col % 2) {
					if (row < 3) 
						board[row][col]=new Boardspot(row, col, "White");

					else if (row > 4) 
						board[row][col]=new Boardspot(row, col, "Red");

					 else
						 board[row][col]=new Boardspot(row, col, "Empty");
					
				} else {
					board[row][col]=new Boardspot(row, col, "Empty");
				}

			}
		}

	}
	
public void establishLinks(){
		
		
		for(int row=0; row<8; row++){
			for(int col=0; col<8; col++){
				board[row][col].setRight(board);
				board[row][col].setLeft(board);
				
			}
				
		}
		
	}
public void calcSpots(){
	
	
	for(int row=0; row<8; row++){
		for(int col=0; col<8; col++){
				
			if(board[row][col].getType().equalsIgnoreCase("white"))
					existingList.add(board[row][col]);
		}
			
	}
	
}

/*

		public void fillboar(char[][] b) {

			for (int row = 0; row < 8; row++) {
				for (int col = 0; col < 8; col++) {

					if (row % 2 != col % 2) {
						if (row < 3) 
							b[row][col]='W';

						else if (row > 4) 
							b[row][col]='R';

						 else
							b[row][col]='E';
						
					} else {
						b[row][col]='E';
					}

				}
			}

		}
		*/
public void printer(){
		
		
		for(int row=0; row<8; row++){
			for(int col=0; col<8; col++){
				System.out.print(board[row][col].getType()+" ");
				
			}
				System.out.println(" ");
		}
		
	}
	
	public void valid_move(Boardspot box){
		
	
		
	if(box.right!=null && box.right.right!=null)
		if(box.right.type.equalsIgnoreCase("red"))
			if(box.right.right.type.equalsIgnoreCase("empty"))
					moves.add(new possibleMove("white", box.x, box.y, box.right.right.x, box.right.right.y,box.right.x,box.right.y, 1));
		
	if(box.left!=null && box.left.left!=null)
		if(box.left.type.equalsIgnoreCase("red"))
			if(box.left.left.type.equalsIgnoreCase("empty"))
					moves.add(new possibleMove("white", box.x, box.y, box.left.left.x, box.left.left.y,box.left.x, box.left.y, 1));

	if(box.right!=null)
		if(box.right.type.equalsIgnoreCase("empty"))
			moves.add(new possibleMove("white", box.x, box.y, box.right.x, box.right.y, 0));

	if(box.left!=null)	
		if(box.left.type.equalsIgnoreCase("empty"))
			moves.add(new possibleMove("white", box.x, box.y, box.left.x, box.left.y, 0));
}
	
	public boolean userValidmove(int xf,int yf,int xt,int yt){
		
		boolean res=false;
		
		if(xf-xt>1 && xt<=maxX && xt>=0 && yt<=7 && yt>=0){
			
			if(yt-yf>0){
				if(board[xf-1][yf+1].getType().equalsIgnoreCase("white")){
						
					board[xf][yf].setType("empty");
					board[xt][yt].setType("red");
					board[xf-1][yf+1].setType("empty");
					res=true;
					
				}
				
			
			}
			if(yt-yf<0){
				
				if(board[xf-1][yf-1].getType().equalsIgnoreCase("white")){
					
					board[xf][yf].setType("empty");
					board[xt][yt].setType("red");
					board[xf-1][yf-1].setType("empty");
					res=true;
					
				}
				
				
			}
			
		}
		if(xf-xt==1 && xt<=maxX && xt>=0 && yt<=7 && yt>=0){
			
			
			if(yt-yf>0 && board[xt][yt].getType().equalsIgnoreCase("empty")){
				
				board[xf][yf].setType("empty");
				board[xt][yt].setType("red");
				res=true;
				
			}
			if(yt-yf<0 && board[xt][yt].getType().equalsIgnoreCase("empty")){
				
				board[xf][yf].setType("empty");
				board[xt][yt].setType("red");
				res=true;
				
				
			}
			
			
			
		}
		
		
		return res;
	}
	
	
	public void makeMove(){
		
		calcSpots();
		printMoves();
		boolean movePerformed=false;
		
		
		Iterator<possibleMove> itr=moves.iterator();
			
	for(int i=0;i<moves.size();i++){
		
		possibleMove pm=moves.get(i);
	
			if(itr.next().priority==1 && movePerformed==false){
				
				movePerformed=true;
				board[pm.xf][pm.yf].setType("empty");
				board[pm.rx][pm.ry].setType("empty");
				board[pm.xt][pm.yt].setType("white");
				
				
			}
		}
		
		if(movePerformed==false)
		{
			
			Iterator<possibleMove> itrr=moves.iterator();
			Random rn=new Random();
			
			
		//for(int i =0; i<moves.size();i++){
			
			possibleMove pm=moves.get(rn.nextInt(moves.size()));
			
				if(pm.priority==0){
					movePerformed=true;
					board[pm.xf][pm.yf].setType("empty");
					board[pm.xt][pm.yt].setType("white");
					//break;
					
				}
			//}
			
		}
		
		existingList.clear();
		moves.clear();
	}
	
	
	
	public void printMoves(){
		
		Iterator<Boardspot> it=existingList.iterator();
				while(it.hasNext()){
			
			Boardspot temp=it.next();
			System.out.println(Integer.toString(temp.x)+" "+
			Integer.toString(temp.y));
			
			valid_move(temp);
		}
		
		
		for(int i=0; i<moves.size();i++){
			possibleMove temp=moves.get(i);
			System.out.println("Moving Sport "+temp.typeofSpot+" From:"+temp.xf+""+temp.yf+" To:"+temp.xt+""+temp.yt+" Move Priority: "+temp.priority);
		}
		
		
		
}
	public boolean isWin(){
		
		boolean res=false;
		
		String[] type={board[0][1].getType(),board[0][3].getType(),board[0][5].getType(),board[0][7].getType()};
		String[] type2={board[7][0].getType(),board[7][3].getType(),board[7][5].getType(),board[7][7].getType()};
		
		if(type[0].equalsIgnoreCase(type[1]) && type[2].equalsIgnoreCase(type[3]) && type[0].equalsIgnoreCase("red")  && type[2].equalsIgnoreCase("red") )
			res=true;
		
		if(type2[0].equalsIgnoreCase(type2[1]) && type2[2].equalsIgnoreCase(type2[3]) && type2[0].equalsIgnoreCase("white")  && type2[2].equalsIgnoreCase("white") )
			res=true;
		
		
		return res;
	
	}
	
	public void tryWin(){
		
		
		for(int row=0; row<8; row++)
			for(int col=0; col<8; col++)
			
				
				board[row][col].setType("empty");
				
		board[0][1].setType("red");
		board[0][3].setType("red");
		board[0][5].setType("red");
		board[0][7].setType("red");	
		
	}
	
	
	
	}


