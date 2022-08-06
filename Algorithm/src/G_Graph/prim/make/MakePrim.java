package G_Graph.prim.make;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
[적용 문제]
순환을 발생시키지 않으며 최소비용으로 모든 Edge 를 연결
 */
public class MakePrim {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static List<List<Edge>> list = new ArrayList<>();
    static Queue<Edge> pq = new PriorityQueue<>();
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        //int point = Integer.parseInt(st.nextToken());

        int eCount = Integer.parseInt(st.nextToken());
        int vCount = Integer.parseInt(st.nextToken());

        visit = new boolean[eCount+1]; // 방문처리
        for(int i = 0; i<=eCount; i++){
            list.add(new ArrayList<>());
        }

        //그래프
        while(vCount -- > 0){
            st = new StringTokenizer(br.readLine());
            int w1 = Integer.parseInt(st.nextToken());
            int w2 = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list.get(w1).add(new Edge(w1, w2, v));
            list.get(w2).add(new Edge(w2, w1, v));
        }

        int getW = prim(1);
        System.out.println(getW);
    }

    // q에서 뽑아서 q 시작지를 pq에 넣는다.
    // pq를 돌린다.
    // pq의 도착지가 false 라면 사용한다. // q.offer // true // break //
    // 반복
    public static int prim(int startEdge){
        int count = 0;

        while(!visit[startEdge]){
            visit[startEdge] = true;
            for(Edge g : list.get(startEdge))
                pq.offer(g);

            while(!pq.isEmpty()){
                Edge g = pq.poll();
                if(!visit[g.w2]){
                    startEdge = g.w2;
                    count += g.v;
                    break;
                }
            }
        }
        return count;
    }
}

class Edge implements Comparable<Edge>{
    int w1;
    int w2;
    int v;
    Edge(int w1, int w2, int v){
        this.w1 = w1;
        this.w2 = w2;
        this.v = v;
    }

    public int compareTo(Edge g){
        return this.v - g.v;
    }

    public String toString(){
        return w1 + " " + w2 + " " + this.v;
    }
}




