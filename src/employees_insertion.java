
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ghaith al Zein and Hussam Kanaan
 */
public class employees_insertion extends javax.swing.JFrame {

    /**
     * Creates new form employees_insertion
     */
    Employees e = new Employees();

    public employees_insertion() {
        initComponents();
        this.setSize(680, 600);
        this.setLocation(150, 25);
        this.setTitle("Employee_insertion");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        employee_birth = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        save = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        employee_first_name = new javax.swing.JTextField();
        employee_address = new javax.swing.JTextField();
        employee_last_name = new javax.swing.JTextField();
        employee_id = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        employee_salary = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        employee_extension = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        employee_phone = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setText("Phone        :");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(10, 344, 94, 22);
        getContentPane().add(employee_birth);
        employee_birth.setBounds(122, 400, 536, 35);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setText("Extension   :");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(10, 307, 96, 22);

        save.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        getContentPane().add(save);
        save.setBounds(122, 497, 125, 40);

        back.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back);
        back.setBounds(534, 497, 124, 40);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setText("DOB          :");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(10, 404, 94, 22);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setText("Address     :");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(10, 455, 94, 28);
        getContentPane().add(employee_first_name);
        employee_first_name.setBounds(124, 91, 534, 35);
        getContentPane().add(employee_address);
        employee_address.setBounds(122, 453, 536, 33);
        getContentPane().add(employee_last_name);
        employee_last_name.setBounds(124, 144, 534, 35);
        getContentPane().add(employee_id);
        employee_id.setBounds(124, 197, 534, 35);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("First Name :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 95, 96, 31);
        getContentPane().add(employee_salary);
        employee_salary.setBounds(124, 250, 534, 35);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("Last Name :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 148, 96, 31);
        getContentPane().add(employee_extension);
        employee_extension.setBounds(124, 303, 534, 35);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("ID              :");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 201, 96, 31);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("Salary        :");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 254, 96, 31);
        getContentPane().add(employee_phone);
        employee_phone.setBounds(122, 344, 536, 35);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/2.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(6, -3, 660, 620);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        FileReader em_file;
        String s;
        String[] arr;
        boolean checkBirth = false;
        try {
            em_file = new FileReader("Employees.txt");
            BufferedReader br = new BufferedReader(em_file);

            while ((s = br.readLine()) != null) {
                arr = s.split(" ");
                Employee employee = new Employee(arr[0], arr[1], arr[2], arr[3], (int) Integer.parseInt(arr[4]), arr[5], Double.parseDouble(arr[6]), Double.parseDouble(arr[7]));
                e.add_old_Employee(employee);
            }
            br.close();
        } catch (IOException e) {

            JOptionPane.showMessageDialog(null, e.getMessage(), "Wrong User", JOptionPane.WARNING_MESSAGE);
        }

        //the above code is to return the old array of Employees.
        boolean characters_in_id = false;
        if (employee_first_name.getText().isEmpty() || employee_last_name.getText().isEmpty() || employee_id.getText().isEmpty() || employee_birth.getText().isEmpty() || employee_address.getText().isEmpty() || employee_phone.getText().isEmpty() || employee_salary.getText().isEmpty() || employee_extension.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill out all required information", "Missed Information", JOptionPane.WARNING_MESSAGE);

        } else {
            for (int i = 0; i < employee_id.getText().length(); i++) {
                if (Character.isLetter(employee_id.getText().charAt(i))) {
                    characters_in_id = true;
                    JOptionPane.showMessageDialog(this, "Please enter numbers only in the ID field", "Invalid ID", JOptionPane.WARNING_MESSAGE);
                    break;

                }
            }
            if (characters_in_id == false) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyy");
                try {
                    Date birthDate = sdf.parse(employee_birth.getText());
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(this, "Please enter the date of birth in this form(dd/mm/yyy)", "Invalid Date Of Birth", JOptionPane.WARNING_MESSAGE);
                    checkBirth = true;
                }

                if (!checkBirth) {
                    if (e.check_ID(employee_id.getText())) {

                        Employee em = new Employee(employee_first_name.getText(), employee_last_name.getText(), employee_birth.getText(), employee_address.getText(), (int) Integer.parseInt(employee_phone.getText()), employee_id.getText(), Double.parseDouble(employee_salary.getText()), Double.parseDouble(employee_extension.getText()));
                        e.addEmployee(em);

                    } else {
                        JOptionPane.showMessageDialog(this, "You can not insert two students with the same ID", "Invalid ID", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
        manage_employees me = new manage_employees(e);
    }//GEN-LAST:event_saveActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        starting_page sp = new starting_page();
        sp.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_backActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(employees_insertion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(employees_insertion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(employees_insertion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(employees_insertion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new employees_insertion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JTextField employee_address;
    private javax.swing.JTextField employee_birth;
    private javax.swing.JTextField employee_extension;
    private javax.swing.JTextField employee_first_name;
    private javax.swing.JTextField employee_id;
    private javax.swing.JTextField employee_last_name;
    private javax.swing.JTextField employee_phone;
    private javax.swing.JTextField employee_salary;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton save;
    // End of variables declaration//GEN-END:variables
}
