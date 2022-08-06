package G_Graph.Kruskal;

public class Edge implements Comparable<Edge> {
    int u; // ���� 1
    int v; // ���� 2
    int w; // ����ġ

    public Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Edge o) {
        return w - o.w;
    } // ũ�罺Į�� ����ġ ���� �� ���

    @Override
    public String toString() {
        return String.format("(u=%s,v=%s,w=%s)", u, v, w);
    }
}
