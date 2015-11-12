package driver;

import java.util.*;
import string.RabinKarp;;
public class RabinKarpDriver {
	public static void main(String[] args){
		String text,pattern;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Text: ");
		text=sc.nextLine();
		System.out.println("Enter the pattern to be searched: ");
		pattern=sc.nextLine();
		sc.close();
		RabinKarp rk=new RabinKarp();
		rk.rkSearch(text, pattern);
	}
}
/*
 	Enter the Text: ABABDABACDABABCABAB
	Enter the pattern to be searched: ABABCABAB
	Pattern matched at 10
*/