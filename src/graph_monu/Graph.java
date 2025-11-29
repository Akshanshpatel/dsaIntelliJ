package graph_monu;

import java.util.*;

public class Graph{

    HashMap<Integer, HashMap<Integer,Integer>> map=new HashMap<>();   //inside hashmap has two integer one edge other cost
    //graph classs for putting 1 to v1 range vertices by default
    public  Graph(int v1){
        for(int i=1;i<=v1;i++){
            map.put(i,new HashMap<>());
        }
    }

    //add vertices function
    public void addVertex(int v1){
        map.put(v1,new HashMap<>());
    }

    //adding edge in the graph
    public void addEdge(int v1,int v2,int cost){
        map.get(v1).put(v2,cost);
        map.get(v2).put(v1,cost);
    }

    //checking if containsEdge
    public boolean containsEdge(int v1,int v2){
        return map.get(v1).containsKey(v2);
    }

    //if contains vertices
    public boolean containsVertices(int v1){
        return map.containsKey(v1);
    }

    //getting no of edges
    public int noOfEdges(){
        int sum=0;
        for(int key:map.keySet()){
            sum+=map.get(key).size();
        }
        return sum/2;
    }

    //displaying the graph
    public void display(){
        for(int key:map.keySet()){
            System.out.println(key+"="+map.get(key));
        }
    }

    //removing an edge
    public void removeEdge(int v1,int v2){
        map.get(v1).remove(v2);
        map.get(v2).remove(v1);
    }

    public void removeVertex(int v1){
        for(int key:map.get(v1).keySet()){
            map.get(key).remove(v1);
            //removing links that were with the to be removed vertex
        }
        //removing vertex here
        map.remove(v1);
    }

    //has path or not
    public boolean hasPath(int src, int des, HashSet<Integer> visited) {
        if(src==des) {
            return true;
        }
        visited.add(src);
        for(int key:map.get(src).keySet()){   //without set it will give stackoverflow cz
            if(!visited.contains(key)) {
                boolean ans = hasPath(key, des, visited);     //1 will look for 3 and 3 for 1 and on nd on
                if (ans) {
                    return true;
                }
            }
        }
        return false;
    }

    //printing all path
    public void printAllPath(int src, int des, HashSet<Integer> visited,String ans) {
        if(src==des) {
            System.out.println(ans+des); //des cz recursion will stop at getting dest and will not add it
            return;
        }
        visited.add(src);
        for(int key:map.get(src).keySet()){   //without set it will give stackoverflow cz
            if(!visited.contains(key)) {
               printAllPath(key, des, visited,ans+src);     //1 will look for 3 and 3 for 1 and on nd on

            }
        }
        visited.remove(src);  //backtracking step without this we will not get all paths
                              //ex-4 will be in the set already it will not get in for a new path
    }


//---------------------------------------BFS-------------------------------------------
//in case of finding shortest path use this

    public boolean BFS(int src,int des){
        Queue<Integer> q=new LinkedList<>();
        q.add(src);
        HashSet<Integer> visited=new HashSet<>();
        while(!q.isEmpty()){
            //Five steps for graphs
//1-remove
            int rem=q.poll();
//2-ignore
            if(visited.contains(rem)){
                continue;
            }
//3-visited
            visited.add(rem);
//4-self-work
            if(rem==des){
                return true;
            }
//5-Add nbrs(key) which are unvisited
            for(int key:map.get(rem).keySet()) {
                if (!visited.contains(key)) {
                    q.add(key);
                }
            }
        }
        return false;
    }


//---------------------------------------DFS-------------------------------------------
//don't use this in case of shortest path cz this search the whole path of a key in depth -->give bad results

    public boolean DFS(int src,int des){
        HashSet<Integer> visited=new HashSet<>();
        Stack<Integer> st=new Stack<>();
        st.push(src);
        while(!st.isEmpty()) {
//        1-remove
            int rem=st.pop();
//        2-ignore
            if(st.contains(rem)){   //if found here cycle detected same in bfs also
                continue;
            }
//        3-visited
            st.add(rem);
//        4-self work
            if(rem==des){
                return true;
            }
//        5-add nbrs(key) unvisited
            for(int key:map.get(rem).keySet()){
                if(!visited.contains(key)){
                    st.push(key);
                }
            }
        }
        return false;
    }
}
