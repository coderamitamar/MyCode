package tree;
public class SegmentTree{
	private int segArr[];
	private int segSize;
	private int arr[];
	private int elemSize;
	public SegmentTree(int size,int brr[]){
		elemSize=size;
		arr=brr;
		segSize=2*(int)(Math.pow(2,Math.ceil(Math.log10(size)/Math.log10(2))))-1;
		segArr=new int[segSize];
	}
				//method section
	//Segment tree Construction method
	private int consSegTreeUtil(int ss,int se,int index){
		if(ss==se){
			segArr[index]=arr[ss];
			return segArr[index];
		}
		int mid=ss+(se-ss)/2;
		segArr[index]=consSegTreeUtil(ss,mid,2*index+1)+
					  consSegTreeUtil(mid+1,se,2*index+2);
		return segArr[index];
	}
	private int getSumUtil(int ss,int se,int qs,int qe,int index){
		if(qs<=ss && se<=qe)
			return segArr[index];
		if(qs>se || qe<ss)	return 0;
		int mid=ss+(se-ss)/2;
		return getSumUtil(ss,mid,qs,qe,2*index+1)+
			   getSumUtil(mid+1,se,qs,qe,2*index+2);
	}
	private void updateSegTreeUtil(int ss,int se,int i,int diff,int index){
		if(i<ss || i>se)	return;
		segArr[index]+=diff;
		if(ss!=se){
			int mid=ss+(se-ss)/2;
			updateSegTreeUtil(ss,mid,i,diff,2*index+1);
			updateSegTreeUtil(mid+1,se,i,diff,2*index+2);
		}
	}
	public void createSegTree()
	{
		int size=arr.length;
		consSegTreeUtil(0,size-1,0);
	}
	public int getSum(int l,int r)
	{
		if(l<0 || r>elemSize-1 || l>r)
		{
			System.out.println("Invalid Range");
			return -1;
		}
		return getSumUtil(0,elemSize-1,l,r,0);
	}
	public void updateSegTree(int i,int newVal)
	{
		if(i<0 || i>elemSize)
		{
			System.out.println("Invalid index for update");
			return;
		}
		int diff=newVal-arr[i];
		arr[i]=newVal;
		updateSegTreeUtil(0,elemSize-1,i,diff,0);
	}
	public int getSegSize()
	{
		return segSize;
	}
}