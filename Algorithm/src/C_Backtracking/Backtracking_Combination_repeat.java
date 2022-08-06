package C_Backtracking;

public class Backtracking_Combination_repeat {
    static int[] arr = new int[10];
    static int[] basicArr;
    static int M;
    static int count;

    public static void main(String[] args){
        basicArr = new int[]{2, 3, 5, 7};
        M = basicArr.length;
        BT(0, 0);
    }
    public static void BT(int k, int idx){ // ���� �ڸ���, �־��� idx
        if(2 == k){
            for(int j = 0; j < 2; j++) {
                System.out.print(arr[j] + " ");
            }
            System.out.println();
            return;
        }

        // �պ��� ���� ���� ���� �� ���� ����
        for(int i = idx; i < M; i++){
            arr[k] = basicArr[i];
            BT(k + 1, i ); // �ڱ� �ڽ��� ������ ������ ��ͽ�Ŵ
                            // ������ �� ���� [e, e, <=(�ڽ�) ] ���� ���ư� ���� ����.
        }
    }
}
