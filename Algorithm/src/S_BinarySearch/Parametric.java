package S_BinarySearch;

// BS ������ "����"�Ǿ��־����.

import java.util.Arrays;

public class Parametric {
    static long[] arr;
    public static void main(String[] args) {
        // arr �Էº�
        // need �Էº�
        // long answer= parametricSearch(need);
        // System.out.println(answer);
    }

    public static long parametricSearch(int need){
        long s = 0;
        long e = 2_000_000_000;
        long returnHeight = 0;

        while(s <= e){
            long mid = (s + e) / 2;

            // �ڸ� ������ ������ �������� �̿�
            long sum = Arrays.stream(arr).map(element -> element - mid).sum();

            if(sum >= need) { // ������ �����ϹǷ� ������ �� �����ϰ� ����
                s = mid + 1;
                returnHeight = mid;    // ������ �����Ѵٸ� �ϴ� ����
            }else if(sum < need)
                e = mid - 1;
        }
        return returnHeight;
    }

}
