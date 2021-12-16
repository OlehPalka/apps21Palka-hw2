package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {

    private ImmutableLinkedList stack = new ImmutableLinkedList();

    public void push(Object e) {
        stack = stack.add(e);
    }

    public Object pop() {
        Object result = stack.getLast();
        stack = stack.removeLast();
        return result;
    }

    public Object peek() {
        return stack.getLast();
    }
}
