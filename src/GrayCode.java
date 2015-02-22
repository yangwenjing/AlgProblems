import java.util.ArrayList;
import java.util.List;


public class GrayCode {
	
	public int getNextCode(int x, int i)
	{
		int mask = 1<<(i-1);
		if((x&mask)==0)
			return x+mask;
		else
			return x-mask;
	}
	
	public List<Integer> grayCode(int n) {
		 List<Integer> codes = new ArrayList<Integer>();
		 codes.add(0);
		 int arr[] = new int[(int) Math.pow(2, n)+1];
		 int row = 1;
		 while(row<=Math.pow(2, n)-1)
		 {
			 int i=arr[row]+1;
			 while(i<=n)
			 {
				 int x = this.getNextCode(codes.get(row-1), i);
				 if(!codes.contains(x))
				 {
					codes.add(x);
					arr[row]=i;
					row++;
					break;
				 }
				 i++;
			 }
			 if(i>n)//»ØÍË
			 {
				 codes.remove(codes.size()-1);
				 arr[row]=0;
				 row--;
			 }
		 }
		 
		 
		 
		 
		 return codes;
	        
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GrayCode gc = new GrayCode();
		List<Integer>l = gc.grayCode(3);
		
		for(int x:l)
		{
			System.out.println(Integer.toBinaryString(x));
		}

	}

}
