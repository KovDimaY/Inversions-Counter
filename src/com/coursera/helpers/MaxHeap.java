package com.coursera.helpers;

public class MaxHeap {
	
	private int[] Heap;
    private int size;
    private int maxsize;
 
    private static final int ROOT = 0;
 
    public MaxHeap(int maxsize)
    {
        this.maxsize = maxsize;
        this.size = 0;
        this.Heap = new int[this.maxsize + 1];
        this.Heap[0] = Integer.MIN_VALUE;
    }
 
    private int parent(int pos)
    {
        return pos / 2;
    }
 
    private int leftChild(int pos)
    {
        return (2 * pos);
    }
 
    private int rightChild(int pos)
    {
        return (2 * pos) + 1;
    }
 
    private boolean isLeaf(int pos)
    {
        if (pos >=  (this.size / 2)  &&  pos <= this.size)
        { 
            return true;
        }
        return false;
    }
 
    private void swap(int firstPos, int secondPos)
    {
        int temp;
        temp = this.Heap[firstPos];
        this.Heap[firstPos] = this.Heap[secondPos];
        this.Heap[secondPos] = temp;
    }
 
    private void maxHeapify(int pos)
    {
        if (!this.isLeaf(pos))
        { 
            if ( this.Heap[pos] < this.Heap[this.leftChild(pos)]  || this.Heap[pos] < this.Heap[this.rightChild(pos)])
            {
                if (this.Heap[this.leftChild(pos)] > this.Heap[this.rightChild(pos)])
                {
                    this.swap(pos, this.leftChild(pos));
                    this.maxHeapify(this.leftChild(pos));
                } else
                {
                    this.swap(pos, this.rightChild(pos));
                    this.maxHeapify(this.rightChild(pos));
                }
            }
        }
    }
 
    public void insert(int element)
    {
        this.Heap[++this.size] = element;
        int current = this.size;
 
        while (this.Heap[current] > this.Heap[this.parent(current)])
        {
            this.swap(current, this.parent(current));
            current = this.parent(current);
        }	
    }
 
    public int remove()
    {
        int popped = this.Heap[ROOT];
        this.Heap[ROOT] = this.Heap[this.size--]; 
        this.maxHeapify(ROOT);
        return popped;
    }
    
    public int size() {
    	return this.size;
    }
    
    public int getMax() {
    	return this.Heap[ROOT];
    }
}