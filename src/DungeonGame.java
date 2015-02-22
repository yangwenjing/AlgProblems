/***
 * 
 * @author yangwenjing
 * 动态规划的基本问题
 *
 */
public class DungeonGame {
	
	public int calculateMinimumHP(int[][] dungeon) {
		
		int [][]hp = new int[dungeon.length][dungeon[0].length];
		int [][]minHp = new int[dungeon.length][dungeon[0].length];
		
		int i=0;
		while(i<dungeon.length)
		{
			
			int j=0;
			while(j<dungeon[i].length)
			{
				if(i==0&&j==0)
				{
					if(dungeon[0][0]<=0)
					{
						hp[0][0] = dungeon[0][0];
						minHp[0][0] = 1-dungeon[0][0];
						
					}
					else{
						hp[0][0]=dungeon[0][0];
						minHp[0][0]=1;
					}
				}
				else if(i==0)
				{
					hp[i][j]=dungeon[i][j]+hp[i][j-1];
					if(minHp[i][j-1]+hp[i][j-1]+dungeon[i][j]<1)
					{
						minHp[i][j]=1-dungeon[i][j]-hp[i][j-1];
					}
					else{
						minHp[i][j] = minHp[i][j-1];
					}
					
				}
				else if(j==0)
				{

					hp[i][j]=dungeon[i][j]+hp[i-1][j];
					if(minHp[i-1][j]+hp[i-1][j]+dungeon[i][j]<1)
					{
						minHp[i][j]=1-dungeon[i][j]-hp[i-1][j];
					}
					else{
						minHp[i][j] = minHp[i-1][j];
					}
					
				}
				else{
					
					int minhpi;
					int minhpj;
					
					int hpi = dungeon[i][j]+hp[i][j-1];
					int hpj = dungeon[i][j]+hp[i-1][j];
					
					if(minHp[i][j-1]+hp[i][j-1]+dungeon[i][j]<1)
					{
						minhpi=1-dungeon[i][j]-hp[i][j-1];
					}
					else{
						minhpi=minHp[i][j] = minHp[i][j-1];
					}
					
					if(minHp[i-1][j]+hp[i-1][j]+dungeon[i][j]<1)
					{
						minhpj=1-dungeon[i][j]-hp[i-1][j];
					}
					else{
						minhpj = minHp[i-1][j];
					}
					
					if(hpi>hpj){
						minHp[i][j] = minhpi;
						hp[i][j] = hpi;
					}
					else if(hpi<hpj){
						minHp[i][j] = minhpj;
						hp[i][j] = hpj;
					}else if(minhpi<minhpj)
					{
						minHp[i][j] = minhpi;
						hp[i][j]=hpi;
					}
					else if(minhpi>minhpj)
					{
						minHp[i][j] = minhpj;
						hp[i][j]=hpj;
					}
				
				}
				
				j++;
			}
			i++;
		}
		
		return minHp[dungeon.length-1][dungeon[0].length-1];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = {{1,-3,3},{0,-2,0},{-3,-3,-3}};
		DungeonGame dg = new DungeonGame();
		int x = dg.calculateMinimumHP(arr);
		System.out.print(x);
	}

}
