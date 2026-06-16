/*
연습문제 1.
Wand 클래스와 Wizard 클래스의 각 setter 메소드에 대해, 아래의 4가지 규칙에 따라 인수의 타당성 검사를 추가하시오.
부정한 값이 설정 될 경우에는 “throw new IllegalArgumentException(“메세지");” 를 작성하여 프로그램을 중단 시킵니다.
마법사나 지팡이의 이름은 null 일 수 없고, 반드시 3문자 이상이어야 한다
지팡이의 마력은 0.5 이상 100.0 이하여야 한다.
마법사의 지팡이는 null 일 수 없다.
마법사의 MP는 0 이상이어야 한다.
HP가 음수가 되는 상황에서는 대신 0을 설정 되도록 한다.
 */

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
