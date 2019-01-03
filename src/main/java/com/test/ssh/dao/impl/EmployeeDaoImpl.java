package com.test.ssh.dao.impl;

import com.test.ssh.dao.EmployeeDao;
import com.test.ssh.domain.Employee;
import com.test.ssh.utils.StringUtils;
import org.hibernate.*;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import sun.security.ssl.Debug;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao {

    public String getEmployeesSQL(Employee employee) {
        StringBuffer sql = new StringBuffer("SELECT e.employeeId, e.employeeName, e.employeeNameSpell, e.entryTime, " +
                "e.department, e.groupOfEmployee, e.groupLeader, e.isDelete, d.departmentName, g.groupName " +
                "FROM Employee e, Department d, Groupofdepartment g " +
                "WHERE e.department = d.departmentId " +
                "AND e.groupOfEmployee = g.groupId " +
                "AND e.isDelete = '0' ");
        if (StringUtils.isNotEmpty(employee.getEmployeeName()))
            sql.append(" And e.employeeName like '%" + employee.getEmployeeName() + "%'");
        if (StringUtils.isNotEmpty(employee.getEmployeeId()))
            sql.append(" And e.employeeId = '" + employee.getEmployeeId() + "'");
        if (StringUtils.isNotEmpty(employee.getEmployeeNameSpell()))
            sql.append(" And e.employeeNameSpell = '" + employee.getEmployeeNameSpell() + "'");
        if (employee.getDepartment() != 0)
            sql.append(" And e.department = " + employee.getDepartment());
        if (employee.getGroupOfEmployee() != 0)
            sql.append(" And e.groupOfEmployee = " + employee.getGroupOfEmployee());
        if (StringUtils.isNotEmpty(employee.getGroupLeader()) && !employee.getGroupLeader().equals("255"))
            sql.append(" And e.groupLeader = '" + employee.getGroupLeader() + "'");

        return sql.toString();
    }

    @Override
    public List getEmployees(Employee employee, final int page, final int limit) {
        List resultArrayList = new ArrayList();
        final String finalSql = getEmployeesSQL(employee);
        try {
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
            resultArrayList = (list != null) ? list : null;
        } catch (Exception e) {
            Debug.println("getEmployees", e.toString() + "\n" + finalSql);
        }
        return resultArrayList;
    }

    @Override
    public Employee getEmployeeById(String employeeId) {
        String sql = "from Employee where isDelete = '0'";
        if (employeeId != null && !"".equals(employeeId)){
            sql += " and employeeId='" + employeeId + "'";
        }else {
            Debug.println("getEmployeeById", "传入职员编号为null或空字符串" + "\n" + sql);
        }
        List<Employee> result = this.getHibernateTemplate().find(sql);
        if (result.size()>0){
            return result.get(0);
        }else {
            Debug.println("getEmployeeById", "无法找到该职员" + "\n" + sql);
            return null;
        }
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
                    list.add(e.toString());
                    Debug.println("delEmployeeByIds", e.toString());
                } finally {
                    return list;
                }
            }
        });

        if (resultList != null && resultList.size() > 0) {
            if ("success".equals(resultList.get(0)))
                return "success";
            else
                return resultList.get(0).toString();
        } else {
            return "fail";
        }
    }

    @Override
    public String addEmployee(Employee employee) {
        try {
            this.getHibernateTemplate().saveOrUpdate(employee);
            return "success";
        } catch (Exception e) {
            Debug.println("addEmployee", e.toString());
            return e.toString();
        }
    }

    @Override
    public String importEmployees(final List<Employee> employeeList) {

        List resultList = this.getHibernateTemplate().executeFind(new HibernateCallback() {
            @Override
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                List list = new ArrayList();
                try {
                    Transaction tx = session.beginTransaction();
                    for (int i = 0; i < employeeList.size(); i++) {
                        session.save(employeeList.get(i));
                    }
                    tx.commit();
                    list.add("success");
                } catch (Exception e) {
                    list.add(e.toString());
                    Debug.println("importEmployees", e.toString());
                } finally {
                    return list;
                }
            }
        });

        if (resultList != null && resultList.size() > 0) {
            if ("success".equals(resultList.get(0)))
                return "success";
            else
                return resultList.get(0).toString();
        } else {
            return "fail";
        }
    }

    @Override
    public int getEmployeesCount(Employee employee) {
        final String finalSql = getEmployeesSQL(employee);
        List resultList = null;
        try {
            resultList = this.getHibernateTemplate().find(finalSql);
        } catch (Exception e) {
            Debug.println("getEmployeesCount", e.toString());
        }
        return (resultList != null) ? resultList.size() : 0;
    }
}
