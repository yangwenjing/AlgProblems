import java.util.Hashtable;
import java.util.Iterator;


public class SingleNumber {

	public int singleNumber(int[] A) {

		int result = A[0];
		for(int i=1;i<A.length;i++)
		{
			result = result^A[i];
		}	

		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {1,1,2,5,5};
		SingleNumber sn = new SingleNumber();
		int result = sn.singleNumber(A);
		System.out.println(result);
	}
}
