/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ghaith al Zein and Hussam Kanaan
 */
public class Student extends Person {

    public String ID;
    public String major;
    public double GPA;
    public int cc;//completed credits

    public Student(String Fname, String Lname, String dob, String address, int phone) {
        super(Fname, Lname, dob, address, phone);
    }

    public Student(String Fname, String Lname, String dob, String address, int phone, String ID, String major, double GPA, int cc) {
        super(Fname, Lname, dob, address, phone);
        this.ID = ID;
        this.major = major;
        this.GPA = GPA;
        this.cc = cc;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    @Override
    public String toString() {
        return super.toString() + " " + ID + " " + major + " " + GPA + " " + cc;
    }

}