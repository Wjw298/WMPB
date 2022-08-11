package cn.edu.guet.weapp.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import cn.edu.guet.weapp.util.TokenUtil;
import cn.edu.guet.weapp.controller.CustomerController;
import cn.edu.guet.weapp.exception.TokenAuthExpiredException;

/**
 * @author Jarvan
 * @version 1.0
 * @create 2021/2/10 22:22
 */
@Slf4j
@Component
public class AuthHandlerInterceptor implements HandlerInterceptor {
    @Autowired
    TokenUtil tokenUtil;
    @Value("${token.privateKey}")
    private String privateKey;
    @Value("${token.yangToken}")
    private Long yangToken;
    @Value("${token.oldToken}")
    private Long oldToken;
    @Autowired
    private CustomerController controller ;
    /**
     * 权限认证的拦截操作.
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
        //log.info("=======进入拦截器========");
        // 如果不是映射到方法直接通过,可以访问资源.
        if (!(object instanceof HandlerMethod)) {
            return true;
        }
        //为空就返回错误
        String token = httpServletRequest.getHeader("token");
        //log.info(token);
        if (null == token || "".equals(token.trim())) {
            return false;
        }
        //log.info("==============token:" + token);
        Map<String, String> map = tokenUtil.parseToken(token);
        String openId = map.get("openId");
        System.out.println("token open openId: "+openId);
        long timeOfUse = System.currentTimeMillis() - Long.parseLong(map.get("timeStamp"));

        //1.判断 token 是否过期
        //年轻 token
        if (timeOfUse < yangToken) {
            //log.info("年轻 token");
        }
        //老年 token 就刷新 token
        else if (timeOfUse >= yangToken && timeOfUse < oldToken) {
            httpServletResponse.setHeader("token",tokenUtil.getToken(openId));
        }
        //过期 token 就返回 token 无效.
        else {
            throw new TokenAuthExpiredException();
        }
        //2.角色匹配.
        if(controller.verifyToken(openId)){
            //log.info("========user账户============");
            return true;
        }else{
            //log.info("========不是user账户============");
        }
        return false;
    }

}
