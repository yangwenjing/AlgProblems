/***
 * 
 * @author yangwenjing
 * 只有一种情况，0,1的情况
 *
 */
public class MaxProduct {

	public static int MIN_VALUE = -(~(1<<31));
	
    public int maxProduct(int[] A) {
    	int frontValue = 1;
    	int endValue = 1;
    	int product = MIN_VALUE;
    	int length = A.length;
    	for(int i=0;i<length;i++)
    	{
    		frontValue*=A[i];
    		endValue*=A[length-i-1];
    		product = Math.max(product, Math.max(frontValue, endValue));
    		
    		frontValue = frontValue==0?1:frontValue;
    		endValue = endValue==0?1:endValue;
    		
    	}
    	
    	
    	return product;
    }
	public static void main(String[] args) {
		MaxProduct mp = new MaxProduct();
		int x[] = {-2};
		int result = mp.maxProduct(x);
		System.out.println(result);
		// TODO Auto-generated method stub

	}

}
