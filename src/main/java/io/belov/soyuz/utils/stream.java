package io.belov.soyuz.utils;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * Created by fbelov on 28.06.15.
 */
public class stream {

    public static <R> R firstOrNull(Stream<R> stream) {
        return stream.filter(Objects::nonNull).findFirst().orElse(null);
    }

}
