package driver;
import java.util.*;
/*class Testing{
	public static void reverse(char ar[],int i,int j){
		char ch;
		while(i<j){
			ch=ar[i];
			ar[i]=ar[j];
			ar[j]=ch;
			i++;
			j--;
		}
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		char ar[]=str.toCharArray();
		int len=str.length();
		reverse(ar,0,len-1);
		int i=0;
		int j=0;
		while(j<len){
			while(j<len && ar[j]!=' ')
				j++;
			reverse(ar,i,j-1);
			i=j+1;
			j++;
		}
		System.out.println(ar);
		sc.close();
	}
}
/*import tree.BST;
public class Testing {
	public static void main(String args[]){
		BST<Integer,Integer> bst=new BST<>();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no of nodes");
		int n=sc.nextInt();
		System.out.println("Enter node keys");
		for(int i=0;i<n;i++)
			bst.insBst(sc.nextInt(),1);
		bst.printRightView(bst);
		System.out.println();
		bst.printLeftView(bst);
		sc.close();
	}
}*/
class D{
	int a=4;
	int b=3;
}
public class Testing {
	public static void f(D x){
		x.a=1;
		x=null;
	}
	public static void main(String args[]){
		D d=new D();
		System.out.println(d.a);
		f(d);
		System.out.println(d.a);
		d.a=2;
		System.out.println(d.a);
	}
}