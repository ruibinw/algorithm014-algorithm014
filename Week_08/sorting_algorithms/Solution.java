package sorting_algorithms;

import java.util.Arrays;

/**
 * 选择排序
 * 找最小放前面
 */
class SelectionSort {
    public static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex] ) minIndex = j;
            }
            if (minIndex != i) {
                int tmp = arr[minIndex]; arr[minIndex] = arr[i]; arr[i] = tmp;
            }
        }
    }
}

/**
 * 插入排序
 * 拿待排序中第一个元素，跟前面（已排序序列）从后向前比较，找到相应的位置并插入
 */
class InsertionSort {
    public static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int preIndex = i - 1;
            int curNum = arr[i];
            while (preIndex >= 0 && arr[preIndex] > curNum) {
                arr[preIndex + 1] = arr[preIndex--];
            }
            arr[preIndex + 1] = curNum;
        }
    }
}

/**
 * 冒泡排序
 * 每次比较两个相邻的元素，如果是逆序，则交换
 */
class BubbleSort {
    public static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j]; arr[j] = arr[j + 1]; arr[j + 1] = tmp;
                }
            }
        }
    }
}

/**
 * 快速排序
 * 随机取标杆 pivot，把数组区分成两部分
 * 小的放pivot左边，大的放pivot右边
 * 然后对左边和右边的子数组继续快排
 */
class QuickSort {
    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] a, int start, int end) {
        if (start >= end) return;
        int pivot = partition(a, start, end);
        sort(a, start, pivot - 1);
        sort(a, pivot + 1, end);
    }

    private static int partition(int[] a, int start, int end) {
        int pivot = end, counter = start;
        for (int i = start; i < end; i++) {
            if (a[i] < a[pivot]) {
                swap(a, i, counter++);
            }
        }
        swap(a, pivot, counter);
        return counter;
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}

/**
 * 归并排序
 * 将数组分解成左右子序列长度为 n/2
 * 对2个子序列继续调用归并排序，直到两者的长度为一
 * 再将两个子序列合并成一个有序的序列
 */
class MergeSort {
    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] a, int lo, int hi) {
        if (lo >= hi) return;
        int mid = (lo + hi) >>> 1;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    private static void merge(int[] a, int lo, int mid, int hi) {
        int[] tmp = new int[hi - lo + 1];
        int i = lo, j = mid + 1, k = 0;

        while (i <= mid && j <= hi) {
            tmp[k++] = a[i] <= a[j] ? a[i++] : a[j++];
        }

        while (i <= mid) tmp[k++] = a[i++];
        while (j <= hi) tmp[k++] = a[j++];

        k = 0;
        while (k < tmp.length) a[lo + k] = tmp[k++];
        //System.arraycopy(tmp, 0, a, lo, tmp.length);
    }
}

// 实现空间复杂度为 O(1) 的归并排序
class MergeSort2 {
    public static void sort(int[] arr) {
        int maxVal = Arrays.stream(arr).max().getAsInt() + 1;
        sort(arr, 0, arr.length - 1, maxVal);
    }

    private static void sort(int[] a, int l, int r, int maxVal) {
        if (l >= r) return;
        int m = (l + r) >>> 1;
        sort(a, l, m, maxVal);
        sort(a, m + 1, r, maxVal);
        merge(a, l, m, r, maxVal);
    }

    private static void merge(int[] a, int l, int m, int r, int maxVal) {
        int i = l, j = m + 1, k = l;

        while (i <= m && j <= r)
            a[k] = (a[i] % maxVal <= a[j] % maxVal) ?
                a[k++] + (a[i++] % maxVal) * maxVal : a[k++] + (a[j++] % maxVal) * maxVal;

        while (i <= m) a[k] = a[k++] + (a[i++] % maxVal) * maxVal;
        while (j <= r) a[k] = a[k++] + (a[j++] % maxVal) * maxVal;

        for (i = l; i <= r; i++) a[i] /= maxVal;
    }
}
