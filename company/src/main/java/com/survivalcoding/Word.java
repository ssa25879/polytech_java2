package com.survivalcoding;

import java.util.Objects;

public class Word implements Cloneable {
    private String letters;

    public Word(String letters) {
        this.setLetters(letters);
    }

    public String getLetters() {
        return letters;
    }

    public void setLetters(String letters) {
        if (letters == null || letters.isBlank()) {
            throw new IllegalArgumentException("letters는 비워두거나 null값 일 수 없습니다.");
        }
        this.letters = letters;
    }

    public boolean isVowel(int i) {
        // " ", "\t" 등을 감지하기 위함
        if (letters.substring(i, i + 1).isBlank() || !letters.substring(i, i + 1).matches("[a-zA-Z]")) {
            return false;
        }
//        return letters.substring(i, i + 1).equals("a")
//                || letters.substring(i, i + 1).equals("e")
//                || letters.substring(i, i + 1).equals("i")
//                || letters.substring(i, i + 1).equals("o")
//                || letters.substring(i, i + 1).equals("u");

//        charAt() 으로도 검증 가능
//        return letters.charAt(i) == 'a'
//                || letters.charAt(i) == 'e'
//                || letters.charAt(i) == 'i'
//                || letters.charAt(i) == 'o'
//                || letters.charAt(i) == 'u';

        boolean result = false;

        for (Vowels a : Vowels.values()) {
            result = letters.charAt(i) == a.toString().charAt(0);
            if (result) break;
        }

        return result;
    }

    public boolean isConsonant(int i) {
        // " ", "\t" 등을 감지하기 위함
        if (letters.substring(i, i + 1).isBlank() || !letters.substring(i, i + 1).matches("[a-zA-Z]")) {
            return false;
        }
        return !isVowel(i);
    }

    @Override
    public String toString() {
        return "Word{" +
                "letters='" + letters + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return 31 * letters.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Word word)) return false;
        return Objects.equals(letters, word.getLetters());
    }

    @Override
    public Word clone() {
        return new Word(this.letters);
    }
}
