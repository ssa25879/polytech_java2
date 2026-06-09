package com.survivalcoding;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Hero hero = new Hero(); // 인스턴스 생성
        hero.hp = 50;

        hero.attack();
        hero.attack();

        System.out.println(hero.hp);

        Wizard wizard = new Wizard();

    }
}