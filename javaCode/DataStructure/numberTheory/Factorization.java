package numberTheory;
import java.util.*;
public class Factorization {
	public static Vector<Integer> factorize(long n){
		Vector<Integer> res=new Vector<Integer>();
		long sqrt=(long)Math.sqrt(n);
		for(int i=2;i<=sqrt;i++){
			while(n%i==0){
				res.add(i);
				n/=i;
			}
		}
		if(n!=1)
			res.add((int)n);
		return res;
	}
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		sc.close();
		System.out.println(factorize(n));
	}
}