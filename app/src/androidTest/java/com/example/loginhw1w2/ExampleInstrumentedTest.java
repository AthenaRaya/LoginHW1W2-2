package com.example.loginhw1w2;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        assertEquals("com.example.loginhw1w2", appContext.getPackageName());
        assertEquals(false, MainActivity.sucessfullUsername("apple"));//test  1
        assertEquals(false, MainActivity.sucessfullPassword("banana"));// test 1
        assertEquals(null, MainActivity.returnIntent(false, false));// test1


       // assertEquals(false, successfulLogin(""));
    }
}
