package com.beimin.eveapi;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.BeforeClass;

import com.beimin.eveapi.connectors.ApiConnector;
import com.beimin.eveapi.handler.ApiError;
import com.beimin.eveapi.model.shared.NamedList;
import com.beimin.eveapi.parser.ApiAuthorization;
import com.beimin.eveapi.parser.shared.AbstractApiParser;
import com.beimin.eveapi.response.ApiListResponse;
import com.beimin.eveapi.response.ApiResponse;
import java.util.HashMap;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeTrue;

public abstract class AbstractOnlineTest {
    private final ApiAuthorization account = new ApiAuthorization(4428355, "Efnyja8S6pawB4EzefgZBFLDWGGTv0U9RZTfC6bD3vZ1pIc45FdgOUiCL6bpEssm");
    private final ApiAuthorization character = new ApiAuthorization(4428355, 1528592227L, "Efnyja8S6pawB4EzefgZBFLDWGGTv0U9RZTfC6bD3vZ1pIc45FdgOUiCL6bpEssm");
    private final ApiAuthorization corp = new ApiAuthorization(4428366, "5TDpVttAXfTtJhWvPYKZnVfwIZPj8kAIDGa3YzP3MlVRwa2pYI6KP2qXBZseSoKa");
    private final long charID = 1528592227L;
    private final String charName = "Glazeg";
    private final long corpID = 98400559;
    private final int typeID = 1230; // Veldspar
    private final Set<String> ignoreElements = new HashSet<>();
    private final Map<String, Integer> elementsMissingOK = new HashMap<>();

    private final List<Class<?>> nullCheckClasses = Arrays.asList(new Class<?>[] { Date.class, Boolean.class, boolean.class, ApiError.class });
    private final List<Class<?>> fieldChecks = Arrays.asList(new Class<?>[] { 
        String.class, Date.class, Boolean.class, boolean.class, Long.class, long.class,
        Integer.class, int.class, Double.class, double.class, Float.class, float.class});
    private final Set<String> nullOK = new HashSet<String>();
    private final Set<String> emptyOK = new HashSet<String>();
    private Map<String, Integer> fields;

    protected final void addNullOk(final String methodName) {
        nullOK.add(methodName);
    }

    protected final void addEmptyOK(final String methodName) {
        emptyOK.add(methodName);
    }

    protected final void addIgnoreElement(final String elementName) {
        ignoreElements.add(elementName);
    }

    protected final void addElementMissingOK(final Class clazz, final int count) {
        elementsMissingOK.put(clazz.getName(), count);
        if (fields != null) { //I case this method is inworked after prepareParser
            for (Map.Entry<String, Integer> entry : elementsMissingOK.entrySet()) {
                Integer before = fields.get(entry.getKey());
                if (before == null) {
                    before = 0;
                }
                fields.put(entry.getKey(), before + entry.getValue());
            }
        }
    }

    @BeforeClass
    public static void setUp() {
        AbstractApiParser.setConnector(new ApiConnector());
    }

    @Before
    public void before() {
        nullOK.clear();
        emptyOK.clear();
        ignoreElements.clear();
        addNullOk("getCachedUntil");
        addNullOk("getCurrentTime");
        addNullOk("getVersion");
        addNullOk("getError");
    }

    protected void prepareParser(AbstractApiParser<?> parser) {
        fields = parser.enableStrictCheckMode();
        addElementMissingOK(NamedList.class, 1); //NamedList is always part of rowset that have multiple attributes, but, only name is used
        for (Map.Entry<String, Integer> entry : elementsMissingOK.entrySet()) {
            fields.put(entry.getKey(), entry.getValue());
        }
        parser.setIgnoreElements(ignoreElements);
    }

    private void checkBean(final Object bean) throws Exception {
        // Test methods
        for (final Method method : bean.getClass().getMethods()) {
            if ((method.getParameterCount() == 0) && (method.getName().startsWith("get") || method.getName().startsWith("is")) && !method.getName().equals("getClass")) {
                testValue(method.getName(), method.invoke(bean), method.getReturnType());
            }
        }
        // Chekc for new fields
        final Class<?> clazz = bean.getClass();
        final int classFields = getFields(clazz); // Count fields (to ignore logical methods)
        final Integer xmlFields = fields.get(bean.getClass().getName());
        if (classFields > 0) {
            assertThat(clazz.getName() + " field count missing: ", xmlFields, notNullValue());
            assertThat(clazz.getName() + " field count is wrong: ", xmlFields, equalTo(classFields));
        }
    }

    private int getFields(final Class<?> clazz) {
        if (clazz.getName().equals(Object.class.getName())) {
            return 0;
        }
        int classFields = 0;
        for (final Field field : clazz.getDeclaredFields()) {
            final Class<?> type = field.getType();
            if (fieldChecks.contains(type) || Enum.class.isAssignableFrom(type)) {
                classFields++; // Class Field
            }
        }
        final Class<?> superclass = clazz.getSuperclass();
        if (superclass != null && !superclass.equals(ApiListResponse.class) && !superclass.equals(ApiResponse.class)) {
            classFields = classFields + getFields(superclass);
        }
        return classFields;
    }

    private void testValue(final String id, final Object value) throws Exception {
        assertThat(id + " was null: ", value, notNullValue());
        testValue(id, value, value.getClass());
    }

