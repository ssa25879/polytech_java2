package com.survivalcoding;

public enum KeyType {
    PADLOCK(1024),
    BUTTON(10000),
    DIAL(30000),
    FINGER(1000000);

    private final int maxDurability;

    KeyType(int maxDurability) {
        this.maxDurability = maxDurability;
    }

    public int getMaxDurability() {
        return maxDurability;
    }

    public boolean isUnlock(int repeatCount) {
        return (repeatCount >= this.maxDurability);
    }
}
