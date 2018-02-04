package com.hrms.vsoni.hrms;

/**
 * Created by vishwesh on 3/2/18.
 */

public class LeaveAppBean {
    private String leaveAppNumber;
    private String startDate;
    private String endDate;
    private String mgrName;
    private String typeOfLeave;
    private  String noOfLeave;
    private String status;

    public String getLeaveAppNumber() {
        return leaveAppNumber;
    }

    public void setLeaveAppNumber(String leaveAppNumber) {
        this.leaveAppNumber = leaveAppNumber;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getMgrName() {
        return mgrName;
    }

    public void setMgrName(String mgrName) {
        this.mgrName = mgrName;
    }

    public String getTypeOfLeave() {
        return typeOfLeave;
    }

    public void setTypeOfLeave(String typeOfLeave) {
        this.typeOfLeave = typeOfLeave;
    }

    public String getNoOfLeave() {
        return noOfLeave;
    }

    public void setNoOfLeave(String noOfLeave) {
        this.noOfLeave = noOfLeave;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
