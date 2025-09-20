package stringsubsets;

public class dice {
    public static void main(String[] args) {
        helper("",4);
    }
    static void helper(String p,int target){
        if(target==0){
            System.out.println(p);
        }
        for(int i=1;i<=6 && i<=target;i++){
            helper(p+i,target-i);
        }
    }
}
