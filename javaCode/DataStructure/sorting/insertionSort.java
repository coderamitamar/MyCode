package sorting;

public class insertionSort{
	public void insSort(int A[]){
		System.out.println("I am int");
		int i,j,key;
		int n=A.length;
		for(j=1;j<n;j++){
			i=j-1;
			key=A[j];
			while(i>=0 && A[i]>key){
				A[i+1]=A[i];
				i--;
			}
			A[i+1]=key;
		}
	}
	public void insSort(long A[]){
		System.out.println("I am long");
		int i,j,n=A.length;
		long key;
		for(j=1;j<n;j++){
			i=j-1;
			key=A[j];
			while(i>=0 && A[i]>key){
				A[i+1]=A[i];
				i--;
			}
			A[i+1]=key;
		}
	}
	public void insSort(float A[]){
		System.out.println("I am float");
		int i,j,n=A.length;
		float key;
		for(j=1;j<n;j++){
			i=j-1;
			key=A[j];
			while(i>=0 && A[i]>key){
				A[i+1]=A[i];
				i--;
			}
			A[i+1]=key;
		}
	}
	public void insSort(double A[]){
		System.out.println("I am double");
		int i,j,n=A.length;
		double key;
		for(j=1;j<n;j++){
			i=j-1;
			key=A[j];
			while(i>=0 && A[i]>key){
				A[i+1]=A[i];
				i--;
			}
			A[i+1]=key;
		}
	}
	public void insSort(char A[]){
		System.out.println("I am char");
		int i,j,n=A.length;
		char key;
		for(j=1;j<n;j++){
			i=j-1;
			key=A[j];
			while(i>=0 && A[i]>key){
				A[i+1]=A[i];
				i--;
			}
			A[i+1]=key;
		}
	}
	public void insSort(String A[]){
		System.out.println("I am String");
		int i,j,n=A.length;
		String key;
		for(j=1;j<n;j++){
			i=j-1;
			key=A[j];
			while(i>=0 && A[i].compareTo(key)>0){
				A[i+1]=A[i];
				i--;
			}
			A[i+1]=key;
		}
	}
}
