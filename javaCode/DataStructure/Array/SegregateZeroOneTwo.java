package Array;

public class SegregateZeroOneTwo {
	public static void segregateZeroOneTwo(int arr[]){
		int i=0,j=0,k=arr.length-1;
		while(j<=k){
			if(arr[j]==0){
				arr[i]=arr[i]^arr[j];
				arr[j]=arr[i]^arr[j];
				arr[i]=arr[i]^arr[j];
				i++;
				j++;
			}else if(arr[j]==2){
				arr[j]=arr[j]^arr[k];
				arr[k]=arr[j]^arr[k];
				arr[j]=arr[j]^arr[k];
				k--;
			}else
				j++;
		}
	}
	public static void main(String[] args){
		int arr[] = {0, 1, 2, 0, 1, 0, 0, 2, 1, 0, 0};
		segregateZeroOneTwo(arr);
		int len=arr.length;
		for(int i=0;i<len;i++)
			System.out.print(arr[i]+" ");
	}
}