    private void testValue(final String id, final Object value, final Class<?> type) throws Exception {
        if (type.equals(String.class)) { // String
            // null
            if (!nullOK.contains(id)) { // null
                assertThat(id + " was null: ", value, notNullValue());
            }
            // empty
            if (!nullOK.contains(id) && !emptyOK.contains(id)) { // Empty
                final String result = (String) value;
                assertThat(id + " was empty: ", result.length(), greaterThan(0));
            }
        } else if (Double.class.isAssignableFrom(type) || double.class.isAssignableFrom(type)) { // Double
            // null
            if (!nullOK.contains(id)) { // null
                assertThat(id + " was null: ", value, notNullValue());
            }
            // empty
            if (!nullOK.contains(id) && !emptyOK.contains(id)) { // Empty
                final Double result = (Double) value;
                assertNotEquals(id + " was empty: ", 0, result, 0);
            }
        } else if (Float.class.isAssignableFrom(type) || float.class.isAssignableFrom(type)) { // Float
            // null
            if (!nullOK.contains(id)) { // null
                assertThat(id + " was null: ", value, notNullValue());
            }
            // empty
            if (!nullOK.contains(id) && !emptyOK.contains(id)) { // Empty
                final Double result = (Double) value;
                assertNotEquals(id + " was empty: ", 0, result, 0);
            }
        } else if (Long.class.isAssignableFrom(type) || long.class.isAssignableFrom(type)) { // Long
            // null
            if (!nullOK.contains(id)) { // null
                assertThat(id + " was null: ", value, notNullValue());
            }
            // empty
            if (!nullOK.contains(id) && !emptyOK.contains(id)) { // Empty
                final long result = (Long) value;
                assertNotEquals(id + " was empty: ", 0L, result);
            }
        } else if (Integer.class.isAssignableFrom(type) || int.class.isAssignableFrom(type)) { // Enum
            // null
            if (!nullOK.contains(id)) { // null
                assertThat(id + " was null: ", value, notNullValue());
            }
            // empty
            if (!nullOK.contains(id) && !emptyOK.contains(id)) { // Empty
                final int result = (Integer) value;
                assertNotEquals(id + " was empty: ", 0, result);
            }
        } else if (nullCheckClasses.contains(type)) { // Values
            // null
            if (!nullOK.contains(id)) { // null
                assertThat(id + " was null: ", value, notNullValue());
            }
        } else if (Enum.class.isAssignableFrom(type)) { // Enum
            // null
            if (!nullOK.contains(id)) { // null
                assertThat(id + " was null: ", value, notNullValue());
            }
        } else if (Collection.class.isAssignableFrom(type)) { // Collection
            // null
            if (!nullOK.contains(id)) {
                assertThat(id + " was null: ", value, notNullValue());
            }
            // empty
            if (!nullOK.contains(id) && !emptyOK.contains(id) && !TestControl.ignoreEmptyCollections()) {
                final Collection<?> result = (Collection<?>) value;
                assertThat(id + " was empty: ", result.size(), greaterThan(0));
                testValue(id + "->Collection", result.iterator().next());
            }
        } else if (Map.class.isAssignableFrom(type)) { // Map
            // null
            if (!nullOK.contains(id)) {
                assertThat(id + " was null: ", value, notNullValue());
            }
            // empty
            if (!nullOK.contains(id) && !emptyOK.contains(id) && !TestControl.ignoreEmptyCollections()) {
                final Map<?, ?> result = (Map<?, ?>) value;
                assertThat(id + " was empty: ", result.size(), greaterThan(0));
                testValue(id + "->MapKey", result.keySet().iterator().next()); // Test first kye
                testValue(id + "->MapValue", result.values().iterator().next()); // Test first value
            }
        } else { // Other Objects
            checkBean(value);
        }
    }

    protected long getCorpID() {
        return corpID;
    }

    protected long getCharacterID() {
        return charID;
    }

    protected String getCharacterName() {
        return charName;
    }

    protected int getTypeID() {
        return typeID;
    }

    protected void test(final Collection<?> collection) throws Exception {
        if (TestControl.ignoreEmptyCollections()) {
            assumeTrue(false); //Ignore empty collection
        }
        assertThat("Collection was null: ", collection, notNullValue());
        assertThat("Collection was empty: ", collection.size(), greaterThan(0));
    }

    protected void testResponse(final ApiResponse response) throws Exception {
        testResponse(response, 2);
    }

    protected void testResponse(final ApiResponse response, final int version) throws Exception {
        assertThat("ApiResponse was null: ", response, notNullValue());
        assertThat("ApiResponse.cachedUntil was null: ", response.getCachedUntil(), notNullValue());
        assertThat("ApiResponse.currentTime was null: ", response.getCurrentTime(), notNullValue());
        assertThat("ApiResponse.version was wrong: ", response.getVersion(), equalTo(version));
        assertThat("ApiResponse.error was not null: ", response.getError(), nullValue());
        checkBean(response);
    }

    protected void testFail(final String s) {
        fail(s);
    }

    protected ApiAuthorization getAccount() {
        return account;
    }

    protected ApiAuthorization getCharacter() {
        return character;
    }

    protected ApiAuthorization getCorp() {
        return corp;
    }

    protected ApiAuthorization getEve() {
        return character;
    }
}
