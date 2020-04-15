package com.example.demo.common;

/**
 * Created by aman.ullah 4/14/2020.
 */
public class Tools {
    public static final String COMA = ",";
    public static final String COMA_AND_SPACE = ", ";
    public static final String STR_ZERO = "0";
    public static final String SINGLE_SPACE = " ";
    public static final String EMPTY_SPACE = "";
    public static final String COLON = ":";
    public static final String THREE_DOTS = "...";
    public static final String UNDERSCORE = "_";
    public static final String DASH = "-";
    public static final String LEFT_PARENTHESIS = "(";
    public static final String RIGHT_PARENTHESIS = ")";
    public static final String IS_ERROR = "isError";
    public static final String IS_APP_EXCEPTION = "isException";
    public static final String MESSAGE = "message";
    public static final String SUCCESS = "success";
    public static final String STATUS =  "status";
    public static final String CODE = "code";
    public static final String DATA = "data";
    private static final String REGEX_SYMBOL_START = "\\Q";
    private static final String REGEX_SYMBOL_END = "\\E";
    public static String gerpLocalHostDirectory = null;
    static String baseURL, defaultImagePath;
    static final String DECIMAL_VALIDATION_CHECK = "Please input valid amount.";
    public static final String SLASH = "/";
    private static final String AMOUNT_FORMAT = "৳ ##,##,##0.00";
    private static final String AMOUNT_FORMAT_WITHOUT_CURRENCY = "##,##,##0.00";
    private static final String QUANTITY_FORMAT = "##,##,##0.0000";
    private static final String HTTP = "http";
    private static final String HTTPS = "https";
    private static final String COLON_WITH_SLASH = "://";
    private static final String OPENING_WWW = "//www.";
    private static final String DOUBLE_SLASH = "//";
    private static int valLenStatic = 0;
    static String outputString = "";


    public static boolean isNumberWith4Decimals(String string) {
        if (string.equals(".")) {
            return string.matches("^\\d{0,15}(\\.\\d{1,4})?$");
        } else {
            return string.matches("^\\d{0,15}(\\.\\d{0,4})?$");
        }
    }

    public static String convertToSonkha(String number) {
        int staticLen = number.length() - 1;
        if (number != null && number != "") {
        }
        if (valLenStatic > staticLen) {
            return "";
        }
        Character character = number.charAt(valLenStatic);
        ++valLenStatic;
        return switchConverter(character) + convertToSonkha(number);
    }

    private static String switchConverter(Character character) {
        switch (character) {
            case '@':
                outputString = "@";
                break;
            case '$':
                outputString = "$";
                break;
            case '#':
                outputString = "#";
                break;
            case '/':
                outputString = "/";
                break;
            case '+':
                outputString = "+";
                break;
            case '-':
                outputString = "-";
                break;

            case '.':
                outputString = ".";
                break;

            case '0':
                outputString = "০";
                break;

            case '1':
                outputString = "১";
                break;

            case '2':
                outputString = "২";
                break;

            case '3':
                outputString = "৩";
                break;

            case '4':
                outputString = "৪";
                break;

            case '5':
                outputString = "৫";
                break;

            case '6':
                outputString = "৬";
                break;

            case '7':
                outputString = "৭";
                break;

            case '8':
                outputString = "৮";
                break;

            case '9':
                outputString = "৯";
                break;

            default:
                outputString = "";
        }
        return outputString;
    }

}
