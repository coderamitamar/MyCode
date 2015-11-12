package Array;
import java.util.Arrays;

public class SumClosestToZero {
	public static void getClosestSumPair(int arr[]){
		int brr[]=arr.clone();
		Arrays.sort(brr);
		int i=0,j=brr.length-1;
		int x=0,y=j;
		int min=Integer.MAX_VALUE;
		while(i<j){
			if(min>Math.abs(brr[i]+brr[j])){
				min=Math.abs(brr[i]+brr[j]);
				x=brr[i];
				y=brr[j];
			}
			if(brr[i]+brr[j]<0)
				i++;
			else
				j--;
		}
		System.out.println(x+" "+y);
	}
	public static void main(String[] args){
		int arr[]={1,3,2,3,5,7,5};
		getClosestSumPair(arr);
	}
}