package stringsubsets;

import java.util.HashSet;

public class subsets {
    public static void main(String[] args) {
        String first = "abc ";
        HashSet substring=new HashSet<>();
        recur(first,"",substring);
        System.out.println(substring);
    }
    static void recur(String first,String second,HashSet substring){
        if(first.isEmpty()){
            substring.add(second);
            return;
        }
        char ch= first.charAt(0);
        recur(first.substring(1),second+ch,substring);
        recur(first.substring(1),second,substring);
    }
}

