package A1_Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TopologySort_Simulation {
    static int[] indegree;
    static Queue<Integer> q = new PriorityQueue<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static List<List<Integer>> list = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int edges = Integer.parseInt(st.nextToken());
        int lines = Integer.parseInt(st.nextToken());

        indegree = new int[edges + 1];

        for(int i = 0; i<=edges; i++)
            list.add(new ArrayList<>());

        while(lines -- > 0){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.get(start).add(end);
            indegree[end]++;
        }
        ts();
        System.out.println(sb.toString());

    }
    public static void ts(){

        for(int i = 1; i<indegree.length; i++){
            if( 0 == indegree[i]){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int edge = q.poll(); // 이제부터 얘를 가르키는애는 없다.
            sb.append(edge).append(" "); // 결과에 추가

            for(int ele : list.get(edge)){
                indegree[ele]--;
                if(indegree[ele] == 0){
                    q.offer(ele);
                }
            }
        }
    }
}
