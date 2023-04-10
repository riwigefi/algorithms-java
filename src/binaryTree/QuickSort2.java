package binaryTree;

public class QuickSort2 {

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            // 先在整棵树构造分界点
            int pivotIndex = partition(arr, left, right);
            // 左子树构造分界点
            quickSort(arr, left, pivotIndex - 1);
            // 右子树构造分界点
            quickSort(arr, pivotIndex + 1, right);
        }
    }

    public static int partition(int[] arr, int left, int right) {
        // 分界点的数值
        int pivot = arr[right];
        // i等于
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                // 小于分界点的数值
                i++;
                // 交换位置 小于pivot的值，全换到pivot的左边
                swap(arr, i, j);
            }
        }
        // for循环执行完以后，left到right这个区间的元素，现在所有小于pivot的值都到pivot的左边了
        // 现在将pivot换到i+1这个位置，这样pivot的右边，全是大于pivot的元素了
        swap(arr, i + 1, right);
        // 将新的分界点位置返回
        return i + 1;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
