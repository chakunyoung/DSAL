package A_BFSDFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
/*
거리측청은 BFS 만 가능,
DFS 불가능(파고 들어가는 성질 때문에)
 */
public class BFSDFS {
    static int[][] graph = {{}, {2, 3, 8}, {1, 6, 8}, {1, 5}, {5, 7}, {3, 4, 7}, {2}, {4, 5}, {1, 2}};
    static boolean[] v = new boolean[10];

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        bfs(1);
        System.out.println(sb);

        Arrays.fill(v, false);
        sb.setLength(0);

        dfs(1);
        System.out.println(sb);
    }

    public static void bfs(int n){
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        v[n] = true;

        while(!q.isEmpty()) {
            int s = q.poll();
            sb.append(s).append(" ");

            for (int e : graph[s]){
                if(!v[e]){
                    v[e] = true; // 큐에 딱 한번 넣는것이 효율적
                    q.offer(e);
                }
            }
        }
    }

    public static void dfs(int n){
        sb.append(n).append(" ");
        v[n] = true;
        for(int e : graph[n]){
            if(!v[e]){
                dfs(e);
            }
        }
    }
}
