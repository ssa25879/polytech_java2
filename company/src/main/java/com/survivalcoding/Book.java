package com.survivalcoding;

public class Book extends TangibleAsset {
    private String isBn;

    public Book(String name, int price, String color, double weight, String isBn) {
        super(name, price, color, weight);
        setIsBn(isBn);
    }

    public String getIsBn() {
        return isBn;
    }

    public void setIsBn(String isBn) {
        if (isBn == null) {
            throw new IllegalArgumentException("국제 표준 도서 번호는 비어있을 수 없습니다.");
        }
        this.isBn = isBn;
    }
}