package com.survivalcoding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClericTest {

    @Test
    @DisplayName("selfAid 테스트, MP 5 소모 후 HP 회복")
    void selfAid() {
        // given 준비
        Cleric test1 = new Cleric();
        // 초기값 준비
        test1.hp = 10;
        test1.mp = 10;

        // when 실행
        test1.selfAid();
        assertEquals(5, test1.mp);
        assertEquals(50, test1.hp);
    }

    @Test
    @DisplayName("pray N초 후 N + (0 ~ 2) 만큼 MP 회복")
    void pray() {
        //given 준비
        Cleric test2 = new Cleric();

        // 초기값
        test2.mp = 7;
        // 관측용 변수
        int tmp;

        // when 실행
        tmp = test2.pray(1);
        System.out.println(tmp);

    }
}