package prep;
import java.util.*;
public class WeekDay {
	public static int day(int d, int m, int y){
		int a[]={0,3,2,5,0,3,5,1,4,6,2,4};
	    if(m<3)	y-=1;
	    return (y+ y/4 - y/100 + y/400 + a[m-1] + d)%7;
	}
	public static void main(String[] args){
	    Scanner sc=new Scanner(System.in);
	    int t=sc.nextInt();    
	    int d=0,m=0,y=0;
	    while(t--!=0){
	    	d=sc.nextInt();
	    	m=sc.nextInt();
	    	y=sc.nextInt();
	    	System.out.println(day(d,m,y));
	    }
	    sc.close();
	}
}