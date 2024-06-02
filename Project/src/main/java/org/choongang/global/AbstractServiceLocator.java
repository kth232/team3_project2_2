package org.choongang.global;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractServiceLocator implements ServiceLocator{
    protected static ServiceLocator instance;

    protected Map<Menu, Service> services;


    protected AbstractServiceLocator() {
        services = new HashMap<>();
    }
}
