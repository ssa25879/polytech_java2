package com.survivalcoding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class WandTest {
    final String testName = "mainTestWand";
    final String changeName = "changeTestWand";
    final double testPower = Wand.maxPower;
    final Random rand = new Random();


    @Test
    @DisplayName("getName 테스트. 이름이" + testName + "으로 출력되어야함")
    void getName() {
        // given
        Wand mainTestWand = new Wand(testName, testPower);

        // when then
        assertEquals(testName, mainTestWand.getName());
    }

    @Test
    @DisplayName("setName 테스트. 이름이 " + changeName + "으로 출력되어야함")
    void setName() {
        // given
        Wand mainTestWand = new Wand(testName, testPower);
        String tooShortName = Wizard.tooShortName;

        // when
        mainTestWand.setName(changeName);

        // then
        assertEquals(changeName, mainTestWand.getName());
        assertAll("이름이 null값이거나, 3문자 이하일 경우 테스트", () -> assertThrows(IllegalArgumentException.class, () -> mainTestWand.setName(null)),
                () -> assertThrows(IllegalArgumentException.class, () -> mainTestWand.setName(tooShortName)));
    }

    @Test
    @DisplayName("getPower 테스트. 값으로 주어진 " + testPower + "가 출력되어야함")
    void getPower() {
        // given
        Wand mainTestWand = new Wand(testName, testPower);

        // when then
        assertEquals(testPower, mainTestWand.getPower());
    }

    @Test
    @DisplayName("setPower 테스트. 최댓값" + Wand.maxPower + "를 초과하거나, " + Wand.minPower + "보다 작을 경우 오류가 발생하는지 체크")
    void setPower() {
        // given
        Wand mainTestWand = new Wand(testName, testPower);
        double setRandomDoubleInRange = rand.nextDouble(Wand.minPower, Wand.maxPower);

        // when then
        assertAll("최댓값, 최솟값 초과 테스트 실패",
                () -> {
                    assertThrows(IllegalArgumentException.class, () -> mainTestWand.setPower(Wand.maxPower + 1.0));
                },
                () -> {
                    assertThrows(IllegalArgumentException.class, () -> mainTestWand.setPower(Wand.minPower - 1.0));
                }
        );

        assertDoesNotThrow(() -> mainTestWand.setPower(setRandomDoubleInRange), "정상 값 입력시 예외발생하는 오류 발생");
    }
}