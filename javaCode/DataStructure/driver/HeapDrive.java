package driver;
import tree.MinHeap;
public class HeapDrive
{
	public static void main(String[] args)
	{
		MinHeap mh=new MinHeap(100);
		mh.insertKey(3);
		mh.insertKey(5);
		mh.insertKey(1);
		mh.insertKey(4);
		mh.insertKey(2);
		/*
		System.out.println(mh.extractMin());
		System.out.println(mh.extractMin());
		System.out.println(mh.extractMin());
		System.out.println(mh.extractMin());
		System.out.println(mh.extractMin());
		
		System.out.println(mh.getMin());
		mh.deleteKey(0);
		System.out.println(mh.getMin());
		mh.deleteKey(0);
		System.out.println(mh.getMin());
		mh.deleteKey(0);
		System.out.println(mh.getMin());
		mh.deleteKey(0);
		System.out.println(mh.getMin());
		*/
		mh.deleteKey(0);
		mh.decreaseKey(0, 1);
		System.out.println(mh.extractMin());
		System.out.println(mh.extractMin());
		System.out.println(mh.extractMin());
		System.out.println(mh.extractMin());
	}
}