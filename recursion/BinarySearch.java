package recursion;

public class BinarySearch {
    public static boolean binarySearch(int[] arr, int x, int left, int right) {
        if (left > right)
            return false;
        int mid = (left + right) / 2;
        if (arr[mid] == x)
            return true;
        if (arr[mid] < x)
            return binarySearch(arr, x, mid + 1, right);
        return binarySearch(arr, x, left, mid - 1);
    }
}