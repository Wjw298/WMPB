package cn.edu.guet.weapp.util;

import cn.edu.guet.weapp.bean.SysCustomer;

import java.io.IOException;

/**
 * @Auther wjw
 * @Date 2022/8/4 17:07
 * @Version 1.0
 */
public class GetUser {
    public static SysCustomer getUser(String user) throws IOException {
        String[] ok = user.split("[\\{\\:\\}\\,\\s+]");
        SysCustomer customer=new SysCustomer();
        String name=ok[4];
        customer.setName(name.replace("\"", ""));
        String image = ok[16]+":"+ok[17];
        customer.setImage(image.replace("\"", ""));
        String code = ok[20];
        code = code.substring(code.indexOf('"')+1,code.lastIndexOf('"'));//将code转为可用形式
        customer.setOpenId(GetOpenId.getOpenId(code));
        return customer;
    }
}
