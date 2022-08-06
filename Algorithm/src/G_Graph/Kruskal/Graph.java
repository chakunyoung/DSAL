package G_Graph.Kruskal;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

// TODO : keyword : ���μ� ����(���Ͽ� ���ε�), �켱���� ť
// TODO : ���� �켱����ť�� edge �� �־��

public class Graph {
    final Queue<Edge> q; // �켱���� ť(MinHeap) // ��ü ������ �̰��� ����
    final int[] disjointSet; // ���μ� ���� // index ���� ��ȣ, value ��ǥ����

    public Graph() {
        q = new PriorityQueue<>();
        disjointSet = new int[6];

        for (int i = 0; i < disjointSet.length; i++)
            disjointSet[i] = i;
    }

    public void undirectedEdge(int u, int v, int w) {
        q.add(new Edge(u, v, w));
    }

    private int find(int x) { // TODO : �ش� ������ "��ǥ ���Ұ�" �� ã�´�.
        if (disjointSet[x] == x)   // ����Լ� ���� ����
            return x;
        else
            return disjointSet[x] = find(disjointSet[x]); // ������ ���� ��� // ���δ� 0���� �������     // L-VALUE �� RETURN
    }

    private void union(int u, int v) { // ����Ŭ ������ : ��� ������ union �ϴ� �������� ���� find �� ���ٸ� ����Ŭ �߻�
        u = find(u); // 2 ���� -> 1
        v = find(v); // 5 ���� -> 4
        // ""��ǥ ����""�� ���� �ٲ�
        if (u < v)
            disjointSet[v] = u;
        else
            disjointSet[u] = v;
    }

    // 1 2 3 -> 1���׷� // 4 5 6 -> 4�� �׷�
    // 2�� 5�� union �ϸ� .. 1�� 4 �� ã��, 4���� 1�� �ٲ۴�. (��ǥ�� �ٲ۴�)
    public Set<Edge> getMST() {
        Set<Edge> safeEdgeSet = new HashSet<>();
        while (!q.isEmpty()) {       // ������ ���� �� �̸� �־����
            Edge edge = q.poll();
            // TODO : ��ǥ ���Ұ� ���� �ٸ��� ���� �ٸ� �κ� �����̴�. // ���ᰡ��
            if (find(edge.u) != find(edge.v)) { // ����Ŭ �����õǸ� ������ ������� �ʴ´�.
                union(edge.u, edge.v); // �����ϱ� (��ǥ���� ����)
                safeEdgeSet.add(edge);  // ���� ������ add
            }
        }
        return safeEdgeSet;
    }
}
