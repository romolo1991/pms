package com.test.ssh.dao.impl;

import com.test.ssh.dao.ProjectDao;
import com.test.ssh.domain.Project;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ProjectDaoImpl extends HibernateDaoSupport implements ProjectDao {
    @Override
    public List<Project> getProjects(String projectId, String projectName, String projectType, String projectScale, String startTime, String endTime, final int page, final int limit) {
        String sql = "from Project where isDelete='0'";
        if (projectId != null && !projectId.equals("")){
            sql += "and projectId='" + projectId + "'";
        }
        if (projectName != null && !projectName.equals("")){
            sql += "and projectName like '%" + projectName + "%'";
        }
        if (projectType != null && !projectType.equals("")){
            sql += "and projectType='" + projectType + "'";
        }
        if (projectScale != null && !projectScale.equals("")){
            sql += "and projectScale='" + projectScale + "'";
        }
        if (startTime != null && !startTime.equals("")){
            sql += "and startTime<'" + startTime + "'";
        }
        if (endTime != null && !endTime.equals("")){
            sql += "and endTime<'" + endTime + "'";
        }
        final String finalSql = sql;
        List list = this.getHibernateTemplate().executeFind(
                new HibernateCallback() {
                    public Object doInHibernate(Session session) {
                        Query query = session.createQuery(finalSql);
                        query.setFirstResult((page-1)*limit);
                        query.setMaxResults(limit);
                        return query.list();
                    }
                }
        );
        if (list.size()>0){
            return list;
        }else{
            return null;
        }
    }

    @Override
    public int getProjectCount (String projectId, String projectName, String projectType, String projectScale, String startTime, String endTime){
        String sql = "from Project where isDelete='0'";
        if (projectId != null && !projectId.equals("")){
            sql += "and projectId='" + projectId + "'";
        }
        if (projectName != null && !projectName.equals("")){
            sql += "and projectName like '%" + projectName + "%'";
        }
        if (projectType != null && !projectType.equals("")){
            sql += "and projectType='" + projectType + "'";
        }
        if (projectScale != null && !projectScale.equals("")){
            sql += "and projectScale='" + projectScale + "'";
        }
        if (startTime != null && !startTime.equals("")){
            sql += "and startTime<'" + startTime + "'";
        }
        if (endTime != null && !endTime.equals("")){
            sql += "and endTime<'" + endTime + "'";
        }
        List list = this.getHibernateTemplate().find(sql);
        return list.size();
    }

    @Override
    public String addProject(Project project) {
        this.getHibernateTemplate().save(project);
        return "success";
    }
}
