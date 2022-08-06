package C_Backtracking;

/*
���� -> backtracking (�湮ó���� ����Ž��)
*/
public class Backtracking_Permutation {
    static boolean[] v = new boolean[10]; // �ε����� �ش� ���� ��ü�� ��. // 0�� �Ⱦ� // ũ�⸦ �����ְ� �����
    static int[] arr = new int[10]; // �迭 ���
    static int[] basicArr; // �־��� arr
    static int N;

    public static void main(String[] args) {
        basicArr = new int[]{2, 3, 5, 7, 8, 9};
        N = basicArr.length;
        BT(0);
    }

    public static void BT(int k){
        if(4 == k){
            for(int j=0; j<4; j++)
                System.out.print(arr[j]+ " ");
            System.out.println();
            return;
        }

        /*
         ��� -> �� �ڸ���
         for  -> ���ڴ� �ݺ����� ����
         �湮 -> ��� ���¿��� �湮�� ���� ������� ���ϰ��Ϸ���

         ��� ���¿��� �ᱸ��, ��Ͱ� ������ Ǯ���ش�.
         �ݺ����� ������̱� ������ ��Ͱ� ������ ���� �ݺ����� ����ǹǷ� Ǯ���൵ �ȴ�.
         */

        for(int i =0; i<N; i++){
            if(!v[i]){
                v[i] = true;
                arr[k] = basicArr[i];
                BT(k+1);
                v[i] = false;
            }
        }
    }
}