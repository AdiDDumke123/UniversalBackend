package com.api.wrapper;

public class RestWrapper<T> {

    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public RestWrapper(final T value){
        this.value = value;
    }
}
