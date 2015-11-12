package driver;
import java.util.*;
import string.KMP;;
public class KMPDriver {
	public static void main(String[] args){
		String text,pattern;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Text: ");
		text=sc.nextLine();
		System.out.println("Enter the pattern to be searched: ");
		pattern=sc.nextLine();
		sc.close();
		KMP kmp=new KMP(text);
		kmp.kmpSearch(pattern);
	}
}
/*
 	Enter the Text: ABABDABACDABABCABAB
	Enter the pattern to be searched: ABABCABAB
	Pattern matched at 10
*/