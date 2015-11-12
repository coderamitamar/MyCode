package prep;
import java.util.*;
import java.text.*;
import java.io.*;
public class FileIO{
    public static void main(String[] args)throws Exception
    {
    	File f1=new File("F:/Amit's stuff/PROGRAMS/Java programs/Programs by AKA/jRevisited/src/input.txt");
        PrintStream out=new PrintStream(new FileOutputStream("F:/Amit's stuff/PROGRAMS/Java programs/Programs by AKA/jRevisited/src/output.txt"));
        System.setOut(out);
    	Scanner sc=new Scanner(f1);
    	int i=0,t=sc.nextInt();
    	double v,d,theta,g=9.8f;
    	double x;
    	String s;
    	DecimalFormat df=new DecimalFormat("#.0000000");
    	while(i!=t)
    	{
    		v=(float)sc.nextInt();
    		d=(float)sc.nextInt();
    		x=(d*g)/(v*v);
    		theta=Math.toDegrees(Math.asin(x>1?1:x))/2;
    		s=df.format(theta);
    		if(s.charAt(0)=='.')
    			s="0"+s;
    		System.out.println("Case #"+(i+1)+": "+s);
    		i++;
    	}
    	sc.close();
    }
}