package com.test.ssh.dao;

import com.test.ssh.domain.Groupofdepartment;

import java.util.List;

public interface GroupDao {
    List<Groupofdepartment> getGroups(Groupofdepartment group, final int page, final int limit);
    int getGroupCount(Groupofdepartment group);
    Groupofdepartment getGroupById(int groupId);
    List<Groupofdepartment> getGroupByDept(int departmentId);
}
