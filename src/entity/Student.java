package entity;

import java.io.Serializable;
import java.time.LocalDate;

// defining student POJO
public class Student implements Serializable {

    private String rollNo;
    private String name;
    private LocalDate dob;
    private String gender;
    private String address;

    public void setName(String name) {
        this.name = name;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public Student(){

    }

    public Student( String rollNo,String name, LocalDate dob, String gender, String address) {
        this.name = name;
        this.rollNo = rollNo;
        this.dob = dob;
        this.gender = gender;
        this.address = address;
    }

    public Student( String rollNo,String name,String gender,String address){
        this.name = name;
        this.rollNo = rollNo;
        this.gender=gender;
        this.address=address;
    }
    public String getName() {
        return name;
    }

    public String getRollNo() {
        return rollNo;
    }
    
    public LocalDate getDob() {
        return dob;
    }
     
    public String getGender() {
        return gender;
    }
        
    public String getAddress() {
        return address;
    }
    
    @Override
    public String toString(){
        return  rollNo+" "+name+ " "+ dob +" "+ gender+" "+address;
    }
    

}
