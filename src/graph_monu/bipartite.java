package graph_monu;

import java.util.*;


public class bipartite {

//    odd length edges count inside a loop cycle-bipartite && even length cycles are not
//    reason--> odd length cycle me edge same set me mil jate h

//    colouring a graph question involves logic for checking bipartite

//    leetcode 785 https://leetcode.com/problems/is-graph-bipartite/
    class Solution {
        public boolean isBipartite(int[][] graph) {
            Queue<Bipartite> q=new LinkedList<>();
            HashMap<Integer,Integer> visited=new HashMap<>();
            for(int i=0;i< graph.length;i++){
                if(visited.containsKey(i)){
                    continue;
                }
            q.add(new Bipartite(i,0));
                while(!q.isEmpty()){
//                    1->remove
                    Bipartite rem=q.poll();
//                    2->ignore
                    if(visited.containsKey(rem)){
                        if(visited.get(rem.vtx)!=rem.dis){
                            return false;
                        }
                    }
//                    3->add visited
                    visited.put(rem.vtx, rem.dis);
//                    4->self work(nothing here)
//                    5->add unvisited nbrs
                    for(int nbrs:graph[rem.vtx]){
                        if(!visited.containsKey(rem.vtx)){
                            q.add(new Bipartite(nbrs,rem.dis+1));
                        }
                    }
                }
            }

            return true;
        }
        class Bipartite{
            int vtx;
            int dis;
            public Bipartite(int vtx,int dis){
                this.vtx=vtx;
                this.dis=dis;
            }
        }
    }



//    Q---> What is Spanning tree?
//    Ans--->A subset of graph containing all the vertices with minimum number of edges and contains no cycle and cannot be disconnected(more than 1 part)

//    Properties of Spanning Tree
//    1->A graph can have multiple spanning tree
//    2->It need at least n-1 edges
//    3->all spanning trees have same number of vertices and edges
//    4->does not have any cycle
//    5->removing one edge from it will make it disconnected (it is minimally connected)
//      adding only 1 edge can make it cyclic


//    Q-->Minimum Spanning Tree
//    Ans->  Out of all spanning tree the one which has minimum cost

//    Kruskal's and prim's both are greedy algorithm


//    SSSR



}
