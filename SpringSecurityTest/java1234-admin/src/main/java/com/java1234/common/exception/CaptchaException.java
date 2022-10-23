package com.java1234.common.exception;


import org.springframework.security.core.AuthenticationException;

/**
 * 自定义验证码异常
 * @author java1234_小锋 （公众号：java1234）
 * @site www.java1234.vip
 * @company 南通小锋网络科技有限公司
 */
public class CaptchaException extends AuthenticationException {

    public CaptchaException(String msg) {
        super(msg);
    }
}
