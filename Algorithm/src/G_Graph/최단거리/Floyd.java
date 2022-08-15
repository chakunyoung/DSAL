package G_Graph.최단거리;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
2차원 배열로 low 출발, col 도착, value 가중치

모든 중간 k 를 넣으면서
(출발 - 중간) (중간 - 도착)
갱신

자신은 0 나머지는 INF
방향 그래프일 수도 있다.

탐색이 아니라 "모든경로의 최단경로"
 */

public class Floyd {
    static int N, M;
    static int[][] dist;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        // 플로이드 초기 거리 graph 초기화
        // 자기 자신은 0
        dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                }else
                    dist[i][j] = 100_000_000;
            }
        }

        // 기본 graph 초기화
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            // 가는 경로가 하나가 아닐 수 있다. 따라서 그 중 최소 비용을 저장해두면 된다.
            dist[a][b] = Math.min(dist[a][b], cost);
            dist[b][a] = Math.min(dist[b][a], cost);
        }

        // 플로이드 워셜 알고리즘
        // 중요한건 "사이인 K" 이다. K를 사이에두고 양쪽팔을 벌려 모든 경우의 수를 본다 -> 그러므로 모든 노드가 최적으로 떨어지게 된다.
        // 시작 -> 끝 만 보니깐 // 양쪽팔이었던 것중 하나가 중간위치에 놓이게 되서 쓰이니깐

        for (int k = 0; k < N; k++) {
            // 노드 i에서 j로 가는 경우.
            for (int i = 0; i < N; i++) {  // i -> j  는 N 번 "계속 갱신"을 함
                for (int j = 0; j < N; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]); // 현재 사용중인 것 // 중간 k 인 것 //
                    //                          보면 dist[i][k] 잖아 여태까지 k까지 오면서 최적을 계속 저장해보면서 왔다고
                }
            }
        }

        // 출력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 연결이 안되어 있는 경우
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
sample input(첫 번째 숫자는 노드의 개수, 두 번째 숫자는 간선의 개수 이다).
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