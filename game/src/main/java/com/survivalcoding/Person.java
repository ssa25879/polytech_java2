package com.survivalcoding;

import java.time.LocalDate;

public class Person {
    public static int defaultYear = LocalDate.now().getYear();

    private String name;
    private int birthYear;

    public Person(String name, int birthYear) {
        setName(name);
        setBirthYear(birthYear);
    }

    public Person(String name) {
        this(name, defaultYear);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("이름은 null값일 수 없습니다.");
        }
        this.name = name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    private void setBirthYear(int year) {
        this.birthYear = Math.max(year, 0); // 음수 제외
    }

    public int getAge() {
        return LocalDate.now().getYear() - birthYear;
    }

}
