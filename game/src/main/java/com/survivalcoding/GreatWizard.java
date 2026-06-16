package com.survivalcoding;

public class GreatWizard extends Wizard {
    public static final int defaultGreatWizardMP = 150;
    public static int recoverPoint = 25;


    public GreatWizard(String name, int hp, int mp, Wand wand) {
        super(name, hp, mp, wand);
    }

    public GreatWizard(String name, int hp, int mp) {
        super(name, hp, mp);
    }

    public GreatWizard(String name, int hp) {
        super(name, hp, defaultGreatWizardMP);
    }

    public GreatWizard(String name) {
        super(name, Wizard.defaultWizardHP, defaultGreatWizardMP);
    }

    @Override
    public void heal(Hero hero) {
        if (hero == null) {
            throw new IllegalArgumentException("Hero는 null 값이 올 수 없습니다.");
        }
        if (this.getMP() >= 5) {
            hero.setHP(hero.getHP() + recoverPoint);
            System.out.println("힐을 시전했습니다. " + hero.getName() + " HP : " + hero.getHP());
            this.setMP(this.getMP() - 5);
        } else {
            System.out.println("마나가 부족합니다.");
        }
    }

    public void superHeal(Hero hero) {
        if (hero == null) {
            throw new IllegalArgumentException("Hero는 null 값이 올 수 없습니다.");
        }
        if (this.getMP() >= 50) {
            hero.setHP(hero.getMaxHP());
            System.out.println("슈퍼 힐을 시전했습니다. " + hero.getName() + " HP : " + hero.getHP());
        }
    }
}
