package com.survivalcoding;

public class Computer extends TangibleAsset {
    private String makerName;

    public Computer(String name, int price, String color, double weight, String makerName) {
        super(name, price, color, weight);
        setMakerName(makerName);
    }

    public String getMakerName() {
        return makerName;
    }

    public void setMakerName(String makerName) {
        if (makerName == null) {
            throw new IllegalArgumentException("제조사 이름은 비어있을 수 없습니다.");
        }
        this.makerName = makerName;
    }
}
