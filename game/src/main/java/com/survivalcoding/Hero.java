package com.survivalcoding;

import java.util.Random;

public class Hero {
    static int money = 100;

    private String name;
    private int hp;

    static void setRandomMoney() {
        money = new Random().nextInt(1000);

        Hero hero = new Hero();
        hero.name = "홍길동";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("이름은 빈 값일 수 없습니다.");
        }
        if (name.length() <= 1) {
            throw new IllegalArgumentException("이름은 2글자 이상이어야 합니다.");
        }
        if (name.length() >= 9) {
            throw new IllegalArgumentException("이름은 8글자 이하이어야 합니다.");
        }
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHP(int hp) {
        this.hp = hp;
    }

    Hero() {
        this.name = "홍길동";
        hp = 100;
    }

    Hero(String name) {
        this.name = name;
        hp = 100;
    }

    // 나는 공격하면 hp 가 1씩 빠진다
    void attack() {
        hp -= 1;
        // sout
        System.out.println("공격했다");
    }

}