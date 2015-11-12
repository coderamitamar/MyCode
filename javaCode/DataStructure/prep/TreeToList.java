package prep;
class Nd{
	int data;
	Nd left;
	Nd right;
	Nd(int data){
		this.data=data;
		left=null;
		right=null;
	}
}
public class TreeToList {
	public static Nd toList(Nd root){
		if(root==null)
			return null;
		Nd left,right;
		left=root.left;
		right=root.right;
		toList(root.left);
		toList(root.right);
		if(left!=null){
			while(left.right!=null)
				left=left.right;
			left.right=root;
		}
		if(right!=null){
			while(right.left!=null)
				right=right.left;
			right.left=root;
		}
		root.left=left;
		root.right=right;
		while(root.left!=null)
			root=root.left;
		return root;
	}
	public static void printData(Nd root){
		Nd temp=root;
		while(root!=null){
			System.out.print(root.data+" ");
			temp=root;
			root=root.right;
		}
		root=temp;
		System.out.println();
		while(root!=null){
			System.out.print(root.data+" ");
			root=root.left;
		}
	}
	public static void main(String args[]){
		Nd root=new Nd(5);
		root.left=new Nd(3);
		root.right=new Nd(7);
		root.left.left=new Nd(4);
		root.left.right=new Nd(6);
		root.left.right.left=new Nd(1);
		root.left.right.left.right=new Nd(10);
		printData(toList(root));
	}
}
