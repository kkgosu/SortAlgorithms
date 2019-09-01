package udemy.sortalgorithms.course;

import udemy.stacks.course.StacksCourse;

public class Main {

    public static void main(String[] args) {
        StacksCourse.main();
/*        String[] radixArray = {"bcdef", "dbaqc", "abcde", "omadd", "bbbbb"};
        radixSortString(radixArray, 26, 5);
       *//* int[] array = new int[]{-2, 5, -7, 1, 2, 3, 8, -9, 1, 4};
        insertionSortRecursive(array, array.length);*//*
        for (String i : radixArray) {
            System.out.println(i);
        }*/
    }

    private static void radixSortString(String[] arr, int radix, int width) {
        for (int i = width - 1; i >= 0; i--) {
            radixSingleSortString(arr, i, radix);
        }
    }

    private static void radixSingleSortString(String[] arr, int position, int radix) {
        int numItems = arr.length;
        int[] countArray = new int[radix];

        for (String value : arr) {
            countArray[getIndex(value, position)]++;
        }

        for (int j = 1; j < radix; j++) {
            countArray[j] += countArray[j - 1];
        }

        String[] temp = new String[numItems];
        for (int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--) {
            temp[--countArray[getIndex(arr[tempIndex], position)]] =
                    arr[tempIndex];
        }
        System.arraycopy(temp, 0, arr, 0, numItems);
    }

    private static int getIndex(String input, int position) {
        return input.charAt(position) - 'a';
    }

    private static void radixSort(int[] arr, int radix, int width) {
        for (int i = 0; i < width; i++) {
            radixSingleSort(arr, i, radix);
        }
    }

    private static void radixSingleSort(int[] arr, int position, int radix) {
        int numItems = arr.length;
        int[] countArray = new int[radix];

        for (int value : arr) {
            countArray[getDigit(position, value, radix)]++;
        }

        for (int j = 1; j < radix; j++) {
            countArray[j] += countArray[j - 1];
        }

        int[] temp = new int[numItems];
        for (int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--) {
            temp[--countArray[getDigit(position, arr[tempIndex], radix)]] =
                    arr[tempIndex];
        }
        System.arraycopy(temp, 0, arr, 0, numItems);
    }

    private static int getDigit(int position, int value, int radix) {
        return value / (int) Math.pow(radix, position) % radix;
    }

    private static void countingSort(int[] arr, int min, int max) {
        int[] countArray = new int[(max - min) + 1];
        for (int i = 0; i < countArray.length; i++) {
            countArray[arr[i] - min]++;
        }
        int j = 0;
        for (int i = min; i <= max; i++) {
            while (countArray[i - min] > 0) {
                arr[j++] = i;
                countArray[i - min]--;
            }
        }
    }

    /**
     * <p>O(n*log(n))</p>
     *
     * @param arr   Array to sort
     * @param start start index
     * @param end   end index
     */

