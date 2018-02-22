package pl.nbp.model;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(JUnitParamsRunner.class)
public class ConfirmPasswordTest {

    Confirm systemUnderTest;

    @Before
    public void setup() {
        systemUnderTest = new Confirm();
    }

//    @Test
//    public void stringIsNull() {
//        assertEquals(null, systemUnderTest.strings(null));
//    }
//TODO nie wiem jak to zrobić by te testy działały
//    @Test
//    public void stringIsEmpty() {
//        assertEquals("", systemUnderTest.strings(""));
//    }

    @Test
    @Parameters ({
            "dEe231czxasd123" ,
            "!23123aEdaz" ,
            "###!1@#DADA@",
            "321sdD3",
            "EEECCC2"
    })
    public void correctSize(String s) {
        assertTrue(systemUnderTest.password(s));
    }

    @Test
    @Parameters ({
            "re2" ,
            "DDDe21" ,
            "dddererx2" ,
            "DERAWEEAX" ,
            "232134234" ,
            "ddererezWEQWEQ232112" ,
            "fer  er    "
    })
    public void wrongPassword(String s) {
        assertFalse(systemUnderTest.password(s));
    }
}
