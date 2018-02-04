package com.hrms.vsoni.hrms;

/**
 * Created by vishwesh on 23/1/18.
 */


public class SalaryBin {
    private String Month,Year,Rupees;
    public SalaryBin(){}
    public SalaryBin(String Month,String Year,String Rupees){
         this.Month=Month;
         this.Year=Year;
         this.Rupees=Rupees;
    }
    public String getMonth(){
         return Month;
    }
    public void setMonth(String Month){
         this.Month=Month;
    }

    public String getYear() {
        return Year;
    }


    public void setYear(String year) {
        Year = year;
    }

    public String getRupees() {
        return Rupees;
    }

    public void setRupees(String rupees) {
        Rupees = rupees;
    }
}
