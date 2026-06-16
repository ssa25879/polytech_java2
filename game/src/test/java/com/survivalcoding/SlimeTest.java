package com.survivalcoding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SlimeTest {
    final String testSuffix = "Test";
    final int testSlimeHP = 10;
    final int defaultHeroHP = 100;
    final int negativeTest = -1;

    @Test
    @DisplayName("Get 정상 작동 테스트")
    void getTest() {
        // Given
        Slime testSlime = new Slime(testSuffix, testSlimeHP);
        String getSuffixTest;
        int getHPTest;

        // When
        getHPTest = testSlime.getHP();
        getSuffixTest = testSlime.getSuffix();

        // then
        assertEquals(testSlimeHP, getHPTest);
        assertEquals(testSuffix, getSuffixTest);
    }

    @Test
    @DisplayName("setHP시 음수나 최대 체력을 넘기지 않는지")
    void setHP() {
        // Given
        Slime testSlime = new Slime(testSuffix, testSlimeHP);

        // when then
        assertAll(
                "setHP 검증 실패",
                () -> {
                    testSlime.setHP(testSlime.getMaxHP() + 1);
                    assertEquals(
                            testSlime.getMaxHP(),
                            testSlime.getHP(),
                            "최대 체력을 넘기는 HP 값이 적용됨"
                    );
                },
                () -> {
                    testSlime.setHP(negativeTest);
                    assertEquals(
                            0,
                            testSlime.getHP(),
                            "체력이 음수가 되었지만 HP 가 0으로 보정되지 않음");
                }
        );
    }

    @Test
    @DisplayName("attack 정상 작동 테스트")
    void attack() {
        // Given
        Hero testHero = new Hero(Hero.defaultHeroName, defaultHeroHP);
        Slime testSlime = new Slime(testSuffix, testSlimeHP);

        // when
        testSlime.attack(testHero);

        // then
        assertEquals(
                defaultHeroHP - Slime.slimeAttackPoint,
                testHero.getHP(),
                "슬라임 공격 로직이 정상작동 하지 않음");

    }
}