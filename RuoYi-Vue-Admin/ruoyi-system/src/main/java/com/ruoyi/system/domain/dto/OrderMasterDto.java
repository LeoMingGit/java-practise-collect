package com.ruoyi.system.domain.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;


public class OrderMasterDto {

    @ExcelProperty("order_id")
    private String orderId;

    @ExcelProperty("buyer_name")
    private String buyerName;

    @ExcelProperty("buyer_phone")
    private String buyerPhone;

    @ExcelProperty("order_amount")
    private BigDecimal orderAmount;

    @ExcelProperty("status")
    private Integer status;

    @ExcelProperty("create_time")
    private Date createTime;

    @ExcelProperty("create_user")
    private String createUser;

    @ExcelProperty("update_time")
    private Date updateTime;

    @ExcelProperty("update_user")
    private String updateUser;


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerPhone() {
        return buyerPhone;
    }

    public void setBuyerPhone(String buyerPhone) {
        this.buyerPhone = buyerPhone;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderMasterDto that = (OrderMasterDto) o;
        return Objects.equals(orderId, that.orderId) && Objects.equals(buyerName, that.buyerName) && Objects.equals(buyerPhone, that.buyerPhone) && Objects.equals(orderAmount, that.orderAmount) && Objects.equals(status, that.status) && Objects.equals(createTime, that.createTime) && Objects.equals(createUser, that.createUser) && Objects.equals(updateTime, that.updateTime) && Objects.equals(updateUser, that.updateUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, buyerName, buyerPhone, orderAmount, status, createTime, createUser, updateTime, updateUser);
    }
}
