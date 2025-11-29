package graph_monu;

import java.util.*;

public class kruskel_prim {




    class prep {
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();

        public prep(int v1) {    //this line is the constructor
            for (int i = 1; i <= v1; i++) {
                map.put(i, new HashMap<>());
            }
        }
        public void AddEdge(int v1,int v2,int cost){
            map.get(v1).put(v2,cost);
            map.get(v2).put(v1,cost);
        }

        class EdgePair{
            int e1;
            int e2;
            int cost;
            public EdgePair(int e1,int e2,int cost){
                this.e1= e1;
                this.e2= e2;
                this.cost= cost;
            }
        }
        public List<EdgePair> getAllEdge(){
            List<EdgePair> ll=new ArrayList<>();
            for(int e1:map.keySet()){
                for(int e2:map.get(e1).keySet()){
                    int cost=map.get(e1).get(e2);
                    ll.add(new EdgePair(e1,e2,cost));
                }
            }
            return ll;
        }
    }


    class DisjointSet {

        class Node {
            int rank;
            int data;
            Node parent;
        }

        private HashMap<Integer, Node> map = new HashMap<>();

        public void CreateSet(int v){  //O(1)
            Node nn=new Node();
            nn.data=v;
            nn.rank=0;
            nn.parent=nn;
            map.put(v,nn);
        }
        public int find(int v){   //O(logn) where n is height while getting parent node
            Node nn=map.get(v);
            return find(nn).data;
        }
        private Node find(Node nn){
            if(nn.parent==nn){
                return nn;
            }
//            return find(nn.parent); this gets replaced by path compression-->O(1)
            Node n=find(nn.parent);
            nn.parent=n;
            return n;
        }
        public void Union(int v1,int v2){
            Node nn1=map.get(v1);
            Node nn2=map.get(v2);
            Node rn1=find(nn1);
            Node rn2=find(nn2);
            if(rn1.rank<=rn2.rank){
                rn1.parent=rn2;
                rn2.rank++;
            }else{
                rn2.parent=rn1;
                rn1.rank++;
            }
        }
    }
}