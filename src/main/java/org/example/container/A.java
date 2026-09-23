package org.example.container;

import jakarta.inject.Inject;

public class A {
    private final B dependency;

    @Inject
    public A(B dependency) {
        this.dependency = dependency;
        IO.println("Instance of A with dependency " + dependency.getClass().getSimpleName() + " created!");
    }
}
