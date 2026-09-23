package org.example.container;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class DIContainer {
    public <T> T getInstanceOfClass(Class<T> type) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        var ctor = type.getConstructors()[0];
        var params = ctor.getParameterTypes();
        List<Object> dependencies = new ArrayList<>();

        for(Class<?> param : params) {
            var dependency = getInstanceOfClass(param);
            dependencies.add(dependency);
        }

        var instance = ctor.newInstance(dependencies.toArray());
        return type.cast(instance);
    }
}
