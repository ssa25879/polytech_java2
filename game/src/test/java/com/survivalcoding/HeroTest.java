package com.survivalcoding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HeroTest {

    @Test
    @DisplayName("공격시 자해딜 1씩 들어옴")
    void attack() {
        // given 준비
        Hero hero = new Hero(); // 인스턴스 생성

        // when 실행
        hero.setHP(50);
        hero.attack();

        // then 검증
        assertEquals(49, hero.getHP());

        // when 실행
        hero.attack();

        // then 검증
        assertEquals(48, hero.getHP());
    }

    @Test
    void setName() {
        Hero hero = new Hero();

        assertThrows(IllegalArgumentException.class, () -> hero.setName("1"));

    }
}