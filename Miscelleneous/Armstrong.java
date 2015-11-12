import java.io.*;
class Armstrong{
	public static void arm(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("\tEnter the number: ");
		int n=Integer.parseInt(br.readLine());
		int c=0,a,d;
		d=n;
		while(n>0){
			a=n%10;
			c+=a*a*a;
			n/=10;
		}
		if(c==d)
			System.out.print("\tThe no. is the Armstrong no.");
		else
			System.out.print("\tThe no. is not the Armstrong no.");
	}
}