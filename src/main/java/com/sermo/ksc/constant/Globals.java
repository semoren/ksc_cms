package com.sermo.ksc.constant;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sermo
 * @version 2016/12/13.
 */
public class Globals {

    /**
     * 登陆 session key
     */
    public static String USER_SESSION = "USER_SESSION";

    public static List<String> TIME_LIST = new ArrayList<>(25);
    static {
        for (int i=0; i<=24; i++) {
            TIME_LIST.add("" + i);
        }
    }
}
