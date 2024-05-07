package w9_lecture;

public class BinarySearch {
    public static boolean binarySearch(int[] array, int key) {
        int left = 0;
        int right = array.length -1;
        while (left < right) {
            int mid = (right + left) / 2;
            if (array[mid] < key){
                left = mid + 1;
            }else if (array[mid] > key){
                right = mid - 1;
            }else{
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        System.out.println(binarySearch(array, 5));
        System.out.println(binarySearch(array, 11));
    }
}
