package com.zc.config.shiro;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Created by Logan Zhou on 2018-03-06.
 * 重写FormAuthenticationFilter,解决shiro登录成功后跳转不到设置路径的问题
 */
public class MyFormAuthenticationFilter extends FormAuthenticationFilter{
    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        String successUrl = "/admin/access/index.html";
        WebUtils.issueRedirect(request,response,successUrl);
        return false;
    }
}
