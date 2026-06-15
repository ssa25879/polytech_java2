/*
연습문제 2.
Person 클래스를 작성하시오.

이름과 태어난 해를 생성자로 받는다 (name, birthYear)
이름과 태어난 해는 한번 정해지면 수정이 불가능하다.
getAge() 메서드를 통해 나이를 제공하지만, 임의로 수정은 불가능하다.
나이 계산은 올해년도에서 birthYear 년도를 뺀 값을 리턴한다
현재 시간과 날짜를 구하는 방법은 검색 해 볼 것
 */

package com.survivalcoding;

import java.time.LocalDate;

public class Person {
    static final int currentYear = LocalDate.now().getYear();
    public static int defaultYear = currentYear;

    private String name;
    private int birthYear;
    private int age;

    public Person(String name, int birthYear) {
        setName(name);
        setBirthYear(birthYear);
        this.age = currentYear - birthYear;
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
        return age;
    }

}
