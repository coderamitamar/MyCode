/*
 * A number is called as a Jumping Number if all adjacent digits in it differ
 * by 1. The difference between ‘9’ and ‘0’ is not considered as 1.All single
 * digit numbers are considered as Jumping Numbers. For example 7, 8987 and 
 * 4343456 are Jumping numbers but 796 and 89098 are not.
 * Given a positive number x, print all Jumping Numbers 
 * smaller than or equal to x. The numbers can be printed in any order.
*/
package numberTheory;
import java.util.*;
public class JumpingNumber {
	public static void printJumpingNums(int x,int target){
		Deque<Integer> q=new ArrayDeque<Integer>();
		q.addLast(x);
		int num=0,lastDig;
		while(!q.isEmpty()){
			num=q.removeFirst();
			if(num<=target){
				System.out.print(num+" ");
				lastDig=num%10;
				if(lastDig==0)
					q.addLast(num*10+1);
				else if(lastDig==9)
					q.addLast(num*10+8);
				else{
					q.addLast(num*10+lastDig-1);
					q.addLast(num*10+lastDig+1);
				}
			}
		}
		System.out.println();
	}
	public static void jumpingNums(int x){
		if(x<0){
			System.out.println("Only positive numbers are allowed");
			return;
		}
		System.out.println(0);
		for(int i=1;i<=9;i++)
			printJumpingNums(i,x);
	}
	public static void main(String[] args){
		int x=1140;
		jumpingNums(x);
	}
}
