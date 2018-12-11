package com.test.ssh.dao;

import com.test.ssh.domain.Groupofdepartment;

import java.util.List;

public interface GroupDao {
    List<Groupofdepartment> getGroups(Groupofdepartment group);
}
