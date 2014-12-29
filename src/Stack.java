import java.util.Random;

/**
 * �����
 * @author yangwenjing
 *
 */
//һ��int���͵Ķ�����

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
	//��һ�������������ʼ��
	public Stack(int []aArr)
	{
		this.arr=aArr;
		this.arrlen=aArr.length;
	}
	
	//��ʾ�ڼ��ε���
	//iΪ0ʱ��ʾ��0��ʼ����
	public void adjust(int i)
	{
		for(int root=(this.arrlen-i)/2-1;root>=0;root--)
		{
			//������Ҷ�ӽڵ�
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
			System.out.println("***��"+i+"�ε���:");
			this.print();
		}
	}
	
	public void print()
	{
		for(int i=0;i<this.arrlen;i++)
		{
			System.out.print(this.arr[i]+" ");
		}
		System.out.println("\n�����ϣ�");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {10,8,9,7,11,15};
		//System.out.println("���룺\n"+arr);
		Stack st = new Stack(arr);
		st.print();
		st.adjustHeap();
		st.print();
	}

}
