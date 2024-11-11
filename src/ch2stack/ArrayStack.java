package ch2stack;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.HashSet;
import java.util.Set;

public class ArrayStack<T> {

    //variable

    private static final int defult_capacity = 3;
    int top;
    private T[] stack;

    // Constructor
    public ArrayStack(int size) {
        top = 0;
        stack = (T[]) new Object[size];
    }

    public ArrayStack() {
        this(defult_capacity);
    }

    // Method to get size
    int size() {
        return top;
    }

    boolean isFull() {
        return top == stack.length;
    }

    void push(T element) {
        if (size() == stack.length)
            expandCapacity();
        stack[top] = element;
        top++;
    }

    private void expandCapacity() {
        stack = Arrays.copyOf(stack, stack.length * 2);
    }

    T peak() throws EmptyStackException {
        if (isFull())
            throw new EmptyStackException();
        return stack[top - 1];
    }

    public T pop() throws EmptyStackException {
        if (isFull())
            throw new EmptyStackException();
        top--;
        T removedElement = stack[top];
        stack[top] = null;
        return removedElement;
    }
//// get length
    public int getLength() {
        return stack.length;
    }
/////// ZERO TO TOP
    public T[] display() {
        for (int i = top - 1; i >= 0; i--) {
            System.out.println(stack[i]);
        }
        return stack;
    }

    // remove duplicates methods
    public ArrayStack<T> removeDuplicates(ArrayStack<T> stack1, ArrayStack<T> stack2) {
        ArrayStack<T> result = new ArrayStack<T>();
        boolean duplicateFound;

        // Add elements from stack1 ///
        for (int i = 0; i < stack1.size(); i++) {
            duplicateFound = false;
            T element = stack1.stack[i];
            // Check if element is already exist ////
            for (int j = 0; j < result.size(); j++) {
                if (result.stack[j].equals(element)) {
                    duplicateFound = true;
                    break;
                }
            }
            // HAdii owsan horay ugu jirin, add //
            if (!duplicateFound) {
                result.push(element);
            }
        }

        // Add elements from stack2
        for (int i = 0; i < stack2.size(); i++) {
            duplicateFound = false;
            T element = stack2.stack[i];
            // Check if element is already in the result
            for (int j = 0; j < result.size(); j++) {
                if (result.stack[j].equals(element)) {
                    duplicateFound = true;
                    break;
                }
            }
            //// HAdii owsan horay ugu jirin, add //
            if (!duplicateFound) {
                result.push(element);
            }
        }

        return result;
    }

    @Override
    public String toString() {
        return "ArrayStack{" +
                "top=" + top +
                ", stack=" + Arrays.toString(stack) +
                '}';
    }

    public static void main(String[] args) {
        ArrayStack<Integer> s1 = new ArrayStack<>();
        ArrayStack<Integer> s2 = new ArrayStack<>();


        s1.push(100);
        s1.push(300);
        s1.push(100);
        s1.push(300);
        s2.push(200);
        s2.push(500);
        s2.push(200);
        s2.push(500);
        ArrayStack<Integer> resultStack = s1.removeDuplicates(s1, s2);


        System.out.println("Result Stack Element is: " + resultStack);
//        resultStack.display();
    }
}

