package com.startup.viso.userservice.model.util;

public interface AttributesUpdatable<T> {
    void updateIfChanged(T oldValue, T newValue);
}
