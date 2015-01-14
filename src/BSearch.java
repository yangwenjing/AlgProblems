import java.util.Random;

/**
 * 
 */

/**
 * 1.实现二分查找 int binarySearch(T[] a,T value)；成功返回索引，失败返回-1
2.实现数组元素删除算法 int remove(T[] a, T value)；删除数组a中所有等于value的数值
 * @author Yang Wenjing
 *
 */
public class BSearch {
	
	public int a[] = null;
	public static Random rng = new Random();
	/**
	 * 初始化
	 * @param size 设置数组的大小
	 */
	public BSearch(int size)
	{
		this.a = new int[size];
		for(int i=0;i<size;i++)
		{
			this.a[i] = rng.nextInt(size);
		}
	}
	
	public int binarySearch(int x)
	{
		return search(x,0,this.a.length-1);
	}

	public int search(int x, int l, int r)
	{
		if(l>r)
			return -1;
		if(l==r)
		{
			if(this.a[l]==x)
				return l;
			else
				return -1;
		}
		
		int mid = (l+r)/2;
		int result = search(x,l,mid);
		if(result!=-1)
			return result;
		result = search(x,mid+1,r);
		if(result!=-1)
			return result;
		return result;
	}
	
	public int remove(int x)
	{
		int index = binarySearch(x);
		while(index!=-1)
		{
			this.a[index]=-1;
			index = binarySearch(x);
		}
		
		int j=0;
		
		for(int i=0;i<this.a.length;i++)
		{
			if(a[i]!=-1)
			{
				a[j]=a[i];
				j++;
			}
			
		}
		
		int result = j;
		
		for(;j<this.a.length;j++)
		{
			a[j]=-1;
		}
		return result;
	}
	
	
	public String toString()
	{
		String s = "";
		for(int i=0;i<this.a.length;i++)
		{
			s+=(this.a[i]+" ");
		}
		return s;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BSearch bs = new BSearch(10);
		System.out.println(bs.toString());
		
		int result = bs.binarySearch(8);
		
		System.out.println("8在数组中吗？："+result);
		
		
		result = bs.remove(0);
		System.out.println("删除0，剩余:"+result);
		System.out.println(bs.toString());

	}

}
