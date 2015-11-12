package prep;
import java.util.*;
public class CheckPelindrome {
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
    	String s=sc.next();
    	int len=s.length();
    	int i=0,j=len-1;
    	boolean f=true;
    	while(i<j){
    		if(s.charAt(i)!=s.charAt(j)){
    			System.out.println("Not pelindrome");
    			f=false;
    			break;
    		}
    		i++;
    		j--;
    	}
    	if(f)	System.out.println("pelindrome");
    	sc.close();
	}
}
