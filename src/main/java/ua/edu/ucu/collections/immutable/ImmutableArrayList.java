package ua.edu.ucu.collections.immutable;

import java.util.Arrays;
import java.util.Objects;

public final class ImmutableArrayList implements ImmutableList {
    private Object[] array;

    public ImmutableArrayList(Object[] elements) {
        this.array = elements.clone();
    }

    public ImmutableArrayList() {
        this.array = new Object[]{};
    }

    @Override
    public ImmutableList add(Object e) {
        return addAll(-1, new Object[]{e});
    }

    @Override
    public ImmutableList add(int index, Object e) {
        return addAll(index, new Object[]{e});
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(-1, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        Object[] result = new Object[array.length + c.length];
        if (index == -1) {
            System.arraycopy(array, 0, result, 0, array.length);
            System.arraycopy(c, 0, result, array.length, c.length);
            return new ImmutableArrayList(result);
        }
        int counter = 0;
        for (int i = 0; i < index; i++) {
            result[i] = array[i];
            counter++;
        }

        for (Object o : c) {
            result[counter] = o;
            counter++;
        }

        for (int i = index; i < array.length; i++) {
            result[counter] = array[i];
            counter++;
        }
        return new ImmutableArrayList(result);
    }

    @Override
    public Object get(int index) {
        return array[index];
    }

    @Override
    public ImmutableList remove(int index) {
        System.arraycopy(array, index + 1, array, index, array.length - index - 1);
        return new ImmutableArrayList(array);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        array[index] = e;
        return new ImmutableArrayList(array);
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == e) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return array.length > 0;
    }

    @Override
    public Object[] toArray() {
        Object[] newArray = new Object[size()];

        System.arraycopy(array, 0, newArray, 0, size());

        return newArray;
    }
}
