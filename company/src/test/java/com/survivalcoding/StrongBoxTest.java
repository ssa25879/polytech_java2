package com.survivalcoding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StrongBoxTest {
    final String testStringPut = "Test";
    StrongBox<String> testStringBox;
    int repeatCount;

    @Test
    @DisplayName("금고 생성 여부 확인")
    void put() {
        // Given
        testStringBox = new StrongBox<>();
        // When
        testStringBox.put(testStringPut);

        // then
        assertEquals(testStringPut, testStringBox.get(), "생성 실패");
    }

    @Test
    @DisplayName("열쇠 별 사용 횟수 확인")
    void get() {
        // Given
        KeyType[] keys = KeyType.values();  // enum 객체 만큼 배열 생성

        // When - then
        for (KeyType key : keys) {
            // StrongBox 내부에 usageCount를 초기화하기 위함
            testStringBox = new StrongBox<>();
            testStringBox.put(testStringPut);

            for (repeatCount = 0; repeatCount < key.getMaxDurability() - 1; repeatCount++) {
                assertNull(testStringBox.get(key), key.name() + " 키 타입의 " + repeatCount + "번째에서 Null값이 반환되지 않음");
            }
            // 각 사용횟수 도달 시 확인
            assertNotNull(testStringBox.get(key), repeatCount + 1 + " 사용 횟수에 도달했음에도 값이 반환되지 않음");
            assertEquals(repeatCount + 1, key.getMaxDurability(), "반환된 값이 실제 횟수와 다름");
        }
    }

}