package com.test.ssh.dao.impl;

import com.test.ssh.dao.UserDao;
import com.test.ssh.domain.User;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
    @Override
    public User login(User user) {
        String sql = "from User where userName=? and userPassword=?";
        List<User> list = this.getHibernateTemplate().find(sql, user.getUserName(), user.getUserPassword());
        if (list.size()>0){
            return list.get(0);
        }else{
            return null;
        }
    }
}
