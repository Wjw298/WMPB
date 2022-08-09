package cn.edu.guet.weapp.bean;

import java.util.Objects;

/**
 * @Auther wjw
 * @Date 2022/8/9 16:10
 * @Version 1.0
 */
public class SysAddress {
    private String address_id;
    private String address_name;
    private String address_address;
    private String address_label;

    public String getAddress_id() {
        return address_id;
    }

    public void setAddress_id(String address_id) {
        this.address_id = address_id;
    }

    public String getAddress_name() {
        return address_name;
    }

    public void setAddress_name(String address_name) {
        this.address_name = address_name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysAddress that = (SysAddress) o;
        return Objects.equals(address_id, that.address_id) && Objects.equals(address_name, that.address_name) && Objects.equals(address_address, that.address_address) && Objects.equals(address_label, that.address_label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address_id, address_name, address_address, address_label);
    }

    @Override
    public String toString() {
        return "SysAddress{" +
                "address_id='" + address_id + '\'' +
                ", address_name='" + address_name + '\'' +
                ", address_address='" + address_address + '\'' +
                ", address_label='" + address_label + '\'' +
                '}';
    }
}
