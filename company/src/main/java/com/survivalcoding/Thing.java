package com.survivalcoding;

public abstract class Thing {
    double weight;

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight <= 0.0) {
            throw new IllegalArgumentException("형태가 있다면 무게가 있어야합니다.");
        }
        this.weight = weight;
    }
}
