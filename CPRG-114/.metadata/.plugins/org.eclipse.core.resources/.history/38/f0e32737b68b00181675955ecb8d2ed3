package ca.sait.jpa;

import java.util.function.Consumer;

import javax.persistence.EntityManager;

/**
 * 
 * @author celias
 *
 */
@FunctionalInterface
public interface JPATransactionVoidFunction extends Consumer<EntityManager> {
    default void beforeTransactionCompletion() {
    }

    default void afterTransactionCompletion() {
    }
}