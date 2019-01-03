package com.test.ssh.service.impl;

import com.test.ssh.dao.DepartmentDao;
import com.test.ssh.domain.Department;
import com.test.ssh.service.DepartmentService;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentDao departmentDao;

    @Override
    public List<Department> getDepts(){
       return departmentDao.getDepts();
    }

    public void setDepartmentDao(DepartmentDao departmentDao){
        this.departmentDao = departmentDao;
    }


}
