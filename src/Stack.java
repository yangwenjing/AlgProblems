import java.util.Random;

/**
 * 大根堆
 * @author yangwenjing
 *
 */
//一个int类型的队排序

public class Stack {
	
	public int arr[];
	public int arrlen;
	public Stack(int len)
	{
		this.arrlen = len;
		this.arr = new int [this.arrlen];
		Random rng = new Random();
		for(int i=0;i<this.arrlen;i++)
		{
			this.arr[i]=rng.nextInt();
		}
	}
	//由一个给定的数组初始化
	public Stack(int []aArr)
	{
		this.arr=aArr;
		this.arrlen=aArr.length;
	}
	
	//表示第几次调整
	//i为0时表示从0开始调整
	public void adjust(int i)
	{
		for(int root=(this.arrlen-i)/2-1;root>=0;root--)
		{
			//调整左叶子节点
			if((root*2+1)<this.arrlen-i)
			{
				if(this.arr[root]<this.arr[root*2+1])
				{
					int temp = this.arr[root];
					this.arr[root]=this.arr[root*2+1];
					this.arr[root*2+1]=temp;
				}
			}
			if((root*2+2)<this.arrlen-i)
			{
				if(this.arr[root]<this.arr[root*2+2])
				{
					int temp = this.arr[root];
					this.arr[root]=this.arr[root*2+2];
					this.arr[root*2+2]=temp;
				}
			}
		}
		
		int temp = this.arr[0];
		int j=0;
		while(j<this.arrlen-i-1)
		{
			this.arr[j]=this.arr[j+1];
			j++;
		}
		this.arr[this.arrlen-i-1]=temp;
	}
	
	public void adjustHeap()
	{
		for(int i=0;i<this.arrlen;i++)
		{
			adjust(i);
			System.out.println("***第"+i+"次调整:");
			this.print();
		}
	}
	
	public void print()
	{
		for(int i=0;i<this.arrlen;i++)
		{
			System.out.print(this.arr[i]+" ");
		}
		System.out.println("\n输出完毕！");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {10,8,9,7,11,15};
		//System.out.println("输入：\n"+arr);
		Stack st = new Stack(arr);
		st.print();
		st.adjustHeap();
		st.print();
	}

}
