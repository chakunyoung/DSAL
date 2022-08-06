package A1_Simulation;

// 중복 순열
// 순열
// 중복 조합 -> 앞 수가 뒷 수보다 작아야 함
// 조합

public class BackTrackingSimulation {
    static int[] arr; // 임시 저장 arr
    static int[] temp;
    static boolean[] v = new boolean[7];

    public static void main(String[] args) {
        temp = new int[5];

        arr = new int[]{1,2,3,4,5,6,7};

        bt(5, 0, 0);

    }

    // limit 에서 문제 요구사항을 처리해주면 좋다.
    // 과정에서 처리해줘야하는 경우도 있다. (N-queen)
    public static void bt(int limit, int n, int idx){ // limit 제한 자리수, n 현재 자리수



    }
}
