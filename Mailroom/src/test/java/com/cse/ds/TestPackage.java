package com.cse.ds;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import java.util.ArrayList;

//17 test case
@FixMethodOrder(MethodSorters.JVM)
public class TestMailroom {

    static Mailroom mailroom;


    @Before
    public void populate(){
        mailroom = new Mailroom();
    }


    @Test
    public void testRegister() {
        Deliverable package1 = new MyPackage(1,
                                    "92037, 3811 Nobel Drive, La Jolla, CA, USA",
                                    "92037, 3811 Nobel Drive, La Jolla, CA, USA",
                                    "Hello World!",1);
        mailroom.registerItem(package1);
        Assert.assertTrue(package1 == mailroom.checkEarliest());
    }

    @Test
    public void testEarliestNull() {
        Assert.assertNull(mailroom.checkEarliest("94501"));
    }

    @Test
    public void testDeliverMultiple() {
        Deliverable package1 = new MyPackage(1,
                                    "92037, 3811 Nobel Drive, La Jolla, CA, USA",
                                    "92037, 3811 Nobel Drive, La Jolla, CA, USA",
                                    "Hello World!",1);
        Deliverable package2 = new MyPackage(1,
                                    "92037, 3811 Nobel Drive, La Jolla, CA, USA",
                                    "92037, 3811 Nobel Drive, La Jolla, CA, USA",
                                    "Hello World!",1);

        Deliverable package3 = new MyPackage(1,
                                    "92037, 3811 Nobel Drive, La Jolla, CA, USA",
                                    "92037, 3811 Nobel Drive, La Jolla, CA, USA",
                                    "Hello World!",1);

        mailroom.registerItem(package1);
        mailroom.registerItem(package2);
        mailroom.registerItem(package3);
        Assert.assertTrue(package1 == mailroom.checkEarliest());
        Assert.assertTrue(package1 == mailroom.deliverEarliest());
        Assert.assertTrue(package2 == mailroom.checkEarliest());
        Assert.assertTrue(package2 == mailroom.deliverEarliest());
        Assert.assertTrue(package3 == mailroom.checkEarliest());
        Assert.assertTrue(package3 == mailroom.deliverEarliest());
    }

    @Test
    public void testDeliverMultipleZip() {
        Deliverable package1 = new MyPackage(1,
                                    "92037, 3811 Nobel Drive, La Jolla, CA, USA",
                                    "92037, 3811 Nobel Drive, La Jolla, CA, USA",
                                    "Hello World!",1);
        Deliverable package2 = new MyPackage(1,
                                    "92037, 3811 Nobel Drive, La Jolla, CA, USA",
                                    "92037, 3811 Nobel Drive, La Jolla, CA, USA",
                                    "Hello World!",1);

        Deliverable package3 = new MyPackage(1,
                                    "92037, 3811 Nobel Drive, La Jolla, CA, USA",
                                    "92037, 3811 Nobel Drive, La Jolla, CA, USA",
                                    "Hello World!",1);

        mailroom.registerItem(package1);
        mailroom.registerItem(package2);
        mailroom.registerItem(package3);
        Assert.assertTrue(package1 == mailroom.checkEarliest());
        Assert.assertTrue(package1 == mailroom.deliverEarliest());
        Assert.assertTrue(package2 == mailroom.checkEarliest());
        Assert.assertTrue(package2 == mailroom.deliverEarliest());
        Assert.assertTrue(package3 == mailroom.checkEarliest());
        Assert.assertTrue(package3 == mailroom.deliverEarliest());
    }
    @Test
    public void testDeliverMultipleZipDiff() {
        Deliverable package1 = new MyPackage(1,
                                    "92037, 3811 Nobel Drive, La Jolla, CA, USA",
                                    "92037, 3811 Nobel Drive, La Jolla, CA, USA",
                                    "Hello World!",1);
        Deliverable package2 = new MyPackage(1,
                                    "92037, 3811 Nobel Drive, La Jolla, CA, USA",
                                    "92033, 3811 Nobel Drive, La Jolla, CA, USA",
                                    "Hello World!",1);

        Deliverable package3 = new MyPackage(1,
                                    "92037, 3811 Nobel Drive, La Jolla, CA, USA",
                                    "92037, 3811 Nobel Drive, La Jolla, CA, USA",
                                    "Hello World!",1);

        mailroom.registerItem(package1);
        mailroom.registerItem(package2);
        mailroom.registerItem(package3);
        Assert.assertTrue(package1 == mailroom.checkEarliest());
        Assert.assertTrue(package1 == mailroom.deliverEarliest());
        Assert.assertTrue(package2 == mailroom.checkEarliest());
        Assert.assertTrue(package2 == mailroom.deliverEarliest());
        Assert.assertTrue(package3 == mailroom.checkEarliest());
        Assert.assertTrue(package3 == mailroom.deliverEarliest());
    }

