package G_Graph.prim;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph();
        /**
         * Undirected Graph
         *           0
         *      (2)↗↙  ↖↘(3)
         *        3      1
         *   (2)↗↙ ↖↘(3)↗↙(1)
         *     4      2
         *            ↖↘(3)
         *              5
         */
        graph.undirectedEdge(1, 0, 3); // 간선 넣어줌
        graph.undirectedEdge(3, 0, 2);
        graph.undirectedEdge(1, 2, 1);
        graph.undirectedEdge(2, 3, 3);
        graph.undirectedEdge(4, 3, 2);
        graph.undirectedEdge(2, 5, 3);

        ArrayList<Edge> list = graph.getMST();
        System.out.println(list);

        int sum = 0;
        for(Edge e: list){
            sum += e.w;
        }
        System.out.println("가중치합 "+ sum);

    }
}
