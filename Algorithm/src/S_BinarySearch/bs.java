package S_BinarySearch;

// BS ������ "����"�Ǿ��־����.

public class bs {
    public static void main(String[] args) {

    }

    public static long binarySearch(int need){
        long s = 0;
        long e = 2_000_000_000;
        long returnHeight = 0;

        while(s <= e){
            long mid = (s + e) / 2;

            // ���ذ� ����
            // �ڸ� ������ ������ �̿�
            long sum = 0;
//            for(int i = 0; i<arr.length; i++){
//                int ele = arr[i];
//                if(ele > mid)
//                    sum += ele - mid;
//            }

            if(sum >= need) { // ������ �����ϹǷ� ������ �� �����ϰ� ����
                s = mid + 1;
                returnHeight = mid;    // ������ �����Ѵٸ� �ϴ� ����
            }else if(sum < need)
                e = mid - 1;
        }
        return returnHeight;
    }

}
