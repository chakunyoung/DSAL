package C_Backtracking;

/*
순열 -> backtracking (방문처리로 조건탐색)
*/
public class Backtracking_Permutation {
    static boolean[] v = new boolean[10]; // 인덱스가 해당 숫자 자체가 됨. // 0을 안씀 // 크기를 여유있게 잡아줌
    static int[] arr = new int[10]; // 배열 기억
    static int[] basicArr; // 주어진 arr
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
         재귀 -> 각 자리수
         for  -> 숫자는 반복문이 제어
         방문 -> 재귀 상태에서 방문된 숫자 사용하지 못하게하려고

         재귀 상태에선 잠구고, 재귀가 끝나면 풀어준다.
         반복문을 사용중이기 때문에 재귀가 끝나면 다음 반복으로 진행되므로 풀어줘도 된다.
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