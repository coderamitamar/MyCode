package prep;
import java.util.*;
public class RemoveWhiteSpace {
	public static int removeWhiteSpace(char ar[]){
		int len=ar.length;
		int i=0,j=0;
		while(j<len){
			while(j<len && ar[j]==' ')	j++;
			while(j<len && ar[j]!=' '){
				ar[i]=ar[j];
				i++;
				j++;
			}
		}
		return i;
	}
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		char ar[]=str.toCharArray();
		int len=removeWhiteSpace(ar);
		for(int i=0;i<len;i++)
			System.out.print(ar[i]);
		sc.close();
	}
}