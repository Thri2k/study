package com.sun.curd.bean;

public class Employee {
    private Integer empId;

    private String empName;

    private Integer empSex;

    private String deptName;

    private Integer deptId;

    private String empCard;

    private String empJob;

    private String empAddress;

    private String empTelnumber;

    private String empDate;

    private Integer empMoney;

   

	public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName == null ? null : empName.trim();
    }

    public Integer getEmpSex() {
        return empSex;
    }

    public void setEmpSex(Integer empSex) {
        this.empSex = empSex;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getEmpCard() {
        return empCard;
    }

    public void setEmpCard(String empCard) {
        this.empCard = empCard == null ? null : empCard.trim();
    }

    public String getEmpJob() {
        return empJob;
    }

    public void setEmpJob(String empJob) {
        this.empJob = empJob == null ? null : empJob.trim();
    }

    public String getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress == null ? null : empAddress.trim();
    }

    public String getEmpTelnumber() {
        return empTelnumber;
    }

    public void setEmpTelnumber(String empTelnumber) {
        this.empTelnumber = empTelnumber == null ? null : empTelnumber.trim();
    }

    public String getEmpDate() {
        return empDate;
    }

    public void setEmpDate(String empDate) {
        this.empDate = empDate == null ? null : empDate.trim();
    }

    public Integer getEmpMoney() {
        return empMoney;
    }

    public void setEmpMoney(Integer empMoney) {
        this.empMoney = empMoney;
    }

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSex=" + empSex + ", deptName=" + deptName
				+ ", deptId=" + deptId + ", empCard=" + empCard + ", empJob=" + empJob + ", empAddress=" + empAddress
				+ ", empTelnumber=" + empTelnumber + ", empDate=" + empDate + ", empMoney=" + empMoney + "]";
	}
    
}