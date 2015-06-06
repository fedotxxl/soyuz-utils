package io.belov.soyuz.utils;

import com.google.common.base.Throwables;

import java.util.concurrent.TimeUnit;

/**
 * Created by fbelov on 06.06.15.
 */
public class thread {

    public static void sleep(long millis) {
        sleep(millis, TimeUnit.MILLISECONDS);
    }

    public static void sleep(long value, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(value);
        } catch (InterruptedException e) {
            Throwables.propagate(e);
        }
    }

}
