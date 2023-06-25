import java.util.Arrays;

public class QuickSort {
    public static void sort(int[] arr, int low, int high) {
        if(low < high) {
            int pivotIndex = partition(arr, low, high);
            sort(arr, 0, pivotIndex - 1);
            sort(arr, pivotIndex + 1, high);    
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
    public static int partition(int[] arr, int lb, int ub) {
        int low = lb;
        int high = ub;
        int pivot = arr[lb];

        while(low < high) {
            while(low <= high &&  arr[low] <= pivot) {
                low++;
            }
            while(low <= high && arr[high] > pivot) {
                high--;
            }
            if(low < high) {
                // System.out.println("Swap position: "+ low + ", "+high);
                swap(arr, low, high);
            }
        }
        swap(arr, lb, high);
        return high;
    }
    public static void main(String[] args) {
        int[] arr = {6,1,9,4,7,5,2,3,8};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
