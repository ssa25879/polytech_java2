package com.survivalcoding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordTest {
    final String testString = "testString";
    final String changeString = "changeString";
    final String chkVowel = "abcde fghijklmno pqrstuvwxyz ABCDE FGHIJKLM NOPQRS TUVWXYZ";


    @Test
    @DisplayName("Getter Setter 검증")
    void getSetLetters() {
        // Given
        Word testWord = new Word(testString);

        // when - then
        assertEquals(testString, testWord.getLetters());

        testWord.setLetters(changeString);
        assertEquals(changeString, testWord.getLetters());
    }

    @Test
    @DisplayName("모음 검색 테스트 공백 포함")
    void isVowel() {
        // Given
        boolean chk = false;
        char c;
        Word chkWord = new Word(chkVowel);

        // when - then
        for (int i = 0; i < chkWord.getLetters().length(); i++) {
            c = chkWord.getLetters().charAt(i);
            chk = c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                    c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
            assertSame(chk, chkWord.isVowel(i), i + 1 + "번째 글자에서 판정 오류 발생");
        }

    }

    @Test
    @DisplayName("자음 검색 테스트 공백 포함")
    void isConsonant() {
        // Given
        boolean chk = false;
        char c;
        Word chkWord = new Word(chkVowel);

        // when - then
        for (int i = 0; i < chkWord.getLetters().length(); i++) {
            c = chkWord.getLetters().charAt(i);
            chk = !(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                    c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') && c != ' ' && c != '\t';
            assertSame(chk, chkWord.isConsonant(i), i + 1 + "번째 글자에서 판정 오류 발생");
        }
    }

    @Test
    @DisplayName("clone 테스트")
    void cloneTest() {
        // Given
        Word testWord = new Word(testString);

        // when
        Word clone = testWord.clone();

        // when - then
        assertNotSame(testWord, clone);
    }
}