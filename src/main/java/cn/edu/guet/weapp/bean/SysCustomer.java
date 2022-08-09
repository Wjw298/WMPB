package cn.edu.guet.weapp.bean;

import java.util.Objects;

/**
 * @Auther wjw
 * @Date 2022/8/3 13:28
 * @Version 1.0
 */
public class SysCustomer {
    private String id;
    private String openId;
    private String name;
    private String image;
    private String salt;

    public SysCustomer() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysCustomer customer = (SysCustomer) o;
        return Objects.equals(id, customer.id) && Objects.equals(openId, customer.openId) && Objects.equals(name, customer.name) && Objects.equals(image, customer.image) && Objects.equals(salt, customer.salt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, openId, name, image, salt);
    }

    @Override
    public String toString() {
        return "SysCustomer{" +
                "id='" + id + '\'' +
                ", openId='" + openId + '\'' +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", salt='" + salt + '\'' +
                '}';
    }
}
