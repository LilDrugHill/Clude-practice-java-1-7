package models;

import annotations.Component;

public class ComponentScanner {
    static void describe(Object o) {
        Class<?> c = o.getClass();
        if (c.isAnnotationPresent(Component.class)) {
            System.out.println(c.getAnnotation(Component.class).name());
        } else  {
            System.out.println("Component annotation not found in the class instance");
        }
    }
}
