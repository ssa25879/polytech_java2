package com.survivalcoding;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    final int testPrice = 10000;
    final int negativePrice = -1;
    final String testName = "TestBook";
    final String testColor = "TestColor";
    final String testIsbn = "979-11-955205-0-4";
    final double testWeight = 1.5;
    final double zeroWeight = 0;

    @Test
    @DisplayName("Book getter 정상 작동 테스트")
    void getTest() {
        // given
        Book testBook = new Book(testName, testPrice, testColor, testWeight, testIsbn);

        // when then
        assertAll("Book getter 검증 실패",
                () -> assertEquals(testName, testBook.getName(), "이름 불러오기 실패"),
                () -> assertEquals(testPrice, testBook.getPrice(), "가격 불러오기 실패"),
                () -> assertEquals(testColor, testBook.getColor(), "색 가져오기 실패"),
                () -> assertEquals(testWeight, testBook.getWeight(), "무게 가져오기 실패"),
                () -> assertEquals(testIsbn, testBook.getIsbn(), "ISBN 가져오기 실패")
        );
    }

    @Test
    @DisplayName("Book 유효하지 않는 값을 넣을 때 예외가 발생하는지 확인")
    void createBookInvalidTest() {
        // Given
        // 상단에 final 상수로 미리 선언함

        // when then
        assertAll("Book 유효성 검증 실패",
                () -> assertThrows(IllegalArgumentException.class,
                        () -> new Book(null, testPrice, testColor, testWeight, testIsbn),
                        "이름이 null값임에도 생성됨"
                ),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> new Book(testName, negativePrice, testColor, testWeight, testIsbn),
                        "가격이 음수임에도 생성됨"
                ),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> new Book(testName, testPrice, null, testWeight, testIsbn),
                        "색이 null값임에도 생성됨"
                ),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> new Book(testName, testPrice, testColor, zeroWeight, testIsbn),
                        "무게가 0임에도 생성됨"
                ),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> new Book(testName, testPrice, testColor, testWeight, null),
                        "ISBN이 null값임에도 생성됨"
                )
        );
    }



}