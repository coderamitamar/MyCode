package string;

public class RabinKarp {
	private int alphabetLen=256;
	private int maxPrime=Integer.MAX_VALUE;
	public void rkSearch(String text,String pattern){
		char txt[]=text.toCharArray();
		char pat[]=pattern.toCharArray();
		int txtHashVal=0;
		int patHashVal=0;
		int hash=1;
		int textLen=text.length();
		int patLen=pattern.length();
		// The value of hash would be "pow(d, M-1)%q"
		for(int i=0;i<patLen-1;i++)
			hash=(hash*alphabetLen)%maxPrime;
		// Calculate the hash value of pattern and first window of text
		for(int i=0;i<patLen;i++){
			patHashVal=(alphabetLen*patHashVal + pat[i])%maxPrime;
			txtHashVal=(alphabetLen*txtHashVal + txt[i])%maxPrime;
		}
		int i=0,j=0;
		for(i=0;i<=textLen-patLen;i++){// Slide the pattern over text one by one
			// Check the hash values of current window of text and pattern
	        // If the hash values match then only check for characters on by one
			if(patHashVal==txtHashVal){
				for(j=0;j<patLen;j++){// Check for characters one by one
					if(txt[i+j]!=pat[j])
						break;
				}
				if(j==patLen)
					System.out.println("Pattern found at: "+i);
			}
			// Calculate hash value for next window of text: Remove leading digit, 
	        // add trailing digit
			if(i<(textLen-patLen)){
				txtHashVal=(alphabetLen*(txtHashVal-txt[i]*hash) + txt[i+patLen])%maxPrime;
				// We might get negative value of txtHashVal, converting it to positive
				if(txtHashVal<0)
					txtHashVal+=maxPrime;
			}
		}
	}
}
