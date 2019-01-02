package com.test.ssh.dao.impl;

import com.test.ssh.dao.GroupDao;
import com.test.ssh.domain.Groupofdepartment;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.ArrayList;
import java.util.List;

public class GroupDaoImpl extends HibernateDaoSupport implements GroupDao {

    @Override
    public List<Groupofdepartment> getGroups(Groupofdepartment group) {
        List<Groupofdepartment> resultList;
        StringBuffer sql = new StringBuffer("from Groupofdepartment where isDelete='0'");
        if (group.getDepartment() != 0) {
            sql.append(" and department =" + group.getDepartment());
        }
        if (group.getGroupId() != 0) {
            sql.append(" and groupId =" + group.getGroupId());
        }
        List<Groupofdepartment> list = this.getHibernateTemplate().find(sql.toString());
        resultList = (list.size() > 0) ? list : new ArrayList<Groupofdepartment>();
        return resultList;
    }
}
