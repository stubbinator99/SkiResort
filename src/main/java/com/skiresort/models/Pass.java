package com.skiresort.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "passes")
public class Pass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pass_id")
    private long passId;

    @Column(name = "username", updatable = false, nullable = false)
    private String username;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "price_id")
    private Price price;

    public Pass() { }

    public Pass(
        String username,
        LocalDate startDate,
        LocalDate endDate,
        Price price
    ) {
        this.username = username;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
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

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }
}

