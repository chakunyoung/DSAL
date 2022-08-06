package S_BinarySearch;

// BS 이전에 "정렬"되어있어야함.

public class bs {
    public static void main(String[] args) {

    }

    public static long binarySearch(int need){
        long s = 0;
        long e = 2_000_000_000;
        long returnHeight = 0;

        while(s <= e){
            long mid = (s + e) / 2;

            // 기준값 설정
            // 자른 값들의 총합을 이용
            long sum = 0;
//            for(int i = 0; i<arr.length; i++){
//                int ele = arr[i];
//                if(ele > mid)
//                    sum += ele - mid;
//            }

            if(sum >= need) { // 조건을 만족하므로 범위를 더 엄밀하게 줄임
                s = mid + 1;
                returnHeight = mid;    // 조건을 충족한다면 일단 저장
            }else if(sum < need)
                e = mid - 1;
        }
        return returnHeight;
    }

}
