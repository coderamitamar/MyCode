package stack;
import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfix {
	public static int getAssociativity(char ch){
		if(ch=='+'||ch=='-'||ch=='*'||ch=='/')
			return 1;
		else if(ch=='^')
			return 2;
		else
			return 0;
	}
	public static int getPrecedence(char ch){
		if(ch=='^')
			return 3;
		else if(ch=='*'||ch=='/')
			return 2;
		else if(ch=='+'||ch=='-')
			return 1;
		else if(ch=='(')
			return 0;
		else return -1;
	}
	public static String getPostfix(String str){
		String res="";
		char ch;
		int preced1,preced2,assoc;
		Stack<Character> stk=new Stack<>();
		int i=0,len=str.length();
		while(i<len){
			ch=str.charAt(i);
			if((ch>='a' && ch<='z') || (ch>='A' && ch<='Z')){
				res+=ch;
				i++;
			}else if(ch==')'){
				i++;
				while(!stk.isEmpty() && stk.peek()!='(')
					res+=stk.pop();
				if(!stk.isEmpty())
					stk.pop();
				else{
					System.out.println("Wrong expression");
					break;
				}
			}else{
				if(stk.isEmpty()||ch=='('){
					stk.push(ch);
					i++;
				}else{
					preced1=getPrecedence(stk.peek());
					preced2=getPrecedence(ch);
					assoc=getAssociativity(ch);
					if(preced1<preced2){
						stk.push(ch);
						i++;
					}else if(preced1==preced2 && assoc==2){
						stk.push(ch);
						i++;
					}else if(preced1>preced2){
						res+=stk.pop();
					}else if(preced1==preced2 && assoc==1){
						res+=stk.pop();
					}else{
						System.out.println("Something went wrong");
						break;
					}
				}
			}
		}
		while(!stk.isEmpty()){
			res+=stk.pop();
		}
		return res;
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		sc.close();
		System.out.println(getPostfix(str));
	}
}