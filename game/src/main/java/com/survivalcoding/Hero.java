package com.survivalcoding;

import java.util.Random;

public class Hero {
    static int money = 100;
    static String defaultHeroName = "홍길동";
    static int defaultHeroHP = 100;

    private String name;
    private int hp;
    private int maxHP = 100;


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

    public int getHP() {
        return hp;
    }

    public void setHP(int hp) {
        this.hp = Math.min(hp, maxHP);
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = Math.max(maxHP, 0);
    }

    public Hero(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    public Hero(String name) {
        this(name, defaultHeroHP);
    }

    public Hero() {
        this(defaultHeroName, defaultHeroHP);
    }
    // 나는 공격하면 hp 가 1씩 빠진다

    public void attack() {
        hp -= 1;
        // sout
        System.out.println("공격했다");
    }

    public void run() {
        System.out.println("도망쳤다");
    }

    public final void slip() {
        hp -= 5;
        System.out.println("미끄러졌다!");
    }
}