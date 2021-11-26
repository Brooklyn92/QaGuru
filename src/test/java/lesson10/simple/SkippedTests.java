package lesson10.simple;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertFalse;

public class SkippedTests {

    @Test
    @Disabled
    void test0() {
        assertFalse(true);
    }

    @Test
    @Disabled
    void test1() {
        assertFalse(true);
    }

    @Test
    @Disabled
    void test2() {
        assertFalse(true);
    }

    @Test
    @Disabled
    void test3() {
        assertFalse(true);
    }

    @Test
    @Disabled("Some reason")
    void test4() {
        assertFalse(true);
    }


}
