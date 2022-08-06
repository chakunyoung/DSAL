package G_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// keyword: inDegree

/*
��������( indegree ���� ���� ) // ��ũƮ��

        [���� ����]
        3���� 1, 2 �� �տ� �ִ°� Ȯ��
        ������ 1, 2 �� ������ ����.
        1,2,3
        2,1,3 �Ѵ� ����.

        "����׷���"
        ������ �ִ°�.
        a->b->c
        d->

        [�˰���]
        deg 0 �ξֵ��� ���� ť�� �־��.
        "����Ű�� �ֵ�" deg ��
        ����Ų deg �� 0�� �Ǹ� ť�� ����.
*/

public class �������� {
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

        // 0���� ������� ����.
        for(int i = 0; i<=student; i++)
            list.add(new ArrayList<>());

        // �׷��� 
        while(lines-- > 0){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            list.get(first).add(second);
            ++deg[second];
        }

        // inDegree �� ���� ���� int[] �� �־� ��.

        // ��������
        for (int i = 1; i < deg.length; i++) { // deg �� 0�� �ֵ��� ���� ���� ť�� �־��
            if (deg[i] == 0)
                q.add(i);
        }

/////////

        while (!q.isEmpty()) { // ���� 0�� edge
            int edge = q.poll();
            List<Integer> v = list.get(edge);

            System.out.println(edge + " ");
            for (int e : v) {
                deg[e]--;  // 0�� ����� ���� �ϳ� �ٿ���

                if (deg[e] == 0) // deg 0�� �Ǹ� �ش� edge �� ����� �غ� �� �� (�� ��ũƮ���� ���� �Ϸ� ��)
                    q.add(e); // q�� �ִ´�.
            }
        }
    }
}
