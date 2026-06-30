package com.survivalcoding;

import java.util.Objects;

public class Book extends TangibleAsset {
    private String isBn;

    public Book(String name, int price, String color, double weight, String isbn) {
        super(name, price, color, weight);
        setIsbn(isbn);
    }

    public String getIsbn() {
        return isBn;
    }

    private void setIsbn(String isBn) {
        if (isBn == null) {
            throw new IllegalArgumentException("국제 표준 도서 번호는 비어있을 수 없습니다.");
        }
        this.isBn = isBn;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isBn='" + isBn + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Book book)) return false;
        return Objects.equals(isBn, book.isBn);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(isBn);
    }
}