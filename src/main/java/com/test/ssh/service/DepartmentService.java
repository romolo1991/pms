package com.test.ssh.service;

import com.test.ssh.domain.Department;



import java.util.List;

public interface DepartmentService {

    public List<Department> getDept();
    public String addDept(Department department);
    public String editDept(Department department);
    public String verifyDepartmentId(int departmentId);

}
