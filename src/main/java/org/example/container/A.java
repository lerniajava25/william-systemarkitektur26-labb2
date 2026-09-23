package org.example.container;

public class A {
    private final B dependency;

    public A(B dependency) {
        this.dependency = dependency;
        IO.println("Instance of A with dependency " + dependency.getClass().getSimpleName() + " created!");
    }
}
