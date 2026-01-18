package dp;

public class start_dp {
    public static void main(String[] args) {
        int n=8,n2=7;
        int[] dpTD=new int[n+1];
        int[] dpBU=new int[n2+1];
        System.out.println(fibboTD(n,dpTD));
        System.out.println(fibboBU(n2,dpBU));
    }
    public static int fibboTD(int n,int[] dp){
        if(n==0 || n==1)return n;
        if(dp[n]!=0)return dp[n];  // agr value h to lao

        int f1=fibboTD(n-1,dp);
        int f2=fibboTD(n-2,dp);
        return dp[n]=f1+f2;   // results yad kr rha h
    }

    public static int fibboBU(int n,int[] dp){
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
