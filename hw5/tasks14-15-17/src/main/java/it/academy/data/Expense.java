package it.academy.data;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class Expense implements Serializable {
 private int num;
 private Date payDate;
 private int receiver;
 private float value;

    public Expense() {
        super();
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public int getReceiver() {
        return receiver;
    }

    public void setReceiver(int receiver) {
        this.receiver = receiver;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expense expense = (Expense) o;
        return num == expense.num && receiver == expense.receiver && Float.compare(expense.value, value) == 0 && Objects.equals(payDate, expense.payDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, payDate, receiver, value);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Expenses{");
        sb.append("num=").append(num);
        sb.append(", payDate=").append(payDate);
        sb.append(", receiver=").append(receiver);
        sb.append(", value=").append(value);
        sb.append('}');
        return sb.toString();
    }
}
