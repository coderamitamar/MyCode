package prep;
import java.util.*;
import java.io.*;
public class LIS{
	public static int getCeilIndex(int A[],int T[],int l,int r,int key){
    	int m;
    	while(r-l>1){
    		m=l+(r-l)/2;
    		if(A[T[m]]>=key)	r=m;
    		else    			l=m;
    	}
    	return r;
    }
    public static int getLIS(int A[],int size){
    	int pos,len;
    	int tailIndices[]=new int[size];
    	int prevIndices[]=new int[size];
    	tailIndices[0]=0;
    	prevIndices[0]=-1;
    	len=1;
    	for(int i=1;i<size;i++){
    		if(A[i]<A[tailIndices[0]])
    			tailIndices[0]=i;
    		else if(A[i]>A[tailIndices[len-1]]){
    			prevIndices[i]=tailIndices[len-1];
    			tailIndices[len++]=i;
    		}else{
    			pos=getCeilIndex(A,tailIndices,-1,len-1,A[i]);
    			if(pos>0)
    				prevIndices[i]=tailIndices[pos-1];
    			tailIndices[pos]=i;
    		}
    	}
    	return len;
    }
    public static void main(String[] args) throws Exception{
    	File f1=new File("F:/Amit's stuff/PROGRAMS/Java programs/Programs by AKA/jRevisited/src/input.txt");
    	PrintStream out=new PrintStream(new FileOutputStream("F:/Amit's stuff/PROGRAMS/Java programs/Programs by AKA/jRevisited/src/output.txt"));
    	System.setOut(out);
    	Scanner sc=new Scanner(f1);
    	int N=sc.nextInt();
    	int a[]=new int[N];
    	for(int i=0;i<N;i++)
    		a[i]=sc.nextInt();
    	System.out.println(getLIS(a,N));
    	sc.close();
    }
}