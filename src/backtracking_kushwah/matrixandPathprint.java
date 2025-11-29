package backtracking_kushwah;

import java.util.Arrays;

public class matrixandPathprint {
    public static void main(String[] args) {
        //pre-requisite type but with all 4 directions
        boolean[][] maze={
                {true,true,true},
                {true,true,true},
                {true,true,true}
        };
        int[][] path=new int[maze.length][maze[0].length];
        helper(0,0,"",maze,path,1);
    }
    static void helper(int d,int r,String st,boolean[][] maze,int[][] path,int step){
        if(d==maze.length-1 && r==maze[0].length-1){
            //last step here
            path[d][r]=step;
            for(int[] arr:path){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(st);
            return;
        }
        if(maze[d][r]==false){
            return;
        }

        //considering cell in my path
        maze[d][r]=false;
        path[d][r]=step;

        if(d<maze.length-1){
            helper(d+1,r,st+"d",maze,path,step+1);
        }
        if(r<maze[0].length-1){
            helper(d,r+1,st+"r",maze,path,step+1);
        }
        if(d>0){
            helper(d-1,r,st+"u",maze,path,step+1);
        }
        if(r>0){
            helper(d,r-1,st+"l",maze,path,step+1);
        }

        //backtracking step
        maze[d][r]=true;
        path[d][r]=0;
    }
}


//Simple hint-->When a choice affect future answers use backtracking