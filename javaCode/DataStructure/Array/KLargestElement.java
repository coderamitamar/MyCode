package Array;

public class KLargestElement {
	public static void swap(int arr[],int i,int j){
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	public static void collectKLargestElem(int arr[],int k){
		int j=0,p=0,len=arr.length;
		for(int i=1;i<k;i++){
			j=i;
			p=(j-1)/2;
			while(p>=0 && arr[p]>arr[j]){
				swap(arr,j,p);
				j=p;
				p=(j-1)/2;
			}
		}
		for(int i=k;i<len;i++){
			if(arr[0]<arr[i]){
				swap(arr,i,0);
				heapify(arr,0,k);
			}
		}
	}
	public static void heapify(int arr[],int x,int size){
		int smallest=x;
		int l=2*x+1;
		int r=2*x+2;
		if(l<size && arr[l]<arr[x])
			smallest=l;
		if(r<size && arr[r]<arr[smallest])
			smallest=r;
		if(smallest!=x){
			swap(arr,smallest,x);
			heapify(arr,smallest,size);
		}
	}
	public static void main(String[] args){
		int arr[]={9,4,2,6,8,7,9,5,9};
		int k=6;
		collectKLargestElem(arr,k);
		for(int i=0;i<k;i++)
			System.out.print(arr[i]+" ");
	}
}