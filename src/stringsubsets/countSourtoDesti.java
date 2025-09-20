package stringsubsets;

public class countSourtoDesti {
    public static void main(String[] args) {
        //both works
        System.out.println(helper(3,3));
        System.out.println(helper2(3,3));
    }
    //d represents down and r right
    static int helper(int d,int r){
        if(d==1 && r==1){
            return 1;
        }
        int count=0;
        if(d>1){
            count+=helper(d-1,r);
        }
        if(r>1){
            count+=helper(d,r-1);
        }
        return count;

    }
    static int helper2(int d,int r){
        if(d==1 || r==1){
            return 1;
        }
        int left=helper2(d-1,r);
        int right=helper2(d,r-1);
        return left+right;
    }
}
