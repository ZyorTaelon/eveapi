package com.beimin.eveapi;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeTrue;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.BeforeClass;

import com.beimin.eveapi.connectors.ApiConnector;
import com.beimin.eveapi.connectors.LoggingConnector;
import com.beimin.eveapi.handler.ApiError;
import com.beimin.eveapi.model.shared.NamedList;
import com.beimin.eveapi.parser.ApiAuthorization;
import com.beimin.eveapi.parser.shared.AbstractApiParser;
import com.beimin.eveapi.response.ApiResponse;

public abstract class AbstractOnlineTest {
    private final ApiAuthorization account = new ApiAuthorization(4428355, "Efnyja8S6pawB4EzefgZBFLDWGGTv0U9RZTfC6bD3vZ1pIc45FdgOUiCL6bpEssm");
    private final ApiAuthorization character = new ApiAuthorization(5669026, 1528592227L, "Ud0aGh79j4ugLNmBhct4o9cHjbzFOmoMkbemN0ZSolsDfX0JXpXob4OwUU9Dw4Hu");
    private final ApiAuthorization corp = new ApiAuthorization(4428366, "5TDpVttAXfTtJhWvPYKZnVfwIZPj8kAIDGa3YzP3MlVRwa2pYI6KP2qXBZseSoKa");
    private final long charID = 1528592227L;
    private final String charName = "Glazeg";
    private final long corpID = 98400559;

    private final int typeID = 1230; // Veldspar

    private final List<Class<?>> nullCheckClasses = Arrays.asList(new Class<?>[] { Date.class, Boolean.class, boolean.class, ApiError.class });
    private final List<Class<?>> fieldChecks = Arrays.asList(new Class<?>[] { 
        String.class, Date.class, Boolean.class, boolean.class, Long.class, long.class,
        Integer.class, int.class, Double.class, double.class, Float.class, float.class});
    private final Set<String> allowNull = new HashSet<String>();
    private final Set<String> allowEmpty = new HashSet<String>();
    private final Map<String, Map<String, String>> xmlAlias = new HashMap<>();
    private final Map<String, Map<String, String>> classAlias = new HashMap<>();
    private final Set<String> ignoreXmlIdentifiers = new HashSet<>();
    private final Map<String, Set<String>> ignoreClassFields = new HashMap<>();

    private Map<String, Set<String>> fields;

    protected final void allowNull(final String methodName) {
        allowNull.add(methodName);
    }

    protected final void allowEmpty(final String methodName) {
        allowEmpty.add(methodName);
    }

    protected final void ignoreXmlField(final String xmlField) {
        ignoreXmlIdentifiers.add(xmlField.toLowerCase());
    }

    protected final void ignoreClassField(final Class<?> clazz, final String classField) {
        Set<String> set = ignoreClassFields.get(clazz.getName());
        if (set == null) {
            set = new HashSet<>();
            ignoreClassFields.put(clazz.getName(), set);
        }
        set.add(classField.toLowerCase());
    }

    protected final void setAlias(final Class<?> clazz, final String xmlIdentifier, final String fieldName) {
        Map<String, String> xmlMap = xmlAlias.get(clazz.getName());
        if (xmlMap == null) {
            xmlMap = new HashMap<>();
            xmlAlias.put(clazz.getName(), xmlMap);
        }
        xmlMap.put(xmlIdentifier.toLowerCase(), fieldName.toLowerCase());

        Map<String, String> classMap = classAlias.get(clazz.getName());
        if (classMap == null) {
            classMap = new HashMap<>();
            classAlias.put(clazz.getName(), classMap);
        }
        classMap.put(fieldName.toLowerCase(), xmlIdentifier.toLowerCase());
    }

    @BeforeClass
    public static void setUp() {
        if (TestControl.logResponse()) {
            AbstractApiParser.setConnector(new LoggingConnector(new ApiConnector()));
        } else {
            AbstractApiParser.setConnector(new ApiConnector());
        }
    }

    @Before
    public void before() {
        allowNull.clear();
        allowEmpty.clear();
        ignoreXmlIdentifiers.clear();
        ignoreClassFields.clear();
        xmlAlias.clear();
        classAlias.clear();
        allowNull("getCachedUntil");
        allowNull("getCurrentTime");
        allowNull("getVersion");
        allowNull("getError");
    }

    protected void prepareParser(AbstractApiParser<?> parser) {
        prepareParser(parser, false);
    }

    protected void prepareParser(AbstractApiParser<?> parser, boolean fullPath) {
        fields = parser.enableStrictCheckMode(fullPath);
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
        Set<String> classFields = getFields(clazz); // Count fields (to ignore logical methods)
        Set<String> xmlFields = fields.get(bean.getClass().getName());
        if (xmlFields != null) {
            //Looks for added xml fields
            Map<String, String> xmlAliasMap = xmlAlias.get(clazz.getName());
            for (String xml : xmlFields) {
                if (ignoreXmlIdentifiers.contains(xml)) {
                    continue; //Ignore XML
                }
                String testName = xml;
                if (xmlAliasMap != null) {
                    String className = xmlAliasMap.get(xml);
                    if (className != null) {
                        testName = className;
                    }
                }
                assertThat(clazz.getSimpleName()+ "." + testName + " is not included in class: ", classFields.contains(testName), equalTo(true));
            }
            //Looks for removed xml fields
            Set<String> ignoreClassFieldsSet = ignoreClassFields.get(clazz.getName());
            Map<String, String> classAliasMap = classAlias.get(clazz.getName());
            for (String classField : classFields) {
                if (ignoreClassFieldsSet != null && ignoreClassFieldsSet.contains(classField)) {
                    continue; //Ignore XML
                }
                String testName = classField;
                if (classAliasMap != null) {
                    String className = classAliasMap.get(classField);
                    if (className != null) {
                        testName = className;
                    }
                }
                assertThat(clazz.getSimpleName() + "." + testName + " is not include in the xml result: ", xmlFields.contains(testName), equalTo(true));
            }
        }
    }

