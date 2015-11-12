package Array;
import java.text.DecimalFormat;

class Heap{
	int harr[];
	int hSize;
	int capacity;
	Heap(int s){
		capacity=s;
		hSize=0;
		harr=new int[s];
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
	public int getTop(){
		return harr[0];
	}
	public void swap(int i,int j){
		int temp=harr[i];
		harr[i]=harr[j];
		harr[j]=temp;
	}
}
class Minheap extends Heap{
	Minheap(int size){
		super(size);
	}
	public void heapify(int i){
		int l=left(i);
		int r=right(i);
		int smallest=i;
		if(l<hSize && harr[l]<harr[i])
			smallest=l;
		if(r<hSize && harr[r]<harr[smallest])
			smallest=r;
		if(i!=smallest){
			swap(i,smallest);
			heapify(smallest);
		}
	}
	public void insert(int key){
		if(hSize==capacity){
			System.out.println("Heap overflow");
			return;
		}
		int i=hSize++;
		harr[i]=key;
		while(i!=0 && harr[parent(i)]>harr[i]){
			swap(i,parent(i));
			i=parent(i);
		}
	}
	public int extractTop(){
		if(hSize<=0)
			return -1;
		if(hSize==1){
			hSize--;
			return harr[0];
		}
		int root=harr[0];
		harr[0]=harr[hSize-1];
		hSize--;
		heapify(0);
		return root;
	}
}
class MaxHeap extends Heap{
	MaxHeap(int size){
		super(size);
	}
	public void heapify(int i){
		int l=left(i);
		int r=right(i);
		int largest=i;
		if(l<hSize && harr[l]>harr[i])
			largest=l;
		if(r<hSize && harr[r]>harr[largest])
			largest=r;
		if(i!=largest){
			swap(i,largest);
			heapify(largest);
		}
	}
	public void insert(int key){
		if(hSize==capacity){
			System.out.println("Heap overflow");
			return;
		}
		int i=hSize++;
		harr[i]=key;
		while(i!=0 && harr[parent(i)]<harr[i]){
			swap(i,parent(i));
			i=parent(i);
		}
	}
	public int extractTop(){
		if(hSize<=0)
			return -1;
		if(hSize==1){
			hSize--;
			return harr[0];
		}
		int root=harr[0];
		harr[0]=harr[hSize-1];
		hSize--;
		heapify(0);
		return root;
	}
}
class FindMedian{
	int brr[];
	int size;
	Minheap r;
	MaxHeap l;
	FindMedian(int n,int arr[]){
		r=new Minheap(n);
		l=new MaxHeap(n);
		brr=arr;
		size=n;
	}
	public void showAllMedian(){
		float m=0;
		for(int i=0;i<size;i++){
			m=getMedian(brr[i],m);
			DecimalFormat df=new DecimalFormat("#.0");
			System.out.println(df.format(m));
		}
	}
	public float getMedian(int e,float m){
		int sig=(l.hSize==r.hSize)?0:((l.hSize<r.hSize)?-1:1);
		float newM=0;
		switch(sig){
			case -1:{//right side (min heap has more elements)
				if(e<m)
					l.insert(e);
				else{
					l.insert(r.extractTop());
					r.insert(e);
				}
				newM=((float)l.getTop()+r.getTop())/2;
				break;
			}
			case 1:{//left side (max heap has more elements)
				if(e<m){
					r.insert(l.extractTop());
					l.insert(e);
				}else
					r.insert(e);
				newM=((float)l.getTop()+r.getTop())/2;
				break;
			}
			case 0:{
				if(e<m){
					l.insert(e);
					newM=(float)l.getTop();
				}else{
					r.insert(e);
					newM=(float)r.getTop();
				}
				break;
			}
		}
		return newM;
	}
}
public class Median{
	public static void main(String[] args){
		int A[] = {5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4};
		FindMedian m=new FindMedian(A.length,A);
		m.showAllMedian();
	}
}