package com.test.ssh.dao.impl;

import com.test.ssh.dao.DepartmentDao;
import com.test.ssh.domain.Department;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;


public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao {
    @Override
    public List<Department> getDepts() {
        String sql = "from Department where isDelete='0'";
        List<Department> list = this.getHibernateTemplate().find(sql);
        if(list.size()>0){
            return list;
        }
        else {
            return null;
        }

    }

}
