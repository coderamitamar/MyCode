package linklist;
import java.util.Scanner;

class pInfo{
	Node head;
	Node mid;
	Node tail;
	pInfo(Node h,Node m,Node t){
		head=h;
		mid=m;
		tail=t;
	}
}
public class LinkedListSort {
	static Node root;
	static Node end;
	public static void insToList(int data){
		Node trv=new Node(data);
		if(root==null){
			root=trv;
			end=trv;
			return;
		}
		end.next=trv;
		end=trv;
	}
	public static Node getPrevX(Node head,Node X){
		Node trv=head;
		if(head==null || X==null)
			return null;
		if(head==X)
			return X;
		while(trv!=null && trv.next!=X)
			trv=trv.next;
		return trv;
	}
	public static pInfo partition(Node head,Node tail){
		if(head==null || tail==null)
			return null;
		if(head==tail)	return new pInfo(head,head,head);
		boolean flag=false,check=false;
		if(head==root)
			flag=true;
		Node curr=head,prt=head,temp,last=tail;
		while(curr!=tail){
			if(curr!=null && curr.data>tail.data){
				if(curr==head){
					head=head.next;
					prt=head;
				}else{
					prt.next=curr.next;
				}
				if(!check){
					last =curr;
					check=true;
				}
				temp=tail.next;
				tail.next=curr;
				curr.next=temp;
				if(prt==head)
					curr=prt;
				else
					curr=prt.next;
			}else{
				prt=curr;
				if(curr!=null)
					curr=curr.next;
			}
		}
		if(flag)
			root=head;
		return new pInfo(head,tail,last);
	}
	public static void qSort(Node head,Node tail){
		if(head==tail)	return;
		pInfo p=partition(head,tail);
		Node prevMid=getPrevX(p.head,p.mid);
		qSort(p.head,prevMid);
		qSort(p.mid ,p.tail );
	}
	public static void printData(){
		Node trv=root;
		while(trv!=null){
			System.out.print(trv.data+" ");
			trv=trv.next;
		}
	}
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the No of nodes: ");
		int n=sc.nextInt();
		System.out.println("Enter the nodes: ");
		for(int i=0;i<n;i++)
			insToList(sc.nextInt());
		printData();
		System.out.println();
		System.out.println();
		qSort(root,end);
		printData();
		sc.close();
	}
}