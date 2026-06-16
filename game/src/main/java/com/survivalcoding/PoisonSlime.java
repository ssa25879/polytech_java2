/*
연습문제 3

독 슬라임(PoisonSlime) 은, 슬라임 (Slime) 중에서도 특히 “독 공격" 이 되는 것
PoisonSlime 는 아래의 코드로 인스턴스화 되는 클래스임
PoisonSlime poisonSlime = new PoisonSlime(“A”);
PoisonSlime 독 공격 가능 횟수를 저장하는 poisonCount(초기값 5)를 가진다. 아무나 수정 금지
PoisonSlime attack() 메소드가 호출되면 다음 내용의 공격을 한다
우선, “보통 슬라임과 같은 공격"을 한다
poisonCount가 0이 아니면 다음을 추가로 수행한다
화면에 “추가로, 독 포자를 살포했다!” 를 표시
독 데미지는 용사의 HP / 5 이며 소수점 이하는 버린다. 독 데미지만큼 용사의 HP를 감소시키고 “~포인트 데미지"라고 표시한다
poisonCount 를 1 감소 시킨다

 */

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
