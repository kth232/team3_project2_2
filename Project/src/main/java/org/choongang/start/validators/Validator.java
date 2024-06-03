package org.choongang.start.validators;

public interface Validator<T> {
    void check(T form);
}
