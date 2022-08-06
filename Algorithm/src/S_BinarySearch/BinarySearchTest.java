package S_BinarySearch;

public class BinarySearchTest {

    static int[] arr;

    public static void main(String[] args) {
        arr = new int[]{1,3,5,7,9,11,13};
        int idx = BinarySearchCode(9);
        System.out.println(idx);
    }

    public static int BinarySearchCode(int findNumber){
        int s = 0;
        int e = arr.length - 1;
        int mid;

        int returnNumber = 0;

        while(s <= e){
            mid = (s+e) / 2;

            /*
            기준값, 가변값으로 s, e 컨트롤
             */

            if(findNumber == arr[mid]) {
                returnNumber = mid;
                break;
            }
            else if(findNumber > arr[mid])
                s = mid + 1;
            else if(findNumber < arr[mid])
                e = mid - 1;
        }
        return returnNumber;
    }
}
