package com.test.ssh.domain;

public class Department {
    private int departmentId;
    private String departmentName;
    private String departmentIntro;
    private String  chief;
    private char isDelete;

    public void setDepartmentId(int departmentId){ this.departmentId = departmentId;}

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentName(String departmentName){ this.departmentName = departmentName;}

    public String getDepartmentName(){ return departmentName; }

    public void setChief(String chief){this.chief=chief;}

    public String getChief(){return chief;}

    public String getDepartmentIntro(){return departmentIntro;}

    public void setDepartmentIntro(String departmentIntro){this.departmentIntro = departmentIntro;}

    public void setIsDelete(char isDelete){this.isDelete=isDelete;}

    public char getIsDelete(){return isDelete;}



}
