import java.util.Arrays;

public class SelectionSort {
    public static void sort(int[] arr) {
        int n = arr.length;
        int t;

        for(int i = 0; i < n - 1 ;i++) {
            for(int j = i + 1; j < n; j++) {
                if(arr[i] > arr[j]) {
                    t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {50,40,30,20,10};

        sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}