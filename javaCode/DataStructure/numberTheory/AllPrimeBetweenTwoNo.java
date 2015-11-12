package numberTheory;
import java.util.Scanner;

public class AllPrimeBetweenTwoNo {
	public static boolean isPrime(int x){
		if(x<=1)
			return false;
		int y=(int)Math.sqrt(x);
		for(int i=2;i<=y;i++){
			if(x%i==0)
				return false;
		}
		return true;
	}
	public static void main(String[] args) throws java.lang.Exception{
		Scanner sc=new Scanner(System.in);
		int m,n,t=sc.nextInt();
		while(t-->0){
			m=sc.nextInt();
			n=sc.nextInt();
			for(int i=m;i<=n;i++){
				if(isPrime(i))
					System.out.println(i);
			}
		}
		sc.close();
	}
}