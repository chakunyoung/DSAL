package G_Graph.최단거리;
import java.util.*;

// TODO: keyword: 출발-경유-도착, dist(INF, 시작지는 0), 우선 순위 큐

// 한점에서 모든노드의 최소비용 구할 때
// bfs 와 유사함

// ***목적지를 큐에 넣어 다음부터 경유지로 사용한다.
// 경유지와 연결된 목적지들을 확인하며 최소비용을 갱신해줄 수 있다.

public class Dijkstra {
    static int[] dist;
    static int[] path; // 자신의 앞 경로를 갖고 있다. ** 모든 경로를 확인할 수 있다.

    static List<List<Node>> list = new ArrayList<>(); // 간선들

    static final int edgeCount = 5 + 1;
    static final int vCount = 7;

    public static void main(String[] args) {
        //노드 5개
        dist = new int[edgeCount]; // 0 사용안함.
        path = new int[edgeCount];
        //간선 7개
        for(int i = 0; i<=vCount; i++) {
            list.add(new ArrayList<>());
        }

        // (1 - > 5) 2000 쓰는 경로
        list.get(1).add(new Node(4, 2000));
        list.get(1).add(new Node(5, 2000));

        // (1 -> 5) 10 쓰는 경로
        list.get(1).add(new Node(2, 5));
        list.get(2).add(new Node(5, 5));

        // (1 -> 5) 3 쓰는 경로
        list.get(1).add(new Node(3, 1));
        list.get(3).add(new Node(4, 1));
        list.get(4).add(new Node(5, 1));

        
        // TODO: 이 부분 주의 자신은 0으로 만들어야함
        // 자기 자신 빼고 나머지 INF 로 초기화
        Arrays.fill(dist, 100_000_000);
        dist[1] = 0; // 시작

        
        dijk();

        // 결과
        System.out.println(Arrays.toString(dist));
        // 경로
        System.out.println(Arrays.toString(path));
    }

    // TODO: 출발지 1번은 계속 고정
    public static void dijk(){
        Queue<Node> q = new PriorityQueue<>((o1,o2) -> o1.w - o2.w);
        q.add(new Node(1, 0)); // 경유지, 비용 (1 -> 1 -> n)

        while(!q.isEmpty()) { // TODO: 경유지 뽑기 // 1 -> M
            Node mid = q.poll(); // 1과 연결된 경유지
            
            if(mid.w > dist[mid.dest]) // update 된 거리보다 큐에서 뽑은게 더 크면 사용 안하고 버림
                continue;

            // TODO: 경유 -> 도착 꺼내는 부분
            for(Node d : list.get(mid.dest)){
                if(dist[d.dest] > dist[mid.dest] + d.w){ // 갱신이 되는 부분.
                    dist[d.dest] = dist[mid.dest] + d.w;
                    // 갱신이 된 것. 1->n , n->M
                    // 1 -> 도착지  // 1 -> 경유  +  경유 - > 도착지
                    // 계속 갱신       계속 생신

                    // TODO: 현재 목적지가 다음부터는 경유지로 쓰인다.
                    q.offer(new Node(d.dest, dist[d.dest]));
                    // 갱신된 (1 -> 목적지) 를 넣어준다.
                    // 갱신된걸 넣지 않으면 for 부분을 또 확인하기 때문에 갱신된 값을 넣어주는게 좋다.

                    path[d.dest] = mid.dest; // 길찾기 용도 (자신의 앞 노드)
                }
            }
        }
    }
}

// 경유지로도 쓰고, 목적지로도 쓰임
class Node{
    int dest; // 도착지
    int w; // 가중치

    Node(int dest, int w){
        this.dest = dest;
        this.w = w;
    }

    public String toString(){
        return this.dest + " " + this.w;
    }
}
