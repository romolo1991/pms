package com.test.ssh.service.impl;

import com.test.ssh.dao.DepartmentDao;
import com.test.ssh.domain.Department;
import com.test.ssh.service.DepartmentService;
import net.sf.json.JSONObject;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentDao departmentDao;

    @Override
    public List<Department> getDept(){
        return departmentDao.getDept();
    }

    public void setDepartmentDao(DepartmentDao departmentDao){
        this.departmentDao = departmentDao;
    }

    @Override
    public String addDept(Department department){
        return departmentDao.addDept(department);
    }

    @Override
    public String editDept(Department department){
        return departmentDao.editDept(department);
    }

    @Override
    public String verifyDepartmentId(int departmentId){
        return departmentDao.verifyDepartmentId(departmentId);
    }


}
