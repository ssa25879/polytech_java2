package com.survivalcoding;

public class Hero {
    String name;
    int hp;

    void attack() {
        hp -= 1;    // 자해뎀 테스트
        System.out.println("공격!");
    }
}
