package string;
import java.util.*;
class MyTuple implements Comparable<MyTuple>{
	int origIndex;
	int firstHalf;
	int secondHalf;
	public int compareTo(MyTuple b){
		if(this.firstHalf==b.firstHalf)
			return (this.secondHalf<b.secondHalf)?-1:1;
		return (this.firstHalf<b.firstHalf)?-1:1;
	}
}
public class SuffixArray{
	public static int[] getSuffixArray(String s){
		int n=s.length();
		int suffixRank[][]=new int[20][n+5];
		MyTuple L[]=new MyTuple[n];
		int res[]=new int[n];
		for(int i=0;i<n;++i){
	        suffixRank[0][i]=s.charAt(i)-'a';
	        L[i]=new MyTuple();
		}
		int stp=1;
	    for(int cnt=1;cnt<n;cnt*=2,++stp){
	        for(int i=0;i<n;++i){
	            L[i].firstHalf =suffixRank[stp-1][i];
	            L[i].secondHalf=((i+cnt)<n)?suffixRank[stp-1][i+cnt]:-1;
	            L[i].origIndex=i;
	        }
	        Arrays.sort(L);
	        suffixRank[stp][L[0].origIndex]=0;
	        for(int i=1,currRank=0;i<n;++i){
	            if(L[i-1].firstHalf !=L[i].firstHalf || 
	               L[i-1].secondHalf!=L[i].secondHalf)
	                ++currRank;
			    suffixRank[stp][L[i].origIndex]=currRank;
	        }
	    }
	    for(int i=0;i<n;i++)
	    	res[i]=L[i].origIndex;
	    return res;
	}
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		sc.close();
		int n=str.length();
		int res[];
		res=getSuffixArray(str);
	    for(int i=0;i<n;i++){
	    	System.out.print(res[i]+" ");
	    }
	}
}