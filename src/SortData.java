import java.util.Random;


public abstract class SortData {
	public int arr[];
	public int arrlen;
	public SortData(int len)
	{
		this.arrlen = len;
		this.arr = new int [this.arrlen];
		Random rng = new Random();
		for(int i=0;i<this.arrlen;i++)
		{
			this.arr[i]=rng.nextInt();
		}
	}
	//��һ�������������ʼ��
	public SortData(int []aArr)
	{
		this.arr=aArr;
		this.arrlen=aArr.length;
	}
	
	public void print()
	{
		for(int i=0;i<this.arrlen;i++)
		{
			System.out.print(this.arr[i]+" ");
		}
		System.out.println("\n�����ϣ�");
	}
	
	public abstract void sort();

}
