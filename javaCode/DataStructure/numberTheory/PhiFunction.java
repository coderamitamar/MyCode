package numberTheory;
import java.util.*;
public class PhiFunction {
	public static long phi(long n){
		long res=n;
		long sqrt=(long)Math.sqrt(res);
		for(int i=2;i<=sqrt;i++){
			if(n%i==0){
				while(n%i==0)	n/=i;
				res-=res/i;
			}
		}
		if(n!=1){
			res-=res/n;
		}
		return res;
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		sc.close();
		System.out.println(phi(n));
	}
}
