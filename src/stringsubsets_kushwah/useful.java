package stringsubsets_kushwah;

public class useful{
    public static void main(String[] args) {
        String s="a Panel A canal a snAil";
        String newS=s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        int st=0,e=newS.length()-1;
        while(st<e){
            if(newS.charAt(st)!=newS.charAt(e)) {
                System.out.println("false");
                break;
            }
        else{System.out.println("true");}
        }
        System.out.println(newS);
    }
}
