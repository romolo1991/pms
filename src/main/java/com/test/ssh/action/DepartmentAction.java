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

    private List<Department> departmentList;

    @Override
    public Department getModel() {
        return department;
    }

    private JSONObject deptJson;

    //获取部门信息
    public String getDeptInfo(){

        List<Department> depts = departmentService.getDept();
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", 0);
        result.put("msg", "");
        if (depts != null){
            result.put("count", depts.size());
        }else{
            result.put("msg", "暂无数据");
            result.put("count", 0);
        }
        JSONArray array = JSONArray.fromObject(depts);
        result.put("data", array);
        deptJson = JSONObject.fromObject(result);
        return SUCCESS;

    }

    //增加部门
    public String addDept(){

        department.setIsDelete("0");
        Map<String, Object> result = new HashMap<String, Object>();
        String addResult = departmentService.addDept(department);
        result.put("msg",addResult);
        deptJson = JSONObject.fromObject(result);
        return SUCCESS;

    }


    //修改部门信息
    public String editDept(){

        Map<String, Object> result = new HashMap<String, Object>();
        department.setIsDelete("0");
        String editResult = departmentService.editDept(department);
        result.put("msg",editResult);
        deptJson = JSONObject.fromObject(result);
        return SUCCESS;

    }


    //验证新建部门中的部门id
    public String verifyDepartmentId(){

        Map<String, Object> result = new HashMap<String, Object>();
        int departmentId = department.getDepartmentId();
        String verifyResult = departmentService.verifyDepartmentId(departmentId);
        result.put("msg",verifyResult);
        deptJson = JSONObject.fromObject(result);
        return SUCCESS;

    }


    public String getAllDepartments() {

        List<Department> departmentList = departmentService.getDept();
        Department department = new Department();
        department.setDepartmentId(0);
        department.setDepartmentName("请选择部门");
        departmentList.add(0,department);
        setDepartmentList(departmentList);
        return SUCCESS;

    }


    public void setDepartmentList(List<Department> departmentList){
        this.departmentList = departmentList;
    }


    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public JSONObject getDeptJson() {
        return deptJson;
    }

    public void setDeptJson(JSONObject deptJson) {
        this.deptJson = deptJson;
    }


}
