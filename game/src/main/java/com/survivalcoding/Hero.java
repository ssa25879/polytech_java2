package com.survivalcoding;

public class Hero {
    static int money = 100; // static을 붙이면 공용 자원이 됨.

    String name;
    int hp;

    void attack() {
        hp -= 1;    // 자해뎀 테스트
        System.out.println("공격!");
    }
}
