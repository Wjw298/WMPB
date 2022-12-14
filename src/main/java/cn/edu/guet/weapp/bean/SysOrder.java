package cn.edu.guet.weapp.bean;

import java.util.Date;
import java.util.Objects;

/**
 * @Auther wjw
 * @Date 2022/7/29 10:43
 * @Version 1.0
 */
public class SysOrder {
    private String order_id;
    private String username;
    private double total_amount;
    private double pay_amount;
    private String create_time;
    private int pay_type;
    private int status;
    //非数据库字段
    private String pay_typeS;
    //非数据库字段
    private String statusS;

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(double total_amount) {
        this.total_amount = total_amount;
    }

    public double getPay_amount() {
        return pay_amount;
    }

    public void setPay_amount(double pay_amount) {
        this.pay_amount = pay_amount;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public int getPay_type() {
        return pay_type;
    }

    public void setPay_type(int pay_type) {
        this.pay_type = pay_type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPay_typeS() {
        return pay_typeS;
    }

    public void setPay_typeS(String pay_typeS) {
        this.pay_typeS = pay_typeS;
    }

    public String getStatusS() {
        return statusS;
    }

    public void setStatusS(String statusS) {
        this.statusS = statusS;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysOrder sysOrder = (SysOrder) o;
        return Double.compare(sysOrder.total_amount, total_amount) == 0 && Double.compare(sysOrder.pay_amount, pay_amount) == 0 && pay_type == sysOrder.pay_type && status == sysOrder.status && Objects.equals(order_id, sysOrder.order_id) && Objects.equals(username, sysOrder.username) && Objects.equals(create_time, sysOrder.create_time) && Objects.equals(pay_typeS, sysOrder.pay_typeS) && Objects.equals(statusS, sysOrder.statusS);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order_id, username, total_amount, pay_amount, create_time, pay_type, status, pay_typeS, statusS);
    }

    @Override
    public String toString() {
        return "SysOrder{" +
                "order_id='" + order_id + '\'' +
                ", username='" + username + '\'' +
                ", total_amount=" + total_amount +
                ", pay_amount=" + pay_amount +
                ", create_time='" + create_time + '\'' +
                ", pay_type=" + pay_type +
                ", status=" + status +
                ", pay_typeS='" + pay_typeS + '\'' +
                ", statusS='" + statusS + '\'' +
                '}';
    }
}
