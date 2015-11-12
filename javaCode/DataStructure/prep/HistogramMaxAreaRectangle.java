package prep;
import java.util.*;
class Stk{
	int height;
    int index;
    public Stk(int h,int i){
    	height=h;
    	index=i;
    }
}
public class HistogramMaxAreaRectangle{
    public static void main(String[] args){
    	Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int A[]=new int[N];
        for(int i=0;i<N;i++)
        	A[i]=sc.nextInt();
        sc.close();
        Stk s[]=new Stk[N];
        int i,top=-1,left,currArea,maxArea=-1;
        for(i=0;i<=N;i++){
            while(top>=0 && (i==N || s[top].height>A[i])){
                if(top>0)
                    left=s[top-1].index;
                else
                    left=-1;
                currArea=(i-left-1)*s[top].height;
                --top;
                if(currArea>maxArea)
                    maxArea=currArea;
            }
            if(i<N){
                ++top;
                s[top]=new Stk(A[i],i);
            }
        }
        System.out.println(maxArea);
    }
}