package D_Dynamic;

import java.io.*;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.StringTokenizer;

/*
입력
6
10 20 10 30 20 50
 */

public class LIS {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int[] arr;

    public static void main(String[] args) throws IOException {
        int arrCount = Integer.parseInt(br.readLine());
        arr = new int[arrCount];

        int idx = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            arr[idx++] = Integer.parseInt(st.nextToken());
        }

        int[] count = new int[arrCount];
        Arrays.fill(count, 1);

        // LIS
        // 앞서 있던걸 다시 다 본다.
        for(int i = 1; i<arr.length; i++) // 현재 자신
            for(int j =0; j<i; j++) // 이전 꺼
                if(arr[i] > arr[j])  // j가 작다 그럼 연결 가능. (j까지 해놨던거 흡수 + 자신)
                    count[i] = Math.max(count[i], count[j] + 1); // (자신꺼 갱신 , 이전 + 1 ) 중 가장 큰거 사용

        OptionalInt maxCount = Arrays.stream(count).max();
        System.out.println(maxCount.orElse(0));
    }
}


