/*
 * Implement a MinHeap class that supports:

Building a Min Heap from an input array of integers.
Inserting integers in the heap.
Removing the heap's minimum / root value.
Peeking at the heap's minimum / root value.
Sifting integers up and down the heap, which is to be used when inserting and removing values.
Note that the heap should be represented in the form of an array.

If you're unfamiliar with Min Heaps, we recommend watching the Conceptual Overview section of this question's video explanation before starting to code.

Sample Usage
array = [48, 12, 24, 7, 8, -5, 24, 391, 24, 56, 2, 6, 8, 41]

MinHeap(array): - // instantiate a MinHeap (calls the buildHeap method and populates the heap)
buildHeap(array): - [-5, 2, 6, 7, 8, 8, 24, 391, 24, 56, 12, 24, 48, 41]
insert(76): - [-5, 2, 6, 7, 8, 8, 24, 391, 24, 56, 12, 24, 48, 41, 76]
peek(): -5
remove(): -5 [2, 7, 6, 24, 8, 8, 24, 391, 76, 56, 12, 24, 48, 41]
peek(): 2
remove(): 2 [6, 7, 8, 24, 8, 24, 24, 391, 76, 56, 12, 41, 48]
peek(): 6
insert(87): - [6, 7, 8, 24, 8, 24, 24, 391, 76, 56, 12, 41, 48, 87]
 */

import java.util.Arrays;

public class MinHeap {

    private int[] heap;
    private int size;

    public MinHeap(int[] array) {
        this.heap = array;
        this.size = array.length;
        buildHeap();
    }

    public void insert(int value) {
        ensureExtraCapacity();
        heap[size] = value;
        size++;
        siftUp(size - 1);
    }

    public int remove() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        int rootValue = heap[0];
        heap[0] = heap[size - 1];
        size--;
        siftDown(0);
        return rootValue;
    }

    public int peek() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap[0];
    }

    private void buildHeap() {
        int lastParentIndex = (size - 2) / 2;
        for (int i = lastParentIndex; i >= 0; i--) {
            siftDown(i);
        }
    }

    private void siftUp(int index) {
        int parentIndex = (index - 1) / 2;
        while (index > 0 && heap[index] < heap[parentIndex]) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    private void siftDown(int index) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int smallestChildIndex = index;

        if (leftChildIndex < size && heap[leftChildIndex] < heap[smallestChildIndex]) {
            smallestChildIndex = leftChildIndex;
        }

        if (rightChildIndex < size && heap[rightChildIndex] < heap[smallestChildIndex]) {
            smallestChildIndex = rightChildIndex;
        }

        if (smallestChildIndex != index) {
            swap(index, smallestChildIndex);
            siftDown(smallestChildIndex);
        }
    }

    private void swap(int index1, int index2) {
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    private void ensureExtraCapacity() {
        if (size == heap.length) {
            int[] newHeap = new int[2 * heap.length];
            System.arraycopy(heap, 0, newHeap, 0, heap.length);
            heap = newHeap;
        }
    }

    public static void main(String[] args) {
        int[] array = { 4, 1, 3, 9, 7 };
        MinHeap heap = new MinHeap(array);
        System.out.println("Heap built from input array: " + Arrays.toString(array));
        System.out.println("Minimum value in heap: " + heap.peek());

        heap.insert(2);
        System.out.println("Inserted value 2");
        System.out.println("Minimum value in heap: " + heap.peek());

        int min = heap.remove();
        System.out.println("Removed minimum value from heap: " + min);
        System.out.println("Minimum value in heap: " + heap.peek());
    }
}
