package G_Graph.prim;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

/*
프림은 그리디, 방문처리를 사용해서 BFS 처럼 사용한다.
 */
public class Graph {
    final LinkedList<Edge>[] graph;
    final boolean[] visit;

    @SuppressWarnings("unchecked")
    public Graph() { // 생성자 - (방문처리, 정점)
        visit = new boolean[6]; // 방문처리
        graph = new LinkedList[6]; // 정점 6개
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new LinkedList<>(); // 6개 정점 객체 생성
        }
    }

    // 양방향 간선 // 2차원 LinkedList
    public void undirectedEdge(int u, int v, int w) { // MAP 간선들 추가
        graph[u].add(new Edge(u, v, w));
        graph[v].add(new Edge(v, u, w));
    }

    // 간선은 다 연결된 상태에서 getMST
    // u 시작, v 도착
    public ArrayList<Edge> getMST() {
        int vertex = 0; // 0에 도착했다고 시작.
        PriorityQueue<Edge> edgeQueue = new PriorityQueue<>(); // 우선순위큐, 간선 저장
        ArrayList<Edge> safeEdge = new ArrayList<>(); // 최종 연결된 간선
        
        while (!visit[vertex]) { // 0부터 시작. 방문x 면 방문으로 만듬
            visit[vertex] = true;

            // 해당 정점의 간선들 추가하기
            for (Edge edge : graph[vertex]) {
                if (!visit[edge.v]) { // 간선의 도착지가 방문X 인 것 만
                    edgeQueue.add(edge);
                }
            }
            
            while (!edgeQueue.isEmpty()) { // 현재 vertex 길막혀도 목적지가 방문처리 x 인걸 찾아서 돌게됨.
                Edge edge = edgeQueue.poll(); 
                if (!visit[edge.v]) { // (간선의 도착지)방문x, (이전에 방문처리 됐을수도 있으니 계속 확인)
                    safeEdge.add(edge); // 최종 간선으로 사용
                    vertex = edge.v; // 다음은 여기를 기준으로 돌릴꺼임
                    break; // 여기는 연결이 끝낫고 (도착 정점) -> (시작 정점) 으로 교체
                }
            }
        }
        return safeEdge; // 최종 연결 간선
    }
}
