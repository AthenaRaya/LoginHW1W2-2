package com.example.loginhw1w2;

import android.content.Intent;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void successful() {
        assertEquals(4, 2 + 2);
        assertEquals(false, MainActivity.sucessfullUsername("apple"));//test  1
        assertEquals(false, MainActivity.sucessfullPassword("banana"));// test 1
        assertEquals(null, MainActivity.returnIntent(false, false));// test 1, wrong user & password


        assertEquals(false, MainActivity.sucessfullUsername("apple"));//test  2
        assertEquals(true, MainActivity.sucessfullPassword("baby_yoda_ftw"));//test  2
        assertEquals(null, MainActivity.returnIntent(false,true));//test 2, wrong user but correct password

        assertEquals(true, MainActivity.sucessfullUsername("din_djarin"));//test  3
        assertEquals(false, MainActivity.sucessfullPassword("banana"));//test  3
        assertEquals(null, MainActivity.returnIntent(true,false));//test  3, correct user but wrong password

        assertEquals(true, MainActivity.sucessfullUsername("din_djarin"));//test  4
        assertEquals(true, MainActivity.sucessfullPassword("baby_yoda_ftw"));//test  4
        assertNotNull(MainActivity.returnIntent(true,true));//test  4, correct user & password

    }
}