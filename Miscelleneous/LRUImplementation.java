package Miscellaneous;
import java.util.*;
class DLLNode{
	int data;
	DLLNode prev;
	DLLNode next;
	public DLLNode(int d){
		data=d;
		prev=null;
		next=null;
	}
}
class Cache{
	DLLNode head,tail;
	HashMap<Integer,DLLNode> hash;
	int capacity,size;
	public Cache(int leastPageNo,int highestPageNo){
		head=null;
		tail=null;
		capacity=5;//(highestPageNo-leastPageNo+1)/2;
		size=0;
		hash=new HashMap<>();
		for(int i=leastPageNo;i<=highestPageNo;i++){
			hash.put(i, null);
		}
	}
	public void addFirst(int data){
		if(size==capacity)
			this.remove(tail.data);
		DLLNode temp=new DLLNode(data);
		temp.next=head;
		if(head!=null)
			head.prev=temp;
		else
			tail=temp;
		head=temp;
		size++;
		hash.put(data,temp);
	}
	public int remove(int data){
		DLLNode trv=hash.get(data);
		if(trv==null || size<=0)
			return -1;
		if(trv==tail){
			tail=tail.prev;
			tail.next=null;
			trv.prev=null;
		}else if(trv==head){
			head=head.next;
			head.prev=null;
			trv.next=null;
		}else{
			trv.prev.next=trv.next;
			trv.next.prev=trv.prev;
			trv.next=null;
			trv.prev=null;
		}
		hash.put(trv.data, null);
		size--;
		return trv.data;
	}
	public void refer(int pageNo){
		DLLNode trv=hash.get(pageNo);
		if(trv==null){
			this.addFirst(pageNo);
			return;
		}
		if(trv!=head){
			this.remove(pageNo);
			this.addFirst(pageNo);
		}
	}
	public void display(int cnt){
		DLLNode trv=head;
		for(int i=0;i<cnt && trv!=null;i++){
			System.out.print(trv.data+" ");
			trv=trv.next;
		}
	}
}
public class LRUImplementation {
	public static void main(String[] args){
		Cache ch=new Cache(0,9);
		ch.refer(1);
		ch.refer(2);
		ch.refer(3);
		ch.refer(1);
		ch.refer(4);
		ch.refer(5);
		ch.display(60);
	}
}