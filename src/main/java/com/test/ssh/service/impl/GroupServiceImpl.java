package com.test.ssh.service.impl;

import com.test.ssh.dao.GroupDao;
import com.test.ssh.domain.Groupofdepartment;
import com.test.ssh.service.GroupService;

import java.util.List;

public class GroupServiceImpl implements GroupService {

    private GroupDao groupDao;

    public void setGroupDao(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    @Override
    public List<Groupofdepartment> getGroups(Groupofdepartment group, int page, int limit) {
        return groupDao.getGroups(group, page, limit);
    }

    @Override
    public int getGroupCount(Groupofdepartment group) {
        return groupDao.getGroupCount(group);
    }

    @Override
    public Groupofdepartment getGroupById(int groupId) {
        return groupDao.getGroupById(groupId);
    }

    @Override
    public List<Groupofdepartment> getGroupByDept(int departmentId) {
        return groupDao.getGroupByDept(departmentId);
    }

}
