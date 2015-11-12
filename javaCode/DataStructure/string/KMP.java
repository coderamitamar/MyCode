package string;

public class KMP {
	private char text[];
	private int textLen;
	private int patLen;
	private int lps[];
	public KMP(String text){
		textLen=text.length();
		this.text=text.toCharArray();
	}
	private void calcLps(char pat[]){
		int i=1,len=0;
		lps=new int[patLen];
		lps[0]=0;
		while(i<patLen){
			if(pat[i]==pat[len]){
				len++;
				lps[i]=len;
				i++;
			}else{
				if(len!=0)
					len=lps[len-1];
				else{
					lps[i]=0;
					i++;
				}
			}
		}
	}
	public void kmpSearch(String pattern){
		patLen=pattern.length();
		char pat[]=pattern.toCharArray();
		calcLps(pat);
		int i=0,j=0;
		while(i<textLen){
			if(text[i]==pat[j]){
				i++;
				j++;
			}
			if(j==patLen){
				System.out.println("Pattern matched at "+(i-j));
				j=lps[j-1];
			}
			else if(i<textLen && text[i]!=pat[j]){
				if(j!=0)
					j=lps[j-1];
				else
					i++;
			}
		}
	}
}