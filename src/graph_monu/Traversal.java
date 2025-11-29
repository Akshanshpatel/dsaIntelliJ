package graph_monu;

import java.util.*;

public class Traversal {
    HashMap<Integer, HashMap<Integer,Integer>> map=new HashMap<>();   //inside hashmap has two integer one edge other cost
    //graph class for putting 1 to v1 range vertices by default
    public  Traversal(int v1){
        for(int i=1;i<=v1;i++){
            map.put(i,new HashMap<>());
        }
    }
    //adding edge in the graph
    public void addEdge(int v1,int v2,int cost){
        map.get(v1).put(v2,cost);
        map.get(v2).put(v1,cost);
    }

//     Graphs can be disconnected too in case their components are separated (alg-alg)
//      all 5 steps are inside a loop for disconnected graphs

    public void BFT(){
        Queue<Integer> q=new LinkedList<>();
        HashSet<Integer> visited=new HashSet<>();
            int components=0;
        for(int key:map.keySet()) {
            if (!visited.contains(key)) {
                components++;
                q.add(key);
            }
            while (!q.isEmpty()){
//                1-remove
                int rem=q.poll();
//                2-ignore
                if(visited.contains(rem)){
                    continue;
                }
//                3-add visited
                visited.add(rem);
//                4-self work
                System.out.print(rem+"  ");
//            5-add nbrs(the unvisited)
            for(int nbrs:map.get(rem).keySet()){
                if(!visited.contains(nbrs)){
                    q.add(nbrs);
                }
            }
            }
        }
        System.out.println();
        System.out.println("components in this graph->"+components);
    }

    public void DFT() {
        Stack<Integer> st = new Stack<>();
        HashSet<Integer> visited = new HashSet<>();
            int components = 0;
        for (int key : map.keySet()) {
            if (!visited.contains(key)) {
                components++;
                st.push(key);
            }
            while (!st.isEmpty()) {
//                1-remove
                int rem = st.pop();
//                2-ignore
                if (visited.contains(rem)) {
                    continue;
                }
//                3-add visited
                visited.add(rem);
//                4-self work
                System.out.print(rem + "  ");
//            5-add nbrs(the unvisited)
                for (int nbrs : map.get(rem).keySet()) {
                    if (!visited.contains(nbrs)) {
                        st.push(nbrs);
                    }
                }
            }
        }
        System.out.println();
        System.out.println("components in this graph->"+components);
    }

//--------Q>>is Graph a valid tree
//--------Ans>> check for two conditions is cycle present and does it have 1 component only(both checked above in bft and dft




//-----------------------------------Main running function here----------------------------------------
public static void main(String[] args) {
    Traversal tg=new Traversal(7);
    tg.addEdge(1, 4, 6);
    tg.addEdge(1, 2, 10);
    tg.addEdge(2, 3, 7);
    tg.addEdge(3, 4, 5);
    tg.addEdge(4, 5, 1);
    tg.addEdge(5, 6, 4);
    tg.addEdge(6, 7, 3);
    tg.addEdge(7, 5, 2);

    tg.BFT();
    tg.DFT();

}
}
