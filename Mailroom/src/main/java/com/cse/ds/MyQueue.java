package com.cse.ds;

import java.util.*;

/**
 * Author: Julian Wai San Yan 
 * Date: 5/8/19
 * File: MyQueue.java 
 */

/**
 * This file contains the MyQueue class which implements the queue data
 * structure. This means that whatever is inserted first, is the first one to
 * be removed.
 */

/**
 * This class contains the methods of a queue such as enqueue and dequeue. 
 * These methods follow the first in, first out order. There are also methods
 * to check if the queue is empty and to peek into the queue.
 */

public class MyQueue<E> {

    private MyQueueNode<E> head;
    private MyQueueNode<E> tail;
    private int nElements;

    /**
     * Constructor for MyQueue object
     * 
     * @param none
     * @return    MyQueue object
     */

    public MyQueue() {
        this.head = new MyQueueNode(null);
        this.tail = new MyQueueNode(null);
        this.head.setNext(tail);
        this.nElements = 0;
    }

    /**
     * Adds an element of generic type E to the end of the queue
     *
     * @param element element to add
     * @return        none
     */

    public void enqueue(E element) throws NullPointerException {
        // if element is null, throw exception
        if(element == null) {
            throw new NullPointerException();
        }
        
        // create new node with element
        MyQueueNode newNode = new MyQueueNode(element);

        // if queue is empty, set head and tail to newNode
        if(isEmpty() == true) {
            this.head = newNode;
            this.tail = newNode;
            nElements++;
        }
        
        // if not empty, set tail to newNode
        else {
            this.tail.setNext(newNode);
            this.tail = newNode;
            nElements++;
        }
    }

    /**
     * Removes and returns the element of generic type E from the head of the
     * queue
     *
     * @param  none
     * @return the element that was removed
     */
    
    public E dequeue() throws NoSuchElementException {
        // if there are no elements to remove, throw exception
        if(this.size() == 0) {
            throw new NoSuchElementException();
        }
        
        // stores the element to be removed
        E removedElement = this.head.getElement();

        // if there is 1 element left, set head and tail to null
        if(this.size() == 1) {
            this.head = new MyQueueNode(null);
            this.tail = new MyQueueNode(null);
            this.head.setNext(tail);
            nElements--;
            return removedElement;
        }

        // sets the new head
        this.head = this.head.getNext();
    	nElements--;
        return removedElement;
    }

    /**
     * Returns the element of generic type E at the head of the queue
     * 
     * @param  none
     * @return none
     */

    public E peek() throws NoSuchElementException {
        // if there are no elements, throw exception
        if(this.isEmpty() == true) {
            throw new NoSuchElementException();
        }
    	return this.head.getElement();
    }

    /**
     * Whether or not the queue is empty
     * 
     * @param  none
     * @return none
     */

    public boolean isEmpty() {
        if(nElements == 0) {
            return true;
        }

    	return false;
    }

    /**
     * Returns the size of the queue
     * 
     * @param  none
     * @return none
     */

    public int size() {
    	return this.nElements;

    }

}
