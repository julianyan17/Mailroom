package com.cse.ds;
import java.util.*;

/**
 * Author: Julian Wai San Yan 
 * Date: 5/8/19
 * File: MyPackage.java 
 */

/**
 * This file contains the MyPackage class which extends from the Deliverable
 * abstract class. This means that MyPackage class must either inherit or 
 * override the methods in Deliverable. 
 */

/**
 * This class contains methods to create a MyPackage object which has a specific
 * message. There are also methods to get the content of a MyPackage object and
 * the zipcode. MyPackage objects also have specific weight.
 */

public class MyPackage<E> extends Deliverable {

    private E content;
    private static final int ZIPCODE_LENGTH = 5;
    /**
     * Constructor for MyPackage
     *
     * @param id          id of mail
     * @param fromAddress sender's address
     * @param toAddress   receiver's address
     * @param content     content in package
     * @param weight      weight of package
     * @return            MyMail object
     */

    public MyPackage(int id, String fromAddress, String toAddress,
                 E content, int weight) {
        this.id = id;
        this.fromAddress = fromAddress;
        this.toAddress = toAddress;
        this.content = content;
        this.weight = weight;
        this.timestamp = -1;
    }

    /**
     * Getter for the content of the package
     *
     * @param none
     * @return    content of the package
     */
  
    public E getContent() { return this.content; }

    /**
     * Getter for the zipcode of the mail
     *
     * @param none
     * @return    zipcode of the mail
     */
  
    @Override
    public String getZipCode() {
        String zipCode = this.getToAddress().substring(0,ZIPCODE_LENGTH);
	    return zipCode;

  }

}
