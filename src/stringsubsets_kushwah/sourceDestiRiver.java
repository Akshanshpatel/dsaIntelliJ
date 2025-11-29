package stringsubsets_kushwah;

public class sourceDestiRiver {
    public static void main(String[] args) {
        boolean[][] river={
                {false,false,false},
                {false,true,false},
                {false,false,false}
        };
        helper(0,0,river,"");
    }
    static void helper(int d,int r,boolean[][] river,String st){
        if(d== river.length-1 && r==river[0].length-1){
            System.out.print(st+" ");
            return;
        }
        if(river[d][r]==true){
            return;
        }
        if(d< river.length-1){
            helper(d+1,r,river,st+"d");
        }
        if(r< river[0].length-1){
            helper(d,r+1,river,st+"r");
        }
    }
}
