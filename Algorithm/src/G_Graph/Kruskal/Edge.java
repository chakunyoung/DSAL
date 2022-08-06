package G_Graph.Kruskal;

public class Edge implements Comparable<Edge> {
    int u; // 엣지 1
    int v; // 엣지 2
    int w; // 가중치

    public Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Edge o) {
        return w - o.w;
    } // 크루스칼은 가중치 정렬 후 사용

    @Override
    public String toString() {
        return String.format("(u=%s,v=%s,w=%s)", u, v, w);
    }
}
