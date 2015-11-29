public class MinHeap{
	int harr[];
	int capacity;
	int heapSize;
	final int INT_MAX=999999999;
	final int INT_MIN=-999999999;
	//Constructor
	public MinHeap(int size){
		capacity=size;
		heapSize=0;
		harr=new int[size];
	}
	//Methods
	public void swap(int i,int j){
		int temp=harr[i];
		harr[i]=harr[j];
		harr[j]=temp;
	}
	public int left(int i){
		return 2*i+1;
	}
	public int right(int i){
		return 2*i+2;
	}
	public int parent(int i){
		return (i-1)/2;
	}
	public int getHeapSize(){
		return heapSize;
	}
	public int getCapacity(){
		return capacity;
	}
	public int getMin(){
		if(heapSize<=0)
			return INT_MAX;
		return harr[0];
	}
	public void minHeapify(int i){
		int l=left(i);
		int r=right(i);
		int smallest=i;
		if(l<heapSize && harr[l]<harr[i])
			smallest=l;
		if(r<heapSize && harr[r]<harr[smallest])
			smallest=r;
		if(i!=smallest){
			swap(i,smallest);
			minHeapify(smallest);
		}
	}
	public int extractMin(){
		if(heapSize<=0)
			return INT_MAX;
		if(heapSize==1){
			heapSize--;
			return harr[0];
		}
		int root=harr[0];
		harr[0]=harr[heapSize-1];
		heapSize--;
		minHeapify(0);
		return root;
	}
	public void insertKey(int key){
		if(heapSize==capacity){
			System.out.println("Heap overflow");
			return;
		}
		int p;
		int i=heapSize++;
		harr[i]=key;
		p=parent(i);
		while(i!=0 && harr[p]>harr[i]){
			swap(p,i);
			i=parent(i);
			p=parent(i);
		}
	}
	public void decreaseKey(int i,int newVal){
		harr[i]=newVal;
		int p=parent(i);
		while(i!=0 && harr[p]>harr[i]){
			swap(p,i);
			i=parent(i);
			p=parent(i);
		}
	}
	public void deleteKey(int i){
		decreaseKey(i,INT_MIN);
		extractMin();
	}
}
