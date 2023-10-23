package main.access;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import service.connect;
import static main.access.panelManagementAkun.tableManagementAkun;

public class panelTambahAkun extends javax.swing.JPanel {

    public panelTambahAkun() {
        initComponents();
    }
    
    public void tableManagementAkun(){
        DefaultTableModel isi = new DefaultTableModel();
        isi.addColumn("ID Pengguna");
        isi.addColumn("Username");
        isi.addColumn("Nama");
        isi.addColumn("Email");
        isi.addColumn("Tipe Akun");
        isi.addColumn("Alamat");
        
        tableManagementAkun.setModel(isi);
        try{
            com.mysql.jdbc.Statement statement = (com.mysql.jdbc.Statement)service.connect.GetConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM data_pengguna");
            while(result.next()){
                isi.addRow(new Object[]{
                    result.getString("id_pengguna"),
                    result.getString("username"),
                    result.getString("nama_pengguna"),
                    result.getString("email"),
                    result.getString("tipe_akun"),
                    result.getString("alamat")
                });
                tableManagementAkun.setModel(isi);
            }        
        }
        catch(Exception e){
            System.out.print("Gagal terhubung");
            JOptionPane.showMessageDialog(null,"Koneksi databases error");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fieldUsernameTambahAkun = new component.swing.textFieldMain();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fieldNamaTambahAkun = new component.swing.textFieldMain();
        jLabel3 = new javax.swing.JLabel();
        fieldEmailTambahAkun = new component.swing.textFieldMain();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        button1 = new component.swing.button();
        panelRound1 = new component.swing.panelRound();
        comboboxTambahAkun = new component.swing.comboBoxSuggestion();
        fieldPasswordTambahAkun = new component.swing.passwordFieldMain();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fieldUsernameTambahAkun.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        add(fieldUsernameTambahAkun, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 630, 60));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel1.setText("Username");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel2.setText("Nama");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, -1, -1));

        fieldNamaTambahAkun.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        add(fieldNamaTambahAkun, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 630, 60));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel3.setText("Email");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, -1, -1));

        fieldEmailTambahAkun.setText("example@gmail.com");
        fieldEmailTambahAkun.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        add(fieldEmailTambahAkun, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 630, 60));

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel4.setText("Password");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel5.setText("Tipe Akun");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, -1, -1));

        button1.setBackground(new java.awt.Color(51, 204, 0));
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setText("Simpan");
        button1.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(597, 450, 140, 50));

        panelRound1.setLayout(new java.awt.BorderLayout());

        comboboxTambahAkun.setBorder(null);
        comboboxTambahAkun.setEditable(false);
        comboboxTambahAkun.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administrator", "Karyawan" }));
        comboboxTambahAkun.setSelectedIndex(-1);
        panelRound1.add(comboboxTambahAkun, java.awt.BorderLayout.CENTER);

        add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, 630, 60));

        fieldPasswordTambahAkun.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        add(fieldPasswordTambahAkun, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 630, 60));
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        String Username = fieldUsernameTambahAkun.getText();
        String Nama = fieldNamaTambahAkun.getText();
        String Email = fieldEmailTambahAkun.getText();
        String Password = fieldPasswordTambahAkun.getText();
        String TipeAkun = (String)comboboxTambahAkun.getSelectedItem().toString();

        if(Username.isEmpty()){ 
            JOptionPane.showMessageDialog(null,"Username Tidak Boleh Kosong"); 
            fieldUsernameTambahAkun.requestFocus();  
        } else if(Nama.isEmpty()){ 
            JOptionPane.showMessageDialog(null,"Nama Tidak Boleh Kosong"); 
            fieldNamaTambahAkun.requestFocus(); 
        }else if(Email.isEmpty()){ 
            JOptionPane.showMessageDialog(null,"Email Tidak Boleh Kosong"); 
            fieldEmailTambahAkun.requestFocus(); 
        } else if(Password.isEmpty()){ 
            JOptionPane.showMessageDialog(null,"Password Tidak Boleh Kosong"); 
            fieldPasswordTambahAkun.requestFocus(); 
        }else if(TipeAkun.isEmpty()){ 
            JOptionPane.showMessageDialog(null,"Tipe Akun Tidak Boleh Kosong"); 
            comboboxTambahAkun.requestFocus(); 
        } else{
            
            try{
                Statement statement = (Statement)connect.GetConnection().createStatement();
                ResultSet rest = statement.executeQuery("SELECT * FROM data_pengguna WHERE username='"+ Username +"';");
                if(rest.next()) {
                    JOptionPane.showMessageDialog(this, "username="+ Username +" Already Exist");
                } else{
                    statement.executeUpdate("INSERT INTO data_pengguna VALUES (NULL, '"+ Username +"','"+ Password +"', '"+ Nama +"', '"+ Email +"', NULL, NULL, '"+ TipeAkun +"', NULL, NULL, NULL);");                   
                    fieldUsernameTambahAkun.setText("");
                    fieldNamaTambahAkun.setText("");
                    fieldEmailTambahAkun.setText("");
                    fieldPasswordTambahAkun.setText("");
                    
                    JOptionPane.showMessageDialog(null, "data berhasil disimpan");
                }
                
                statement.close ();
            } catch (Exception t){
                Logger.getLogger(system.panelTambahAkun.class.getName()).log(Level.SEVERE, null, t);
            }
            tableManagementAkun();
        }
    }//GEN-LAST:event_button1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.swing.button button1;
    private component.swing.comboBoxSuggestion comboboxTambahAkun;
    private component.swing.textFieldMain fieldEmailTambahAkun;
    private component.swing.textFieldMain fieldNamaTambahAkun;
    private component.swing.passwordFieldMain fieldPasswordTambahAkun;
    private component.swing.textFieldMain fieldUsernameTambahAkun;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private component.swing.panelRound panelRound1;
    // End of variables declaration//GEN-END:variables
}
