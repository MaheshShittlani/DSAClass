import java.util.Arrays;

public class RadixSort {
    public static int findMax(int[] arr) {
        int max = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    public static int calacDigits(int number) {
        int digitCount = 0;
        while(number != 0) {
            digitCount++;
            number /= 10;
        }
        return digitCount;
    }
    public static int getDigit(int item, int pos) {
        int posCount = 0;
        int digit = 0;
        while(posCount < pos) {
            digit = item % 10;
            item = item / 10;
            posCount++;
        }
        return digit;
    }
    public static void initializeBucket(int[][] bucket) {
        for(int i = 0; i < bucket.length; i++) {
            Arrays.fill(bucket[i], -1);
        }
    }

    public static void copyIntoBucket(int[] arr, int digit, int[][] bucket) {
        for(int index = 0; index < arr.length; index++) {
                int item = arr[index];
                int row = getDigit(item,digit);
                int col = 0;
                while(bucket[row][col] != -1) {
                    col++;
                }
                bucket[row][col] = item;
            }
    }

    public static void copyIntoArray(int[] arr, int[][] bucket) {
        int index = 0;
        for(int i = 0; i < bucket.length; i++) {
            for(int j = 0; j < bucket[i].length; j++) {
                if(bucket[i][j] != -1) {
                    arr[index] = bucket[i][j];
                    index++;
                }
            }
        }
    }

    public static void sort(int[] arr) {
        int largestNumber = findMax(arr);
        int digits = calacDigits(largestNumber);
        int bucket[][] = new int[10][arr.length];
        for(int i = 1; i <= digits; i++) {
            initializeBucket(bucket);
            copyIntoBucket(arr, i, bucket);
            copyIntoArray(arr, bucket);
        }
    }
    public static void main(String[] args) {
        int[] arr = {11,2,102,0,33,53,46,76,55,3,2,1,78,98,99,19};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
