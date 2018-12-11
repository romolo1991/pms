package com.test.ssh.dao.impl;

import com.test.ssh.dao.EmployeeDao;
import com.test.ssh.domain.Employee;
import com.test.ssh.domain.modelResult.EmployeeResult;
import com.test.ssh.utils.StringUtils;
import org.hibernate.*;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import sun.security.ssl.Debug;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao {

    @Override
    public List<EmployeeResult> getEmployees(Employee employee, final int page, final int limit) {
        List<EmployeeResult> employeeResults;
        final StringBuffer sql = new StringBuffer("SELECT e.employeeId, e.employeeName, e.employeeNameSpell, e.entryTime, " +
                "e.department, e.groupOfEmployee, e.groupLeader, e.isDelete, d.departmentName, g.groupName " +
                "FROM Employee e, Department d, Groupofdepartment g " +
                "WHERE e.department = d.departmentId " +
                "AND e.groupOfEmployee = g.groupId " +
                "AND e.isDelete = 0 ");
        if (StringUtils.isNotEmpty(employee.getEmployeeName()))
            sql.append(" And e.employeeName = " + employee.getEmployeeName());
        if (StringUtils.isNotEmpty(employee.getEmployeeId()))
            sql.append(" And e.employeeId = " + employee.getEmployeeId());
        if (StringUtils.isNotEmpty(employee.getEmployeeNameSpell()))
            sql.append(" And e.employeeNameSpell = " + employee.getEmployeeNameSpell());
        if (employee.getDepartment() != 0)
            sql.append(" And e.department = " + employee.getDepartment());
        if (employee.getGroupOfEmployee() != 0)
            sql.append(" And e.groupOfEmployee = " + employee.getGroupOfEmployee());
        if (StringUtils.isNotEmpty(employee.getGroupLeader()) && !employee.getGroupLeader().equals("255"))
            sql.append(" And e.groupLeader = " + employee.getGroupLeader());

        final String finalSql = sql.toString();
        List list = this.getHibernateTemplate().executeFind(
                new HibernateCallback() {
                    @Override
                    public Object doInHibernate(Session session) {
                        Query query = session.createQuery(finalSql);
                        query.setFirstResult((page - 1) * limit);
                        query.setMaxResults(limit);
                        return query.list();
                    }
                }
        );
        try {
            employeeResults = (list.size() > 0 && list != null) ? list : null;
        } catch (Exception e) {
            employeeResults = null;
            Debug.println("数据库查询结果强转错误", e.toString());
        }
        return employeeResults;
    }

    @Override
    public String delEmployeeByIds(final ArrayList<String> employeeIds) {

        List resultList = this.getHibernateTemplate().executeFind(new HibernateCallback() {
            @Override
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                List list = new ArrayList();
                try {
                    Transaction tx = session.beginTransaction();
                    for (int i = 0; i < employeeIds.size(); i++) {
                        String employeeId = employeeIds.get(i);
                        String updateSql = "update Employee set isDelete = '1' where employeeId = '" + employeeId + "'";
                        Query query = session.createQuery(updateSql);
                        query.executeUpdate();
                    }
                    tx.commit();
                    list.add("success");
                } catch (Exception e) {
                    list.add("error");
                    Debug.println("delEmployeeByIds:", e.toString());
                }
                return list;
            }
        });

        if (resultList != null && resultList.size() > 0) {
            if (resultList.get(0).toString().equals("success"))
                return "success";
            else
                return "fail";
        } else {
            return "fail";
        }

    }
}
