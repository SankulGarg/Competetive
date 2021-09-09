	package com.github.sankulgarg.google;
	
	public class KvisibleFromLeft {
	
		public int kVisibleFromLeft(int n, int k) {
			
			
			if(n==k)
				return 1;
			
			
			int dp[][]= new int[n+1][k+1];
			
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=k;j++) {
					
					if(i==j)
						dp[i][j]=1;
					
					else {
						dp[i][j]= dp[i-1][j-1]+ (i-1)*dp[i-1][j];
					}
					
				}
			}
			return dp[n][k];
		}
		
		public static void main(String[] args) {
			System.out.println(new KvisibleFromLeft().kVisibleFromLeft(5, 2));
		}
		
	}
