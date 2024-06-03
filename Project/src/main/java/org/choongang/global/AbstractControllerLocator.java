package org.choongang.global;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractControllerLocator implements ControllerLocator{

    protected Map<Menu, Controller> controllers;

    protected AbstractControllerLocator() {
        controllers = new HashMap<>();
    }
}
