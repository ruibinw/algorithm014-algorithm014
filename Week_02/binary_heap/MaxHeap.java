package binary_heap;

/**
 * Max heap in Java
 */
public class MaxHeap {
    private static final int INITIAL_CAPACITY = 15;
    private int[] heap;
    private int heapSize;

    public MaxHeap() {
        this(INITIAL_CAPACITY);
    }

    public MaxHeap(int capacity) {
        this.heap = new int[capacity];
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    public boolean isFull() {
        return heapSize == heap.length;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int maxChildIndex(int i) {
        int left = (i * 2) + 1;
        int right = left + 1;
        if (right >= heapSize)
            return left;
        return heap[left] > heap[right] ? left : right;
    }

    private void heapifyUp(int i, int newVal) {
        int pi;
        while (i > 0 && newVal > heap[(pi = parent(i))]) {
            heap[i] = heap[pi];
            i = pi;
        }
        heap[i] = newVal;
    }

    private void heapifyDown(int i, int temp) {
        int half = heapSize / 2;//最后的一个非叶子节点的下标是 n/2 - 1
        int ci;
        while (i < half && heap[(ci = maxChildIndex(i))] > temp) {
            heap[i] = heap[ci];
            i = ci;
        }
        heap[i] = temp;
    }

    public void add(int val) {
        if (isFull())
            throw new RuntimeException("Heap is full");
        heap[heapSize] = val;
        heapifyUp(heapSize++, val);
    }

    public int pop() {
        if (isEmpty())
            throw new RuntimeException("Heap is empty");
        int max = heap[0];
        heap[0] = heap[--heapSize];
        heap[heapSize] = 0;
        if (heapSize > 1)
            heapifyDown(0, heap[0]);
        return max;
    }

    public int peek() {
        if (isEmpty())
            throw new RuntimeException("Heap is empty");
        return heap[0];
    }

    /**
     * Heap Sort Implementation
     */
    public static void sort(int[] nums) {
        MaxHeap heap = new MaxHeap(nums);
        heap.sort();
    }

    private MaxHeap(int[] nums) {
        heap = nums;
        heapSize = nums.length;
        for (int i = heapSize / 2 - 1; i >= 0 ; i--) {
            heapifyDown(i, heap[i]);
        }
    }

    private void sort() {
        for (int i = heapSize - 1; i > 0 ; i--) {
            int tmp = heap[i];
            heap[i] = heap[0];
            heapifyDown(0, tmp);
        }
    }
}
