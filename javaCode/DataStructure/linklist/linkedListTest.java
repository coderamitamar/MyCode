package linklist;

class Node{
	int data;
	Node next;
	public Node(){
		data=0;
		next=null;
	}
	public Node(int d){
		data=d;
		next=null;
	}
	public Node(int a,Node n){
		data=a;
		next=n;
	}
	public int getData(){
		return data;
	}
	public Node getNext(){
		return next;
	}
	public void setNext(Node n){
		next=n;
	}
	public void setData(int d){
		data=d;
	}
}
class linkedList{
	Node start;
	public linkedList(){
		start=null;
	}
	public boolean isEmpty(){
		return start==null;
	}
	public void insert(int val){
		Node newPtr=new Node(val,start);
		if(start==null)
			start=newPtr;
		else
			start=newPtr;
	}
	public void display(){
		if(start==null){
			System.out.print("no list");
			return;
		}
		Node ptr=start;
		System.out.println();
		System.out.print(ptr.getData());
		ptr=ptr.getNext();
		while(ptr != null){
			System.out.print("-->"+ptr.getData());
			ptr=ptr.getNext();
		}
	}
}
class linkedListTest{
	//linkedList list;
	public static void main(String args[]){
		linkedList list;
		list=new linkedList();
		list.display();
		list.insert(5);
		list.insert(4);
		list.insert(3);
		list.display();
		list.insert(2);
		list.display();		
	}
}