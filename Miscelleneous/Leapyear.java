import java.io.*;
public class Leapyear{
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the Year no.:");
		int Year = Integer.parseInt(br.readLine());
		if((Year%400==0) || (Year%100!=0 && Year%4==0))
			System.out.println("It is a leap Year");
		else
			System.out.print("It is not a leap Year");
	}
}
