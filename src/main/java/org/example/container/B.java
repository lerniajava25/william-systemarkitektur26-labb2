package org.example.container;

public class B {
    private final C dependency;

    public B(C dependency) {
        this.dependency = dependency;
        IO.println("Instance of B with dependency " + dependency.getClass().getSimpleName() + " created!");
    }
}
