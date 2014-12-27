import java.io.FileNotFoundException;
import java.io.IOException;


public class XQueen {
	public int x = 8;
	public int arr[];
	public int currentRow;
	public int currentCol;
	//还需要一个数据结构记录无效的
	
	public XQueen(int x)
	{
		this.currentRow=0;
		this.currentCol=0;
		this.x=x;
		this.arr = new int[this.x];
		
		for(int i=0;i<this.x;i++)
		{
			this.arr[i]=0;
		}
	}
	
	
	public void mainput()
	{
		if(this.currentCol>=this.x)
		{
			this.currentRow--;
			this.currentCol=++this.arr[this.currentRow];
			return;
		}
		boolean result = pass(this.currentRow,this.currentCol);
		if(result)
		{
			this.arr[this.currentRow]=this.currentCol;
			this.currentRow++;
			this.currentCol=0;
		}
		else{
			this.currentCol++;
			if(this.currentCol>=this.x)
			{
				this.currentRow--;
				this.currentCol=++this.arr[this.currentRow];
			}
			
		}
		System.out.println(this.currentRow+"-"+this.currentCol);
		
		
		
	}
	
	
	public boolean pass(int i,int j)
	{
		int k=1;
		
		while(i-k>=0)
		{
			int xpoint=i-k;
			int ypointl=j-k;
			int ypointr=j+k;
			int ypointt=j;
			if(isValid(xpoint, ypointl)&&
				isValid(xpoint,ypointt)&&
				isValid(xpoint,ypointr))
			{
				k++;
			}
			else
			{
				return false;
			}
		}
		
		return true;
	}
	
	public void stack()
	{
		while(this.currentRow<this.x)
		{
			mainput();
		}
	}

	//在对应位置上是否有冲突
	private boolean isValid(int xpoint, int ypoint) {
		
		if(ypoint>=0&&ypoint<this.x)
		{
			if(this.arr[xpoint]==ypoint)
				return false;		
		}
		
		return true;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 4;
		XQueen queen = new XQueen(x);
		queen.stack();
		System.out.println("***输出"+x+"皇后****");
		for(int i=0;i<queen.x;i++)
		{
			for(int j=0;j<queen.x;j++)
			{
				if(queen.arr[i]==j)
					System.out.print(1+" ");
				else
					System.out.print(0+" ");
			}
			System.out.print("\n");
		}
		System.out.println("\n***End****");

	}

}
