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
public class Students {

    private ArrayList<Student> l_students = new ArrayList<>();
    StringBuilder sb;

    public Students() {
    }

    public ArrayList<Student> getL_students() {
        return l_students;
    }

    public void setL_students(ArrayList<Student> l_students) {
        this.l_students = l_students;
    }

    public int get_Nb() {
        String s;
        int number_of_students = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader("Students.txt"));
            while ((s = br.readLine()) != null) {
                number_of_students++;
            }
            br.close();
        } catch (IOException m) {

            JOptionPane.showMessageDialog(null, m.getMessage(), "Wrong User", JOptionPane.WARNING_MESSAGE);
        }
        return number_of_students;
    }

    public void add_old_student(Student st) {
        l_students.add(st);
    }

    public void addStudent(Student st) {
        try {
            FileWriter students_file = new FileWriter("Students.txt", true);
            l_students.add(st);
            students_file.write(st.toString() + "\r\n");
            students_file.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Wrong User", JOptionPane.WARNING_MESSAGE);
        }
    }

    public boolean check_ID(String id) {
        for (Student l_student : l_students) {
            if (l_student.getID().equals(id)) {
                return false;
            }
        }
        return true;
    }

    public void deleteStudent(String id, Students st) {
        st.getL_students().clear();
        File st_file;
        String s;
        String[] arr;
        try {
            BufferedReader br = new BufferedReader(new FileReader("Students.txt"));
            sb = new StringBuilder("");
            while ((s = br.readLine()) != null) {
                arr = s.split(" ");
                if (arr[5].equals(id)) {
                    continue;
                }
                sb.append(s).append("\r\n");
            }
            br.close();
            st_file = new File("Students.txt");
            st_file.delete();
        } catch (IOException m) {

            JOptionPane.showMessageDialog(null, m.getMessage(), "Wrong User", JOptionPane.WARNING_MESSAGE);
        }
        try {
            FileWriter fw = new FileWriter(("Students.txt"), true);
            //Write entire string buffer into the file
            fw.write(sb.toString());
            fw.close();
        } catch (IOException m) {
            System.out.println(m.getMessage());
        }

    }

    public void show_Student(String id) {
        String s;
        String[] arr;
        try {
            BufferedReader br = new BufferedReader(new FileReader("Students.txt"));

            while ((s = br.readLine()) != null) {
                arr = s.split(" ");
                if (arr[5].equals(id)) {
                    JTable table = new JTable(1, 9);
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
                    table.getColumnModel().getColumn(6).setHeaderValue("Major");
                    table.getColumnModel().getColumn(7).setHeaderValue("GPA");
                    table.getColumnModel().getColumn(8).setHeaderValue("Copmleted_Credits");
                    int a = 0;
                    for (int i = 0; i < 1; i++) {
                        for (int j = 0; j < 9; j++) {
                            table.setValueAt(arr[a], i, j);
                            a = a + 1;
                        }
                    }

                }

            }
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
            BufferedReader br = new BufferedReader(new FileReader("Students.txt"));

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

    }

}
