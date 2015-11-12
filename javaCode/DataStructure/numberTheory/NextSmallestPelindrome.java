package numberTheory;
import java.util.*;
public class NextSmallestPelindrome{
	public static boolean areAll9(char num[],int len){
		for(int i=0;i<len;i++)
			if(num[i]!='9')
				return false;
		
		return true;
	}
	public static void getNextPelinUtil(char num[],int len){
		int mid=len/2;
		boolean leftSmaller=false;
		int i=mid-1,j;
		j=((len&1)==1)?mid+1:mid;
		//ignoring mid elements which are equal
		while(i>=0 && num[i]==num[j]){
			i--;
			j++;
		}
		if(i<0 || num[i]<num[j])
			leftSmaller=true;
		//copying left side to right side
		//if leftside is not smaller than right side than problem
		//will be completed here
		while(i>=0){
			num[j]=num[i];
			i--;
			j++;
		}
		//if left side is smaller then right side than we have to take
		//some more steps
		if(leftSmaller){
			i=mid-1;
			char carry='1';
			if((len&1)==1){
				if(num[mid]=='9'){
					carry='1';
					num[mid]='0';
				}else{
					carry='0';
					num[mid]=(char)(num[mid]+1);
				}
				j=mid+1;
			}else
				j=mid;
			//propagate the carry and copy leftSide to rightSide
			while(i>=0 && carry=='1'){
				if(num[i]=='9')
					num[i]='0';
				else{
					carry='0';
					num[i]=(char)(num[i]+1);
				}
				num[j]=num[i];
				i--;
				j++;
			}
		}
	}
	public static void getNextPelindrome(String str){
		char num[]=str.toCharArray();
		int len=num.length;
		if(areAll9(num,len)){
			StringBuilder res=new StringBuilder("1");
			for(int i=1;i<len;i++)
				res.append("0");
			res.append("1");
			System.out.println(res);
		}else{
			getNextPelinUtil(num,len);
			System.out.println(num);
		}
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		sc.close();
		getNextPelindrome(str);
	}
}