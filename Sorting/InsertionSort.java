import java.util.Arrays;

public class InsertionSort {
    public static void sort(int[] arr) {
        int n = arr.length;
        int item;
        for(int j = 1; j < n; j++)
        {
            int i;
            item = arr[j];
            // Shifting
            for(i = j - 1; i >= 0 && arr[i] > item; i--) {
                arr[i + 1] = arr[i];
            }
            //Insertion
            arr[i + 1] = item;
        }
    }
    public static void main(String[] args) {
        int[] arr = {12,1,33,22,40,9};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
