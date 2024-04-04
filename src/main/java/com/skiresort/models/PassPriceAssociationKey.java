package com.skiresort.models;

import java.io.Serializable;

public class PassPriceAssociationKey implements Serializable {
    private Long passId;
    private Long priceId;

    public PassPriceAssociationKey() { }

    public PassPriceAssociationKey(Long passId, Long priceId) {
        this.passId = passId;
        this.priceId = priceId;
    }

    public Long getPassId() {
        return passId;
    }

    public void setPassId(Long passId) {
        this.passId = passId;
    }

    public Long getPriceId() {
        return priceId;
    }

    public void setPriceId(Long priceId) {
        this.priceId = priceId;
    }
}
