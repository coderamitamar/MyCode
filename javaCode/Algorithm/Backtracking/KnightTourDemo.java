package Backtracking;

class KnightTour{
	final int N=8;
	final int blockCnt=64;
	public void printSol(int sol[][]){
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++)
				System.out.print(sol[i][j]+"\t");
			System.out.println("\n");
		}
	}
	public boolean isSafe(int x,int y,int sol[][]){
		if(x>=0 && x<N && y>=0 && y<N && sol[x][y]==-1)
			return true;
		return false;
	}
	public boolean kTourUtil(int x,int y,int xMove[],int yMove[],int movei,int sol[][]){
		if(movei==blockCnt)
			return true;
		else{
			int xCord,yCord;
			for(int k=0;k<N;k++){
				xCord=x+xMove[k];
				yCord=y+yMove[k];
				if(isSafe(xCord,yCord,sol)==true){
					sol[xCord][yCord]=movei;
					if(kTourUtil(xCord,yCord,xMove,yMove,movei+1,sol)==true)
						return true;
					else
						sol[xCord][yCord]=-1;
				}
			}
			return false;
		}
	}
	public boolean kTour(int x,int y){
		int sol[][]=new int[N][N];
		//initialise the table
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				sol[i][j]=-1;
		//starting cell
		sol[x][y]=0;
		//Array of all possible moves from a cell
		int xMove[]={2,1,-1,-2,-2,-1,1,2};
		int yMove[]={1,2,2,1,-1,-2,-2,-1};
		//check if solution is possible
		if(kTourUtil(x,y,xMove,yMove,1,sol)==false){
			System.out.println("Solution not possible");
			return false;
		}else{
			System.out.println("Solution is:");
			printSol(sol);
			return true;
		}
	}
}
public class KnightTourDemo{
	public static void main(String[] args){
		KnightTour k=new KnightTour();
		k.kTour(0,0);
	}
}