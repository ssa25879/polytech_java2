package com.survivalcoding;

public class Wand {
    private String name;                   // 지팡이 이름
    private double power;                  // 지팡이 마력

    final int nameMaxLength = 3;           // 이름 최대 길이
    static final double minPower = 0.5;    // 마력 최소값
    static final double maxPower = 100.0;  // 마력 최댓값

    public Wand(String name, double power) {
        setName(name);
        setPower(power);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("지팡이의 이름은 null값 일 수 없습니다.");
        }
        if (name.length() < nameMaxLength) {
            throw new IllegalArgumentException("지팡이의 이름은 " + nameMaxLength + "문자 이상이어야합니다.");
        }
        this.name = name;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        if (!(power >= minPower && power <= maxPower)) {
            throw new IllegalArgumentException("지팡이의 마력은 0.5 이상, 100.0 이하여야합니다.");
        }
        this.power = power;
    }
}
