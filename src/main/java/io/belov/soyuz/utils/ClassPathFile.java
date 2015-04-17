package io.belov.soyuz.utils;

import java.io.InputStream;

/**
 * Created by fbelov on 17.04.15.
 */
public class ClassPathFile {

    private static final Object o = new Object();

    //http://stackoverflow.com/questions/1464291/how-to-really-read-text-file-from-classpath-in-java
    public static InputStream asStream(String filePath) {
        return o.getClass().getResourceAsStream(filePath.startsWith("/") ? filePath : "/" + filePath);
    }

}
