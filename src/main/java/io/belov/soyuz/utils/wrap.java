package io.belov.soyuz.utils;

import com.google.common.base.Throwables;
import io.belov.soyuz.base.Throwing;

import java.util.function.Consumer;

/**
 * Created by fbelov on 09.06.15.
 */
public class wrap {

    public static <T> Consumer<T> rethrow(Throwing.Consumer<T> consumer) {
        return new Consumer<T>() {
            @Override
            public void accept(T val) {
                try {
                    consumer.accept(val);
                } catch (Throwable t) {
                    throw Throwables.propagate(t);
                }
            }
        };
    }

}
