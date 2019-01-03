package com.test.ssh.service;

import com.test.ssh.domain.Groupofdepartment;

import java.util.List;

public interface GroupService {
    List<Groupofdepartment> getGroups(Groupofdepartment group, int page, int limit);
    int getGroupCount(Groupofdepartment group);
    Groupofdepartment getGroupById(int groupId);
    List<Groupofdepartment> getGroupByDept(int departmentId);
}
