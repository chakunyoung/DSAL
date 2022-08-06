package A1_Simulation;

import java.util.Arrays;

public class UnionFind_Simulation {
    static int[] set = new int[10];

    public static void main(String[] args) {
        set[2] = 2;
        set[3] = 2;
        set[4] = 3;
        set[5] = 4;

        set[6] = 5;
        set[7] = 5;

        find(5);
        System.out.println(Arrays.toString(set));

        if(find(5) != find(7))
            union(4, 7);
        System.out.println(Arrays.toString(set));
    }

    // 사이클 확인은 (find != find) 로 가능
    public static int find(int n){
        if(set[n] == n)
            return n;
        return set[n] = find(set[n]);
    }

    // 들어오기전에 n1==n2 검사를 함
    public static void union(int n1, int n2){
        n1 = find(n1);
        n2 = find(n2);

        if(n1 > n2 ){
            set[n1] = n2;
        }
        else if(n2 > n1){
            set[n2] = n1;
        }
    }
}
