package com.cse.ds;

/**
 * Author: Julian Wai San Yan 
 * Date: 5/8/19
 * File: Deliverable.java 
 */

/** 
 * This file contains the Deliverable class which is an abstract class. This 
 * means that this class can be extended from to create more objects.
 */

/**
 * This class is an abstract class that contains the abstract method to get
 * the zipcode of an object. This class also overrides the equals method and 
 * the hashcode method.
 */

public abstract class Deliverable {

    protected int id;
    protected int weight;
    protected int timestamp;
    protected String fromAddress;
    protected String toAddress;

    /**
     * Getter for id
     *
     * @param none
     * @return    the id
     */

    public int getId() { 
        return id; 
    }

    /**
     * Getter for the weight
     *
     * @param none
     * @return    the weight
     */

    public int getWeight() { 
        return weight; 
    }

    /**
     * Getter for the time stamp
     *
     * @param none
     * @return    the time stamp
     */
    
    public int getTimestamp() { 
        return timestamp; 
    }

    /**
     * Setter for the time stamp
     *
     * @param timestamp timestamp to set
     * @return          none
     */

    public void setTimestamp(int timestamp) { 
        this.timestamp = timestamp; 
    }

    /**
     * Getter for the sender's address
     *
     * @param none
     * @return    the sender's address
     */
    
    public String getFromAddress() {
        return fromAddress; 
    }

    /**
     * Getter for the receiver's address
     *
     * @param none
     * @return    the receiver's address
     */
    
    public String getToAddress() {
        return toAddress; 
    }

    /**
     * Abstract method to get the zip code
     *
     * @param none
     * @return    the zip code as a string
     */

    public abstract String getZipCode();

    /**
     * Returns the hashcode determined by the deliverable
     *
     * @param none
     * @return    none
     */

    @Override
    public int hashCode() {
    	return this.getZipCode().hashCode();

    }

    /**
     * Whether if this and obj are equivalent based on the receiver's zip 
     *
     * @param obj object to compare to 
     * @return    whether or not this and obj are equal
     */

    @Override
    public boolean equals(Object obj) {
        // if obj is null, return false
        if(obj == null) {
        	return false;
        }
        
        // if obj is an instance of Deliverable and the zip codes of the 
        // receiver are the same 
        if(obj instanceof Deliverable) {
            if(this.getZipCode().equals(((Deliverable)obj).getZipCode())) {
                return true;
            }
        }
        return false;
    }

}
