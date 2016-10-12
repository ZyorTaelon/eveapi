package com.beimin.eveapi;

public class TestControl {
    private final static boolean RUN_ALL = false;
    private final static boolean RUN_NO_DATA = false;
    private final static boolean RUN_TEST_INCOMPLETE = false;
    private final static boolean RUN_API_ERROR = false;
    private final static boolean RUN_OTHER = false;
    
    public static boolean runNoData() {
        return RUN_NO_DATA || RUN_ALL;
    }

    public static boolean runTestIncomplete() {
        return RUN_TEST_INCOMPLETE || RUN_ALL;
    }

    public static boolean runApiError() {
        return RUN_API_ERROR || RUN_ALL;
    }

    public static boolean runOther() {
        return RUN_OTHER || RUN_ALL;
    }
   
}
