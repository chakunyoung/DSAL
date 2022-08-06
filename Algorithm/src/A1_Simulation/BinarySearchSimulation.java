package A1_Simulation;

import java.util.Arrays;

public class BinarySearchSimulation {
    public static void main(String[] args) {
        int[] arr = {4,2,6,3,7,10,15,13};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        int idx = 0;

        idx = bs(15, arr, 0, arr.length-1);
        System.out.println(idx);
        idx = bs(2, arr, 0, arr.length-1);
        System.out.println(idx);
        idx = bs(4, arr, 0, arr.length-1);
        System.out.println(idx);

        // ¾ø´Â ¼ö
        idx = bs(8, arr, 0, arr.length-1);
        System.out.println(idx);

    }
    public static int bs(int findNum, int[] arr, int s, int e){
        boolean isPre = false;
        int mid = 0;

        while(s<=e){
            mid = (s+e) / 2;

            if(findNum == arr[mid]) {
                isPre = true;
                break;
            }

            else if(findNum > arr[mid]){
                s = mid+1;
            }

            else if(findNum < arr[mid]){
                e = mid-1;
            }
        }
        if(isPre)
            return 1;
        else
            return 0;
    }
}
