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
    public static void BT(int k, int idx){ // 현재 자리수, 주어진 idx
        if(2 == k){
            for(int j = 0; j < 2; j++) {
                System.out.print(arr[j] + " ");
            }
            System.out.println();
            return;
        }

        // 앞보다 작은 수가 나올 수 없게 설정
        for(int i = idx; i < M; i++){
            arr[k] = basicArr[i];
            BT(k + 1, i ); // 자기 자신을 포함한 범위로 재귀시킴
                            // 하지만 그 이전 [e, e, <=(자신) ] 으로 돌아갈 경우는 없앰.
        }
    }
}
