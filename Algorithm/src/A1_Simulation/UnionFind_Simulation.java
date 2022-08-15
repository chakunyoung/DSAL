package A1_Simulation;

import java.util.Arrays;

public class UnionFind_Simulation {
    static int[] set = new int[10];

    public static void main(String[] args) {
        set[2] = 2;
        set[3] = 2;
        set[4] = 3;
        set[5] = 4;

        set[6] = 6;
        set[7] = 6;
        set[8] = 6;
        set[9] = 6;

        System.out.println("fine 전: " + Arrays.toString(set));

        find(5);
        System.out.println("5번 fine 후: " + Arrays.toString(set));

        find(7);
        System.out.println("7번 fine 후: " + Arrays.toString(set));

        if(find(5) != find(7))
            union(5, 7);
        System.out.println("union: " + Arrays.toString(set));

        // 대표값이 같아서 union call() 이 되지 않는다.
        if(find(5) != find(8))
            union(5, 8);
        System.out.println("union: " + Arrays.toString(set));
    }

    // 사이클 확인은 (find != find) 로 가능
    // 소속을 찾는다.
    public static int find(int n){
       if(n == set[n])
           return n;

        return set[n] = find(set[n]);
    }

    // 들어오기전에 n1==n2 검사를 함
    // edge 를 연결하는 같지 않으면 union 이 가능하다.
    public static void union(int n1, int n2){
        System.out.println("union() call");

        // 대표값을 찾는다.
        int rep1 = find(n1);
        int rep2 = find(n2);
        System.out.println(rep1 + " " + rep2);

        // 둘중 작은 대표 값을 대표값으로 설정
        if(rep1 > rep2){
            set[rep2] = rep2;
        }else
            set[rep2] = rep1;
    }
}
