/*
 * to
 * Copyright (c) 2012 Cybervision. All rights reserved.
 */
package io.belov.soyuz.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

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

}
