package prep;
class Node2{
	int data;
	Node2 left;
	Node2 right;
	Node2(int d){
		data=d;
		left=null;
		right=null;
	}
}
public class LeafToList{
	static Node2 head=null;
	static Node2 curr=null;
	static boolean flag=true;
	public static Node2 getLeafList(Node2 root){
		if(root==null)
			return null;
		getLeafList(root.left);
		getLeafList(root.right);
		if(flag==true){
			head=root;
			curr=root;
			flag=false;
			return head;
		}
		if(root.left!=null || root.right!=null)
			return null;
		curr.right=root;
		curr=curr.right;
		return head;
	}
	public static void printList(){
		Node2 root=head;
		while(root!=null){
			System.out.print(root.data+" ");
			root=root.right;
		}
	}
	public static void main(String args[]){
		Node2 root				=new Node2(1);
		root.left				=new Node2(2);
		root.right				=new Node2(3);
		root.left.left			=new Node2(4);
		root.left.right			=new Node2(5);
		root.right.left			=new Node2(7);
		root.right.left.right	=new Node2(9);
		root.right.right		=new Node2(6);
		root.left.right.left	=new Node2(10);
		getLeafList(root);
		printList();
	}
}