    private Set<String> getFields(final Class<?> clazz) {
        Set<String> classFields = new HashSet<>();
        if (clazz.getName().equals(Object.class.getName())) {
            return classFields;
        }
        for (final Field field : clazz.getDeclaredFields()) {
            final Class<?> type = field.getType();
            if (fieldChecks.contains(type) || NamedList.class.equals(type) || Enum.class.isAssignableFrom(type) || Collection.class.isAssignableFrom(type) || Map.class.isAssignableFrom(type)) {
                classFields.add(field.getName().toLowerCase());
            }
        }
        final Class<?> superclass = clazz.getSuperclass();
        if (superclass != null && !superclass.equals(ApiResponse.class)) {
            classFields.addAll(getFields(superclass));
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
            if (!allowNull.contains(id)) { // null
                assertThat(id + " was null: ", value, notNullValue());
            }
            // empty
            if (!allowNull.contains(id) && !allowEmpty.contains(id)) { // Empty
                final String result = (String) value;
                assertThat(id + " was empty: ", result.length(), greaterThan(0));
            }
        } else if (Double.class.isAssignableFrom(type) || double.class.isAssignableFrom(type)) { // Double
            // null
            if (!allowNull.contains(id)) { // null
                assertThat(id + " was null: ", value, notNullValue());
            }
            // empty
            if (!allowNull.contains(id) && !allowEmpty.contains(id)) { // Empty
                final double result = (Double) value;
                assertThat(id + " was empty: ", result, not(equalTo(0.0)));
            }
        } else if (Float.class.isAssignableFrom(type) || float.class.isAssignableFrom(type)) { // Float
            // null
            if (!allowNull.contains(id)) { // null
                assertThat(id + " was null: ", value, notNullValue());
            }
            // empty
            if (!allowNull.contains(id) && !allowEmpty.contains(id)) { // Empty
                final float result = (Float) value;
                assertThat(id + " was empty: ", result, not(equalTo(0.0f)));
            }
        } else if (Long.class.isAssignableFrom(type) || long.class.isAssignableFrom(type)) { // Long
            // null
            if (!allowNull.contains(id)) { // null
                assertThat(id + " was null: ", value, notNullValue());
            }
            // empty
            if (!allowNull.contains(id) && !allowEmpty.contains(id)) { // Empty
                final long result = (Long) value;
                assertThat(id + " was empty: ", result, not(equalTo(0L)));
            }
        } else if (Integer.class.isAssignableFrom(type) || int.class.isAssignableFrom(type)) { // Enum
            // null
            if (!allowNull.contains(id)) { // null
                assertThat(id + " was null: ", value, notNullValue());
            }
            // empty
            if (!allowNull.contains(id) && !allowEmpty.contains(id)) { // Empty
                final int result = (Integer) value;
                assertThat(id + " was empty: ", result, not(equalTo(0)));
            }
        } else if (nullCheckClasses.contains(type)) { // Values
            // null
            if (!allowNull.contains(id)) { // null
                assertThat(id + " was null: ", value, notNullValue());
            }
        } else if (Enum.class.isAssignableFrom(type)) { // Enum
            // null
            if (!allowNull.contains(id)) { // null
                assertThat(id + " was null: ", value, notNullValue());
            }
        } else if (Collection.class.isAssignableFrom(type)) { // Collection
            // null
            if (!allowNull.contains(id)) {
                assertThat(id + " was null: ", value, notNullValue());
            }
            // empty
            final Collection<?> result = (Collection<?>) value;
            if (!allowNull.contains(id) && !allowEmpty.contains(id) && TestControl.failOnEmptyCollection()) {
                assertThat(id + " was empty: ", result.size(), greaterThan(0));
            }
            if (result != null && !result.isEmpty()) {
                testValue(id + "->Collection", result.iterator().next());
            }
        } else if (Map.class.isAssignableFrom(type)) { // Map
            // null
            if (!allowNull.contains(id)) {
                assertThat(id + " was null: ", value, notNullValue());
            }
            // empty
            final Map<?, ?> result = (Map<?, ?>) value;
            if (!allowNull.contains(id) && !allowEmpty.contains(id) && TestControl.failOnEmptyCollection()) {
                assertThat(id + " was empty: ", result.size(), greaterThan(0));
            }
            if (result != null && !result.isEmpty()) {
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
        if (!TestControl.failOnEmptyCollection()) {
            assumeTrue("Empty collections allowed: ", false); //Ignore empty collection
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
