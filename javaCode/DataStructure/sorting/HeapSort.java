package sorting;

public class HeapSort
{
	int hSize;
	public void swap(int arr[],int i,int j)
	{
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	public void maxHeapify(int arr[],int i)
	{
		int l=2*i+1;
		int r=2*i+2;
		int largest=i;
		if(l<hSize && arr[l]>arr[i])
			largest=l;
		if(r<hSize && arr[r]>arr[largest])
			largest=r;
		if(i!=largest)
		{
			swap(arr,i,largest);
			maxHeapify(arr,largest);
		}
	}
	public void createHeap(int arr[])
	{
		hSize=arr.length;
		for(int i=(hSize-2)/2;i>=0;i--)
			maxHeapify(arr,i);
	}
	public void heapSort(int arr[])
	{
		createHeap(arr);
		while(hSize>1)
		{
			swap(arr,0,hSize-1);
			hSize--;
			maxHeapify(arr,0);
		}
	}
}