package com.beimin.eveapi;

public class TestControl {
    /**
     * Run everything (overwrite other settings)
     */
    private final static boolean RUN_ALL = false;
    /**
     * Run tests that is missing data
     */
    private final static boolean RUN_NO_DATA = false;
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
     * Run tests that miss part of the data set
     */
    private final static boolean RUN_INCOMPLETE_DATASET = false;
    /**
     * Ignore collections if they are empty
     */
    private final static boolean IGNORE_EMPTY_COLLECTIONS = false;
    /**
     * Log the response to console
     */
    private final static boolean LOG_RESPONSE = false;

    public static boolean runNoData() {
        return RUN_NO_DATA || RUN_ALL;
    }

    public static boolean runTestIncomplete() {
        return RUN_TEST_INCOMPLETE || RUN_ALL;
    }

    public static boolean runApiError() {
        return RUN_API_ERROR || RUN_ALL;
    }

    public static boolean runBug() {
        return RUN_BUG || RUN_ALL;
    }

    public static boolean runIncompleteDataset() {
        return RUN_INCOMPLETE_DATASET || RUN_ALL;
    }

    public static boolean ignoreEmptyCollections() {
        return IGNORE_EMPTY_COLLECTIONS;
    }

    public static boolean logResponse() {
        return LOG_RESPONSE;
    }
}
