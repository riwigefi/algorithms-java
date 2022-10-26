package binaryTree;

/**
 * 快速排序的逻辑，若要对numList[start,...,end]进行排序，我们先要找一个分界点p，通过交换元素，
 * 使得numList[start,...,p-1]都小于等于numList[p]
 * 且numList[p+1,...,end]都大于numList[p]
 * 然后递归地去numList[start,...,p-1]和numList[p+1,...,end]区间中寻找新的分界点，最后整个数组就被排序了
 * <p>
 * You can now follow organizations
 * Organization activity like new discussions,sponsorships,and repositories will appear in your dashboard feed.
 */

public class QuickSort {

    // A utility function to swap two elements in array
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int partition(int[] arr, int low, int high) {
        // pivot
        int pivot = arr[high];
        // Index of smaller element and indicates the right position of pivot found so far
        int i = (low - 1);
        for (int j = low; j < high - 1; j++) {
            // If current element is smaller than the pivot
            if (arr[j] < pivot) {
                // Increment index of smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    /**
     * The main function that implements QuickSort
     *
     * @param numList Array to be sorted
     * @param low     starting index
     * @param high    ending index
     */
    static public void quick_sort(int[] numList, int low, int high) {

        /***** 前序遍历位置，通过交换元素构建分界点 *****/
        if (low < high) {
            // pivot is partitioning index,arr[p] is now at right place
            int pivotIdx = partition(numList, low, high);

            // Separately sort elements before partition and after partition
            quick_sort(numList, low, pivotIdx - 1);
            quick_sort(numList, pivotIdx + 1, high);
        }
    }

    // Function to print an array
    static void printArray(int[] arr) {
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            System.out.println(arr[i] + "/n");
        }
    }

    // Diver Code
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};

        quick_sort(arr, 0, arr.length - 1);
        System.out.println("Sorted array: ");
        printArray(arr);
    }

}
