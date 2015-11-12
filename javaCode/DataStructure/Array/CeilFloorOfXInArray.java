package Array;

public class CeilFloorOfXInArray {
	public static int ceilSearch(int arr[],int low,int high,int x){
		if(x<=arr[low])
			return low;
		if(x>arr[high])
			return -1;
		int mid=low+(high-low)/2;
		if(x==arr[mid])
			return mid;
		else if(arr[mid]<x){
			if((mid+1)<=high && x<=arr[mid+1])
				return mid+1;
			else
				return ceilSearch(arr,mid+1,high,x);
		}else{
			if(low<=(mid-1) && arr[mid-1]<x)
				return mid;
			else
				return ceilSearch(arr,low,mid-1,x);
		}
	}
	public static int floorSearch(int arr[],int low,int high,int x){
		if(x<arr[low])
			return -1;
		if(arr[high]<=x)
			return high;
		int mid=low+(high-low)/2;
		if(x==arr[mid])
			return mid;
		else if(arr[mid]<x){
			if((mid+1)<=high && x<arr[mid+1])
				return mid;
			else
				return floorSearch(arr,mid+1,high,x);
		}else{
			if(low<=(mid-1) && arr[mid-1]<=x)
				return mid-1;
			else
				return floorSearch(arr,low,mid-1,x);
		}
	}
	public static void main(String[] args){
		int arr[] = {1, 2, 8, 10, 10, 12, 19};
		   int n = arr.length;
		   int x = 11;
		   int index = ceilSearch(arr,0,n-1,x);
		   if(index == -1)
		     System.out.printf("Ceiling of %d doesn't exist in array ", x);
		   else 
			   System.out.printf("ceiling of %d is %d", x, arr[index]);
		   System.out.println();
		   index = floorSearch(arr,0,n-1,x);
		   if(index == -1)
		     System.out.printf("Flooring of %d doesn't exist in array ", x);
		   else 
			   System.out.printf("Flooring of %d is %d", x, arr[index]);
	}
}