package recursion_monu;

import java.util.ArrayList;

public class start {
    public static void main(String[] args) {

        //code for pow(n,x)-->n to power x
//        System.out.println(pow(3,5));
//        System.out.println(pow(3,5));
//        System.out.println(fibboo(10));
//        subSequence("abc","");
//        headTail("",3);
//        headTailNo2head("",3);
//        Permutation("abc","");

        int[] coins={2,3,5};
//        coinPerm(coins,8,"");


    }

    //this is classy example of Head based Recursion
//    call stack me action direction-->vapis ate time
    public static int pow(int a,int b){
        if(b==0){
            return 1;
        }
        int prod=pow(a,b-1);
        return prod*a;
    }

//    This is same code for pow(x,n) but tail recursion
//    no work while coming back in call stack
    public static int powTail(int a,int b){
        if(b==0){
            return a;
        }
        return powTail(a*=a,b-1);
    }

//    getting nth fibboo number
    public static int fibboo(int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        return fibboo(n-1)+fibboo(n-2);
    }

    public static void subSequence(String ques,String ans){
        if(ques.length()==0){
            System.out.println(ans);
            return;
        }
        char ch=ques.charAt(0);
        subSequence(ques.substring(1),ans);
        subSequence(ques.substring(1),ans+ch);
    }

    public static void headTail(String ans,int n){
        if(n==0){
            System.out.println(ans);
            return;
        }
        headTail(ans+"H",n-1);
        headTail(ans+"T",n-1);
    }

    public static void headTailNo2head(String ans,int n){
        if(n==0){
            System.out.println(ans);
            return;
        }

        if(ans.length()==0 || ans.charAt(ans.length()-1)!='H'){
            headTailNo2head(ans+"H",n-1);
        }
        headTailNo2head(ans+"T",n-1);
    }

    public static void Permutation(String ques,String ans){
        if(ques.length()==0){
            System.out.println(ans);
            return;
        }
        for (int i = 0; i <ques.length() ; i++) {
            Permutation(ques.substring(0,i)+ques.substring(i+1),ans+ques.charAt(i));
        }
    }

    public static void coinPerm(int[] nums,int target,String currS){
        if(target==0){
            System.out.println(currS);
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(target>=nums[i]){
                coinPerm(nums,target-nums[i],currS+nums[i]);
            }
        }
    }
}
