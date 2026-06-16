package com.survivalcoding;

public class SuperHero extends Hero {
    private boolean isFlying;

    public SuperHero(String name, int hp) {
        super(name, hp);
    }

    public SuperHero(String name) {
        super(name);
    }

    public SuperHero() {
        super();
    }

    public boolean isFlying() {
        return isFlying;
    }

    public void setFlying(boolean flying) {
        isFlying = flying;
    }

    @Override
    public void run() {
        System.out.println("매우 빠르게 달렸다.");
    }

    @Override
    public void attack() {
        super.attack();
    }
}
