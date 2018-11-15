package com.test.ssh.dao.impl;

import com.test.ssh.dao.EmployeeDao;
import com.test.ssh.domain.Employee;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao{
    @Override
    public Employee login(Employee employee) {
        String sql = "from Employee where name = ? and password = ?";
        List<Employee> list = this.getHibernateTemplate().find(sql, employee.getName(), employee.getPassword());
        if (list.size()>0){
            return list.get(0);
        }
        return null;
    }
}
