package queue;
import java.util.*;
class A implements Comparable<A>{
	int data;
	int key;
	public A(int key, int value){
		this.key=key;
		data=value;
	}
	public int compareTo(A a){
		return this.key-a.key;
	}
}
public class PriorityQueueImplementation {
	public static void main(String[] args){
		PriorityQueue<A> pq=new PriorityQueue<>();
		pq.add(new A(3,123));
		pq.add(new A(1,231));
		pq.add(new A(2,133));
		pq.add(new A(4,345));
		A x;/*=pq.remove();
		System.out.println(x.key+" "+x.data);
		x=pq.remove();
		System.out.println(x.key+" "+x.data);
		x=pq.remove();
		System.out.println(x.key+" "+x.data);
		x=pq.remove();
		System.out.println(x.key+" "+x.data);*/
		//Iterator<A> a=pq.iterator();
		while(!pq.isEmpty()){
			x=pq.remove();
			System.out.println(x.key+" "+x.data);
		}
	}
}