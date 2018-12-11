package com.test.ssh.service;

import com.test.ssh.domain.Groupofdepartment;

import java.util.List;

public interface GroupService {
    List<Groupofdepartment> getGroups(Groupofdepartment group);
}
