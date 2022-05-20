package parallelTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test3 {
    @Test
    public void testParallel55() throws InterruptedException {
        Thread.sleep(3000);
        Assertions.assertEquals(22, 11+11);
    }
}
