package com.test.ssh.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.test.ssh.domain.Employee;
import com.test.ssh.domain.modelResult.EmployeeResult;
import com.test.ssh.service.EmployeeService;
import com.test.ssh.utils.ExcelUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeAction extends ActionSupport implements ModelDriven<Employee> {

    //文件导入
    private File file;
    private String fileFileName;
    private String fileContentType;

    //前端传入参数
    private Employee employee = new Employee();
    private int page = 1;
    private int limit = 10;
    private ArrayList<String> employeeIds;

    //后台返回结果
    private JSONObject getEmployeesJson;
    private JSONObject delEmployeesJson;
    private JSONObject addEmployeeJson;
    private JSONObject importEmployeesJson;


    private EmployeeService employeeService;

    @Override
    public Employee getModel() {
        return employee;
    }

    //获取职员信息
    public String getEmployees() {
        List<EmployeeResult> employeeResults = employeeService.getEmployees(employee, page, limit);
        Map<String, Object> result = new HashMap<String, Object>();
        JSONArray array = new JSONArray();
        if (employeeResults != null && employeeResults.size() > 0) {
            array = JSONArray.fromObject(employeeResults);
            result.put("code", 0);
            result.put("msg", "success");
            result.put("count",employeeResults.size());
            result.put("data", array);
        } else {
            result.put("code", 0);
            result.put("msg", "error");
            result.put("count",0);
            result.put("data", array);
        }
        setGetEmployeesJson(JSONObject.fromObject(result));
        return SUCCESS;
    }

    //删除职员信息
    public String delEmployees() {
        Map<String, String> result = new HashMap<String, String>();
        String backMsg = employeeService.delEmployeeByIds(employeeIds);
        result.put("msg", backMsg);
        setDelEmployeesJson(JSONObject.fromObject(result));
        return SUCCESS;
    }

    //添加职员信息
    public String addEmployee() {
        Map<String, String> result = new HashMap<String, String>();
        String backMsg = employeeService.addEmployee(employee);
        result.put("msg", backMsg);
        setAddEmployeeJson(JSONObject.fromObject(result));
        return SUCCESS;
    }

    //导入职员信息
    public String importEmployees() {
        Map<String, String> result = new HashMap<String, String>();
        try {
            //将导入文件临时保存在out文件夹temp文件夹下
            String root = ServletActionContext.getServletContext().getRealPath("temp");
            FileInputStream fis;
            FileOutputStream fos;
            // 得到文件保存的位置(根据root来得到文件保存的路径在tomcat下的该工程里)
            File destFile = new File(root, fileFileName);
            // fis中保存了文件的内容
            fis = new FileInputStream(getFile());
            fos = new FileOutputStream(destFile);
            // 把文件写入到上面设置的路径里
            byte[] buffer = new byte[512];
            int length = 0;
            while ((length = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, length);
            }
            fis.close();
            fos.close();
            //文件在服务器上保存的绝对路径
            String path = root + "\\" + fileFileName;
            List<Employee> employeeList = ExcelUtils.excelToEmployeeList(path);
            String backMsg = employeeService.importEmployees(employeeList);
            result.put("msg", backMsg);

        }  catch (IOException e) {
            result.put("msg",e.toString());
        }
        setImportEmployeesJson(JSONObject.fromObject(result));
        return SUCCESS;
    }

    //

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public JSONObject getGetEmployeesJson() {
        return getEmployeesJson;
    }

    public void setGetEmployeesJson(JSONObject getEmployeesJson) {
        this.getEmployeesJson = getEmployeesJson;
    }

    public void setDelEmployeesJson(JSONObject delEmployeesJson) {
        this.delEmployeesJson = delEmployeesJson;
    }

    public JSONObject getDelEmployeesJson() {
        return delEmployeesJson;
    }

    public ArrayList<String> getEmployeeIds() {
        return employeeIds;
    }

    public void setEmployeeIds(ArrayList<String> employeeIds) {
        this.employeeIds = employeeIds;
    }

    public JSONObject getAddEmployeeJson() {
        return addEmployeeJson;
    }

    public void setAddEmployeeJson(JSONObject addEmployeeJson) {
        this.addEmployeeJson = addEmployeeJson;
    }

    public JSONObject getImportEmployeesJson() {
        return importEmployeesJson;
    }

    public void setImportEmployeesJson(JSONObject importEmployeesJson) {
        this.importEmployeesJson = importEmployeesJson;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    public String getFileContentType() {
        return fileContentType;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }
}
