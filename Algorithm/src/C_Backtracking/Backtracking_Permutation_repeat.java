package C_Backtracking;

// �ߺ� ���� ����Ž�� DFS

public class Backtracking_Permutation_repeat {
    static int[] arr = new int[10];
    static int[] basicArr;
    static int N;

    public static void main(String[] args) {
        basicArr = new int[]{2, 3, 5, 7, 8, 9};
        N = basicArr.length;
        BT(0);
    }
    public static void BT(int k){ // ���ڹ���, �ڸ���, ���� �ڸ���
        if(4 == k){
            for(int j=0; j<4; j++) {
                System.out.print(arr[j] + " ");
            }
            System.out.println();
            return;
        }

        for(int i =0; i<N; i++){
            arr[k] = basicArr[i];
            BT(k + 1);
        }
    }
}
