package com.skiresort.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "passes")
public class Pass {
    @Id
    @GeneratedValue
    @Column(name = "pass_id")
    private String passId;

    @Column(name = "username", updatable = false, nullable = false)
    private String username;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "price_id")
    private String priceId;

    public Pass() {
    }

    public Pass(String username,
                LocalDate startDate,
                LocalDate endDate,
                String priceId) {
        this.username = username;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceId = priceId;
    }

    public String getPassId() {
        return passId;
    }

    public void setPassId(String passId) {
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

    public String getPriceId() {
        return priceId;
    }

    public void setPriceId(String priceId) {
        this.priceId = priceId;
    }
}

