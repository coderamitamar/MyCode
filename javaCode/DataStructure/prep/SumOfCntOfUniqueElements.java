package prep;

public class SumOfCntOfUniqueElements {
	public static int getUniqueCnt(int ar[],int k){
		int map[]=new int[101];
		int cnt=0,prev,len=ar.length,j;
		for(int i=0;i<k;i++)	map[ar[i]]++;
		for(int i=0;i<k;i++){
			if(map[ar[i]]==1)	cnt++;
		}
		prev=cnt;
		System.out.println(cnt);
		for(int i=k;i<len;i++){
			j=i-k;
			if(ar[i]!=ar[j]){
				map[ar[i]]++;
				map[ar[j]]--;
				if(map[ar[i]]==1)			prev++;
				else if(map[ar[i]]==2)		prev--;
				
				if(map[ar[j]]==1)			prev++;
				else if(map[ar[j]]==0)		prev--;
			}
			System.out.println(prev);
			cnt+=prev;
		}
		return cnt;
	} 
	public static void main(String args[]){
		int ar[]={1,2,1,3,4,2,3,5,4,6,7,4,5,3};
		int k=7;
		System.out.println(getUniqueCnt(ar,k));
	}
}
