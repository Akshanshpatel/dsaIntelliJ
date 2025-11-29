package recursion_monu;

public class start {
    public static void main(String[] args) {

        //code for pow(n,x)-->n to power x
        int a=3,b=5;
        System.out.print(pow(3,5));
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
}
