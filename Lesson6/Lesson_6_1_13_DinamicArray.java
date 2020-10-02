package Lesson6;

import java.util.Arrays;

public class Lesson_6_1_13_DinamicArray {
    public static void main(String[] args) {
        DynamicArray<String> da = new DynamicArray<>();
        System.out.println("size = " + da.size());
        da.add("Hello");
        da.add("world");
        System.out.println("size = " + da.size());
        System.out.println(da.get(0) + da.get(1));
        da.remove(0);
        System.out.println("size = " + da.size());
        System.out.println(da.get(0));
        System.out.println(da.get(1));
    }

    public static class DynamicArray<T> {
        private static final int DEFAULT_CAPACITY = 10;
        private Object[] arr;
        private int size;

        public DynamicArray() {
            this(DEFAULT_CAPACITY);
        }
        public DynamicArray(int initialCapacity) {
            if (initialCapacity > 0) {
                this.arr = new Object[initialCapacity];
            } else if (initialCapacity == 0) {
                this.arr = new Object[]{};
            } else {
                throw new IllegalArgumentException("Illegal Capacity: "+
                        initialCapacity);
            }
        }

        public void add(T el){
            if (size == arr.length){
                arr = grow();
            }
            arr[size] = el;
            size++;
        }

        public void remove(int index){
            if (index < 0 || index >= size){
                throw new IndexOutOfBoundsException();
            }

            final Object[] es = arr;

            final int newSize;
            if ((newSize = size - 1) > index){
                System.arraycopy(es, index + 1, es, index, newSize - index);
            }
            es[size = newSize] = null;
        }

        public T get(int index){
            if (index < 0 || index >= size){
                throw new IndexOutOfBoundsException();
            }

            return (T) arr[index];
        }

        private Object[] grow() {
            int oldCapacity = arr.length;
            if (oldCapacity > 0 ) {
                int newCapacity = (int) (1.5 * oldCapacity);
                return arr = Arrays.copyOf(arr, newCapacity);
            } else {
                return arr = new Object[DEFAULT_CAPACITY];
            }
        }

        public int size() {
            return size;
        }
    }
}
