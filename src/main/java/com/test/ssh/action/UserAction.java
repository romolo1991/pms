package com.test.ssh.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.test.ssh.domain.User;
import com.test.ssh.service.UserService;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserAction extends ActionSupport implements ModelDriven<User> {

    private User user = new User();

    private UserService userService;

    @Override
    public User getModel() {
        return user;
    }

    public String login() {
        User returnUser = userService.login(user);
        if (returnUser == null) {
            this.addActionError("用户名或密码错误！");
            return "failed";
        } else if (returnUser.getIsDelete() == "1") {
            this.addActionError("该用户已进入睡眠状态，请联系管理员激活该用户！");
            return "failed";
        } else {
            HttpServletRequest request = ServletActionContext.getRequest();
            HttpSession session = request.getSession();
            session.setAttribute("user", returnUser);
            return "success";
        }
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
