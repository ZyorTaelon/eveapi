package com.beimin.eveapi;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;

import com.beimin.eveapi.connectors.ApiConnector;

public abstract class AbstractOnlineTest {
    private final List<Class<?>> nullCheckClasses = Arrays.asList(new Class<?>[] { Date.class, Integer.class, Long.class, Double.class, int.class, long.class, double.class });

    @BeforeClass
    public static void setUp() {
        EveApi.setConnector(new ApiConnector());
    }

    protected void checkBean(final Object bean) {
        final List<String> emptyStringMethods = getEmptyStringMethods();
        try {
            for (final Method method : bean.getClass().getMethods()) {
                if (method.getName().startsWith("get") && !method.getName().equals("getClass")) {
                    final Class<?> returnType = method.getReturnType();
                    if (nullCheckClasses.contains(returnType)) {
                        assertThat(method.invoke(bean), notNullValue());
                    } else if (returnType.equals(String.class)) {
                        final String result = (String) method.invoke(bean);
                        assertThat(result, notNullValue());
                        if ((emptyStringMethods != null) && !emptyStringMethods.contains(method.getName())) {
                            assertThat(result.length(), greaterThan(0));
                        }
                    } else if (returnType.equals(List.class)) {
                        @SuppressWarnings("unchecked")
                        final List<Object> result = (List<Object>) method.invoke(bean);
                        assertThat(result, notNullValue());
                        assertThat(result.size(), greaterThan(0));
                        checkBean(result.get(0));
                    } else {
                        checkBean(method.invoke(bean));
                    }
                }
            }
        } catch (final Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    protected abstract List<String> getEmptyStringMethods();
}
