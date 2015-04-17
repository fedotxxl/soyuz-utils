package io.belov.soyuz.utils;

import java.io.InputStream;

/**
 * Created by fbelov on 17.04.15.
 */
public class ClassPathFile {

    //http://stackoverflow.com/questions/1464291/how-to-really-read-text-file-from-classpath-in-java
    InputStream asStream(String filePath) {
        return this.getClass().getClassLoader().getResourceAsStream(filePath);
    }

}
