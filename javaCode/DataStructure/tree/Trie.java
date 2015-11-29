package tree;
class TrieNode{
	int val;
	TrieNode children[];
	final int alphabet=26;
	public TrieNode(){
		children=new TrieNode[alphabet];
		for(int i=0;i<alphabet;i++)
			children[i]=null;
		val=0;
	}
}
public class Trie {
	TrieNode root;//holds the tree
	int count;
	int maxLevel;
	final int alphabet=26;
	private String prefix="";
	//constructor: creates the root node
	Trie(){
		root=new TrieNode();
		count=0;
		maxLevel=0;
	}
	private String getWord(char word[],int r){
		String str="";
		for(int i=0;i<=r;i++)
			str+=word[i];
		return str;
	}
	private void printWordUtil(TrieNode trie,char word[],int indx,int r){
		if(trie==null)//base condition for recursive call
			return;
		word[r]=(char)(indx+'a');//getting the char from index
		if(trie.val!=0)//if the node is the end of a word
			System.out.println(prefix+getWord(word,r));
		for(int i=0;i<alphabet;i++)//recursive call for next level
			printWordUtil(trie.children[i],word,i,r+1);
	}
	private TrieNode deleteWordUtil(TrieNode trie,String str,int x){
		if(trie==null)//base condition for recursion
			return null;
		if(trie.val==0 || x!=str.length()){//if string has not ended or not matched
			int indx=str.charAt(x)-'a';
			trie.children[indx]=deleteWordUtil(trie.children[indx],str,x+1);
		}
		//Checking if the node is shared or not
		boolean flag=false;//assuming not shared
		for(int i=0;i<alphabet;i++){
			if(trie.children[i]!=null){
				flag=true;
				break;
			}
		}
		if(flag){//if shared
			if(x==str.length())
				trie.val=0;//for deletion just unmark as a word
			return trie;
		}
		else//remove the link from its parent
			return null;//this will remove the link from parent
	}
	public void insert(String str){
		int len=str.length();
		int indx;
		TrieNode pCrawl;
		//processing
		maxLevel=Math.max(len, maxLevel);
		count++;
		pCrawl=root;
		for(int level=0;level<len;level++){
			indx=(int)str.charAt(level) - 'a';
			if(pCrawl.children[indx]==null)
				pCrawl.children[indx]=new TrieNode();
			pCrawl=pCrawl.children[indx];
		}
		pCrawl.val=count;
	}
	public boolean isPresent(String str){
		int len=str.length();
		int indx;
		TrieNode pCrawl;
		//processing
		pCrawl=root;
		for(int level=0;level<len;level++){
			indx=(int)str.charAt(level) - 'a';
			if(pCrawl.children[indx]==null)
				return false;
			pCrawl=pCrawl.children[indx];
		}
		return (pCrawl!=null && pCrawl.val!=0);
	}
	public void deleteWord(String str){
		if(str==null || str.equals(""))
			return;
		else if(!this.isPresent(str))
			System.out.println("'"+str+"' is not in the trie");
		else
			root=deleteWordUtil(root,str,0);
	}
	public void printAllWords(TrieNode trie){
		if(trie==root)//because this function is used in two cases
			prefix="";
		char word[]=new char[maxLevel+1];
		for(int i=0;i<alphabet;i++)//calling from root
			printWordUtil(trie.children[i],word,i,0);
	}
	public void printSuggestions(String str){
		prefix=str;//for completion of word while printing suggestion
		TrieNode trv=root;
		int indx;
		int len=str.length();
		for(int i=0;i<len;i++){//finding the node which string str drives to
			indx=(int)(str.charAt(i)-'a');
			if(trv.children[indx]==null){//if string str is not found
				System.out.println("No suggestions found");
				return;
			}
			trv=trv.children[indx];
		}
		//print all the words under the found node.
		//this leads to printing all suggestions
		printAllWords(trv);
	}
	public static void main(String[] args){
		Trie trie=new Trie();
		//Checking insertion
		trie.insert("the");
		trie.insert("these");
		trie.insert("amit");
		trie.insert("kumar");
		trie.insert("amar");
		trie.insert("aman");
		trie.insert("amay");
		trie.insert("sagar");
		trie.insert("singh");
		trie.insert("yadav");
		trie.insert("roushan");
		trie.insert("roy");
		//Checking printAllWords
		System.out.println("Words present in the trie:");
		trie.printAllWords(trie.root);
		//Chicking Printing suggestions
		String str="s";
		System.out.println("\nSuggestions for: "+str);
		trie.printSuggestions(str);
		System.out.println();
		//Checking Searching
		System.out.println("Presence of a words:");
		String s[]={"amar","amit","abhay","singh"};
		for(int i=0;i<s.length;i++){
			if(trie.isPresent(s[i]))
				System.out.printf("%10s ---> Found\n","'"+s[i]+"'");
			else
				System.out.printf("%10s ---> Not Found\n","'"+s[i]+"'");
		}
		//Checking Deletion
		System.out.println("Checking deletion of words:");
		trie.deleteWord("a");
		trie.deleteWord("ama");
		trie.deleteWord("amar");
		trie.deleteWord("amit");
		trie.deleteWord("aman");
		trie.deleteWord("amay");
		trie.deleteWord("sagar");
		System.out.println("After deletion of words:");
		trie.printAllWords(trie.root);
	}
}
