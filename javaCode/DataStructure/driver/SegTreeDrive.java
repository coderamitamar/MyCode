package driver;
import tree.SegmentTree;
public class SegTreeDrive
{
	public static void main(String[] args)
	{
		int arr[]={1,2,3,4,5,6,7,8,9,10};
		int len=10;
		SegmentTree st=new SegmentTree(len,arr);
		st.createSegTree();
		System.out.println(st.getSum(1,9));
		st.updateSegTree(1,300);
		System.out.println(st.getSum(1,9));
		System.out.println(st.getSegSize());
	}
}