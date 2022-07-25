package parallelTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test2 {
    @Test
    public void testParallel22() throws InterruptedException {
        Thread.sleep(3000);
        Assertions.assertEquals(10, 5*2);
    }
}
