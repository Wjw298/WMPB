package cn.edu.guet.weapp.bean;

import java.util.Objects;

/**
 * @Auther wjw
 * @Date 2022/8/9 16:10
 * @Version 1.0
 */
public class SysAddress {
    private String address_id;
    private String address_openId;
    private String address_address;
    private String address_label;
    private String address_nickname;
    private String address_phone;

    public String getAddress_id() {
        return address_id;
    }

    public void setAddress_id(String address_id) {
        this.address_id = address_id;
    }

    public String getAddress_openId() {
        return address_openId;
    }

    public void setAddress_openId(String address_openId) {
        this.address_openId = address_openId;
    }

    public String getAddress_address() {
        return address_address;
    }

    public void setAddress_address(String address_address) {
        this.address_address = address_address;
    }

    public String getAddress_label() {
        return address_label;
    }

    public void setAddress_label(String address_label) {
        this.address_label = address_label;
    }

    public String getAddress_nickname() {
        return address_nickname;
    }

    public void setAddress_nickname(String address_nickname) {
        this.address_nickname = address_nickname;
    }

    public String getAddress_phone() {
        return address_phone;
    }

    public void setAddress_phone(String address_phone) {
        this.address_phone = address_phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysAddress that = (SysAddress) o;
        return Objects.equals(address_id, that.address_id) && Objects.equals(address_openId, that.address_openId) && Objects.equals(address_address, that.address_address) && Objects.equals(address_label, that.address_label) && Objects.equals(address_nickname, that.address_nickname) && Objects.equals(address_phone, that.address_phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address_id, address_openId, address_address, address_label, address_nickname, address_phone);
    }

    @Override
    public String toString() {
        return "SysAddress{" +
                "address_id='" + address_id + '\'' +
                ", address_openId='" + address_openId + '\'' +
                ", address_address='" + address_address + '\'' +
                ", address_label='" + address_label + '\'' +
                ", address_nickname='" + address_nickname + '\'' +
                ", address_phone='" + address_phone + '\'' +
                '}';
    }
}
