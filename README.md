Author: Julian Yan  
Date: 5/8/2019  
Title: Mailroom  
Summary: This program implements a queue and hashmap to mimic the sorting of an item in a mailroom.

Contents: 
* src
  * main
    * Deliverable.java
      * This file contains the abstract Deliverale class.
        * int getId()
        * int getWeight()
        * int getTimeStamp()
        * void setTimestamp(int timestamp) 
        * String getFromAddress()
        * String getToAddress()
        * String getZipCode()
        * int hashCode()
        * boolean equals(Object obj)
    * Mailroom.java
      * This file contains the Mailroom class which implements a hashmap of queues.
        * Mailroom()
        * void registerItem(Deliverable d)
        * Deliverable deliverEarliest()
        * Deliverable deliverEarliest(String zip)
        * Deliverable checkEarliest()
        * Deliverable checkEarliest(String zip)
        * ArrayList<Deliverable> deliverAll()
        * ArrayList<Deliverable> deliverAll(String zip)
        * ArrayList<Deliverable> deliverByWeight(int capacity)
        * ArrayList<Deliverable> deliverByWeight(int capacity, String zip)
        * void sortMergedQueues(ArrayList<Deliverable> toSort)
        * void mergeBins(String prefix)
    * MyMail.java
      * This file contains a class which extends from the Deliverable abstract class.
        * MyMail(int id, String fromAddress, String toAddress, String message)
        * String getMessage()
        * String getZipCode()
    * MyPackage.java
      * This file contains a class which extends from the Deliverable abstract class.
        * MyPackage(int id, String fromAddress, String toAddress, E content, int weight)
        * E getContent()
        * String getZipCode()
    * MyQueue.java
      * This file contains a class which implements the queue data structure. 
        * MyQueue()
        * void enqueue(E element)
        * E dequeue()
        * E peek()
        * boolean isEmpty()
        * int size()
    * MyQueueNode.java
      * This file contains a class that acts as the Node class for the Queue.
        * MyQueueNode(E elem)
        * MyQueueNode<E> getNext()
        * void setNext(MyQueueNode<E> node)
        * E getElement()
  * test
    * TestDeliverable.java
    * TestMailroom.java
    * TestMyQueue.java
    * TestPackage.java
