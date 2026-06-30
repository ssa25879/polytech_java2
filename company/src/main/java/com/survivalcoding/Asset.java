package com.survivalcoding;

import java.util.Objects;

public abstract class Asset {
    private String name;

    public Asset(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("이름은 비어있을 수 없습니다.");
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return "Asset{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Asset asset)) return false;
        return Objects.equals(name, asset.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
