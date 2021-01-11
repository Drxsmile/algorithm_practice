public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        int res = binarySearch(4, arr);
        System.out.println(res);
    }

    public static int binarySearch(int tar, int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            // 每次向下取整，所以left要加1
            if (tar > arr[mid]) {
                left = mid + 1;
            } else if (tar < arr[mid]) {
                right = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }
}