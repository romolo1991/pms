package com.test.ssh.service.impl;

import com.test.ssh.dao.GroupDao;
import com.test.ssh.domain.Groupofdepartment;
import com.test.ssh.service.GroupService;

import java.util.List;

public class GroupServiceImpl implements GroupService {

    private GroupDao groupDao;

    public void setGroupDao(GroupDao groupDao){
        this.groupDao = groupDao;
    }

    @Override
    public List<Groupofdepartment> getGroups(Groupofdepartment group) {
        if (group.getDepartment()==0)
            return null;
        else
            return groupDao.getGroups(group);
    }


}
