package prep;
import java.util.*;
class CheckBalancedParenthesis{
    public static void main(String args[]){
        String str=new String("(((()))()())(())");
        Deque<Character> q=new ArrayDeque<Character>();
        int i,len=str.length();
        char ch;
        boolean flag=false;
        for(i=0;i<len;i++){
        	ch=str.charAt(i);
            if(ch=='(')
                q.push(ch);
            else if(ch==')'){
            	if(!q.isEmpty())
            		ch=q.pop();
            	else{
            		System.out.println("Not balanced");
            		flag=true;
            		break;
            	}
                if(ch!='('){
                    System.out.println("Not balanced");
                    flag=true;
                    break;
                }   
            }
        }
        if(!flag){
	        if(q.isEmpty()){
	            System.out.println("Balanced");
	        }else{
	        	System.out.println("Not Balanced");
	        }
        }
    }
}