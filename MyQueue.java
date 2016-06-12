package uk.ac.reigate.RM13030.linear;

import java.util.Arrays;

/**
 * @author Robbie
 * @since 16-09-2015
 */

public class MyQueue implements LinearQueue {
    
    public static Object[] queue;
    public int frontPointerPos;
    public int rearPointerPos;
    
    public MyQueue() {
        queue = new Object[Constants.capacity];
        
        add("str1", 1, true);
        add("str2", 2, true);
        
        /*add("str1", true);
        add("str2", true);
        add("str3", true);
        remove("str1", true);
        add("str67", true);*/
    }

    @Override
    public int getSize() {
        return queue.length;
    }
    
    @Override
    public int getFrontPos() {
        return frontPointerPos;
    }

    @Override
    public int getRearPos() {
        return rearPointerPos;
    }

    @Override
    public Object peek() {
        return queue[frontPointerPos];
    }

    @Override
    public boolean isEmpty() {
        return queue.length == 0;
    }

    @Override
    public boolean isFull() {
        return queue.length == 5;
    }

    /* Debugging only */
    @Override
    public void add(Object obj, int idx, boolean print) {
        try { 
            queue[(idx - 1)] = obj;
            rearPointerPos = (idx - 1);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.err.println("[ERROR]: Given array index is out of bounds -> Ignoring...");
        }
        if (print)
            printContents(true);
    }
    
    @Override
    public void add(Object obj, boolean print) {
        if (queue[getRearPos()] == null) {
            rearPointerPos--;
        }
        rearPointerPos++;
        queue[getRearPos()] = obj;
        if (print)
            printContents(true);
    }
    
    public int getLastObjIndex() {
        int index = 0;
        for (int i = 0; i < queue.length; i++) {
            if (queue[i] != null) {
                index++;
            }
            continue;
        }
        return (index - 1);
    }
    
    @Override
    public void remove(boolean print) {
        queue[getFrontPos()] = null;
        frontPointerPos++;
        if (print)
            printContents(true);
    }

    @Override
    public void remove(int idx, boolean print) {
        queue[idx] = null;
        frontPointerPos++;
        if (print)
            printContents(true);
    }
    
    @Override
    public void remove(Object obj, boolean print) {
        int idx = Arrays.asList(queue).indexOf(obj);
        queue[idx] = null;
        frontPointerPos++;
        if (print)
            printContents(true);
    }

    @Override
    public void printContents(boolean breakLine) {
        for (int i = 0; i < queue.length; i++) {
            System.out.print("["+i+"] - "+queue[i]);
            if (i == rearPointerPos || i == frontPointerPos) {
                System.out.print("\t<--- "+(i == rearPointerPos ? "Rear Pointer ("+i+")" : "Front Pointer ("+i+")")+"\n");
            } else {
                if (breakLine == true) {
                    System.out.print("\n");
                }
            }
        }
        
        if (breakLine == true) {
            System.out.print("\n");
        }
    }
    
    @Override
    public void printContents() {
        for (int i = 0; i < queue.length; i++) {
            System.out.println("["+i+"] - "+queue[i]);
        }
    }
    
    public static void main(String args[]) { new MyQueue(); }

}
