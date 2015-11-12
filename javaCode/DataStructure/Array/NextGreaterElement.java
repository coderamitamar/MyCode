/* The Next greater Element for an element x is the first greater element
 * on the right side of x in array. Elements for which no greater element
 * exist, consider next greater element as -1.
 */
package Array;
import java.util.*;
public class NextGreaterElement {
	public static void getNGE(int arr[]){
		Stack<Integer> s=new Stack<>();
		int elem,next,len=arr.length;
		s.push(arr[0]);
		for(int i=1;i<len;i++){
			next=arr[i];
			if(!s.isEmpty()){
				elem=s.pop();
				while(elem<next){
					System.out.println(elem+" --> "+next);
					if(s.isEmpty())
						break;
					elem=s.pop();
				}
				if(elem>next)
					s.push(elem);
			}
			s.push(next);
		}
	}
	public static void main(String[] args){
		int arr[]= {11, 13, 21, 3};
	    getNGE(arr);
	}
}