package Array;

public class InversionCount {
	public static int getInvCount(int arr[]){
		int temp[]=new int[arr.length];
		return mSort(arr.clone(),temp,0,arr.length-1);
	}
	public static int merge(int arr[],int temp[],int low,int mid,int high){
		int invCnt=0;
		int i=low,j=mid,k=low;
		while(i<mid && j<=high){
			if(arr[i]<=arr[j])
				temp[k++]=arr[i++];
			else{
				temp[k++]=arr[j++];
				invCnt+=(mid-i);
			}
		}
		while(i<mid)	temp[k++]=arr[i++];
		while(j<=high)	temp[k++]=arr[j++];
		i=low;
		while(i<k)	arr[i]=temp[i++];
		return invCnt;
	}
	public static int mSort(int arr[],int temp[],int low,int high){
		int invCnt=0;
		if(high>low){
			int mid=low+(high-low)/2;
			invCnt =mSort(arr,temp,low,mid);
			invCnt+=mSort(arr,temp,mid+1,high);
			invCnt+=merge(arr,temp,low,mid+1,high);
		}
		return invCnt;
	}
	public static void main(String[] args){
		int arr[]={1,20,6,4,5};
		System.out.println(getInvCount(arr));
	}
}