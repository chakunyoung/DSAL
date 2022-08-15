package G_Graph.prim;

public class Edge implements Comparable<Edge> {
    int u;
    int v;
    int w;

    public Edge(int u, int v, int w) {
        this.u = u; // 시작
        this.v = v; // 도착
        this.w = w; // 비용
    }

    // 비교기준
    @Override
    public int compareTo(Edge o) {
        return w - o.w;
    }

    @Override
    public String toString() {
        return String.format("(u=%s,v=%s,w=%s)", u, v, w);
    }
}
