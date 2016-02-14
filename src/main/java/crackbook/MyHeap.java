package crackbook;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Created by Suheng on 12/21/15.
 */
public class MyHeap<T extends Comparable<T>> {
    /**
     * 在实现中,使用ArrayList作为其内部容器
     * 在ArrayList基于数组,方便定位
     * 父亲结点和子结点的关系只要计算就可以得到
     * (2*index+1)
     * (index-1)/2
     */
    ArrayList<T> items;
    int cursor;//用于记数

    public MyHeap(int size) {
        this.items = new ArrayList<T>(size);
        cursor = -1;
    }

    public MyHeap() {
        this.items = new ArrayList<T>();
        cursor = -1;
    }

    //上移动操作
    public void siftUp(int index) {
        T intent = this.items.get(index);
        while (index > 0) {
            int pindex = (index - 1) / 2;
            T parent = items.get(pindex);
            if (intent.compareTo(parent) > 0) {
                this.items.set(index, parent);
                index = pindex;
            } else {
                break;
            }
        }

        this.items.set(index, intent);
    }


    //下移动操作
    public void siftDown(int index) {
        T intent = this.items.get(index);
        int l_index = 2 * index + 1;
        while (l_index < this.items.size()) {
            T maxChild = this.items.get(l_index);
            int max_index = l_index;
            int r_index = l_index + 1;
            if (r_index < this.items.size()) {
                T rightChild = items.get(r_index);
                if (rightChild.compareTo(maxChild) > 0) {
                    maxChild = rightChild;
                    max_index = r_index;
                }
            }
            if (maxChild.compareTo(intent) > 0) {
                items.set(index, maxChild);
                index = max_index;
                l_index = index * 2 + 1;
            } else {
                break;
            }
        }
        this.items.set(index, intent);
    }

    public void add(T item) {
        this.items.add(item);
        siftUp(this.items.size() - 1);
    }

    public T deleteTop() {
        if (this.items.isEmpty()) {
            throw new NoSuchElementException();
        }
        T maxItem = this.items.get(0);
        T lastItem = this.items.remove(this.items.size() - 1);
        if (this.items.isEmpty()) {
            return lastItem;
        }

        items.set(0, lastItem);
        siftDown(0);
        return maxItem;
    }

    public T next() {
        if (cursor < 0 || cursor == (this.items.size() - 1)) {
            return null;
        }
        cursor++;
        return items.get(cursor);
    }

    public T first() {
        if (this.items.size() == 0) {
            return null;
        }
        cursor = 0;
        return this.items.get(0);
    }

    public boolean isEmpty() {
        return this.items.isEmpty();
    }

    public int size() {
        return items.size();
    }

    public void clear() {
        this.items.clear();
    }

    public void print() {
        for (T t : this.items) {
            System.out.print(t + " ");
        }
    }

    public static void main(String[] args) {
        MyHeap<Integer> heap = new MyHeap<Integer>();

        heap.add(1);
        heap.add(2);
        heap.add(3);
        heap.add(4);
        heap.add(5);
        heap.add(6);

        heap.print();

    }
}
