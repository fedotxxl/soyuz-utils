package io.belov.soyuz.utils;

import java.util.function.Supplier;

/**
 * Created by fbelov on 01.04.15.
 */
public class _ {

    public static  <T> T or(T object, Supplier<T> supplier) {
        if (object != null) {
            return object;
        } else {
            return supplier.get();
        }
    }

    public static String trim(String o) {
        if (o == null) {
            return null;
        } else {
            return o.trim();
        }
    }
}
