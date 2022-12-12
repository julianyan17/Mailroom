package com.cse.ds;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Author: Julian Wai San Yan 
 * Date: 5/8/19
 * File: Mailroom.java 
 */

/**
 * This file contains the Mailroom class which implements a hashmap of queues.
 * This class mimicks an actual mailroom in which mail is sorted by its 
 * zipcodes.
 */

/**
 * This class contains methods to modify the hashmap in a Mailroom object.
 * Methods include registering an item, deliverying the earliest item, and
 * merging all the items with the same zipcode prefix.
 */

public class Mailroom {
    private HashMap<Deliverable,MyQueue<Deliverable>> deliveryBins;
    private int currentTimestamp;

    private static final String EMPTY = "";
    private static final int ZIPCODE_LENGTH = 5;
    private static final String DASH = "-";

    /**
     * Constructor for Mailroom
     *
     * @param none
     * @return    Mailroom object
     */

    public Mailroom() {
        this.deliveryBins = new HashMap<Deliverable, MyQueue<Deliverable>>();
        this.currentTimestamp = 0;
    }

    /**
     * Adds an item to the hashmap
     *
     * @param d Deliverable item to add
     * @return  none
     */

    public void registerItem(Deliverable d) throws NullPointerException  {
        // if item to add is null, throw exception
        if(d == null) {
            throw new NullPointerException();
        }

        // set the timestamp of the item
        d.setTimestamp(this.currentTimestamp);

        // if item zipcode exists in hashmap, add to the key
        if(deliveryBins.containsKey(d)) {
            deliveryBins.get(d).enqueue(d);
        }

        // if item zipcode doesn't exist in hashmap, add new key and add item
        else {
            deliveryBins.put(d, new MyQueue<Deliverable>());
            deliveryBins.get(d).enqueue(d);
        }
        currentTimestamp++;
    }

    /** 
     * Removes and returns the Deliverable object that has the earliest
     * timestamp
     *
     * @param none
     * @return     Deliverable object that was removed
     */

    public Deliverable deliverEarliest() {
        // if hashmap is empty, return null
        if(this.deliveryBins.isEmpty() == true) {
            return null;
        }

        // stores the earliest Deliverable object
        Deliverable toReturn = this.checkEarliest();

        // remove object from hashmap
        this.deliveryBins.get(toReturn).dequeue();

        // if there are no more values in the key, remove the value
        if(this.deliveryBins.get(toReturn).isEmpty()) {
            this.deliveryBins.remove(toReturn);
        }
        return toReturn;

    }
    
    /** 
     * Removes and returns the Deliverable object with the zipcode that has the 
     * earliest timestamp
     *
     * @param none
     * @return     Deliverable object with the zipcode that was removed
     */

    public Deliverable deliverEarliest(String zip) {
        // create a dummy Deliverable object
        Deliverable dummy = new MyMail(1,zip,zip,EMPTY);

        // if zipcode doesn't exist in hashmap
        if(!(this.deliveryBins.containsKey(dummy))) {
                return null;
        }

        // remove object from hashmap
        Deliverable toReturn = this.deliveryBins.get(dummy).dequeue();

        // if there are no more values in the key, remove the value
        if(this.deliveryBins.get(dummy).isEmpty()) {
            this.deliveryBins.remove(dummy);
        }
        return toReturn;

    }

    /** 
     * Returns the Deliverable object with the earliest timestamp
     *
     * @param none
     * @return    Deliverable object with the earliest timestamp
     */

    public Deliverable checkEarliest() {
        if(this.deliveryBins.isEmpty() == true) {
            return null;
        }

        // set smallest timestamp to -1 
        int smallest = -1;
        // initialize object to return
        Deliverable toReturn = null;

        // iterate through the entire hashmap to get the object with the
        // earliest timestamp
        for(Deliverable d: deliveryBins.keySet()) {
            MyQueue<Deliverable> q = deliveryBins.get(d);
            int queueTimeStamp = q.peek().getTimestamp();
            // if the timestamp is less than smallest
            if(queueTimeStamp < smallest || smallest == -1) {
                // set the object to return
                toReturn = q.peek();
                // make smallest the same as the lowest timestamp
                smallest = queueTimeStamp;
            }
        }  
        return toReturn;
    }

    /** 
     * Returns the Deliverable object of the zipcode with the earliest timestamp
     *
     * @param none
     * @return    Deliverable object of the zipcode with the earliest timestamp
     */

    public Deliverable checkEarliest(String zip) {
        // create a dummy Deliverable object
        Deliverable dummy = new MyMail(1,zip,zip,EMPTY);

        // get the object with the earliest timestamp
        if(this.deliveryBins.containsKey(dummy)) {
            Deliverable toReturn = deliveryBins.get(dummy).peek();
            return toReturn;
        }
        return null;
    }

    /**
     * Removes and returns all Deliverable objects currently in the mailroom as
     * an Arraylist
     *
     * @param none 
     * @return    Arraylist with all the objects that were removed
     */ 

    public ArrayList<Deliverable> deliverAll() {
        
        ArrayList<Deliverable> toReturn = new ArrayList<Deliverable>();
        int queueSize = 0;

        // iterate through the entire hashmap to get the number of Deliverable
        // objects in the hashmap
        for(Deliverable d: deliveryBins.keySet()) {
            MyQueue<Deliverable> q = deliveryBins.get(d);
            queueSize += q.size();
        }

        // remove each item from hashmap in ascending order
        for(int i = 0; i < queueSize; i++) {
            toReturn.add(this.deliverEarliest());
        }
        return toReturn;
    }

    /**
     * Removes and returns all Deliverable objects with the zip currently in 
     * the mailroom as an Arraylist
     *
     * @param none 
     * @return    Arraylist with all the objects that were removed
     */ 

