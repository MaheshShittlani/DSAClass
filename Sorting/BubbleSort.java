import java.util.Arrays;

public class BubbleSort {
    public static void sort(int[] arr) {
        int i, j,t;
        int n = arr.length;
        boolean isSwap = true;

        for(i = 1; isSwap && i < n; i++) {
            isSwap = false;
            for(j = 0; j < n - i ; j++) {
                if(arr[j] > arr[j + 1]) {
                    t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                    isSwap = true;
                }
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = {50,40,30,20,10};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
