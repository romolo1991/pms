package com.test.ssh.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.Set;

public class LoginInterceptoe extends MethodFilterInterceptor {

    private static final long serialVersionUID = 1L;

    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        Set<String> set = this.getExcludeMethodsSet();
        HttpServletRequest request = ServletActionContext.getRequest();
        String url = request.getRequestURL().toString();

        Iterator<String> xx = set.iterator();
        while (xx.hasNext()) {
            String excludeMethod = xx.next();
            if (url.contains(excludeMethod)) {
                System.out.println("----用户正在登陆，放行:" + url);
                return actionInvocation.invoke();
            }
        }
        if (null == request.getSession().getAttribute("user")) {
            System.out.println("----用户未登录，拦截:" + url);
            return "fail";  // 这里返回用户登录页面视图
        }
        return actionInvocation.invoke();
    }

}

