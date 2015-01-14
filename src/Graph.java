import java.util.ArrayList;
import java.util.List;

/***
 * 实现一个无向图
 * 然后遍历无向图
 * @author yangwenjing
 *
 */

public class Graph {
	
	public static void searchGraph(int arr[][])
	{
		//int outputName[] = new int[arr.length];
		
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr[i].length;j++)
			{
				if(arr[i][j]==1)
				{
					System.out.println(String.format("%d<->%d", i,j));
				}
			}
		}
		
		
		//return outputName;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = {{0,1,1,1,0,0},
					   {1,0,1,1,0,0},
					   {1,1,0,1,0,0},
					   {1,1,1,0,1,1},
					   {0,0,0,1,0,1},
					   {0,0,0,1,1,0}};
		
		Graph.searchGraph(arr);
		
		

	}

}
