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

public class Wizard {
    static final int nameMinLength = 3;
    static final String tooShortName = "12";
    static final int maxHP = 50;
    static final int maxMP = 30;
    static final String defaultWandName = "기본지팡이";
    static final double defaultWandPower = 1.0;
    private Wand wand = new Wand(defaultWandName, defaultWandPower);

    static int basePoint = 10;  // heal 기술 기본값
    private String name;
    private int hp;
    private int mp;

    public Wizard(String name, int hp, int mp, Wand wand) {
        setName(name);
        setHP(hp);
        setMP(mp);
        setWand(wand);
    }

    public Wizard(String name, int hp, int mp) {
        this(name, hp, mp, new Wand(defaultWandName, defaultWandPower));
    }

    public Wizard(String name, int hp) {
        this(name, hp, maxMP, new Wand(defaultWandName, defaultWandPower));
    }

    public Wizard(String name) {
        this(name, maxHP, maxMP, new Wand(defaultWandName, defaultWandPower));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("마법사의 이름은 null값일 수 없습니다.");
        }
        if (name.length() < nameMinLength) {
            throw new IllegalArgumentException("마법사의 이름은 " + nameMinLength + "문자 이상이어야 합니다.");
        }
        this.name = name;
    }

    public int getHP() {
        return hp;
    }

    public void setHP(int hp) {
        this.hp = Math.max(hp, 0);
    }

    public int getMP() {
        return mp;
    }

    public void setMP(int mp) {
        if (mp < 0) {
            throw new IllegalArgumentException("마법사의 MP는 0 이상이어야합니다.");
        }
        this.mp = mp;
    }

    public Wand getWand() {
        return wand;
    }

    public void setWand(Wand wand) {
        if (wand == null) {
            throw new IllegalArgumentException("마법사는 지팡이를 가지고 있어야만합니다.");
        }
        this.wand = wand;
    }

    public void heal(Hero hero) {
        int recoverPoint = (int) (basePoint * this.wand.getPower());
        hero.setHP(hero.getHp() + recoverPoint);
    }

    public void fireball(Hero hero) {

    }
}