    private static void quickSort(int[] arr, int start, int end) {
        if (end - start < 2)
            return;

        int pivot = partition(arr, start, end);
        quickSort(arr, start, pivot);
        quickSort(arr, pivot + 1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[start];

        int i = start;
        int j = end;

        while (i < j) {
            while (i < j && arr[--j] >= pivot) ;
            if (i < j) {
                arr[i] = arr[j];
            }
            while (i < j && arr[++i] <= pivot) ;
            if (i < j) {
                arr[j] = arr[i];
            }
        }
        arr[j] = pivot;
        return j;
    }

    /**
     * <p>O(n*log(n)); Stable sort</p>
     *
     * @param arr   Array to sort
     * @param start Start index of the array (sub-array)
     * @param end   End index of the array (sub-array)
     */

    private static void mergeSort(int[] arr, int start, int end) {
        if (end - start < 2)
            return;
        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid, end);
        merge(arr, start, mid, end);
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        if (arr[mid - 1] <= arr[mid])
            return;

        int i = start;
        int j = mid;
        int tempIndex = 0;
        int[] tempArray = new int[end - start];

        while (i < mid && j < end) {
            tempArray[tempIndex++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }

        System.arraycopy(arr, i, arr, start + tempIndex, mid - i);
        System.arraycopy(tempArray, 0, arr, start, tempIndex);
    }

    private static void mergeSortDescending(int[] arr, int start, int end) {
        if (end - start < 2)
            return;
        int mid = (start + end) / 2;
        mergeSortDescending(arr, start, mid);
        mergeSortDescending(arr, mid, end);
        mergeDescending(arr, start, mid, end);
    }

    private static void mergeDescending(int[] arr, int start, int mid, int end) {
        if (arr[mid - 1] >= arr[mid])
            return;
        int i = start;
        int j = mid;
        int tempIndex = 0;
        int[] tempArray = new int[end - start];

        while (i < mid && j < end) {
            tempArray[tempIndex++] = arr[i] >= arr[j] ? arr[i++] : arr[j++];
        }
        System.arraycopy(arr, i, arr, start + tempIndex, mid - i);
        System.arraycopy(tempArray, 0, arr, start, tempIndex);
    }

    private static int recursiveFactorial(int n) {
        if (n == 0)
            return 1;
        return recursiveFactorial(n - 1) * n;
    }

    private static int iterativeFactorial(int n) {
        if (n == 0 || n == 1)
            return 1;
        else {
            int factorial = 1;
            for (int i = 1; i <= n; i++) {
                factorial *= i;
            }
            return factorial;
        }
    }

    /**
     * <p>O(n^2) in worst case but it's much faster than insertion Sort cuz of gap; Unstable sort</p>
     *
     * @param arr Array to sort
     */
    private static void shellSort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int newElement = arr[i];
                int j = i;

                while (j >= gap && arr[j - gap] > newElement) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = newElement;
            }
        }

        for (int i : arr) {
            System.out.println(i);
        }
    }

    /**
     * <p>O(n^2); Stable sort</p>
     *
     * @param arr Array to sort
     */
    private static void insertionSort(int[] arr) {
        for (int firstUnsortedIndex = 1; firstUnsortedIndex < arr.length; firstUnsortedIndex++) {
            int newElement = arr[firstUnsortedIndex];
            int i;
            for (i = firstUnsortedIndex; i > 0 && arr[i - 1] > newElement; i--) {
                arr[i] = arr[i - 1];
            }
            arr[i] = newElement;
        }
        for (int i : arr) {
            System.out.println(i);
        }
    }

    private static void insertionSortRecursive(int[] arr, int numItems) {
        if (numItems < 2)
            return;

        insertionSortRecursive(arr, numItems - 1);
        int newElement = arr[numItems - 1];
        int i;
        for (i = numItems - 1; i > 0 && arr[i - 1] > newElement; i--) {
            arr[i] = arr[i - 1];
        }
        arr[i] = newElement;
    }

    /**
     * <p>O(n^2); Unstable sort</p>
     *
     * @param arr Array to sort
     */
    private static void selectionSort(int[] arr) {
        for (int lastUnsortedIndex = arr.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            int largest = 0;
            for (int i = 1; i <= lastUnsortedIndex; i++) {
                if (arr[i] > arr[largest])
                    largest = i;
            }
            swap(arr, largest, lastUnsortedIndex);
        }

        for (int i : arr) {
            System.out.println(i);
        }
    }


    /**
     * <p>
     * O(n^2); Stable sort
     * </p>
     *
     * @param arr Array to sort
     */
    private static void bubbleSort(int[] arr) {
        for (int lastUnsortedIndex = arr.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            for (int i = 0; i < lastUnsortedIndex; i++) {
                swap(arr, i, i + 1);
            }
        }

        for (int i : arr) {
            System.out.println(i);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        if (arr[i] > arr[j]) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
