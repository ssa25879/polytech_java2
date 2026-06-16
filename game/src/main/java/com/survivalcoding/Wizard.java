/*
연습문제 4.
필드:
    int mp (초기값 100)
메서드:
    void heal(Hero hero) : hp를 20 회복시키고 자신의 mp를 10 소모
    mp가 부족하면 "마나가 부족합니다" 출력
    힐을 성공하면 "힐을 시전했습니다. 대상 HP: XX" 출력
 */

package com.survivalcoding;

public class Wizard {
    static final int nameMinLength = 3;
    static final String tooShortName = "12";
    static final int maxHP = 50;
    static final int maxMP = 500;
    static final String defaultWandName = "기본지팡이";
    static final double defaultWandPower = 1.0;
    static public final int defaultWizardMP = 100;
    static public final int defaultWizardHP = 30;

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
        this(name, hp, defaultWizardMP, new Wand(defaultWandName, defaultWandPower));
    }

    public Wizard(String name) {
        this(name, defaultWizardHP, defaultWizardMP, new Wand(defaultWandName, defaultWandPower));
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
        if (hero == null) {
            throw new IllegalArgumentException("Hero는 null 값이 올 수 없습니다.");
        }
        if (this.getMP() >= 10) {
            int recoverPoint = (int) (basePoint * this.wand.getPower());
            hero.setHP(hero.getHP() + recoverPoint);
            System.out.println("힐을 시전했습니다. " + hero.getName() + "HP : " + hero.getHP());
            this.setMP(this.getMP() - 10);
        } else {
            System.out.println("마나가 부족합니다.");
        }
    }

    public void fireball(Hero hero) {

    }
}
