package G_Graph.Kruskal;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

// TODO : keyword : 서로소 집합(유니온 파인드), 우선순위 큐
// TODO : 먼저 우선순위큐에 edge 다 넣어둠

public class Graph {
    final Queue<Edge> q; // 우선순위 큐(MinHeap) // 전체 엣지를 이곳에 넣음
    final int[] disjointSet; // 서로소 집합 // index 엣지 번호, value 대표원소

    public Graph() {
        q = new PriorityQueue<>();
        disjointSet = new int[6];

        for (int i = 0; i < disjointSet.length; i++)
            disjointSet[i] = i;
    }

    public void undirectedEdge(int u, int v, int w) {
        q.add(new Edge(u, v, w));
    }

    private int find(int x) { // TODO : 해당 원소의 "대표 원소값" 을 찾는다.
        if (disjointSet[x] == x)   // 재귀함수 종료 조건
            return x;
        else
            return disjointSet[x] = find(disjointSet[x]); // 마지막 값을 사용 // 전부다 0으로 만들어줌     // L-VALUE 가 RETURN
    }

    private void union(int u, int v) { // 사이클 디텍팅 : 모든 간선을 union 하는 과정에서 만약 find 가 같다면 사이클 발생
        u = find(u); // 2 정점 -> 1
        v = find(v); // 5 정점 -> 4
        // ""대표 원소""의 값을 바꿈
        if (u < v)
            disjointSet[v] = u;
        else
            disjointSet[u] = v;
    }

    // 1 2 3 -> 1번그룹 // 4 5 6 -> 4번 그룹
    // 2와 5를 union 하면 .. 1과 4 를 찾고, 4번을 1로 바꾼다. (대표를 바꾼다)
    public Set<Edge> getMST() {
        Set<Edge> safeEdgeSet = new HashSet<>();
        while (!q.isEmpty()) {       // 간선을 전부 다 미리 넣어뒀음
            Edge edge = q.poll();
            // TODO : 대표 원소가 서로 다르면 서로 다른 부분 집합이다. // 연결가능
            if (find(edge.u) != find(edge.v)) { // 사이클 디텍팅되면 간선을 사용하지 않는다.
                union(edge.u, edge.v); // 연결하기 (대표원소 변경)
                safeEdgeSet.add(edge);  // 연결 엣지들 add
            }
        }
        return safeEdgeSet;
    }
}
