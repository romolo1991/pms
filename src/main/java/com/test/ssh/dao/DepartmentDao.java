package com.test.ssh.dao;

import com.test.ssh.domain.Department;
import net.sf.json.JSONObject;

import java.util.List;

public interface DepartmentDao {
    public List<Department> getDept();
    public String addDept(Department department);
    public String editDept(Department department);
    public String verifyDepartmentId(int departmentId);
}
