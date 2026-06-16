package com.survivalcoding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest {
    final String testName = "홍길동";
    final int testYear = 1980;

    @Test
    @DisplayName("이름, 태어난 해 get 가능 여부 확인")
    void getStats() {
        // given
        Person testPerson = new Person(testName, testYear);

        // when then
        assertAll("유효성 검사 실패",
                () -> assertEquals(testName, testPerson.getName()),
                () -> assertEquals(testYear, testPerson.getBirthYear())
        );
    }

    @Test
    @DisplayName("나이가 정확히 출력되는지 확인")
    void getAge() {
        // given
        Person testPerson = new Person(testName, testYear);
        final int currentYear = LocalDate.now().getYear();
        final int answerAge = currentYear - testPerson.getBirthYear();

        // when then
        assertEquals(answerAge, testPerson.getAge());
    }
}