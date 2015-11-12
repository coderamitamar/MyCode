package prep;
import java.util.Scanner;
import java.util.regex.*;

public class RegularExpr {
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		sc.close();
		String pattern="^[_a-zA-Z][_a-zA-Z0-9]{7,29}$";
		Pattern r=Pattern.compile(pattern);
		Matcher m=r.matcher(str);
		if(m.find() && str.length()<31)
			System.out.println("Valid");
		else
			System.out.println("Invalid");
	}
}
