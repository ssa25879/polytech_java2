package com.survivalcoding;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PoisonSlimeTest {
    final String testSuffix = "Test";
    final int testSlimeHP = 10;
    final int defaultHeroHP = 100;

    Hero testHero;

    @BeforeEach
    void setUp() {
        testHero = new Hero(Hero.defaultHeroName, defaultHeroHP);
    }

    @Test
    @DisplayName("PoisonSlime 공격기능 테스트")
    void attackDamageTest() {
        // Given
        // 슬라임의 공격력은 10, PoisonSlime 특성으로 현재 체력의 1/5 만큼 추가 감소해야함
        // 즉 testHero의 체력은 (기존 체력 - 10) * 4 / 5 가 되어야 하기에 Given에서 answerTestHeroHP를 준비
        int answerTestHeroHP = (testHero.getHP() - 10) * 4 / 5;
        PoisonSlime testPoisonSlime = new PoisonSlime(testSuffix, testSlimeHP);

        // when
        testPoisonSlime.attack(testHero);

        // then
        assertEquals(answerTestHeroHP, testHero.getHP(), "독 데미지를 정상적으로 입히지 않음");
    }

    @Test
    @DisplayName("PoisonSlime의 독 공격 횟수가 모두 소진된 후 확인")
    void poisonCountTest() {
        // Given
        int answerTestHeroHP = (testHero.getHP() - 10) * 4 / 5;
        PoisonSlime testPoisonSlime = new PoisonSlime(testSuffix, testSlimeHP);
        int repeat = testPoisonSlime.getPoisonCount();

        // when then
        // testHero가 중간에 죽으면 안되므로 체력을 회차별로 defaultHeroHP 로 초기화
        for (int i = 0; i < repeat; i++) {
            testHero.setHP(defaultHeroHP);
            testPoisonSlime.attack(testHero);
            assertEquals(answerTestHeroHP, testHero.getHP(), "데미지 계산에서 오류가 발생");
        }

        testHero.setHP(defaultHeroHP);
        testPoisonSlime.attack(testHero);

        assertEquals(
                defaultHeroHP - PoisonSlime.slimeAttackPoint,
                testHero.getHP(),
                "poisonCount를 전부 소모했지만 독데미지를 입힘"
        );
    }
}