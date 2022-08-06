package G_Graph.�ִܰŸ�;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
2���� �迭�� low ���, col ����, value ����ġ

��� �߰� k �� �����鼭
(��� - �߰�) (�߰� - ����)
����

�ڽ��� 0 �������� INF
���� �׷����� ���� �ִ�.

Ž���� �ƴ϶� "������� �ִܰ��"
 */

public class Floyd {
    static int N, M;
    static int[][] dist;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        // �÷��̵� �ʱ� �Ÿ� graph �ʱ�ȭ
        // �ڱ� �ڽ��� 0
        dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                }else
                    dist[i][j] = 100_000_000;
            }
        }

        // �⺻ graph �ʱ�ȭ
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            // ���� ��ΰ� �ϳ��� �ƴ� �� �ִ�. ���� �� �� �ּ� ����� �����صθ� �ȴ�.
            dist[a][b] = Math.min(dist[a][b], cost);
            dist[b][a] = Math.min(dist[b][a], cost);
        }

        // �÷��̵� ���� �˰���
        // �߿��Ѱ� "������ K" �̴�. K�� ���̿��ΰ� �������� ���� ��� ����� ���� ���� -> �׷��Ƿ� ��� ��尡 �������� �������� �ȴ�.
        // ���� -> �� �� ���ϱ� // �������̾��� ���� �ϳ��� �߰���ġ�� ���̰� �Ǽ� ���̴ϱ�

        for (int k = 0; k < N; k++) {
            // ��� i���� j�� ���� ���.
            for (int i = 0; i < N; i++) {  // i -> j  �� N �� "��� ����"�� ��
                for (int j = 0; j < N; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]); // ���� ������� �� // �߰� k �� �� //
                    //                          ���� dist[i][k] �ݾ� ���±��� k���� ���鼭 ������ ��� �����غ��鼭 �Դٰ�
                }
            }
        }

        // ���
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // ������ �ȵǾ� �ִ� ���
                if (dist[i][j] == 100_000_000) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}

/*
sample input(ù ��° ���ڴ� ����� ����, �� ��° ���ڴ� ������ ���� �̴�).
5
8
0 1 5
0 4 1
0 2 7
0 3 2
1 2 3
1 3 6
2 3 10
3 4 4
 */