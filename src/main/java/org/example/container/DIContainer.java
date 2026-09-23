package org.example.container;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class DIContainer {
    private final Map<Class<?>, Class<?>> bindings = new HashMap<>();
    private final Set<Class<?>> resolutionPath = new HashSet<>();

    public <T> void registerBinding(Class<T> interfaceType, Class<? extends T> implementationType) {
        bindings.put(interfaceType, implementationType);
    }

    public <T> T getInstanceOfClass(Class<T> type) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        if (!resolutionPath.add(type)) {
            throw new IllegalStateException("Circular dependency detected for type: " + type.getName());
        }

        try {
            Class<?> targetClass = bindings.getOrDefault(type, type);
            if(targetClass.isInterface()) {
                throw new IllegalArgumentException("Can't instantiate interface with no registered implementation: " + targetClass.getName());
            }

            var ctor = targetClass.getConstructors()[0];
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
