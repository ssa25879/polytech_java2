package com.survivalcoding;

import java.util.Random;

public class Cleric {
    static final int maxMP = 10;
    static final int maxHP = 50;
    final int selfAidMPCost = 5;
    final int randBoundary = 3;
    final Random rand = new Random();

    String name;
    int hp;
    int mp;

    Cleric(String name, int hp, int mp) {
        if (hp <= 0 || hp > 50) {
            throw new IllegalArgumentException("HP는 최소 1, 최대 50이어야 합니다.");
        } else if (mp < 0 || mp > 10) {
            throw new IllegalArgumentException("MP는 최대 10이여야 합니다. 음수는 입력할 수 없습니다.");
        }
        this.name = name;
        this.hp = hp;
        this.mp = mp;
    }

    Cleric(String name, int hp) {
        this(name, hp, maxMP);
    }

    Cleric(String name) {
        this(name, maxHP, maxMP);
    }

    Cleric() {
        throw new IllegalArgumentException("스탯을 입력하지 않은 클레릭은 생성될 수 없습니다.");
    }

    void selfAid() {
        // 5 미만일 때 실패하는 로직 구현
        if (mp < selfAidMPCost) {
            System.out.println("MP가 부족합니다.");
            return;
        }
        mp -= selfAidMPCost;
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
