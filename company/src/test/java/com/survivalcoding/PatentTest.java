package com.survivalcoding;

import org.junit.jupiter.api.*;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class PatentTest {

    final String testName = "TestName";
    final String testAssetType = "TestAssetType";
    final String testAcquiredDate = "2026-06-22";
    final String testInventor = "TestInventor";
    final int testPatentNumber = 12345;
    final String changeName = "ChangeName";
    final String changeAssetType = "ChangeAssetType";
    final int negativePatentNumber = -1;

    @Test
    @DisplayName("Patent getter 정상 작동 테스트")
    void getTest() {
        // given
        Patent testPatent = new Patent(
                testName,
                testAssetType,
                testAcquiredDate,
                testInventor,
                testPatentNumber
        );

        // when then
        assertAll("Patent getter 검증 실패",
                () -> assertEquals(testName, testPatent.getName()),
                () -> assertEquals(testAssetType, testPatent.getAssetType()),
                () -> assertEquals(LocalDate.parse(testAcquiredDate), testPatent.getAcquiredDate()),
                () -> assertEquals(testInventor, testPatent.getInventor()),
                () -> assertEquals(testPatentNumber, testPatent.getPatentNumber())
        );
    }

    @Test
    @DisplayName("Patent의 변경 가능한 값들이 정상 변경되는지 확인")
    void setTest() {
        // given
        Patent testPatent = new Patent(
                testName,
                testAssetType,
                testAcquiredDate,
                testInventor,
                testPatentNumber
        );


        // when
        testPatent.setName(changeName);
        testPatent.setAssetType(changeAssetType);

        // then
        assertAll("Patent 변경 값 검증 실패",
                () -> assertEquals(changeName, testPatent.getName()),
                () -> assertEquals(changeAssetType, testPatent.getAssetType())
        );
    }

    @Test
    @DisplayName("Patent 유효성 검사")
    void patentInvalidTestTest() {
        // given
        // 상단에 상수 준비됨

        // when then
        assertAll("Patent 유효성 검증 실패",
                () -> assertThrows(IllegalArgumentException.class,
                        () -> new Patent(null, testAssetType, testAcquiredDate, testInventor, testPatentNumber),
                        "이름이 null값임에도 실행됨"),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> new Patent(testName, null, testAcquiredDate, testInventor, testPatentNumber),
                        "assetType이 null임에도 실행됨"),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> new Patent(testName, testAssetType, (LocalDate) null, testInventor, testPatentNumber),
                        "LocalDate으로 입력된 acquiredDate가 null임에도 실행됨"),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> new Patent(testName, testAssetType, (String) null, testInventor, testPatentNumber),
                        "String으로 입력된 acquiredDate가 null임에도 실행됨"),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> new Patent(testName, testAssetType, testAcquiredDate, null, testPatentNumber),
                        "inventor가 null값임에도 실행됨"),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> new Patent(testName, testAssetType, testAcquiredDate, testInventor, negativePatentNumber),
                        "patentNumber가 null값임에도 실행됨")
        );
    }
}