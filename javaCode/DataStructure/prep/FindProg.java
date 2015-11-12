package prep;
import java.util.*;
public class FindProg {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
    	int rem=1,count=1;
    	while(rem!=0){
    		rem=(rem*10+1)%num;
    		count++;
    	}
    	for(int i=0;i<count;i++){
    		System.out.print(1);
    	}
    	sc.close();
	}
}
