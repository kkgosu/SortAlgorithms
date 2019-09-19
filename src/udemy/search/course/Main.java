package udemy.search.course;

public class Main {
    public static void main() {
        int[] array = {-22, -15, 1, 7, 20, 35, 55};

        System.out.println(recursiveBinarySearch(array, 0, array.length, 21));
    }

    private static int iterativeBinarySearch(int[] array, int value) {
        int start = 0;
        int end = array.length;

        while (start < end) {
            int midpoint = (start + end) / 2;
            if (array[midpoint] == value)
                return array[midpoint];
            else if (array[midpoint] < value) {
                start = midpoint + 1;
            } else {
                end = midpoint;
            }
        }
        return -1;
    }

    private static int recursiveBinarySearch(int[] array, int start, int end, int value) {
        int midpoint = (start + end) / 2;
        if (start >= end)
            return -1;
        if (array[midpoint] == value)
            return array[midpoint];
        else if (array[midpoint] < value) {
            return recursiveBinarySearch(array, midpoint + 1, end, value);
        } else
            return recursiveBinarySearch(array, start, midpoint, value);
    }
}

