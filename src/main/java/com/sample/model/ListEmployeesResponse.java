package com.sample.model;

import java.util.List;

public class ListEmployeesResponse extends Status{

    private List employeeList;

    public ListEmployeesResponse(List employeeList) {
        this.employeeList = employeeList;
    }

    public ListEmployeesResponse(int code, String message, String statusType, List employeeList) {
        super(code, message, statusType);
        this.employeeList = employeeList;
    }

    public List getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List employeeList) {
        this.employeeList = employeeList;
    }
}
