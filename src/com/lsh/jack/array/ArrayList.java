package com.lsh.jack.array;

import java.util.*;

/**
 * 自己实现的类
 */
public class ArrayList<E> implements List<E> {

    private Object[] data;

    private static final int DEFAULT_SIZE = 10;

    private static final Object[] DEFAULT_EMPTY_ARRAY = {};

    private int size = 0;


    public ArrayList() {
        data = DEFAULT_EMPTY_ARRAY;
    }

    public ArrayList(int initialCapacity) {
        if (initialCapacity < 0 ) {
            throw  new IllegalArgumentException("initialCapacity must bigger than zero");
        }
        data = new Object[initialCapacity];
        this.size = initialCapacity;
    }

    public ArrayList(Collection<? extends E> collection) {
        Objects.requireNonNull(collection);
        Object[] objects = collection.toArray();
        size = objects.length;
        data = Arrays.copyOf(objects, objects.length);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator<E>();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        if (data == DEFAULT_EMPTY_ARRAY) {
            data = new Object[DEFAULT_SIZE];
        }
        // 扩容1.5倍
        if (size == data.length) {
            Objects[] newData = new Objects[data.length + (data.length >> 2)];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
        data[size++] = e;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        Objects.requireNonNull(o);
        int index = -1;
        for (int i = 0; i < data.length; i++) {
            if (o.equals(data[i])) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return false;
        }
        // 移动剩余的元素
        System.arraycopy(data, index, data, index+1, size - index);
        data[--size] = null;
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        data = DEFAULT_EMPTY_ARRAY;
        size = 0;
    }

    @Override
    public E get(int index) {
        if (index < 0 && index > size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return (E)data[index];
    }

    @Override
    public E set(int index, E element) {
        if (index < 0 && index > size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        E oldValue = (E)data[index];
        data[index] = element;
        return oldValue;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }


    class MyIterator<E> implements ListIterator<E> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index != size;
        }

        @Override
        public E next() {
            return (E)data[index++];
        }

        @Override
        public boolean hasPrevious() {
            return false;
        }

        @Override
        public E previous() {
            return null;
        }

        @Override
        public int nextIndex() {
            return 0;
        }

        @Override
        public int previousIndex() {
            return 0;
        }

        @Override
        public void remove() {
            ArrayList.this.remove(index);
        }

        @Override
        public void set(E e) {

        }

        @Override
        public void add(E e) {

        }
    }

}
