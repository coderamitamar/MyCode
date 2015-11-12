package driver;
import tree.BST;
import java.util.*;
public class BSTDriver
{
	public static void main(String[] args)
	{
		int opt;
		boolean getout=false;
		BST<Integer,String> t=new BST<>();
		Scanner sc=new Scanner(System.in);
		while(getout==false)
		{
			System.out.println("1> Create Tree\n"+
					   		   "2> Insert key/Value into tree\n"+
					   		   "3> Delete key/Value by key in tree\n"+
					   		   "4> Show key/Value from tree\n"+
					   		   "5> Exit Application"
					  		  );
			System.out.print("Enter the choice: ");
			opt=sc.nextInt();
			switch(opt)
			{
				case 1:
				{
					System.out.println("Always created\n");
					break;
				}
				case 2:
				{
					System.out.print("Enter the key: ");
					Integer key=sc.nextInt();
					System.out.print("Enter the value: ");
					String val=sc.next();
					t.insBst(key,val);
					break;
				}
				case 3:
				{
					System.out.print("Enter the key: ");
					Integer key=sc.nextInt();
					t.delBst(key);
					break;
				}
				case 4:
				{
					//t.showInorder(t.getRoot());
					t.showInorderWithoutStack(t.getRoot());
					break;
				}
				case 5:
				{
					getout=true;
					break;
				}
			}
		}
		sc.close();
	}
}