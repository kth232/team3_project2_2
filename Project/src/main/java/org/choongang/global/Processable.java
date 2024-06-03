package org.choongang.global;

public interface Processable<T> {
     default void process(T form) {};
}
