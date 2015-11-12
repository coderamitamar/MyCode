package driver;
//import sorting.insertionSort;
//import sorting.quickSort;
import sorting.HeapSort;
public class SortDrive
{
	public static void main(String[] args)
	{
		String A[]={"Ram","Shyam","Prashant","prashant","amit","4","shaurav","harsh","Anil","anil"};
		char B[]={'a','b','A','C','1','3','2','5'};
		float C[]={1.23f,2.12f,123.321f};
		double D[]={1.23,2.12,123.321,123,123456.7654321,456.123456};
		long E[]={1233,12232,35346456,125235134,678475734,26756856,6798835609769687l,4541247907563658697l};
		int F[]={243234,3456345,54757,789679,10847456,245345,5674756,967757,133458568};
		int J[]={17,12,20,13,45,10,32,53};
		//Creating object of sorting class
		/*insertionSort s=new insertionSort();
		
		//Sorting String
		s.insSort(A);
		for(String k:A)
			System.out.println(k);
		System.out.println();
		
		//Sorting char
		s.insSort(B);
		for(char k:B)
		 	System.out.println(k);
		System.out.println();
		
		//Sorting float
		s.insSort(C);
		for(float k:C)
		 	System.out.println(k);
		System.out.println();
		
		//Sorting double
		s.insSort(D);
		for(double k:D)
		 	System.out.println(k);
		System.out.println();
		
		//Sorting long
		s.insSort(E);
		for(long k:E)
		 	System.out.println(k);
		System.out.println();
		
		//Sorting int
		s.insSort(F);
		for(int k:F)
		 	System.out.println(k);*/
		
		//quickSort q=new quickSort();
		//q.qckSort(F,0,F.length-1);
		HeapSort hs=new HeapSort();
		hs.heapSort(J);
		for(int k:J)
		 	System.out.println(k);
		if('1'<'2')
			System.out.println("No");
	}
}
