package com.survivalcoding;

import java.time.LocalDate;

public class Patent extends IntangibleAsset{
    private String inventor;
    private int patentNumber;

    public Patent(String name, String assetType, String acquiredDate, String inventor, int patentNumber) {
        super(name, assetType, acquiredDate);
        setInventor(inventor);
        setPatentNumber(patentNumber);
    }

    public String getInventor() {
        return inventor;
    }

    public void setInventor(String inventor) {
        if (inventor == null) {
            throw new IllegalArgumentException("특허 출원인은 비어있을 수 없습니다.");
        }
        this.inventor = inventor;
    }

    public int getPatentNumber() {
        return patentNumber;
    }

    public void setPatentNumber(int patentNumber) {
        if (patentNumber < 0) {
            throw new IllegalArgumentException("특허 출원 번호는 비어있을 수 없습니다.");
        }
        this.patentNumber = patentNumber;
    }
}
