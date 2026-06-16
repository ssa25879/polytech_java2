package com.survivalcoding;

public class Slime {
    static final int slimeAttackPoint = 10; // 슬라임 공격력
    private final String suffix;
    private int hp;
    private int maxHP;

    public Slime(String suffix, int hp) {
        this.suffix = suffix;
        setMaxHP(hp);
        setHP(hp);
    }


    public String getSuffix() {
        return suffix;
    }

    public int getHP() {
        return hp;
    }

    public void setHP(int hp) {
        // 체력이 음수가 될 경우 0 으로, maxHP를 초과할 경우 maxHP로 보정
        this.hp = Math.clamp(hp, 0, maxHP);
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = Math.max(maxHP, 0);
        if (this.getHP() < this.maxHP) {
            this.setHP(this.maxHP);
        }
    }

    public void attack(Hero hero) {
        if (hero == null) {
            throw new IllegalArgumentException("공격하는 대상이 있어야합니다.");
        }

        System.out.println("슬라임 " + this.suffix + "이/가 공격했다");
        System.out.println("대상 " + hero.getName() + "에게 " + slimeAttackPoint + "포인트 데미지!");

        hero.setHP(hero.getHP() - slimeAttackPoint);
    }
}
