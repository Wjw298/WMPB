package cn.edu.guet.weapp.controller;

import cn.edu.guet.weapp.bean.LoginBean;
import cn.edu.guet.weapp.bean.SysUser;
import cn.edu.guet.weapp.http.HttpResult;
import cn.edu.guet.weapp.security.JwtAuthenticationToken;
import cn.edu.guet.weapp.service.SysUserService;
import cn.edu.guet.weapp.util.PasswordUtils;
import cn.edu.guet.weapp.util.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
public class LoginController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping(value = "/login")
    //public HttpResult login(String username, String password,HttpServletRequest request){
    public HttpResult login(@RequestBody LoginBean loginBean, HttpServletRequest request){
        String username = loginBean.getUsername();
        String password = loginBean.getPassword();
        System.out.println("request: "+request);

        // 用户信息
        System.out.println(username);
        System.out.println(password);
        SysUser user = sysUserService.findByName(username);
        // 账号不存在、密码错误
        if (user == null) {
            return HttpResult.error("账号不存在");
        }
        if (!PasswordUtils.matches(user.getSalt(), password, user.getPassword())) {
            return HttpResult.error("密码不正确");
        }
        // 账号锁定
        if (user.getStatus() == 0) {
            return HttpResult.error("账号已被锁定,请联系管理员");
        }
        // 系统登录认证
        JwtAuthenticationToken token = SecurityUtils.login(request, username, password, authenticationManager);
        System.out.println("HttpResult.ok(token): "+HttpResult.ok(token));
        return HttpResult.ok(token);
    }
}
