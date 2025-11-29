package stringsubsets_kushwah;

import java.util.ArrayList;

public class sourceToDestiDiagonal {
    public static void main(String[] args) {
        ArrayList<String> ans=new ArrayList<>();
        helper(3,3,"",ans);
        System.out.println(ans);
    }
    static void helper(int d, int r, String st, ArrayList<String> list){
        if(d==1 && r==1){
            list.add(st);
            return;
        }
        if(d>1){helper(d-1,r,st+"d",list);}
        if(d>1 && r>1)helper(d-1,r-1,st+"D",list);
        if(r>1){helper(d,r-1,st+"r",list);}
    }
}
