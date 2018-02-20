package pl.nbp.model;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(JUnitParamsRunner.class)
public class ConfirmLoginTest {

    Confirm systemUnderTest;

    @Before
    public void setup(){
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
    @Parameters({
            "tomektomek" ,
            "do@334c3" ,
            "Damian177",
            "Kmoino12$$$@mka" ,
            "dedsas2323fdsdwe" ,
            "Dasdqwd2"
    })
    public void loginIsCorrect(String s) {
        assertTrue(systemUnderTest.login(s));
    }

    @Test
    @Parameters({
            "4dsfsdf" ,
            "asd" ,
            "Damkie" ,
            "2" ,
            "dfgwqeqczxzxvsdgasdf" ,
            "dedsas2323fdsdwe3" ,
            "!sdasdasd34" ,
            "     344",
            "       sa",
            "?dfddf"
    })
    public void wrongLogin(String s) {
        assertFalse(systemUnderTest.login(s));
    }
}
