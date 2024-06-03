package org.choongang.global;

import java.util.List;

public interface Retrivable<T, R>{
    default List<R> getList(T search) { return null; };
    default List<R> getList() { return null; };
    default R get(T search) { return null; };
    default R get() { return null; };

}
