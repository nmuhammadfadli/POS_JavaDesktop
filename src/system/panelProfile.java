package system;

import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import service.connect;
import static system.panelManagementAkun.tableManagementAkun;

public class panelProfile extends javax.swing.JPanel {

    public panelProfile() {
        initComponents();
        setOpaque(false);
    }
    
    public void DataTableManagementAkun(){
        DefaultTableModel isi = new DefaultTableModel();
        isi.addColumn("ID User");
        isi.addColumn("Username");
        isi.addColumn("Nama");
        isi.addColumn("Email");
        isi.addColumn("Tipe Akun");
        
        tableManagementAkun.setModel(isi);
        
        isi.getDataVector().removeAllElements();
        isi.fireTableDataChanged();
        
        try{
            java.sql.Statement statement = (com.mysql.jdbc.Statement)service.connect.GetConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM user");
            while(result.next()){
                Object[] obj = new Object[5];
                    
                obj [0] = result.getString("IDUser");
                obj [1] = result.getString("Username");
                obj [2] = result.getString("Name");
                obj [3] = result.getString("Email");
                obj [4] = result.getString("TypeAkun");

                isi.addRow(obj);
            }
            result.close();
            statement.close();         
        }
        catch(Exception e){
            System.out.print("Gagal terhubung");
            JOptionPane.showMessageDialog(null,"Koneksi databases error");
        }
    }

    private void SimpanProfileAkun(){
        String Username = profileUsername.getText();
        String Name = profileName.getText();
        String Email = profileEmail.getText();
        String Password = profilePassword.getText();
        String TypeAkun = profileTipeAkun.getText();

        if(Username.isEmpty()){ 
            JOptionPane.showMessageDialog(null,"Username Tidak Boleh Kosong"); 
            profileUsername.requestFocus();
        } else if(Name.isEmpty()){ 
            JOptionPane.showMessageDialog(null,"Name Tidak Boleh Kosong"); 
            profileName.requestFocus();
        } else if(Email.isEmpty()){ 
            JOptionPane.showMessageDialog(null,"Email Tidak Boleh Kosong"); 
            profileEmail.requestFocus();
        } else if(Password.isEmpty()){ 
            JOptionPane.showMessageDialog(null,"Password Tidak Boleh Kosong"); 
            profilePassword.requestFocus();
        } else{
            
            try{
                Statement statement = (Statement)connect.GetConnection().createStatement();
                statement.executeUpdate("UPDATE user SET Username='"+ Username +"', Name='"+ Name +"', Password='"+ Password +"', Email='"+ Email +"', TypeAkun='"+ TypeAkun +"' WHERE Username='"+ Username +"';");                   
//                if(.next){
//                    
//                }
                
                DataTableManagementAkun();
                main.gbrandapplication.homeLabelUsername.setText(Username);
                statement.close ();
            } catch (Exception t){
                JOptionPane.showMessageDialog(null, "data gagal disimpan");
            }
        
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        profile = new component.swing.panelRound();
        labelProfile = new javax.swing.JLabel();
        profileUsername = new component.swing.textField();
        profileName = new component.swing.textField();
        profileEmail = new component.swing.textField();
        profilePassword = new component.swing.passwordField();
        profileRePassword = new component.swing.passwordField();
        profileTipeAkun = new component.swing.textField();
        profileSimpan = new component.swing.button();

        profile.setBackground(new java.awt.Color(204, 204, 204));

        labelProfile.setFont(new java.awt.Font("Dialog", 1, 45)); // NOI18N
        labelProfile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelProfile.setText("Profile");

        javax.swing.GroupLayout profileLayout = new javax.swing.GroupLayout(profile);
        profile.setLayout(profileLayout);
        profileLayout.setHorizontalGroup(
            profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelProfile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 677, Short.MAX_VALUE)
        );
        profileLayout.setVerticalGroup(
            profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profileLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelProfile, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                .addContainerGap())
        );

        profileUsername.setLabelText("Username");
        profileUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileUsernameActionPerformed(evt);
            }
        });

        profileName.setLabelText("Name");
        profileName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileNameActionPerformed(evt);
            }
        });

        profileEmail.setLabelText("Email");
        profileEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileEmailActionPerformed(evt);
            }
        });

        profilePassword.setLabelText("Password");
        profilePassword.setOpaque(false);
        profilePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profilePasswordActionPerformed(evt);
            }
        });

        profileRePassword.setLabelText("Re Password");
        profileRePassword.setOpaque(false);
        profileRePassword.setShowAndHide(true);
        profileRePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileRePasswordActionPerformed(evt);
            }
        });

        profileTipeAkun.setEditable(false);
        profileTipeAkun.setLabelText("Tpie Akun");
        profileTipeAkun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileTipeAkunActionPerformed(evt);
            }
        });

        profileSimpan.setBackground(new java.awt.Color(0, 255, 0));
        profileSimpan.setForeground(new java.awt.Color(255, 255, 255));
        profileSimpan.setText("Simpan Profile");
        profileSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileSimpanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(profile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(profileUsername, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(profileName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(profileEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(profileTipeAkun, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(profilePassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(profileRePassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(profileSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(profile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(profileUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(profileName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(profileEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(profilePassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(profileRePassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(profileTipeAkun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(profileSimpan, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void profileUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_profileUsernameActionPerformed

    private void profileNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_profileNameActionPerformed

    private void profileEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_profileEmailActionPerformed

    private void profilePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profilePasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_profilePasswordActionPerformed

    private void profileRePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileRePasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_profileRePasswordActionPerformed

    private void profileTipeAkunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileTipeAkunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_profileTipeAkunActionPerformed

    private void profileSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileSimpanActionPerformed
        SimpanProfileAkun();
    }//GEN-LAST:event_profileSimpanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelProfile;
    private component.swing.panelRound profile;
    public static component.swing.textField profileEmail;
    public static component.swing.textField profileName;
    public static component.swing.passwordField profilePassword;
    public static component.swing.passwordField profileRePassword;
    private component.swing.button profileSimpan;
    public static component.swing.textField profileTipeAkun;
    public static component.swing.textField profileUsername;
    // End of variables declaration//GEN-END:variables
}
