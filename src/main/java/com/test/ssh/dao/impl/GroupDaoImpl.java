package com.test.ssh.dao.impl;

import com.test.ssh.dao.GroupDao;
import com.test.ssh.domain.Groupofdepartment;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import sun.security.ssl.Debug;

import java.util.ArrayList;
import java.util.List;

public class GroupDaoImpl extends HibernateDaoSupport implements GroupDao {

    public String getAllGroupsSql(Groupofdepartment group){
        String sql = "from Groupofdepartment where isDelete='0'";
        if (group.getDepartment() != 0){
            sql += " and department='" + group.getDepartment() + "'";
        }
        if (group.getGroupId() != 0){
            sql += " and groupId='" + group.getGroupId() + "'";
        }
        return sql;
    }

    @Override
    public List<Groupofdepartment> getGroups(Groupofdepartment group, final int page, final int limit) {
        String sql = getAllGroupsSql(group);
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
        if (list.size()>0){
            return list;
        }else {
            return null;
        }
    }

    @Override
    public int getGroupCount(Groupofdepartment group) {
        String sql = getAllGroupsSql(group);
        List list = this.getHibernateTemplate().find(sql);
        return list.size();
    }

    @Override
    public Groupofdepartment getGroupById(int groupId) {
        String sql = "from Groupofdepartment where isDelete='0'";
        if (groupId != 0){
            sql += " and groupId='" + groupId + "'";
            List<Groupofdepartment> result = this.getHibernateTemplate().find(sql);
            if (result.size()>0){
                return result.get(0);
            }
        }
        return null;
    }

    @Override
    public List<Groupofdepartment> getGroupByDept(int departmentId) {
        String sql = "from Groupofdepartment where isDelete='0'";
        if (departmentId != 0){
            sql += " and department='" + departmentId + "'";
            List<Groupofdepartment> result = this.getHibernateTemplate().find(sql);
            if (result.size()>0){
                return result;
            }
        }
        return null;
    }
}
