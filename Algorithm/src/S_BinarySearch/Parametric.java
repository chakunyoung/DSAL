package S_BinarySearch;

// BS 이전에 "정렬"되어있어야함.

import java.util.Arrays;

public class Parametric {
    static long[] arr;
    public static void main(String[] args) {
        // arr 입력부
        // need 입력부
        // long answer= parametricSearch(need);
        // System.out.println(answer);
    }

    public static long parametricSearch(int need){
        long s = 0;
        long e = 2_000_000_000;
        long returnHeight = 0;

        while(s <= e){
            long mid = (s + e) / 2;

            // 자른 값들의 총합을 조건으로 이용
            long sum = Arrays.stream(arr).map(element -> element - mid).sum();

            if(sum >= need) { // 조건을 만족하므로 범위를 더 엄밀하게 줄임
                s = mid + 1;
                returnHeight = mid;    // 조건을 충족한다면 일단 저장
            }else if(sum < need)
                e = mid - 1;
        }
        return returnHeight;
    }

}
