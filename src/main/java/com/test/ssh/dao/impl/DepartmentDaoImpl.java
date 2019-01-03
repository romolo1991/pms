package com.test.ssh.dao.impl;

import com.test.ssh.dao.DepartmentDao;
import com.test.ssh.domain.Department;


import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;


public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao {
    @Override
    public List<Department> getDept() {
        String sql = "from Department where isDelete='0'";
        List<Department> list = this.getHibernateTemplate().find(sql);
        if(list.size()>0){
            return list;
        }
        else {
            return null;
        }

    }

    @Override
    public String addDept (Department department){
        String addResult;
        try{
            this.getHibernateTemplate().save(department);
            addResult = "success";

        }
        catch(Exception e){
            addResult = "fail";
            System.out.println(e);

        }
        return addResult;

    }


    @Override
    public String editDept (Department department){
        String editResult;

        try{
            Department department1 = this.getHibernateTemplate().get(Department.class, department.getDepartmentId());
            if(department1.equals(department)){
                editResult="noDataModify";
            }
            else {
                department1.setDepartmentName(department.getDepartmentName());
                department1.setChief(department.getChief());
                department1.setDepartmentIntro(department.getDepartmentIntro());
                this.getHibernateTemplate().update(department1);
                editResult = "success";
            }

        }
        catch (Exception e){
            editResult = "fail";
            System.out.println(e);

        }

        return editResult;

    }



    @Override
    public String verifyDepartmentId(int departmentId){

        String verifyResult="";
        String sql = "from Department where departmentId = ? and isDelete= '0' ";

        try{
            List<Department> list = this.getHibernateTemplate().find(sql,departmentId);
            if(list.size()> 0){
                //部门编号存在
                verifyResult="exist";
            }
            else{
                //部门编号不存在
                verifyResult="inexistent";
            }
        }
        catch (Exception e){
            System.out.println(e);

        }
        return verifyResult;

    }

}
