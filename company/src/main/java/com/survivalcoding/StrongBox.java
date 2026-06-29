package com.survivalcoding;

public class StrongBox<E> {
    private E data;
    private int usageCount = 0;

    public void put(E data) {
        this.data = data;
    }

    public E get(KeyType key) {
        if (key.isUnlock(++this.usageCount)) {
            return this.data;
        } else {
            return null;
        }
    }

    public E get() {
        return this.data;
    }
}
