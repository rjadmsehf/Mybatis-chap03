package com.ohgiraffers.section01.xmlconfig;

import lombok.*;

//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
////@ToString
//@Data     //필기 위에 다섯가지 요소를 한 번에 포함하는 어노테이션. 이지만 오류(에러)를 발생시킬 수 있어서 잘사용하지 않음
public class MenuDTO {

    private int code;
    private String name;
    private int price;
    private int categoryCode;
    private String orderableStatus;

public MenuDTO (){}

    public MenuDTO(int code, String name, int price, int categoryCode, String orderableStatus) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.categoryCode = categoryCode;
        this.orderableStatus = orderableStatus;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getOrderableStatus() {
        return orderableStatus;
    }

    public void setOrderableStatus(String orderableStatus) {
        this.orderableStatus = orderableStatus;
    }

    @Override
    public String toString() {
        return "MenuDTO{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", categoryCode=" + categoryCode +
                ", orderableStatus='" + orderableStatus + '\'' +
                '}';
    }

}
