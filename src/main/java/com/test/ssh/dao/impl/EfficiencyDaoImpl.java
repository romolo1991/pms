package com.test.ssh.dao.impl;

import com.test.ssh.dao.EfficiencyDao;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import sun.security.ssl.Debug;

import java.util.ArrayList;
import java.util.List;

public class EfficiencyDaoImpl extends HibernateDaoSupport implements EfficiencyDao {

    @Override
    public List getEmployeePerf(String employeeId, String month) {
        String sql = "select p.projectType, j.workload, p.efficiency " +
                "from JobassignmentEntity j, Project p " +
                "where j.isDelete = '0' and j.project = p.projectId " +
                "and j.employee='" + employeeId + "' and j.monthOfAssignment='" + month + "'";

        Query query = getSession().createQuery(sql);

        return query.list() != null ? query.list() : new ArrayList();
    }

    @Override
    public List<String> getMonths(String startMonth, String endMonth, String employeeId) {
        List<String> resultList = new ArrayList<String>();
        String sql = "select monthOfAssignment from JobassignmentEntity where employee = '"+ employeeId + "' and '"
                + startMonth + "' <= monthOfAssignment and monthOfAssignment <= '"
                + endMonth + "' group by  monthOfAssignment order by monthOfAssignment";
        try {
            List list = getSession().createQuery(sql).list();
            resultList = list;
        } catch (Exception e) {
            Debug.println("getMonths", e.toString() + "\n" + sql);
        }
        return resultList;
    }

}
