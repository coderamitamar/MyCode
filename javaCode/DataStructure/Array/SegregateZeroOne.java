package Array;

public class SegregateZeroOne {
	public static void segregateZeroOne(int arr[]){
		int i=0,j=arr.length-1;
		while(i<j){
			if(arr[i]==1){
				if(arr[j]==0){
					arr[j]=1;
					arr[i]=0;
					i++;
					j--;
				}else
					j--;
			}else{
				i++;
			}
		}
	}
	public static void main(String[] args){
		int arr[] = {1, 1, 0, 1, 0, 0};
		segregateZeroOne(arr);
		int len=arr.length;
		for(int i=0;i<len;i++)
			System.out.print(arr[i]+" ");
	}
}