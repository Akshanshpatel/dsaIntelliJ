package dp;

import java.util.Arrays;

public class House_Robber {
    public static void main(String[] args) {
        int[] nums={5,7,3,13,4,30};
        int[] dp=new int[nums.length];
        Arrays.fill(dp,-1);
//        Fill dp with something that can't be any output in any recursion call
//        ex-here no house can have -ve money

//        System.out.println(robber_TopD(nums,dp,0));
          System.out.println(robber_BottomUp(nums,dp));

    }

    public static int robber_TopD(int[] nums,int[] dp,int curr){
        if(curr>= nums.length){
            return 0;
        }
        if(dp[curr]!=-1)return dp[curr];

        int rob=robber_TopD(nums,dp,curr+2)+nums[curr];
        int noRob=robber_TopD(nums,dp,curr+1);
        return dp[curr]=Math.max(rob,noRob);
    }

    public static int robber_BottomUp(int[] nums,int[]dp){
        int n=nums.length;
        dp[n-1]=nums[n-1];
        dp[n-2]=nums[n-2];
        for(int i=n-1;i>=2;i--){
            int rob=dp[i]+nums[i-2];
            int noRob=dp[i-1];
            dp[i-2]=Math.max(rob,noRob);
        }
        return dp[0];
    }
}