    public ArrayList<Deliverable> deliverAll(String zip){
        // create a dummy Deliverable object 
        Deliverable dummy = new MyMail(1,zip,zip,EMPTY);
        ArrayList<Deliverable> toReturn = new ArrayList<Deliverable>();

        // if zipcode doesn't exist in hashmap
        if(!(this.deliveryBins.containsKey(dummy))) {
                return toReturn;
        }

        int queueSize = this.deliveryBins.get(dummy).size();

        // remove each item from hashmap in ascending order
        for(int i = 0; i < queueSize; i++) {
                toReturn.add(this.deliverEarliest(zip));
        }
        return toReturn;
    }

    /**
     * Removes and returns all Deliverable objects currently in the mailroom 
     * under the weight capcity as an Arraylist
     *
     * @param none 
     * @return    Arraylist with all the objects that were removed
     */ 

    public ArrayList<Deliverable> deliverByWeight(int capacity) {        
        ArrayList<Deliverable> toReturn = new ArrayList<Deliverable>();
        int queueSize = 0;
        int weightCapacity = 0;

        // iterate through the entire hashmap to get the number of Deliverable
        // objects in the hashmap
        for(Deliverable d: deliveryBins.keySet()) {
            MyQueue<Deliverable> q = deliveryBins.get(d);
            queueSize += q.size();
        }

        // remove each item from hashmap in ascending order
        for(int i = 0; i < queueSize; i++) {
            // checks the capacity of the packages doesn't exceed
            weightCapacity += this.checkEarliest().getWeight();
            if(weightCapacity <= capacity) {
                toReturn.add(this.deliverEarliest());
            }
        }
        return toReturn;
    }

    /**
     * Removes and returns all Deliverable objects currently in the mailroom 
     * with the zip and under the weight capcity as an Arraylist
     *
     * @param none 
     * @return    Arraylist with all the objects that were removed
     */ 

    public ArrayList<Deliverable> deliverByWeight(int capacity, String zip) {
        Deliverable dummy = new MyMail(1,zip,zip,EMPTY);
        ArrayList<Deliverable> toReturn = new ArrayList<Deliverable>();

        // if zipcode doesn't exist in hashmap
        if(!(this.deliveryBins.containsKey(dummy))) {
                return toReturn;
        }

        int queueSize = this.deliveryBins.get(dummy).size();
        int weightCapacity = 0;

        // remove each item from hashmap in ascending order
        for(int i = 0; i < queueSize; i++) {
            // checks the capacity of the packages doesn't exceed
            weightCapacity += this.checkEarliest(zip).getWeight();
            if(weightCapacity <= capacity) {
                toReturn.add(this.deliverEarliest(zip));
            }
        }
        return toReturn;
    }

    /**
     * Helper method to sort Deliverable objects
     *
     * @param toSort arraylist of Deliverable objects to sort
     * @return       none
     */

    private void sortMergedQueues(ArrayList<Deliverable> 
            toSort) throws NullPointerException {
        // if array is null, throw exception
        if(toSort == null) {
            throw new NullPointerException();
        }

        // use boolean to check if swap has been made
        boolean swapped = false;
        for(int i = 1; i < toSort.size() && swapped == false; i++) {
            swapped = true;
            // loop through the entire array
            for(int j = 0; j < toSort.size() - i; j++) {
                // compares the timestamps of j and j + 1
                if(toSort.get(j).getTimestamp() > 
                        toSort.get(j + 1).getTimestamp()) {
                    // swap if comparison is true
                    Deliverable temp = toSort.get(j);
                    toSort.set(j, toSort.get(j + 1));
                    toSort.set(j + 1, temp);
                    swapped = false;
                }
            }
        }
    }

    /**
     * Merge all of the queues stored by each key that has the corresponding
     * zipcode prefix
     *
     * @param prefix prefix of zipcode
     * @return       none
     */

    public void mergeBins(String prefix) {
        ArrayList<Deliverable> toAdd = new ArrayList<Deliverable>(); 
        ArrayList<Deliverable> toRemove = new ArrayList<Deliverable>(); 

        if(prefix.length() == 5 || prefix.length() == 0) {
            return;
        }
      
        // if prefix matches zipcode, add to the toAdd arraylist
        for(Deliverable d: deliveryBins.keySet()) {
            MyQueue<Deliverable> q = deliveryBins.get(d);
            if(q.peek().getZipCode().startsWith(prefix)) {
                toAdd.add(q.peek());
            }
        }

        // if zipcode doesn't exist, return
        if(toAdd.isEmpty()) {
            return;
        }

        // remove each queue and add individual Deliverable object to toRemove
        // arraylist
        for(int i = 0; i < toAdd.size(); i++) {
            toRemove.addAll(this.deliverAll(toAdd.get(i).getZipCode()));
        }
         
        // sort all the Deliverable objects in toRemove arraylist
        sortMergedQueues(toRemove);

        // create a new queue with the objects from toRemove arraylist
        MyQueue<Deliverable> newQueue = new MyQueue<Deliverable>();
        for(int i = 0; i < toRemove.size(); i++) {
            newQueue.enqueue(toRemove.get(i));
        }

        // create prefix with dashes 
        String newPrefix = prefix;
        for(int i = 0; i < ZIPCODE_LENGTH - prefix.length(); i++) {
            newPrefix += DASH;
        }
        
        // create a dummy key to add to hashmap
        Deliverable newKey = new MyMail(1, newPrefix, newPrefix,EMPTY);

        // using dummy key, add the newQueue to hashmap
        this.deliveryBins.put(newKey, newQueue);
    }

}
