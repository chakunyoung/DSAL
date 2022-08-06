package A1_Simulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 우선순위 큐, dist
// 가중치가 음수면 안됨

// 경유지, 도착지


public class Dijk_Simulation {
    static int[] dist;
    static List<List<Node1>> list = new ArrayList<>();

    static final int edgeCount = 5 + 1;
    static final int vCount = 7;

    public static void main(String[] args) {

        dist = new int[edgeCount]; // 0 사용안함.

        //간선 7개
        for(int i = 0; i<=vCount; i++) {
            list.add(new ArrayList<>());
        }

        // (1 - > 5) 2000 쓰는 경로
        list.get(1).add(new Node1(4, 2000));
        list.get(1).add(new Node1(5, 2000));

        // (1 -> 5) 10 쓰는 경로
        list.get(1).add(new Node1(2, 5));
        list.get(2).add(new Node1(5, 5));

        // (1 -> 5) 3 쓰는 경로
        list.get(1).add(new Node1(3, 1));
        list.get(3).add(new Node1(4, 1));
        list.get(4).add(new Node1(5, 1));


        //## 주의!!!
        Arrays.fill(dist, 10000000);
        dist[1] = 0;

        dijk();

        System.out.println(Arrays.toString(dist));
        // [10000000, 0, 5, 1, 2, 3]

    }

    public static void dijk() {





    }
}

class Node1{
    int dest;
    int w;

    public Node1(int dest, int w){
        this.dest = dest;
        this.w = w;
    }
}
