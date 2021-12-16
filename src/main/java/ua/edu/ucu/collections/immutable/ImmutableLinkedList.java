package ua.edu.ucu.collections.immutable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ImmutableLinkedList implements ImmutableList {
    private Node had;
    private Node tail;
    private int len = 0;


    public ImmutableLinkedList(Object[] elements) {
        if (elements.length == 0) {
            new ImmutableLinkedList();
        } else {
            had = new Node();
            had.setValue(elements[0]);
            Node previous = had;
            int counter = 0;
            for (Object object: elements) {
                if (counter != 0) {
                    Node newNode = new Node();
                    previous.setNext(newNode);
                    newNode.setValue(object);
                    newNode.setPrevious(previous);
                    previous = newNode;
                }
                counter++;
            }
            len = counter;
            tail = previous;
        }
    }

    public ImmutableLinkedList() {
        had = new Node();
        tail = had;
    }

    @Override
    public ImmutableLinkedList add(Object e) {
        return add(len, e);
    }

    @Override
    public ImmutableLinkedList add(int index, Object e) {
        List<Object> array = convertShit();
        if (array.size() == 0) {
            array.add(e);
        } else {
            array.add(index, e);
        }
        return new ImmutableLinkedList(array.toArray());
    }

    @Override
    public ImmutableLinkedList addAll(Object[] c) {
        List<Object> array = convertShit();
        Collections.addAll(array, c);
        return new ImmutableLinkedList(array.toArray());
    }

    @Override
    public ImmutableLinkedList addAll(int index, Object[] c) {
        List<Object> array = convertShit();
        for (int i = 0; i < c.length; i++) {
            array.add(index + i, c[i]);
        }
        return new ImmutableLinkedList(array.toArray());
    }

    @Override
    public Object get(int index) {
        return toArray()[index];
    }

    @Override
    public ImmutableLinkedList remove(int index) {
        List<Object> array = convertShit();
        array.remove(index);

        return new ImmutableLinkedList(array.toArray());
    }

    @Override
    public ImmutableLinkedList set(int index, Object e) {
        Object[] array = toArray();
        array[index] = e;
        return new ImmutableLinkedList(array);
    }

    @Override
    public int indexOf(Object e) {
        Node current = had;
        for (int i = 0; i < len; i++) {
            if (current == e) {
                return i;
            }
            current = current.getNext();
        }
        return -1;
    }

    @Override
    public int size() {
        return len;
    }

    @Override
    public ImmutableLinkedList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return len != 0;
    }

    @Override
    public Object[] toArray() {
        ArrayList<Object> array = new ArrayList<>();
        if (len == 0) {
            return array.toArray();
        }
        Node current = had;

        while (current != null) {
            array.add(current.getValue());
            current = current.getNext();
        }

        return array.toArray();
    }

    public List<Object> convertShit() {
        List<Object> array = new ArrayList<>();
        Object[] lst = toArray();
        Collections.addAll(array, lst);
        return array;
    }


    public ImmutableLinkedList addFirst(Object e) {
        return addAll(0, new Object[]{e});
    }

    public ImmutableLinkedList addLast(Object e) {
        return add(e);
    }

    public Node getHead() {
        return had;
    }

    public Node getTail() {
        return tail;
    }

    public Object getFirst() {
        return had.getValue();
    }

    public Object getLast() {
        return tail.getValue();
    }

    public ImmutableLinkedList removeFirst() {
        return remove(0);
    }

    public ImmutableLinkedList removeLast() {
        return remove(len - 1);
    }
}
