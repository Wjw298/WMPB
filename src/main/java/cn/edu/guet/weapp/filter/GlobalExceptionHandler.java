package cn.edu.guet.weapp.filter;

import cn.edu.guet.weapp.exception.TokenAuthExpiredException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理类
 * @author Jarvan
 * @version 1.0
 * @create 2021/2/11 0:05
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 用户 token 过期
     * @return
     */
    @ExceptionHandler(value = TokenAuthExpiredException.class)
    @ResponseBody
    public String tokenExpiredExceptionHandler(){
        log.warn("用户 token 过期");
        return "用户 token 过期";
    }
}
