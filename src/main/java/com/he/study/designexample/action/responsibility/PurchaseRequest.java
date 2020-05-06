package com.he.study.designexample.action.responsibility;

/**
 * @author he.xuelong
 * @Description 采购单：请求类
 * @ClassName PurchaseRequest
 * @Date 2020年03月23日 14:57
 */
public class PurchaseRequest {
    private double amount; //采购金额
    private int number; //采购单编号
    private String purpose; //采购目的

    public PurchaseRequest(double amount, int number, String purpose) {
        this.amount = amount;
        this.number = number;
        this.purpose = purpose;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getPurpose() {
        return this.purpose;
    }
}
