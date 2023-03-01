package de.telran.logging;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.atomic.AtomicInteger;

/*
* Trace << Debug << Info << Warn << Error << Fatal
 */
//@Log4j2
@Slf4j
public class LoggingExampleWIthSlf4j {
    public static void main(String[] args) {
        try {
            loggingExample();
        } catch (Throwable e) {
            log.error("", e);
            System.exit(-1);
        }
    }

    private static void loggingExample() {
        int a = 555;
        String s = "hello";
        log.info("Some objects: int - {}, String - {}", a, s);
        log.trace("Trace log");
        log.debug("Debug log");
        log.info("Info log");
        log.warn("Warn log");
        log.error("Error log");

        new Thread(() -> log.warn("From thread")).start();

        try {
            throw new RuntimeException("AAAAAAAAAAAAAAAAAA");
        } catch (RuntimeException e) {
            log.error("Something went wrong", e);
        }

        throw new StackOverflowError();
    }

    private static void atomics() {
        AtomicInteger atomicInteger = new AtomicInteger(15);
        System.out.println(atomicInteger);
        System.out.println(atomicInteger.addAndGet(25));
    }
}
