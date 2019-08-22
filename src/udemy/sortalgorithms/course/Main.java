package udemy.sortalgorithms.course;

public class Main {

    public static void main(String[] args) {
        System.out.println(recursiveFactorial(5));
        System.out.println(iterativeFactorial(5));
        //int[] array = new int[]{5, 43, -21, 11, 0, -5};
        //shellSort(array);
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
