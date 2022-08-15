package A1_Simulation;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DFSBFSSimulation {
    static int[][] graph = {{}, {2, 3, 8}, {1, 6, 8}, {1, 5}, {5, 7}, {3, 4, 7}, {2}, {4, 5}, {1, 2}};
    static boolean[] v = new boolean[10];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        bfs(1);
        System.out.println("bfs:" + sb.toString());
        sb.setLength(0);
        Arrays.fill(v, false);
        dfs(1);
        System.out.println("dfs:" +sb.toString());
    }

    public static void bfs(int s){

    }

    public static void dfs(int s){



    }
}
