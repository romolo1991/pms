package com.test.ssh.dao.impl;

import com.test.ssh.dao.ProjectDao;
import com.test.ssh.domain.Project;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

public class ProjectDaoImpl extends HibernateDaoSupport implements ProjectDao {

    public String getAllProjectSql(String projectId, String projectName, int hostGroup, String projectType, String startTime, String endTime) {
        String sql = "from Project where isDelete='0'";
        if (projectId != null && !projectId.equals("")) {
            sql += " and projectId='" + projectId + "'";
        }
        if (projectName != null && !projectName.equals("")) {
            sql += " and projectName like '%" + projectName + "%'";
        }
        String hostGroupStr = hostGroup + "";
        if (!hostGroupStr.equals("0")) {
            sql += " and hostGroup='" + hostGroup + "'";
        }
        if (projectType != null && !projectType.equals("")) {
            sql += " and projectType='" + projectType + "'";
        }
        if (startTime != null && !startTime.equals("")) {
            sql += " and startTime>'" + startTime + "'";
        }
        if (endTime != null && !endTime.equals("")) {
            sql += " and endTime<'" + endTime + "'";
        }
        return sql;
    }

    @Override
    public List<Project> getProjects(String projectId, String projectName, int hostGroup, String projectType, String startTime, String endTime, final int page, final int limit) {
        String sql = getAllProjectSql(projectId, projectName, hostGroup, projectType, startTime, endTime);
        final String finalSql = sql;
        List list = this.getHibernateTemplate().executeFind(
                new HibernateCallback() {
                    public Object doInHibernate(Session session) {
                        Query query = session.createQuery(finalSql);
                        query.setFirstResult((page - 1) * limit);
                        query.setMaxResults(limit);
                        return query.list();
                    }
                }
        );
        if (list.size() > 0) {
            return list;
        } else {
            return null;
        }
    }

    @Override
    public int getProjectCount(String projectId, String projectName, int hostGroup, String projectType, String startTime, String endTime) {
        String sql = getAllProjectSql(projectId, projectName, hostGroup, projectType, startTime, endTime);
        List list = this.getHibernateTemplate().find(sql);
        return list.size();
    }

    @Override
    public String addProject(Project project) {
        this.getHibernateTemplate().saveOrUpdate(project);
        return "success";
    }

    @Override
    public String delProject(String projectId) {
        String sql = "from Project where projectId='" + projectId + "'";
        List<Project> list = this.getHibernateTemplate().find(sql);
        Project projectNow = list.get(0);
        projectNow.setIsDelete("1");
        this.getHibernateTemplate().update(projectNow);
        return "success";
    }
}
