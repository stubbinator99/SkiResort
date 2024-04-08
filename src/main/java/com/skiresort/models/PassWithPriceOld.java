package com.skiresort.models;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PassWithPriceOld {
    private long passId;
    private String username;
    private LocalDate startDate;
    private LocalDate endDate;
    private int priceId;
    private BigDecimal price;
    private PassType passType;
    private PassCategory passCategory;

    public PassWithPriceOld() { }

    public PassWithPriceOld(Pass pass, Price price) {
        //mapToPassWithPrice(pass, price);
    }

    public long getPassId() {
        return passId;
    }

    public void setPassId(long passId) {
        this.passId = passId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getPriceId() {
        return priceId;
    }

    public void setPriceId(int priceId) {
        this.priceId = priceId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public PassType getPassType() {
        return passType;
    }

    public void setPassType(PassType passType) {
        this.passType = passType;
    }

    public PassCategory getPassCategory() {
        return passCategory;
    }

    public void setPassCategory(PassCategory passCategory) {
        this.passCategory = passCategory;
    }

    /*private void mapToPassWithPrice(Pass pass, Price price) {
        this.passId = pass.getPassId();
        this.username = pass.getUsername();
        this.startDate = pass.getStartDate();
        this.endDate = pass.getEndDate();
        this.priceId = pass.getPriceId();
        this.price = price.getPrice();
        this.passType = price.getPassType();
        this.passCategory = price.getPassCategory();
    }*/
}
