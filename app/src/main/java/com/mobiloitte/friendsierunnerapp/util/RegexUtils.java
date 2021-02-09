package com.mobiloitte.friendsierunnerapp.util;

import android.util.Patterns;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegexUtils {

    public static final String PASSWORD_REGEX = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,16}$";

    private final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public RegexUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static boolean isValidEmail(CharSequence target) {
        return target != null && Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }


    public static boolean isValidEmail(final String email) {
        if (!email.matches("^[A-Z0-9a-z\\._%+-]+@([A-Za-z0-9-]+\\.)+[A-Za-z]{2,4}$")) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean isValidMobileNumber(String number) {


        return number.matches("^(1-)?\\d{3}-\\d{3}-\\d{4}$");


//return number.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,16}$");
       // return number.matches("^\\+[0-9]{10,14}$");
    }
    public static boolean isValidMobileNumber1(String number) {

        return number.matches(("\\+[0-9]+[\\- \\.]*?" + "(\\([0-9]+\\)[\\- \\.]*)?" + "([0-9][0-9\\- \\.]+[0-9])"));
    }
    public static boolean isValidPhone(CharSequence target) {
        return target != null && Patterns.PHONE.matcher(target).matches();
    }

    public static boolean ValidPassword(String password){
        return password.matches(PASSWORD_REGEX);
    }

    public static boolean isValidMobile(String name) {
       /* String regex = "^([6-9\\+]|\\(\\d{1,3}\\))[0-9\\-\\. ]{7,13}$";
        return Pattern.matches(regex, name);
  */
        if (name.length() > 7) {
            return true;
        } else {
            return false;
        }

    }
    public static boolean isValidCreditCard(String number) {
        String regex = "^(?:(?<visa>4[0-9]{12}(?:[0-9]{3})?)|" +
                "(?<mastercard>5[1-5][0-9]{14})|" +
                "(?<discover>6(?:011|5[0-9]{2})[0-9]{12})|" +
                "(?<amex>3[47][0-9]{13})|" +
                "(?<diners>3(?:0[0-5]|[68][0-9])?[0-9]{11})|" +
                "(?<jcb>(?:2131|1800|35[0-9]{3})[0-9]{11}))$";

        return Pattern.matches(regex, number);
    }

    public static boolean isValidUserName(String name) {
        String regex = "^[a-zA-Z0-9_]*$";
        return Pattern.matches(regex, name);
    }

    public static boolean isValidAmount(String name) {
        String regex = "^([0-9]{0,2}((.)[0-9]{0,2}))$";
        return Pattern.matches(regex, name);
    }



    public static boolean isOnlyNumeric(String name) {
        String regex = "^[0-9]*$";
        return Pattern.matches(regex, name);
    }

    public static boolean isStartFromHttp(String name) {
        String regex = "^(https?|ftp|http)://.*$";
        return Pattern.matches(regex, name);
    }

    public String validateEmail(String email) {
        return validEmail(email) ? null : "Invalid email.png";
    }

    private boolean validEmail(String email) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.find();
    }

    public static boolean isValidPassword(String password) {
        return validPassword(password);
    }

    public static boolean validName(String name) {
        return name != null && name.length() > 7;
    }

    private static boolean validPassword(String password) {
        return password != null && password.length() >= 8 && password.length() <= 16;
    }

    public String validateConfirm(String password, String confirm) {
        return validConfirm(password, confirm) ? null : "Password and confirm not match";
    }

    private boolean validConfirm(String password, String confirm) {
        return confirm != null && confirm.equals(password);
    }


}
