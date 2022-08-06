package D_Dynamic;

import java.io.*;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.StringTokenizer;

/*
�Է�
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
        // �ռ� �ִ��� �ٽ� �� ����.
        for(int i = 1; i<arr.length; i++) // ���� �ڽ�
            for(int j =0; j<i; j++) // ���� ��
                if(arr[i] > arr[j])  // j�� �۴� �׷� ���� ����. (j���� �س����� ��� + �ڽ�)
                    count[i] = Math.max(count[i], count[j] + 1); // (�ڽŲ� ���� , ���� + 1 ) �� ���� ū�� ���

        OptionalInt maxCount = Arrays.stream(count).max();
        System.out.println(maxCount.orElse(0));
    }
}


