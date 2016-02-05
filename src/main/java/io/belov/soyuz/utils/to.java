/*
 * to
 * Copyright (c) 2012 Cybervision. All rights reserved.
 */
package io.belov.soyuz.utils;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class to {

    private static final Logger log = LoggerFactory.getLogger(to.class);

    public static Integer integer(Object val, Integer defaultValue) {
        return integer(val, defaultValue, true);
    }

    public static Integer integer(Object val, Integer defaultValue, boolean silent) {
        if (val != null) {
            try {
                return doIntConvert(val);
            } catch (Exception e) {
                if (!silent) log.warn("Cannot convert " + val + " to int", e);
            }
        }

        return defaultValue;
    }

    public static Integer integer(Object val) {
        if (val == null) {
            return null;
        } else if (val instanceof Integer) {
            return (Integer) val;
        } else {
            return integer(val.toString(), null);
        }
    }

    public static Integer integer(String val) {
        return integer(val, null);
    }

    public static Long l(Object val, Long defaultValue) {
        return l(val, defaultValue, true);
    }

    public static Long l(Object val, Long defaultValue, boolean silent) {
        if (val != null) {
            try {
                return doLongConvert(val);
            } catch (Exception e) {
                if (!silent) log.warn("Cannot convert " + val + " to long", e);
            }
        }

        return defaultValue;
    }

    public static Long l(Object val) {
        if (val == null) {
            return null;
        } else if (val instanceof Long) {
            return (Long) val;
        } else {
            return l(val.toString(), null);
        }
    }

    public static Long l(String val) {
        return l(val, null);
    }

    public static Boolean b(String val) {
        return b(val, null);
    }

    public static Boolean b(String val, Boolean defaultValue) {
        return b(val, defaultValue, true);
    }

    public static Boolean b(Object val, Boolean defaultValue, boolean silent) {
        if (val != null) {
            try {
                return doBooleanConvert(val);
            } catch (Exception e) {
                if (!silent) log.warn("Cannot convert " + val + " to boolean", e);
            }
        }

        return defaultValue;
    }

    public static URI uri(String url) {
        try {
            return new URI(url);
        } catch (URISyntaxException e) {
            return null;
        }
    }

    public static Object[] arr(Object... objects) {
        return objects;
    }

    public static String s(String s, Object... params) {
        return s; //todo
    }

    public static Map map(Object key, Object value) {
        Map a = new HashMap();
        a.put(key, value);
        return a;
    }

    public static Map map(Object... keyValues) {
        if (keyValues.length % 2 != 0) {
            throw new IllegalStateException();
        }

        Map a = new HashMap();

        for (int i = 0; i < keyValues.length; i = i + 2) {
            a.put(keyValues[i], keyValues[i + 1]);
        }

        return a;
    }

    public static <T> List<T> list(T value) {
        List<T> answer = new ArrayList<>();
        answer.add(value);
        return answer;
    }

    public static <T> List<T> list(Iterator<T> iterator) {
        return Lists.newArrayList(iterator);
    }

    public static <T> List<T> list(T... value) {
        List<T> answer = new ArrayList<>();
        Collections.addAll(answer, value);
        return answer;
    }

    public static <T> Set<T> set(T value) {
        Set<T> answer = new HashSet<>();
        answer.add(value);
        return answer;
    }

    public static <T> Set<T> set(T... value) {
        Set<T> answer = new HashSet<>();
        Collections.addAll(answer, value);
        return answer;
    }

    public static <T> SortedSet<T> sortedSet(T value) {
        SortedSet<T> answer = new TreeSet<>();
        answer.add(value);
        return answer;
    }

    public static <T> SortedSet<T> sortedSet(T... value) {
        SortedSet<T> answer = new TreeSet<>();
        Collections.addAll(answer, value);
        return answer;
    }

    public static Date date(LocalDateTime localDateTime) {
        //http://blog.progs.be/542/date-to-java-time
        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }

    public static <T> Stream<T> stream(T[] array) {
        return Arrays.stream(array);
    }

    public static IntStream stream(int[] array) {
        return Arrays.stream(array);
    }

    public static LongStream stream(long[] array) {
        return Arrays.stream(array);
    }

    public static DoubleStream stream(double[] array) {
        return Arrays.stream(array);
    }

    private static Integer doIntConvert(BigDecimal val) {
        return val.intValue();
    }

    private static Integer doIntConvert(Long val) {
        return val.intValue();
    }

    private static Integer doIntConvert(Integer val) {
        return val;
    }

    private static Integer doIntConvert(Object val) {
        return Integer.parseInt(val.toString());
    }

    private static Long doLongConvert(BigDecimal val) {
        return val.longValue();
    }

    private static Long doLongConvert(Long val) {
        return val;
    }

    private static Long doLongConvert(Integer val) {
        return val.longValue();
    }

    private static Long doLongConvert(Object val) {
        return Long.parseLong(val.toString());
    }

    private static Boolean doBooleanConvert(String val) {
        return Boolean.valueOf(val);
    }

    private static Boolean doBooleanConvert(Boolean val) {
        return val;
    }

    private static Boolean doBooleanConvert(Object val) {
        return Boolean.valueOf(val.toString());
    }

}
