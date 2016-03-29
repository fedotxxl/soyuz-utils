package io.belov.soyuz.utils;

import org.apache.commons.validator.routines.EmailValidator;

/**
 * Created by fbelov on 28.03.15.
 */
public class ise {

    private static final EmailValidator mailValidator = EmailValidator.getInstance();

    public static boolean mail(String mail) {
        return is.tt(mail) && mailValidator.isValid(mail);
    }

}
