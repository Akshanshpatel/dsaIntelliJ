package graph;

import java.util.HashMap;

public class Graph {


    HashMap<Integer,HashMap<Integer,Integer>> map=new HashMap<>();
    public  Graph(int v){
        for(int i=1;i<=v;i++){  //lowda
            map.put(i,new HashMap<>());
        }
    }
    public void AddEdge(int v1,int v2,int cost){
        map.get(v1).put(v2,cost);
        map.get(v2).put(v1,cost);
    }
    public boolean ContainsEdge(int v1,int v2){
    return map.get(v1).containsKey(v2);
    }
    public boolean ContainsVertex(int v1){
        return map.containsKey(v1);
    }
    public int noofedges(){
    int sum=0;
    for(int key: map.keySet()){
        sum+=map.get(key).size();
    }
    return sum/2;  // by 2 bcz every vertex is counted twice
    }

    public void removeEdge(int v1,int v2){
        map.get(v1).remove(v2);
        map.get(v2).remove(v1);
    }

    public void removeVertex(int v1){
        for(int nbrs:map.get(v1).keySet()){
            map.get(nbrs).remove(v1);
        }
        map.remove(v1);
    }

    public void display(){
        for(int key:map.keySet()){
            System.out.println(key+""+map.get(key));
        }
    }
}
