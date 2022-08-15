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

        System.out.println("fine ��: " + Arrays.toString(set));

        find(5);
        System.out.println("5�� fine ��: " + Arrays.toString(set));

        find(7);
        System.out.println("7�� fine ��: " + Arrays.toString(set));

        if(find(5) != find(7))
            union(5, 7);
        System.out.println("union: " + Arrays.toString(set));

        // ��ǥ���� ���Ƽ� union call() �� ���� �ʴ´�.
        if(find(5) != find(8))
            union(5, 8);
        System.out.println("union: " + Arrays.toString(set));
    }

    // ����Ŭ Ȯ���� (find != find) �� ����
    // �Ҽ��� ã�´�.
    public static int find(int n){
       if(n == set[n])
           return n;

        return set[n] = find(set[n]);
    }

    // ���������� n1==n2 �˻縦 ��
    // edge �� �����ϴ� ���� ������ union �� �����ϴ�.
    public static void union(int n1, int n2){
        System.out.println("union() call");

        // ��ǥ���� ã�´�.
        int rep1 = find(n1);
        int rep2 = find(n2);
        System.out.println(rep1 + " " + rep2);

        // ���� ���� ��ǥ ���� ��ǥ������ ����
        if(rep1 > rep2){
            set[rep2] = rep2;
        }else
            set[rep2] = rep1;
    }
}
