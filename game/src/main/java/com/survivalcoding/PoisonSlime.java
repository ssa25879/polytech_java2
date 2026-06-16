package com.survivalcoding;

public class PoisonSlime extends Slime {
    private int poisonCount = 5;

    public PoisonSlime(String suffix, int hp) {
        super(suffix, hp);
    }

    @Override
    public void attack(Hero hero) {
        super.attack(hero);
        if (poisonCount > 0) {
            System.out.println("포이즌슬라임" + this.getSuffix() + "의 능력! 추가로, 독 포자를 살포했다!");
            System.out.println("대상 " + hero.getName() + "에게 " + hero.getHP() / 5 + "포인트 독 데미지!");
            hero.setHP(hero.getHP() * 4 / 5);
            poisonCount -= 1;
        } else {
            System.out.println("포이즌슬라임" + this.getSuffix() + "은 독을 모두 소모했다.");
        }
    }

    public int getPoisonCount() {
        return poisonCount;
    }

}
