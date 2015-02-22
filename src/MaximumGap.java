import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
/**
 * 
 * @author yangwenjing
 * 
 * ��Ҫ���ö��Ͱ����
 *
 */
public class MaximumGap {
	
	public int getMaxGap(int arr[], int length)
	{
		int maxGap = 0;
		int temp = arr[0];
		for(int i=1;i<length;i++)
		{
			maxGap = Math.max(arr[i]-temp,maxGap);
			temp = arr[i];
		}
		
		return maxGap;
	}
	//Ͱ������
	public int[] bucketsSort(List<Integer>list, int min,int bits)
	{
		int mask = (1<<bits)-1;//����
		int bucket[] = new int[(int) Math.pow(2, bits)];
		
		for(int x:list)
		{
			bucket[(x-min)&mask] = 1;
		}
		
		int arr[] = new int[list.size()];
		int j=0;
		for(int i=0;i<bucket.length;i++)
		{
			if(bucket[i]==0)
				continue;
			
			arr[j]=i;
			j++;
			
		}
		
		
		return arr;
	}
	
	
	public int maximumGap(int[] num) {
		if(num.length<2)return 0;
		List<Integer>list = new LinkedList<Integer>();
		int max = 0;
		int min = num[0];
		//ȥ���ظ���
		for(int x:num)
		{
			if(!list.contains(x))
			{
				list.add(x);
				
				min = Math.min(x,min);
				max = Math.max(x, max);
			}
		}
		
		if(list.size()<=2)
			return max-min;

		int range = max-min+1;
		int bits = Integer.toBinaryString(range).length();//ÿ����������20λ
		
		
		if(bits<=20)//������С��20λ��ֱ��Ͱ����
		{
			int []arr = this.bucketsSort(list,min,bits);
			return this.getMaxGap(arr, arr.length);
		}
		
		//������Ҫ������Ͱ
		Hashtable ht = new Hashtable<Integer,List<Integer>>();
		
		for(int x:list)
		{
			int index = (x-min)>>20;
			if(!ht.contains(index))
			{
				List<Integer>l = new ArrayList<Integer>();
				l.add(x);
				ht.put(index, l);
			}
			else
			{
				ht.put(index, ((List<Integer>) ht.get(index)).add(x));
			}
			
		}
		
		
		int lay1_range = ((max-min)>>20)+1;
		int bucket_lay1[] = new int[lay1_range*2];
		
		int bucket_lay2_max=0;
		//���Ͱ����
		int arrLength = 0;
		for(int i=0;i<lay1_range;i++)
		{
			if(ht.containsKey(i)))
			{
				int arr[] = this.bucketsSort((List<Integer>)ht.get(i),min,20);
				
			}
		}
		
		return -1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num[] = {2,9,1048576};
		MaximumGap mg = new MaximumGap();
		int x = mg.maximumGap(num);
		System.out.println(x);
	}

}
