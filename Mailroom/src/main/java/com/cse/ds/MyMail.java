package com.cse.ds;
import java.util.*;

/**
 * Author: Julian Wai San Yan 
 * Date: 5/8/19
 * File: MyMail.java 
 */

/**
 * This file contains the MyMail class which extends from the Deliverable
 * abstract class. This means that MyMail class must either inherit or override
 * the methods in Deliverable. 
 */

/**
 * This class contains methods to create a MyMail object which has a specific
 * message. There are also methods to get the message of a MyMail object and the
 * zipcode.
 */

public class MyMail extends Deliverable {

    private String message;
    private static final int ZIPCODE_LENGTH = 5;

    /**
     * Constructor for MyMail
     *
     * @param id          id of mail
     * @param fromAddress sender's address
     * @param toAddress   receiver's address
     * @param message     message in mail
     * @return            MyMail object
     */

    public MyMail(int id, String fromAddress, String toAddress, String message) {
        this.id = id;
        this.fromAddress = fromAddress;
        this.toAddress = toAddress;
        this.message = message;
        this.weight = 1;
        this.timestamp = -1;
    }

    /**
     * Getter for the message in mail
     *
     * @param none
     * @return    message in the mail
     */

    public String getMessage() { 
        return this.message; 
    }

    /**
     * Getter for the zipcode of the mail
     *
     * @param none
     * @return    zipcode of the mail
     */

    @Override
    public String getZipCode() {
        String zipCode = this.getToAddress().substring
            (this.getToAddress().length() - ZIPCODE_LENGTH);
    	return zipCode;
    }

}
