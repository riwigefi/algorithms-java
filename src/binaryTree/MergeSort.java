package binaryTree;

public class MergeSort {

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    /**
     * 合并两个有序数组
     *
     * @param arr   待合并的数组
     * @param left  左边有序数组的起始下标
     * @param mid   左边有序数组的结束下标，mid+1为右边有序数组的开始下标
     * @param right 右边有序数组的结束下标
     */
    public static void merge(int[] arr, int left, int mid, int right) {
        // 临时数组，用于存储合并后的有序数组
        int[] temp = new int[arr.length];
        // 定义左边有序数组的起始下标
        int i = left;
        // 定义右边有序数组的起始下标
        int j = mid + 1;
        // 定义临时数组的起始下标
        int k = left;
        // 循环比较左右两个数组的元素，将较小的元素放入到临时数组中
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        // 将左边有序数组剩余的元素放入到临时数组中
        while (i < mid) {
            temp[k++] = arr[i++];
        }
        // 将右边数组中剩余的元素放入临时数组中
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        // 将临时数组的元素复制会原数组
        for (int l = left; l < right; l++) {
            arr[l] = temp[l];
        }
    }
}
