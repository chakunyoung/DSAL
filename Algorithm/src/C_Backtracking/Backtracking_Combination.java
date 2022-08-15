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
    public static void BT(int k, int idx){ // 현재 자리수, 시작 idx
        if(2 == k){
            for(int j = 0; j < 2; j++)
                System.out.print(arr[j] + " ");
            System.out.println();
            return;
        }
        
        // 앞보다 작은수가 나올 수 없고, 반복수도 안나옴
        for(int i = idx; i < M; i++){ // 주어진 idx // 0 ~ 4
            arr[k] = inputArr[i];
            BT(k + 1, i + 1); // 다음 for 문은 idx+1 부터 시작.
        }
    }
}
// "앞 수보다 뒷 수가 작을 수 없다." 를 이용하면 됨.
// (3 ..) 이면 for 문에 못들어가서 종료