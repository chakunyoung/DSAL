package A1_Simulation;

// �ߺ� ����
// ����
// �ߺ� ���� -> �� ���� �� ������ �۾ƾ� ��
// ����

public class BackTrackingSimulation {
    static int[] arr; // �ӽ� ���� arr
    static int[] temp;
    static boolean[] v = new boolean[7];

    public static void main(String[] args) {
        temp = new int[5];

        arr = new int[]{1,2,3,4,5,6,7};

        bt(5, 0, 0);

    }

    // limit ���� ���� �䱸������ ó�����ָ� ����.
    // �������� ó��������ϴ� ��쵵 �ִ�. (N-queen)
    public static void bt(int limit, int n, int idx){ // limit ���� �ڸ���, n ���� �ڸ���



    }
}
