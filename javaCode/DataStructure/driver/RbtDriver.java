package driver;
import tree.RBT;
import java.util.*;
public class RbtDriver
{
	public static void main(String[] args)
	{
		int opt;
		boolean getout=false;
		RBT<Integer,String> t=new RBT<>();
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
					int n;
					System.out.print("How many pairs: ");
					n=sc.nextInt();
					for(int i=0;i<n;i++)
					{
						System.out.print("Enter the key: ");
						Integer key=sc.nextInt();
						//System.out.print("Enter the value: ");
						String val="hello"+i;//sc.next();
						t.insRbt(key,val);
					}
					break;
				}
				case 3:
				{
					System.out.print("Enter the key: ");
					Integer key=sc.nextInt();
					t.delRbt(key);
					break;
				}
				case 4:
				{
					t.showInorder(t.getRoot());
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