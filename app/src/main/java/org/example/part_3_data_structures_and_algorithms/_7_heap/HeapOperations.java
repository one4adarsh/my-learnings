package org.example.part_3_data_structures_and_algorithms._7_heap;

public class HeapOperations extends HeapConstructor {
    public void insert(int value) {
        heap.add(value);
        int current = heap.size() - 1;

        while (current > 0 && heap.get(current) > heap.get(parent(current))) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public void sinkDown(int parentIndex) {
        int maxIndex = parentIndex;
        while (true) {
            int leftIndex = leftChild(parentIndex);
            int rightIndex = rightChild(parentIndex);
            if (leftIndex < heap.size() && heap.get(leftIndex) > heap.get(maxIndex)) {
                maxIndex = leftIndex;
            }

            if (rightIndex < heap.size() && heap.get(rightIndex) > heap.get(maxIndex)) {
                maxIndex = rightIndex;
            }

            if (maxIndex != parentIndex) {
                swap(parentIndex, maxIndex);
                parentIndex = maxIndex;
            } else {
                return;
            }
        }
    }

    public Integer remove() {
        if (heap.isEmpty()) {
            return null;
        }
        if (heap.size() == 1) {
            return heap.remove(0);
        }

        int maxValue = heap.get(0);
        heap.set(0, heap.remove(heap.size() - 1));
        sinkDown(0);

        return maxValue;
    }

    public void insertMinHeap(int value) {
        heap.add(value);
        int current = heap.size() - 1;

        while (current > 0 && heap.get(current) < heap.get(parent(current))) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public void sinkDownMinHeap(int parentIndex) {
        int minIndex = parentIndex;
        while (true) {
            int leftIndex = leftChild(parentIndex);
            int rightIndex = rightChild(parentIndex);
            if (leftIndex < heap.size() && heap.get(leftIndex) < heap.get(minIndex)) {
                minIndex = leftIndex;
            }

            if (rightIndex < heap.size() && heap.get(rightIndex) < heap.get(minIndex)) {
                minIndex = rightIndex;
            }

            if (minIndex != parentIndex) {
                swap(parentIndex, minIndex);
                parentIndex = minIndex;
            } else {
                return;
            }
        }
    }

    public Integer removeMinHeap() {
        if (heap.isEmpty()) {
            return null;
        }
        if (heap.size() == 1) {
            return heap.remove(0);
        }

        int minValue = heap.get(0);
        heap.set(0, heap.remove(heap.size() - 1));
        sinkDownMinHeap(0);

        return minValue;
    }
}
