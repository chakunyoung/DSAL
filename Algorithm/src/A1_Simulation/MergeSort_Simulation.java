package A1_Simulation;

import java.util.Arrays;

/*

end 는 계속 포함 (크기가 아니라 실제 배열 데이터)
mid 도 마찬가지

 */

public class MergeSort_Simulation {
    static int[] arr;
    static int[] tmp;

    public static void main(String[] args) {
        arr = new int[]{5, 2, 3, 1, 0, -30, -50, 100};
        tmp = new int[arr.length];
        divide(0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    // divide 를 계속 하면서 스택을 쌓음
    // merge 를 하면서 상위 merge 로 이동
    public static void divide(int s, int e){
        // todo: 원소가 두개 이상일 때 동작
        // s , e 는 <= 로 동작함
        // s, e 같을 때 한개의 원소이며 쓰지않음
        if(s < e) {
            int mid = (s + e) / 2;
            divide(s, mid);  // mid 까지 포함
            divide(mid+1, e);

            // 재귀 재귀 재귀 .. 이후
            // 가장 작은단위인 2개가 됐을 때
            // 순서를 바꾸는 merge 를 함
            // 그다음 4개 일 때, 8 개일 때
            merge(s, e);
        }
    }

    // 나눠진 것을 정렬해주는 부분
    public static void merge(int s, int e){
        int mid = (s+e) / 2;

        int left = s; // 왼쪽 시작 위치
        int right = mid + 1; // 오른쪽 시작 위치

        int k = s; // tmp idx

        // arr 값이 덮여지니까 tmp 를 사용해야함
        while(left <= mid && right <= e){
            if(arr[left] <= arr[right]) // 우측이 큰경우 사용
                tmp[k++] = arr[right++];
            else
                tmp[k++] = arr[left++];
        }

        // 남은 데이터 넣기
        while (left <= mid) // 오른쪽이 일찍 끝난 경우
            tmp[k++] = arr[left++];
        while (right <= e) { // 왼쪽이 일찍 끝난 경우
            tmp[k++] = arr[right++];
        }

        // 부분 정렬된 tmp arr 반영, 정렬된 arr 다음 상위 재귀에서 사용해야함
        for(int i = s; i <= e; i++)
            arr[i] = tmp[i];
    }
}