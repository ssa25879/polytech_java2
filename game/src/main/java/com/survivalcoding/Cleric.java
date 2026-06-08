package com.survivalcoding;

import java.util.Random;

public class Cleric {
    String name;
    final int maxHP = 50;
    int hp = maxHP;
    final int maxMP = 10;
    int mp = maxMP;


    void selfAid() {
        mp -= 5;
        hp = maxHP;
    }

    int pray(int second) {
        Random rand = new Random();
        int healMP = second;
        healMP += rand.nextInt(3);
        // 최대 MP보다 더 회복 할 수 없음
        if ((healMP + mp) > maxMP) {
            healMP = maxMP - mp;
        }
        return healMP;
    }
}
