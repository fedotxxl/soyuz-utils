package io.belov.soyuz.base;

/**
 * Created by fbelov on 09.06.15.
 */
public interface Throwing {
    /** Variations on the standard functional interfaces which throw a specific subclass of Throwable. */
    public interface Specific {
        @FunctionalInterface
        public interface Runnable<E extends Throwable> {
            void run() throws E;
        }

        @FunctionalInterface
        public interface Supplier<T, E extends Throwable> {
            T get() throws E;
        }

        @FunctionalInterface
        public interface Consumer<T, E extends Throwable> {
            void accept(T t) throws E;
        }

        @FunctionalInterface
        public interface Function<T, R, E extends Throwable> {
            R apply(T t) throws E;
        }

        @FunctionalInterface
        public interface Predicate<T, E extends Throwable> {
            boolean test(T t) throws E;
        }
    }

    @FunctionalInterface
    public interface Runnable extends Specific.Runnable<Throwable> {}

    @FunctionalInterface
    public interface Supplier<T> extends Specific.Supplier<T, Throwable> {}

    @FunctionalInterface
    public interface Consumer<T> extends Specific.Consumer<T, Throwable> {}

    @FunctionalInterface
    public interface Function<T, R> extends Specific.Function<T, R, Throwable> {}

    @FunctionalInterface
    public interface Predicate<T> extends Specific.Predicate<T, Throwable> {}
}
