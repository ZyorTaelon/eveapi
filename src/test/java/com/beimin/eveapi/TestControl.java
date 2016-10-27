package com.beimin.eveapi;

public class TestControl {
    /**
     * Run everything (overwrite other settings)
     */
    private final static boolean RUN_ALL = false;
    /**
     * Run tests that have not be completed yet
     */
    private final static boolean RUN_TEST_INCOMPLETE = false;
    /**
     * Run tests with API errors
     */
    private final static boolean RUN_API_ERROR = false;
    /**
     * Run tests with bugs
     */
    private final static boolean RUN_BUG = false;
    /**
     * Fail when collections or maps are empty
     */
    private final static boolean FAIL_ON_EMPTY_COLLECTION = false;
    /**
     * Log the response to console
     */
    private final static boolean LOG_RESPONSE = false;

    public static boolean runTestIncomplete() {
        return RUN_TEST_INCOMPLETE || RUN_ALL;
    }

    public static boolean runApiError() {
        return RUN_API_ERROR || RUN_ALL;
    }

    public static boolean runBug() {
        return RUN_BUG || RUN_ALL;
    }

    public static boolean failOnEmptyCollection() {
        return FAIL_ON_EMPTY_COLLECTION;
    }

    public static boolean logResponse() {
        return LOG_RESPONSE;
    }
}
