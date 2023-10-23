package main.access;

import com.mysql.jdbc.Statement;
import component.model.table.tableCustom;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class panelManagementAkun extends javax.swing.JPanel {

    public panelManagementAkun() {
        initComponents();
        setOpaque(false);
        tableManagementAkun();
        tableCustom.apply(scrollPaneManagementAkun, tableCustom.TableType.MULTI_LINE);
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
            Statement statement = (Statement)service.connect.GetConnection().createStatement();
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
        buttonHapusManagementAkun.setEnabled(false);
    }
    
    private void searchManagementAkun(String key){
        DefaultTableModel isi = new DefaultTableModel();
        isi.addColumn("ID Pengguna");
        isi.addColumn("Username");
        isi.addColumn("Nama");
        isi.addColumn("Email");
        isi.addColumn("Tipe Akun");
        isi.addColumn("Alamat");
        
        tableManagementAkun.setModel(isi);
        try{
            Statement statement = (Statement)service.connect.GetConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM data_pengguna WHERE id_pengguna LIKE '%"+key+"%' OR username LIKE '%"+key+"%' OR nama_pengguna LIKE '%"+key+"%' OR email LIKE '%"+key+"%' OR tipe_akun LIKE '%"+key+"%' OR alamat LIKE '%"+key+"%';");
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
            System.out.print("Gagal menampilkan... ");
            JOptionPane.showMessageDialog(null,"Tidak bisa mencari data");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fieldIDPenggunaManagementAkun = new javax.swing.JTextField();
        panelRound1 = new component.swing.panelRound();
        panelRound15 = new component.swing.panelRound();
        fieldCariManagementAkun = new component.swing.textField();
        buttonHapusManagementAkun = new component.swing.button();
        scrollPaneManagementAkun = new javax.swing.JScrollPane();
        tableManagementAkun = new javax.swing.JTable();

        fieldIDPenggunaManagementAkun.setText("jTextField1");

        panelRound1.setBackground(new java.awt.Color(235, 235, 235));
        panelRound1.setShadowSize(new java.awt.Insets(5, 5, 5, 5));

        panelRound15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fieldCariManagementAkun.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        fieldCariManagementAkun.setLabelText("Cari");
        fieldCariManagementAkun.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldCariManagementAkunKeyReleased(evt);
            }
        });
        panelRound15.add(fieldCariManagementAkun, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 11, 240, 50));

        buttonHapusManagementAkun.setBackground(new java.awt.Color(204, 0, 0));
        buttonHapusManagementAkun.setForeground(new java.awt.Color(255, 255, 255));
        buttonHapusManagementAkun.setText("Hapus");
        buttonHapusManagementAkun.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonHapusManagementAkun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHapusManagementAkunActionPerformed(evt);
            }
        });

        tableManagementAkun.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableManagementAkun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableManagementAkunMouseClicked(evt);
            }
        });
        scrollPaneManagementAkun.setViewportView(tableManagementAkun);

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addComponent(panelRound15, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(280, 280, 280)
                .addComponent(buttonHapusManagementAkun, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(scrollPaneManagementAkun, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(panelRound15, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(buttonHapusManagementAkun, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(scrollPaneManagementAkun, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(panelRound1);
    }// </editor-fold>//GEN-END:initComponents

    private void fieldCariManagementAkunKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldCariManagementAkunKeyReleased
        String key = fieldCariManagementAkun.getText();
        System.out.println(key);

        if(key!=""){
            searchManagementAkun(key);
        }else{
            tableManagementAkun();
        }
    }//GEN-LAST:event_fieldCariManagementAkunKeyReleased

    private void buttonHapusManagementAkunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHapusManagementAkunActionPerformed
        try{
            Statement statement = (Statement)service.connect.GetConnection().createStatement();
            statement.executeUpdate("DELETE FROM data_pengguna WHERE id_pengguna = ('"+ fieldIDPenggunaManagementAkun.getText() +"');");

            fieldIDPenggunaManagementAkun.requestFocus();
            fieldIDPenggunaManagementAkun.getText();
        }
        catch(Exception t){
            JOptionPane.showMessageDialog(null, "Data gagal di hapus");
        }

        tableManagementAkun();
    }//GEN-LAST:event_buttonHapusManagementAkunActionPerformed

    private void tableManagementAkunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableManagementAkunMouseClicked
        fieldIDPenggunaManagementAkun.setText(tableManagementAkun.getValueAt(tableManagementAkun.getSelectedRow(),0) + "");
        
        buttonHapusManagementAkun.setEnabled(true);
    }//GEN-LAST:event_tableManagementAkunMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.swing.button buttonHapusManagementAkun;
    private component.swing.textField fieldCariManagementAkun;
    private javax.swing.JTextField fieldIDPenggunaManagementAkun;
    private component.swing.panelRound panelRound1;
    private component.swing.panelRound panelRound15;
    private javax.swing.JScrollPane scrollPaneManagementAkun;
    public static javax.swing.JTable tableManagementAkun;
    // End of variables declaration//GEN-END:variables
}
