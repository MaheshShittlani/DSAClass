import java.util.Arrays;

public class MergeSort {
    public static void merge(int[] arr, int lb1, int ub1, int lb2, int ub2, int[] temp) {
        
    }
    public static void sort(int[] arr) {
        int n = arr.length;
        int sz = 1;
        while(sz < n) {
            //Create block size array
            int lb1 = 0;
            // Merging and storing into temp array
            int[] temp = new int[arr.length];
            int k = 0;
            while(lb1 < n) {
                int lb2 = lb1 + sz;
                int ub1 = lb2 - 1;
                int ub2 = ub1 + sz < n ? ub1 + sz : n - 1; // Math.min(ub1 + sz, n - 1);

                
                int i = lb1;
                int j = lb2;

                while(i < ub1 && j < ub2) {
                    if(arr[i] < arr[j]) {
                        temp[k] = arr[i];
                        i++;
                    } else {
                        temp[k] = arr[j];
                        j++;
                    }
                    k++;
                }

                // Remaing of array-1
                while(i < ub1) {
                    temp[k] = arr[i];
                    i++;
                    k++;
                }

                // Remaing of array-1
                while(j < ub2) {
                    temp[k] = arr[j];
                    j++;
                    k++;
                }
                

                // Update the lower bound and point to the next block
                lb1 = ub2 + 1;
            }

            sz = sz * 2;
        }
    }
    public static void main(String[] args) {
        int[] arr = {5,1,8,3,6,9,2,4,7};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
