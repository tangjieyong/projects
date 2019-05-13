package keyon.tang.util;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: tangkeyon@gmail.com
 * @Date: 2019/5/9 16:03
 * @Version 1.0
 */
public class LogBackTest {
   @Test
    public void test1(){
        Logger logger = LoggerFactory.getLogger(LogBackTest.class);
        logger.debug("hello world");
    }
}

