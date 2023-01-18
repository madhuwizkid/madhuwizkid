package com.test.address;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class AddressBookProcessorTest {
    static AddressBookProcessor addressBookProcessor;
    @BeforeClass
    public static void setup(){
        addressBookProcessor = new AddressBookProcessor("addressBook");
    }
    @Test
    public void testGetNumMales() {
        assertEquals(3, addressBookProcessor.getNumMales());
    }

    @Test
    public void testGetOldestPerson() {
        AddressBook oldestPerson = addressBookProcessor.getOldestPerson();
        assertEquals("Wes Jackson", oldestPerson.getName());
        assertEquals("Male", oldestPerson.getGender());
        assertEquals(LocalDate.of(1974, 8, 14), oldestPerson.getDob());
    }

    @Test
    public void testGetAgeDifference() {
        int ageDiff = addressBookProcessor.getAgeDifference("Bill McKnight", "Paul Robinson");
        assertEquals(7, ageDiff);
    }

    @Test(expected = RuntimeException.class)
    public void testGetAgeDifference_onePersonNotFound() {
        addressBookProcessor.getAgeDifference("Bill McKnight", "John");
    }

    @Test(expected = RuntimeException.class)
    public void testGetAgeDifference_bothPeopleNotFound() {
        addressBookProcessor.getAgeDifference("John", "Jane");
    }

    @AfterClass
    public static void tearDown(){
        AddressBookProcessor addressBookProcessor = null;
    }

}
