package C_Backtracking;

public class Backtracking_Combination {
    static int[] arr = new int[10];
    static int[] inputArr;
    static int M;
    static int count;

    public static void main(String[] args){
        inputArr = new int[]{2, 3, 5, 7};
        M = inputArr.length;
        BT(0, 0);
    }
    public static void BT(int k, int idx){ // ���� �ڸ���, ���� idx
        if(2 == k){
            for(int j = 0; j < 2; j++)
                System.out.print(arr[j] + " ");
            System.out.println();
            return;
        }
        
        // �պ��� �������� ���� �� ����, �ݺ����� �ȳ���
        for(int i = idx; i < M; i++){ // �־��� idx // 0 ~ 4
            arr[k] = inputArr[i];
            BT(k + 1, i + 1); // ���� for ���� idx+1 ���� ����.
        }
    }
}
// "�� ������ �� ���� ���� �� ����." �� �̿��ϸ� ��.
// (3 ..) �̸� for ���� ������ ����