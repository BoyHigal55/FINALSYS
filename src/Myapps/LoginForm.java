/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Myapps;

import Admin.ManagerDash;
import Config.DbConnector;
import Config.PasswordHasher;
import Config.Session;
import USERS.UserDash;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author AJ
 */
public class LoginForm extends javax.swing.JFrame {

    /**
     * Creates new form LoginForm
     */
    public LoginForm() {
        initComponents();
    }
    
    static String status;
    static String type;
    
    public static boolean loginAcc(String username, String password){
        DbConnector connector = new DbConnector();
  
        try{
            String query = "SELECT * FROM tbl_user  WHERE username = '" + username + "'";
            ResultSet resultSet = connector.getData(query);
            if(resultSet.next()){ 
                
                String hashedPass =resultSet.getString("password");
                String rehashedPass = PasswordHasher.hashPassword(password);
                
                if(hashedPass.equals(rehashedPass)){
                status=resultSet.getString("user_status");
                type=resultSet.getString("user_account");
                Session sn = Session.getInstance();
                    sn.setUid(resultSet.getInt("user_id"));
                    sn.setFname(resultSet.getString("user_firstname"));
                    sn.setLname(resultSet.getString("user_lastname"));
                    sn.setUname(resultSet.getString("username"));
                    sn.setEmail(resultSet.getString("user_email"));
                    sn.setType(resultSet.getString("user_account"));
                    sn.setStatus(resultSet.getString("user_status")); 
                    System.out.println(""+sn.getUid());
                return true;
            }else{
                return false;
            }
            }else{
                return false;
            }
        }catch (NoSuchAlgorithmException | SQLException ex) {
            return false;
        }    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        signup = new javax.swing.JButton();
        ckbox = new javax.swing.JCheckBox();
        username = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        login = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("X");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 10, 31, -1));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 255, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Email (username)");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 100, 20));

        signup.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        signup.setForeground(new java.awt.Color(51, 255, 51));
        signup.setText("SIGNUP");
        signup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signupMouseClicked(evt);
            }
        });
        jPanel2.add(signup, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 163, 80, 30));

        ckbox.setBackground(new java.awt.Color(51, 255, 51));
        ckbox.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        ckbox.setForeground(new java.awt.Color(255, 255, 255));
        ckbox.setText(" View Password");
        ckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckboxActionPerformed(evt);
            }
        });
        jPanel2.add(ckbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 109, 110, 20));

        username.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        username.setForeground(new java.awt.Color(51, 255, 0));
        username.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 0), 2));
        jPanel2.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 42, 280, 30));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 255, 51));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Password ");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 78, 80, -1));

        password.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        password.setForeground(new java.awt.Color(51, 255, 0));
        password.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 0), 2));
        jPanel2.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 103, 280, 31));

        login.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        login.setForeground(new java.awt.Color(51, 255, 51));
        login.setText("LOGIN");
        login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginMouseClicked(evt);
            }
        });
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        jPanel2.add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 163, 80, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 470, 520, 200));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/12344 (2).jpg"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        int a = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Confirm Exit", JOptionPane.YES_NO_OPTION);
            if(a == JOptionPane.YES_OPTION){
                  System.exit(0);     
            }
    }//GEN-LAST:event_jLabel5MouseClicked

    private void signupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signupMouseClicked
          RegisterForm rf = new RegisterForm();
        rf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_signupMouseClicked

    private void ckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckboxActionPerformed
       if(ckbox.isSelected()){
            password.setEchoChar((char)0);
        }else{
            password.setEchoChar('*');
        }
    }//GEN-LAST:event_ckboxActionPerformed

    private void loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMouseClicked
       if(loginAcc(username.getText(),password.getText())){
            if(!status.equals("Active")){
                JOptionPane.showMessageDialog(null,"In-Active Account, Contact the Manager","Warning", JOptionPane.WARNING_MESSAGE);
            }else{
                if(type.equals("Manager")){
                    JOptionPane.showMessageDialog(null,"Login Success!");
                    ManagerDash ad = new ManagerDash();
                    ad.setVisible(true);
                    this.dispose();
                }else if(type.equals("User")){
                    JOptionPane.showMessageDialog(null,"Login Success!");
                    UserDash ad = new UserDash();
                    ad.setVisible(true);
                    this.dispose();
                }else{
                    JOptionPane.showMessageDialog(null,"No account type found, Contact the Manager","Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        }else{
            JOptionPane.showMessageDialog(null,"Invalid Account","Login Active Account", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_loginMouseClicked

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginActionPerformed

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
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox ckbox;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton login;
    private javax.swing.JPasswordField password;
    private javax.swing.JButton signup;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
