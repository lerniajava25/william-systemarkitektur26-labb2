package org.example.container;

import jakarta.inject.Inject;

public class B {
    private final C dependency;

    @Inject
    public B(C dependency) {
        this.dependency = dependency;
        IO.println("Instance of B with dependency " + dependency.getClass().getSimpleName() + " created!");
    }
}
