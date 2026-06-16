package com.survivalcoding;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GreatWizardTest {
    final String testName = "Test";
    final int testHP = Wizard.defaultWizardHP;
    final int testMP = GreatWizard.defaultGreatWizardMP;
    final String testWandName = Wizard.defaultWandName;
    final double testWandPower = Wizard.defaultWandPower;
    final int excessiveRecoveryAmount = 10;
    final int superHealTestHP = 1;

    GreatWizard testGreatWizard;
    Hero testHero;

    @BeforeEach
    void setUp() {
        testGreatWizard = new GreatWizard(testName);
        testHero = new Hero(testName);
    }

    @Test
    @DisplayName("테스트용 GreatWizard 정상 생성 여부 확인")
    void createGreatWizardTest() {
        // Given
        Wand testWand = new Wand(testWandName, testWandPower);
        GreatWizard createTestGW = new GreatWizard(testName, testHP, testMP, testWand);

        // when then
        assertAll(
                "getter / setter 이상작동함",
                () -> assertEquals(testName, createTestGW.getName()),
                () -> assertEquals(testHP, createTestGW.getHP()),
                () -> assertEquals(testMP, createTestGW.getMP()),
                () -> assertEquals(testWand, createTestGW.getWand())
        );
    }

    @Test
    @DisplayName("heal 정상 작동 여부 확인")
    void heal() {
        // Given
        // testGreatWizard는 setUp에서 준비됨
        testHero.setHP(testHero.getMaxHP() - GreatWizard.recoverPoint);

        // when
        testGreatWizard.heal(testHero);

        // then
        assertEquals(testHero.getMaxHP(), testHero.getHP());
    }

    @Test
    @DisplayName("heal 회복량 초과시 최대 체력까지 회복되는가")
    void overHeal() {
        // Given
        // testGreatWizard는 setUp에서 준비됨
        testHero.setHP(testHero.getMaxHP() - GreatWizard.recoverPoint + excessiveRecoveryAmount);

        // when
        testGreatWizard.heal(testHero);

        // then
        assertEquals(testHero.getMaxHP(), testHero.getHP());
    }

    @Test
    @DisplayName("heal 대상이 null값일 때 예외가 발생하는가")
    void nullHeal() {
        // given
        // testGreatWizard는 setUp에서 준비됨

        // when then
        assertThrows(IllegalArgumentException.class, () -> testGreatWizard.heal(null));
    }

    @Test
    @DisplayName("superHeal로 testHero의 체력이 최대체력까지 회복되는가")
    void superHeal() {
        // given
        // testGreatWizard는 setUp에서 준비됨
        testHero.setHP(superHealTestHP);

        // when
        testGreatWizard.superHeal(testHero);

        // then
        assertEquals(testHero.getMaxHP(), testHero.getHP());
    }

    @Test
    @DisplayName("superHeal 대상이 null값일 때 예외가 발생하는가")
    void nullSuperHeal() {
        // Given
        // testGreatWizard는 setUp에서 준비됨

        // when then
        assertThrows(IllegalArgumentException.class, () -> testGreatWizard.superHeal(null));
    }
}