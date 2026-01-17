package recursion_monu;

import java.util.*;

public class palindrome_partition {
        static int cut=Integer.MAX_VALUE;
    public static void main(String[] args) {
        String s="ab";
        List<String> local=new ArrayList<>();
        List<List<String>> ans=new ArrayList<>();
        partition(s,local,ans);
        System.out.println(ans);
        System.out.println("Minimum cut-->"+cut);
        //minimum cost works here in brute force but for long strings
        //gives TLE DP required
    }

    public static void partition(String ques,List<String> local,List<List<String>> ans){
        if(ques.length()==0){
            cut=Math.min(cut,local.size()-1);
            ans.add(new ArrayList<>(local));
            return;
        }

        for(int i=1;i<=ques.length();i++){
            String s=ques.substring(0,i);

            if(checker(s)){
                local.add(s);
                partition(ques.substring(i),local,ans);
                local.remove(local.size()-1);
            }
        }
    }
    public static boolean checker(String st){
        int s=0,e=st.length()-1;
        while(s<e){
            if(st.charAt(s++)!=st.charAt(e--)){
                return false;
            }
        }
        return true;
    }
}
