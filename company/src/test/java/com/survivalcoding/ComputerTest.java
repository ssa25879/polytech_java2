package com.survivalcoding;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {
    final String testName = "TestName";
    final String testColor = "TestColor";
    final String testMakerName = "TestMaker";
    final String changeName = "ChangeName";
    final String changeMakerName = "ChangeMakerName";
    final String changeColor = "ChangeColor";

    final int changePrice = 10000;
    final int testPrice = 20000;
    final int negativePrice = -1;

    final double changeWeight = 1.0;
    final double testWeight = 1.5;
    final double negativeWeight = -1.0;

    @Test
    @DisplayName("Computer getter 정상 작동 테스트")
    void getTest() {
        // given
        Computer testComputer = new Computer(testName, testPrice, testColor, testWeight, testMakerName);

        // when then
        assertAll("Computer getter 검증 실패",
                () -> assertEquals(testName, testComputer.getName()),
                () -> assertEquals(testPrice, testComputer.getPrice()),
                () -> assertEquals(testColor, testComputer.getColor()),
                () -> assertEquals(testWeight, testComputer.getWeight()),
                () -> assertEquals(testMakerName, testComputer.getMakerName())
        );
    }

    @Test
    @DisplayName("Computer 정상 변경되는지 확인")
    void setTest() {
        // given
        Computer testComputer = new Computer(testName, testPrice, testColor, testWeight, testMakerName);


        // when
        testComputer.setName(changeName);
        testComputer.setPrice(changePrice);
        testComputer.setColor(changeColor);
        testComputer.setWeight(changeWeight);
        testComputer.setMakerName(changeMakerName);

        // then
        assertAll("Computer 변경 값 검증 실패",
                () -> assertEquals(changeName, testComputer.getName()),
                () -> assertEquals(changePrice, testComputer.getPrice()),
                () -> assertEquals(changeColor, testComputer.getColor()),
                () -> assertEquals(changeWeight, testComputer.getWeight()),
                () -> assertEquals(changeMakerName, testComputer.getMakerName())
        );
    }

    @Test
    @DisplayName("Computer 유효성 검사")
    void computerInvalidTest() {
        // given
        // 최초 선언 시 상수 준비함

        // when then
        assertAll("Computer 유효성 검증 실패",
                () -> assertThrows(IllegalArgumentException.class,
                        () -> new Computer(null, testPrice, testColor, testWeight, testMakerName)),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> new Computer(testName, negativePrice, testColor, testWeight, testMakerName)),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> new Computer(testName, testPrice, null, testWeight, testMakerName)),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> new Computer(testName, testPrice, testColor, negativeWeight, testMakerName)),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> new Computer(testName, testPrice, testColor, testWeight, null))
        );
    }
}