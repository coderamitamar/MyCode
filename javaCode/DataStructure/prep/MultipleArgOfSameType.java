package prep;
import java.io.*;
import static java.lang.System.in;
//Ans to how to pass unknown no of same type of arguements in a function
//and changing System.in to in
public class MultipleArgOfSameType {
	public static void main(String args[]){
		BufferedReader br=new BufferedReader(new InputStreamReader(in));
		Prime.checkPrime(1,2,3,4,5);
	}
}
class Prime{
	public static boolean isPrime(int x){
		int y=(int)Math.sqrt(x);
		for(int i=2;i<=y;i++){
			if(x%i==0)
				return false;
		}
		return true;
	}
	public static void checkPrime(int ...a){
		int len=a.length;
		for(int i=0;i<len;i++){
			if(isPrime(a[i]))
				System.out.print(a[i]+" ");
		}
	}
}