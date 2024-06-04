package org.choongang.start.validators;

/**
 * 필수 항목 체크
 *
 */
public interface RequiredValidator {
    default void checkRequired(String str, RuntimeException e){
        if(str == null || str.isBlank()){
            throw e;
        }
    }
}
