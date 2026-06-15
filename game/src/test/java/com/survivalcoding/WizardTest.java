package com.survivalcoding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WizardTest {
    final String testName = "TestName";
    final int testHP = 30;
    final int testMP = 15;
    final String testWandName = "TestWand";
    final double testWandPower = Wand.maxPower;
    final int negativeHP = -1;
    final int negativeMP = -1;

    @Test
    @DisplayName("이름, HP, MP 반환 테스트, 각 값이 " + testName + ", " + testHP + ", " + testMP + "로 출력되어야함")
    void getstats() {
        // given
        Wizard testWizard = new Wizard(testName, testHP, testMP);

        // when then
        assertAll("일부 반환 실패",
                () -> assertEquals(testName, testWizard.getName()),
                () -> assertEquals(testHP, testWizard.getHP()),
                () -> assertEquals(testMP, testWizard.getMP())
        );
    }

    @Test
    @DisplayName("이름이 null값이거나 " + Wizard.nameMinLength + "보다 짧을 경우 예외 발생처리 확인")
    void setName() {
        // given
        String tooShortName = Wizard.tooShortName;

        // when then
        assertAll("예외 발생 안함",
                () -> assertThrows(IllegalArgumentException.class, () -> new Wizard(null), "이름이 null 값임에도 예외가 발생 하지 않음"),
                () -> assertThrows(IllegalArgumentException.class, () -> new Wizard(tooShortName), "이름이 " + Wizard.nameMinLength + "보다 짧음에도 예외가 발생하지 않음")
        );

    }

    @Test
    @DisplayName("HP는 음수가 될 경우 0으로 초기화 해야함")
    void setHP() {
        // given
        Wizard testWizard = new Wizard(testName);

        // when
        testWizard.setHP(negativeHP);

        // then
        assertEquals(0, testWizard.getHP());
    }

    @Test
    @DisplayName("마법사의 MP는 0 이상이여야만함")
    void setMP() {
        // given
        Wizard testWizard = new Wizard(testName);

        // when then
        assertAll("MP 유효성 검증 실패",
                () -> assertThrows(IllegalArgumentException.class, () -> testWizard.setMP(negativeMP)),
                () -> assertDoesNotThrow(() -> testWizard.setMP(0))
        );
    }

    @Test
    @DisplayName("정상 지팡이 삽입, 출력 테스트")
    void getSetWand() {
        // given
        Wand testWand = new Wand(testWandName, testWandPower);
        Wizard testWizard = new Wizard(testName);

        // when
        testWizard.setWand(testWand);

        // then
        assertEquals(testWand, testWizard.getWand());
    }

    @Test
    @DisplayName("기존에 가지고 있던 지팡이를 뺏으면 예외가 발생하는지 테스트")
    void setWand() {
        // given
        Wand testWand = new Wand(testWandName, testWandPower);
        Wizard testWizard = new Wizard(testName, testHP, testMP, testWand);

        // when then
        assertThrows(IllegalArgumentException.class, () -> testWizard.setWand(null));
    }
}