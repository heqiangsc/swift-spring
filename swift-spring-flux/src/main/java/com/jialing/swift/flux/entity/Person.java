package com.jialing.swift.flux.entity;


import com.jialing.swift.flux.validation.ValidCardNumber;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

public class Person {
    @Max(value = 100, message = "最大值不能超过100")
    private int id;
    @NotBlank(message = "姓名不能为空")
    private String name;

    @ValidCardNumber(message = "卡号不正确")
    @NotBlank
    private String cardNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
