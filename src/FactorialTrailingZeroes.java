
public class FactorialTrailingZeroes {

	
	public int trailingZeroes(int n) {
		
		int counter5 = 0;
		
		int i=1;                                                                                                                                                                                                                                                                                                                                                                                                                                                         
		int seed = (int) (n/Math.pow(5, i));
		
		while(seed>0)
		{
			counter5+=seed;
			i++;
			seed = (int) (n/Math.pow(5, i));

		}
		
		return counter5;
		
    }
	public static void main(String[] args) {
		// TODO Auto-generated method s1tub
		FactorialTrailingZeroes ftz = new FactorialTrailingZeroes();
		int x = ftz.trailingZeroes(30);
		int y = ftz.trailingZeroes(20);
		System.out.println(x+" "+y);
	}

}
