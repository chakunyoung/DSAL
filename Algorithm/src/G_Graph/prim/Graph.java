package G_Graph.prim;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

/*
������ �׸���, �湮ó���� ����ؼ� BFS ó�� ����Ѵ�.
 */
public class Graph {
    final LinkedList<Edge>[] graph;
    final boolean[] visit;

    @SuppressWarnings("unchecked")
    public Graph() { // ������ - (�湮ó��, ����)
        visit = new boolean[6]; // �湮ó��
        graph = new LinkedList[6]; // ���� 6��
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new LinkedList<>(); // 6�� ���� ��ü ����
        }
    }

    // ����� ���� // 2���� LinkedList
    public void undirectedEdge(int u, int v, int w) { // MAP ������ �߰�
        graph[u].add(new Edge(u, v, w));
        graph[v].add(new Edge(v, u, w));
    }

    // ������ �� ����� ���¿��� getMST
    // u ����, v ����
    public ArrayList<Edge> getMST() {
        int vertex = 0; // 0�� �����ߴٰ� ����.
        PriorityQueue<Edge> edgeQueue = new PriorityQueue<>(); // �켱����ť, ���� ����
        ArrayList<Edge> safeEdge = new ArrayList<>(); // ���� ����� ����
        
        while (!visit[vertex]) { // 0���� ����. �湮x �� �湮���� ����
            visit[vertex] = true;

            // �ش� ������ ������ �߰��ϱ�
            for (Edge edge : graph[vertex]) {
                if (!visit[edge.v]) { // ������ �������� �湮X �� �� ��
                    edgeQueue.add(edge);
                }
            }
            
            while (!edgeQueue.isEmpty()) { // ���� vertex �渷���� �������� �湮ó�� x �ΰ� ã�Ƽ� ���Ե�.
                Edge edge = edgeQueue.poll(); 
                if (!visit[edge.v]) { // (������ ������)�湮x, (������ �湮ó�� �������� ������ ��� Ȯ��)
                    safeEdge.add(edge); // ���� �������� ���
                    vertex = edge.v; // ������ ���⸦ �������� ��������
                    break; // ����� ������ ������ (���� ����) -> (���� ����) ���� ��ü
                }
            }
        }
        return safeEdge; // ���� ���� ����
    }
}
