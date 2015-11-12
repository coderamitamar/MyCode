package prep;
import java.util.*;
class Vert{
	Vector<Integer> eList=new Vector<>();
}
public class SnakeLadderGame{
    public static void main(String[] args){
    	Scanner sc=new Scanner(System.in);
	    int n,m,t=sc.nextInt();
	    int ladder[][],snake[][];
	    while(t!=0){
	    	n=sc.nextInt();
	        ladder=new int[n][2];
	        for(int i=0;i<n;i++){
	        	ladder[i][0]=sc.nextInt();
	        	ladder[i][1]=sc.nextInt();
	        }
	        m=sc.nextInt();
	        snake=new int[m][2];
	        for(int i=0;i<m;i++){
	        	snake[i][0]=sc.nextInt();
	        	snake[i][1]=sc.nextInt();
	        }
	        SnakeLadder sl=new SnakeLadder(ladder,snake);
	        System.out.println(sl.CountRoll());
	        t--;
	    }
	    sc.close();
    }
}
class SnakeLadder{
	Vert vList[];
	int path[];
	int pathLength;
	SnakeLadder(int ladder[][],int snake[][]){
		vList=new Vert[101];
		path=new int[101];
		pathLength=0;
		initVertex(ladder,snake);
		doBfs();
	}
	public void initVertex(int ladder[][],int snake[][]){
		for(int i=1;i<100;i++){
			vList[i]=new Vert();
			vList[i].eList.add(i+1);
		}    
		vList[100]=new Vert();
		int size=ladder.length;
		for(int i=0;i<size;i++)
			vList[ladder[i][0]].eList.add(ladder[i][1]);
		size=snake.length;
		for(int i=0;i<size;i++)
			vList[snake[i][0]].eList.add(snake[i][1]);
	}
	public void doBfs(){
		Deque<Integer> q=new ArrayDeque<>();
		boolean visited[]=new boolean[101];
		q.addLast(1);
	    int buildPath[]=new int[101];
	    buildPath[1]=0;
	    int x,y;
	    while(!q.isEmpty()){
	    	x=q.removeFirst();
	    	if(visited[x]==false){
		        visited[x]=true;
		        if(x==100)
		        	break;
		        if(vList[x].eList.size()>=1){
		        	y=vList[x].eList.get(0);
			        buildPath[y]=x;
			        q.addLast(y);
			        if(vList[x].eList.size()==2){
			        	y=vList[x].eList.get(1);
			        	buildPath[y]=x;
			        	q.addLast(y);
			        }
			    }
	    	}
	    }
	    pathLength=0;
	    path[0]=100;
	    y=100;
	    x=1;
	    while(buildPath[y]!=0){
	    	path[x++]=buildPath[y];
	    	y=buildPath[y];
	    }
	    pathLength=x;
	}
	public int CountRoll(){
		for(int i=0;i<pathLength;i++)
			System.out.print(path[i]+" ");
		System.out.print("\n ");
		int temp,cnt=0;
		for(int i=pathLength-1;i>0;){
			temp=0;
			while(i>0){
				if(path[i-1]==(path[i]+1)){
					i--;
					temp++;
				}else{
					i--;
					break;
				}
			}
			cnt+=(temp/6 + 1);
		}
		return cnt;
	}
}