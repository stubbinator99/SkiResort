package com.skiresort.models;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "pass_price_association")
@IdClass(PassPriceAssociationKey.class)
public class PassWithPrice implements Serializable {
    @Id
    @Column(name = "pass_id")
    private long passId;

    @Id
    @Column(name = "price_id")
    private int priceId;

    @ManyToOne
    @JoinColumn(name = "pass_id", referencedColumnName = "pass_id", insertable = false, updatable = false)
    private Pass pass;

    @ManyToOne
    @JoinColumn(name = "price_id", referencedColumnName = "price_id", insertable = false, updatable = false)
    private Price price;

    public PassWithPrice() { }

    
}
