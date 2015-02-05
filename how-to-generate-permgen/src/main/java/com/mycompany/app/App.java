package com.mycompany.app;

import javassist.CannotCompileException;
import javassist.ClassPool;

import java.util.concurrent.TimeUnit;

/**
 * Steps to build and run demo application: <br />
 *
 * <li>mvn clean package appassembler:assemble
 * <li>target/appassembler/bin/app
 *
 */
public class App {
    /**
     * We should use static block for OutOfMemoryError "initialization"
     * It's very important to have it. In other case JVM won't be able to
     * throw (actually create new OutOfMemoryError) this exception because
     * there will be no free memory for this. That's why we creating it beforehand.
     * As you can see we intentionally added output to highlight that THIS error
     * was produces by us.
     */
    static {
        new OutOfMemoryError().printStackTrace();
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("=====================");
            System.out.println("Initialized/created OutOfMemoryError");
            System.out.println("=====================");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Start dynamic class creation.....\n");
        for (int i = 0; i < 1000; i++) {
            Class clazz = createClass("MyClass" + i);
            // we use this output as indicator to see the rough number of created classes
            // it's not necessary to print every single (just created) class
            if(i % 50 == 0) System.out.println(clazz);
        }
    }

    private static Class createClass(String className) throws CannotCompileException {
        ClassPool pool = ClassPool.getDefault();
        return pool.makeClass(className).toClass();
    }
}
