package com.survivalcoding;

import java.util.Random;

public class Cleric {
    static final int maxMP = 10;
    static final int maxHP = 50;
    final int selfAidMPCost = 5;
    final int randBoundary = 3;
    final Random rand = new Random();

    private String name;
    private int hp;
    private int mp;

    Cleric(String name, int hp, int mp) {
        this.setName(name);
        this.setHP(hp);
        this.setMP(mp);
    }

    Cleric(String name, int hp) {
        this(name, hp, maxMP);
    }

    Cleric(String name) {
        this(name, maxHP, maxMP);
    }


    public int getSelfAidMPCost() {
        return selfAidMPCost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("이름은 null값 일 수 없습니다.");
        }
        this.name = name;
    }

    public int getHP() {
        return hp;
    }

    public void setHP(int hp) {
        this.hp = Math.clamp(hp, 0, maxHP);
    }

    public int getMP() {
        return mp;
    }

    public void setMP(int mp) {
        this.mp = Math.clamp(mp, 0, maxMP);
    }

    void selfAid() {
        // 5 미만일 때 실패하는 로직 구현
        if (this.getMP() < selfAidMPCost) {
            System.out.println("MP가 부족합니다.");
            return;
        }
        this.setMP(this.getMP() - selfAidMPCost);
        hp = maxHP;
    }

    int pray(int second) {
        int healMP = second;
        healMP += rand.nextInt(randBoundary);
        // 최대 MP보다 더 회복 할 수 없음
        healMP = Math.min(maxMP - mp, healMP);
//        if ((healMP + mp) > maxMP) {
//            healMP = maxMP - mp;
//        }
        mp += healMP;
        return healMP;
    }
}
