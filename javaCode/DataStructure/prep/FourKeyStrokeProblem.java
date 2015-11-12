package prep;
import java.util.*;
//There are four key strokes A,Ctrl+A(Selects all),
//Ctrl+C(Copy selected),Ctrl+V(Paste copied)
//How many chars can you print on the screen using N key Strokes
public class FourKeyStrokeProblem {
	public static long getCountOfChar(int n){
		if(n<=6)
			return n;
		long curr=0;
		long screen[]=new long[n];
		for(int i=1;i<=6;i++)
			screen[i-1]=i;
		for(int i=7;i<=n;i++){
			screen[i-1]=0;
			for(int j=n-3;j>=1;j--){
				curr=(i-j-1)*screen[j-1];
				if(curr>screen[i-1])
					screen[i-1]=curr;
			}
		}
		return screen[n-1];
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		System.out.println(getCountOfChar(n));
		sc.close();
	}
}