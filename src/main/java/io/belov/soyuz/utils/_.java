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

    public static String s(String value, Object... params) {
        for (int i = 0; i < params.length; i++) {
            value = value.replace("{" + i + "}", params[i].toString());
        }

        return value;
    }

    public static String trim(String o) {
        if (o == null) {
            return null;
        } else {
            return o.trim();
        }
    }
}
