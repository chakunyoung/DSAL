package G_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// keyword: inDegree

/*
위상정렬( indegree 세기 문제 ) // 테크트리

        [적용 문제]
        3보다 1, 2 가 앞에 있는건 확실
        하지만 1, 2 의 순서가 없다.
        1,2,3
        2,1,3 둘다 가능.

        "방향그래프"
        순서가 있는것.
        a->b->c
        d->

        [알고리즘]
        deg 0 인애들을 먼저 큐에 넣어둠.
        "가르키는 애들" deg 뺌
        가르킨 deg 가 0이 되면 큐에 넣음.
*/

public class 위상정렬 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static List<List<Integer>> list = new ArrayList<>();
    static Queue<Integer> q = new LinkedList<>();
    static int[] deg; // InDegree .

    public static void main(String[] args) throws IOException {
        List<Integer> order = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int student = Integer.parseInt(st.nextToken());
        int lines = Integer.parseInt(st.nextToken());
        deg = new int[student+1];

        // 0번은 사용하지 않음.
        for(int i = 0; i<=student; i++)
            list.add(new ArrayList<>());

        // 그래프 
        while(lines-- > 0){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            list.get(first).add(second);
            ++deg[second];
        }

        // inDegree 를 전부 세서 int[] 에 넣어 둠.

        // 위상정렬
        for (int i = 1; i < deg.length; i++) { // deg 가 0인 애들을 전부 먼저 큐에 넣어둠
            if (deg[i] == 0)
                q.add(i);
        }

/////////

        while (!q.isEmpty()) { // 현재 0인 edge
            int edge = q.poll();
            List<Integer> v = list.get(edge);

            System.out.println(edge + " ");
            for (int e : v) {
                deg[e]--;  // 0과 연결된 곳을 하나 줄여줌

                if (deg[e] == 0) // deg 0이 되면 해당 edge 가 사용할 준비가 된 것 (앞 테크트리가 전부 완료 됨)
                    q.add(e); // q에 넣는다.
            }
        }
    }
}
