package com.survivalcoding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClericTest {
    @Test
    @DisplayName("여러 객체 생성 테스트, 입력받지 않은 값이 기본값으로 돌아가는지")
    void clericCreation() {
        // given
        final String testName = "이름";
        final int testHP = 30;
        final int testMP = 7;
        final int overflowHP = Cleric.maxHP + 1;    // 항상 maxHP보다 1 크게하여 초과시킴
        final int underflowHP = -1;
        final int overflowMP = Cleric.maxMP + 1;    // 항상 maxMP보다 1 크게하여 초과시킴
        final int underflowMP = -1;


        // when
        Cleric set1 = new Cleric(testName, testHP, testMP);
        Cleric set2 = new Cleric(testName, testHP);
        Cleric set3 = new Cleric(testName);

        // then 검증
        assertStats("set1 스탯 확인(전부 입력)", set1, testName, testHP, testMP);
        assertStats("set2 스탯 확인(이름, HP 입력)", set2, testName, testHP, Cleric.maxMP);
        assertStats("set3 스탯 확인(이름 입력)", set3, testName, Cleric.maxHP, Cleric.maxMP);

        // 생성 안되는지 검증
        assertThrows(IllegalArgumentException.class, () -> {
            Cleric noNameCase = new Cleric();
        });

        // 최대, 최소 값을 지키지 않는 경우 생성이 안되는지 검증
        assertAll("최대값, 최소값을 지키지 않았을 경우 확인",
                () -> assertThrows(IllegalArgumentException.class, () -> {
                    Cleric overflowHPCase = new Cleric(testName, overflowHP);
                }, "HP 최대값 초과 예외처리가 발생하지 않음"),
                () -> assertThrows(IllegalArgumentException.class, () -> {
                    Cleric overflowMPCase = new Cleric(testName, testHP, overflowMP);
                }, "MP 최대값 초과 예외처리가 발생하지 않음"),
                () -> assertThrows(IllegalArgumentException.class, () -> {
                    Cleric underflowHPCase = new Cleric(testName, underflowHP);
                }, "HP 음수, 0 입력 예외처리가 발생하지 않음"),
                () -> assertThrows(IllegalArgumentException.class, () -> {
                    Cleric underflowMPCase = new Cleric(testName, testHP, underflowMP);
                }, "MP 음수 입력 예외처리가 발생하지 않음")
        );
    }

    // 스탯 확인을 위한 임시 함수
    private void assertStats(String headDescription, Cleric cleric, String exceptedName, int exceptedHP, int exceptedMP) {
        assertAll(headDescription,
                () -> assertEquals(exceptedName, cleric.name, "이름 틀림"),
                () -> assertEquals(exceptedHP, cleric.hp, "HP 틀림"),
                () -> assertEquals(exceptedMP, cleric.mp, "MP 불일치")
        );
    }

    @Test
    @DisplayName("selfAid 테스트, MP 5 소모 후 HP 회복")
    void selfAid() {
        // 초기값 준비
        final int initSelfAidHP = 10;
        final int initSelfAidMP = 10;
        final int mpEdgeCase = 4;

        // given 준비
        Cleric test1 = new Cleric("testCleric1");
        test1.hp = initSelfAidHP;
        test1.mp = initSelfAidMP;

        // when 실행
        test1.selfAid();

        // then 검증
        assertEquals(initSelfAidMP - test1.selfAidMPCost, test1.mp);
        assertEquals(Cleric.maxHP, test1.hp);

        // mp가 부족할 경우 테스트
        // given 준비
        test1.mp = mpEdgeCase;
        test1.hp = initSelfAidHP;

        // when 실행
        test1.selfAid();

        // then 검증
        assertNotEquals(Cleric.maxHP, test1.hp);
        assertEquals(mpEdgeCase, test1.mp);
    }

    @Test
    @DisplayName("pray testSecond초 후 testSecond + (0 ~ 2) 만큼 MP 회복")
    void pray() {
        // 초기값 준비
        final int initPrayMP = 5;
        final int overflowInitPrayMP = 7;
        final int randTestSecond = 0;
        final int overflowTestSec = 3;

        //given 준비
        Cleric test2 = new Cleric("testCleric2");
        int tmp;    // 관측용 변수 생성

        // 초기값
        test2.mp = initPrayMP;

        // when 실행
        tmp = test2.pray(randTestSecond);

        // then 검증
        // 피드백 이후 assert 관련 함수들을 찾아서 랜덤값 작동 확인 방법 개선
        // pray(int second)는 second + (0 ~ 2) 이기 때문에, 회복량은 (현재MP ~ 현재MP + 2) 가 되어야 함.
        assertTrue(tmp >= 0 && tmp <= 2, "랜덤함수 테스트실패");
        assertTrue(test2.mp >= initPrayMP && test2.mp <= (initPrayMP + 2), "실제 마나 회복 테스트실패");

        // 초기값 9로 maxMP를 넘기는 상황을 연축
        test2.mp = overflowInitPrayMP;
        final int correctAnswer = Cleric.maxMP - test2.mp;

        // when 실행
        // 무조건 maxMP를 넘기므로 1이 출력되도록 실행
        tmp = test2.pray(overflowTestSec);

        // then 검증
        // maxMP의 값이 10이기에 로직상 tmp에는 (최대MP - 현재MP)의 값이 담겨있어야함.
        assertEquals(correctAnswer, tmp, "최대 마나 테스트실패");
    }
}