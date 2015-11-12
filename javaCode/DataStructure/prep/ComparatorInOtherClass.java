package prep;
import java.util.*;
import java.io.*;
import static java.lang.System.in;
//Ans to how to convert System.in to in
//Ans to how to define Comparator of one class in another class
//and how to pass comparator in Arrays.sort() function
public class ComparatorInOtherClass{
	public static void main(String args[]){
		BufferedReader br=new BufferedReader(new InputStreamReader(in));
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		Player p[]=new Player[n];
		for(int i=0;i<n;i++){
			p[i]=new Player();
			p[i].name=sc.next();
			p[i].score=sc.nextInt();
		}
		Checker check=new Checker();
		Arrays.sort(p,new Comparator<Player>(){
			public int compare(Player a,Player b){
	            return (a.score>b.score)?0:1;
			}
		});
		for(int i=0;i<n;i++){
			System.out.println(p[i].name+" "+p[i].score);
		}
	}
}
class Player{
	int score;
	String name;
}
class Checker{
	Comparator<Player> desc=new Comparator<Player>(){
		public int compare(Player a,Player b){
	            return (a.score<b.score)?0:1;
		}
	};
}