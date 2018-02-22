package pl.nbp.model;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class ConfirmStringTest {

    Confirm systemUnderTest;

    @Before
    public void setup() {
        systemUnderTest = new Confirm();
    }

//    @Test
//    public void stringIsNull(String s) {
////        assertEquals("", systemUnderTest.strings(null));
//        assertFalse(systemUnderTest.);
//    }
//TODO nie wiem jak to zrobić by te testy działały
//    @Test
//    public void stringIsEmpty() {
//        assertEquals("", systemUnderTest.strings(""));
//    }

    @Test
    @Parameters({
            "Alicja",
            "Konrad",
            "Tomasz"
    })
    public void correctString(String s) {
        assertTrue(systemUnderTest.strings(s));
    }

    @Test
    @Parameters({
            "damian",
            "4dde$",
            "OlA",
            "Mateu z",
            "" ,
            "  %"
    })
    public void wrongString(String s) {
        assertFalse(systemUnderTest.strings(s));
    }
}
