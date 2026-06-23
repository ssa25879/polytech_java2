package com.survivalcoding;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public abstract class IntangibleAsset extends Asset {
    // name, date
    private String assetType;
    private LocalDate acquiredDate;

    public IntangibleAsset(String name, String assetType, LocalDate acquiredDate) {
        super(name);
        setAssetType(assetType);
        setAcquiredDate(acquiredDate);
    }

    public IntangibleAsset(String name, String assetType, String acquiredDate) {
        super(name);
        setAssetType(assetType);
        setAcquiredDate(acquiredDate);
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        if (assetType == null) {
            throw new IllegalArgumentException("자산 종류가 비어있습니다.");
        }
        this.assetType = assetType;
    }

    public LocalDate getAcquiredDate() {
        return acquiredDate;
    }

    private void setAcquiredDate(LocalDate acquiredDate) {
        if (acquiredDate == null) {
            throw new IllegalArgumentException("취득일을 작성해야합니다.");
        }
        try {
            this.acquiredDate = acquiredDate;
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("취득일 작성 형식이 틀립니다.");
        }
    }

    private void setAcquiredDate(String acquiredDate) {
        if (acquiredDate == null) {
            throw new IllegalArgumentException("취득일을 작성해야합니다.");
        }
        this.acquiredDate = LocalDate.parse(acquiredDate);
    }
}
