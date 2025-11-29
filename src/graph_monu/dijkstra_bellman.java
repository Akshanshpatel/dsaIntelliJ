package graph_monu;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class dijkstra_bellman {

    HashMap<Integer,HashMap<Integer,Integer>> map=new HashMap<>();
    public dijkstra_bellman(int v){
        for(int i=0;i<v;i++){
            map.put(i,new HashMap<>());
        }
    }

    public void addEdge(int v1,int v2,int cost){
        map.get(v1).put(v2,cost);
        map.get(v2).put(v1,cost);
    }

    class dijkstraPair{
        int vtx;
        String path;
        int cost;
        public dijkstraPair(int vtx,String path,int cost){  //constructor for dijkstra datatype
            this.vtx=vtx;
            this.path=path;
            this.cost=cost;
        }
        public String toString(){
            return this.vtx+" through "+this.path+"  costing-> $"+this.cost;
        }
    }

    public void Dijkstra(int src){
        PriorityQueue<dijkstraPair> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        HashSet<Integer> visited=new HashSet<>();
        pq.add(new dijkstraPair(src,""+src,0));
        while(!pq.isEmpty()){
//            1->remove
            dijkstraPair rem=pq.poll();
//            2->ignore if already visited
            if(visited.contains(rem.vtx)){
                continue;
            }
//            3->add visited
            visited.add(rem.vtx);
//            4->self work
            System.out.println(rem);
//            5->add unvisited nbrs
            for(int nbrs:map.get(rem.vtx).keySet()){
                if(!visited.contains(nbrs)){
                    int cost=map.get(rem.vtx).get(nbrs);
                    pq.add(new dijkstraPair(nbrs, rem.path+nbrs,rem.cost+cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        dijkstra_bellman dj = new dijkstra_bellman(8);
        dj.addEdge(1, 4, 6);
        dj.addEdge(1, 2, 10);
        dj.addEdge(2, 3, 7);
        dj.addEdge(3, 4, 5);
        dj.addEdge(4, 5, 1);
        dj.addEdge(5, 6, 4);
        dj.addEdge(6, 7, 3);
        dj.addEdge(7, 5, 2);
        dj.Dijkstra(2);

    }
//  Dijkstra is not right for negative weights
//    so we study bellman-ford  but -ve weight in a cycle can't be determined
//    cz in each cycle weight can be reduced this can't be determined


//    Topological sorting
//    It is a linear ordering of a DAG(Directed Acyclic Graph) such that for every directed edge u to v , u will come before v in that ordering
//    a DAG will have at least one Topological order
}
