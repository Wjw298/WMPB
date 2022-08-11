package cn.edu.guet.weapp.http;

import cn.edu.guet.weapp.bean.SysCustomer;
import org.apache.http.HttpStatus;

/**
 * HTTP结果封装
 *
 * @Author Liwei
 * @Date 2021-08-10 09:30
 */
public class HttpResult {

    private int code = 200;
    private String msg;
    private Object data;
    private SysCustomer customer;

    public static HttpResult error() {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
    }

    public static HttpResult error(String msg) {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
    }

    public static HttpResult error(int code, String msg) {
        HttpResult r = new HttpResult();
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }
    public static HttpResult ok(String msg) {
        HttpResult r = new HttpResult();
        r.setMsg(msg);
        return r;
    }

    public static HttpResult ok(SysCustomer customer, String msg) {
        HttpResult r = new HttpResult();
        r.setCustomer(customer);
        r.setMsg(msg);
        return r;
    }

    public static HttpResult ok(Object data) {
        HttpResult r = new HttpResult();
        r.setData(data);
        return r;
    }

    public static HttpResult ok() {
        return new HttpResult();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public SysCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(SysCustomer customer) {
        this.customer = customer;
    }
}
