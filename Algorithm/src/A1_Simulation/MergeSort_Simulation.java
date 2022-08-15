package A1_Simulation;

import java.util.Arrays;

/*

end �� ��� ���� (ũ�Ⱑ �ƴ϶� ���� �迭 ������)
mid �� ��������

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

    // divide �� ��� �ϸ鼭 ������ ����
    // merge �� �ϸ鼭 ���� merge �� �̵�
    public static void divide(int s, int e){
        // todo: ���Ұ� �ΰ� �̻��� �� ����
        // s , e �� <= �� ������
        // s, e ���� �� �Ѱ��� �����̸� ��������
        if(s < e) {
            int mid = (s + e) / 2;
            divide(s, mid);  // mid ���� ����
            divide(mid+1, e);

            // ��� ��� ��� .. ����
            // ���� ���������� 2���� ���� ��
            // ������ �ٲٴ� merge �� ��
            // �״��� 4�� �� ��, 8 ���� ��
            merge(s, e);
        }
    }

    // ������ ���� �������ִ� �κ�
    public static void merge(int s, int e){
        int mid = (s+e) / 2;

        int left = s; // ���� ���� ��ġ
        int right = mid + 1; // ������ ���� ��ġ

        int k = s; // tmp idx

        // arr ���� �������ϱ� tmp �� ����ؾ���
        while(left <= mid && right <= e){
            if(arr[left] <= arr[right]) // ������ ū��� ���
                tmp[k++] = arr[right++];
            else
                tmp[k++] = arr[left++];
        }

        // ���� ������ �ֱ�
        while (left <= mid) // �������� ���� ���� ���
            tmp[k++] = arr[left++];
        while (right <= e) { // ������ ���� ���� ���
            tmp[k++] = arr[right++];
        }

        // �κ� ���ĵ� tmp arr �ݿ�, ���ĵ� arr ���� ���� ��Ϳ��� ����ؾ���
        for(int i = s; i <= e; i++)
            arr[i] = tmp[i];
    }
}