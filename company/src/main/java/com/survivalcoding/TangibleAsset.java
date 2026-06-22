package com.survivalcoding;

public abstract class TangibleAsset extends Asset implements Thing{
    private int price;
    private String color;
    private double weight;

    public TangibleAsset(String name, int price, String color, double weight) {
        super(name);
        setPrice(price);
        setColor(color);
        setWeight(weight);
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if (price < 0) {
            throw new IllegalArgumentException("가치는 0이거나 그보다 낮을 수 없습니다.");
        }
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (color == null) {
            throw new IllegalArgumentException("색이 없는 유형자산은 존재할 수 없습니다.");
        }
        this.color = color;
    }

    @Override
    public void setWeight(double weight) {
        if (weight <= 0) {
            throw new IllegalArgumentException("실체가 있는 물건은 무게가 0보다 커야합니다.");
        }
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}