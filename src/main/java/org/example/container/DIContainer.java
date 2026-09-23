package org.example.container;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DIContainer {
    private final Set<Class<?>> resolutionPath = new HashSet<>();

    public <T> T getInstanceOfClass(Class<T> type) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        if (!resolutionPath.add(type)) {
            throw new IllegalStateException("Circular dependency detected for type: " + type.getName());
        }

        try {
            var ctor = type.getConstructors()[0];
            var params = ctor.getParameterTypes();
            List<Object> dependencies = new ArrayList<>();

            for(Class<?> param : params) {
                var dependency = getInstanceOfClass(param);
                dependencies.add(dependency);
            }

            var instance = ctor.newInstance(dependencies.toArray());
            return type.cast(instance);
        } finally {
            resolutionPath.remove(type);
        }
    }
}
