package com.test.ssh.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.test.ssh.domain.Department;
import com.test.ssh.service.DepartmentService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DepartmentAction extends ActionSupport implements ModelDriven<Department> {

    private Department department = new Department();

    private DepartmentService departmentService;

    @Override
    public Department getModel() {
        return department;
    }

    private JSONObject deptsJson;

    private List<Department> departmentList;

    public String getDepts(){
        List<Department> depts = departmentService.getDepts();
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", 0);
        result.put("msg", "");
        if (depts != null){
            result.put("count", depts.size());
        }else{
            result.put("count", 0);
        }
        JSONArray array = JSONArray.fromObject(depts);
        result.put("data", array);
        deptsJson = JSONObject.fromObject(result);
        return SUCCESS;
    }

    public String getAllDepartments() {
        List<Department> departmentList = departmentService.getDepts();
        Department department = new Department();
        department.setDepartmentId(0);
        department.setDepartmentName("请选择部门");
        departmentList.add(0,department);
        setDepartmentList(departmentList);
        return SUCCESS;
    }


    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList){
        this.departmentList = departmentList;
    }

    public JSONObject getDeptsJson() {
        return deptsJson;
    }

    public void setDeptsJson(JSONObject deptsJson) {
        this.deptsJson = deptsJson;
    }


}
