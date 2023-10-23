package system;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import service.connect;
import static system.panelManagementAkun.tableManagementAkun;

public class panelTambahAkun extends javax.swing.JPanel {

    public panelTambahAkun() {
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
            Statement statement = (com.mysql.jdbc.Statement)service.connect.GetConnection().createStatement();
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

    private void SimpanTambahAkun(){
        String Username = fieldUsernameTambahAkun.getText();
        String Name = fieldNamaTambahAkun.getText();
        String Email = fieldEmailTambahAkun.getText();
        String Password = fieldPasswordTambahAkun.getText();
        String TypeAkun = (String)comboboxTambahAkun.getSelectedItem().toString();

        if(Username.isEmpty()){ 
            JOptionPane.showMessageDialog(null,"Username Tidak Boleh Kosong"); 
            fieldUsernameTambahAkun.requestFocus();  
        } else if(Name.isEmpty()){ 
            JOptionPane.showMessageDialog(null,"Nama Tidak Boleh Kosong"); 
            fieldNamaTambahAkun.requestFocus(); 
        }else if(Email.isEmpty()){ 
            JOptionPane.showMessageDialog(null,"Email Tidak Boleh Kosong"); 
            fieldEmailTambahAkun.requestFocus(); 
        } else if(Password.isEmpty()){ 
            JOptionPane.showMessageDialog(null,"Password Tidak Boleh Kosong"); 
            fieldPasswordTambahAkun.requestFocus(); 
        }else if(TypeAkun.isEmpty()){ 
            JOptionPane.showMessageDialog(null,"Tipe Akun Tidak Boleh Kosong"); 
            comboboxTambahAkun.requestFocus(); 
        } else{
            
            try{
                Statement statement = (Statement)connect.GetConnection().createStatement();
                ResultSet rest = statement.executeQuery("SELECT * FROM user WHERE Username='"+ Username +"';");
                if(rest.next()) {
                    JOptionPane.showMessageDialog(this, "Username="+ Username +" Already Exist");
                } else{
                    statement.executeUpdate("INSERT INTO user VALUES (NULL, '"+ Username +"','"+ Name +"', '"+ Password +"', '"+ Email +"', '"+ TypeAkun +"', NULL, NULL);");                   
                    fieldUsernameTambahAkun.setText("");
                    fieldNamaTambahAkun.setText("");
                    fieldEmailTambahAkun.setText("");
                    fieldPasswordTambahAkun.setText("");
                    
                    JOptionPane.showMessageDialog(null, "data berhasil disimpan");
                }
                
                statement.close ();
            } catch (Exception t){
                Logger.getLogger(panelTambahAkun.class.getName()).log(Level.SEVERE, null, t);
            }
        DataTableManagementAkun();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new component.swing.panelRound();
        jLabel1 = new javax.swing.JLabel();
        panel2 = new component.swing.panelRound();
        jLabel2 = new javax.swing.JLabel();
        panel3 = new component.swing.panelRound();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        buttonSimpanTambahAkun = new component.swing.button();
        fieldUsernameTambahAkun = new component.swing.textField();
        fieldNamaTambahAkun = new component.swing.textField();
        comboboxTambahAkun = new component.swing.combobox();
        jLabel3 = new javax.swing.JLabel();
        fieldEmailTambahAkun = new component.swing.textField();
        fieldPasswordTambahAkun = new component.swing.textField();
        button1 = new component.swing.button();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 45)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tambah Akun Karyawan");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 677, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
        );

        add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, -1, -1));

        panel2.setRound(25);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icon/profile-m.png"))); // NOI18N
        jLabel2.setText("Profile");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 140, 170, 190));

        panel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("Username");
        panel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        jLabel5.setText("Nama");
        panel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        jLabel7.setText("Password");
        panel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

        jLabel8.setText("Tipe Akun");
        panel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, -1, -1));

        buttonSimpanTambahAkun.setBackground(new java.awt.Color(204, 204, 204));
        buttonSimpanTambahAkun.setText("Simpan");
        buttonSimpanTambahAkun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSimpanTambahAkunActionPerformed(evt);
            }
        });
        panel3.add(buttonSimpanTambahAkun, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 380, 120, 50));

        fieldUsernameTambahAkun.setLabelText("");
        fieldUsernameTambahAkun.setOpaque(false);
        panel3.add(fieldUsernameTambahAkun, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 330, -1));

        fieldNamaTambahAkun.setLabelText("");
        fieldNamaTambahAkun.setOpaque(false);
        panel3.add(fieldNamaTambahAkun, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 330, -1));

        comboboxTambahAkun.setMaximumRowCount(2);
        comboboxTambahAkun.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administrator", "Karyawan" }));
        comboboxTambahAkun.setLabeText("");
        comboboxTambahAkun.setName(""); // NOI18N
        panel3.add(comboboxTambahAkun, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 330, 50));

        jLabel3.setText("Email");
        panel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        fieldEmailTambahAkun.setText("example@gmail.com");
        fieldEmailTambahAkun.setLabelText("");
        fieldEmailTambahAkun.setOpaque(false);
        panel3.add(fieldEmailTambahAkun, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 330, -1));

        fieldPasswordTambahAkun.setLabelText("");
        fieldPasswordTambahAkun.setOpaque(false);
        panel3.add(fieldPasswordTambahAkun, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 330, -1));

        add(panel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 520, 450));

        button1.setText("Change Avatar");
        add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 170, 50));
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSimpanTambahAkunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSimpanTambahAkunActionPerformed
        SimpanTambahAkun();
    }//GEN-LAST:event_buttonSimpanTambahAkunActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.swing.button button1;
    private component.swing.button buttonSimpanTambahAkun;
    private component.swing.combobox comboboxTambahAkun;
    private component.swing.textField fieldEmailTambahAkun;
    private component.swing.textField fieldNamaTambahAkun;
    private component.swing.textField fieldPasswordTambahAkun;
    private component.swing.textField fieldUsernameTambahAkun;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private component.swing.panelRound panel1;
    private component.swing.panelRound panel2;
    private component.swing.panelRound panel3;
    // End of variables declaration//GEN-END:variables
}
