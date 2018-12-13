package com.lzx.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Book {
    private String name;
    private BigDecimal price;
    private Date created;

    public Book(String name, BigDecimal price, Date created) {
        this.name = name;
        this.price = price;
        this.created = created;
    }

    public Book() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