    @Test
    public void testDeliverAll() {
        Deliverable package1 = new MyPackage(1,
                                    "92037, 3811 Nobel Drive, La Jolla, CA, USA",
                                    "92037, 3811 Nobel Drive, La Jolla, CA, USA",
                                    "Hello World!",1);
        Deliverable package2 = new MyPackage(1,
                                    "92037, 3811 Nobel Drive, La Jolla, CA, USA",
                                    "92033, 3811 Nobel Drive, La Jolla, CA, USA",
                                    "Hello World!",1);

        Deliverable package3 = new MyPackage(1,
                                    "92037, 3811 Nobel Drive, La Jolla, CA, USA",
                                    "92033, 3811 Nobel Drive, La Jolla, CA, USA",
                                    "Hello World!",1);
        ArrayList<Deliverable> test = new ArrayList<Deliverable>();
        test.add(package1);
        test.add(package2);
        test.add(package3);

        mailroom.registerItem(package1);
        mailroom.registerItem(package2);
        mailroom.registerItem(package3);
        Assert.assertEquals(test, mailroom.deliverAll());
    }

    @Test
    public void testDeliverWeightAll() {
        Deliverable package1 = new MyPackage(1,
                                    "92037, 3811 Nobel Drive, La Jolla, CA, USA",
                                    "92037, 3811 Nobel Drive, La Jolla, CA, USA",
                                    "Hello World!",1);
        Deliverable package2 = new MyPackage(1,
                                    "92037, 3811 Nobel Drive, La Jolla, CA, USA",
                                    "92033, 3811 Nobel Drive, La Jolla, CA, USA",
                                    "Hello World!",1);

        Deliverable package3 = new MyPackage(1,
                                    "92037, 3811 Nobel Drive, La Jolla, CA, USA",
                                    "92033, 3811 Nobel Drive, La Jolla, CA, USA",
                                    "Hello World!",1);
        ArrayList<Deliverable> test = new ArrayList<Deliverable>();
        test.add(package1);
        test.add(package2);
        test.add(package3);

        mailroom.registerItem(package1);
        mailroom.registerItem(package2);
        mailroom.registerItem(package3);
        Assert.assertEquals(test, mailroom.deliverByWeight(3));
    }

    @Test
    public void testDeliverWeightLess() {
        Deliverable package1 = new MyPackage(1,
                                    "92037, 3811 Nobel Drive, La Jolla, CA, USA",
                                    "92037, 3811 Nobel Drive, La Jolla, CA, USA",
                                    "Hello World!",1);
        Deliverable package2 = new MyPackage(1,
                                    "92037, 3811 Nobel Drive, La Jolla, CA, USA",
                                    "92033, 3811 Nobel Drive, La Jolla, CA, USA",
                                    "Hello World!",1);

        Deliverable package3 = new MyPackage(1,
                                    "92037, 3811 Nobel Drive, La Jolla, CA, USA",
                                    "92033, 3811 Nobel Drive, La Jolla, CA, USA",
                                    "Hello World!",1);
        ArrayList<Deliverable> test = new ArrayList<Deliverable>();
        test.add(package1);
        test.add(package2);
        test.add(package3);

        mailroom.registerItem(package1);
        mailroom.registerItem(package2);
        mailroom.registerItem(package3);
        Assert.assertEquals(test, mailroom.deliverByWeight(2));
    }

