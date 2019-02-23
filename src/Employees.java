/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Ghaith al Zein and Hussam Kanaan
 */
public class Employees {

    private ArrayList<Employee> l_employees = new ArrayList<>();
    StringBuilder sb;

    public Employees() {
    }

    public ArrayList<Employee> getL_employees() {
        return l_employees;
    }

    public void setL_employees(ArrayList<Employee> l_employees) {
        this.l_employees = l_employees;
    }

    public int get_Nb() {
        String s;
        int number_of_employees = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader("Employees.txt"));
            sb = new StringBuilder("");
            while ((s = br.readLine()) != null) {
                number_of_employees++;
            }
            br.close();
        } catch (IOException m) {
            JOptionPane.showMessageDialog(null, m.getMessage(), "Wrong User", JOptionPane.WARNING_MESSAGE);
        }
        return number_of_employees;
    }

    public void add_old_Employee(Employee em) {
        l_employees.add(em);
    }

    public void addEmployee(Employee em) {
        try {
            FileWriter employees_file = new FileWriter("Employees.txt", true);
            l_employees.add(em);
            employees_file.write(em.toString() + "\r\n");
            employees_file.close();

        } catch (IOException e) {
            System.out.println(e.getMessage() + "Employees.txt");
        }

    }

    public boolean check_ID(String id) {
        for (Employee l_employee : l_employees) {
            if (l_employee.getID().equals(id)) {
                return false;
            }
        }
        return true;
    }

    public void deleteEmployee(String id, Employees e) {
        e.getL_employees().clear();
        File em_file;
        String s;
        String[] arr;
        try {
            BufferedReader br = new BufferedReader(new FileReader("Employees.txt"));
            sb = new StringBuilder("");
            while ((s = br.readLine()) != null) {
                arr = s.split(" ");
                if (arr[5].equals(id)) {
                    continue;//continue because i should not insert the id to the string buffer.
                }
                sb.append(s).append("\r\n");
            }
            br.close();
            em_file = new File("Employees.txt");
            em_file.delete();
        } catch (IOException m) {

            JOptionPane.showMessageDialog(null, m.getMessage(), "Wrong User", JOptionPane.WARNING_MESSAGE);
        }
        try {
            FileWriter fw = new FileWriter(("Employees.txt"), true);
            fw.write(sb.toString()); //Write the entire string buffer into the file.
            fw.close();
        } catch (IOException m) {
            JOptionPane.showMessageDialog(null, m.getMessage(), "Wrong User", JOptionPane.WARNING_MESSAGE);
        }

    }

    public void show_Employee(String id) {
        String s;
        String[] arr;
        try {
            BufferedReader br = new BufferedReader(new FileReader("Employees.txt"));
            while ((s = br.readLine()) != null) {
                arr = s.split(" ");
                if (arr[5].equals(id)) {
                    JTable table = new JTable(1, 8);
                    JFrame f = new JFrame();
                    f.setSize(1100, 600);
                    f.add(new JScrollPane(table));
                    f.setVisible(true);
                    table.getColumnModel().getColumn(0).setHeaderValue("First_name");
                    table.getColumnModel().getColumn(1).setHeaderValue("Last_Name");
                    table.getColumnModel().getColumn(2).setHeaderValue("Date_of_Birth");
                    table.getColumnModel().getColumn(3).setHeaderValue("Address");
                    table.getColumnModel().getColumn(4).setHeaderValue("phone");
                    table.getColumnModel().getColumn(5).setHeaderValue("ID");
                    table.getColumnModel().getColumn(6).setHeaderValue("Salary");
                    table.getColumnModel().getColumn(7).setHeaderValue("Extension");

                    int a = 0;
                    for (int i = 0; i < 1; i++) {
                        for (int j = 0; j < 8; j++) {
                            table.setValueAt(arr[a], i, j);
                            a = a + 1;
                        }//end second loop.
                    }//end first loop.

                }//end if statement for checking id.

            }//end while loop.

            br.close();

        } catch (IOException m) {
            JOptionPane.showMessageDialog(null, m.getMessage(), "Wrong User", JOptionPane.WARNING_MESSAGE);
        }

    }

    public Age show_Age(String id) {
        String s;
        String[] arr;
        Age age = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader("Employees.txt"));

            while ((s = br.readLine()) != null) {
                arr = s.split(" ");
                if (arr[5].equals(id)) {
                    Student student = new Student(arr[0], arr[1], arr[2], arr[3], (int) Integer.parseInt(arr[4]));
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyy");
                    Date birthDate = sdf.parse(arr[2]);
                    age = student.getAge(birthDate);

                }//end if  

            }//end while

            br.close();

        } catch (IOException m) {
            JOptionPane.showMessageDialog(null, m.getMessage(), "Wrong User", JOptionPane.WARNING_MESSAGE);
        } catch (ParseException ex) {
            Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
        }

        return age;

    }//end show age method.

}
