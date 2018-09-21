package ca.sait.jpa;

import java.util.function.Function;

import javax.persistence.EntityManager;

@FunctionalInterface
public interface JPATransactionFunction<T> extends Function<EntityManager, T> {
    default void beforeTransactionCompletion() {
    }

    default void afterTransactionCompletion() {
    }
}