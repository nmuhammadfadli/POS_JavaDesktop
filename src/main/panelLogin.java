package main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static main.gbrandapplication.accessHome;
import static main.gbrandapplication.getNotify;
import static main.gbrandapplication.mainAccessPanel;
import static main.panelHome.homeAdministrator;
import static main.panelHome.homeKaryawan;
import service.connect;
import static main.panelHome.fieldEmailProfile;
import static main.panelHome.fieldIDPenggunaProfile;
import static main.panelHome.fieldNamaProfile;
import static main.panelHome.fieldNoTelphoneProfile;
import static main.panelHome.fieldPasswordProfile;
import static main.panelHome.fieldTipeAkunProfile;
import static main.panelHome.fieldUsernameProfile;
import static main.panelHome.textPaneAlamatProfile;
import system.massage.popup.dialogLupaPassword;
import system.notification.Notification;
import static main.panelHome.homeAccess;
import static main.panelHome.homeUser;

public class panelLogin extends javax.swing.JPanel {

    public panelLogin() {
        initComponents();
        setOpaque(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        panelTransparent1 = new component.swing.panelTransparent();
        jLabel2 = new javax.swing.JLabel();
        fieldUsername = new component.swing.textFieldMain();
        jLabel4 = new javax.swing.JLabel();
        fieldPassword = new component.swing.passwordFieldMain();
        checkBoxCustom1 = new component.swing.checkBoxCustom();
        labelLupaPassword = new javax.swing.JLabel();
        buttonLogin = new component.swing.button();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icon/brand.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, 340));

        panelTransparent1.setBackground(new java.awt.Color(225, 225, 225));
        panelTransparent1.setAlpha(0.8F);
        panelTransparent1.setRound(25);
        panelTransparent1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel2.setText("Username");
        panelTransparent1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, -1, -1));

        fieldUsername.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        panelTransparent1.add(fieldUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 310, 60));

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel4.setText("Password");
        panelTransparent1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, -1, -1));

        fieldPassword.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        panelTransparent1.add(fieldPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, 310, 60));

        checkBoxCustom1.setText("Remember me");
        checkBoxCustom1.setIconTextGap(8);
        panelTransparent1.add(checkBoxCustom1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 210, 130, -1));

        labelLupaPassword.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        labelLupaPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelLupaPassword.setText("Lupa Password ?");
        labelLupaPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelLupaPasswordMouseClicked(evt);
            }
        });
        panelTransparent1.add(labelLupaPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 306, 290, 30));

        buttonLogin.setBackground(new java.awt.Color(0, 102, 255));
        buttonLogin.setForeground(new java.awt.Color(255, 255, 255));
        buttonLogin.setText("Log In");
        buttonLogin.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        buttonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoginActionPerformed(evt);
            }
        });
        panelTransparent1.add(buttonLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 250, 170, 50));

        add(panelTransparent1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 720, 370));
    }// </editor-fold>//GEN-END:initComponents

    private void buttonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLoginActionPerformed
        try{
            Statement getLogin = (Statement)connect.GetConnection().createStatement();
            ResultSet rest = getLogin.executeQuery("SELECT * FROM data_pengguna WHERE username = '" + fieldUsername.getText() + "'");
            if(rest.next()){
                if(fieldPassword.getText().equals(rest.getString("password"))){
                    
                    mainAccessPanel.removeAll();
                    mainAccessPanel.add(accessHome);
                    mainAccessPanel.repaint();
                    mainAccessPanel.revalidate();
                    
                    if(rest.getString("tipe_akun").equals("Administrator")){
                        homeUser.removeAll();
                        homeUser.add(homeAdministrator);
                        homeUser.repaint();
                        homeUser.revalidate();
                    } else {
                        homeUser.removeAll();
                        homeUser.add(homeKaryawan);
                        homeUser.repaint();
                        homeUser.revalidate();
                    }

                    main.panelHome.fieldIDPenggunaProfile.setText(rest.getString("id_pengguna"));
                    main.panelHome.fieldUsernameProfile.setText(rest.getString("username"));
                    main.panelHome.fieldPasswordProfile.setText(rest.getString("password"));
                    main.panelHome.fieldNamaProfile.setText(rest.getString("nama_pengguna"));
                    main.panelHome.fieldEmailProfile.setText(rest.getString("email"));
                    main.panelHome.fieldNoTelphoneProfile.setText(rest.getString("no_telphone"));
                    main.panelHome.textPaneAlamatProfile.setText(rest.getString("alamat"));   
                    main.panelHome.fieldTipeAkunProfile.setText(rest.getString("tipe_akun"));

                    Notification notif = new Notification(getNotify(), Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Anda Berhasil Login");
                    notif.showNotification();
                } else {
                    fieldPassword.requestFocus();
                    fieldPassword.setText("");
                    Notification notif = new Notification(getNotify(), Notification.Type.INFO, Notification.Location.TOP_CENTER, "Password yang anda masukkan salah !");
                    notif.showNotification();   
                }
            } else {
                fieldUsername.requestFocus();
                fieldUsername.setText("");
                Notification notif = new Notification(getNotify(), Notification.Type.INFO, Notification.Location.TOP_CENTER, "Username tidak ditemukan !");
                notif.showNotification();
            }
        } catch (SQLException ex) {
            Notification notif = new Notification(getNotify(), Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Koneksi Databases Error !");
            notif.showNotification();
        }
    }//GEN-LAST:event_buttonLoginActionPerformed

    private void labelLupaPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelLupaPasswordMouseClicked
        dialogLupaPassword message = new dialogLupaPassword(getNotify());
        message.showMessage("Lupa Password ?", "Verify Username and Email \n for Your User to change Password.");
    }//GEN-LAST:event_labelLupaPasswordMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static component.swing.button buttonLogin;
    private component.swing.checkBoxCustom checkBoxCustom1;
    public static component.swing.passwordFieldMain fieldPassword;
    public static component.swing.textFieldMain fieldUsername;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel labelLupaPassword;
    private component.swing.panelTransparent panelTransparent1;
    // End of variables declaration//GEN-END:variables
}
