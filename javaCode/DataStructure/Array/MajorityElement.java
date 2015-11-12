package Array;

public class MajorityElement {
	//returns some index of majority element
	public static int getMajorityElement(int arr[]){
		int majElem=0;
		int count=1,len=arr.length;
		for(int i=0;i<len;i++){
			if(arr[i]==arr[majElem])
				count++;
			else
				count--;
			if(count==0){
				count=1;
				majElem=i;
			}
		}
		count=0;
		for(int i=0;i<len;i++){
			if(arr[i]==arr[majElem])
				count++;
		}
		if(count>len/2)
			return majElem;
		return -1;
	}
	public static void main(String[] args){
		int arr[]={2,2,3,4,5,1,3,1,2,1,2,2,1,2,1,2,1,2,2,2};
		int res=getMajorityElement(arr);
		System.out.println((res==-1)?"No majority element exists":
									 "Majority Element is:"+arr[res]);
	}
}