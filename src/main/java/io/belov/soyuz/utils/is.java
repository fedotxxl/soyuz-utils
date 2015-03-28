package io.belov.soyuz.utils;

import org.apache.commons.validator.routines.EmailValidator;

import java.util.Collection;
import java.util.Map;

/**
 * Created by fbelov on 28.03.15.
 */
public class is {

    private static final EmailValidator mailValidator = EmailValidator.getInstance();

    public static boolean t(String check) {
        return check != null && check.length() > 0;
    }

    public static boolean t(Boolean check) {
        return check != null && check;
    }

    public static boolean t(Collection check) {
        return check != null && check.size() > 0;
    }

    public static boolean t(Object[] check) {
        return check != null && check.length > 0;
    }

    public static boolean t(Map check) {
        return check != null && check.size() > 0;
    }

    public static boolean tt(String check) {
        return check != null && check.trim().length() > 0;
    }

    public static boolean mail(String mail) {
        return tt(mail) && mailValidator.isValid(mail);
    }

}
