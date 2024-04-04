package com.skiresort.models;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "pass_prices")
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "price_id")
    private int priceId;

    @Column(name = "year")
    private int year;

    @Enumerated(EnumType.STRING)
    @Column(name = "pass_type")
    private PassType passType;

    @Enumerated(EnumType.STRING)
    @Column(name = "pass_category")
    private PassCategory passCategory;

    @Column(name = "price")
    private BigDecimal price;

    public Price() {
    }

    public Price(int year,
                 SnowSport snowSport,
                 PassType passType,
                 PassCategory passCategory,
                 BigDecimal price) {
        this.year = year;
        this.passType = passType;
        this.passCategory = passCategory;
        this.price = price;
    }

    public int getPriceId() {
        return priceId;
    }

    public void setPriceId(int priceId) {
        this.priceId = priceId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
