package G_Graph.�ִܰŸ�;
import java.util.*;

// TODO: keyword: ���-����-����, dist(INF, �������� 0), �켱 ���� ť

// �������� ������� �ּҺ�� ���� ��
// bfs �� ������

// ***�������� ť�� �־� �������� �������� ����Ѵ�.
// �������� ����� ���������� Ȯ���ϸ� �ּҺ���� �������� �� �ִ�.

public class Dijkstra {
    static int[] dist;
    static int[] path; // �ڽ��� �� ��θ� ���� �ִ�. ** ��� ��θ� Ȯ���� �� �ִ�.

    static List<List<Node>> list = new ArrayList<>(); // ������

    static final int edgeCount = 5 + 1;
    static final int vCount = 7;

    public static void main(String[] args) {
        //��� 5��
        dist = new int[edgeCount]; // 0 ������.
        path = new int[edgeCount];
        //���� 7��
        for(int i = 0; i<=vCount; i++) {
            list.add(new ArrayList<>());
        }

        // (1 - > 5) 2000 ���� ���
        list.get(1).add(new Node(4, 2000));
        list.get(1).add(new Node(5, 2000));

        // (1 -> 5) 10 ���� ���
        list.get(1).add(new Node(2, 5));
        list.get(2).add(new Node(5, 5));

        // (1 -> 5) 3 ���� ���
        list.get(1).add(new Node(3, 1));
        list.get(3).add(new Node(4, 1));
        list.get(4).add(new Node(5, 1));

        
        // TODO: �� �κ� ���� �ڽ��� 0���� ��������
        // �ڱ� �ڽ� ���� ������ INF �� �ʱ�ȭ
        Arrays.fill(dist, 100_000_000);
        dist[1] = 0; // ����

        
        dijk();

        // ���
        System.out.println(Arrays.toString(dist));
        // ���
        System.out.println(Arrays.toString(path));
    }

    // TODO: ����� 1���� ��� ����
    public static void dijk(){
        Queue<Node> q = new PriorityQueue<>((o1,o2) -> o1.w - o2.w);
        q.add(new Node(1, 0)); // ������, ��� (1 -> 1 -> n)

        while(!q.isEmpty()) { // TODO: ������ �̱� // 1 -> M
            Node mid = q.poll(); // 1�� ����� ������
            
            if(mid.w > dist[mid.dest]) // update �� �Ÿ����� ť���� ������ �� ũ�� ��� ���ϰ� ����
                continue;

            // TODO: ���� -> ���� ������ �κ�
            for(Node d : list.get(mid.dest)){
                if(dist[d.dest] > dist[mid.dest] + d.w){ // ������ �Ǵ� �κ�.
                    dist[d.dest] = dist[mid.dest] + d.w;
                    // ������ �� ��. 1->n , n->M
                    // 1 -> ������  // 1 -> ����  +  ���� - > ������
                    // ��� ����       ��� ����

                    // TODO: ���� �������� �������ʹ� �������� ���δ�.
                    q.offer(new Node(d.dest, dist[d.dest]));
                    // ���ŵ� (1 -> ������) �� �־��ش�.
                    // ���ŵȰ� ���� ������ for �κ��� �� Ȯ���ϱ� ������ ���ŵ� ���� �־��ִ°� ����.

                    path[d.dest] = mid.dest; // ��ã�� �뵵 (�ڽ��� �� ���)
                }
            }
        }
    }
}

// �������ε� ����, �������ε� ����
class Node{
    int dest; // ������
    int w; // ����ġ

    Node(int dest, int w){
        this.dest = dest;
        this.w = w;
    }

    public String toString(){
        return this.dest + " " + this.w;
    }
}