    @Test
    public void testDeliverAllZip() {
        Deliverable package1 = new MyPackage(1,
                                    "92037, 3811 Nobel Drive, La Jolla, CA, USA",
                                    "92033, 3811 Nobel Drive, La Jolla, CA, USA",
                                    "Hello World!",1);
        Deliverable package2 = new MyPackage(1,
                                    "92037, 3811 Nobel Drive, La Jolla, CA, USA",
                                    "92033, 3811 Nobel Drive, La Jolla, CA, USA",
                                    "Hello World!",1);

        Deliverable package3 = new MyPackage(1,
                                    "92037, 3811 Nobel Drive, La Jolla, CA, USA",
                                    "92033, 3811 Nobel Drive, La Jolla, CA, USA",
                                    "Hello World!",1);
        ArrayList<Deliverable> test = new ArrayList<Deliverable>();
        test.add(package1);
        test.add(package2);
        test.add(package3);

        mailroom.registerItem(package1);
        mailroom.registerItem(package2);
        mailroom.registerItem(package3);
        Assert.assertEquals(test, mailroom.deliverAll("92033"));
    }

    @Test
    public void testDeliverWeightZipAll() {
        Deliverable package1 = new MyPackage(1,
                                    "92037, 3811 Nobel Drive, La Jolla, CA, USA",
                                    "92033, 3811 Nobel Drive, La Jolla, CA, USA",
                                    "Hello World!",1);
        Deliverable package2 = new MyPackage(1,
                                    "92037, 3811 Nobel Drive, La Jolla, CA, USA",
                                    "92033, 3811 Nobel Drive, La Jolla, CA, USA",
                                    "Hello World!",1);

        Deliverable package3 = new MyPackage(1,
                                    "92037, 3811 Nobel Drive, La Jolla, CA, USA",
                                    "92033, 3811 Nobel Drive, La Jolla, CA, USA",
                                    "Hello World!",1);
        ArrayList<Deliverable> test = new ArrayList<Deliverable>();
        test.add(package1);
        test.add(package2);
        test.add(package3);

        mailroom.registerItem(package1);
        mailroom.registerItem(package2);
        mailroom.registerItem(package3);
        Assert.assertEquals1(test, mailroom.deliverByWeight(3,"92033"));
    }

    @Test
    public void testDeliverWeightZipLess() {
        Deliverable package1 = new MyPackage(1,
                                    "92037, 3811 Nobel Drive, La Jolla, CA, USA",
                                    "92033, 3811 Nobel Drive, La Jolla, CA, USA",
                                    "Hello World!",1);
        Deliverable package2 = new MyPackage(1,
                                    "92037, 3811 Nobel Drive, La Jolla, CA, USA",
                                    "92033, 3811 Nobel Drive, La Jolla, CA, USA",
                                    "Hello World!",1);

        Deliverable package3 = new MyPackage(1,
                                    "92037, 3811 Nobel Drive, La Jolla, CA, USA",
                                    "92033, 3811 Nobel Drive, La Jolla, CA, USA",
                                    "Hello World!",1);
        ArrayList<Deliverable> test = new ArrayList<Deliverable>();
        test.add(package1);
        test.add(package2);
        test.add(package3);

        mailroom.registerItem(package1);
        mailroom.registerItem(package2);
        mailroom.registerItem(package3);
        Assert.assertEquals(test, mailroom.deliverByWeight(3,"92033"));
    }
}