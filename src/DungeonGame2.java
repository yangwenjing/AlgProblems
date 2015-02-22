
public class DungeonGame2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = {{1,-3,3},{0,-2,0},{-3,-3,-3}};
		int arr2[][] = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
		int arr3[][] = {{2,1},{1,-1}};
		DungeonGame2 dg = new DungeonGame2();
		int x = dg.calculateMinimumHP(arr3);
		System.out.print(x);
	}

	private int calculateMinimumHP(int[][] dungeon) {
		// TODO Auto-generated method stub
		int dp[][] = new int[dungeon.length][dungeon[0].length]; 
		int m = dungeon.length;
		int n = dungeon[0].length; 
		
		dp[m-1][n-1] = Math.max(1, 1-dungeon[m-1][n-1]);
		for(int i=m-1;i>=0;i--)
		{
			for(int j=n-1;j>=0;j--)
			{
				if(i>=1)
				{
					if(dp[i-1][j]==0)
						dp[i-1][j] =Math.max(1, dp[i][j]-dungeon[i-1][j]);
					else{
						dp[i-1][j] = Math.min(dp[i-1][j],Math.max(1, dp[i][j]-dungeon[i-1][j]));
					}
					
				}
				if(j>=1)
				{
					if(dp[i][j-1]==0)
						dp[i][j-1] =Math.max(1, dp[i][j]-dungeon[i][j-1]);
					else{
						dp[i][j-1] = Math.min(dp[i][j-1], Math.max(1,dp[i][j]-dungeon[i][j-1] ));
					}	
				}
				
			}
		}
	
		return dp[0][0];
	}

}
