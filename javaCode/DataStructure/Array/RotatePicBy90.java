package Array;

public class RotatePicBy90 {
	public static void rotate(int arr[][],int brr[][]){
		int r=arr.length;
		int c=arr[0].length;
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				brr[j][r-i-1]=arr[i][j];
			}
		}
	}
	public static void display(int arr[][]){
		int r=arr.length;
		int c=arr[0].length;
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				System.out.printf("%3d",arr[i][j]);
			}
			System.out.println();
		}
	}
	public static void main(String[] args){
		int arr[][]={ { 1, 2, 3, 4},
					  { 5, 6, 7, 8},
					  { 9,10,11,12}
					};
		int brr[][]=new int[4][3];
		display(arr);
		rotate(arr,brr);
		System.out.println();
		display(brr);
	}
}