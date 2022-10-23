package com.java1234.common.security;

import com.java1234.common.constant.JwtConstant;
import com.java1234.entity.CheckResult;
import com.java1234.entity.SysUser;
import com.java1234.service.SysUserService;
import com.java1234.util.JwtUtils;
import com.java1234.util.StringUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author java1234_小锋 （公众号：java1234）
 * @site www.java1234.vip
 * @company 南通小锋网络科技有限公司
 */
public class JwtAuthenticationFilter  extends BasicAuthenticationFilter {

    @Autowired
    private MyUserDetailServiceImpl myUserDetailService;

    @Autowired
    private SysUserService sysUserService;

    // 请求白名单
    private static final String URL_WHITELIST[]={
            "/captcha"
    };

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String token = request.getHeader("token");
        System.out.println("request.getRequestURI()"+request.getRequestURI());
        if(StringUtil.isEmpty(token) || new ArrayList<String>(Arrays.asList(URL_WHITELIST)).contains(request.getRequestURI())){
            chain.doFilter(request,response);
            return;
        }
        CheckResult checkResult = JwtUtils.validateJWT(token);
        if(!checkResult.isSuccess()){
            switch (checkResult.getErrCode()){
                case JwtConstant.JWT_ERRCODE_NULL: throw new JwtException("Token不存在");
                case JwtConstant.JWT_ERRCODE_FAIL: throw new JwtException("Token验证不通过");
                case JwtConstant.JWT_ERRCODE_EXPIRE: throw new JwtException("Token过期");
            }
        }


        Claims claims = JwtUtils.parseJWT(token);
        String username = claims.getSubject();

        SysUser sysUser = sysUserService.getByUserName(username);

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(username,null,myUserDetailService.getUserAuthority(sysUser.getId()));

        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

        chain.doFilter(request,response);

    }
}
