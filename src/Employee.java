/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ghaith al Zein and Hussam Kanaan
 */
public class Employee extends Person {

    public String ID;
    public double salary;
    public double extension;

    public Employee(String Fname, String Lname, String dob, String address, int phone, String ID, double salary, double extension) {
        super(Fname, Lname, dob, address, phone);
        this.ID = ID;
        this.salary = salary;
        this.extension = extension;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString() + " " + ID + " " + salary + " " + extension;
    }

}
