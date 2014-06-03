/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epita.mti.datemine.data.Business;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author macbookpro
 */
public class DatemineDigestTest {
    
    private final String message = "Cette string est à tester";
    
    public DatemineDigestTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of compare method, of class DatemineDigest,
     * Use encode function to encode the message and compare.
     */
    @Test
    public void testCompare() {
        System.out.println("compare");
        String str = message;
        String encodedStr = DatemineDigest.encode(message);
        Boolean result = DatemineDigest.compare(str, encodedStr);
        assertEquals(true, result);
    }

    /**
     * Test of encode method, of class DatemineDigest,
     * A hash function should product the same hash for a same string.
     */
    @Test
    public void testEncode() {
        System.out.println("encode");
        String result = DatemineDigest.encode(message);
        String result2 = DatemineDigest.encode(message);
        assertNotNull(result);
        assertEquals(result, result2);
    }
}
