package numberTheory;
import java.util.*;
public class PowerFunc{
	public static long getPow(long x,int y){
		long res=1;
		while(y!=0){
			if((y&1)!=0)
				res*=x;
			x*=x;
			y>>=1;
		}
		return res;
	}
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.println("To get x^y::");
		System.out.print("Enter x: ");
		int x=sc.nextInt();
		System.out.print("Enter y: ");
		int y=sc.nextInt();
		sc.close();
		System.out.println(getPow(x,y));
	}
}